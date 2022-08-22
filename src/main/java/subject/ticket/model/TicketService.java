package subject.ticket.model;

import java.util.List;

import subject.blacklist.model.BlacklistDAO;
import subject.blacklist.model.BlacklistVO;

public class TicketService {
	
	private TicketDAO_interface dao;
	
	public TicketService() {
		dao = new TicketDAO();
	}

	public List<TicketVO> getAll() {
		return dao.getAll();
	}
}
