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
import ec.gob.inspi.gidi.sit.cmm.Log;
import ec.gob.inspi.gidi.sit.cmm.Message;
import ec.gob.inspi.gidi.sit.cmm.Method;
import ec.gob.inspi.gidi.sit.cmm.Name;
import ec.gob.inspi.gidi.sit.ent.ScrTblPrsRol;
import ec.gob.inspi.gidi.sit.ent.SitTblGnr;
import ec.gob.inspi.gidi.sit.ent.SitTblGnrDtl;
import ec.gob.inspi.gidi.sit.ent.SitTblGnrPrsPrf;
import ec.gob.inspi.gidi.sit.ent.SitTblNmb;
import ec.gob.inspi.gidi.sit.ent.SitTblSte;
import ec.gob.inspi.gidi.sit.srv.ScrSrvPrsRol;
import ec.gob.inspi.gidi.sit.srv.SitSrvGnr;
import ec.gob.inspi.gidi.sit.srv.SitSrvGnrDtl;
import ec.gob.inspi.gidi.sit.srv.SitSrvGnrPrsPrf;
import ec.gob.inspi.gidi.sit.srv.SitSrvOPt;
import ec.gob.inspi.gidi.sit.srv.SitSrvNmb;
import ec.gob.inspi.gidi.sit.srv.SitSrvSte;

@ManagedBean
@ViewScoped
public class SitCtlGnr {

	protected Method mth;
	protected Message msg;
	protected Code cde;
	protected Default dfl;
	private ScrTblPrsRol prl;
	protected ScrCtlSss sss;
	protected Name nme;

	protected Log log;

	public SitCtlGnr() {
		gnr = new SitTblGnr();
		gnrDtl = new SitTblGnrDtl();
		mth = new Method();
		msg = new Message();
		cde = new Code();
		dfl = new Default();
		gnrDtlAdl = new SitTblGnrDtl();
		gnrDtlLrv = new SitTblGnrDtl();
		prl = new ScrTblPrsRol();
		sss = new ScrCtlSss();
		log = new Log();
		nme = new Name();
	}

	public void loadPrl() {
		try {
			prl = sss.getPrl();
		} catch (Exception e) {
			this.log.impCtl(this.getClass().getSimpleName(), nme.evnLoad(), nme.actAdd(),
					ScrTblPrsRol.class.getSimpleName(), e.getMessage());
			e.printStackTrace();
		}
	}

	private void cptInit() {

		BGnrTrpRcv = true;
		BGnrTrpSup = true;
		this.actPgr(true, false);
		this.actBtnHme(false, true);
		this.actBtnAdd(false, true);
		this.actBtnAddCpy(true, true);
		this.actBtnSve(true, true);
		this.actBtnUpd(true, false);
		this.actBtnRtr(false, true);
		this.actTblBtnEdt(true, true);
		this.actTblBtnDlt(false, true);

		this.actTpe(true, true, false);

		this.actGnrNmbCpl(true, true, false);
		this.actGnrNmbBrk(true, true, false);
		this.actGnrNmbUsd(true, true, false);
		this.actGnrNmbVbl(true, true, false);
		this.actGnrObsEgs(true, true, false);

		this.actGnrNmbLrsPps(true, true, false);
		this.actPrsPrf(true, true, false);
		this.actYr(true, true, false);
		this.actEpi(true, true, false);
		this.actPrj(true, true, false);
		this.actTrp(true, true, false);
		this.actSte(true, true, false);
		this.actNmb(true, true, false);
		this.actDteSet(true, true, false);
		this.actDteClc(true, true, false);
		this.actTrpRcv(true, true, false);
		this.actTrpSup(true, true, false);
		this.actBEgs(true, true, false);
		this.actBLrs(true, true, false);
		this.actBAdl(true, true, false);
		this.actLrsStg(true, true, false);
		this.actBtnAdlAdd(true, true);
		this.actBtnAdlNew(true, true);
		this.actBtnAdlRst(true, true);
		this.actBtnLrvAdd(true, true);
		this.actBtnLrvNew(true, true);
		this.actBtnLrvRst(true, true);
		this.actGnrObsEgs(true, true, false);
		this.actGnrObsLrv(true, true, false);
		this.actGnrObsAdl(true, true, false);
		this.actGnrDtlLrvNmbLive(true, true, false);
		this.actGnrDtlLrvNmbDied(true, true, false);
		this.actGnrDtlLrvNmb(true, true, false);
		this.actGnrDtlLrvStg(true, true, false);
		this.actGnrDtlLrvSex(true, true, false);
		this.actGnrDtlLrvSpc(true, true, false);

		this.actAdlNmb(true, true, false);
		this.actAdlSex(true, true, false);
		this.actAdlSpc(true, true, false);
		this.actBtnAdlAdd(true, true);
		this.actBtnAdlNew(true, true);
		this.actBtnAdlRst(true, true);

		this.actGnrPrfAgn(true, true, false);
		this.actGnrPrfTch(true, true, false);
		this.newPrsPrfAgnSlc();
		this.newPrsPrfTchSlc();
	}

	@PostConstruct
	public void init() {
		this.loadGnr();
		this.loadPrl();
		this.cptInit();
	}

	private void cptAdd() {
		this.actPgr(false, true);
		this.actBtnHme(true, true);
		this.actBtnAdd(true, true);
		this.actBtnSve(false, true);
		this.actPrj(false, true, true);
		this.actSte(false, true, true);
		this.actTpe(false, true, true);
	}

	public void add() {
		try {
			this.cptAdd();
			gnr = new SitTblGnr();
			IYrId = 0;
			ISteId = 0;
			INmbId = 0;
			IDteSetYr = 0;
			IDteSetMth = 0;
			IDteSetDay = 0;
			IDteClcYr = 0;
			IDteClcMth = 0;
			IDteClcDay = 0;
			gnr.setIGnrNmbEgsBrk(0);
			gnr.setIGnrNmbEgsCpl(0);
			gnr.setIGnrNmbEgsUsd(0);
			gnr.setIGnrNmbEgsVlb(0);
			this.newAdlSlc();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addCopy() {
		this.actPrsPrf(false, true, true);
		this.actPrj(false, true, true);
		this.actSte(false, true, true);
		this.actYr(false, true, true);
		this.actEpi(false, true, true);
		this.actTrp(false, true, true);
		this.actNmb(false, true, true);
		this.actDteSet(false, true, true);
		this.actDteClc(false, true, true);
		this.actTrpRcv(false, true, false);
		this.actTrpSup(false, true, false);
		gnr = new SitTblGnr();
		gnr.setIGnrNmbEgsBrk(0);
		gnr.setIGnrNmbEgsCpl(0);
		gnr.setIGnrNmbEgsUsd(0);
		gnr.setIGnrNmbEgsVlb(0);
		this.actBEgs(false, true, false);
		this.actBLrs(false, true, false);
		this.actBAdl(false, true, false);
		this.newLstLrsStg();
		this.newAdlSlc();
		gnrDtlLrv = new SitTblGnrDtl();
		gnrDtlAdl = new SitTblGnrDtl();
		ILrsStgId = 0;
		ISexId = 0;
		ISpcId = 0;
		ITtlLrsId = 0;
		this.newPrsPrfAgnAdd();
		this.newPrsPrfTchAdd();
		this.newPrsPrfAgnSlc();
		this.newPrsPrfTchSlc();
		this.actGnrPrfAgn(false, true, false);
		this.actGnrPrfTch(false, true, false);
		this.actBtnSve(false, true);
		this.actBtnAdd(true, true);
		this.actBtnAddCpy(true, true);
		this.actTpe(false, true, true);
	}

	private void cptSve() {
		this.actPrj(true, true, false);
		this.actSte(true, true, false);
		this.actYr(true, true, false);
		this.actEpi(true, true, false);
		this.actTrp(true, true, false);
		this.actNmb(true, true, false);
		this.actDteSet(true, true, false);
		this.actDteClc(true, true, false);
		this.actTrpRcv(true, true, false);
		this.actTrpSup(true, true, false);

		this.actBEgs(true, true, false);
		BGnrEgs = false;
		this.actGnrNmbCpl(true, true, false);
		this.actGnrNmbBrk(true, true, false);
		this.actGnrNmbUsd(true, true, false);
		this.actGnrNmbVbl(true, true, false);
		this.actGnrObsEgs(true, true, false);

		this.actBLrs(true, true, false);
		BGnrLrs = false;
		this.actGnrNmbLrsPps(true, true, false);
		this.actGnrDtlLrvStg(true, true, false);
		this.actGnrDtlLrvNmbDied(true, true, false);
		this.actGnrDtlLrvNmbLive(true, true, false);
		this.actGnrObsLrv(true, true, false);
		this.actBtnLrvAdd(true, true);
		this.actBtnLrvNew(true, true);
		this.actBtnLrvRst(true, true);

		this.actBAdl(true, true, false);
		BGnrAdl = false;
		this.actAdlNmb(true, true, false);
		this.actAdlSex(true, true, false);
		this.actAdlSpc(true, true, false);
		this.actBtnAdlAdd(true, true);
		this.actBtnAdlNew(true, true);
		this.actBtnAdlRst(true, true);

		this.actGnrPrfAgn(true, true, false);
		this.actGnrPrfTch(true, true, false);

		this.actBtnSve(true, true);
		this.actBtnAdd(false, true);
		this.actBtnAddCpy(false, true);
		this.actTpe(true, true, false);
	}

	public void upd() {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@EJB
	protected SitSrvGnrDtl SGnrDtl;
	@EJB
	protected SitSrvGnrPrsPrf SGnrPrsPrf;

	public void sve() {
		try {
			this.loadPrl();
			if (SGnr.sve(prl, gnr, nmb, ITrpId, IDteSetYr, IDteSetMth, IDteSetDay, IDteClcYr, IDteClcMth, IDteClcDay,
					BGnrTrpRcv, BGnrTrpSup, BGnrEgs, BGnrLrs, BGnrAdl, ITpeId) != false) {
				try {
					if (lstLrsStgSlc.size() > 0) {
						for (SitTblGnrDtl gnrDtlLrvAux : lstLrsStgSlc) {
							if (SGnrDtl.sve(gnrDtlLrvAux, gnr) != false) {

							} else {
								this.msg.msgErr("Larvae: Information was not stored correctly");
								break;
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					this.msg.msgWrn("No larvae information");
				}

				try {
					if (lstAdlSlc.size() > 0) {
						for (SitTblGnrDtl gnrDtlAdlAux : lstAdlSlc) {
							if (SGnrDtl.sve(gnrDtlAdlAux, gnr) != false) {
							} else {
								this.msg.msgErr("Adults: Information was not stored correctly");
								break;
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					this.msg.msgWrn("No adult information");
				}

				try {
					if (lstPrsPrfAgnAdd.size() > 0) {
						for (ScrTblPrsRol prsPrfAux : lstPrsPrfAgnAdd) {
							if (SGnrPrsPrf.sve(prsPrfAux, gnr) != false) {
							} else {
								this.msg.msgErr("Agent: Information was not stored correctly");
								break;
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					this.msg.msgWrn("No Field agent information");
				}

				try {
					if (lstPrsPrfTchAdd.size() > 0) {
						for (ScrTblPrsRol prsPrfAux : lstPrsPrfTchAdd) {
							if (SGnrPrsPrf.sve(prsPrfAux, gnr) != false) {
							} else {
								this.msg.msgErr("Technician: Information was not stored correctly");
								break;
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					this.msg.msgWrn("No  Lab technician information");
				}

				this.msg.msgInf("Information stored correctly");
				this.cptSve();
				this.loadGnr();
			} else {
				this.msg.msgErr("Information is not stored correctly");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void edt() {

	}

	public void dlt() {
		try {
			if (SGnr.dlt(gnr)) {
				this.msg.msgInf(msg.msgDltInf());
			} else {
				this.msg.msgErr(msg.msgErrDlt());
			}
			this.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<SitTblGnrDtl> lstGnrDtl(SitTblGnr gnr) {
		try {
			List<SitTblGnrDtl> auxLstGnrDtl = new ArrayList<SitTblGnrDtl>();
			auxLstGnrDtl = SGnrDtl.lstGnrDtl(gnr);
			return auxLstGnrDtl;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<SitTblGnrPrsPrf> lstGnrDtlPrs(SitTblGnr gnr) {
		try {
			List<SitTblGnrPrsPrf> auxLstGnrDtl = new ArrayList<SitTblGnrPrsPrf>();
			auxLstGnrDtl = SGnrPrsPrf.lstGnrDtl(gnr);
			return auxLstGnrDtl;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// BOTONES DE PANELES DE FORMULARIO
	private boolean vsbPgrTbl;
	private boolean vsbPgrDta;

	private void actPgr(boolean tbl, boolean dta) {
		vsbPgrTbl = tbl;
		vsbPgrDta = dta;
	}

	// BOTONES DEL FORMULARIO
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

	private boolean vsbBtnAddCpy;
	private boolean dsbBtnAddCpy;

	private void actBtnAddCpy(boolean dsb, boolean vsb) {
		vsbBtnAddCpy = vsb;
		dsbBtnAddCpy = dsb;
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

	// BOTONES DE TABLA
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

	/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/

	private boolean dsbYr;
	private boolean vsbYr;
	private boolean rqrYr;

	private void actYr(boolean dsb, boolean vsb, boolean rqr) {
		dsbYr = dsb;
		vsbYr = vsb;
		rqrYr = rqr;
	}

	private int IYrId;

	public void chsYr() {
		try {
			this.actEpi(false, true, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/

	private boolean dsbEpi;
	private boolean vsbEpi;
	private boolean rqrEpi;

	private void actEpi(boolean dsb, boolean vsb, boolean rqr) {
		dsbEpi = dsb;
		vsbEpi = vsb;
		rqrEpi = rqr;
	}

	/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
	private boolean dsbPrj;
	private boolean vsbPrj;
	private boolean rqrPrj;

	private void actPrj(boolean dsb, boolean vsb, boolean rqr) {
		dsbPrj = dsb;
		vsbPrj = vsb;
		rqrPrj = rqr;
	}

	private int IPrjId;

	public void chsPrj() {
		try {
			this.actSte(false, true, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
	private boolean dsbTrp;
	private boolean vsbTrp;
	private boolean rqrTrp;

	private void actTrp(boolean dsb, boolean vsb, boolean rqr) {
		dsbTrp = dsb;
		vsbTrp = vsb;
		rqrTrp = rqr;
	}

	@EJB
	protected SitSrvOPt SOtp;

	private int ITrpId;

	public void chsTrp() {
		this.actNmb(false, true, true);
	}

	/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/

	private boolean dsbSte;
	private boolean vsbSte;
	private boolean rqrSte;

	private void actSte(boolean dsb, boolean vsb, boolean rqr) {
		dsbSte = dsb;
		vsbSte = vsb;
		rqrSte = rqr;
	}

	@EJB
	protected SitSrvSte SSte;
	private int ISteId;
	private SitTblSte ste;

	public void chsSte() {
		try {
			ste = new SitTblSte();
			ste = SSte.searchId(ISteId);
			this.actTrp(false, true, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/

	private boolean dsbTpe;
	private boolean vsbTpe;
	private boolean rqrTpe;
	private int ITpeId;

	private void actTpe(boolean dsb, boolean vsb, boolean rqr) {
		dsbTpe = dsb;
		vsbTpe = vsb;
		rqrTpe = rqr;
	}

	/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/

	private boolean dsbNmb;
	private boolean vsbNmb;
	private boolean rqrNmb;

	private void actNmb(boolean dsb, boolean vsb, boolean rqr) {
		dsbNmb = dsb;
		vsbNmb = vsb;
		rqrNmb = rqr;
	}

	@EJB
	protected SitSrvNmb SNmb;
	private int INmbId;
	private SitTblNmb nmb;

	public void chsNmb() {
		try {
			nmb = new SitTblNmb();
			nmb = SNmb.searchId(INmbId);
			this.actDteSet(false, true, true);
			this.actDteClc(false, true, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/

	private boolean dsbDteSet;
	private boolean vsbDteSet;
	private boolean rqrDteSet;

	private void actDteSet(boolean dsb, boolean vsb, boolean rqr) {
		dsbDteSet = dsb;
		vsbDteSet = vsb;
		rqrDteSet = rqr;
	}

	private boolean dsbDteClc;
	private boolean vsbDteClc;
	private boolean rqrDteClc;

	private void actDteClc(boolean dsb, boolean vsb, boolean rqr) {
		dsbDteClc = dsb;
		vsbDteClc = vsb;
		rqrDteClc = rqr;
	}

	private int IDteSetYr;
	private int IDteSetMth;
	private int IDteSetDay;
	private int IDteClcYr;
	private int IDteClcMth;
	private int IDteClcDay;

	public void chsSetYr() {
		IDteSetMth = 0;
		IDteSetDay = 0;
	}

	public void chsSetMth() {
		IDteSetDay = 0;
	}

	public void chsSetDay() {

	}

	public void chsClcYr() {
		IDteClcMth = 0;
		IDteClcDay = 0;
	}

	public void chsClcMth() {
		IDteClcDay = 0;
	}

	public void chsClcDay() {

		try {
			if (mth.vldDte(mth.dte(IDteSetYr, IDteSetMth, IDteSetDay),
					mth.dte(IDteClcYr, IDteClcMth, IDteClcDay)) == -1) { // # FECHA FIN > FECHA INICIO
				if (mth.vldDte(mth.dte(IDteSetYr, IDteSetMth, IDteSetDay),
						mth.dte(IDteClcYr, IDteClcMth, IDteClcDay)) == 0) { // # FECHA FIN = FECHA INICIO
				} else {
					this.actBEgs(false, true, false);
					this.actBLrs(false, true, false);
					this.actBAdl(false, true, false);
					this.actTrpRcv(false, true, false);
					this.actTrpSup(false, true, false);
					this.actGnrPrfAgn(false, true, false);
					this.actGnrPrfTch(false, true, false);

				}
			} else if (mth.vldDte(mth.dte(IDteSetYr, IDteSetMth, IDteSetDay),
					mth.dte(IDteClcYr, IDteClcMth, IDteClcDay)) == 1) {// # FECHA FIN < FECHA INICIO
				this.msg.msgWrn("La fecha ingresada es incorrecta");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/

	private boolean dsbTrpRcv;
	private boolean vsbTrpRcv;
	private boolean rqrTrpRcv;

	private void actTrpRcv(boolean dsb, boolean vsb, boolean rqr) {
		dsbTrpRcv = dsb;
		vsbTrpRcv = vsb;
		rqrTrpRcv = rqr;
	}

	private boolean dsbTrpSup;
	private boolean vsbTrpSup;
	private boolean rqrTrpSup;

	private void actTrpSup(boolean dsb, boolean vsb, boolean rqr) {
		dsbTrpSup = dsb;
		vsbTrpSup = vsb;
		rqrTrpSup = rqr;
	}

	private boolean dsbBEgs;
	private boolean vsbBEgs;
	private boolean rqrBEgs;
	private boolean dsbBLrs;
	private boolean vsbBLrs;
	private boolean rqrBLrs;

	private boolean dsbBAdl;
	private boolean vsbBAdl;
	private boolean rqrBAdl;

	private void actBEgs(boolean dsb, boolean vsb, boolean rqr) {
		dsbBEgs = dsb;
		vsbBEgs = vsb;
		rqrBEgs = rqr;
	}

	private void actBLrs(boolean dsb, boolean vsb, boolean rqr) {
		dsbBLrs = dsb;
		vsbBLrs = vsb;
		rqrBLrs = rqr;
	}

	private void actBAdl(boolean dsb, boolean vsb, boolean rqr) {
		dsbBAdl = dsb;
		vsbBAdl = vsb;
		rqrBAdl = rqr;
	}

	private boolean BGnrTrpRcv;
	private boolean BGnrTrpSup;
	private SitTblGnr gnr;
	private SitTblGnrDtl gnrDtl;
	private List<SitTblGnr> lstGnr;
	@EJB
	protected SitSrvGnr SGnr;
	private boolean BGnrEgs;
	private boolean BGnrLrs;
	private boolean BGnrAdl;
	private boolean dsbGnrNmbCpl;
	private boolean vsbGnrNmbCpl;
	private boolean rqrGnrNmbCpl;
	private boolean dsbGnrNmbBrk;
	private boolean vsbGnrNmbBrk;
	private boolean rqrGnrNmbBrk;
	private boolean dsbGnrNmbUsd;
	private boolean vsbGnrNmbUsd;
	private boolean rqrGnrNmbUsd;
	private boolean dsbGnrNmbVbl;
	private boolean vsbGnrNmbVbl;
	private boolean rqrGnrNmbVbl;
	private boolean dsbGnrNmbLrsPps;
	private boolean vsbGnrNmbLrsPps;
	private boolean rqrGnrNmbLrsPps;
	private boolean dsbGnrEgs;
	private boolean vsbGnrEgs;
	private boolean rqrGnrEgs;
	private boolean dsbGnrLrv;
	private boolean vsbGnrLrv;
	private boolean rqrGnrLrv;
	private int IEgsTtl;

	private boolean dsbGnrObsEgs;
	private boolean vsbGnrObsEgs;
	private boolean rqrGnrObsEgs;

	private boolean dsbGnrObsLrv;
	private boolean vsbGnrObsLrv;
	private boolean rqrGnrObsLrv;

	private boolean dsbGnrObsAdl;
	private boolean vsbGnrObsAdl;
	private boolean rqrGnrObsAdl;

	private boolean dsbGnrDtlLrvNmb;
	private boolean vsbGnrDtlLrvNmb;
	private boolean rqrGnrDtlLrvNmb;

	private boolean dsbGnrDtlLrvStg;
	private boolean vsbGnrDtlLrvStg;
	private boolean rqrGnrDtlLrvStg;

	private boolean dsbGnrDtlLrvSex;
	private boolean vsbGnrDtlLrvSex;
	private boolean rqrGnrDtlLrvSex;

	private boolean dsbGnrDtlLrvSpc;
	private boolean vsbGnrDtlLrvSpc;
	private boolean rqrGnrDtlLrvSpc;

	private boolean dsbGnrDtlLrvNmbLive;
	private boolean vsbGnrDtlLrvNmbLive;
	private boolean rqrGnrDtlLrvNmbLive;

	private boolean dsbGnrDtlLrvNmbDied;
	private boolean vsbGnrDtlLrvNmbDied;
	private boolean rqrGnrDtlLrvNmbDied;

	private boolean dsbBtnLrvAdd;
	private boolean vsbBtnLrvAdd;

	private boolean dsbBtnLrvNew;
	private boolean vsbBtnLrvNew;

	private boolean dsbBtnLrvRst;
	private boolean vsbBtnLrvRst;

	private void actBtnLrvRst(boolean dsb, boolean vsb) {
		dsbBtnLrvRst = dsb;
		vsbBtnLrvRst = vsb;
	}

	private void actBtnLrvNew(boolean dsb, boolean vsb) {
		dsbBtnLrvNew = dsb;
		vsbBtnLrvNew = vsb;
	}

	private void actBtnLrvAdd(boolean dsb, boolean vsb) {
		dsbBtnLrvAdd = dsb;
		vsbBtnLrvAdd = vsb;
	}

	private void actGnrDtlLrvNmbDied(boolean dsb, boolean vsb, boolean rqr) {
		dsbGnrDtlLrvNmbDied = dsb;
		vsbGnrDtlLrvNmbDied = vsb;
		rqrGnrDtlLrvNmbDied = rqr;
	}

	private void actGnrDtlLrvNmbLive(boolean dsb, boolean vsb, boolean rqr) {
		dsbGnrDtlLrvNmbLive = dsb;
		vsbGnrDtlLrvNmbLive = vsb;
		rqrGnrDtlLrvNmbLive = rqr;
	}

	private void actGnrDtlLrvSpc(boolean dsb, boolean vsb, boolean rqr) {
		dsbGnrDtlLrvSpc = dsb;
		vsbGnrDtlLrvSpc = vsb;
		rqrGnrDtlLrvSpc = rqr;
	}

	private void actGnrDtlLrvSex(boolean dsb, boolean vsb, boolean rqr) {
		dsbGnrDtlLrvSex = dsb;
		vsbGnrDtlLrvSex = vsb;
		rqrGnrDtlLrvSex = rqr;
	}

	private void actGnrDtlLrvStg(boolean dsb, boolean vsb, boolean rqr) {
		dsbGnrDtlLrvStg = dsb;
		vsbGnrDtlLrvStg = vsb;
		rqrGnrDtlLrvStg = rqr;
	}

	private void actGnrDtlLrvNmb(boolean dsb, boolean vsb, boolean rqr) {
		dsbGnrDtlLrvNmb = dsb;
		vsbGnrDtlLrvNmb = vsb;
		rqrGnrDtlLrvNmb = rqr;
	}

	private void actGnrObsEgs(boolean dsb, boolean vsb, boolean rqr) {
		dsbGnrObsEgs = dsb;
		vsbGnrObsEgs = vsb;
		rqrGnrObsEgs = rqr;
	}

	private void actGnrObsLrv(boolean dsb, boolean vsb, boolean rqr) {
		dsbGnrObsLrv = dsb;
		vsbGnrObsLrv = vsb;
		rqrGnrObsLrv = rqr;
	}

	private void actGnrObsAdl(boolean dsb, boolean vsb, boolean rqr) {
		dsbGnrObsAdl = dsb;
		vsbGnrObsAdl = vsb;
		rqrGnrObsAdl = rqr;
	}

	private void actGnrNmbCpl(boolean dsb, boolean vsb, boolean rqr) {
		dsbGnrNmbCpl = dsb;
		vsbGnrNmbCpl = vsb;
		rqrGnrNmbCpl = rqr;
	}

	private void actGnrNmbBrk(boolean dsb, boolean vsb, boolean rqr) {
		dsbGnrNmbBrk = dsb;
		vsbGnrNmbBrk = vsb;
		rqrGnrNmbBrk = rqr;
	}

	private void actGnrNmbUsd(boolean dsb, boolean vsb, boolean rqr) {
		dsbGnrNmbUsd = dsb;
		vsbGnrNmbUsd = vsb;
		rqrGnrNmbUsd = rqr;
	}

	private void actGnrNmbVbl(boolean dsb, boolean vsb, boolean rqr) {
		dsbGnrNmbVbl = dsb;
		vsbGnrNmbVbl = vsb;
		rqrGnrNmbVbl = rqr;
	}

	private void actGnrNmbLrsPps(boolean dsb, boolean vsb, boolean rqr) {
		dsbGnrNmbLrsPps = dsb;
		vsbGnrNmbLrsPps = vsb;
		rqrGnrNmbLrsPps = rqr;
	}

	private void actGnrEgs(boolean dsb, boolean vsb, boolean rqr) {
		dsbGnrEgs = dsb;
		vsbGnrEgs = vsb;
		rqrGnrEgs = rqr;
	}

	private void actGnrLrv(boolean dsb, boolean vsb, boolean rqr) {
		dsbGnrLrv = dsb;
		vsbGnrLrv = vsb;
		rqrGnrLrv = rqr;
	}

	private void newGnr() {
		lstGnr = new ArrayList<SitTblGnr>();
	}

	private void loadGnr() {
		try {
			this.newGnr();
			this.loadPrl();
			lstGnr = SGnr.lstPrsRol(prl.getIPrjId());
			Collections.sort(lstGnr, new Comparator<SitTblGnr>() {
				public int compare(SitTblGnr o1, SitTblGnr o2) {
					return mth.dte(o2.getIGnrDteClcYr(), o2.getIGnrDteClcMth(), o2.getIGnrDteClcDay())
							.compareTo(mth.dte(o1.getIGnrDteClcYr(), o1.getIGnrDteClcMth(), o1.getIGnrDteClcDay()));
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void chsTrpRcv() {
		this.actGnrEgs(true, true, false);
		this.actGnrLrv(true, true, false);
	}

	public void chsTrpSup() {

	}

	public void chsEgs() {
		if (BGnrEgs != false) {
			this.actGnrNmbCpl(false, true, true);
			this.actGnrNmbBrk(false, true, true);
			this.actGnrNmbUsd(false, true, true);
			this.actGnrNmbVbl(false, true, true);
			this.actGnrObsEgs(false, true, false);
		} else {
			this.actGnrNmbCpl(true, true, false);
			this.actGnrNmbBrk(true, true, false);
			this.actGnrNmbUsd(true, true, false);
			this.actGnrNmbVbl(true, true, false);
			this.actGnrObsEgs(true, true, false);
		}
	}

	/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
	private boolean dsbPrsPrf;
	private boolean vsbPrsPrf;
	private boolean rqrPrsPrf;

	private void actPrsPrf(boolean dsb, boolean vsb, boolean rqr) {
		dsbPrsPrf = dsb;
		vsbPrsPrf = vsb;
		rqrPrsPrf = rqr;
	}

	private int IPrsPrfId;

	private List<ScrTblPrsRol> lstAgn;
	private List<ScrTblPrsRol> lstTch;
	private List<ScrTblPrsRol> lstAgnCmp;
	private List<ScrTblPrsRol> lstTchCmp;

	private String IAgnId;
	private String ITchId;

	public void chsPrsPrf() {
		try {
			this.actPrj(false, true, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void chsAddAgn() {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void chsAddTch() {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/****************************************************************************/
	/* +++++++++++++++++++++++++++++++ Larvae +++++++++++++++++++++++++++ */
	/****************************************************************************/

	private boolean dsbLrsStg;
	private boolean vsbLrsStg;
	private boolean rqrLrsStg;

	private int ILrsStgId;
	private int ITtlLrsId = 0;

	private List<SitTblGnrDtl> lstLrsStgSlc;
	private SitTblGnrDtl gnrDtlLrv;

	public void chsLrs() {
		if (BGnrLrs != false) {
			this.actGnrNmbLrsPps(false, true, true);
			this.actLrsStg(false, true, true);
			this.actBtnLrvAdd(false, true);
		} else {
			this.actGnrNmbLrsPps(true, true, false);
			this.actLrsStg(true, true, false);
			this.actBtnLrvAdd(true, true);
		}
		this.newLstLrsStg();
	}

	private void actLrsStg(boolean dsb, boolean vsb, boolean rqr) {
		dsbLrsStg = dsb;
		vsbLrsStg = vsb;
		rqrLrsStg = rqr;
	}

	public void newLstLrsStg() {
		lstLrsStgSlc = new ArrayList<SitTblGnrDtl>();

	}

	public void newLrsStg() {
		ILrsStgId = 0;
		gnrDtlLrv = new SitTblGnrDtl();
		this.actGnrNmbLrsPps(false, true, true);
		this.actLrsStg(false, true, true);
		this.actBtnLrvAdd(false, true);
		this.actBtnLrvNew(true, true);
	}

	public void addLrsStg() {
		try {
			gnrDtlLrv.setIStgId(ILrsStgId);
			gnrDtlLrv.setITpeDtl(cde.sitLrv());
			gnrDtlLrv.setIGnsId(dfl.IDflVle());
			gnrDtlLrv.setISexId(dfl.IDflVle());
			lstLrsStgSlc.add(gnrDtlLrv);
			this.actGnrObsLrv(false, true, false);
			this.actGnrDtlLrvNmbDied(false, true, false);
			this.actBtnLrvAdd(true, true);
			this.actBtnLrvNew(false, true);
			this.actGnrNmbLrsPps(true, true, false);
			this.actLrsStg(true, true, false);
			ITtlLrsId = 0;
			for (SitTblGnrDtl gnrDtlAux : lstLrsStgSlc) {
				ITtlLrsId = ITtlLrsId + gnrDtlAux.getIGnrDtlNmb();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void rstLrsStg() {

	}

	/****************************************************************************/
	/* +++++++++++++++++++++++++++++++ Adult +++++++++++++++++++++++++++ */
	/****************************************************************************/

	private boolean dsbAdlNmb;
	private boolean vsbAdlNmb;
	private boolean rqrAdlNmb;

	private boolean dsbAdlSex;
	private boolean vsbAdlSex;
	private boolean rqrAdlSex;

	private boolean dsbAdlSpc;
	private boolean vsbAdlSpc;
	private boolean rqrAdlSpc;

	private boolean dsbBtnAdlAdd;
	private boolean vsbBtnAdlAdd;

	private boolean dsbBtnAdlNew;
	private boolean vsbBtnAdlNew;

	private boolean dsbBtnAdlRst;
	private boolean vsbBtnAdlRst;

	private List<SitTblGnrDtl> lstAdlSlc;
	private SitTblGnrDtl gnrDtlAdl;
	private int ISexId;
	private int ISpcId;

	private void newAdlSlc() {
		lstAdlSlc = new ArrayList<SitTblGnrDtl>();
	}

	public void newAdl() {
		try {
			gnrDtlAdl = new SitTblGnrDtl();
			ISexId = 0;
			ISpcId = 0;
			this.actBtnAdlAdd(false, true);
			this.actBtnAdlNew(true, true);
			this.actAdlNmb(false, true, true);
			this.actAdlSex(false, true, true);
			this.actAdlSpc(false, true, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void chsAdl() {
		this.actGnrObsAdl(false, true, false);
		if (BGnrAdl != false) {
			this.actAdlNmb(false, true, true);
			this.actAdlSex(false, true, true);
			this.actAdlSpc(false, true, true);
			this.actBtnAdlAdd(false, true);
		} else {
			this.actAdlNmb(true, true, false);
			this.actAdlSex(true, true, false);
			this.actAdlSpc(true, true, false);
			this.actBtnAdlAdd(true, true);
		}

	}

	public void addAdl() {
		try {
			gnrDtlAdl.setIGnsId(ISpcId);
			gnrDtlAdl.setISexId(ISexId);
			gnrDtlAdl.setITpeDtl(cde.sitAdl());
			gnrDtlAdl.setIStgId(dfl.IDflVle());
			lstAdlSlc.add(gnrDtlAdl);
			this.actAdlNmb(true, true, false);
			this.actAdlSex(true, true, false);
			this.actAdlSpc(true, true, false);
			this.actBtnAdlAdd(true, true);
			this.actBtnAdlNew(false, true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void rstAdl() {

	}

	private void actBtnAdlRst(boolean dsb, boolean vsb) {
		dsbBtnAdlRst = dsb;
		vsbBtnAdlRst = vsb;
	}

	private void actBtnAdlNew(boolean dsb, boolean vsb) {
		dsbBtnAdlNew = dsb;
		vsbBtnAdlNew = vsb;
	}

	private void actBtnAdlAdd(boolean dsb, boolean vsb) {
		dsbBtnAdlAdd = dsb;
		vsbBtnAdlAdd = vsb;
	}

	private void actAdlNmb(boolean dsb, boolean vsb, boolean rqr) {
		dsbAdlNmb = dsb;
		vsbAdlNmb = vsb;
		rqrAdlNmb = rqr;
	}

	private void actAdlSex(boolean dsb, boolean vsb, boolean rqr) {
		dsbAdlSex = dsb;
		vsbAdlSex = vsb;
		rqrAdlSex = rqr;
	}

	private void actAdlSpc(boolean dsb, boolean vsb, boolean rqr) {
		dsbAdlSpc = dsb;
		vsbAdlSpc = vsb;
		rqrAdlSpc = rqr;
	}

	/****************************************************************************/
	/* +++++++++++++++++++++++++++++++ Professional +++++++++++++++++++++++++++ */
	/****************************************************************************/

	private boolean dsbGnrPrfAgn;
	private boolean vsbGnrPrfAgn;
	private boolean rqrGnrPrfAgn;
	private boolean dsbGnrPrfTch;
	private boolean vsbGnrPrfTch;
	private boolean rqrGnrPrfTch;

	@EJB
	protected ScrSrvPrsRol SPrsPrf;
	private List<ScrTblPrsRol> lstPrsPrfAgnAdd;
	private List<String> IPrsPrfAgnSlcId;

	private List<ScrTblPrsRol> lstPrsPrfTchAdd;
	private List<String> IPrsPrfTchSlcId;

	private void newPrsPrfAgnSlc() {
		try {
			IPrsPrfAgnSlcId = new ArrayList<String>();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void newPrsPrfAgnAdd() {
		try {
			lstPrsPrfAgnAdd = new ArrayList<ScrTblPrsRol>();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void chsPrsPrfAgn() {
		try {
			this.newPrsPrfAgnAdd();
			for (String prsPrfAux : IPrsPrfAgnSlcId) {
				lstPrsPrfAgnAdd.add(SPrsPrf.searchId(Integer.valueOf(prsPrfAux)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void newPrsPrfTchSlc() {
		try {
			IPrsPrfTchSlcId = new ArrayList<String>();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void newPrsPrfTchAdd() {
		try {
			lstPrsPrfTchAdd = new ArrayList<ScrTblPrsRol>();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void chsPrsPrfTch() {
		try {
			this.newPrsPrfTchAdd();
			for (String prsPrfAux : IPrsPrfTchSlcId) {
				lstPrsPrfTchAdd.add(SPrsPrf.searchId(Integer.valueOf(prsPrfAux)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void actGnrPrfAgn(boolean dsb, boolean vsb, boolean rqr) {
		dsbGnrPrfAgn = dsb;
		vsbGnrPrfAgn = vsb;
		rqrGnrPrfAgn = rqr;
	}

	private void actGnrPrfTch(boolean dsb, boolean vsb, boolean rqr) {
		dsbGnrPrfTch = dsb;
		vsbGnrPrfTch = vsb;
		rqrGnrPrfTch = rqr;
	}

	/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/

	public int getIYrId() {
		return IYrId;
	}

	public void setIYrId(int iYrId) {
		IYrId = iYrId;
	}

	public int getISteId() {
		return ISteId;
	}

	public void setISteId(int iSteId) {
		ISteId = iSteId;
	}

	public SitTblSte getSte() {
		return ste;
	}

	public void setSte(SitTblSte ste) {
		this.ste = ste;
	}

	public int getIDteSetYr() {
		return IDteSetYr;
	}

	public void setIDteSetYr(int iDteSetYr) {
		IDteSetYr = iDteSetYr;
	}

	public int getIDteSetMth() {
		return IDteSetMth;
	}

	public void setIDteSetMth(int iDteSetMth) {
		IDteSetMth = iDteSetMth;
	}

	public int getIDteSetDay() {
		return IDteSetDay;
	}

	public void setIDteSetDay(int iDteSetDay) {
		IDteSetDay = iDteSetDay;
	}

	public int getIDteClcYr() {
		return IDteClcYr;
	}

	public void setIDteClcYr(int iDteClcYr) {
		IDteClcYr = iDteClcYr;
	}

	public int getIDteClcMth() {
		return IDteClcMth;
	}

	public void setIDteClcMth(int iDteClcMth) {
		IDteClcMth = iDteClcMth;
	}

	public int getIDteClcDay() {
		return IDteClcDay;
	}

	public void setIDteClcDay(int iDteClcDay) {
		IDteClcDay = iDteClcDay;
	}

	public boolean isBGnrTrpRcv() {
		return BGnrTrpRcv;
	}

	public void setBGnrTrpRcv(boolean bGnrTrpRcv) {
		BGnrTrpRcv = bGnrTrpRcv;
	}

	public boolean isBGnrTrpSup() {
		return BGnrTrpSup;
	}

	public void setBGnrTrpSup(boolean bGnrTrpSup) {
		BGnrTrpSup = bGnrTrpSup;
	}

	public SitTblGnr getGnr() {
		return gnr;
	}

	public void setGnr(SitTblGnr gnr) {
		this.gnr = gnr;
	}

	public boolean isBGnrEgs() {
		return BGnrEgs;
	}

	public void setBGnrEgs(boolean bGnrEgs) {
		BGnrEgs = bGnrEgs;
	}

	public boolean isBGnrLrs() {
		return BGnrLrs;
	}

	public void setBGnrLrs(boolean bGnrLrs) {
		BGnrLrs = bGnrLrs;
	}

	public boolean isDsbGnrNmbCpl() {
		return dsbGnrNmbCpl;
	}

	public void setDsbGnrNmbCpl(boolean dsbGnrNmbCpl) {
		this.dsbGnrNmbCpl = dsbGnrNmbCpl;
	}

	public boolean isVsbGnrNmbCpl() {
		return vsbGnrNmbCpl;
	}

	public void setVsbGnrNmbCpl(boolean vsbGnrNmbCpl) {
		this.vsbGnrNmbCpl = vsbGnrNmbCpl;
	}

	public boolean isRqrGnrNmbCpl() {
		return rqrGnrNmbCpl;
	}

	public void setRqrGnrNmbCpl(boolean rqrGnrNmbCpl) {
		this.rqrGnrNmbCpl = rqrGnrNmbCpl;
	}

	public boolean isDsbGnrNmbBrk() {
		return dsbGnrNmbBrk;
	}

	public void setDsbGnrNmbBrk(boolean dsbGnrNmbBrk) {
		this.dsbGnrNmbBrk = dsbGnrNmbBrk;
	}

	public boolean isVsbGnrNmbBrk() {
		return vsbGnrNmbBrk;
	}

	public void setVsbGnrNmbBrk(boolean vsbGnrNmbBrk) {
		this.vsbGnrNmbBrk = vsbGnrNmbBrk;
	}

	public boolean isRqrGnrNmbBrk() {
		return rqrGnrNmbBrk;
	}

	public void setRqrGnrNmbBrk(boolean rqrGnrNmbBrk) {
		this.rqrGnrNmbBrk = rqrGnrNmbBrk;
	}

	public boolean isDsbGnrNmbVbl() {
		return dsbGnrNmbVbl;
	}

	public void setDsbGnrNmbVbl(boolean dsbGnrNmbVbl) {
		this.dsbGnrNmbVbl = dsbGnrNmbVbl;
	}

	public boolean isVsbGnrNmbVbl() {
		return vsbGnrNmbVbl;
	}

	public void setVsbGnrNmbVbl(boolean vsbGnrNmbVbl) {
		this.vsbGnrNmbVbl = vsbGnrNmbVbl;
	}

	public boolean isRqrGnrNmbVbl() {
		return rqrGnrNmbVbl;
	}

	public void setRqrGnrNmbVbl(boolean rqrGnrNmbVbl) {
		this.rqrGnrNmbVbl = rqrGnrNmbVbl;
	}

	public boolean isDsbGnrNmbLrsPps() {
		return dsbGnrNmbLrsPps;
	}

	public void setDsbGnrNmbLrsPps(boolean dsbGnrNmbLrsPps) {
		this.dsbGnrNmbLrsPps = dsbGnrNmbLrsPps;
	}

	public boolean isVsbGnrNmbLrsPps() {
		return vsbGnrNmbLrsPps;
	}

	public void setVsbGnrNmbLrsPps(boolean vsbGnrNmbLrsPps) {
		this.vsbGnrNmbLrsPps = vsbGnrNmbLrsPps;
	}

	public boolean isRqrGnrNmbLrsPps() {
		return rqrGnrNmbLrsPps;
	}

	public void setRqrGnrNmbLrsPps(boolean rqrGnrNmbLrsPps) {
		this.rqrGnrNmbLrsPps = rqrGnrNmbLrsPps;
	}

	public List<SitTblGnr> getLstGnr() {
		return lstGnr;
	}

	public void setLstGnr(List<SitTblGnr> lstGnr) {
		this.lstGnr = lstGnr;
	}

	public int getIPrsPrfId() {
		return IPrsPrfId;
	}

	public void setIPrsPrfId(int iPrsPrfId) {
		IPrsPrfId = iPrsPrfId;
	}

	public boolean isDsbGnrEgs() {
		return dsbGnrEgs;
	}

	public void setDsbGnrEgs(boolean dsbGnrEgs) {
		this.dsbGnrEgs = dsbGnrEgs;
	}

	public boolean isVsbGnrEgs() {
		return vsbGnrEgs;
	}

	public void setVsbGnrEgs(boolean vsbGnrEgs) {
		this.vsbGnrEgs = vsbGnrEgs;
	}

	public boolean isRqrGnrEgs() {
		return rqrGnrEgs;
	}

	public void setRqrGnrEgs(boolean rqrGnrEgs) {
		this.rqrGnrEgs = rqrGnrEgs;
	}

	public boolean isDsbGnrLrv() {
		return dsbGnrLrv;
	}

	public void setDsbGnrLrv(boolean dsbGnrLrv) {
		this.dsbGnrLrv = dsbGnrLrv;
	}

	public boolean isVsbGnrLrv() {
		return vsbGnrLrv;
	}

	public void setVsbGnrLrv(boolean vsbGnrLrv) {
		this.vsbGnrLrv = vsbGnrLrv;
	}

	public boolean isRqrGnrLrv() {
		return rqrGnrLrv;
	}

	public void setRqrGnrLrv(boolean rqrGnrLrv) {
		this.rqrGnrLrv = rqrGnrLrv;
	}

	public boolean isDsbPrsPrf() {
		return dsbPrsPrf;
	}

	public void setDsbPrsPrf(boolean dsbPrsPrf) {
		this.dsbPrsPrf = dsbPrsPrf;
	}

	public boolean isVsbPrsPrf() {
		return vsbPrsPrf;
	}

	public void setVsbPrsPrf(boolean vsbPrsPrf) {
		this.vsbPrsPrf = vsbPrsPrf;
	}

	public boolean isRqrPrsPrf() {
		return rqrPrsPrf;
	}

	public void setRqrPrsPrf(boolean rqrPrsPrf) {
		this.rqrPrsPrf = rqrPrsPrf;
	}

	public boolean isDsbYr() {
		return dsbYr;
	}

	public void setDsbYr(boolean dsbYr) {
		this.dsbYr = dsbYr;
	}

	public boolean isVsbYr() {
		return vsbYr;
	}

	public void setVsbYr(boolean vsbYr) {
		this.vsbYr = vsbYr;
	}

	public boolean isRqrYr() {
		return rqrYr;
	}

	public void setRqrYr(boolean rqrYr) {
		this.rqrYr = rqrYr;
	}

	public boolean isDsbEpi() {
		return dsbEpi;
	}

	public void setDsbEpi(boolean dsbEpi) {
		this.dsbEpi = dsbEpi;
	}

	public boolean isVsbEpi() {
		return vsbEpi;
	}

	public void setVsbEpi(boolean vsbEpi) {
		this.vsbEpi = vsbEpi;
	}

	public boolean isRqrEpi() {
		return rqrEpi;
	}

	public void setRqrEpi(boolean rqrEpi) {
		this.rqrEpi = rqrEpi;
	}

	public boolean isDsbTrp() {
		return dsbTrp;
	}

	public void setDsbTrp(boolean dsbTrp) {
		this.dsbTrp = dsbTrp;
	}

	public boolean isVsbTrp() {
		return vsbTrp;
	}

	public void setVsbTrp(boolean vsbTrp) {
		this.vsbTrp = vsbTrp;
	}

	public boolean isRqrTrp() {
		return rqrTrp;
	}

	public void setRqrTrp(boolean rqrTrp) {
		this.rqrTrp = rqrTrp;
	}

	public int getITrpId() {
		return ITrpId;
	}

	public void setITrpId(int iTrpId) {
		ITrpId = iTrpId;
	}

	public boolean isDsbSte() {
		return dsbSte;
	}

	public void setDsbSte(boolean dsbSte) {
		this.dsbSte = dsbSte;
	}

	public boolean isVsbSte() {
		return vsbSte;
	}

	public void setVsbSte(boolean vsbSte) {
		this.vsbSte = vsbSte;
	}

	public boolean isRqrSte() {
		return rqrSte;
	}

	public void setRqrSte(boolean rqrSte) {
		this.rqrSte = rqrSte;
	}

	public boolean isDsbDteSet() {
		return dsbDteSet;
	}

	public void setDsbDteSet(boolean dsbDteSet) {
		this.dsbDteSet = dsbDteSet;
	}

	public boolean isVsbDteSet() {
		return vsbDteSet;
	}

	public void setVsbDteSet(boolean vsbDteSet) {
		this.vsbDteSet = vsbDteSet;
	}

	public boolean isRqrDteSet() {
		return rqrDteSet;
	}

	public void setRqrDteSet(boolean rqrDteSet) {
		this.rqrDteSet = rqrDteSet;
	}

	public boolean isDsbDteClc() {
		return dsbDteClc;
	}

	public void setDsbDteClc(boolean dsbDteClc) {
		this.dsbDteClc = dsbDteClc;
	}

	public boolean isVsbDteClc() {
		return vsbDteClc;
	}

	public void setVsbDteClc(boolean vsbDteClc) {
		this.vsbDteClc = vsbDteClc;
	}

	public boolean isRqrDteClc() {
		return rqrDteClc;
	}

	public void setRqrDteClc(boolean rqrDteClc) {
		this.rqrDteClc = rqrDteClc;
	}

	public boolean isDsbTrpRcv() {
		return dsbTrpRcv;
	}

	public void setDsbTrpRcv(boolean dsbTrpRcv) {
		this.dsbTrpRcv = dsbTrpRcv;
	}

	public boolean isVsbTrpRcv() {
		return vsbTrpRcv;
	}

	public void setVsbTrpRcv(boolean vsbTrpRcv) {
		this.vsbTrpRcv = vsbTrpRcv;
	}

	public boolean isRqrTrpRcv() {
		return rqrTrpRcv;
	}

	public void setRqrTrpRcv(boolean rqrTrpRcv) {
		this.rqrTrpRcv = rqrTrpRcv;
	}

	public boolean isDsbTrpSup() {
		return dsbTrpSup;
	}

	public void setDsbTrpSup(boolean dsbTrpSup) {
		this.dsbTrpSup = dsbTrpSup;
	}

	public boolean isVsbTrpSup() {
		return vsbTrpSup;
	}

	public void setVsbTrpSup(boolean vsbTrpSup) {
		this.vsbTrpSup = vsbTrpSup;
	}

	public boolean isRqrTrpSup() {
		return rqrTrpSup;
	}

	public void setRqrTrpSup(boolean rqrTrpSup) {
		this.rqrTrpSup = rqrTrpSup;
	}

	public boolean isDsbLrsStg() {
		return dsbLrsStg;
	}

	public void setDsbLrsStg(boolean dsbLrsStg) {
		this.dsbLrsStg = dsbLrsStg;
	}

	public boolean isVsbLrsStg() {
		return vsbLrsStg;
	}

	public void setVsbLrsStg(boolean vsbLrsStg) {
		this.vsbLrsStg = vsbLrsStg;
	}

	public boolean isRqrLrsStg() {
		return rqrLrsStg;
	}

	public void setRqrLrsStg(boolean rqrLrsStg) {
		this.rqrLrsStg = rqrLrsStg;
	}

	public int getILrsStgId() {
		return ILrsStgId;
	}

	public void setILrsStgId(int iLrsStgId) {
		ILrsStgId = iLrsStgId;
	}

	public List<SitTblGnrDtl> getLstLrsStgSlc() {
		return lstLrsStgSlc;
	}

	public void setLstLrsStgSlc(List<SitTblGnrDtl> lstLrsStgCmp) {
		this.lstLrsStgSlc = lstLrsStgCmp;
	}

	public boolean isDsbBEgs() {
		return dsbBEgs;
	}

	public void setDsbBEgs(boolean dsbBEgs) {
		this.dsbBEgs = dsbBEgs;
	}

	public boolean isVsbBEgs() {
		return vsbBEgs;
	}

	public void setVsbBEgs(boolean vsbBEgs) {
		this.vsbBEgs = vsbBEgs;
	}

	public boolean isRqrBEgs() {
		return rqrBEgs;
	}

	public void setRqrBEgs(boolean rqrBEgs) {
		this.rqrBEgs = rqrBEgs;
	}

	public boolean isDsbBLrs() {
		return dsbBLrs;
	}

	public void setDsbBLrs(boolean dsbBLrs) {
		this.dsbBLrs = dsbBLrs;
	}

	public boolean isVsbBLrs() {
		return vsbBLrs;
	}

	public void setVsbBLrs(boolean vsbBLrs) {
		this.vsbBLrs = vsbBLrs;
	}

	public boolean isRqrBLrs() {
		return rqrBLrs;
	}

	public void setRqrBLrs(boolean rqrBLrs) {
		this.rqrBLrs = rqrBLrs;
	}

	public boolean isDsbNmb() {
		return dsbNmb;
	}

	public void setDsbNmb(boolean dsbNmb) {
		this.dsbNmb = dsbNmb;
	}

	public boolean isVsbNmb() {
		return vsbNmb;
	}

	public void setVsbNmb(boolean vsbNmb) {
		this.vsbNmb = vsbNmb;
	}

	public boolean isRqrNmb() {
		return rqrNmb;
	}

	public void setRqrNmb(boolean rqrNmb) {
		this.rqrNmb = rqrNmb;
	}

	public int getINmbId() {
		return INmbId;
	}

	public void setINmbId(int iNmbId) {
		INmbId = iNmbId;
	}

	public SitTblNmb getNmb() {
		return nmb;
	}

	public void setNmb(SitTblNmb nmb) {
		this.nmb = nmb;
	}

	public boolean isBGnrAdl() {
		return BGnrAdl;
	}

	public void setBGnrAdl(boolean bGnrAdl) {
		BGnrAdl = bGnrAdl;
	}

	public boolean isDsbPrj() {
		return dsbPrj;
	}

	public void setDsbPrj(boolean dsbPrj) {
		this.dsbPrj = dsbPrj;
	}

	public boolean isVsbPrj() {
		return vsbPrj;
	}

	public void setVsbPrj(boolean vsbPrj) {
		this.vsbPrj = vsbPrj;
	}

	public boolean isRqrPrj() {
		return rqrPrj;
	}

	public void setRqrPrj(boolean rqrPrj) {
		this.rqrPrj = rqrPrj;
	}

	public int getIPrjId() {
		return IPrjId;
	}

	public void setIPrjId(int iPrjId) {
		IPrjId = iPrjId;
	}

	public int getIEgsTtl() {
		return IEgsTtl;
	}

	public void setIEgsTtl(int iEgsTtl) {
		IEgsTtl = iEgsTtl;
	}

	public boolean isDsbGnrObsEgs() {
		return dsbGnrObsEgs;
	}

	public void setDsbGnrObsEgs(boolean dsbGnrObsEgs) {
		this.dsbGnrObsEgs = dsbGnrObsEgs;
	}

	public boolean isVsbGnrObsEgs() {
		return vsbGnrObsEgs;
	}

	public void setVsbGnrObsEgs(boolean vsbGnrObsEgs) {
		this.vsbGnrObsEgs = vsbGnrObsEgs;
	}

	public boolean isRqrGnrObsEgs() {
		return rqrGnrObsEgs;
	}

	public void setRqrGnrObsEgs(boolean rqrGnrObsEgs) {
		this.rqrGnrObsEgs = rqrGnrObsEgs;
	}

	public boolean isDsbGnrObsLrv() {
		return dsbGnrObsLrv;
	}

	public void setDsbGnrObsLrv(boolean dsbGnrObsLrv) {
		this.dsbGnrObsLrv = dsbGnrObsLrv;
	}

	public boolean isVsbGnrObsLrv() {
		return vsbGnrObsLrv;
	}

	public void setVsbGnrObsLrv(boolean vsbGnrObsLrv) {
		this.vsbGnrObsLrv = vsbGnrObsLrv;
	}

	public boolean isRqrGnrObsLrv() {
		return rqrGnrObsLrv;
	}

	public void setRqrGnrObsLrv(boolean rqrGnrObsLrv) {
		this.rqrGnrObsLrv = rqrGnrObsLrv;
	}

	public boolean isDsbGnrObsAdl() {
		return dsbGnrObsAdl;
	}

	public void setDsbGnrObsAdl(boolean dsbGnrObsAdl) {
		this.dsbGnrObsAdl = dsbGnrObsAdl;
	}

	public boolean isVsbGnrObsAdl() {
		return vsbGnrObsAdl;
	}

	public void setVsbGnrObsAdl(boolean vsbGnrObsAdl) {
		this.vsbGnrObsAdl = vsbGnrObsAdl;
	}

	public boolean isRqrGnrObsAdl() {
		return rqrGnrObsAdl;
	}

	public void setRqrGnrObsAdl(boolean rqrGnrObsAdl) {
		this.rqrGnrObsAdl = rqrGnrObsAdl;
	}

	public boolean isDsbGnrDtlLrvNmb() {
		return dsbGnrDtlLrvNmb;
	}

	public void setDsbGnrDtlLrvNmb(boolean dsbGnrDtlLrvNmb) {
		this.dsbGnrDtlLrvNmb = dsbGnrDtlLrvNmb;
	}

	public boolean isVsbGnrDtlLrvNmb() {
		return vsbGnrDtlLrvNmb;
	}

	public void setVsbGnrDtlLrvNmb(boolean vsbGnrDtlLrvNmb) {
		this.vsbGnrDtlLrvNmb = vsbGnrDtlLrvNmb;
	}

	public boolean isRqrGnrDtlLrvNmb() {
		return rqrGnrDtlLrvNmb;
	}

	public void setRqrGnrDtlLrvNmb(boolean rqrGnrDtlLrvNmb) {
		this.rqrGnrDtlLrvNmb = rqrGnrDtlLrvNmb;
	}

	public boolean isDsbGnrDtlLrvStg() {
		return dsbGnrDtlLrvStg;
	}

	public void setDsbGnrDtlLrvStg(boolean dsbGnrDtlLrvStg) {
		this.dsbGnrDtlLrvStg = dsbGnrDtlLrvStg;
	}

	public boolean isVsbGnrDtlLrvStg() {
		return vsbGnrDtlLrvStg;
	}

	public void setVsbGnrDtlLrvStg(boolean vsbGnrDtlLrvStg) {
		this.vsbGnrDtlLrvStg = vsbGnrDtlLrvStg;
	}

	public boolean isRqrGnrDtlLrvStg() {
		return rqrGnrDtlLrvStg;
	}

	public void setRqrGnrDtlLrvStg(boolean rqrGnrDtlLrvStg) {
		this.rqrGnrDtlLrvStg = rqrGnrDtlLrvStg;
	}

	public boolean isDsbGnrDtlLrvSex() {
		return dsbGnrDtlLrvSex;
	}

	public void setDsbGnrDtlLrvSex(boolean dsbGnrDtlLrvSex) {
		this.dsbGnrDtlLrvSex = dsbGnrDtlLrvSex;
	}

	public boolean isVsbGnrDtlLrvSex() {
		return vsbGnrDtlLrvSex;
	}

	public void setVsbGnrDtlLrvSex(boolean vsbGnrDtlLrvSex) {
		this.vsbGnrDtlLrvSex = vsbGnrDtlLrvSex;
	}

	public boolean isRqrGnrDtlLrvSex() {
		return rqrGnrDtlLrvSex;
	}

	public void setRqrGnrDtlLrvSex(boolean rqrGnrDtlLrvSex) {
		this.rqrGnrDtlLrvSex = rqrGnrDtlLrvSex;
	}

	public boolean isDsbGnrDtlLrvSpc() {
		return dsbGnrDtlLrvSpc;
	}

	public void setDsbGnrDtlLrvSpc(boolean dsbGnrDtlLrvSpc) {
		this.dsbGnrDtlLrvSpc = dsbGnrDtlLrvSpc;
	}

	public boolean isVsbGnrDtlLrvSpc() {
		return vsbGnrDtlLrvSpc;
	}

	public void setVsbGnrDtlLrvSpc(boolean vsbGnrDtlLrvSpc) {
		this.vsbGnrDtlLrvSpc = vsbGnrDtlLrvSpc;
	}

	public boolean isRqrGnrDtlLrvSpc() {
		return rqrGnrDtlLrvSpc;
	}

	public void setRqrGnrDtlLrvSpc(boolean rqrGnrDtlLrvSpc) {
		this.rqrGnrDtlLrvSpc = rqrGnrDtlLrvSpc;
	}

	public boolean isDsbGnrDtlLrvNmbDied() {
		return dsbGnrDtlLrvNmbDied;
	}

	public void setDsbGnrDtlLrvNmbDied(boolean dsbGnrDtlLrvNmbDied) {
		this.dsbGnrDtlLrvNmbDied = dsbGnrDtlLrvNmbDied;
	}

	public boolean isVsbGnrDtlLrvNmbDied() {
		return vsbGnrDtlLrvNmbDied;
	}

	public void setVsbGnrDtlLrvNmbDied(boolean vsbGnrDtlLrvNmbDied) {
		this.vsbGnrDtlLrvNmbDied = vsbGnrDtlLrvNmbDied;
	}

	public boolean isRqrGnrDtlLrvNmbDied() {
		return rqrGnrDtlLrvNmbDied;
	}

	public void setRqrGnrDtlLrvNmbDied(boolean rqrGnrDtlLrvNmbDied) {
		this.rqrGnrDtlLrvNmbDied = rqrGnrDtlLrvNmbDied;
	}

	public boolean isDsbBtnLrvAdd() {
		return dsbBtnLrvAdd;
	}

	public void setDsbBtnLrvAdd(boolean dsbBtnLrvAdd) {
		this.dsbBtnLrvAdd = dsbBtnLrvAdd;
	}

	public boolean isVsbBtnLrvAdd() {
		return vsbBtnLrvAdd;
	}

	public void setVsbBtnLrvAdd(boolean vsbBtnLrvAdd) {
		this.vsbBtnLrvAdd = vsbBtnLrvAdd;
	}

	public boolean isDsbBtnLrvNew() {
		return dsbBtnLrvNew;
	}

	public void setDsbBtnLrvNew(boolean dsbBtnLrvNew) {
		this.dsbBtnLrvNew = dsbBtnLrvNew;
	}

	public boolean isVsbBtnLrvNew() {
		return vsbBtnLrvNew;
	}

	public void setVsbBtnLrvNew(boolean vsbBtnLrvNew) {
		this.vsbBtnLrvNew = vsbBtnLrvNew;
	}

	public boolean isDsbBtnLrvRst() {
		return dsbBtnLrvRst;
	}

	public void setDsbBtnLrvRst(boolean dsbBtnLrvRst) {
		this.dsbBtnLrvRst = dsbBtnLrvRst;
	}

	public boolean isVsbBtnLrvRst() {
		return vsbBtnLrvRst;
	}

	public void setVsbBtnLrvRst(boolean vsbBtnLrvRst) {
		this.vsbBtnLrvRst = vsbBtnLrvRst;
	}

	public boolean isDsbBtnAdlAdd() {
		return dsbBtnAdlAdd;
	}

	public void setDsbBtnAdlAdd(boolean dsbBtnAdlAdd) {
		this.dsbBtnAdlAdd = dsbBtnAdlAdd;
	}

	public boolean isVsbBtnAdlAdd() {
		return vsbBtnAdlAdd;
	}

	public void setVsbBtnAdlAdd(boolean vsbBtnAdlAdd) {
		this.vsbBtnAdlAdd = vsbBtnAdlAdd;
	}

	public boolean isDsbBtnAdlNew() {
		return dsbBtnAdlNew;
	}

	public void setDsbBtnAdlNew(boolean dsbBtnAdlNew) {
		this.dsbBtnAdlNew = dsbBtnAdlNew;
	}

	public boolean isVsbBtnAdlNew() {
		return vsbBtnAdlNew;
	}

	public void setVsbBtnAdlNew(boolean vsbBtnAdlNew) {
		this.vsbBtnAdlNew = vsbBtnAdlNew;
	}

	public boolean isDsbBtnAdlRst() {
		return dsbBtnAdlRst;
	}

	public void setDsbBtnAdlRst(boolean dsbBtnAdlRst) {
		this.dsbBtnAdlRst = dsbBtnAdlRst;
	}

	public boolean isVsbBtnAdlRst() {
		return vsbBtnAdlRst;
	}

	public void setVsbBtnAdlRst(boolean vsbBtnAdlRst) {
		this.vsbBtnAdlRst = vsbBtnAdlRst;
	}

	public int getISexId() {
		return ISexId;
	}

	public void setISexId(int iSexId) {
		ISexId = iSexId;
	}

	public int getISpcId() {
		return ISpcId;
	}

	public void setISpcId(int iSpcId) {
		ISpcId = iSpcId;
	}

	public List<ScrTblPrsRol> getLstAgn() {
		return lstAgn;
	}

	public void setLstAgn(List<ScrTblPrsRol> lstAgn) {
		this.lstAgn = lstAgn;
	}

	public List<ScrTblPrsRol> getLstTch() {
		return lstTch;
	}

	public void setLstTch(List<ScrTblPrsRol> lstTch) {
		this.lstTch = lstTch;
	}

	public List<ScrTblPrsRol> getLstAgnCmp() {
		return lstAgnCmp;
	}

	public void setLstAgnCmp(List<ScrTblPrsRol> lstAgnCmp) {
		this.lstAgnCmp = lstAgnCmp;
	}

	public List<ScrTblPrsRol> getLstTchCmp() {
		return lstTchCmp;
	}

	public void setLstTchCmp(List<ScrTblPrsRol> lstTchCmp) {
		this.lstTchCmp = lstTchCmp;
	}

	public String getIAgnId() {
		return IAgnId;
	}

	public void setIAgnId(String iAgnId) {
		IAgnId = iAgnId;
	}

	public String getITchId() {
		return ITchId;
	}

	public void setITchId(String iTchId) {
		ITchId = iTchId;
	}

	public boolean isDsbGnrDtlLrvNmbLive() {
		return dsbGnrDtlLrvNmbLive;
	}

	public void setDsbGnrDtlLrvNmbLive(boolean dsbGnrDtlLrvNmbLive) {
		this.dsbGnrDtlLrvNmbLive = dsbGnrDtlLrvNmbLive;
	}

	public boolean isVsbGnrDtlLrvNmbLive() {
		return vsbGnrDtlLrvNmbLive;
	}

	public void setVsbGnrDtlLrvNmbLive(boolean vsbGnrDtlLrvNmbLive) {
		this.vsbGnrDtlLrvNmbLive = vsbGnrDtlLrvNmbLive;
	}

	public boolean isRqrGnrDtlLrvNmbLive() {
		return rqrGnrDtlLrvNmbLive;
	}

	public void setRqrGnrDtlLrvNmbLive(boolean rqrGnrDtlLrvNmbLive) {
		this.rqrGnrDtlLrvNmbLive = rqrGnrDtlLrvNmbLive;
	}

	public SitTblGnrDtl getGnrDtl() {
		return gnrDtl;
	}

	public void setGnrDtl(SitTblGnrDtl gnrDtl) {
		this.gnrDtl = gnrDtl;
	}

	public boolean isDsbBAdl() {
		return dsbBAdl;
	}

	public void setDsbBAdl(boolean dsbBAdl) {
		this.dsbBAdl = dsbBAdl;
	}

	public boolean isVsbBAdl() {
		return vsbBAdl;
	}

	public void setVsbBAdl(boolean vsbBAdl) {
		this.vsbBAdl = vsbBAdl;
	}

	public boolean isRqrBAdl() {
		return rqrBAdl;
	}

	public void setRqrBAdl(boolean rqrBAdl) {
		this.rqrBAdl = rqrBAdl;
	}

	public boolean isDsbGnrPrfAgn() {
		return dsbGnrPrfAgn;
	}

	public void setDsbGnrPrfAgn(boolean dsbGnrPrfAgn) {
		this.dsbGnrPrfAgn = dsbGnrPrfAgn;
	}

	public boolean isVsbGnrPrfAgn() {
		return vsbGnrPrfAgn;
	}

	public void setVsbGnrPrfAgn(boolean vsbGnrPrfAgn) {
		this.vsbGnrPrfAgn = vsbGnrPrfAgn;
	}

	public boolean isRqrGnrPrfAgn() {
		return rqrGnrPrfAgn;
	}

	public void setRqrGnrPrfAgn(boolean rqrGnrPrfAgn) {
		this.rqrGnrPrfAgn = rqrGnrPrfAgn;
	}

	public boolean isDsbGnrPrfTch() {
		return dsbGnrPrfTch;
	}

	public void setDsbGnrPrfTch(boolean dsbGnrPrfTch) {
		this.dsbGnrPrfTch = dsbGnrPrfTch;
	}

	public boolean isVsbGnrPrfTch() {
		return vsbGnrPrfTch;
	}

	public void setVsbGnrPrfTch(boolean vsbGnrPrfTch) {
		this.vsbGnrPrfTch = vsbGnrPrfTch;
	}

	public boolean isRqrGnrPrfTch() {
		return rqrGnrPrfTch;
	}

	public void setRqrGnrPrfTch(boolean rqrGnrPrfTch) {
		this.rqrGnrPrfTch = rqrGnrPrfTch;
	}

	public List<ScrTblPrsRol> getLstPrsPrfAgnAdd() {
		return lstPrsPrfAgnAdd;
	}

	public void setLstPrsPrfAgnAdd(List<ScrTblPrsRol> lstPrsPrfAgnAdd) {
		this.lstPrsPrfAgnAdd = lstPrsPrfAgnAdd;
	}

	public List<String> getIPrsPrfAgnSlcId() {
		return IPrsPrfAgnSlcId;
	}

	public void setIPrsPrfAgnSlcId(List<String> iPrsPrfAgnSlcId) {
		IPrsPrfAgnSlcId = iPrsPrfAgnSlcId;
	}

	public List<ScrTblPrsRol> getLstPrsPrfTchAdd() {
		return lstPrsPrfTchAdd;
	}

	public void setLstPrsPrfTchAdd(List<ScrTblPrsRol> lstPrsPrfTchAdd) {
		this.lstPrsPrfTchAdd = lstPrsPrfTchAdd;
	}

	public List<String> getIPrsPrfTchSlcId() {
		return IPrsPrfTchSlcId;
	}

	public void setIPrsPrfTchSlcId(List<String> iPrsPrfTchSlcId) {
		IPrsPrfTchSlcId = iPrsPrfTchSlcId;
	}

	public boolean isDsbAdlNmb() {
		return dsbAdlNmb;
	}

	public void setDsbAdlNmb(boolean dsbAdlNmb) {
		this.dsbAdlNmb = dsbAdlNmb;
	}

	public boolean isVsbAdlNmb() {
		return vsbAdlNmb;
	}

	public void setVsbAdlNmb(boolean vsbAdlNmb) {
		this.vsbAdlNmb = vsbAdlNmb;
	}

	public boolean isRqrAdlNmb() {
		return rqrAdlNmb;
	}

	public void setRqrAdlNmb(boolean rqrAdlNmb) {
		this.rqrAdlNmb = rqrAdlNmb;
	}

	public boolean isDsbAdlSex() {
		return dsbAdlSex;
	}

	public void setDsbAdlSex(boolean dsbAdlSex) {
		this.dsbAdlSex = dsbAdlSex;
	}

	public boolean isVsbAdlSex() {
		return vsbAdlSex;
	}

	public void setVsbAdlSex(boolean vsbAdlSex) {
		this.vsbAdlSex = vsbAdlSex;
	}

	public boolean isRqrAdlSex() {
		return rqrAdlSex;
	}

	public void setRqrAdlSex(boolean rqrAdlSex) {
		this.rqrAdlSex = rqrAdlSex;
	}

	public boolean isDsbAdlSpc() {
		return dsbAdlSpc;
	}

	public void setDsbAdlSpc(boolean dsbAdlSpc) {
		this.dsbAdlSpc = dsbAdlSpc;
	}

	public boolean isVsbAdlSpc() {
		return vsbAdlSpc;
	}

	public void setVsbAdlSpc(boolean vsbAdlSpc) {
		this.vsbAdlSpc = vsbAdlSpc;
	}

	public boolean isRqrAdlSpc() {
		return rqrAdlSpc;
	}

	public void setRqrAdlSpc(boolean rqrAdlSpc) {
		this.rqrAdlSpc = rqrAdlSpc;
	}

	public List<SitTblGnrDtl> getLstAdlSlc() {
		return lstAdlSlc;
	}

	public void setLstAdlSlc(List<SitTblGnrDtl> lstAdlSlc) {
		this.lstAdlSlc = lstAdlSlc;
	}

	public SitTblGnrDtl getGnrDtlAdl() {
		return gnrDtlAdl;
	}

	public void setGnrDtlAdl(SitTblGnrDtl gnrDtlAdl) {
		this.gnrDtlAdl = gnrDtlAdl;
	}

	public boolean isDsbGnrNmbUsd() {
		return dsbGnrNmbUsd;
	}

	public void setDsbGnrNmbUsd(boolean dsbGnrNmbUsd) {
		this.dsbGnrNmbUsd = dsbGnrNmbUsd;
	}

	public boolean isVsbGnrNmbUsd() {
		return vsbGnrNmbUsd;
	}

	public void setVsbGnrNmbUsd(boolean vsbGnrNmbUsd) {
		this.vsbGnrNmbUsd = vsbGnrNmbUsd;
	}

	public boolean isRqrGnrNmbUsd() {
		return rqrGnrNmbUsd;
	}

	public void setRqrGnrNmbUsd(boolean rqrGnrNmbUsd) {
		this.rqrGnrNmbUsd = rqrGnrNmbUsd;
	}

	public SitTblGnrDtl getGnrDtlLrv() {
		return gnrDtlLrv;
	}

	public void setGnrDtlLrv(SitTblGnrDtl gnrDtlLrv) {
		this.gnrDtlLrv = gnrDtlLrv;
	}

	public int getITtlLrsId() {
		return ITtlLrsId;
	}

	public void setITtlLrsId(int iTtlLrsId) {
		ITtlLrsId = iTtlLrsId;
	}

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

	public boolean isVsbBtnAddCpy() {
		return vsbBtnAddCpy;
	}

	public void setVsbBtnAddCpy(boolean vsbBtnAddCpy) {
		this.vsbBtnAddCpy = vsbBtnAddCpy;
	}

	public boolean isDsbBtnAddCpy() {
		return dsbBtnAddCpy;
	}

	public void setDsbBtnAddCpy(boolean dsbBtnAddCpy) {
		this.dsbBtnAddCpy = dsbBtnAddCpy;
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

	public ScrTblPrsRol getPrl() {
		return prl;
	}

	public void setPrl(ScrTblPrsRol prl) {
		this.prl = prl;
	}

	public boolean isDsbTpe() {
		return dsbTpe;
	}

	public void setDsbTpe(boolean dsbTpe) {
		this.dsbTpe = dsbTpe;
	}

	public boolean isVsbTpe() {
		return vsbTpe;
	}

	public void setVsbTpe(boolean vsbTpe) {
		this.vsbTpe = vsbTpe;
	}

	public boolean isRqrTpe() {
		return rqrTpe;
	}

	public void setRqrTpe(boolean rqrTpe) {
		this.rqrTpe = rqrTpe;
	}

	public int getITpeId() {
		return ITpeId;
	}

	public void setITpeId(int iTpeId) {
		ITpeId = iTpeId;
	}

}
