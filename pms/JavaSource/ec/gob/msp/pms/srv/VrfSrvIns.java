package ec.gob.msp.pms.srv;

import javax.ejb.Stateless;

import ec.gob.msp.pms.cmm.SrvDb;
import ec.gob.msp.pms.ent.VrfTblIn;

@Stateless
public class VrfSrvIns extends SrvDb<VrfTblIn> {

	public VrfSrvIns() {
		super(VrfTblIn.class, VrfSrvIns.class);

	}
}
