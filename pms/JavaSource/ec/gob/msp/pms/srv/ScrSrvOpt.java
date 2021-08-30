package ec.gob.msp.pms.srv;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.msp.pms.cmm.SrvDb;
import ec.gob.msp.pms.ent.ScrTblOpt;

@Stateless
public class ScrSrvOpt extends SrvDb<ScrTblOpt> {
	public ScrSrvOpt() {
		super(ScrTblOpt.class, ScrSrvOpt.class);
	}

	/** 1.- rtrLstEnt: Retornar los registros de una entidad por id **/
	public List<ScrTblOpt> rtrLstEnt(int IOptCde, boolean BOptStt) {
		try {
			String sql = "SELECT opt FROM ScrTblOpt opt WHERE opt.iOptTpe=:prm1 AND opt.bOptStt=:prm2 ORDER BY iOptCtg ASC";
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
