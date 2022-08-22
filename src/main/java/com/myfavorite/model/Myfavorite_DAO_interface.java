package com.myfavorite.model;

import java.util.*;

public interface Myfavorite_DAO_interface {
          public void insert(Myfavorite_VO Myfavorite_VO);
//          public void update(Item_category_VO Item_category_VO);
          public void delete(Integer my_favorite_number);
          public Myfavorite_VO findByPrimaryKey(Integer my_favorite_number);
          public List<Myfavorite_VO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
          public List<Myfavorite_VO> getAll(Map<String, String[]> map); 
}
