package com.item_category.model;

import java.util.*;

public interface Item_category_DAO_interface {
//          public void insert(Item_category_VO Item_category_VO);
//          public void update(Item_category_VO Item_category_VO);
//          public void delete(Integer item_category_number);
          public Item_category_VO findByPrimaryKey(Integer item_category_number);
          public List<Item_category_VO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
          public List<Item_category_VO> getAll(Map<String, String[]> map); 
}
