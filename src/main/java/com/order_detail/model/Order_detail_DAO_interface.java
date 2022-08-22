package com.order_detail.model;

import java.util.*;

public interface Order_detail_DAO_interface {
//          public void insert(Item_category_VO Item_category_VO);
//          public void update(Item_category_VO Item_category_VO);
//          public void delete(Integer item_category_number);
          public Order_detail_VO findByPrimaryKey(Integer order_detail_serial_number);
          public List<Order_detail_VO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
          public List<Order_detail_VO> getAll(Map<String, String[]> map); 
}
