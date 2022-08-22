package subject.dao;

import java.util.List;

import subject.vo.FroannVO;

public interface FroannDAO_interface {
	public void insert(FroannVO froannVO);
    public void update(FroannVO froannVO);
    public void delete(Integer froannno);
    public FroannVO findByPrimaryKey(Integer froannno);
    public List<FroannVO> getAll();
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<FroannVO> getAll(Map<String, String[]> map); 
}
