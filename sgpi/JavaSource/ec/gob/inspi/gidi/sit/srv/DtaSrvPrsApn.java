package ec.gob.inspi.gidi.sit.srv;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.inspi.gidi.sit.cmm.Default;
import ec.gob.inspi.gidi.sit.cmm.Log;
import ec.gob.inspi.gidi.sit.cmm.SrvDb;
import ec.gob.inspi.gidi.sit.ent.DtaTblPr;
import ec.gob.inspi.gidi.sit.ent.DtaTblPrsApn;
import ec.gob.inspi.gidi.sit.ent.InsTblApn;
import ec.gob.inspi.gidi.sit.ent.InsTblUnt;

@Stateless
public class DtaSrvPrsApn extends SrvDb<DtaTblPrsApn> {

	protected Log log;
	protected Default dfl;

	public DtaSrvPrsApn() {
		super(DtaTblPrsApn.class, DtaSrvPrsApn.class);
		log = new Log();
		dfl = new Default();
	}

	public boolean save(DtaTblPr prs, InsTblApn apn, int ISttCde) {
		try {
			DtaTblPrsApn prsApn = new DtaTblPrsApn();
			prsApn.setSPrsApnTmeRgs(dfl.currentTime());
			prsApn.setDPrsApnDteRgs(dfl.dCurrentDate());
			prsApn.setDtaTblPr(prs);
			prsApn.setInsTblApn(apn);
			prsApn.setISttCde(ISttCde);
			this.insert(prsApn);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(DtaTblPrsApn prsApn, InsTblApn apn, int ISttCde) {
		try {
			prsApn.setInsTblApn(apn);
			prsApn.setISttCde(ISttCde);
			this.update(prsApn);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<DtaTblPrsApn> lstPrsApn() {
		try {
			String sql = "SELECT prsApn FROM DtaTblPrsApn prsApn WHERE prsApn.ISttCde = 901 ";
			Query q = em.createQuery(sql);
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<DtaTblPrsApn> lstApn(DtaTblPr prs) {
		try {
			String sql = "SELECT prsApn FROM DtaTblPrsApn prsApn WHERE prsApn.dtaTblPr = :param ORDER BY 1";
			Query q = em.createQuery(sql);
			q.setParameter("param", prs);
			return q.getResultList();
		} catch (Exception e) {
			this.log.impSrv(3, DtaSrvPrsApn.class.getSimpleName(), List.class.getSimpleName(),
					DtaTblPrsApn.class.getSimpleName(), e.getMessage());
			return null;
		}
	}
	
	public List<DtaTblPrsApn> lstApnT(DtaTblPr prs) {
		try {
			String sql = "SELECT prsApn FROM DtaTblPrsApn prsApn WHERE prsApn.dtaTblPr = :param AND prsApn.ISttCde = 901 ORDER BY 1";
			Query q = em.createQuery(sql);
			q.setParameter("param", prs);
			return q.getResultList();
		} catch (Exception e) {
			this.log.impSrv(3, DtaSrvPrsApn.class.getSimpleName(), List.class.getSimpleName(),
					DtaTblPrsApn.class.getSimpleName(), e.getMessage());
			return null;
		}
	}

	public List<DtaTblPrsApn> lstPrsApn(InsTblUnt unt) {
		try {
			String sql = "SELECT prsApn FROM DtaTblPrsApn prsApn "
					+ "WHERE prsApn.insTblApn.insTblUnt = :param AND prsApn.ISttCde = 901 " + "ORDER BY 1";
			Query q = em.createQuery(sql);
			q.setParameter("param", unt);
			return q.getResultList();
		} catch (Exception e) {
			this.log.impSrv(2, DtaSrvPrsApn.class.getSimpleName(), List.class.getSimpleName(),
					DtaTblPrsApn.class.getSimpleName(), e.getMessage());
			return null;
		}
	}

	public List<DtaTblPrsApn> lstPrs(DtaTblPr prs) {
		try {
			String sql = "SELECT prsApn FROM DtaTblPrsApn prsApn WHERE prsApn.dtaTblPr = :param ORDER BY 1";
			Query q = em.createQuery(sql);
			q.setParameter("param", prs);
			return q.getResultList();
		} catch (Exception e) {
			this.log.impSrv(1, DtaSrvPrsApn.class.getSimpleName(), List.class.getSimpleName(),
					DtaTblPrsApn.class.getSimpleName(), e.getMessage());
			return null;
		}

	}

}
