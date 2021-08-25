package ec.gob.inspi.gidi.sit.srv;

import javax.ejb.Stateless;

import ec.gob.inspi.gidi.sit.cmm.SrvDb;
import ec.gob.inspi.gidi.sit.ent.DpaTblCnr;;

@Stateless
public class DpaSrvCnr extends SrvDb<DpaTblCnr> {
	public DpaSrvCnr() {
		super(DpaTblCnr.class, DpaSrvCnr.class);
	}
}
