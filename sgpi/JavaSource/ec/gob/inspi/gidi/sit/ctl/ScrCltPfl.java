package ec.gob.inspi.gidi.sit.ctl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
import ec.gob.inspi.gidi.sit.ent.InfTblStm;
import ec.gob.inspi.gidi.sit.ent.ScrTblPrsRol;
import ec.gob.inspi.gidi.sit.srv.DpaSrvCnr;
import ec.gob.inspi.gidi.sit.srv.DtaSrvOpt;
import ec.gob.inspi.gidi.sit.srv.DtaSrvPrs;
import ec.gob.inspi.gidi.sit.srv.InfSrvStm;
import ec.gob.inspi.gidi.sit.srv.ScrSrvPrsRol;

import javax.servlet.http.HttpSession;



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
	private static Logger LOG;
	

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
		
		session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		LOG = Logger.getLogger(this.getClass().getName());

	}

	@PostConstruct
	public void init() {

		this.cptInit();
		
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

	
		this.loadCnr();
		ICnrId = prl.getDtaTblPr().getDpaTblCnr().getICnrId();

		/******************************************************/
		lstLvlSrc = this.loadDtaOpt(cde.dtaLvl());
		/******************************************************/
		/** DTA-EML **/
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
			LOG.log(Level.WARNING, e.getMessage());
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
			LOG.log(Level.WARNING, e.getMessage());
		}

	}

	public void UpdPrsEml() {
		try {
			this.actPrsEml(false, true, true);
			sprs.update(prl.getDtaTblPr());
			session.setAttribute("prl", prl);
			this.msg.msgInf(msg.msgUpdInf());
		} catch (Exception e) {
			LOG.log(Level.WARNING, e.getMessage());
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
			LOG.log(Level.WARNING, e.getMessage());
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
			LOG.log(Level.WARNING, e.getMessage());
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
			LOG.log(Level.WARNING, e.getMessage());
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
			LOG.log(Level.WARNING, e.getMessage());
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
				LOG.log(Level.WARNING, eX.getMessage());
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
			LOG.log(Level.WARNING, e.getMessage());
		}
	}

	/*
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ------------------------- MODULE: Dta -------------------------
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */
	

	

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
			LOG.log(Level.WARNING, e.getMessage());
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
