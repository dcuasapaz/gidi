package ec.gob.inspi.gidi.sit.ctl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.gob.inspi.gidi.sit.cmm.Code;
import ec.gob.inspi.gidi.sit.ent.DtaTblOpt;
import ec.gob.inspi.gidi.sit.ent.DtaTblPr;
import ec.gob.inspi.gidi.sit.ent.DtaTblPrsEdc;
import ec.gob.inspi.gidi.sit.srv.DtaSrvOpt;
import ec.gob.inspi.gidi.sit.srv.DtaSrvPrsEdc;

@ManagedBean
@ViewScoped
public class DtaCtlPrsEdc {

	protected Code cde;

	public DtaCtlPrsEdc() {
		cde = new Code();
		prsEdc = new DtaTblPrsEdc();

		lstLvl = new ArrayList<DtaTblOpt>();
		ILvlId = 0;
	}

	@PostConstruct
	public void init() {
		this.loadPrsEdc(3);
		this.actBtnDtaPrsEdcNew(false, true);
		this.actBtnDtaPrsEdcSve(true, true);
		this.actBtnDtaPrsEdcRst(true, true);
		this.actBtnDtaPrsEdcDlt(false, true);
		this.actDtaPrsEdc(true, true, false);

	}

	public DtaTblPrsEdc edc(DtaTblPr prs) {
		try {
			return sPrsEdc.sngPrsEdc(prs);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private boolean dsbBtnDtaPrsEdcNew;
	private boolean vsbBtnDtaPrsEdcNew;

	private void actBtnDtaPrsEdcNew(boolean dsb, boolean vsb) {
		dsbBtnDtaPrsEdcNew = dsb;
		vsbBtnDtaPrsEdcNew = vsb;
	}

	private boolean dsbBtnDtaPrsEdcSve;
	private boolean vsbBtnDtaPrsEdcSve;

	private void actBtnDtaPrsEdcSve(boolean dsb, boolean vsb) {
		dsbBtnDtaPrsEdcSve = dsb;
		vsbBtnDtaPrsEdcSve = vsb;
	}

	private boolean dsbBtnDtaPrsEdcDlt;
	private boolean vsbBtnDtaPrsEdcDlt;

	private void actBtnDtaPrsEdcDlt(boolean dsb, boolean vsb) {
		dsbBtnDtaPrsEdcDlt = dsb;
		vsbBtnDtaPrsEdcDlt = vsb;
	}

	private boolean dsbBtnDtaPrsEdcRst;
	private boolean vsbBtnDtaPrsEdcRst;

	private void actBtnDtaPrsEdcRst(boolean dsb, boolean vsb) {
		dsbBtnDtaPrsEdcRst = dsb;
		vsbBtnDtaPrsEdcRst = vsb;
	}

	private boolean dsbDtaPrsEdc;
	private boolean vsbDtaPrsEdc;
	private boolean rqrDtaPrsEdc;

	private void actDtaPrsEdc(boolean dsb, boolean vsb, boolean rqr) {
		dsbDtaPrsEdc = dsb;
		vsbDtaPrsEdc = vsb;
		rqrDtaPrsEdc = rqr;
	}

	private List<DtaTblPrsEdc> lstPrsEdc;
	private int IPrsEdcId;
	private DtaTblPrsEdc prsEdc;
	@EJB
	protected DtaSrvPrsEdc sPrsEdc;

	private void newLstPrsEdc() {
		lstPrsEdc = new ArrayList<DtaTblPrsEdc>();
		IPrsEdcId = 0;
	}

	private void loadPrsEdc(int IPrsId) {
		try {
			this.newLstPrsEdc();
			lstPrsEdc = sPrsEdc.lstPrsEdc(IPrsId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newPrsEdc() {
		this.actDtaPrsEdc(false, true, false);
		this.actBtnDtaPrsEdcNew(true, true);
		this.actBtnDtaPrsEdcSve(false, true);
		this.actBtnDtaPrsEdcRst(false, true);
		lstLvl = new ArrayList<DtaTblOpt>();
		ILvlId = 0;
		lstLvl = this.loadDtaOpt(cde.dtaLvl());
		prsEdc = new DtaTblPrsEdc();
	}

	public void add() {

	}

	public void svePrsEdc() {
		try {
			prsEdc.getSEdcDsp();
			prsEdc.getSEdcDspSub();
			prsEdc.setILvlId(ILvlId);
			prsEdc.setIPrsId(3);
			sPrsEdc.insert(prsEdc);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void updPrsEdc() {

	}

	public void dltPrsEdc() {

	}

	public void rstPrsEdc() {

	}

	private List<DtaTblOpt> lstLvl;
	private int ILvlId;
	@EJB
	protected DtaSrvOpt sDtaOpt;

	private List<DtaTblOpt> loadDtaOpt(int IOptTpe) {
		try {
			return sDtaOpt.lstOpt(IOptTpe);
		} catch (Exception e) {

			return null;
		}
	}

	public List<DtaTblOpt> getLstLvl() {
		return lstLvl;
	}

	public void setLstLvl(List<DtaTblOpt> lstLvl) {
		this.lstLvl = lstLvl;
	}

	public int getILvlId() {
		return ILvlId;
	}

	public void setILvlId(int iLvlId) {
		ILvlId = iLvlId;
	}

	public List<DtaTblPrsEdc> getLstPrsEdc() {
		return lstPrsEdc;
	}

	public void setLstPrsEdc(List<DtaTblPrsEdc> lstPrsEdc) {
		this.lstPrsEdc = lstPrsEdc;
	}

	public int getIPrsEdcId() {
		return IPrsEdcId;
	}

	public void setIPrsEdcId(int iPrsEdcId) {
		IPrsEdcId = iPrsEdcId;
	}

	public DtaTblPrsEdc getPrsEdc() {
		return prsEdc;
	}

	public void setPrsEdc(DtaTblPrsEdc prsEdc) {
		this.prsEdc = prsEdc;
	}

	public boolean isDsbBtnDtaPrsEdcNew() {
		return dsbBtnDtaPrsEdcNew;
	}

	public void setDsbBtnDtaPrsEdcNew(boolean dsbBtnDtaPrsEdcNew) {
		this.dsbBtnDtaPrsEdcNew = dsbBtnDtaPrsEdcNew;
	}

	public boolean isVsbBtnDtaPrsEdcNew() {
		return vsbBtnDtaPrsEdcNew;
	}

	public void setVsbBtnDtaPrsEdcNew(boolean vsbBtnDtaPrsEdcNew) {
		this.vsbBtnDtaPrsEdcNew = vsbBtnDtaPrsEdcNew;
	}

	public boolean isDsbBtnDtaPrsEdcSve() {
		return dsbBtnDtaPrsEdcSve;
	}

	public void setDsbBtnDtaPrsEdcSve(boolean dsbBtnDtaPrsEdcSve) {
		this.dsbBtnDtaPrsEdcSve = dsbBtnDtaPrsEdcSve;
	}

	public boolean isVsbBtnDtaPrsEdcSve() {
		return vsbBtnDtaPrsEdcSve;
	}

	public void setVsbBtnDtaPrsEdcSve(boolean vsbBtnDtaPrsEdcSve) {
		this.vsbBtnDtaPrsEdcSve = vsbBtnDtaPrsEdcSve;
	}

	public boolean isDsbBtnDtaPrsEdcDlt() {
		return dsbBtnDtaPrsEdcDlt;
	}

	public void setDsbBtnDtaPrsEdcDlt(boolean dsbBtnDtaPrsEdcDlt) {
		this.dsbBtnDtaPrsEdcDlt = dsbBtnDtaPrsEdcDlt;
	}

	public boolean isVsbBtnDtaPrsEdcDlt() {
		return vsbBtnDtaPrsEdcDlt;
	}

	public void setVsbBtnDtaPrsEdcDlt(boolean vsbBtnDtaPrsEdcDlt) {
		this.vsbBtnDtaPrsEdcDlt = vsbBtnDtaPrsEdcDlt;
	}

	public boolean isDsbBtnDtaPrsEdcRst() {
		return dsbBtnDtaPrsEdcRst;
	}

	public void setDsbBtnDtaPrsEdcRst(boolean dsbBtnDtaPrsEdcRst) {
		this.dsbBtnDtaPrsEdcRst = dsbBtnDtaPrsEdcRst;
	}

	public boolean isVsbBtnDtaPrsEdcRst() {
		return vsbBtnDtaPrsEdcRst;
	}

	public void setVsbBtnDtaPrsEdcRst(boolean vsbBtnDtaPrsEdcRst) {
		this.vsbBtnDtaPrsEdcRst = vsbBtnDtaPrsEdcRst;
	}

	public boolean isDsbDtaPrsEdc() {
		return dsbDtaPrsEdc;
	}

	public void setDsbDtaPrsEdc(boolean dsbDtaPrsEdc) {
		this.dsbDtaPrsEdc = dsbDtaPrsEdc;
	}

	public boolean isVsbDtaPrsEdc() {
		return vsbDtaPrsEdc;
	}

	public void setVsbDtaPrsEdc(boolean vsbDtaPrsEdc) {
		this.vsbDtaPrsEdc = vsbDtaPrsEdc;
	}

	public boolean isRqrDtaPrsEdc() {
		return rqrDtaPrsEdc;
	}

	public void setRqrDtaPrsEdc(boolean rqrDtaPrsEdc) {
		this.rqrDtaPrsEdc = rqrDtaPrsEdc;
	}

}
