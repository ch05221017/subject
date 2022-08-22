package com.advertisement_show.model;

import java.util.*;

public interface Advertisement_show_DAO_interface {
//          public void insert(Item_category_VO Item_category_VO);
//          public void update(Item_category_VO Item_category_VO);
//          public void delete(Integer item_category_number);
          public Advertisement_show_VO findByPrimaryKey(Integer advertisement_serial_number);
          public List<Advertisement_show_VO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
          public List<Advertisement_show_VO> getAll(Map<String, String[]> map); 
}
