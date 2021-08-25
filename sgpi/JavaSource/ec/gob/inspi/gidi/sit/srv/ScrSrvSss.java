package ec.gob.inspi.gidi.sit.srv;

import javax.ejb.Stateless;

import ec.gob.inspi.gidi.sit.cmm.Default;
import ec.gob.inspi.gidi.sit.cmm.SrvDb;
import ec.gob.inspi.gidi.sit.ent.ScrTblPrsRol;
import ec.gob.inspi.gidi.sit.ent.ScrTblSss;

@Stateless
public class ScrSrvSss extends SrvDb<ScrTblSss> {
	protected Default dfl;

	public ScrSrvSss() {
		super(ScrTblSss.class, ScrSrvSss.class);
		dfl = new Default();
	}

	public ScrTblSss save(ScrTblPrsRol prl, String msg) {
		try {
			ScrTblSss sss = new ScrTblSss();
			sss.setIPrsRolId(prl.getIPrsRolId());
			sss.setDSssDte(dfl.dCurrentDate());
			sss.setSSssTmeSrt(dfl.currentTime());
			sss.setSSssTmeEnd(dfl.currentTime());
			sss.setSSssTmeDsc(msg);
			this.insert(sss);
			return sss;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean update(ScrTblSss sss, String msg) {
		try {
			sss.setSSssTmeEnd(dfl.currentTime());
			sss.setSSssTmeDsc(sss.getSSssTmeDsc() + msg);
			this.update(sss);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
