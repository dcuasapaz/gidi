package ec.gob.msp.pms.srv;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.msp.pms.cmm.Default;
import ec.gob.msp.pms.cmm.Method;
import ec.gob.msp.pms.cmm.SrvDb;
import ec.gob.msp.pms.ent.DpaTblOpt;
import ec.gob.msp.pms.ent.DtaTblOpt;

@Stateless
public class DpaSrvOpt extends SrvDb<DpaTblOpt> {
	protected Default dfl;
	protected Method mth;

	public DpaSrvOpt() {
		super(DpaTblOpt.class, DpaSrvOpt.class);
		dfl = new Default();
		mth = new Method();
	}

	public List<DpaTblOpt> rtrLstEnt(int IOptCde) {
		try {
			String sql = "SELECT prv FROM DpaTblOpt prv WHERE prv.iOptTpe=:prm ORDER BY iOptCde ASC";
			Query q = em.createQuery(sql);
			q.setParameter("prm", IOptCde);
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public DpaTblOpt rtrEntPrv(int IPrvCde) {
		try {
			String sql = "SELECT prv FROM DpaTblOpt prv WHERE prv.iOptTpe=100 AND iOptCde=:prm";
			Query q = em.createQuery(sql);
			q.setParameter("prm", IPrvCde);
			return (DpaTblOpt) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
