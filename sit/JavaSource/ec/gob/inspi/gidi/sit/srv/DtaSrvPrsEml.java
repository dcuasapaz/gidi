package ec.gob.inspi.gidi.sit.srv;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.inspi.gidi.sit.cmm.Log;
import ec.gob.inspi.gidi.sit.cmm.SrvDb;
import ec.gob.inspi.gidi.sit.ent.DtaTblPr;
import ec.gob.inspi.gidi.sit.ent.DtaTblPrsEml;


@Stateless
public class DtaSrvPrsEml extends SrvDb<DtaTblPrsEml> {
	protected Log log;

	public DtaSrvPrsEml() {
		super(DtaTblPrsEml.class, DtaSrvPrsEml.class);
		log = new Log();
	}
	
	public List<DtaTblPrsEml> lstPrsEml(int IPrsId) {
		try {
			String sql = "SELECT prsEml FROM DtaTblPrsEml prsEml WHERE prsEml.iPrsId = :param ";
			Query q = em.createQuery(sql);
			q.setParameter("param", IPrsId);
			return q.getResultList();
		} catch (Exception e) {
			this.log.impSrv(1, DtaSrvPrsApn.class.getSimpleName(), List.class.getSimpleName(),
					DtaSrvPrsEml.class.getSimpleName(), e.getMessage());
			return null;
		}
	}
	
	public List<DtaTblPrsEml> lstPrsEml(DtaTblPr prs) {
		try {
			String sql = "SELECT prsEml FROM DtaTblPrsEml prsEml WHERE prsEml.iPrsId = :param ";
			Query q = em.createQuery(sql);
			q.setParameter("param", prs.getIPrsId());
			return q.getResultList();
		} catch (Exception e) {
			this.log.impSrv(1, DtaSrvPrsApn.class.getSimpleName(), List.class.getSimpleName(),
					DtaSrvPrsEml.class.getSimpleName(), e.getMessage());
			return null;
		}
	}

}
