package ec.gob.inspi.gidi.sit.srv;

import javax.ejb.Stateless;

import ec.gob.inspi.gidi.sit.cmm.Log;
import ec.gob.inspi.gidi.sit.cmm.SrvDb;
import ec.gob.inspi.gidi.sit.ent.DteTblMnt;

@Stateless
public class DteSrvMnt extends SrvDb<DteTblMnt> {

	protected Log log;

	public DteSrvMnt() {
		super(DteTblMnt.class, DteSrvMnt.class);
		log = new Log();
	}
}
