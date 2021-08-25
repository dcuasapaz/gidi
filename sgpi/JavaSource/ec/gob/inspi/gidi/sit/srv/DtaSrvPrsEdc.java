package ec.gob.inspi.gidi.sit.srv;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.inspi.gidi.sit.cmm.SrvDb;
import ec.gob.inspi.gidi.sit.ent.DtaTblPr;
import ec.gob.inspi.gidi.sit.ent.DtaTblPrsEdc;

@Stateless
public class DtaSrvPrsEdc extends SrvDb<DtaTblPrsEdc> {

	public DtaSrvPrsEdc() {
		super(DtaTblPrsEdc.class, DtaSrvPrsEdc.class);

	}

	public List<DtaTblPrsEdc> lstPrsEdc(int IPrsId) {
		try {
			String sql = "SELECT prsEdc FROM DtaTblPrsEdc prsEdc WHERE prsEdc.iPrsId = :param ORDER BY 1";
			Query q = em.createQuery(sql);
			q.setParameter("param", IPrsId);
			return q.getResultList();
		} catch (Exception e) {
			LOG.debug(1 + "|" + DtaSrvPrsEdc.class.getSimpleName() + "|" + List.class.getSimpleName() + "|"
					+ DtaTblPrsEdc.class.getSimpleName() + " | " + e.getMessage());
			return null;
		}
	}

	public DtaTblPrsEdc sngPrsEdc(DtaTblPr prs) {
		try {
			String sql = "SELECT prsEdc FROM DtaTblPrsEdc prsEdc WHERE prsEdc.iPrsId = :param ORDER BY 1 DESC";
			Query q = em.createQuery(sql);
			q.setParameter("param", prs.getIPrsId()).setMaxResults(1);
			return (DtaTblPrsEdc) q.getSingleResult();
		} catch (Exception e) {
			LOG.debug(2 + "|" + DtaSrvPrsEdc.class.getSimpleName() + "|" + List.class.getSimpleName() + "|"
					+ DtaTblPrsEdc.class.getSimpleName() + " | " + e.getMessage());
			return null;
		}
	}

}
