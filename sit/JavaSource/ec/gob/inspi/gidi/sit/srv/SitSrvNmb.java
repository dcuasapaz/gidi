package ec.gob.inspi.gidi.sit.srv;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.inspi.gidi.sit.cmm.SrvDb;
import ec.gob.inspi.gidi.sit.ent.SitTblNmb;
import ec.gob.inspi.gidi.sit.ent.SitTblSte;


@Stateless
public class SitSrvNmb extends SrvDb<SitTblNmb> {

	public SitSrvNmb() {
		super(SitTblNmb.class, SitSrvNmb.class);

	}

	public List<SitTblNmb> lstNmb(SitTblSte ste) {
		try {
			String sql = "SELECT nmb FROM SitTblNmb nmb WHERE nmb.sitTblSte = :param";
			Query q = em.createQuery(sql);
			q.setParameter("param", ste);
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
