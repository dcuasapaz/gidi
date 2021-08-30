package ec.gob.msp.pms.srv;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.msp.pms.cmm.Default;
import ec.gob.msp.pms.cmm.SrvDb;
import ec.gob.msp.pms.ent.DpaTblCnt;
import ec.gob.msp.pms.ent.DtaTblPr;
import ec.gob.msp.pms.ent.ScrTblPrsRol;

@Stateless
public class ScrSrvPrsRol extends SrvDb<ScrTblPrsRol> {
	protected Default dfl;

	public ScrSrvPrsRol() {
		super(ScrTblPrsRol.class, ScrSrvPrsRol.class);
		dfl = new Default();
	}

	public boolean sve(int IRolId, DtaTblPr prs, int ISttId, DpaTblCnt cnt) {
		try {
			ScrTblPrsRol prl = new ScrTblPrsRol();
			prl.setDPrsRolDteRgs(dfl.DCurrentDate());
			prl.setSPrsRolTmeRgs(dfl.SCurrentTime());
			prl.setIRolId(IRolId);
			prl.setDtaTblPr(prs);
			prl.setISttId(ISttId);
			prl.setDpaTblCnt(cnt);
			this.insert(prl);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean upd(ScrTblPrsRol prl, int IRolId, int ISttId, DpaTblCnt cnt) {
		try {
			prl.setIRolId(IRolId);
			prl.setISttId(ISttId);
			prl.setDpaTblCnt(cnt);
			this.update(prl);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean upd(ScrTblPrsRol prl, int ISttId) {
		try {
			prl.setISttId(ISttId);
			this.update(prl);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<ScrTblPrsRol> lstPrsRol(int ISttId) {
		try {
			String sql = "SELECT prsRol FROM ScrTblPrsRol prsRol WHERE prsRol.iSttId=:prm ORDER BY prsRol.iRolId";
			Query q = em.createQuery(sql);
			q.setParameter("prm", ISttId);
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<ScrTblPrsRol> lstRol(DtaTblPr prs) {
		try {
			String sql = "SELECT prsRol FROM ScrTblPrsRol prsRol WHERE prsRol.dtaTblPr = :param ORDER BY prsRol.iRolId ASC";
			Query q = em.createQuery(sql);
			q.setParameter("param", prs);
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
