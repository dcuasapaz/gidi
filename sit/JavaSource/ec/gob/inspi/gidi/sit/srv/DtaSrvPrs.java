package ec.gob.inspi.gidi.sit.srv;

import javax.ejb.Stateless;

import ec.gob.inspi.gidi.sit.cmm.Default;
import ec.gob.inspi.gidi.sit.cmm.SrvDb;
import ec.gob.inspi.gidi.sit.ent.DpaTblCnr;
import ec.gob.inspi.gidi.sit.ent.DtaTblPr;

@Stateless
public class DtaSrvPrs extends SrvDb<DtaTblPr> {

	protected Default dfl;

	public DtaSrvPrs() {
		super(DtaTblPr.class, DtaSrvPrs.class);
		dfl = new Default();
	}

	public boolean save(DtaTblPr prs, int IIdnId, int IGrtId, DpaTblCnr cnr, int IGndId) {
		try {
			prs.setSPrsTmeRgs(dfl.currentTime());
			prs.setDPrsDteRgs(dfl.dCurrentDate());
			prs.setDpaTblCnr(cnr);
			prs.setIIdnId(IIdnId);
			prs.setIGrtId(IGrtId);
			prs.setIGndCde(IGndId);
			this.insert(prs);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(DtaTblPr prs, int IIdnId, int IGrtId, DpaTblCnr cnr, int IGndId) {
		try {
			prs.setDpaTblCnr(cnr);
			prs.setIIdnId(IIdnId);
			prs.setIGrtId(IGrtId);
			prs.setIGndCde(IGndId);
			this.update(prs);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
