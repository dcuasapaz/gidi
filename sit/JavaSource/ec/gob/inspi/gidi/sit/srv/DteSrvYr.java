package ec.gob.inspi.gidi.sit.srv;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.inspi.gidi.sit.cmm.Log;
import ec.gob.inspi.gidi.sit.cmm.SrvDb;
import ec.gob.inspi.gidi.sit.ent.DteTblYr;

@Stateless
public class DteSrvYr extends SrvDb<DteTblYr> {

	protected Log log;

	public DteSrvYr() {
		super(DteTblYr.class, DteSrvYr.class);
		log = new Log();
	}

	public List<DteTblYr> lstYr(int IMdlId) {
		try {
			String sql = "SELECT yr FROM DteTblYr yr WHERE yr.iMdlId = :param ORDER BY 3 DESC";
			Query q = em.createQuery(sql);
			q.setParameter("param", IMdlId);
			return q.getResultList();
		} catch (Exception e) {
			this.log.impSrv(1, DteSrvYr.class.getSimpleName(), List.class.getSimpleName(),
					DteTblYr.class.getSimpleName(), e.getMessage());
			return null;
		}
	}

	public DteTblYr lstYr(int IMdlId, int value) {
		try {
			String sql = "SELECT yr FROM DteTblYr yr WHERE yr.iMdlId = :param1 AND yr.iYrVle = :param2 ORDER BY 3 ASC";
			Query q = em.createQuery(sql);
			q.setParameter("param1", IMdlId);
			q.setParameter("param2", value);
			return (DteTblYr)q.getSingleResult();
		} catch (Exception e) {
			this.log.impSrv(2, DteSrvYr.class.getSimpleName(), List.class.getSimpleName(),
					DteTblYr.class.getSimpleName(), e.getMessage());
			return null;
		}
	}
}
