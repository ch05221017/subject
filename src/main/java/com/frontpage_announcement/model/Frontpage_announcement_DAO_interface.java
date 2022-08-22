package com.frontpage_announcement.model;

import java.util.*;

public interface Frontpage_announcement_DAO_interface {
//          public void insert(Item_category_VO Item_category_VO);
//          public void update(Item_category_VO Item_category_VO);
//          public void delete(Integer item_category_number);
          public Frontpage_announcement_VO findByPrimaryKey(Integer frontpage_announcement_serial_number);
          public List<Frontpage_announcement_VO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
          public List<Frontpage_announcement_VO> getAll(Map<String, String[]> map); 
}
