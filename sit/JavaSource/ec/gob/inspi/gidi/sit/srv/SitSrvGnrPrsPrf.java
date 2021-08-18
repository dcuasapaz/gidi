package ec.gob.inspi.gidi.sit.srv;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.inspi.gidi.sit.cmm.Default;
import ec.gob.inspi.gidi.sit.cmm.SrvDb;
import ec.gob.inspi.gidi.sit.ent.ScrTblPrsRol;
import ec.gob.inspi.gidi.sit.ent.SitTblGnr;
import ec.gob.inspi.gidi.sit.ent.SitTblGnrPrsPrf;

@Stateless
public class SitSrvGnrPrsPrf extends SrvDb<SitTblGnrPrsPrf> {

	protected Default dfl;

	public SitSrvGnrPrsPrf() {
		super(SitTblGnrPrsPrf.class, SitSrvGnrPrsPrf.class);
		dfl = new Default();
	}

	public boolean sve(ScrTblPrsRol prsPrf, SitTblGnr gnr) {
		try {
			SitTblGnrPrsPrf gnrPrsPrf = new SitTblGnrPrsPrf();
			gnrPrsPrf.setScrTblPrsRol(prsPrf);
			gnrPrsPrf.setSitTblGnr(gnr);
			this.insert(gnrPrsPrf);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<SitTblGnrPrsPrf> lstGnrDtl(SitTblGnr gnr) {
		try {
			String sql = "SELECT gnr FROM SitTblGnrPrsPrf gnr WHERE gnr.sitTblGnr = :param";
			Query q = em.createQuery(sql);
			q.setParameter("param", gnr);
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
