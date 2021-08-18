package ec.gob.inspi.gidi.sit.srv;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.inspi.gidi.sit.cmm.Default;
import ec.gob.inspi.gidi.sit.cmm.Log;
import ec.gob.inspi.gidi.sit.cmm.SrvDb;
import ec.gob.inspi.gidi.sit.ent.InsTblApn;
import ec.gob.inspi.gidi.sit.ent.InsTblUnt;

@Stateless
public class InsSrvApn extends SrvDb<InsTblApn> {

	protected Log log;
	protected Default dfl;

	public InsSrvApn() {
		super(InsTblApn.class, InsSrvApn.class);
		log = new Log();
		dfl = new Default();
	}

	public boolean save(InsTblApn apn, InsTblUnt unt) {
		try {
			apn.setSApnTmeRgs(dfl.currentTime());
			apn.setDApnDteRgs(dfl.dCurrentDate());
			apn.setInsTblUnt(unt);
			this.insert(apn);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(InsTblApn apn, InsTblUnt unt) {
		try {
			apn.setInsTblUnt(unt);
			this.update(apn);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<InsTblApn> lstApn(InsTblUnt unt) {
		try {
			String sql = "SELECT apn FROM InsTblApn apn WHERE apn.insTblUnt = :param ORDER BY sApnNme ASC";
			Query q = em.createQuery(sql);
			q.setParameter("param", unt);
			return q.getResultList();
		} catch (Exception e) {
			this.log.impSrv(1, InsSrvApn.class.getSimpleName(), List.class.getSimpleName(),
					InsTblApn.class.getSimpleName(), e.getMessage());
			return null;
		}

	}

}
