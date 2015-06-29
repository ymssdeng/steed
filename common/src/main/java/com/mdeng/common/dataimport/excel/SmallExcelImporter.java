package com.mdeng.common.dataimport.excel;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.base.Function;
import com.mdeng.common.dal.IEntity;
import com.mdeng.common.dataimport.AbstractImporter;
import com.mdeng.common.dataimport.excel.LargeExcelImporter.Consumer;
import com.mdeng.common.dataimport.excel.LargeExcelImporter.Scaner;

/**
 * 处理较小的Excel
 * 
 * @author Administrator
 *
 */
public class SmallExcelImporter extends AbstractImporter {

  private static final int MAX_QUEUE_SIZE = 1000;
  private static final int MAX_THREAD_SIZE = 5;
  private BlockingQueue<Row> queue;
  private ExecutorService es;
  private Function<Row, ? extends IEntity> function;
  private CountDownLatch cdl;

  public SmallExcelImporter(String path, Function<Row, ? extends IEntity> function) {
    super(path);
    queue = new ArrayBlockingQueue<Row>(MAX_QUEUE_SIZE);
    es = Executors.newFixedThreadPool(MAX_THREAD_SIZE);
    this.function = function;
    cdl = new CountDownLatch(files.length);
  }

  public void exec() {
    int count = 0;
    for (File file : files) {
      es.submit(new Scaner(file));
      count++;
      es.submit(new Consumer());
      count++;
    }

    for (int i = 0; i < MAX_THREAD_SIZE - count; i++) {
      es.submit(new Consumer());
    }
  }

  public void waitForComplete() {
    try {
      es.shutdown();
      es.awaitTermination(5, TimeUnit.DAYS);
    } catch (InterruptedException e) {}
  }

  class Scaner implements Runnable {
    private final File file;

    public Scaner(File file) {
      this.file = file;
    }

    @Override
    public void run() {
      try {
        XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));
        for (Row row : wb.getSheetAt(0)) {
          queue.put(row);
        }
        cdl.countDown();
        logger.info("{} scaned.", file.getName());
      } catch (Exception e) {
        logger.error("{} scaned failed: {}", file.getName(), e.getMessage());
      }
    }
  }

  class Consumer implements Runnable {
    @Override
    public void run() {
      try {
        while (cdl.getCount() > 0 || queue.size() > 0) {
          Row row = queue.poll(5, TimeUnit.MILLISECONDS);
          if (row != null) function.apply(row);
        }
      } catch (InterruptedException e) {}
    }
  }
}