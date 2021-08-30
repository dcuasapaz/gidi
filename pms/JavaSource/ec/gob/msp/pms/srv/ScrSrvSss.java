package ec.gob.msp.pms.srv;

import javax.ejb.Stateless;

import ec.gob.msp.pms.cmm.Default;
import ec.gob.msp.pms.cmm.SrvDb;
import ec.gob.msp.pms.ent.ScrTblPrsRol;
import ec.gob.msp.pms.ent.ScrTblSss;

@Stateless
public class ScrSrvSss extends SrvDb<ScrTblSss> {
	protected Default dfl;

	public ScrSrvSss() {
		super(ScrTblSss.class, ScrSrvSss.class);
		dfl = new Default();
	}

	public ScrTblSss sve(ScrTblPrsRol prl, String msg) {
		try {
			ScrTblSss sss = new ScrTblSss();
			sss.setDSssDte(dfl.DCurrentDate());
			sss.setSSssTmeSrt(dfl.SCurrentTime());
			sss.setSSssTmeEnd(dfl.SCurrentTime());
			sss.setIPrsRolId(prl.getIPrsRolId());
			sss.setSSssTmeDsc(msg);
			this.insert(sss);
			return sss;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean upd(ScrTblSss sss) {
		try {
			sss.setSSssTmeEnd(dfl.SCurrentTime());
			this.update(sss);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean upd(ScrTblSss sss, String msg) {
		try {
			sss.setSSssTmeEnd(Default.S_CURRENT_TIME());
			sss.setSSssTmeDsc(sss.getSSssTmeDsc() + msg);
			this.update(sss);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
