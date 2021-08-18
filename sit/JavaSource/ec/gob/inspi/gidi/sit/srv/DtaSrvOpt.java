package ec.gob.inspi.gidi.sit.srv;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.inspi.gidi.sit.cmm.Log;
import ec.gob.inspi.gidi.sit.cmm.SrvDb;
import ec.gob.inspi.gidi.sit.ent.DtaTblOpt;

@Stateless
public class DtaSrvOpt extends SrvDb<DtaTblOpt> {
	protected Log log;

	public DtaSrvOpt() {
		super(DtaTblOpt.class, DtaSrvOpt.class);
		log = new Log();
	}

	public List<DtaTblOpt> lstOpt(int IoptId) {
		try {
			String sql = "SELECT opt FROM DtaTblOpt opt WHERE opt.iOptTpe = :param ORDER BY iOptCtg ASC";
			Query q = em.createQuery(sql);
			q.setParameter("param", IoptId);
			return q.getResultList();
		} catch (Exception e) {
			this.log.impSrv(1, DtaTblOpt.class.getSimpleName(), List.class.getSimpleName(),
					DtaTblOpt.class.getSimpleName(), e.getMessage());
			return null;
		}

	}

}
