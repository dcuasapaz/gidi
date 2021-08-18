package ec.gob.inspi.gidi.sit.ctl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.gob.inspi.gidi.sit.cmm.Code;
import ec.gob.inspi.gidi.sit.cmm.Default;
import ec.gob.inspi.gidi.sit.cmm.Message;
import ec.gob.inspi.gidi.sit.ent.DtaTblPr;
import ec.gob.inspi.gidi.sit.itf.DtaItfPrs;
import ec.gob.inspi.gidi.sit.srv.DpaSrvCnr;
import ec.gob.inspi.gidi.sit.srv.DtaSrvPrs;

@ManagedBean
@ViewScoped
public class DtaCtlPrs implements DtaItfPrs {

	protected Message msg;
	protected Code cde;
	protected Default dfl;

	public DtaCtlPrs() {
		prs = new DtaTblPr();
		msg = new Message();
		cde = new Code();
		dfl = new Default();
	}

	@Override
	public void loadLstTblPrs() {
		try {
			lstTblPrs = new ArrayList<>();
			lstTblPrs = sPrs.srcAll();
			Collections.sort(lstTblPrs, new Comparator<DtaTblPr>() {
				public int compare(DtaTblPr o1, DtaTblPr o2) {
					return o1.getSPrsLstNme().compareTo(o2.getSPrsLstNme());
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	@PostConstruct
	public void init() {
		this.cptInit();
		this.loadLstTblPrs();
	}

	@Override
	public void cptInit() {
		this.actPgr(true, false);
		this.actTblBtnDlt(false, true);
		this.actTblBtnEdt(false, true);
		this.actBtnHme(false, true);
		this.actBtnAdd(false, true);
		this.actBtnSve(true, true);
		this.actBtnUpd(true, false);
		this.actBtnRtr(false, true);

	}

	@Override
	public void add() {
		try {
			prs = new DtaTblPr();
			ICnrId = 0;
			ICnrId = cde.dpaCnrEcd();
			IGrtId = 0;
			IIdnId = 0;
			IGndId = 0;
			this.actPgr(false, true);
			this.actBtnAdd(true, true);
			this.actBtnSve(false, true);
			this.actBtnHme(true, true);
			this.actPrsIdnTpe(false, true, false);
			this.actPrsIdn(false, true, false);
			this.actPrsGrt(false, true, true);
			this.actPrsNme(false, true, true);
			this.actPrsCnr(false, true, true);
			this.actPrsGnd(false, true, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void sve() {
		try {
			if (sPrs.save(prs, IIdnId, IGrtId, sCnr.searchId(ICnrId), IGndId) != false) {
				this.msg.msgInf(msg.msgSaveInf());
			} else {
				this.msg.msgErr(msg.msgSaveErr());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.init();
	}

	@Override
	public void edt() {
		try {
			this.actPgr(false, true);
			this.actBtnHme(true, true);
			this.actBtnAdd(true, true);
			this.actBtnSve(true, false);
			this.actBtnUpd(false, true);
			this.actPrsIdnTpe(false, true, false);
			this.actPrsIdn(false, true, false);
			this.actPrsGrt(false, true, true);
			this.actPrsNme(false, true, true);
			this.actPrsCnr(false, true, true);
			this.actPrsGnd(false, true, true);
			IIdnId = prs.getIIdnId();
			IGrtId = prs.getIGrtId();
			ICnrId = prs.getDpaTblCnr().getICnrId();
			IGndId = prs.getIGndCde();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void upd() {
		try {
			if (sPrs.update(prs, IIdnId, IGrtId, sCnr.searchId(ICnrId), IGndId) != false) {
				this.msg.msgInf(msg.msgUpdInf());
			} else {
				this.msg.msgErr(msg.msgUpdErr());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.init();
	}

	@Override
	public void dlt() {
		try {
			sPrs.delete(prs);
			this.msg.msgInf(msg.msgDltInf());
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.init();
	}

	/****************** ACCIONES PANELES *********************/
	private boolean vsbPgrTbl;
	private boolean vsbPgrDta;

	private void actPgr(boolean tbl, boolean dta) {
		vsbPgrTbl = tbl;
		vsbPgrDta = dta;
	}

	/****************** BOTONES FORMULARIO *********************/
	private boolean vsbBtnHme;
	private boolean dsbBtnHme;

	private void actBtnHme(boolean dsb, boolean vsb) {
		vsbBtnHme = vsb;
		dsbBtnHme = dsb;
	}

	private boolean vsbBtnAdd;
	private boolean dsbBtnAdd;

	private void actBtnAdd(boolean dsb, boolean vsb) {
		vsbBtnAdd = vsb;
		dsbBtnAdd = dsb;
	}

	private boolean vsbBtnSve;
	private boolean dsbBtnSve;

	private void actBtnSve(boolean dsb, boolean vsb) {
		vsbBtnSve = vsb;
		dsbBtnSve = dsb;
	}

	private boolean vsbBtnUpd;
	private boolean dsbBtnUpd;

	private void actBtnUpd(boolean dsb, boolean vsb) {
		vsbBtnUpd = vsb;
		dsbBtnUpd = dsb;
	}

	private boolean vsbBtnRtr;
	private boolean dsbBtnRtr;

	private void actBtnRtr(boolean dsb, boolean vsb) {
		vsbBtnRtr = vsb;
		dsbBtnRtr = dsb;
	}

	/****************** BOTONES TABLA *********************/

	private boolean dsbTblBtnEdt;
	private boolean vsbTblBtnEdt;

	private void actTblBtnEdt(boolean dsb, boolean vsb) {
		dsbTblBtnEdt = dsb;
		vsbTblBtnEdt = vsb;
	}

	private boolean dsbTblBtnDlt;
	private boolean vsbTblBtnDlt;

	private void actTblBtnDlt(boolean dsb, boolean vsb) {
		dsbTblBtnDlt = dsb;
		vsbTblBtnDlt = vsb;
	}

	/****************** PRS *********************/

	private boolean dsbPrsIdn;
	private boolean vsbPrsIdn;
	private boolean rqrPrsIdn;

	private void actPrsIdn(boolean dsb, boolean vsb, boolean rqr) {
		dsbPrsIdn = dsb;
		vsbPrsIdn = vsb;
		rqrPrsIdn = rqr;
	}

	private boolean dsbPrsNme;
	private boolean vsbPrsNme;
	private boolean rqrPrsNme;

	private void actPrsNme(boolean dsb, boolean vsb, boolean rqr) {
		dsbPrsNme = dsb;
		vsbPrsNme = vsb;
		rqrPrsNme = rqr;
	}

	private List<DtaTblPr> lstTblPrs;
	private DtaTblPr prs;
	@EJB
	protected DtaSrvPrs sPrs;

	@Override
	public List<DtaTblPr> loadPrs() {
		try {
			List<DtaTblPr> lstPrs = new ArrayList<DtaTblPr>();
			lstPrs = sPrs.srcAll();
			Collections.sort(lstPrs, new Comparator<DtaTblPr>() {
				public int compare(DtaTblPr o1, DtaTblPr o2) {
					return o1.getSPrsLstNme().compareTo(o2.getSPrsLstNme());
				}
			});
			return lstPrs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/****************** IDN-TPE *********************/
	private boolean dsbPrsIdnTpe;
	private boolean vsbPrsIdnTpe;
	private boolean rqrPrsIdnTpe;

	private void actPrsIdnTpe(boolean dsb, boolean vsb, boolean rqr) {
		dsbPrsIdnTpe = dsb;
		vsbPrsIdnTpe = vsb;
		rqrPrsIdnTpe = rqr;
	}

	private int IIdnId;

	public void chsIdn() {
		if (IIdnId == cde.dtaIdnNne()) {
			this.actPrsIdn(true, true, false);
		} else {
			this.actPrsIdn(false, true, true);
		}
	}

	/****************** GRT *********************/
	private boolean dsbPrsGrt;
	private boolean vsbPrsGrt;
	private boolean rqrPrsGrt;

	private void actPrsGrt(boolean dsb, boolean vsb, boolean rqr) {
		dsbPrsGrt = dsb;
		vsbPrsGrt = vsb;
		rqrPrsGrt = rqr;
	}

	private int IGrtId;

	/****************** CNR *********************/
	private boolean dsbPrsCnr;
	private boolean vsbPrsCnr;
	private boolean rqrPrsCnr;

	private void actPrsCnr(boolean dsb, boolean vsb, boolean rqr) {
		dsbPrsCnr = dsb;
		vsbPrsCnr = vsb;
		rqrPrsCnr = rqr;
	}

	private int ICnrId;
	@EJB
	protected DpaSrvCnr sCnr;

	/****************** GND *********************/
	private boolean dsbPrsGnd;
	private boolean vsbPrsGnd;
	private boolean rqrPrsGnd;

	private void actPrsGnd(boolean dsb, boolean vsb, boolean rqr) {
		dsbPrsGnd = dsb;
		vsbPrsGnd = vsb;
		rqrPrsGnd = rqr;
	}

	private int IGndId;

	public boolean isVsbPgrTbl() {
		return vsbPgrTbl;
	}

	public void setVsbPgrTbl(boolean vsbPgrTbl) {
		this.vsbPgrTbl = vsbPgrTbl;
	}

	public boolean isVsbPgrDta() {
		return vsbPgrDta;
	}

	public void setVsbPgrDta(boolean vsbPgrDta) {
		this.vsbPgrDta = vsbPgrDta;
	}

	public boolean isVsbBtnHme() {
		return vsbBtnHme;
	}

	public void setVsbBtnHme(boolean vsbBtnHme) {
		this.vsbBtnHme = vsbBtnHme;
	}

	public boolean isDsbBtnHme() {
		return dsbBtnHme;
	}

	public void setDsbBtnHme(boolean dsbBtnHme) {
		this.dsbBtnHme = dsbBtnHme;
	}

	public boolean isVsbBtnAdd() {
		return vsbBtnAdd;
	}

	public void setVsbBtnAdd(boolean vsbBtnAdd) {
		this.vsbBtnAdd = vsbBtnAdd;
	}

	public boolean isDsbBtnAdd() {
		return dsbBtnAdd;
	}

	public void setDsbBtnAdd(boolean dsbBtnAdd) {
		this.dsbBtnAdd = dsbBtnAdd;
	}

	public boolean isVsbBtnSve() {
		return vsbBtnSve;
	}

	public void setVsbBtnSve(boolean vsbBtnSve) {
		this.vsbBtnSve = vsbBtnSve;
	}

	public boolean isDsbBtnSve() {
		return dsbBtnSve;
	}

	public void setDsbBtnSve(boolean dsbBtnSve) {
		this.dsbBtnSve = dsbBtnSve;
	}

	public boolean isVsbBtnUpd() {
		return vsbBtnUpd;
	}

	public void setVsbBtnUpd(boolean vsbBtnUpd) {
		this.vsbBtnUpd = vsbBtnUpd;
	}

	public boolean isDsbBtnUpd() {
		return dsbBtnUpd;
	}

	public void setDsbBtnUpd(boolean dsbBtnUpd) {
		this.dsbBtnUpd = dsbBtnUpd;
	}

	public boolean isVsbBtnRtr() {
		return vsbBtnRtr;
	}

	public void setVsbBtnRtr(boolean vsbBtnRtr) {
		this.vsbBtnRtr = vsbBtnRtr;
	}

	public boolean isDsbBtnRtr() {
		return dsbBtnRtr;
	}

	public void setDsbBtnRtr(boolean dsbBtnRtr) {
		this.dsbBtnRtr = dsbBtnRtr;
	}

	public boolean isDsbTblBtnEdt() {
		return dsbTblBtnEdt;
	}

	public void setDsbTblBtnEdt(boolean dsbTblBtnEdt) {
		this.dsbTblBtnEdt = dsbTblBtnEdt;
	}

	public boolean isVsbTblBtnEdt() {
		return vsbTblBtnEdt;
	}

	public void setVsbTblBtnEdt(boolean vsbTblBtnEdt) {
		this.vsbTblBtnEdt = vsbTblBtnEdt;
	}

	public boolean isDsbTblBtnDlt() {
		return dsbTblBtnDlt;
	}

	public void setDsbTblBtnDlt(boolean dsbTblBtnDlt) {
		this.dsbTblBtnDlt = dsbTblBtnDlt;
	}

	public boolean isVsbTblBtnDlt() {
		return vsbTblBtnDlt;
	}

	public void setVsbTblBtnDlt(boolean vsbTblBtnDlt) {
		this.vsbTblBtnDlt = vsbTblBtnDlt;
	}

	public boolean isDsbPrsIdn() {
		return dsbPrsIdn;
	}

	public void setDsbPrsIdn(boolean dsbPrsIdn) {
		this.dsbPrsIdn = dsbPrsIdn;
	}

	public boolean isVsbPrsIdn() {
		return vsbPrsIdn;
	}

	public void setVsbPrsIdn(boolean vsbPrsIdn) {
		this.vsbPrsIdn = vsbPrsIdn;
	}

	public boolean isRqrPrsIdn() {
		return rqrPrsIdn;
	}

	public void setRqrPrsIdn(boolean rqrPrsIdn) {
		this.rqrPrsIdn = rqrPrsIdn;
	}

	public boolean isDsbPrsNme() {
		return dsbPrsNme;
	}

	public void setDsbPrsNme(boolean dsbPrsNme) {
		this.dsbPrsNme = dsbPrsNme;
	}

	public boolean isVsbPrsNme() {
		return vsbPrsNme;
	}

	public void setVsbPrsNme(boolean vsbPrsNme) {
		this.vsbPrsNme = vsbPrsNme;
	}

	public boolean isRqrPrsNme() {
		return rqrPrsNme;
	}

	public void setRqrPrsNme(boolean rqrPrsNme) {
		this.rqrPrsNme = rqrPrsNme;
	}

	public DtaTblPr getPrs() {
		return prs;
	}

	public void setPrs(DtaTblPr prs) {
		this.prs = prs;
	}

	public boolean isDsbPrsIdnTpe() {
		return dsbPrsIdnTpe;
	}

	public void setDsbPrsIdnTpe(boolean dsbPrsIdnTpe) {
		this.dsbPrsIdnTpe = dsbPrsIdnTpe;
	}

	public boolean isVsbPrsIdnTpe() {
		return vsbPrsIdnTpe;
	}

	public void setVsbPrsIdnTpe(boolean vsbPrsIdnTpe) {
		this.vsbPrsIdnTpe = vsbPrsIdnTpe;
	}

	public boolean isRqrPrsIdnTpe() {
		return rqrPrsIdnTpe;
	}

	public void setRqrPrsIdnTpe(boolean rqrPrsIdnTpe) {
		this.rqrPrsIdnTpe = rqrPrsIdnTpe;
	}

	public int getIIdnId() {
		return IIdnId;
	}

	public void setIIdnId(int iIdnId) {
		IIdnId = iIdnId;
	}

	public boolean isDsbPrsGrt() {
		return dsbPrsGrt;
	}

	public void setDsbPrsGrt(boolean dsbPrsGrt) {
		this.dsbPrsGrt = dsbPrsGrt;
	}

	public boolean isVsbPrsGrt() {
		return vsbPrsGrt;
	}

	public void setVsbPrsGrt(boolean vsbPrsGrt) {
		this.vsbPrsGrt = vsbPrsGrt;
	}

	public boolean isRqrPrsGrt() {
		return rqrPrsGrt;
	}

	public void setRqrPrsGrt(boolean rqrPrsGrt) {
		this.rqrPrsGrt = rqrPrsGrt;
	}

	public int getIGrtId() {
		return IGrtId;
	}

	public void setIGrtId(int iGrtId) {
		IGrtId = iGrtId;
	}

	public boolean isDsbPrsCnr() {
		return dsbPrsCnr;
	}

	public void setDsbPrsCnr(boolean dsbPrsCnr) {
		this.dsbPrsCnr = dsbPrsCnr;
	}

	public boolean isVsbPrsCnr() {
		return vsbPrsCnr;
	}

	public void setVsbPrsCnr(boolean vsbPrsCnr) {
		this.vsbPrsCnr = vsbPrsCnr;
	}

	public boolean isRqrPrsCnr() {
		return rqrPrsCnr;
	}

	public void setRqrPrsCnr(boolean rqrPrsCnr) {
		this.rqrPrsCnr = rqrPrsCnr;
	}

	public int getICnrId() {
		return ICnrId;
	}

	public void setICnrId(int iCnrId) {
		ICnrId = iCnrId;
	}

	public boolean isDsbPrsGnd() {
		return dsbPrsGnd;
	}

	public void setDsbPrsGnd(boolean dsbPrsGnd) {
		this.dsbPrsGnd = dsbPrsGnd;
	}

	public boolean isVsbPrsGnd() {
		return vsbPrsGnd;
	}

	public void setVsbPrsGnd(boolean vsbPrsGnd) {
		this.vsbPrsGnd = vsbPrsGnd;
	}

	public boolean isRqrPrsGnd() {
		return rqrPrsGnd;
	}

	public void setRqrPrsGnd(boolean rqrPrsGnd) {
		this.rqrPrsGnd = rqrPrsGnd;
	}

	public int getIGndId() {
		return IGndId;
	}

	public void setIGndId(int iGndId) {
		IGndId = iGndId;
	}

	public List<DtaTblPr> getLstTblPrs() {
		return lstTblPrs;
	}

	public void setLstTblPrs(List<DtaTblPr> lstTblPrs) {
		this.lstTblPrs = lstTblPrs;
	}

}
