package ec.gob.inspi.gidi.sit.srv;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.inspi.gidi.sit.cmm.Log;
import ec.gob.inspi.gidi.sit.cmm.SrvDb;
import ec.gob.inspi.gidi.sit.ent.InsTblOpt;

@Stateless
public class InsSrvOpt extends SrvDb<InsTblOpt> {
	protected Log log;

	public InsSrvOpt() {
		super(InsTblOpt.class, InsSrvOpt.class);
		log = new Log();
	}

	public List<InsTblOpt> lstOpt(int IoptId) {
		try {
			String sql = "SELECT opt FROM InsTblOpt opt WHERE opt.iOptTpe = :param ORDER BY iOptCtg ASC";
			Query q = em.createQuery(sql);
			q.setParameter("param", IoptId);
			return q.getResultList();
		} catch (Exception e) {
			this.log.impSrv(1, InsTblOpt.class.getSimpleName(), List.class.getSimpleName(),
					InsTblOpt.class.getSimpleName(), e.getMessage());
			return null;
		}

	}

}
