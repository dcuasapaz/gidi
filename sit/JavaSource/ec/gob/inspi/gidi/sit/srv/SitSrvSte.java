package ec.gob.inspi.gidi.sit.srv;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.inspi.gidi.sit.cmm.SrvDb;
import ec.gob.inspi.gidi.sit.ent.SitTblSte;



@Stateless
public class SitSrvSte extends SrvDb<SitTblSte> {
	public SitSrvSte() {
		super(SitTblSte.class, SitSrvSte.class);
	}

	public List<SitTblSte> lstSte(int IPrjId) {
		try {
			String sql = "SELECT ste FROM SitTblSte ste WHERE ste.iPrjId = :param";
			Query q = em.createQuery(sql);
			q.setParameter("param", IPrjId);
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
