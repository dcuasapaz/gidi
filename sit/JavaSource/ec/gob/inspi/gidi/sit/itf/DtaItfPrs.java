package ec.gob.inspi.gidi.sit.itf;

import java.util.List;

import ec.gob.inspi.gidi.sit.ent.DtaTblPr;

public interface DtaItfPrs {

	public void init();

	public void cptInit();

	public List<DtaTblPr> loadPrs();
	
	public void loadLstTblPrs();

	public void add();

	public void sve();

	public void edt();

	public void upd();

	public void dlt();

}
