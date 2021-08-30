package ec.gob.msp.pms.srv;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.msp.pms.cmm.SrvDb;
import ec.gob.msp.pms.ent.DpaTblCnt;
import ec.gob.msp.pms.ent.IndTblLvl;
import ec.gob.msp.pms.ent.IndTblMain;

@Stateless
public class IndSrvMain extends SrvDb<IndTblMain> {

	public IndSrvMain() {
		super(IndTblMain.class, IndSrvMain.class);
	}

	public List<IndTblMain> lstMain(IndTblLvl lvl) {
		try {
			String sql = "SELECT main FROM IndTblMain main WHERE main.indTblLvl = :param";
			Query q = em.createQuery(sql);
			q.setParameter("param", lvl);
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<IndTblMain> lstMain21() {
		try {
			String sql = "SELECT main FROM IndTblMain main ORDER BY main.sMainNme";
			Query q = em.createQuery(sql);
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<IndTblMain> lstMain22(DpaTblCnt cnt) {
		try {
			String sql = "SELECT main FROM IndTblMain main WHERE main NOT IN (SELECT indTblMain FROM PmsTblMnc AS Tmp WHERE ((dpaTblCnt=:prm) AND ((rCrtNmb<>-99) OR (rCrtNmb=-999)))) ORDER BY main.sMainNme";
			Query q = em.createQuery(sql);
			q.setParameter("prm", cnt);
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<IndTblMain> lstMain23() {
		try {
			String sql = "SELECT main FROM IndTblMain main WHERE main.bMainObl = TRUE ORDER BY main.sMainNme";
			Query q = em.createQuery(sql);
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<IndTblMain> lstMain24() {
		try {
			String sql = "SELECT main FROM IndTblMain main WHERE main.bMainDsn = TRUE ORDER BY main.sMainNme";
			Query q = em.createQuery(sql);
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<IndTblMain> lstMain25() {
		try {
			String sql = "SELECT main FROM IndTblMain main WHERE main.bMainMtr = TRUE ORDER BY main.sMainNme";
			Query q = em.createQuery(sql);
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<IndTblMain> lstMain26() {
		try {
			String sql = "SELECT main FROM IndTblMain main WHERE main.bMainVln = TRUE ORDER BY 3";
			Query q = em.createQuery(sql);
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
