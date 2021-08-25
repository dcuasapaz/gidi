package ec.gob.inspi.gidi.sit.srv;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.inspi.gidi.sit.cmm.Default;
import ec.gob.inspi.gidi.sit.cmm.SrvDb;
import ec.gob.inspi.gidi.sit.ent.ScrTblPrsRol;
import ec.gob.inspi.gidi.sit.ent.SitTblGnr;
import ec.gob.inspi.gidi.sit.ent.SitTblNmb;

@Stateless
public class SitSrvGnr extends SrvDb<SitTblGnr> {

	protected Default dfl;

	public SitSrvGnr() {
		super(SitTblGnr.class, SitSrvGnr.class);
		dfl = new Default();
	}

	public boolean sve(SitTblGnr gnr, SitTblNmb nmb, int IDteSetYr, int IDteSetMth, int IDteSetDay, int IDteClcYr,
			int IDteClcMth, int IDteClcDay, boolean BGnrTrpRcv, boolean BGnrTrpSup, boolean BGnrEgs, boolean BGnrLrs,
			boolean BGnrAdl, int ITpeId) {
		try {
			gnr.setIEpiId(-99);
			gnr.setSitTblNmb(nmb);
			gnr.setIGnrDteSetYr(IDteSetYr);
			gnr.setIGnrDteSetMth(IDteSetMth);
			gnr.setIGnrDteSetDay(IDteSetDay);
			gnr.setIGnrDteClcYr(IDteClcYr);
			gnr.setIGnrDteClcMth(IDteClcMth);
			gnr.setIGnrDteClcDay(IDteClcDay);
			gnr.setBGnrTrpRcv(BGnrTrpRcv);
			gnr.setBGnrTrpSup(BGnrTrpSup);
			gnr.setBGnrEgs(BGnrEgs);
			gnr.setBGnrLrs(BGnrLrs);
			gnr.setBGnrAdl(BGnrAdl);
			gnr.setITpeId(ITpeId);
			gnr.setBGnrStt(true);
			this.insert(gnr);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean sve(ScrTblPrsRol prsPrf, SitTblGnr gnr, SitTblNmb nmb, int ITrpId, int IDteSetYr, int IDteSetMth,
			int IDteSetDay, int IDteClcYr, int IDteClcMth, int IDteClcDay, boolean BGnrTrpRcv, boolean BGnrTrpSup,
			boolean BGnrEgs, boolean BGnrLrs, boolean BGnrAdl, int ITpeId) {
		try {
			gnr.setDGnrDteRgs(dfl.dCurrentDate());
			gnr.setSGnrTmeRgs(dfl.currentTime());
			gnr.setScrTblPrsRol(prsPrf);
			gnr.setIEpiId(-99);
			gnr.setSitTblNmb(nmb);
			gnr.setITrpId(ITrpId);
			gnr.setIGnrDteSetYr(IDteSetYr);
			gnr.setIGnrDteSetMth(IDteSetMth);
			gnr.setIGnrDteSetDay(IDteSetDay);
			gnr.setIGnrDteClcYr(IDteClcYr);
			gnr.setIGnrDteClcMth(IDteClcMth);
			gnr.setIGnrDteClcDay(IDteClcDay);
			gnr.setBGnrTrpRcv(BGnrTrpRcv);
			gnr.setBGnrTrpSup(BGnrTrpSup);
			gnr.setBGnrEgs(BGnrEgs);
			gnr.setBGnrLrs(BGnrLrs);
			gnr.setBGnrAdl(BGnrAdl);
			gnr.setITpeId(ITpeId);
			gnr.setBGnrStt(true);
			this.insert(gnr);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<SitTblGnr> lstPrsRol(int IPrjId) {
		try {
			String sql = "SELECT gnr FROM SitTblGnr gnr WHERE gnr.scrTblPrsRol.IPrjId = :param AND gnr.BGnrStt = true";
			Query q = em.createQuery(sql);
			q.setParameter("param", IPrjId);
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean dlt(SitTblGnr gnr) {
		try {
			gnr.setBGnrStt(false);
			this.update(gnr);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
