package ec.gob.inspi.gidi.sit.srv;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.inspi.gidi.sit.cmm.SrvDb;
import ec.gob.inspi.gidi.sit.ent.SitTblOpt;

@Stateless
public class SitSrvOPt extends SrvDb<SitTblOpt> {
	public SitSrvOPt() {
		super(SitTblOpt.class, SitSrvOPt.class);
	}

	public List<SitTblOpt> lstOpt(int IFhtId) {
		try {
			String sql = "SELECT opt FROM SitTblOpt opt WHERE opt.iOptFth = :param";
			Query q = em.createQuery(sql);
			q.setParameter("param", IFhtId);
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
