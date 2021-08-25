package ec.gob.inspi.gidi.sit.itf;

public interface TplItfFrm {
	

	public void init();

	public void cptInit();

	public void add();

	public void cptAdd();

	public void sve();

	public void cptSve();

	public void upd();

	public void cptUpd();

	public void shw();

	public void cptShw();

	public void edt();

	public void cptEdt();

	public void dlt();

	public void cptDlt();

	public void actFrm(boolean vsbTbl, boolean vsbDta);

	public void actBtnHme(boolean dsb, boolean vsb);

	public void actBtnAdd(boolean dsb, boolean vsb);

	public void actBtnSve(boolean dsb, boolean vsb);

	public void actBtnUpd(boolean dsb, boolean vsb);

	public void actBtnRtr(boolean dsb, boolean vsb);
	
	public void actTblBtnShw(boolean dsb, boolean vsb);

	public void actTblBtnEdt(boolean dsb, boolean vsb);

	public void actTblBtnDlt(boolean dsb, boolean vsb);
}
