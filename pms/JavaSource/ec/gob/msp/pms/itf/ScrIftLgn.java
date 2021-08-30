package ec.gob.msp.pms.itf;

public interface ScrIftLgn {

	void actAtrPrsUsr(boolean dsb, boolean vsb, boolean rqr);

	void actAtrPrsPsw(boolean dsb, boolean vsb, boolean rqr);

	void actBtnLgn(boolean dsb, boolean vsb);

	void init();

	void login();
}
