package ec.gob.msp.pms.srv;

import javax.ejb.Stateless;

import ec.gob.msp.pms.cmm.SrvDb;
import ec.gob.msp.pms.ent.DteTblMnt;


@Stateless
public class DteSrvMnt extends SrvDb<DteTblMnt> {



	public DteSrvMnt() {
		super(DteTblMnt.class, DteSrvMnt.class);
	}
}
