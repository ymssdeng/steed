package com.mdeng.common.dataimport;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;
import com.mdeng.common.dal.IEntity;
import com.mdeng.common.utils.Charsets;

public abstract class Importable<T extends IEntity> {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * 预处理
   * 
   * @return
   */
  public boolean preprocess() {
    try {
      Field[] fields = this.getClass().getDeclaredFields();
      for (Field field : fields) {
        String fun = field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
        String getterFunName = "get" + fun;
        String setterFunName = "set" + fun;
        Method getter = this.getClass().getDeclaredMethod(getterFunName);

        Class<?> clazz = field.getType();
        // 支持String和String数组
        if (clazz.equals(String.class)) {
          String str = (String) getter.invoke(this);
          str = processItem(str);
          Method setter = this.getClass().getDeclaredMethod(setterFunName, String.class);
          setter.invoke(this, str);
        } else if (clazz.equals(String[].class)) {
          String[] strs = (String[]) getter.invoke(this);
          strs = processItem(strs);
          Method setter = this.getClass().getDeclaredMethod(setterFunName, String[].class);
          setter.invoke(this, (Object) strs);
        }
      }
    } catch (Exception e) {
      logger.error("failed at preprocess: {}", e.getMessage());
      return false;
    }
    return true;
  }

  protected String processItem(String str) {
    str = StringUtils.defaultString(str);
    try {
      str = Charsets.remove4BytesUTF8Char(str);
      str = Charsets.removeHtml(str);
      str = StringUtils.trim(str);
      str = removeInvalids(str);
    } catch (Exception e) {
      logger.error("failed to process string: {}, msg: {}", str, e.getMessage());
    }

    return str;
  }

  protected String[] processItem(String[] arr) {
    List<String> ret = Lists.newArrayList();

    try {
      for (int i = 0; i < arr.length; i++) {
        arr[i] = StringUtils.defaultString(arr[i]);

        arr[i] = Charsets.remove4BytesUTF8Char(arr[i]);
        arr[i] = Charsets.removeHtml(arr[i]);
        arr[i] = StringUtils.trim(arr[i]);
        arr[i] = removeInvalids(arr[i]);

        if (arr[i].length() > 0) ret.add(arr[i]);
      }
    } catch (Exception e) {
      logger.error("failed to process array: {}, msg: {}", arr, e.getMessage());
    }

    return ret.toArray(new String[0]);
  }

  /**
   * 格式检查
   * 
   * @return
   */
  public boolean selfCheck() {
    return preprocess();
  }

  /**
   * 转换成对应的数据库实体
   * 
   * @return
   */
  public abstract T toEntity() throws Exception;

  /**
   * 自定义非法字符
   * 
   * @return
   */
  public abstract String[] regexOfInvalids();

  protected String removeInvalids(String str) {
    String[] regex = regexOfInvalids();
    if (regex != null) {
      for (String invalid : regex) {
        str = str.replaceAll(invalid, "");
      }
    }

    return str;
  }
}