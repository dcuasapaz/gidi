package ec.gob.msp.pms.ctl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.gob.msp.pms.cmm.Code;
import ec.gob.msp.pms.cmm.Default;
import ec.gob.msp.pms.cmm.Email;
import ec.gob.msp.pms.cmm.Message;
import ec.gob.msp.pms.cmm.Method;
import ec.gob.msp.pms.ent.DpaTblCnt;
import ec.gob.msp.pms.ent.DpaTblOpt;
import ec.gob.msp.pms.ent.DtaTblPr;
import ec.gob.msp.pms.ent.ScrTblOpt;
import ec.gob.msp.pms.ent.ScrTblPrsRol;
import ec.gob.msp.pms.ent.WebTblClr;
import ec.gob.msp.pms.itf.DbIftGnr;
import ec.gob.msp.pms.itf.ScrIftPrsRol;
import ec.gob.msp.pms.srv.DpaSrvCnt;
import ec.gob.msp.pms.srv.DpaSrvOpt;
import ec.gob.msp.pms.srv.DtaSrvPrs;
import ec.gob.msp.pms.srv.PmsSrvMnc;
import ec.gob.msp.pms.srv.ScrSrvOpt;
import ec.gob.msp.pms.srv.ScrSrvPrsRol;
import ec.gob.msp.pms.srv.WebSrvClr;

@ViewScoped
@ManagedBean
public class ScrCtlPrsRol implements DbIftGnr, ScrIftPrsRol {

	protected Default dfl;
	protected Message msg;
	protected Method mth;
	protected Code cde;
	protected Email eml;

	/*******************************************************/
	public ScrCtlPrsRol() {
		dfl = new Default();
		msg = new Message();
		mth = new Method();
		cde = new Code();
		prs = new DtaTblPr();
		prsRol = new ScrTblPrsRol();
		sss = new ScrCtlSss();
		eml = new Email();
	}

	/*******************************************************/
	@Override
	@PostConstruct
	public void init() {
		this.actSpcFrm(true, false);
		this.actBtnAdd(false, true);
		this.actBtnSve(true, true);
		this.actBtnUpd(true, true);
		this.actBtnEdt(false, true);
		this.actBtnDlt(false, true);
		this.actBtnRfr(false, true);
		this.actBtnPdf(true, true);
		this.actBtnCsv(true, true);
		this.actPrsLstNme(true, true, false);
		this.actPrsNme(true, true, false);

		this.actPrsEml(true, true, false);
		this.actBtnVldPrsEml(true, true);
		this.actPrsUsr(true, true, false);
		this.actBtnVldPrsUsr(true, true);
		this.actPrsPsw(true, true, false);
		this.actBtnGntrPrsPsw(true, true);

		this.actPrsRolRol(true, true, false);
		this.actPrsRolStt(true, true, false);
		this.actBtnPrsRolNew(true, true);
		this.actBtnPrsRolAdd(true, true);
		this.actBtnPrsRolUpd(true, true);
		this.actBtnPrsRolRfr(true, true);
		this.actBtnPrsRolEdt(true, true);
		this.actBtnPrsRolDlt(true, true);
		this.actCnt(true, true, false);
		this.actCntPrv(true, true, false);
		this.actCntPrvChk(true, true, false);

	}

	/*******************************************************/
	@Override
	public void cptAdd() {
		this.actSpcFrm(false, true);
		this.actBtnAdd(true, true);
		this.actBtnSve(false, true);
		this.actBtnUpd(true, true);
		this.actBtnEdt(true, true);
		this.actBtnDlt(true, true);
		this.actBtnRfr(false, true);
		this.actPrsLstNme(false, true, true);
		this.actPrsNme(false, true, true);
		this.actPrsEml(false, true, true);
		this.actBtnVldPrsEml(false, true);
	}

	@Override
	public void add() {
		try {
			this.cptAdd();
			prs = new DtaTblPr();
			prsRol = new ScrTblPrsRol();
			ICntCde = 0;
			IRolId = 0;
			rol = new ScrTblOpt();
			stt = new ScrTblOpt();
			ISttId = 0;
			this.newLstPrsRol();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*******************************************************/
	@Override
	public void cptEdt() {
		this.actSpcFrm(false, true);
		this.actBtnAdd(true, true);
		this.actBtnSve(true, true);
		this.actBtnUpd(false, true);
		this.actBtnEdt(true, true);
		this.actBtnDlt(true, true);
		this.actBtnRfr(false, true);

		this.actPrsLstNme(false, true, true);
		this.actPrsNme(false, true, true);
		this.actPrsEml(false, true, true);
		this.actBtnVldPrsEml(false, true);
		this.actPrsUsr(false, true, true);
		this.actBtnVldPrsUsr(false, true);
		this.actPrsPsw(true, true, true);
		this.actBtnGntrPrsPsw(false, true);

		this.actBtnPrsRolEdt(false, true);
		this.actBtnPrsRolDlt(false, true);
		this.actBtnPrsRolNew(false, true);
		this.actBtnPrsRolRfr(false, true);
	}

	@Override
	public void edt() {
		try {
			this.cptEdt();
			this.newLstPrsRol();
			lstPrsRol = SPrsRol.lstRol(prs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*******************************************************/
	@Override
	public void cptSve() {
		this.init();
	}

	@Override
	public void sve() {
		try {
			String prl = "";
			String ent = "";
			if (SPrs.sve(prs) != false) {
				Iterator<ScrTblPrsRol> itPrsRol = lstPrsRol.iterator();
				while (itPrsRol.hasNext()) {
					ScrTblPrsRol prsRolAux = itPrsRol.next();
					if (SPrsRol.sve(prsRolAux.getIRolId(), prs, prsRolAux.getISttId(),
							prsRolAux.getDpaTblCnt()) != true) {
						this.msg.msgErr(msg.getSMsgSveErr());
						break;
					} else {
						if (lstPrsRol.size() == 1) {
							prl = prl + SScrOpt.searchId(prsRolAux.getIRolId()).getSOptNmeSpn() + ".";
						} else {
							prl = prl + SScrOpt.searchId(prsRolAux.getIRolId()).getSOptNmeSpn() + ", ";
						}
						ent = prsRolAux.getDpaTblCnt().getSCntNme();
					}
				}
				if (lstPrsRol.size() > 1) {
					prl = prl.substring(0, prl.length() - 2) + ".";
				}
				if (eml.sndEmlPrf(prs, prl, ent) != false) {
					this.msg.msgInf(msg.getSMsgSveOk());
				}
			} else {
				this.msg.msgErr(msg.getSMsgSveErr());
			}
			this.cptSve();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*******************************************************/
	@Override
	public void cptUpd() {
		this.init();
	}

	@Override
	public void upd() {
		try {
			if (SPrs.upd(prs) != false) {
				Iterator<ScrTblPrsRol> itPrsRol = SPrsRol.lstRol(prs).iterator();
				while (itPrsRol.hasNext()) {
					ScrTblPrsRol prsRolAux = itPrsRol.next();
					SPrsRol.delete(prsRolAux);
				}
				Iterator<ScrTblPrsRol> itPrsRolUpd = lstPrsRol.iterator();
				while (itPrsRolUpd.hasNext()) {
					ScrTblPrsRol prsRolAux = itPrsRolUpd.next();
					if (SPrsRol.sve(prsRolAux.getIRolId(), prs, prsRolAux.getISttId(),
							prsRolAux.getDpaTblCnt()) != true) {
						this.msg.msgErr(msg.getSMsgSveErr());
						break;
					}
				}
				this.msg.msgInf(msg.getSMsgUpdOk());
			} else {
				this.msg.msgErr(msg.getSMsgUpdErr());
			}
			this.cptUpd();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*******************************************************/
	@Override
	public void cptDlt() {
		this.init();
	}

	@Override
	public void dlt() {
		try {

			this.cptDlt();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*******************************************************/
	@EJB
	protected PmsSrvMnc SMnc;
	/*******************************************************/
	protected ScrCtlSss sss;

	/*******************************************************/
	private boolean dsbPrsNme;
	private boolean vsbPrsNme;
	private boolean rqrPrsNme;

	private boolean dsbPrsLstNme;
	private boolean vsbPrsLstNme;
	private boolean rqrPrsLstNme;

	private boolean dsbPrsEml;
	private boolean vsbPrsEml;
	private boolean rqrPrsEml;

	private boolean dsbBtnVldPrsEml;
	private boolean vsbBtnVldPrsEml;

	private boolean dsbPrsUsr;
	private boolean vsbPrsUsr;
	private boolean rqrPrsUsr;

	private boolean dsbBtnVldPrsUsr;
	private boolean vsbBtnVldPrsUsr;

	private boolean dsbPrsPsw;
	private boolean vsbPrsPsw;
	private boolean rqrPrsPsw;

	private boolean dsbBtnGntrPrsPsw;
	private boolean vsbBtnGntrPrsPsw;

	private void actPrsNme(boolean dsb, boolean vsb, boolean rqr) {
		dsbPrsNme = dsb;
		vsbPrsNme = vsb;
		rqrPrsNme = rqr;
	}

	private void actPrsLstNme(boolean dsb, boolean vsb, boolean rqr) {
		dsbPrsLstNme = dsb;
		vsbPrsLstNme = vsb;
		rqrPrsLstNme = rqr;
	}

	private void actPrsEml(boolean dsb, boolean vsb, boolean rqr) {
		dsbPrsEml = dsb;
		vsbPrsEml = vsb;
		rqrPrsEml = rqr;
	}

	private void actBtnVldPrsEml(boolean dsb, boolean vsb) {
		dsbBtnVldPrsEml = dsb;
		vsbBtnVldPrsEml = vsb;
	}

	private void actPrsUsr(boolean dsb, boolean vsb, boolean rqr) {
		dsbPrsUsr = dsb;
		vsbPrsUsr = vsb;
		rqrPrsUsr = rqr;
	}

	private void actBtnVldPrsUsr(boolean dsb, boolean vsb) {
		dsbBtnVldPrsUsr = dsb;
		vsbBtnVldPrsUsr = vsb;
	}

	private void actPrsPsw(boolean dsb, boolean vsb, boolean rqr) {
		dsbPrsPsw = dsb;
		vsbPrsPsw = vsb;
		rqrPrsPsw = rqr;
	}

	private void actBtnGntrPrsPsw(boolean dsb, boolean vsb) {
		dsbBtnGntrPrsPsw = dsb;
		vsbBtnGntrPrsPsw = vsb;
	}

	@EJB
	protected DtaSrvPrs SPrs;
	private DtaTblPr prs;

	@Override
	public void srcPrsEml() {
		try {
			List<DtaTblPr> lstPrsAux = new ArrayList<DtaTblPr>();
			lstPrsAux = SPrs.srcAll();
			Iterator<DtaTblPr> itPrs = lstPrsAux.iterator();
			while (itPrs.hasNext()) {
				DtaTblPr prsAux = itPrs.next();
				if (prsAux.getSPrsEml().compareToIgnoreCase(prs.getSPrsEml()) == 0) {
					this.msg.msgWrn(msg.getMsgWrnSrcEml());
					this.actPrsUsr(true, true, true);
					this.actBtnVldPrsUsr(true, true);
				} else {
					this.actPrsUsr(false, true, true);
					this.actBtnVldPrsUsr(false, true);
					this.msg.msgInf(msg.getMsgInfSrcEml());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.msg.msgErr(msg.getMsgErrSrcPrm());
		}
	}

	@Override
	public void srcPrsUsr() {
		try {
			List<DtaTblPr> lstPrsAux = new ArrayList<DtaTblPr>();
			lstPrsAux = SPrs.srcAll();
			Iterator<DtaTblPr> itPrs = lstPrsAux.iterator();
			while (itPrs.hasNext()) {
				DtaTblPr prsAux = itPrs.next();
				if (prsAux.getSPrsUsr().compareToIgnoreCase(prs.getSPrsUsr()) == 0) {
					this.msg.msgWrn(msg.getMsgWrnSrcUsr());
					this.actBtnGntrPrsPsw(true, true);
				} else {
					this.msg.msgInf(msg.getMsgInfSrcUsr());
					this.actBtnGntrPrsPsw(false, true);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.msg.msgErr(msg.getMsgErrSrcPrm());
		}
	}

	@Override
	public void gntrPrsPsw() {
		try {
			String psw = mth.getPassword(dfl, dfl.SKey(), prs.getSPrsUsr());
			if (psw != null) {
				prs.setSPrsPsw(psw);
				this.msg.msgInf(msg.getMsgInfGntrPsw());
				this.actPrsRolRol(false, true, true);
				this.actPrsRolStt(false, true, true);
				this.loadLstRol();
			} else {
				this.msg.msgErr(msg.getMsgErrGntrPsw());
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.msg.msgErr(msg.getMsgErrGntrPsw());
		}
	}

	/*******************************************************/

	private boolean dsbBtnPrsRolNew;
	private boolean vsbBtnPrsRolNew;

	private boolean dsbBtnPrsRolAdd;
	private boolean vsbBtnPrsRolAdd;

	private boolean dsbBtnPrsRolUpd;
	private boolean vsbBtnPrsRolUpd;

	private boolean dsbBtnPrsRolRfr;
	private boolean vsbBtnPrsRolRfr;

	private boolean dsbBtnPrsRolEdt;
	private boolean vsbBtnPrsRolEdt;

	private boolean dsbBtnPrsRolDlt;
	private boolean vsbBtnPrsRolDlt;

	private void actBtnPrsRolNew(boolean dsb, boolean vsb) {
		dsbBtnPrsRolNew = dsb;
		vsbBtnPrsRolNew = vsb;
	}

	private void actBtnPrsRolAdd(boolean dsb, boolean vsb) {
		dsbBtnPrsRolAdd = dsb;
		vsbBtnPrsRolAdd = vsb;
	}

	private void actBtnPrsRolUpd(boolean dsb, boolean vsb) {
		dsbBtnPrsRolUpd = dsb;
		vsbBtnPrsRolUpd = vsb;
	}

	private void actBtnPrsRolRfr(boolean dsb, boolean vsb) {
		dsbBtnPrsRolRfr = dsb;
		vsbBtnPrsRolRfr = vsb;
	}

	private void actBtnPrsRolEdt(boolean dsb, boolean vsb) {
		dsbBtnPrsRolEdt = dsb;
		vsbBtnPrsRolEdt = vsb;
	}

	private void actBtnPrsRolDlt(boolean dsb, boolean vsb) {
		dsbBtnPrsRolDlt = dsb;
		vsbBtnPrsRolDlt = vsb;
	}

	@EJB
	protected ScrSrvPrsRol SPrsRol;
	private ScrTblPrsRol prsRol;
	private List<ScrTblPrsRol> lstPrsRol;

	private void newLstPrsRol() {
		lstPrsRol = new ArrayList<ScrTblPrsRol>();
	}

	public ScrTblPrsRol loadPrl() {
		try {
			return sss.getPrl();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void newPrsRol() {
		try {
			this.actBtnPrsRolAdd(false, true);
			this.actBtnPrsRolNew(true, true);
			this.actBtnPrsRolDlt(true, true);
			this.actPrsRolRol(false, true, true);
			this.actPrsRolStt(false, true, true);
			prsRol = new ScrTblPrsRol();
			IRolId = 0;
			ISttId = 0;
			rol = new ScrTblOpt();
			stt = new ScrTblOpt();
			this.loadLstRol();
			for (ScrTblPrsRol prsRolAux : lstPrsRol) {
				for (ScrTblOpt rolAux : lstRol) {
					if (prsRolAux.getIRolId() == rolAux.getIOptId()) {
						if (lstRol.remove(rolAux) != false) {
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addPrsRol() {
		try {
			if (IRolId != dfl.IVleInt() && ISttId != dfl.IVleInt()) {
				prsRol.setIRolId(IRolId);
				prsRol.setDtaTblPr(prs);
				prsRol.setISttId(ISttId);
				prsRol.setDpaTblCnt(cnt);
				this.actBtnPrsRolAdd(true, true);
				this.actBtnPrsRolNew(false, true);
				this.actBtnPrsRolDlt(false, true);
				this.actPrsRolRol(true, true, false);
				this.actPrsRolStt(true, true, false);
				this.actCnt(true, true, false);
				this.newLstRol();
				ISttId = 0;
			} else {
				this.msg.msgWrn("!Seleccione un rol y su estado!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updPrsRol() {
		try {
			if (SPrsRol.upd(prsRol, ISttId) != false) {
				this.actPrsRolRol(true, true, false);
				this.actPrsRolStt(true, true, false);
				this.actBtnPrsRolUpd(true, true);
				this.actBtnPrsRolNew(false, true);
				rol = new ScrTblOpt();
				stt = new ScrTblOpt();
				ISttId = 0;
				IRolId = 0;
				this.newLstRol();
				this.msg.msgInf(msg.SMsgUpdOk);
			} else {
				this.msg.msgErr(msg.SMsgUpdErr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void rtrPrsRol() {
		try {
			this.actPrsRolRol(true, true, false);
			this.actPrsRolStt(true, true, false);
			this.actBtnPrsRolUpd(true, true);
			this.actBtnPrsRolNew(false, true);
			this.actBtnPrsRolAdd(true, true);
			this.actBtnPrsRolRfr(false, true);
			rol = new ScrTblOpt();
			stt = new ScrTblOpt();
			ISttId = 0;
			IRolId = 0;
			IPrvCde = 0;
			ICntCde = 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void edtPrsRol() {
		try {
			this.actPrsRolRol(false, true, true);
			this.actPrsRolStt(false, true, true);
			this.actBtnPrsRolUpd(false, true);
			this.actBtnPrsRolNew(true, true);
			this.loadLstRol();
			IRolId = prsRol.getIRolId();
			ISttId = prsRol.getISttId();
			rol = new ScrTblOpt();
			stt = new ScrTblOpt();
			rol = SScrOpt.searchId(IRolId);
			stt = SScrOpt.searchId(ISttId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dltPrsRol() {
		try {
			lstPrsRol.remove(prsRol);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*******************************************************/
	@EJB
	protected WebSrvClr SWebClr;
	/*******************************************************/
	private boolean dsbPrsRolRol;
	private boolean vsbPrsRolRol;
	private boolean rqrPrsRolRol;

	private void actPrsRolRol(boolean dsb, boolean vsb, boolean rqr) {
		dsbPrsRolRol = dsb;
		vsbPrsRolRol = vsb;
		rqrPrsRolRol = rqr;
	}

	private boolean dsbPrsRolStt;
	private boolean vsbPrsRolStt;
	private boolean rqrPrsRolStt;

	private void actPrsRolStt(boolean dsb, boolean vsb, boolean rqr) {
		dsbPrsRolStt = dsb;
		vsbPrsRolStt = vsb;
		rqrPrsRolStt = rqr;
	}

	@EJB
	protected ScrSrvOpt SScrOpt;
	private List<ScrTblOpt> lstRol;
	private int IRolId;
	private ScrTblOpt rol;
	private int ISttId;
	private ScrTblOpt stt;

	private void newLstRol() {
		lstRol = new ArrayList<ScrTblOpt>();
	}

	private void loadLstRol() {
		try {
			this.newLstRol();
			lstRol = SScrOpt.rtrLstEnt(cde.IScrRol(), true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String rtrRls(DtaTblPr prs) {
		try {
			String vleRol = "";
			List<ScrTblPrsRol> lstPrsRolAux = new ArrayList<ScrTblPrsRol>();
			lstPrsRolAux = SPrsRol.lstRol(prs);
			Collections.sort(lstPrsRolAux, new Comparator<ScrTblPrsRol>() {
				public int compare(ScrTblPrsRol o1, ScrTblPrsRol o2) {
					return o1.getIRolId().compareTo(o2.getIRolId());
				}
			});

			Iterator<ScrTblPrsRol> itPrsRol = lstPrsRolAux.iterator();
			while (itPrsRol.hasNext()) {
				ScrTblPrsRol prsRolAux = itPrsRol.next();
				ScrTblOpt optAux = new ScrTblOpt();
				ScrTblOpt sttAux = new ScrTblOpt();
				WebTblClr clrAux = new WebTblClr();
				optAux = SScrOpt.searchId(prsRolAux.getIRolId());
				sttAux = SScrOpt.searchId(prsRolAux.getISttId());
				clrAux = SWebClr.searchId(sttAux.getIClrId());
				vleRol = vleRol + "<div class=\"tbl-stt\"><div class=\" tbl-stt-shp \" style=\" background:"
						+ clrAux.getSClrHex() + ";\"></div>" + "<div class=\"tbl-stt-txt\"> - " + optAux.getSOptNmeSpn()
						+ "</div></div><br/>";
			}

			return vleRol;
		} catch (Exception e) {
			e.printStackTrace();
			return dfl.SVleNull();
		}

	}

	public void chsRol() {
		try {
			rol = new ScrTblOpt();
			rol = SScrOpt.searchId(IRolId);
			if (IRolId == cde.IScrRolAdmMsp() || IRolId == cde.IScrRolTcnMsp()) {
				this.actCnt(true, true, true);
				this.actCntPrvChk(true, true, false);
				this.actBtnPrsRolAdd(false, true);
				ICntCde = dfl.IVleInt();
				cnt = new DpaTblCnt();
				cnt = SCnt.searchId(ICntCde);
				this.actPrsRolStt(false, true, true);
			} else {
				if (SCnt.lstCnt(cde.IPmsCntSttAct()).size() == 0) {
					this.msg.msgWrn("!No existen municipios adheridos!");
					this.actBtnPrsRolAdd(true, true);
					this.actCnt(true, true, true);
					this.actCntPrvChk(true, true, false);
					this.actPrsRolStt(true, true, false);
				} else {
					this.actCntPrvChk(false, true, false);
					this.actCnt(false, true, true);
					this.loadLstCnt(cde.IPmsCntSttAct());
					this.actPrsRolStt(false, true, true);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void chsStt() {
		try {
			stt = new ScrTblOpt();
			stt = SScrOpt.searchId(ISttId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*******************************************************/

	private boolean dsbCntPrv;
	private boolean vsbCntPrv;
	private boolean rqrCntPrv;

	private void actCntPrv(boolean dsb, boolean vsb, boolean rqr) {
		dsbCntPrv = dsb;
		vsbCntPrv = vsb;
		rqrCntPrv = rqr;
	}

	private boolean dsbCntPrvChk;
	private boolean vsbCntPrvChk;
	private boolean rqrCntPrvChk;

	private void actCntPrvChk(boolean dsb, boolean vsb, boolean rqr) {
		dsbCntPrvChk = dsb;
		vsbCntPrvChk = vsb;
		rqrCntPrvChk = rqr;
	}

	@EJB
	protected DpaSrvOpt SDpaOpt;
	private List<DpaTblOpt> lstPrv;
	private int IPrvCde;
	private boolean chkPrv;

	private void newLstPrv() {
		IPrvCde = 0;
		lstPrv = new ArrayList<DpaTblOpt>();
	}

	private void loadLstPrv() {
		try {
			this.newLstPrv();
			lstPrv = SDpaOpt.rtrLstEnt(cde.IDpaPrv());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void slcPrv() {
		try {
			this.loadLstPrv();
			this.actCntPrv(false, true, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void chsPrv() {

	}

	/*******************************************************/
	private boolean dsbCnt;
	private boolean vsbCnt;
	private boolean rqrCnt;

	private void actCnt(boolean dsb, boolean vsb, boolean rqr) {
		dsbCnt = dsb;
		vsbCnt = vsb;
		rqrCnt = rqr;
	}

	@EJB
	protected DpaSrvCnt SCnt;
	private int ICntCde;
	private List<DpaTblCnt> lstCnt;
	protected DpaTblCnt cnt;

	private void newLstCnt() {
		ICntCde = 0;
		lstCnt = new ArrayList<DpaTblCnt>();
	}

	private void loadLstCnt(int condition) {
		try {
			this.newLstCnt();
			lstCnt = SCnt.lstCnt(condition);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void chsCnt() {
		try {
			cnt = new DpaTblCnt();
			cnt = SCnt.searchId(ICntCde);
			this.actBtnPrsRolAdd(false, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*******************************************************/
	private boolean VsbSpcTbl;
	private boolean VsbSpcDta;
	private boolean DsbBtnAdd;
	private boolean VsbBtnAdd;
	private boolean DsbBtnSve;
	private boolean VsbBtnSve;
	private boolean DsbBtnUpd;
	private boolean VsbBtnUpd;
	private boolean DsbBtnEdt;
	private boolean VsbBtnEdt;
	private boolean DsbBtnDlt;
	private boolean VsbBtnDlt;
	private boolean DsbBtnRfr;
	private boolean VsbBtnRfr;
	private boolean DsbBtnPdf;
	private boolean VsbBtnPdf;
	private boolean DsbBtnCsv;
	private boolean VsbBtnCsv;

	@Override
	public void actSpcFrm(boolean tbl, boolean dta) {
		VsbSpcTbl = tbl;
		VsbSpcDta = dta;
	}

	@Override
	public void actBtnAdd(boolean dsb, boolean vsb) {
		DsbBtnAdd = dsb;
		VsbBtnAdd = vsb;
	}

	@Override
	public void actBtnSve(boolean dsb, boolean vsb) {
		DsbBtnSve = dsb;
		VsbBtnSve = vsb;
	}

	@Override
	public void actBtnUpd(boolean dsb, boolean vsb) {
		DsbBtnUpd = dsb;
		VsbBtnUpd = vsb;
	}

	@Override
	public void actBtnEdt(boolean dsb, boolean vsb) {
		DsbBtnEdt = dsb;
		VsbBtnEdt = vsb;
	}

	@Override
	public void actBtnDlt(boolean dsb, boolean vsb) {
		DsbBtnDlt = dsb;
		VsbBtnDlt = vsb;
	}

	@Override
	public void actBtnRfr(boolean dsb, boolean vsb) {
		DsbBtnRfr = dsb;
		VsbBtnRfr = vsb;
	}

	public void actBtnPdf(boolean dsb, boolean vsb) {
		DsbBtnPdf = dsb;
		VsbBtnPdf = vsb;
	}

	public void actBtnCsv(boolean dsb, boolean vsb) {
		DsbBtnCsv = dsb;
		VsbBtnCsv = vsb;
	}

	public boolean isVsbSpcTbl() {
		return VsbSpcTbl;
	}

	public void setVsbSpcTbl(boolean vsbSpcTbl) {
		VsbSpcTbl = vsbSpcTbl;
	}

	public boolean isVsbSpcDta() {
		return VsbSpcDta;
	}

	public void setVsbSpcDta(boolean vsbSpcDta) {
		VsbSpcDta = vsbSpcDta;
	}

	public boolean isDsbBtnAdd() {
		return DsbBtnAdd;
	}

	public void setDsbBtnAdd(boolean dsbBtnAdd) {
		DsbBtnAdd = dsbBtnAdd;
	}

	public boolean isVsbBtnAdd() {
		return VsbBtnAdd;
	}

	public void setVsbBtnAdd(boolean vsbBtnAdd) {
		VsbBtnAdd = vsbBtnAdd;
	}

	public boolean isDsbBtnSve() {
		return DsbBtnSve;
	}

	public void setDsbBtnSve(boolean dsbBtnSve) {
		DsbBtnSve = dsbBtnSve;
	}

	public boolean isVsbBtnSve() {
		return VsbBtnSve;
	}

	public void setVsbBtnSve(boolean vsbBtnSve) {
		VsbBtnSve = vsbBtnSve;
	}

	public boolean isDsbBtnUpd() {
		return DsbBtnUpd;
	}

	public void setDsbBtnUpd(boolean dsbBtnUpd) {
		DsbBtnUpd = dsbBtnUpd;
	}

	public boolean isVsbBtnUpd() {
		return VsbBtnUpd;
	}

	public void setVsbBtnUpd(boolean vsbBtnUpd) {
		VsbBtnUpd = vsbBtnUpd;
	}

	public boolean isDsbBtnEdt() {
		return DsbBtnEdt;
	}

	public void setDsbBtnEdt(boolean dsbBtnEdt) {
		DsbBtnEdt = dsbBtnEdt;
	}

	public boolean isVsbBtnEdt() {
		return VsbBtnEdt;
	}

	public void setVsbBtnEdt(boolean vsbBtnEdt) {
		VsbBtnEdt = vsbBtnEdt;
	}

	public boolean isDsbBtnDlt() {
		return DsbBtnDlt;
	}

	public void setDsbBtnDlt(boolean dsbBtnDlt) {
		DsbBtnDlt = dsbBtnDlt;
	}

	public boolean isVsbBtnDlt() {
		return VsbBtnDlt;
	}

	public void setVsbBtnDlt(boolean vsbBtnDlt) {
		VsbBtnDlt = vsbBtnDlt;
	}

	public boolean isDsbBtnRfr() {
		return DsbBtnRfr;
	}

	public void setDsbBtnRfr(boolean dsbBtnRfr) {
		DsbBtnRfr = dsbBtnRfr;
	}

	public boolean isVsbBtnRfr() {
		return VsbBtnRfr;
	}

	public void setVsbBtnRfr(boolean vsbBtnRfr) {
		VsbBtnRfr = vsbBtnRfr;
	}

	public DtaTblPr getPrs() {
		return prs;
	}

	public void setPrs(DtaTblPr prs) {
		this.prs = prs;
	}

	public ScrTblPrsRol getPrsRol() {
		return prsRol;
	}

	public void setPrsRol(ScrTblPrsRol prsRol) {
		this.prsRol = prsRol;
	}

	public List<ScrTblPrsRol> getLstPrsRol() {
		return lstPrsRol;
	}

	public void setLstPrsRol(List<ScrTblPrsRol> lstPrsRol) {
		this.lstPrsRol = lstPrsRol;
	}

	public int getIRolId() {
		return IRolId;
	}

	public void setIRolId(int iRolId) {
		IRolId = iRolId;
	}

	public int getISttId() {
		return ISttId;
	}

	public void setISttId(int iSttId) {
		ISttId = iSttId;
	}

	public int getICntCde() {
		return ICntCde;
	}

	public void setICntCde(int iCntCde) {
		ICntCde = iCntCde;
	}

	public boolean isDsbBtnPdf() {
		return DsbBtnPdf;
	}

	public void setDsbBtnPdf(boolean dsbBtnPdf) {
		DsbBtnPdf = dsbBtnPdf;
	}

	public boolean isVsbBtnPdf() {
		return VsbBtnPdf;
	}

	public void setVsbBtnPdf(boolean vsbBtnPdf) {
		VsbBtnPdf = vsbBtnPdf;
	}

	public boolean isDsbBtnCsv() {
		return DsbBtnCsv;
	}

	public void setDsbBtnCsv(boolean dsbBtnCsv) {
		DsbBtnCsv = dsbBtnCsv;
	}

	public boolean isVsbBtnCsv() {
		return VsbBtnCsv;
	}

	public void setVsbBtnCsv(boolean vsbBtnCsv) {
		VsbBtnCsv = vsbBtnCsv;
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

	public boolean isDsbPrsLstNme() {
		return dsbPrsLstNme;
	}

	public void setDsbPrsLstNme(boolean dsbPrsLstNme) {
		this.dsbPrsLstNme = dsbPrsLstNme;
	}

	public boolean isVsbPrsLstNme() {
		return vsbPrsLstNme;
	}

	public void setVsbPrsLstNme(boolean vsbPrsLstNme) {
		this.vsbPrsLstNme = vsbPrsLstNme;
	}

	public boolean isRqrPrsLstNme() {
		return rqrPrsLstNme;
	}

	public void setRqrPrsLstNme(boolean rqrPrsLstNme) {
		this.rqrPrsLstNme = rqrPrsLstNme;
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

	public boolean isDsbBtnVldPrsEml() {
		return dsbBtnVldPrsEml;
	}

	public void setDsbBtnVldPrsEml(boolean dsbBtnVldPrsEml) {
		this.dsbBtnVldPrsEml = dsbBtnVldPrsEml;
	}

	public boolean isVsbBtnVldPrsEml() {
		return vsbBtnVldPrsEml;
	}

	public void setVsbBtnVldPrsEml(boolean vsbBtnVldPrsEml) {
		this.vsbBtnVldPrsEml = vsbBtnVldPrsEml;
	}

	public boolean isDsbBtnVldPrsUsr() {
		return dsbBtnVldPrsUsr;
	}

	public void setDsbBtnVldPrsUsr(boolean dsbBtnVldPrsUsr) {
		this.dsbBtnVldPrsUsr = dsbBtnVldPrsUsr;
	}

	public boolean isVsbBtnVldPrsUsr() {
		return vsbBtnVldPrsUsr;
	}

	public void setVsbBtnVldPrsUsr(boolean vsbBtnVldPrsUsr) {
		this.vsbBtnVldPrsUsr = vsbBtnVldPrsUsr;
	}

	public boolean isDsbBtnGntrPrsPsw() {
		return dsbBtnGntrPrsPsw;
	}

	public void setDsbBtnGntrPrsPsw(boolean dsbBtnGntrPrsPsw) {
		this.dsbBtnGntrPrsPsw = dsbBtnGntrPrsPsw;
	}

	public boolean isVsbBtnGntrPrsPsw() {
		return vsbBtnGntrPrsPsw;
	}

	public void setVsbBtnGntrPrsPsw(boolean vsbBtnGntrPrsPsw) {
		this.vsbBtnGntrPrsPsw = vsbBtnGntrPrsPsw;
	}

	public boolean isDsbBtnPrsRolNew() {
		return dsbBtnPrsRolNew;
	}

	public void setDsbBtnPrsRolNew(boolean dsbBtnPrsRolNew) {
		this.dsbBtnPrsRolNew = dsbBtnPrsRolNew;
	}

	public boolean isVsbBtnPrsRolNew() {
		return vsbBtnPrsRolNew;
	}

	public void setVsbBtnPrsRolNew(boolean vsbBtnPrsRolNew) {
		this.vsbBtnPrsRolNew = vsbBtnPrsRolNew;
	}

	public boolean isDsbBtnPrsRolAdd() {
		return dsbBtnPrsRolAdd;
	}

	public void setDsbBtnPrsRolAdd(boolean dsbBtnPrsRolAdd) {
		this.dsbBtnPrsRolAdd = dsbBtnPrsRolAdd;
	}

	public boolean isVsbBtnPrsRolAdd() {
		return vsbBtnPrsRolAdd;
	}

	public void setVsbBtnPrsRolAdd(boolean vsbBtnPrsRolAdd) {
		this.vsbBtnPrsRolAdd = vsbBtnPrsRolAdd;
	}

	public boolean isDsbBtnPrsRolUpd() {
		return dsbBtnPrsRolUpd;
	}

	public void setDsbBtnPrsRolUpd(boolean dsbBtnPrsRolUpd) {
		this.dsbBtnPrsRolUpd = dsbBtnPrsRolUpd;
	}

	public boolean isVsbBtnPrsRolUpd() {
		return vsbBtnPrsRolUpd;
	}

	public void setVsbBtnPrsRolUpd(boolean vsbBtnPrsRolUpd) {
		this.vsbBtnPrsRolUpd = vsbBtnPrsRolUpd;
	}

	public boolean isDsbBtnPrsRolRfr() {
		return dsbBtnPrsRolRfr;
	}

	public void setDsbBtnPrsRolRfr(boolean dsbBtnPrsRolRfr) {
		this.dsbBtnPrsRolRfr = dsbBtnPrsRolRfr;
	}

	public boolean isVsbBtnPrsRolRfr() {
		return vsbBtnPrsRolRfr;
	}

	public void setVsbBtnPrsRolRfr(boolean vsbBtnPrsRolRfr) {
		this.vsbBtnPrsRolRfr = vsbBtnPrsRolRfr;
	}

	public boolean isDsbBtnPrsRolEdt() {
		return dsbBtnPrsRolEdt;
	}

	public void setDsbBtnPrsRolEdt(boolean dsbBtnPrsRolEdt) {
		this.dsbBtnPrsRolEdt = dsbBtnPrsRolEdt;
	}

	public boolean isVsbBtnPrsRolEdt() {
		return vsbBtnPrsRolEdt;
	}

	public void setVsbBtnPrsRolEdt(boolean vsbBtnPrsRolEdt) {
		this.vsbBtnPrsRolEdt = vsbBtnPrsRolEdt;
	}

	public boolean isDsbBtnPrsRolDlt() {
		return dsbBtnPrsRolDlt;
	}

	public void setDsbBtnPrsRolDlt(boolean dsbBtnPrsRolDlt) {
		this.dsbBtnPrsRolDlt = dsbBtnPrsRolDlt;
	}

	public boolean isVsbBtnPrsRolDlt() {
		return vsbBtnPrsRolDlt;
	}

	public void setVsbBtnPrsRolDlt(boolean vsbBtnPrsRolDlt) {
		this.vsbBtnPrsRolDlt = vsbBtnPrsRolDlt;
	}

	public boolean isDsbPrsRolRol() {
		return dsbPrsRolRol;
	}

	public void setDsbPrsRolRol(boolean dsbPrsRolRol) {
		this.dsbPrsRolRol = dsbPrsRolRol;
	}

	public boolean isVsbPrsRolRol() {
		return vsbPrsRolRol;
	}

	public void setVsbPrsRolRol(boolean vsbPrsRolRol) {
		this.vsbPrsRolRol = vsbPrsRolRol;
	}

	public boolean isRqrPrsRolRol() {
		return rqrPrsRolRol;
	}

	public void setRqrPrsRolRol(boolean rqrPrsRolRol) {
		this.rqrPrsRolRol = rqrPrsRolRol;
	}

	public boolean isDsbPrsRolStt() {
		return dsbPrsRolStt;
	}

	public void setDsbPrsRolStt(boolean dsbPrsRolStt) {
		this.dsbPrsRolStt = dsbPrsRolStt;
	}

	public boolean isVsbPrsRolStt() {
		return vsbPrsRolStt;
	}

	public void setVsbPrsRolStt(boolean vsbPrsRolStt) {
		this.vsbPrsRolStt = vsbPrsRolStt;
	}

	public boolean isRqrPrsRolStt() {
		return rqrPrsRolStt;
	}

	public void setRqrPrsRolStt(boolean rqrPrsRolStt) {
		this.rqrPrsRolStt = rqrPrsRolStt;
	}

	public ScrTblOpt getRol() {
		return rol;
	}

	public void setRol(ScrTblOpt rol) {
		this.rol = rol;
	}

	public ScrTblOpt getStt() {
		return stt;
	}

	public void setStt(ScrTblOpt stt) {
		this.stt = stt;
	}

	public List<DpaTblOpt> getLstPrv() {
		return lstPrv;
	}

	public void setLstPrv(List<DpaTblOpt> lstPrv) {
		this.lstPrv = lstPrv;
	}

	public int getIPrvCde() {
		return IPrvCde;
	}

	public void setIPrvCde(int iPrvCde) {
		IPrvCde = iPrvCde;
	}

	public boolean isDsbCntPrv() {
		return dsbCntPrv;
	}

	public void setDsbCntPrv(boolean dsbCntPrv) {
		this.dsbCntPrv = dsbCntPrv;
	}

	public boolean isVsbCntPrv() {
		return vsbCntPrv;
	}

	public void setVsbCntPrv(boolean vsbCntPrv) {
		this.vsbCntPrv = vsbCntPrv;
	}

	public boolean isRqrCntPrv() {
		return rqrCntPrv;
	}

	public void setRqrCntPrv(boolean rqrCntPrv) {
		this.rqrCntPrv = rqrCntPrv;
	}

	public boolean isDsbCnt() {
		return dsbCnt;
	}

	public void setDsbCnt(boolean dsbCnt) {
		this.dsbCnt = dsbCnt;
	}

	public boolean isVsbCnt() {
		return vsbCnt;
	}

	public void setVsbCnt(boolean vsbCnt) {
		this.vsbCnt = vsbCnt;
	}

	public boolean isRqrCnt() {
		return rqrCnt;
	}

	public void setRqrCnt(boolean rqrCnt) {
		this.rqrCnt = rqrCnt;
	}

	public List<ScrTblOpt> getLstRol() {
		return lstRol;
	}

	public void setLstRol(List<ScrTblOpt> lstRol) {
		this.lstRol = lstRol;
	}

	public boolean isChkPrv() {
		return chkPrv;
	}

	public void setChkPrv(boolean chkPrv) {
		this.chkPrv = chkPrv;
	}

	public List<DpaTblCnt> getLstCnt() {
		return lstCnt;
	}

	public void setLstCnt(List<DpaTblCnt> lstCnt) {
		this.lstCnt = lstCnt;
	}

	public boolean isDsbCntPrvChk() {
		return dsbCntPrvChk;
	}

	public void setDsbCntPrvChk(boolean dsbCntPrvChk) {
		this.dsbCntPrvChk = dsbCntPrvChk;
	}

	public boolean isVsbCntPrvChk() {
		return vsbCntPrvChk;
	}

	public void setVsbCntPrvChk(boolean vsbCntPrvChk) {
		this.vsbCntPrvChk = vsbCntPrvChk;
	}

	public boolean isRqrCntPrvChk() {
		return rqrCntPrvChk;
	}

	public void setRqrCntPrvChk(boolean rqrCntPrvChk) {
		this.rqrCntPrvChk = rqrCntPrvChk;
	}

}
