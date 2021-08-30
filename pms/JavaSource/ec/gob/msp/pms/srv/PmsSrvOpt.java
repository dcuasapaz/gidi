package ec.gob.msp.pms.srv;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.msp.pms.cmm.Default;
import ec.gob.msp.pms.cmm.Method;
import ec.gob.msp.pms.cmm.SrvDb;
import ec.gob.msp.pms.ent.PmsTblOpt;

@Stateless
public class PmsSrvOpt extends SrvDb<PmsTblOpt> {
	protected Default dfl;
	protected Method mth;

	public PmsSrvOpt() {
		super(PmsTblOpt.class, PmsSrvOpt.class);
		dfl = new Default();
		mth = new Method();
	}

	public List<PmsTblOpt> rtrLstEnt(int IOptCde) {
		try {
			String sql = "SELECT ent FROM PmsTblOpt ent WHERE ent.iOptVrb=:prm ORDER BY iOptId ASC";
			Query q = em.createQuery(sql);
			q.setParameter("prm", IOptCde);
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<PmsTblOpt> rtrLstEntObl(int IOptCde) {
		try {
			String sql = "SELECT ent FROM PmsTblOpt ent WHERE ent.iOptVrb=:prm AND iOptId BETWEEN 24 AND 26  ORDER BY iOptId ASC";
			Query q = em.createQuery(sql);
			q.setParameter("prm", IOptCde);
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
