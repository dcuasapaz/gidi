package ec.gob.inspi.gidi.sit.itf;

import java.util.List;

import ec.gob.inspi.gidi.sit.ent.DpaTblCnr;

public interface DpaIftCnr {

	public DpaTblCnr rtrCnr(int ICnrId);

	public List<DpaTblCnr> loadLstCnr();
}
