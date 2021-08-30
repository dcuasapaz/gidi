package ec.gob.msp.pms.srv;

import javax.ejb.Stateless;

import ec.gob.msp.pms.cmm.Default;
import ec.gob.msp.pms.cmm.SrvDb;
import ec.gob.msp.pms.ent.DpaTblCnt;
import ec.gob.msp.pms.ent.HstTblCntPrsRol;
import ec.gob.msp.pms.ent.ScrTblPrsRol;

@Stateless
public class HstSrvCntPrsRol extends SrvDb<HstTblCntPrsRol> {
	protected Default dfl;

	public HstSrvCntPrsRol() {
		super(HstTblCntPrsRol.class, HstSrvCntPrsRol.class);
		dfl = new Default();
	}

	public boolean sve(DpaTblCnt cnt, ScrTblPrsRol prsRol, int IActCde, String SCntDtl) {
		try {
			HstTblCntPrsRol hstAux = new HstTblCntPrsRol();
			hstAux.setDCntPrsRolDteRgs(dfl.DCurrentDate());
			hstAux.setSCntPrsRolTmeRgs(dfl.SCurrentTime());
			hstAux.setDpaTblCnt(cnt);
			hstAux.setScrTblPrsRol(prsRol);
			hstAux.setIActCde(IActCde);
			hstAux.setSCntPrsRolDtl(SCntDtl);
			this.insert(hstAux);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
