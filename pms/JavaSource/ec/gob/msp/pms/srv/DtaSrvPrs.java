package ec.gob.msp.pms.srv;

import javax.ejb.Stateless;

import ec.gob.msp.pms.cmm.Default;
import ec.gob.msp.pms.cmm.Method;
import ec.gob.msp.pms.cmm.SrvDb;
import ec.gob.msp.pms.ent.DtaTblPr;

@Stateless
public class DtaSrvPrs extends SrvDb<DtaTblPr> {
	protected Default dfl;
	protected Method mth;

	public DtaSrvPrs() {
		super(DtaTblPr.class, DtaSrvPrs.class);
		dfl = new Default();
		mth = new Method();
	}

	public boolean sve(DtaTblPr prs) {
		try {
			prs.setDPrsDteRgs(dfl.DCurrentDate());
			prs.setSPrsTmeRgs(dfl.SCurrentTime());
			prs.setSPrsLstNme(mth.mtdStrNmb(prs.getSPrsLstNme()));
			prs.setSPrsNme(mth.mtdStrNmb(prs.getSPrsNme()));
			prs.setSPrsUsr(prs.getSPrsUsr().toLowerCase());
			this.insert(prs);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean upd(DtaTblPr prs) {
		try {
			prs.setSPrsLstNme(mth.mtdStrNmb(prs.getSPrsLstNme()));
			prs.setSPrsNme(mth.mtdStrNmb(prs.getSPrsNme()));
			this.update(prs);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
