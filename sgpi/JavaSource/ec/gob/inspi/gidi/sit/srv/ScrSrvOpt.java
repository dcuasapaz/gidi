package ec.gob.inspi.gidi.sit.srv;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.inspi.gidi.sit.cmm.Log;
import ec.gob.inspi.gidi.sit.cmm.SrvDb;
import ec.gob.inspi.gidi.sit.ent.ScrTblOpt;

@Stateless
public class ScrSrvOpt extends SrvDb<ScrTblOpt> {

	protected Log log;

	public ScrSrvOpt() {
		super(ScrTblOpt.class, ScrSrvOpt.class);
		log = new Log();
	}

	public List<ScrTblOpt> lstOpt(int IoptId) {
		try {
			String sql = "SELECT opt FROM ScrTblOpt opt WHERE opt.iOptTpe = :param AND opt.bOptStt = TRUE ORDER BY iOptCtg ASC";
			Query q = em.createQuery(sql);
			q.setParameter("param", IoptId);
			return q.getResultList();
		} catch (Exception e) {
			this.log.impSrv(1, ScrSrvOpt.class.getSimpleName(), List.class.getSimpleName(),
					ScrTblOpt.class.getSimpleName(), e.getMessage());
			return null;
		}

	}

}
