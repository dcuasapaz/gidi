package ec.gob.msp.pms.srv;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.msp.pms.cmm.Default;
import ec.gob.msp.pms.cmm.SrvDb;
import ec.gob.msp.pms.ent.DpaTblCnt;

@Stateless
public class DpaSrvCnt extends SrvDb<DpaTblCnt> {
	protected Default dfl;

	public DpaSrvCnt() {
		super(DpaTblCnt.class, DpaSrvCnt.class);
		dfl = new Default();
	}

	public boolean sve(DpaTblCnt cnt, String SCntDcm, int ISttCde, int ICntDteYr, int ICntDteMth, int ICntDteDay) {
		try {
			cnt.setSCntDcm(SCntDcm);
			cnt.setISttCde(ISttCde);
			cnt.setICntDteStrPrcYr(ICntDteYr);
			cnt.setICntDteStrPrcMth(ICntDteMth);
			cnt.setICntDteStrPrcDay(ICntDteDay);
			cnt.setICntDteEndPrcYr(ICntDteYr);
			cnt.setICntDteEndPrcMth(ICntDteMth);
			cnt.setICntDteEndPrcDay(ICntDteDay);
			this.update(cnt);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean upd(DpaTblCnt cnt, String SCntDcm, int ISttCde, int ICntDteYr, int ICntDteMth, int ICntDteDay) {
		try {
			cnt.setSCntDcm(SCntDcm);
			cnt.setISttCde(ISttCde);
			cnt.setICntDteStrPrcYr(ICntDteYr);
			cnt.setICntDteStrPrcMth(ICntDteMth);
			cnt.setICntDteStrPrcDay(ICntDteDay);
			cnt.setICntDteEndPrcYr(ICntDteYr);
			cnt.setICntDteEndPrcMth(ICntDteMth);
			cnt.setICntDteEndPrcDay(ICntDteDay);
			this.update(cnt);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<DpaTblCnt> lstCnt(int condition) {
		try {
			String sql = "SELECT cnt FROM DpaTblCnt cnt WHERE cnt.iSttCde=:prm ORDER BY to_date(cnt.iCntDteStrPrcYr||'-'||cnt.iCntDteStrPrcMth||'-'||cnt.iCntDteStrPrcDay, 'yyyy-MM-dd') DESC";
			Query q = em.createQuery(sql);
			q.setParameter("prm", condition);
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<DpaTblCnt> lstCntPrv(int IPrvCde) {
		try {
			String sql = "SELECT cnt FROM DpaTblCnt cnt WHERE cnt.iPrvCde=:prm ORDER BY cnt.sCntNme";
			Query q = em.createQuery(sql);
			q.setParameter("prm", IPrvCde);
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<DpaTblCnt> lstCntPrv(int IPrvCde, int ISttCde) {
		try {
			String sql = "SELECT cnt FROM DpaTblCnt cnt WHERE cnt.iPrvCde=:prm1 AND cnt.iSttCde =:prm2 ORDER BY cnt.sCntNme";
			Query q = em.createQuery(sql);
			q.setParameter("prm1", IPrvCde);
			q.setParameter("prm2", ISttCde);
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
