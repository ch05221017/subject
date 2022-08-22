package com.product_seller.model;

import java.util.*;

public interface Product_seller_DAO_interface {
//          public void insert(Item_VO empVO);
//          public void update(Item_VO empVO);
//          public void delete(Integer item_category_number);
          public Product_seller_VO findByPrimaryKey(Integer item_serial_number);
          public List<Product_seller_VO> getAll();
//          //萬用複合查詢(傳入參數型態Map)(回傳 List)
//          public List<Item_VO> getAll(Map<String, String[]> map); 
}
