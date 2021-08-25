package ec.gob.inspi.gidi.sit.ctl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import ec.gob.inspi.gidi.sit.cmm.Code;
import ec.gob.inspi.gidi.sit.cmm.Default;
import ec.gob.inspi.gidi.sit.cmm.Email;
import ec.gob.inspi.gidi.sit.cmm.Log;
import ec.gob.inspi.gidi.sit.cmm.Message;
import ec.gob.inspi.gidi.sit.cmm.Method;
import ec.gob.inspi.gidi.sit.cmm.Name;
import ec.gob.inspi.gidi.sit.cmm.Page;
import ec.gob.inspi.gidi.sit.ent.DpaTblCnr;
import ec.gob.inspi.gidi.sit.ent.DtaTblOpt;
import ec.gob.inspi.gidi.sit.ent.DtaTblPr;
import ec.gob.inspi.gidi.sit.ent.DtaTblPrsEdc;
import ec.gob.inspi.gidi.sit.ent.DtaTblPrsEml;
import ec.gob.inspi.gidi.sit.ent.DtaTblPrsPhn;
import ec.gob.inspi.gidi.sit.ent.InfTblStm;
import ec.gob.inspi.gidi.sit.ent.ScrTblPrsRol;
import ec.gob.inspi.gidi.sit.srv.DpaSrvCnr;
import ec.gob.inspi.gidi.sit.srv.DtaSrvOpt;
import ec.gob.inspi.gidi.sit.srv.DtaSrvPrs;
import ec.gob.inspi.gidi.sit.srv.DtaSrvPrsEdc;
import ec.gob.inspi.gidi.sit.srv.DtaSrvPrsEml;
import ec.gob.inspi.gidi.sit.srv.DtaSrvPrsPhn;
import ec.gob.inspi.gidi.sit.srv.InfSrvStm;
import ec.gob.inspi.gidi.sit.srv.ScrSrvPrsRol;

import javax.servlet.http.HttpSession;

import org.primefaces.event.RowEditEvent;


@ManagedBean
@ViewScoped
public class ScrCltPfl {

	protected Log log;
	protected Name nme;
	protected Page pge;
	protected Message msg;
	protected Email eml;
	protected Code cde;
	protected Method mth;
	protected Default dfl;

	protected ScrCtlSss sss;
	private HttpSession session;

	public ScrCltPfl() {

		log = new Log();
		nme = new Name();
		pge = new Page();
		msg = new Message();
		cde = new Code();
		mth = new Method();
		dfl = new Default();

		sss = new ScrCtlSss();
		prl = new ScrTblPrsRol();
		eml = new Email();

		lstGrt = new ArrayList<DtaTblOpt>();
		lstIdn = new ArrayList<DtaTblOpt>();
		lstPhnTpe = new ArrayList<DtaTblOpt>();
		lstEmlTpe = new ArrayList<DtaTblOpt>();
		prsPhn = new DtaTblPrsPhn();

		lstPrsPhn = new ArrayList<DtaTblPrsPhn>();

		prsEdc = new DtaTblPrsEdc();

		session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);

	}

	@PostConstruct
	public void init() {

		this.cptInit();
		this.newPhnTpe();
		this.newPrsEml();

		prl = this.loadPrl();
		
		emlAnt = prl.getDtaTblPr().getSPrsEml();
		usrAnt = prl.getDtaTblPr().getSPrsUsr();
		this.loadEml();

		this.loadPrsRol(prl.getDtaTblPr());
		lstGrt = this.loadDtaOpt(cde.dtaGrt());
		IGrtId = prl.getDtaTblPr().getIGrtId();

		lstIdn = this.loadDtaOpt(cde.dtaIdn());
		IIdnId = prl.getDtaTblPr().getIIdnId();

		lstGnd = this.loadDtaOpt(cde.dtaGnd());
		IGndCde = prl.getDtaTblPr().getIGndCde();

		lstPhnTpe = this.loadDtaOpt(cde.dtaPhnTpe());

		this.loadPrsPhn(prl.getDtaTblPr().getIPrsId());

		this.loadCnr();
		ICnrId = prl.getDtaTblPr().getDpaTblCnr().getICnrId();

		/******************************************************/
		/** DTA-EDC **/
		this.loadPrsEdc(prl.getDtaTblPr().getIPrsId());
		this.actDtaPrsEdc(true, true, false);
		this.actBtnDtaPrsEdcNew(false, true);
		this.actBtnDtaPrsEdcSve(true, true);
		this.actBtnDtaPrsEdcRst(true, true);
		this.actBtnDtaPrsEdcDlt(false, true);
		this.actDtaPrsEdcLvl(false, true, false);
		lstLvlSrc = this.loadDtaOpt(cde.dtaLvl());
		/******************************************************/
		/** DTA-EML **/
		this.loadPrsEml(prl.getDtaTblPr().getIPrsId());
		this.actDtaPrsEml(true, true, false);
		this.actBtnDtaPrsEmlNew(false, true);
		this.actBtnDtaPrsEmlSve(true, true);
		this.actBtnDtaPrsEmlRst(true, true);
		this.actBtnDtaPrsEmlDlt(false, true);
		this.actDtaPrsEmlTpe(false, true, false);
		lstEmlTpe = this.loadDtaOpt(cde.dtaEmlTpe());
		/******************************************************/

	}

	private void cptInit() {

		this.actPrsEml(false, true, true);
		this.actPrsUsr(false, true, true);
		this.actPrsPsw(false, true, true);
		this.actPrs(false, true, true);

		this.actPnlPrsPhn(false, true);
		this.actPrsPhn(true, true, false);
		this.actBtnSvePrsPhn(true, true);
		this.actBtnRstPrsPhn(true, true);

	}

	protected String emlAnt;
	protected String usrAnt;
	private boolean dsbPrsEml;
	private boolean vsbPrsEml;
	private boolean rqrPrsEml;

	private void actPrsEml(boolean dsb, boolean vsb, boolean rqr) {
		dsbPrsEml = dsb;
		vsbPrsEml = vsb;
		rqrPrsEml = rqr;
	}

	private boolean dsbPrsUsr;
	private boolean vsbPrsUsr;
	private boolean rqrPrsUsr;

	private void actPrsUsr(boolean dsb, boolean vsb, boolean rqr) {
		dsbPrsUsr = dsb;
		vsbPrsUsr = vsb;
		rqrPrsUsr = rqr;
	}

	private boolean dsbPrsPsw;
	private boolean vsbPrsPsw;
	private boolean rqrPrsPsw;

	private void actPrsPsw(boolean dsb, boolean vsb, boolean rqr) {
		dsbPrsPsw = dsb;
		vsbPrsPsw = vsb;
		rqrPrsPsw = rqr;
	}

	private boolean dsbPrs;
	private boolean vsbPrs;
	private boolean rqrPrs;

	private void actPrs(boolean dsb, boolean vsb, boolean rqr) {
		dsbPrs = dsb;
		vsbPrs = vsb;
		rqrPrs = rqr;
	}

	@EJB
	protected DtaSrvPrs sprs;

	public void chsTpePhn() {
		this.log.impMsg("Chosse", "TpePrsPhn");
	}

	private boolean dsbPrsPhn;
	private boolean vsbPrsPhn;
	private boolean rqrPrsPhn;

	private boolean dsbPnlPrsPhn;
	private boolean vsbPnlPrsPhn;

	private boolean dsbBtnSvePrsPhn;
	private boolean vsbBtnSvePrsPhn;

	private boolean dsbBtnRstPrsPhn;
	private boolean vsbBtnRstPrsPhn;

	private void actPrsPhn(boolean dsb, boolean vsb, boolean rqr) {
		dsbPrsPhn = dsb;
		vsbPrsPhn = vsb;
		rqrPrsPhn = rqr;
	}

	private void actPnlPrsPhn(boolean dsb, boolean vsb) {
		dsbPnlPrsPhn = dsb;
		vsbPnlPrsPhn = vsb;
	}

	private void actBtnSvePrsPhn(boolean dsb, boolean vsb) {
		dsbBtnSvePrsPhn = dsb;
		vsbBtnSvePrsPhn = vsb;
	}

	private void actBtnRstPrsPhn(boolean dsb, boolean vsb) {
		dsbBtnRstPrsPhn = dsb;
		vsbBtnRstPrsPhn = vsb;
	}

	private List<DtaTblPrsPhn> lstPrsPhn;
	private DtaTblPrsPhn prsPhn;
	@EJB
	protected DtaSrvPrsPhn sPrsPhn;

	private void newPhnTpe() {
		prsPhn = new DtaTblPrsPhn();
		lstPhnTpe = new ArrayList<DtaTblOpt>();
		IPhnTpeId = 0;
	}

	private void loadPrsPhn(int IPrsId) {
		try {
			lstPrsPhn = sPrsPhn.lstPrsPhn(IPrsId);
		} catch (Exception e) {
			this.log.impCtl(ScrCltPfl.class.getSimpleName(), nme.evnLoad(), nme.actAdd(),
					DtaTblPrsPhn.class.getSimpleName(), e.getMessage());
		}
	}

	public void addPrsPhn() {
		this.actPrsPhn(false, true, false);
		this.actBtnSvePrsPhn(false, true);
		this.actBtnRstPrsPhn(false, true);
		this.newPrsPhn();
		lstPhnTpe = this.loadDtaOpt(cde.dtaPhnTpe());
	}

	private void newPrsPhn() {
		prsPhn = new DtaTblPrsPhn();
		lstPhnTpe = new ArrayList<DtaTblOpt>();
		IPhnTpeId = 0;
	}

	public void savePrsPhn() {
		try {
			prsPhn.setIPrsId(prl.getDtaTblPr().getIPrsId());
			prsPhn.setDPhnDteRgs(dfl.dCurrentDate());
			prsPhn.setSPhnTmeRgs(dfl.currentTime());
			prsPhn.setITpeId(IPhnTpeId);
			sPrsPhn.insert(prsPhn);
			this.msg.msgInf(msg.msgSaveInf());
			this.actPrsPhn(true, true, false);
			this.actBtnSvePrsPhn(true, true);
			this.actBtnRstPrsPhn(true, true);
			this.actPnlPrsPhn(true, true);
			this.loadPrsPhn(prl.getDtaTblPr().getIPrsId());
			this.newPrsPhn();
		} catch (Exception e) {
			this.log.impCtl(ScrCltPfl.class.getSimpleName(), nme.evnSlc(), nme.actUpd(),
					DtaTblPrsPhn.class.getSimpleName(), e.getLocalizedMessage());
			e.printStackTrace();
			this.msg.msgWrn(msg.msgErrSave());
		}
	}

	public void updPrsPhn1(RowEditEvent event) {
		try {
			this.actPrs(false, true, true);
			DtaTblPrsPhn aux = new DtaTblPrsPhn();
			aux = (DtaTblPrsPhn) event.getObject();
			sPrsPhn.update(aux);
			this.msg.msgInf(msg.msgUpdInf());
		} catch (Exception e) {
			this.log.impCtl(ScrCltPfl.class.getSimpleName(), nme.evnSlc(), nme.actUpd(),
					DtaTblPrsPhn.class.getSimpleName(), e.getLocalizedMessage());
			e.printStackTrace();
			this.msg.msgWrn(msg.msgErrUpd());
		}

	}

	public void updPrsPhn(DtaTblPrsPhn aux) {
		try {
			this.actPrs(false, true, true);
			sPrsPhn.update(aux);
			this.msg.msgInf(msg.msgUpdInf());
		} catch (Exception e) {
			this.log.impCtl(ScrCltPfl.class.getSimpleName(), nme.evnSlc(), nme.actUpd(),
					DtaTblPrsPhn.class.getSimpleName(), e.getLocalizedMessage());
			e.printStackTrace();
			this.msg.msgWrn(msg.msgErrUpd());
		}

	}

	public void updPrsPhnTpe(DtaTblPrsPhn aux, int IPhnTpeId) {
		try {
			this.actPrs(false, true, true);
			aux.setITpeId(IPhnTpeId);
			sPrsPhn.update(aux);
			this.msg.msgInf(msg.msgUpdInf());
		} catch (Exception e) {
			this.log.impCtl(ScrCltPfl.class.getSimpleName(), nme.evnSlc(), nme.actUpd(),
					DtaTblPrsPhn.class.getSimpleName(), e.getLocalizedMessage());
			e.printStackTrace();
			this.msg.msgWrn(msg.msgErrUpd());
		}

	}

	public void dltPrsPhn() {
		try {
			sPrsPhn.delete(prsPhn);
			this.msg.msgInf(msg.msgDltInf());
			this.loadPrsPhn(prl.getDtaTblPr().getIPrsId());
			this.newPrsPhn();
		} catch (Exception e) {
			this.log.impCtl(ScrCltPfl.class.getSimpleName(), nme.evnSlc(), nme.actDlt(),
					DtaTblPrsPhn.class.getSimpleName(), e.getLocalizedMessage());
			e.printStackTrace();
		}
	}

	public void rstPrsPhn() {
		this.actPrsPhn(true, false, false);
		this.actBtnSvePrsPhn(true, false);
		this.actBtnRstPrsPhn(true, false);
		this.actPnlPrsPhn(true, false);
	}

	private List<DpaTblCnr> lstCnr;
	private int ICnrId;
	@EJB
	protected DpaSrvCnr scnr;

	private void newCnr() {
		lstCnr = new ArrayList<DpaTblCnr>();
		ICnrId = 0;
	}

	private void loadCnr() {
		try {
			this.newCnr();
			lstCnr = scnr.srcAll();
		} catch (Exception e) {
			this.log.impCtl(ScrCltPfl.class.getSimpleName(), nme.evnLoad(), nme.actAdd(),
					DtaTblOpt.class.getSimpleName(), e.getMessage());
		}
	}

	protected InfTblStm stm;
	@EJB
	protected InfSrvStm sstm;

	protected void loadEml() {
		try {
			List<InfTblStm> lstStmAux = new ArrayList<InfTblStm>();
			lstStmAux = sstm.srcAll();
			Collections.sort(lstStmAux, new Comparator<InfTblStm>() {
				@Override
				public int compare(InfTblStm o1, InfTblStm o2) {
					return o1.getIStmId().compareTo(o2.getIStmId());
				}
			});
			stm = sstm.searchId(lstStmAux.get(0).getIStmId());
		} catch (Exception e) {
			this.log.impCtl(ScrCltPfl.class.getSimpleName(), nme.evnLoad(), nme.actAdd(),
					InfTblStm.class.getSimpleName(), e.getMessage());
			e.printStackTrace();
		}

	}

	public void UpdPrsEml() {
		try {
			this.actPrsEml(false, true, true);
			sprs.update(prl.getDtaTblPr());
			session.setAttribute("prl", prl);
			this.msg.msgInf(msg.msgUpdInf());
		} catch (Exception e) {
			this.log.impCtl(ScrCltPfl.class.getSimpleName(), nme.evnSlc(), nme.actUpd(), DtaTblPr.class.getSimpleName(),
					e.getLocalizedMessage());
			e.printStackTrace();
			prl = this.loadPrl();
			this.msg.msgWrn(msg.msgErrUpd());
		}
	}

	public void UpdPrsUsr() {
		try {
			this.actPrsUsr(false, true, true);
			sprs.update(prl.getDtaTblPr());
			session.setAttribute("prl", prl);
			this.msg.msgInf(msg.msgUpdInf());
			this.actPrsUsr(true, true, false);
		} catch (Exception e) {
			this.log.impCtl(ScrCltPfl.class.getSimpleName(), nme.evnSlc(), nme.actUpd(), DtaTblPr.class.getSimpleName(),
					e.getLocalizedMessage());
			e.printStackTrace();
			prl = this.loadPrl();
			this.msg.msgWrn(msg.msgErrUpd());
		}
	}

	public void UpdPrsPsw() {
		try {
			this.actPrsPsw(false, true, true);
			prl.getDtaTblPr().setSPrsPsw(prl.getDtaTblPr().getSPrsPsw());
			sprs.update(prl.getDtaTblPr());
			session.setAttribute("prl", prl);
			this.msg.msgInf(msg.msgUpdInf());
			this.actPrsPsw(true, true, false);
		} catch (Exception e) {
			this.log.impCtl(ScrCltPfl.class.getSimpleName(), nme.evnSlc(), nme.actUpd(), DtaTblPr.class.getSimpleName(),
					e.getLocalizedMessage());
			e.printStackTrace();
			prl = this.loadPrl();
			this.msg.msgWrn(msg.msgErrUpd());
		}
	}

	public void UpdPrs() {
		try {
			this.actPrs(false, true, true);
			prl.getDtaTblPr().setIGndCde(IGndCde);
			prl.getDtaTblPr().setDpaTblCnr(scnr.searchId(ICnrId));
			prl.getDtaTblPr().setIIdnId(IIdnId);
			prl.getDtaTblPr().setIGrtId(IGrtId);
			sprs.update(prl.getDtaTblPr());
			session.setAttribute("prl", prl);
			this.msg.msgInf(msg.msgUpdInf());
			this.actPrs(true, true, false);
		} catch (Exception e) {
			this.log.impCtl(ScrCltPfl.class.getSimpleName(), nme.evnSlc(), nme.actUpd(), DtaTblPr.class.getSimpleName(),
					e.getLocalizedMessage());
			e.printStackTrace();
			prl = this.loadPrl();
			this.msg.msgWrn(msg.msgErrUpd());
		}
	}

	public void UpdPrsIdn() {
		try {
			if (IIdnId == cde.dtaIdnCdl()) {
				if (mth.validarCedula(prl.getDtaTblPr().getSPrsIdn())) {
					this.actPrs(false, true, true);
					sprs.update(prl.getDtaTblPr());
					session.setAttribute("prl", prl);
					this.msg.msgInf(msg.msgUpdInf());
				} else {
					this.msg.cmpIdnInc();
				}
			} else {
				this.actPrs(false, true, true);
				sprs.update(prl.getDtaTblPr());
				session.setAttribute("prl", prl);
				this.msg.msgInf(msg.msgUpdInf());
			}
		} catch (Exception e) {
			this.log.impCtl(ScrCltPfl.class.getSimpleName(), nme.evnSlc(), nme.actUpd(), DtaTblPr.class.getSimpleName(),
					e.getLocalizedMessage());
			e.printStackTrace();
			prl = this.loadPrl();
			this.msg.msgWrn(msg.msgErrUpd());
		}
	}

	private ScrTblPrsRol prl;
	private List<ScrTblPrsRol> lstPrsRol;
	@EJB
	protected ScrSrvPrsRol sPrsRol;

	private void newPrsRol() {
		lstPrsRol = new ArrayList<ScrTblPrsRol>();
	}

	public ScrTblPrsRol loadPrl() {
		try {
			return sss.getPrl();
		} catch (Exception e) {
			this.log.impCtl(ScrCltPfl.class.getSimpleName(), nme.evnLoad(), nme.actAdd(),
					ScrTblPrsRol.class.getSimpleName(), e.getMessage());
			e.printStackTrace();
			try {
				FacesContext contex = FacesContext.getCurrentInstance();
				contex.getExternalContext().redirect(pge.urlErrorSss());
			} catch (IOException eX) {
				this.log.impCtl(ScrCltPfl.class.getSimpleName(), nme.evnInit(), nme.actSrc(),
						ScrTblPrsRol.class.getSimpleName(), eX.getMessage());
				e.printStackTrace();
			}

			return null;
		}
	}

	private void loadPrsRol(DtaTblPr prs) {
		try {
			this.newPrsRol();
			lstPrsRol = sPrsRol.lstPrsRol(prs);
			Collections.sort(lstPrsRol, new Comparator<ScrTblPrsRol>() {
				@Override
				public int compare(ScrTblPrsRol o1, ScrTblPrsRol o2) {
					return o1.getIRolId().compareTo(o2.getIRolId());
				}
			});
		} catch (Exception e) {
			this.log.impCtl(ScrCltPfl.class.getSimpleName(), nme.evnInit(), nme.actSrc(),
					ScrTblPrsRol.class.getSimpleName(), e.getMessage());
			e.printStackTrace();
		}
	}

	/*
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ------------------------- MODULE: Dta -------------------------
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */
	/****************************************************************/
	/** 01: DtaTblPrsEdc **/
	/****************************************************************/

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

	private boolean dsbDtaPrsEdcLvl;
	private boolean vsbDtaPrsEdcLvl;
	private boolean rqrDtaPrsEdcLvl;

	private void actDtaPrsEdcLvl(boolean dsb, boolean vsb, boolean rqr) {
		dsbDtaPrsEdcLvl = dsb;
		vsbDtaPrsEdcLvl = vsb;
		rqrDtaPrsEdcLvl = rqr;
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
			Collections.sort(lstPrsEdc, new Comparator<DtaTblPrsEdc>() {
				@Override
				public int compare(DtaTblPrsEdc o1, DtaTblPrsEdc o2) {
					return o1.getIEdcId().compareTo(o2.getIEdcId());
				}
			});
		} catch (Exception e) {
			this.log.impCtl(ScrCltPfl.class.getSimpleName(), nme.evnInit(), nme.actSrc(),
					ScrTblPrsRol.class.getSimpleName(), e.getMessage());
			e.printStackTrace();
		}
	}

	public void addPrsEdc() {
		this.actDtaPrsEdc(false, true, false);
		this.actBtnDtaPrsEdcNew(true, true);
		this.actBtnDtaPrsEdcSve(false, true);
		this.actBtnDtaPrsEdcRst(false, true);
		this.newPrsEdc();
		lstLvl = this.loadDtaOpt(cde.dtaLvl());
	}

	private void newPrsEdc() {
		lstLvl = new ArrayList<DtaTblOpt>();
		ILvlId = 0;
		prsEdc = new DtaTblPrsEdc();
	}

	public void svePrsEdc() {
		try {
			prsEdc.setSEdcTmeRgs(dfl.currentTime());
			prsEdc.setDEdcDteRgs(dfl.dCurrentDate());
			prsEdc.setSEdcDsp(mth.mtdStrNmb(prsEdc.getSEdcDsp()));
			prsEdc.setSEdcDspSub(mth.mtdStrNmb(prsEdc.getSEdcDspSub()));
			prsEdc.setILvlId(ILvlId);
			prsEdc.setIPrsId(prl.getDtaTblPr().getIPrsId());
			sPrsEdc.insert(prsEdc);
			this.msg.msgInf(msg.msgSaveInf());
			this.loadPrsEdc(prl.getDtaTblPr().getIPrsId());
			this.actDtaPrsEdc(true, true, false);
			this.actBtnDtaPrsEdcNew(false, true);
			this.actBtnDtaPrsEdcSve(true, true);
			this.actBtnDtaPrsEdcRst(true, true);
			this.newPrsEdc();
		} catch (Exception e) {
			this.log.impCtl(ScrCltPfl.class.getSimpleName(), nme.evnInit(), nme.actSave(),
					DtaTblPrsEdc.class.getSimpleName(), e.getMessage());
			e.printStackTrace();
		}
	}

	public void UpdPrsEdcLvl(DtaTblPrsEdc prsEdc, int ILvlId) {
		try {
			this.actDtaPrsEdcLvl(false, true, true);
			prsEdc.setSEdcDsp(mth.mtdStrNmb(prsEdc.getSEdcDsp()));
			prsEdc.setSEdcDspSub(mth.mtdStrNmb(prsEdc.getSEdcDspSub()));
			prsEdc.setILvlId(ILvlId);
			sPrsEdc.update(prsEdc);
			this.msg.msgInf(msg.msgUpdInf());
			this.loadPrsEdc(prl.getDtaTblPr().getIPrsId());
		} catch (Exception e) {
			this.log.impCtl(ScrCltPfl.class.getSimpleName(), nme.evnInit(), nme.actUpd(),
					DtaTblPrsEdc.class.getSimpleName(), e.getMessage());
			e.printStackTrace();
		}
	}

	public void updPrsEdc(DtaTblPrsEdc prsEdc) {
		try {
			this.actDtaPrsEdcLvl(false, true, true);
			prsEdc.setSEdcDsp(mth.mtdStrNmb(prsEdc.getSEdcDsp()));
			prsEdc.setSEdcDspSub(mth.mtdStrNmb(prsEdc.getSEdcDspSub()));
			sPrsEdc.update(prsEdc);
			this.msg.msgInf(msg.msgUpdInf());
			this.loadPrsEdc(prl.getDtaTblPr().getIPrsId());
		} catch (Exception e) {
			this.log.impCtl(ScrCltPfl.class.getSimpleName(), nme.evnInit(), nme.actUpd(),
					DtaTblPrsEdc.class.getSimpleName(), e.getMessage());
			e.printStackTrace();
		}
	}

	public void dltPrsEdc() {
		try {
			sPrsEdc.delete(prsEdc);
			this.msg.msgInf(msg.msgDltInf());
			this.loadPrsEdc(prl.getDtaTblPr().getIPrsId());
			this.newPrsEdc();
		} catch (Exception e) {
			this.log.impCtl(ScrCltPfl.class.getSimpleName(), nme.evnInit(), nme.actDlt(),
					DtaTblPrsEdc.class.getSimpleName(), e.getMessage());
			e.printStackTrace();
		}
	}

	public void rstPrsEdc() {
		this.actDtaPrsEdc(true, true, false);
		this.actBtnDtaPrsEdcNew(false, true);
		this.actBtnDtaPrsEdcSve(true, true);
		this.actBtnDtaPrsEdcRst(true, true);
		this.newPrsEdc();
	}

	/****************************************************************/
	/** 02: DtaTblPrsOpt **/
	/****************************************************************/
	private List<DtaTblOpt> lstGrt;
	private int IGrtId;
	private List<DtaTblOpt> lstIdn;
	private int IIdnId;
	private List<DtaTblOpt> lstGnd;
	private int IGndCde;
	private List<DtaTblOpt> lstPhnTpe;
	private int IPhnTpeId;
	private List<DtaTblOpt> lstEmlTpe;
	private int IEmlTpeId;
	private List<DtaTblOpt> lstLvl;
	private int ILvlId;
	private List<DtaTblOpt> lstLvlSrc;
	private int ILvlSrcId;
	@EJB
	protected DtaSrvOpt sDtaOpt;

	private List<DtaTblOpt> loadDtaOpt(int IOptTpe) {
		try {
			return sDtaOpt.lstOpt(IOptTpe);
		} catch (Exception e) {
			this.log.impCtl(ScrCltPfl.class.getSimpleName(), nme.evnLoad(), nme.actAdd(),
					DtaTblOpt.class.getSimpleName(), e.getMessage());
			return null;
		}
	}

	/****************************************************************/
	/** 03: DtaTblPrsEml **/
	/****************************************************************/

	private boolean dsbBtnDtaPrsEmlNew;
	private boolean vsbBtnDtaPrsEmlNew;

	private void actBtnDtaPrsEmlNew(boolean dsb, boolean vsb) {
		dsbBtnDtaPrsEmlNew = dsb;
		vsbBtnDtaPrsEmlNew = vsb;
	}

	private boolean dsbBtnDtaPrsEmlSve;
	private boolean vsbBtnDtaPrsEmlSve;

	private void actBtnDtaPrsEmlSve(boolean dsb, boolean vsb) {
		dsbBtnDtaPrsEmlSve = dsb;
		vsbBtnDtaPrsEmlSve = vsb;
	}

	private boolean dsbBtnDtaPrsEmlDlt;
	private boolean vsbBtnDtaPrsEmlDlt;

	private void actBtnDtaPrsEmlDlt(boolean dsb, boolean vsb) {
		dsbBtnDtaPrsEmlDlt = dsb;
		vsbBtnDtaPrsEmlDlt = vsb;
	}

	private boolean dsbBtnDtaPrsEmlRst;
	private boolean vsbBtnDtaPrsEmlRst;

	private void actBtnDtaPrsEmlRst(boolean dsb, boolean vsb) {
		dsbBtnDtaPrsEmlRst = dsb;
		vsbBtnDtaPrsEmlRst = vsb;
	}

	private boolean dsbDtaPrsEml;
	private boolean vsbDtaPrsEml;
	private boolean rqrDtaPrsEml;

	private void actDtaPrsEml(boolean dsb, boolean vsb, boolean rqr) {
		dsbDtaPrsEml = dsb;
		vsbDtaPrsEml = vsb;
		rqrDtaPrsEml = rqr;
	}

	private boolean dsbDtaPrsEmlTpe;
	private boolean vsbDtaPrsEmlTpe;
	private boolean rqrDtaPrsEmlTpe;

	private void actDtaPrsEmlTpe(boolean dsb, boolean vsb, boolean rqr) {
		dsbDtaPrsEmlTpe = dsb;
		vsbDtaPrsEmlTpe = vsb;
		rqrDtaPrsEmlTpe = rqr;
	}

	private List<DtaTblPrsEml> lstPrsEml;
	private DtaTblPrsEml prsEml;
	@EJB
	protected DtaSrvPrsEml sPrsEml;

	private void loadPrsEml(int IPrsId) {
		try {
			lstPrsEml = sPrsEml.lstPrsEml(IPrsId);
		} catch (Exception e) {
			this.log.impCtl(ScrCltPfl.class.getSimpleName(), nme.evnLoad(), nme.actAdd(),
					DtaTblPrsEml.class.getSimpleName(), e.getMessage());
		}
	}

	public void addPrsEml() {
		this.actDtaPrsEml(false, true, false);
		this.actBtnDtaPrsEmlNew(true, true);
		this.actBtnDtaPrsEmlSve(false, true);
		this.actBtnDtaPrsEmlRst(false, true);
		this.newPrsEml();
		lstEmlTpe = this.loadDtaOpt(cde.dtaEmlTpe());
	}

	private void newPrsEml() {
		prsEml = new DtaTblPrsEml();
		lstEmlTpe = new ArrayList<DtaTblOpt>();
		IEmlTpeId = 0;
	}

	public void savePrsEml() {
		try {
			prsEml.setIPrsId(prl.getDtaTblPr().getIPrsId());
			prsEml.setDEmlDteRgs(dfl.dCurrentDate());
			prsEml.setSEmlTmeRgs(dfl.currentTime());
			prsEml.setITpeId(IEmlTpeId);
			sPrsEml.insert(prsEml);
			this.msg.msgInf(msg.msgSaveInf());
			this.actDtaPrsEml(true, true, false);
			this.actBtnDtaPrsEmlNew(false, true);
			this.actBtnDtaPrsEmlSve(true, true);
			this.actBtnDtaPrsEmlRst(true, true);
			this.loadPrsEml(prl.getDtaTblPr().getIPrsId());
			this.newPrsEml();
		} catch (Exception e) {
			this.log.impCtl(ScrCltPfl.class.getSimpleName(), nme.evnSlc(), nme.actUpd(),
					DtaTblPrsEml.class.getSimpleName(), e.getLocalizedMessage());
			e.printStackTrace();
			this.msg.msgWrn(msg.msgErrSave());
		}
	}

	public void updPrsEml(DtaTblPrsEml aux) {
		try {
			sPrsEml.update(aux);
			this.msg.msgInf(msg.msgUpdInf());
		} catch (Exception e) {
			this.log.impCtl(ScrCltPfl.class.getSimpleName(), nme.evnSlc(), nme.actUpd(),
					DtaTblPrsEml.class.getSimpleName(), e.getLocalizedMessage());
			e.printStackTrace();
			this.msg.msgWrn(msg.msgErrUpd());
		}

	}

	public void updPrsEmlTpe(DtaTblPrsEml aux, int IEmlTpeId) {
		try {
			this.actDtaPrsEmlTpe(false, true, true);
			aux.setITpeId(IEmlTpeId);
			sPrsEml.update(aux);
			this.msg.msgInf(msg.msgUpdInf());
		} catch (Exception e) {
			this.log.impCtl(ScrCltPfl.class.getSimpleName(), nme.evnSlc(), nme.actUpd(),
					DtaTblPrsEml.class.getSimpleName(), e.getLocalizedMessage());
			e.printStackTrace();
			this.msg.msgWrn(msg.msgErrUpd());
		}

	}

	public void dltPrsEml() {
		try {
			sPrsEml.delete(prsEml);
			this.msg.msgInf(msg.msgDltInf());
			this.loadPrsEml(prl.getDtaTblPr().getIPrsId());
			this.newPrsEml();
		} catch (Exception e) {
			this.log.impCtl(ScrCltPfl.class.getSimpleName(), nme.evnSlc(), nme.actDlt(),
					DtaTblPrsEml.class.getSimpleName(), e.getLocalizedMessage());
			e.printStackTrace();
		}
	}

	public void rstPrsEml() {

	}

	public List<DtaTblOpt> getLstEmlTpe() {
		return lstEmlTpe;
	}

	public void setLstEmlTpe(List<DtaTblOpt> lstEmlTpe) {
		this.lstEmlTpe = lstEmlTpe;
	}

	public int getIEmlTpeId() {
		return IEmlTpeId;
	}

	public void setIEmlTpeId(int iEmlTpeId) {
		IEmlTpeId = iEmlTpeId;
	}

	public boolean isDsbBtnDtaPrsEmlNew() {
		return dsbBtnDtaPrsEmlNew;
	}

	public void setDsbBtnDtaPrsEmlNew(boolean dsbBtnDtaPrsEmlNew) {
		this.dsbBtnDtaPrsEmlNew = dsbBtnDtaPrsEmlNew;
	}

	public boolean isVsbBtnDtaPrsEmlNew() {
		return vsbBtnDtaPrsEmlNew;
	}

	public void setVsbBtnDtaPrsEmlNew(boolean vsbBtnDtaPrsEmlNew) {
		this.vsbBtnDtaPrsEmlNew = vsbBtnDtaPrsEmlNew;
	}

	public boolean isDsbBtnDtaPrsEmlSve() {
		return dsbBtnDtaPrsEmlSve;
	}

	public void setDsbBtnDtaPrsEmlSve(boolean dsbBtnDtaPrsEmlSve) {
		this.dsbBtnDtaPrsEmlSve = dsbBtnDtaPrsEmlSve;
	}

	public boolean isVsbBtnDtaPrsEmlSve() {
		return vsbBtnDtaPrsEmlSve;
	}

	public void setVsbBtnDtaPrsEmlSve(boolean vsbBtnDtaPrsEmlSve) {
		this.vsbBtnDtaPrsEmlSve = vsbBtnDtaPrsEmlSve;
	}

	public boolean isDsbBtnDtaPrsEmlDlt() {
		return dsbBtnDtaPrsEmlDlt;
	}

	public void setDsbBtnDtaPrsEmlDlt(boolean dsbBtnDtaPrsEmlDlt) {
		this.dsbBtnDtaPrsEmlDlt = dsbBtnDtaPrsEmlDlt;
	}

	public boolean isVsbBtnDtaPrsEmlDlt() {
		return vsbBtnDtaPrsEmlDlt;
	}

	public void setVsbBtnDtaPrsEmlDlt(boolean vsbBtnDtaPrsEmlDlt) {
		this.vsbBtnDtaPrsEmlDlt = vsbBtnDtaPrsEmlDlt;
	}

	public boolean isDsbBtnDtaPrsEmlRst() {
		return dsbBtnDtaPrsEmlRst;
	}

	public void setDsbBtnDtaPrsEmlRst(boolean dsbBtnDtaPrsEmlRst) {
		this.dsbBtnDtaPrsEmlRst = dsbBtnDtaPrsEmlRst;
	}

	public boolean isVsbBtnDtaPrsEmlRst() {
		return vsbBtnDtaPrsEmlRst;
	}

	public void setVsbBtnDtaPrsEmlRst(boolean vsbBtnDtaPrsEmlRst) {
		this.vsbBtnDtaPrsEmlRst = vsbBtnDtaPrsEmlRst;
	}

	public boolean isDsbDtaPrsEml() {
		return dsbDtaPrsEml;
	}

	public void setDsbDtaPrsEml(boolean dsbDtaPrsEml) {
		this.dsbDtaPrsEml = dsbDtaPrsEml;
	}

	public boolean isVsbDtaPrsEml() {
		return vsbDtaPrsEml;
	}

	public void setVsbDtaPrsEml(boolean vsbDtaPrsEml) {
		this.vsbDtaPrsEml = vsbDtaPrsEml;
	}

	public boolean isRqrDtaPrsEml() {
		return rqrDtaPrsEml;
	}

	public void setRqrDtaPrsEml(boolean rqrDtaPrsEml) {
		this.rqrDtaPrsEml = rqrDtaPrsEml;
	}

	public boolean isDsbDtaPrsEmlTpe() {
		return dsbDtaPrsEmlTpe;
	}

	public void setDsbDtaPrsEmlTpe(boolean dsbDtaPrsEmlTpe) {
		this.dsbDtaPrsEmlTpe = dsbDtaPrsEmlTpe;
	}

	public boolean isVsbDtaPrsEmlTpe() {
		return vsbDtaPrsEmlTpe;
	}

	public void setVsbDtaPrsEmlTpe(boolean vsbDtaPrsEmlTpe) {
		this.vsbDtaPrsEmlTpe = vsbDtaPrsEmlTpe;
	}

	public boolean isRqrDtaPrsEmlTpe() {
		return rqrDtaPrsEmlTpe;
	}

	public void setRqrDtaPrsEmlTpe(boolean rqrDtaPrsEmlTpe) {
		this.rqrDtaPrsEmlTpe = rqrDtaPrsEmlTpe;
	}

	public List<DtaTblPrsEml> getLstPrsEml() {
		return lstPrsEml;
	}

	public void setLstPrsEml(List<DtaTblPrsEml> lstPrsEml) {
		this.lstPrsEml = lstPrsEml;
	}

	public DtaTblPrsEml getPrsEml() {
		return prsEml;
	}

	public void setPrsEml(DtaTblPrsEml prsEml) {
		this.prsEml = prsEml;
	}

	public List<DtaTblOpt> getLstLvlSrc() {
		return lstLvlSrc;
	}

	public void setLstLvlSrc(List<DtaTblOpt> lstLvlSrc) {
		this.lstLvlSrc = lstLvlSrc;
	}

	public int getILvlSrcId() {
		return ILvlSrcId;
	}

	public void setILvlSrcId(int iLvlSrcId) {
		ILvlSrcId = iLvlSrcId;
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

	public DtaTblPrsEdc getPrsEdc() {
		return prsEdc;
	}

	public void setPrsEdc(DtaTblPrsEdc prsEdc) {
		this.prsEdc = prsEdc;
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

	public int getIPrsEdcId() {
		return IPrsEdcId;
	}

	public void setIPrsEdcId(int iPrsEdcId) {
		IPrsEdcId = iPrsEdcId;
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

	public List<DtaTblPrsEdc> getLstPrsEdc() {
		return lstPrsEdc;
	}

	public void setLstPrsEdc(List<DtaTblPrsEdc> lstPrsEdc) {
		this.lstPrsEdc = lstPrsEdc;
	}

	public boolean isDsbPnlPrsPhn() {
		return dsbPnlPrsPhn;
	}

	public void setDsbPnlPrsPhn(boolean dsbPnlPrsPhn) {
		this.dsbPnlPrsPhn = dsbPnlPrsPhn;
	}

	public boolean isVsbPnlPrsPhn() {
		return vsbPnlPrsPhn;
	}

	public void setVsbPnlPrsPhn(boolean vsbPnlPrsPhn) {
		this.vsbPnlPrsPhn = vsbPnlPrsPhn;
	}

	public boolean isDsbBtnSvePrsPhn() {
		return dsbBtnSvePrsPhn;
	}

	public void setDsbBtnSvePrsPhn(boolean dsbBtnSvePrsPhn) {
		this.dsbBtnSvePrsPhn = dsbBtnSvePrsPhn;
	}

	public boolean isVsbBtnSvePrsPhn() {
		return vsbBtnSvePrsPhn;
	}

	public void setVsbBtnSvePrsPhn(boolean vsbBtnSvePrsPhn) {
		this.vsbBtnSvePrsPhn = vsbBtnSvePrsPhn;
	}

	public boolean isDsbBtnRstPrsPhn() {
		return dsbBtnRstPrsPhn;
	}

	public void setDsbBtnRstPrsPhn(boolean dsbBtnRstPrsPhn) {
		this.dsbBtnRstPrsPhn = dsbBtnRstPrsPhn;
	}

	public boolean isVsbBtnRstPrsPhn() {
		return vsbBtnRstPrsPhn;
	}

	public void setVsbBtnRstPrsPhn(boolean vsbBtnRstPrsPhn) {
		this.vsbBtnRstPrsPhn = vsbBtnRstPrsPhn;
	}

	public List<ScrTblPrsRol> getLstPrsRol() {
		return lstPrsRol;
	}

	public void setLstPrsRol(List<ScrTblPrsRol> lstPrsRol) {
		this.lstPrsRol = lstPrsRol;
	}

	public boolean isDsbPrsPhn() {
		return dsbPrsPhn;
	}

	public void setDsbPrsPhn(boolean dsbPrsPhn) {
		this.dsbPrsPhn = dsbPrsPhn;
	}

	public boolean isVsbPrsPhn() {
		return vsbPrsPhn;
	}

	public void setVsbPrsPhn(boolean vsbPrsPhn) {
		this.vsbPrsPhn = vsbPrsPhn;
	}

	public boolean isRqrPrsPhn() {
		return rqrPrsPhn;
	}

	public void setRqrPrsPhn(boolean rqrPrsPhn) {
		this.rqrPrsPhn = rqrPrsPhn;
	}

	public DtaTblPrsPhn getPrsPhn() {
		return prsPhn;
	}

	public void setPrsPhn(DtaTblPrsPhn prsPhn) {
		this.prsPhn = prsPhn;
	}

	public List<DtaTblPrsPhn> getLstPrsPhn() {
		return lstPrsPhn;
	}

	public void setLstPrsPhn(List<DtaTblPrsPhn> lstPrsPhn) {
		this.lstPrsPhn = lstPrsPhn;
	}

	public List<DtaTblOpt> getLstGnd() {
		return lstGnd;
	}

	public void setLstGnd(List<DtaTblOpt> lstGnd) {
		this.lstGnd = lstGnd;
	}

	public int getIGndCde() {
		return IGndCde;
	}

	public void setIGndCde(int iGndCde) {
		IGndCde = iGndCde;
	}

	public List<DpaTblCnr> getLstCnr() {
		return lstCnr;
	}

	public void setLstCnr(List<DpaTblCnr> lstCnr) {
		this.lstCnr = lstCnr;
	}

	public int getICnrId() {
		return ICnrId;
	}

	public void setICnrId(int iCnrId) {
		ICnrId = iCnrId;
	}

	public List<DtaTblOpt> getLstIdn() {
		return lstIdn;
	}

	public void setLstIdn(List<DtaTblOpt> lstIdn) {
		this.lstIdn = lstIdn;
	}

	public int getIIdnId() {
		return IIdnId;
	}

	public void setIIdnId(int iIdnId) {
		IIdnId = iIdnId;
	}

	public boolean isDsbPrs() {
		return dsbPrs;
	}

	public void setDsbPrs(boolean dsbPrs) {
		this.dsbPrs = dsbPrs;
	}

	public boolean isVsbPrs() {
		return vsbPrs;
	}

	public void setVsbPrs(boolean vsbPrs) {
		this.vsbPrs = vsbPrs;
	}

	public boolean isRqrPrs() {
		return rqrPrs;
	}

	public void setRqrPrs(boolean rqrPrs) {
		this.rqrPrs = rqrPrs;
	}

	public List<DtaTblOpt> getLstGrt() {
		return lstGrt;
	}

	public void setLstGrt(List<DtaTblOpt> lstGrt) {
		this.lstGrt = lstGrt;
	}

	public int getIGrtId() {
		return IGrtId;
	}

	public void setIGrtId(int iGrtId) {
		IGrtId = iGrtId;
	}

	public boolean isDsbPrsEml() {
		return dsbPrsEml;
	}

	public void setDsbPrsEml(boolean dsbPrsEml) {
		this.dsbPrsEml = dsbPrsEml;
	}

	public boolean isVsbPrsEml() {
		return vsbPrsEml;
	}

	public void setVsbPrsEml(boolean vsbPrsEml) {
		this.vsbPrsEml = vsbPrsEml;
	}

	public boolean isRqrPrsEml() {
		return rqrPrsEml;
	}

	public void setRqrPrsEml(boolean rqrPrsEml) {
		this.rqrPrsEml = rqrPrsEml;
	}

	public ScrTblPrsRol getPrl() {
		return prl;
	}

	public void setPrl(ScrTblPrsRol prl) {
		this.prl = prl;
	}

	public boolean isDsbPrsPsw() {
		return dsbPrsPsw;
	}

	public void setDsbPrsPsw(boolean dsbPrsPsw) {
		this.dsbPrsPsw = dsbPrsPsw;
	}

	public boolean isVsbPrsPsw() {
		return vsbPrsPsw;
	}

	public void setVsbPrsPsw(boolean vsbPrsPsw) {
		this.vsbPrsPsw = vsbPrsPsw;
	}

	public boolean isRqrPrsPsw() {
		return rqrPrsPsw;
	}

	public void setRqrPrsPsw(boolean rqrPrsPsw) {
		this.rqrPrsPsw = rqrPrsPsw;
	}

	public List<DtaTblOpt> getLstPhnTpe() {
		return lstPhnTpe;
	}

	public void setLstPhnTpe(List<DtaTblOpt> lstPhnTpe) {
		this.lstPhnTpe = lstPhnTpe;
	}

	public int getIPhnTpeId() {
		return IPhnTpeId;
	}

	public void setIPhnTpeId(int iPhnTpeId) {
		IPhnTpeId = iPhnTpeId;
	}

	public boolean isDsbDtaPrsEdcLvl() {
		return dsbDtaPrsEdcLvl;
	}

	public void setDsbDtaPrsEdcLvl(boolean dsbDtaPrsEdcLvl) {
		this.dsbDtaPrsEdcLvl = dsbDtaPrsEdcLvl;
	}

	public boolean isVsbDtaPrsEdcLvl() {
		return vsbDtaPrsEdcLvl;
	}

	public void setVsbDtaPrsEdcLvl(boolean vsbDtaPrsEdcLvl) {
		this.vsbDtaPrsEdcLvl = vsbDtaPrsEdcLvl;
	}

	public boolean isRqrDtaPrsEdcLvl() {
		return rqrDtaPrsEdcLvl;
	}

	public void setRqrDtaPrsEdcLvl(boolean rqrDtaPrsEdcLvl) {
		this.rqrDtaPrsEdcLvl = rqrDtaPrsEdcLvl;
	}

	public boolean isDsbPrsUsr() {
		return dsbPrsUsr;
	}

	public void setDsbPrsUsr(boolean dsbPrsUsr) {
		this.dsbPrsUsr = dsbPrsUsr;
	}

	public boolean isVsbPrsUsr() {
		return vsbPrsUsr;
	}

	public void setVsbPrsUsr(boolean vsbPrsUsr) {
		this.vsbPrsUsr = vsbPrsUsr;
	}

	public boolean isRqrPrsUsr() {
		return rqrPrsUsr;
	}

	public void setRqrPrsUsr(boolean rqrPrsUsr) {
		this.rqrPrsUsr = rqrPrsUsr;
	}

}
