package com.mycart.model;

import java.util.*;

public interface Mycart_DAO_interface {
          public void insert(Mycart_VO Mycart_VO);
//          public void update(Item_category_VO Item_category_VO);
          public void delete(Integer cart_serial_number);
          public Mycart_VO findByPrimaryKey(Integer cart_serial_number);
          public List<Mycart_VO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
          public List<Mycart_VO> getAll(Map<String, String[]> map); 
}
