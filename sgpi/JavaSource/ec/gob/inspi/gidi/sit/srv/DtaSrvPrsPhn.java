package ec.gob.inspi.gidi.sit.srv;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.inspi.gidi.sit.cmm.Log;
import ec.gob.inspi.gidi.sit.cmm.SrvDb;
import ec.gob.inspi.gidi.sit.ent.DtaTblPr;
import ec.gob.inspi.gidi.sit.ent.DtaTblPrsPhn;

@Stateless
public class DtaSrvPrsPhn extends SrvDb<DtaTblPrsPhn> {

	protected Log log;

	public DtaSrvPrsPhn() {
		super(DtaTblPrsPhn.class, DtaSrvPrsPhn.class);
		log = new Log();

	}

	public List<DtaTblPrsPhn> lstPrsPhn(int IPrsId) {
		try {
			String sql = "SELECT prsPhn FROM DtaTblPrsPhn prsPhn WHERE prsPhn.iPrsId = :param ";
			Query q = em.createQuery(sql);
			q.setParameter("param", IPrsId);
			return q.getResultList();
		} catch (Exception e) {
			this.log.impSrv(1, DtaSrvPrsApn.class.getSimpleName(), List.class.getSimpleName(),
					DtaSrvPrsPhn.class.getSimpleName(), e.getMessage());
			return null;
		}
	}

	public List<DtaTblPrsPhn> lstPrsPhn(DtaTblPr prs) {
		try {
			String sql = "SELECT prsPhn FROM DtaTblPrsPhn prsPhn WHERE prsPhn.iPrsId = :param ";
			Query q = em.createQuery(sql);
			q.setParameter("param", prs.getIPrsId());
			return q.getResultList();
		} catch (Exception e) {
			this.log.impSrv(1, DtaSrvPrsApn.class.getSimpleName(), List.class.getSimpleName(),
					DtaSrvPrsPhn.class.getSimpleName(), e.getMessage());
			return null;
		}
	}

}
