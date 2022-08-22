package subject.service;

import java.util.List;

import subject.dao.FroannDAO;
import subject.dao.FroannDAO_interface;
import subject.vo.FroannVO;

public class FroannService {
	private FroannDAO_interface dao;

	public FroannService() {
		dao = new FroannDAO();
	}

	public FroannVO addFroann(Integer admno, String froanndesc, java.sql.Date froannsdate,
			java.sql.Date froannedate, Integer froannstatus) {

		FroannVO froannVO = new FroannVO();

		froannVO.setAdmno(admno);
		froannVO.setFroanndesc(froanndesc);
		froannVO.setFroannsdate(froannsdate);
		froannVO.setFroannedate(froannedate);
		froannVO.setFroannstatus(froannstatus);	
		dao.insert(froannVO);

		return froannVO;
	}

	public FroannVO updateFroann(Integer froannno, Integer admno, String froanndesc,
			java.sql.Date froannsdate, java.sql.Date froannedate, Integer froannstatus) {

		FroannVO froannVO = new FroannVO();

		froannVO.setFroannno(froannno);
		froannVO.setAdmno(admno);
		froannVO.setFroanndesc(froanndesc);
		froannVO.setFroannsdate(froannsdate);
		froannVO.setFroannedate(froannedate);
		froannVO.setFroannstatus(froannstatus);		
		dao.update(froannVO);

		return froannVO;
	}

	public void deleteFroann(Integer froannno) {
		dao.delete(froannno);
	}

	public FroannVO getOneFroann(Integer froannno) {
		return dao.findByPrimaryKey(froannno);
	}

	public List<FroannVO> getAll() {
		return dao.getAll();
	}
}
