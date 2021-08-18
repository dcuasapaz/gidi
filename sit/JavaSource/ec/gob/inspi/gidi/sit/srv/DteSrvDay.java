package ec.gob.inspi.gidi.sit.srv;

import javax.ejb.Stateless;

import ec.gob.inspi.gidi.sit.cmm.Log;
import ec.gob.inspi.gidi.sit.cmm.SrvDb;
import ec.gob.inspi.gidi.sit.ent.DteTblDay;

@Stateless
public class DteSrvDay extends SrvDb<DteTblDay> {

	protected Log log;

	public DteSrvDay() {
		super(DteTblDay.class, DteSrvDay.class);
		log = new Log();
	}
}
