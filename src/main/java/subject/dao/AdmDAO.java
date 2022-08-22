package subject.dao;

import subject.vo.AdmBean;

public interface AdmDAO {
	public abstract AdmBean select(String admname);
	
	public abstract boolean update(String admname, String password);

	boolean update(String admname, String password, Integer admid);

	
}