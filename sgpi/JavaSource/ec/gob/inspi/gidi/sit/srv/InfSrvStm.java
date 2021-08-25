package ec.gob.inspi.gidi.sit.srv;

import javax.ejb.Stateless;

import ec.gob.inspi.gidi.sit.cmm.SrvDb;
import ec.gob.inspi.gidi.sit.ent.InfTblStm;

@Stateless
public class InfSrvStm extends SrvDb<InfTblStm> {
	public InfSrvStm() {
		super(InfTblStm.class, InfSrvStm.class);
	}
}
