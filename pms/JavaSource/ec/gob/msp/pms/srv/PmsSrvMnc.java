package ec.gob.msp.pms.srv;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.msp.pms.cmm.Default;
import ec.gob.msp.pms.cmm.SrvDb;
import ec.gob.msp.pms.ent.DpaTblCnt;
import ec.gob.msp.pms.ent.IndTblMain;
import ec.gob.msp.pms.ent.PmsTblMnc;
import ec.gob.msp.pms.ent.ScrTblPrsRol;

@Stateless
public class PmsSrvMnc extends SrvDb<PmsTblMnc> {
	protected Default dfl;

	public PmsSrvMnc() {
		super(PmsTblMnc.class, PmsSrvMnc.class);
		dfl = new Default();
	}

	public List<PmsTblMnc> lstMncPrf(ScrTblPrsRol prsRol) {
		try {
			String sql = "SELECT mnc FROM PmsTblMnc mnc WHERE mnc.scrTblPrsRol = :param";
			Query q = em.createQuery(sql);
			q.setParameter("param", prsRol);
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<IndTblMain> lstMain_22(DpaTblCnt cnt) {
		try {
			String sql = "SELECT main FROM IndTblMain main "
					+ "WHERE main NOT IN (SELECT pms.indTblMain FROM PmsTblMnc pms WHERE pms.dpaTblCnt = :param AND ((pms.rCrtNmb <> -99) OR (pms.rCrtNmb=-999)) ORDER BY main.iMainCde)";
			Query q = em.createQuery(sql);
			q.setParameter("param", cnt);
			return q.getResultList();
		} catch (Exception e) {

			return null;
		}
	}

	public List<PmsTblMnc> lstMncCnt(DpaTblCnt cnt) {
		try {
			String sql = "SELECT mnc FROM PmsTblMnc mnc WHERE mnc.dpaTblCnt = :param";
			Query q = em.createQuery(sql);
			q.setParameter("param", cnt);
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
