package ec.gob.inspi.gidi.sit.srv;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.inspi.gidi.sit.cmm.Default;
import ec.gob.inspi.gidi.sit.cmm.SrvDb;
import ec.gob.inspi.gidi.sit.ent.SitTblGnr;
import ec.gob.inspi.gidi.sit.ent.SitTblGnrDtl;

@Stateless
public class SitSrvGnrDtl extends SrvDb<SitTblGnrDtl> {

	protected Default dfl;

	public SitSrvGnrDtl() {
		super(SitTblGnrDtl.class, SitSrvGnrDtl.class);
		dfl = new Default();
	}

	public boolean sve(SitTblGnrDtl gnrDtl, SitTblGnr gnr) {
		try {
			gnrDtl.setDGnrDtlDteRgs(dfl.dCurrentDate());
			gnrDtl.setSGnrDtlTmeRgs(dfl.currentTime());
			gnrDtl.setSitTblGnr(gnr);
			this.insert(gnrDtl);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<SitTblGnrDtl> lstGnrDtl(SitTblGnr gnr, int ITpeDtl) {
		try {
			String sql = "SELECT gnr FROM SitTblGnrDtl gnr WHERE gnr.sitTblGnr = :param1 AND gnr.iTpeDtl = :param2";
			Query q = em.createQuery(sql);
			q.setParameter("param1", gnr);
			q.setParameter("param2", ITpeDtl);
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
