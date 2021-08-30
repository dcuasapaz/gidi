package ec.gob.msp.pms.srv;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.msp.pms.cmm.SrvDb;
import ec.gob.msp.pms.ent.DtaTblOpt;

@Stateless
public class DtaSrvOpt extends SrvDb<DtaTblOpt> {
	public DtaSrvOpt() {
		super(DtaTblOpt.class, DtaSrvOpt.class);
	}

	public List<DtaTblOpt> rtrLstEnt(int IOptCde, boolean BOptStt) {
		try {
			String sql = "SELECT opt FROM DtaTblOpt opt WHERE opt.iOptTpe=:prm1 AND opt.BOptStt=:prm2 ORDER BY iOptCtg ASC";
			Query q = em.createQuery(sql);
			q.setParameter("prm1", IOptCde);
			q.setParameter("prm2", BOptStt);
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
