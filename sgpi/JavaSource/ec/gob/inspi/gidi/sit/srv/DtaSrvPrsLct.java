package ec.gob.inspi.gidi.sit.srv;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.inspi.gidi.sit.cmm.SrvDb;
import ec.gob.inspi.gidi.sit.ent.DtaTblPr;
import ec.gob.inspi.gidi.sit.ent.DtaTblPrsLct;

@Stateless
public class DtaSrvPrsLct extends SrvDb<DtaTblPrsLct> {

	public DtaSrvPrsLct() {
		super(DtaTblPrsLct.class, DtaSrvPrsLct.class);

	}

	public List<DtaTblPrsLct> lstPrsUbc(DtaTblPr prs) {
		try {
			String sql = "SELECT prsLct FROM DtaTblPrsLct prsLct WHERE prsLct.iPrsId = :param ";
			Query q = em.createQuery(sql);
			q.setParameter("param", prs.getIPrsId());
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
