package ec.gob.inspi.gidi.sit.srv;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.inspi.gidi.sit.cmm.Default;
import ec.gob.inspi.gidi.sit.cmm.Log;
import ec.gob.inspi.gidi.sit.cmm.SrvDb;
import ec.gob.inspi.gidi.sit.ent.InsTblEnt;
import ec.gob.inspi.gidi.sit.ent.InsTblUnt;

@Stateless
public class InsSrvUnt extends SrvDb<InsTblUnt> {

	protected Log log;
	protected Default dfl;

	public InsSrvUnt() {
		super(InsTblUnt.class, InsSrvUnt.class);
		log = new Log();
		dfl = new Default();
	}

	public void save(InsTblEnt ent, int ILvlId, int IUntCde, InsTblUnt unt) {
		try {
			unt.setDUntDteRgs(dfl.dCurrentDate());
			unt.setSUntTmeRgs(dfl.currentTime());
			unt.setSUntAcr(unt.getSUntAcr().toUpperCase());
			unt.setInsTblEnt(ent);
			unt.setILvlId(ILvlId);
			unt.setIUntCde(IUntCde);
			this.insert(unt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean update(InsTblEnt ent, int ILvlId, int IUntCde, InsTblUnt unt) {
		try {
			unt.setSUntAcr(unt.getSUntAcr().toUpperCase());
			unt.setInsTblEnt(ent);
			unt.setILvlId(ILvlId);
			unt.setIUntCde(IUntCde);
			this.update(unt);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<InsTblUnt> lstUnt(InsTblEnt ent) {
		try {
			String sql = "SELECT unt FROM InsTblUnt unt WHERE unt.insTblEnt = :param AND iUntCde = -99 ORDER BY sUntNme ASC";
			Query q = em.createQuery(sql);
			q.setParameter("param", ent);
			return q.getResultList();
		} catch (Exception e) {
			this.log.impSrv(1, InsTblUnt.class.getSimpleName(), List.class.getSimpleName(),
					InsTblUnt.class.getSimpleName(), e.getMessage());
			return null;
		}

	}

	public List<InsTblUnt> lstUntMain(InsTblEnt ent) {
		try {
			String sql = "SELECT unt FROM InsTblUnt unt WHERE unt.insTblEnt = :param AND iUntCde = -99 ORDER BY sUntNme ASC";
			Query q = em.createQuery(sql);
			q.setParameter("param", ent);
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<InsTblUnt> lstUntSub(InsTblEnt ent) {
		try {
			String sql = "SELECT unt FROM InsTblUnt unt WHERE unt.insTblEnt = :param AND iUntCde != -99 ORDER BY sUntNme ASC";
			Query q = em.createQuery(sql);
			q.setParameter("param", ent);
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<InsTblUnt> lstUntSub(int IUntCde) {
		try {
			String sql = "SELECT unt FROM InsTblUnt unt WHERE unt.iUntCde = :param ORDER BY sUntNme ASC";
			Query q = em.createQuery(sql);
			q.setParameter("param", IUntCde);
			return q.getResultList();
		} catch (Exception e) {
			this.log.impSrv(1, InsTblUnt.class.getSimpleName(), List.class.getSimpleName(),
					InsTblUnt.class.getSimpleName(), e.getMessage());
			return null;
		}

	}

	public List<InsTblUnt> lstTblUnt() {
		try {
			String sql = "SELECT unt FROM InsTblUnt unt ORDER BY sUntNme ASC";
			Query q = em.createQuery(sql);
			return q.getResultList();
		} catch (Exception e) {
			this.log.impSrv(3, InsTblUnt.class.getSimpleName(), List.class.getSimpleName(),
					InsTblUnt.class.getSimpleName(), e.getMessage());
			return null;
		}

	}

}
