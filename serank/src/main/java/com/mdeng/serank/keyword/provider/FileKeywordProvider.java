package com.mdeng.serank.keyword.provider;

import org.springframework.stereotype.Component;

import com.mdeng.serank.keyword.KeywordRank;

@Component
public class FileKeywordProvider implements KeywordProvider {
  private String[] keywords={"农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格", // 50
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格", // 50
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格", // 50
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格", // 50
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格",
                             "农作物买卖市场",
                             "有机农作物批发",
                             "农作物价格", // 50
                             };
  private int index=0;
  @Override
  public synchronized boolean hasNext() {
    // TODO Auto-generated method stub
    return index<keywords.length;
  }

  @Override
  public synchronized KeywordRank nextKeyword() {
    // TODO Auto-generated method stub
    KeywordRank kr = new KeywordRank();
    kr.setKeyword(keywords[index++]);
    return kr;
  }

}
