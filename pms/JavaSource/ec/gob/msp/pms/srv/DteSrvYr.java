package ec.gob.msp.pms.srv;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.msp.pms.cmm.SrvDb;
import ec.gob.msp.pms.ent.DteTblYr;

@Stateless
public class DteSrvYr extends SrvDb<DteTblYr> {

	public DteSrvYr() {
		super(DteTblYr.class, DteSrvYr.class);

	}

	public List<DteTblYr> lstYr(int IMdlId) {
		try {
			String sql = "SELECT yr FROM DteTblYr yr WHERE yr.iMdlId = :param ORDER BY 3 DESC";
			Query q = em.createQuery(sql);
			q.setParameter("param", IMdlId);
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
