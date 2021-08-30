package ec.gob.msp.pms.itf;

public interface DbIftGnr {

	void actSpcFrm(boolean tbl, boolean dta);

	void actBtnAdd(boolean dsb, boolean vsb);

	void actBtnSve(boolean dsb, boolean vsb);

	void actBtnUpd(boolean dsb, boolean vsb);

	void actBtnEdt(boolean dsb, boolean vsb);

	void actBtnDlt(boolean dsb, boolean vsb);

	void actBtnRfr(boolean dsb, boolean vsb);

	void init();

	void cptAdd();

	void add();

	void cptEdt();

	void edt();

	void cptSve();

	void sve();

	void cptUpd();

	void upd();

	void cptDlt();

	void dlt();

}
