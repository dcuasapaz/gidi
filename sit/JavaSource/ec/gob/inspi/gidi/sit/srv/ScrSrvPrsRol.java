package ec.gob.inspi.gidi.sit.srv;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.inspi.gidi.sit.cmm.Default;
import ec.gob.inspi.gidi.sit.cmm.Log;
import ec.gob.inspi.gidi.sit.cmm.SrvDb;
import ec.gob.inspi.gidi.sit.ent.DtaTblPr;
import ec.gob.inspi.gidi.sit.ent.ScrTblPrsRol;

@Stateless
public class ScrSrvPrsRol extends SrvDb<ScrTblPrsRol> {
	protected Log log;
	protected Default dfl;

	public ScrSrvPrsRol() {
		super(ScrTblPrsRol.class, ScrSrvPrsRol.class);
		log = new Log();
		dfl = new Default();
	}

	public boolean save(DtaTblPr prs, int IPrfId, int ISttCde, boolean vlr, int IPrjId) {
		try {
			ScrTblPrsRol prl = new ScrTblPrsRol();
			prl.setSPrsRolTmeRgs(dfl.currentTime());
			prl.setDPrsRolDteRgs(dfl.dCurrentDate());
			prl.setIRolId(IPrfId);
			prl.setDtaTblPr(prs);
			prl.setISttId(ISttCde);
			prl.setBPrsRolStt(vlr);
			prl.setIPrjId(IPrjId);
			this.insert(prl);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(ScrTblPrsRol prl, boolean vlr, int IPrjId) {
		try {
			prl.setBPrsRolStt(vlr);
			prl.setIPrjId(IPrjId);
			this.update(prl);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(ScrTblPrsRol prl, int ISttCde) {
		try {
			prl.setISttId(ISttCde);
			this.update(prl);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<ScrTblPrsRol> lstPrsRol(int iRolIdLss, int iRolIdHgh) {
		try {
			String sql = "SELECT prsRol FROM ScrTblPrsRol prsRol WHERE  prsRol.iRolId BETWEEN :param1 AND :param2 AND prsRol.bPrsRolStt = TRUE ORDER BY 1";
			Query q = em.createQuery(sql);
			q.setParameter("param1", iRolIdLss);
			q.setParameter("param2", iRolIdHgh);
			return q.getResultList();
		} catch (Exception e) {
			this.log.impSrv(1, ScrSrvPrsRol.class.getSimpleName(), List.class.getSimpleName(),
					ScrTblPrsRol.class.getSimpleName(), e.getMessage());
			e.printStackTrace();
			return null;
		}

	}

	public List<ScrTblPrsRol> lstPrsRolFld(int IPrjId) {
		try {
			String sql = "";
			if (IPrjId == 101) {
				sql = "SELECT prsRol FROM ScrTblPrsRol prsRol WHERE prsRol.bPrsRolStt = TRUE AND prsRol.IPrjId = :param2 AND prsRol.iRolId = 103";
			} else if (IPrjId == 102) {
				sql = "SELECT prsRol FROM ScrTblPrsRol prsRol WHERE prsRol.bPrsRolStt = TRUE AND prsRol.IPrjId = :param2 AND prsRol.iRolId = 106";
			}
			Query q = em.createQuery(sql);
			q.setParameter("param2", IPrjId);
			return q.getResultList();
		} catch (Exception e) {
			this.log.impSrv(1, ScrSrvPrsRol.class.getSimpleName(), List.class.getSimpleName(),
					ScrTblPrsRol.class.getSimpleName(), e.getMessage());
			e.printStackTrace();
			return null;
		}

	}
	
	public List<ScrTblPrsRol> lstPrsRolTch(int IPrjId) {
		try {
			String sql = "";
			if (IPrjId == 101) {
				sql = "SELECT prsRol FROM ScrTblPrsRol prsRol WHERE prsRol.bPrsRolStt = TRUE AND prsRol.IPrjId = :param2 AND prsRol.iRolId = 104";
			} else if (IPrjId == 102) {
				sql = "SELECT prsRol FROM ScrTblPrsRol prsRol WHERE prsRol.bPrsRolStt = TRUE AND prsRol.IPrjId = :param2 AND prsRol.iRolId = 107";
			}
			Query q = em.createQuery(sql);
			q.setParameter("param2", IPrjId);
			return q.getResultList();
		} catch (Exception e) {
			this.log.impSrv(1, ScrSrvPrsRol.class.getSimpleName(), List.class.getSimpleName(),
					ScrTblPrsRol.class.getSimpleName(), e.getMessage());
			e.printStackTrace();
			return null;
		}

	}

	public List<ScrTblPrsRol> lstPrsRol(DtaTblPr prs) {
		try {
			String sql = "SELECT prsRol FROM ScrTblPrsRol prsRol WHERE prsRol.dtaTblPr = :param";
			Query q = em.createQuery(sql);
			q.setParameter("param", prs);
			return q.getResultList();
		} catch (Exception e) {
			this.log.impSrv(2, ScrSrvPrsRol.class.getSimpleName(), List.class.getSimpleName(),
					ScrTblPrsRol.class.getSimpleName(), e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public List<ScrTblPrsRol> lstRol(DtaTblPr prs) {
		try {
			String sql = "SELECT prsRol FROM ScrTblPrsRol prsRol WHERE prsRol.dtaTblPr = :param AND prsRol.iRolId BETWEEN 101 AND 107 AND prsRol.iRolId != 103 AND prsRol.iRolId != 104 AND prsRol.iRolId != 106 AND prsRol.iRolId != 107";
			Query q = em.createQuery(sql);
			q.setParameter("param", prs);
			return q.getResultList();
		} catch (Exception e) {
			this.log.impSrv(2, ScrSrvPrsRol.class.getSimpleName(), List.class.getSimpleName(),
					ScrTblPrsRol.class.getSimpleName(), e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public ScrTblPrsRol rtrPrsRol(DtaTblPr prs, int IRolId) {
		try {
			String sql = "SELECT prsRol FROM ScrTblPrsRol prsRol WHERE  prsRol.dtaTblPr = :param1 AND prsRol.iRolId = :param2";
			Query q = em.createQuery(sql);
			q.setParameter("param1", prs);
			q.setParameter("param2", IRolId);
			return (ScrTblPrsRol) q.getSingleResult();
		} catch (Exception e) {
			this.log.impSrv(3, ScrSrvPrsRol.class.getSimpleName(), List.class.getSimpleName(),
					ScrTblPrsRol.class.getSimpleName(), e.getMessage());
			e.printStackTrace();
			return null;
		}

	}

	public List<ScrTblPrsRol> lstPrsRol(int IRolId) {
		try {
			String sql = "SELECT prsRol FROM ScrTblPrsRol prsRol WHERE  prsRol.iRolId = :param  ORDER BY 1";
			Query q = em.createQuery(sql);
			q.setParameter("param", IRolId);
			return q.getResultList();
		} catch (Exception e) {
			this.log.impSrv(4, ScrSrvPrsRol.class.getSimpleName(), List.class.getSimpleName(),
					ScrTblPrsRol.class.getSimpleName(), e.getMessage());
			e.printStackTrace();
			return null;
		}

	}

}
