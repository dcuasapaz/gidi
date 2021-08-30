package ec.gob.msp.pms.srv;

import javax.ejb.Stateless;

import ec.gob.msp.pms.cmm.SrvDb;
import ec.gob.msp.pms.ent.DteTblDay;

@Stateless
public class DteSrvDay extends SrvDb<DteTblDay> {

	public DteSrvDay() {
		super(DteTblDay.class, DteSrvDay.class);

	}
}
