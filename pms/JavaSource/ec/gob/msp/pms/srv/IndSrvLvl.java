package ec.gob.msp.pms.srv;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.msp.pms.cmm.SrvDb;
import ec.gob.msp.pms.ent.IndTblLvl;

@Stateless
public class IndSrvLvl extends SrvDb<IndTblLvl> {

	public IndSrvLvl() {
		super(IndTblLvl.class, IndSrvLvl.class);
	}

	public List<IndTblLvl> lstLv1(int ILvlFth) {
		try {
			String sql = "SELECT lvl FROM IndTblLvl lvl WHERE lvl.iLvlFth = :param";
			Query q = em.createQuery(sql);
			q.setParameter("param", ILvlFth);
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<IndTblLvl> lstLvl(IndTblLvl lvl) {
		try {
			String sql = "SELECT lvl FROM IndTblLvl lvl WHERE lvl.iLvlFth = :param ORDER BY 1";
			Query q = em.createQuery(sql);
			q.setParameter("param", lvl.getILvlCde());
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
