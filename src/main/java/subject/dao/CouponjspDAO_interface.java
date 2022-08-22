package subject.dao;

import java.util.List;

import subject.vo.CouponjspVO;

public interface CouponjspDAO_interface {
	public void insert(CouponjspVO couponjspVO);
    public void update(CouponjspVO couponjspVO);
    public void delete(Integer couponserialnumber);
    public CouponjspVO findByPrimaryKey(Integer couponserialnumber);
    public List<CouponjspVO> getAll();
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<FroannVO> getAll(Map<String, String[]> map); 
}
