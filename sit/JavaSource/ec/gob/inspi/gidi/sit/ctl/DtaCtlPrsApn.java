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
import ec.gob.inspi.gidi.sit.ent.DtaTblPrsApn;
import ec.gob.inspi.gidi.sit.ent.InsTblUnt;
import ec.gob.inspi.gidi.sit.srv.DtaSrvPrs;
import ec.gob.inspi.gidi.sit.srv.DtaSrvPrsApn;
import ec.gob.inspi.gidi.sit.srv.InsSrvApn;
import ec.gob.inspi.gidi.sit.srv.InsSrvOpt;
import ec.gob.inspi.gidi.sit.srv.InsSrvUnt;

@ManagedBean
@ViewScoped
public class DtaCtlPrsApn {

	protected Message msg;
	protected Default dfl;

	public DtaCtlPrsApn() {
		lstPrsApn = new ArrayList<DtaTblPrsApn>();
		msg = new Message();
		prsApn = new DtaTblPrsApn();
		dfl = new Default();
		cde = new Code();
	}

	// 1. Retorna los nombres del profesional
	public String rtrPrsApnVrbNme(int IPrsApnId) {
		try {
			String vrbRtr = "";
			if (IPrsApnId == dfl.cmpInt()) {
				vrbRtr = dfl.none();
			} else {
				DtaTblPrsApn aux = new DtaTblPrsApn();
				aux = sPrsApn.searchId(IPrsApnId);
				vrbRtr = aux.getDtaTblPr().getSPrsLstNme() + " " + aux.getDtaTblPr().getSPrsNme();
			}
			return vrbRtr;
		} catch (Exception e) {
			return null;
		}
	}

	// 2. Retorna el cargo
	public String rtrPrsApnVrbApn(int IPrsApnId) {
		try {
			String vrbRtr = "";
			if (IPrsApnId == dfl.cmpInt()) {
				vrbRtr = dfl.none();
			} else {
				DtaTblPrsApn aux = new DtaTblPrsApn();
				aux = sPrsApn.searchId(IPrsApnId);
				vrbRtr = aux.getInsTblApn().getSApnNme();
			}
			return vrbRtr;
		} catch (Exception e) {
			return null;
		}
	}

	// 3. Retorna la unidad o subunidad del profesional
	@EJB
	protected InsSrvUnt SUnt;
	protected Code cde;

	public String rtrPrsApnVrbUnt(int IPrsApnId) {
		try {
			String vrbRtr = "";
			if (IPrsApnId == dfl.cmpInt()) {
				InsTblUnt auxUnt = new InsTblUnt();
				auxUnt = SUnt.searchId(cde.insUntEpiSIG());
				if (auxUnt.getIUntCde() == dfl.cmpInt()) { // Es unidad
					vrbRtr = auxUnt.getSUntNme();
				} else { // Es subunidad
					vrbRtr = SUnt.searchId(auxUnt.getIUntCde()).getSUntNme() + " ("
							+ SUnt.searchId(auxUnt.getIUntId()).getSUntNme() + ")";
				}
			} else {
				DtaTblPrsApn auxPrsApn = new DtaTblPrsApn();
				auxPrsApn = sPrsApn.searchId(IPrsApnId);
				InsTblUnt auxUnt = new InsTblUnt();
				auxUnt = SUnt.searchId(auxPrsApn.getInsTblApn().getInsTblUnt().getIUntId());
				if (auxUnt.getIUntCde() == dfl.cmpInt()) { // Es unidad
					vrbRtr = auxUnt.getSUntNme();
				} else { // Es subunidad
					vrbRtr = SUnt.searchId(auxUnt.getIUntCde()).getSUntNme() + " ("
							+ SUnt.searchId(auxUnt.getIUntId()).getSUntNme() + ")";
				}
			}
			return vrbRtr;
		} catch (Exception e) {
			return null;
		}
	}

	// 4. Retorna la entidad/tipo del profesional
	@EJB
	protected InsSrvOpt SInsOpt;

	public String rtrPrsApnVrbEnt(int IPrsApnId) {
		try {
			String vrbRtr = "";
			if (IPrsApnId == dfl.cmpInt()) {
				InsTblUnt auxUnt = new InsTblUnt();
				auxUnt = SUnt.searchId(cde.insUntGIDi());
				vrbRtr = auxUnt.getInsTblEnt().getSEntNme() + " ("
						+ SInsOpt.searchId(auxUnt.getInsTblEnt().getITpeId()).getSOptNmeSpn() + ")";
			} else {
				DtaTblPrsApn aux = new DtaTblPrsApn();
				aux = sPrsApn.searchId(IPrsApnId);
				vrbRtr = aux.getInsTblApn().getInsTblUnt().getInsTblEnt().getSEntNme() + " ("
						+ SInsOpt.searchId(aux.getInsTblApn().getInsTblUnt().getInsTblEnt().getITpeId()).getSOptNmeSpn()
						+ ")";
			}
			return vrbRtr;
		} catch (Exception e) {
			return null;
		}
	}

	public List<DtaTblPrsApn> loadPrsApn() {
		try {
			List<DtaTblPrsApn> lstPrsApn = new ArrayList<DtaTblPrsApn>();
			lstPrsApn = sPrsApn.lstPrsApn();
			Collections.sort(lstPrsApn, new Comparator<DtaTblPrsApn>() {
				public int compare(DtaTblPrsApn o1, DtaTblPrsApn o2) {
					return o1.getDtaTblPr().getSPrsLstNme().compareTo(o2.getDtaTblPr().getSPrsLstNme());
				}
			});
			return lstPrsApn;
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

	private void ctpInit() {
		this.actPgr(true, false);
		this.actTblBtnDlt(false, true);
		this.actTblBtnEdt(false, true);
		this.actBtnHme(false, true);
		this.actBtnAdd(false, true);
		this.actBtnSve(true, true);
		this.actBtnUpd(true, false);
		this.actBtnRtr(false, true);
	}

	////////////////////////// PRS //////////////////////////

	private boolean dsbPrs;
	private boolean vsbPrs;
	private boolean rqrPrs;

	private void actPrs(boolean dsb, boolean vsb, boolean rqr) {
		dsbPrs = dsb;
		vsbPrs = vsb;
		rqrPrs = rqr;
	}

	private boolean dsbPrsLbl;
	private boolean vsbPrsLbl;

	private void actPrsLbl(boolean dsb, boolean vsb) {
		dsbPrsLbl = dsb;
		vsbPrsLbl = vsb;
	}

	private int IPrsId;
	private DtaTblPr prs;
	@EJB
	protected DtaSrvPrs sPrs;

	////////////////////////// APN //////////////////////////
	private String SUntBld;

	private boolean dsbUntBld;
	private boolean vsbUntBld;
	private boolean rqrUntBld;

	private void actUntBld(boolean dsb, boolean vsb, boolean rqr) {
		dsbUntBld = dsb;
		vsbUntBld = vsb;
		rqrUntBld = rqr;
	}

	public void chsUntBld() {
		if (Integer.parseInt(SUntBld) != -99) {// Cuando no es una UNIDAD
			this.actUntSub(false, true, true);
			this.actUnt(true, false, false);
		} else {
			this.actUnt(false, true, false);
			this.actUntSub(true, false, false);
		}
		this.actApn(false, true, true);
		this.actEntTpe(false, true, true);
		this.actEnt(false, true, true);
		this.actStt(false, true, true);
		IUntCde = 0;
		IUntId = 0;
		IEntId = 0;
		IEntTpeId = 0;
		IApnId = 0;
		ISttCde = 0;
	}

	////////////////////////// ENT-TPE //////////////////////////
	private boolean dsbEntTpe;
	private boolean vsbEntTpe;
	private boolean rqrEntTpe;

	private void actEntTpe(boolean dsb, boolean vsb, boolean rqr) {
		dsbEntTpe = dsb;
		vsbEntTpe = vsb;
		rqrEntTpe = rqr;
	}

	private int IEntTpeId;

	////////////////////////// ENT //////////////////////////

	private boolean dsbEnt;
	private boolean vsbEnt;
	private boolean rqrEnt;

	private void actEnt(boolean dsb, boolean vsb, boolean rqr) {
		dsbEnt = dsb;
		vsbEnt = vsb;
		rqrEnt = rqr;
	}

	private int IEntId;
	////////////////////////// UNT //////////////////////////
	private boolean dsbUnt;
	private boolean vsbUnt;
	private boolean rqrUnt;

	private void actUnt(boolean dsb, boolean vsb, boolean rqr) {
		dsbUnt = dsb;
		vsbUnt = vsb;
		rqrUnt = rqr;
	}

	private int IUntCde;
	////////////////////////// UNT-SUB //////////////////////////
	private boolean dsbUntSub;
	private boolean vsbUntSub;
	private boolean rqrUntSub;

	private void actUntSub(boolean dsb, boolean vsb, boolean rqr) {
		dsbUntSub = dsb;
		vsbUntSub = vsb;
		rqrUntSub = rqr;
	}

	private int IUntId;
	////////////////////////// APN //////////////////////////

	private boolean dsbApn;
	private boolean vsbApn;
	private boolean rqrApn;

	private void actApn(boolean dsb, boolean vsb, boolean rqr) {
		dsbApn = dsb;
		vsbApn = vsb;
		rqrApn = rqr;
	}

	private int IApnId;
	@EJB
	protected InsSrvApn sApn;

	////////////////////////// STT //////////////////////////

	private boolean dsbStt;
	private boolean vsbStt;
	private boolean rqrStt;

	private void actStt(boolean dsb, boolean vsb, boolean rqr) {
		dsbStt = dsb;
		vsbStt = vsb;
		rqrStt = rqr;
	}

	private int ISttCde;

	////////////////////////// PRS-APN //////////////////////////
	private List<DtaTblPrsApn> lstPrsApn;
	private List<DtaTblPrsApn> lstTblPrsApn;
	private DtaTblPrsApn prsApn;
	@EJB
	protected DtaSrvPrsApn sPrsApn;

	private void loadLstTblPrsApn() {
		try {
			lstTblPrsApn = new ArrayList<DtaTblPrsApn>();
			lstTblPrsApn = sPrsApn.srcAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PostConstruct
	public void init() {
		this.ctpInit();
		this.loadLstTblPrsApn();
		this.actPrs(true, true, false);
		this.actPrsLbl(false, false);
		this.actUntBld(true, true, false);
		this.actEntTpe(true, true, false);
		this.actEnt(true, true, false);
		this.actUnt(true, true, false);
		this.actUntSub(true, false, false);
		this.actApn(true, true, false);
		this.actStt(true, true, false);
	}

	public void add() {
		try {
			this.actPgr(false, true);
			this.actBtnAdd(true, true);
			this.actBtnSve(false, true);
			this.actBtnHme(true, true);
			this.actPrs(false, true, true);
			this.actUntBld(false, true, true);
			IUntCde = 0;
			IUntId = 0;
			IEntId = 0;
			IEntTpeId = 0;
			IApnId = 0;
			prs = new DtaTblPr();
			IPrsId = 0;
			SUntBld = "";
			ISttCde = 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sve() {
		try {
			if (sPrsApn.save(sPrs.searchId(IPrsId), sApn.searchId(IApnId), ISttCde) != false) {
				this.msg.msgInf(msg.msgSaveInf());
			} else {
				this.msg.msgErr(msg.msgSaveErr());
			}
			this.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@EJB
	protected InsSrvUnt sUnt;

	public void edt() {
		try {
			this.actPgr(false, true);
			this.actBtnHme(true, true);
			this.actBtnAdd(true, true);
			this.actBtnSve(true, false);
			this.actBtnUpd(false, true);
			this.actUntBld(true, true, false);
			prs = new DtaTblPr();
			this.actPrs(true, false, false);
			this.actPrsLbl(true, true);
			this.actUntBld(true, true, false);
			prs = sPrs.searchId(prsApn.getDtaTblPr().getIPrsId());
			IEntTpeId = prsApn.getInsTblApn().getInsTblUnt().getInsTblEnt().getITpeId();
			this.actEntTpe(false, true, true);
			IEntId = prsApn.getInsTblApn().getInsTblUnt().getInsTblEnt().getIEntCde();
			this.actEnt(false, true, true);
			if (prsApn.getInsTblApn().getInsTblUnt().getIUntCde() == -99) {
				SUntBld = String.valueOf(prsApn.getInsTblApn().getInsTblUnt().getIUntCde());
				this.actUntSub(true, false, false);
				this.actUnt(false, true, true);
				IUntCde = prsApn.getInsTblApn().getInsTblUnt().getIUntId();
			} else {
				this.actUntSub(false, true, true);
				this.actUnt(true, false, false);
				SUntBld = "0";
				IUntId = prsApn.getInsTblApn().getInsTblUnt().getIUntId();
			}
			IApnId = prsApn.getInsTblApn().getIApnId();
			this.actApn(false, true, true);
			ISttCde = prsApn.getISttCde();
			this.actStt(false, true, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void upd() {
		try {
			if (sPrsApn.update(prsApn, sApn.searchId(IApnId), ISttCde) != false) {
				this.msg.msgInf(msg.msgUpdInf());
			} else {
				this.msg.msgErr(msg.msgUpdErr());
			}
			this.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dlt() {
		try {
			sPrsApn.delete(prsApn);
			this.msg.msgInf(msg.msgDltInf());
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.init();
	}

	public void rtr() {

	}

	public String rtrApn(DtaTblPr prs) {
		try {
			String vle = "";
			if (sPrsApn.lstApnT(prs) != null) {
				for (DtaTblPrsApn aux : sPrsApn.lstApnT(prs)) {
					if (sPrsApn.lstApnT(prs).size() == 1) {
						vle = aux.getInsTblApn().getSApnNme();
					} else {
						vle = vle + aux.getInsTblApn().getSApnNme() + "<br/>";
					}
				}
			}
			return vle;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public String rtrUnt(DtaTblPr prs) {
		try {
			String vle = "";
			if (sPrsApn.lstApnT(prs) != null) {
				for (DtaTblPrsApn aux : sPrsApn.lstApnT(prs)) {
					if (sPrsApn.lstApnT(prs).size() == 1) {
						vle = aux.getInsTblApn().getInsTblUnt().getSUntNme();
					} else {
						vle = vle + aux.getInsTblApn().getInsTblUnt().getSUntNme() + "<br/>";
					}
				}
			}
			return vle;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public String rtrEnt(DtaTblPr prs) {
		try {
			String vle = "";
			if (sPrsApn.lstApnT(prs) != null) {
				for (DtaTblPrsApn aux : sPrsApn.lstApnT(prs)) {
					if (sPrsApn.lstApnT(prs).size() == 1) {
						vle = aux.getInsTblApn().getInsTblUnt().getInsTblEnt().getSEntNme();
					} else {
						vle = vle + aux.getInsTblApn().getInsTblUnt().getInsTblEnt().getSEntNme() + "<br/>";
					}
				}
			}
			return vle;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public String rtrEntTpe(DtaTblPr prs) {
		try {
			String vle = "";
			if (sPrsApn.lstApnT(prs) != null) {
				for (DtaTblPrsApn aux : sPrsApn.lstApnT(prs)) {
					if (sPrsApn.lstApnT(prs).size() == 1) {
						vle = SInsOpt.searchId(aux.getInsTblApn().getInsTblUnt().getInsTblEnt().getITpeId())
								.getSOptNmeSpn();
					} else {
						vle = vle + SInsOpt.searchId(aux.getInsTblApn().getInsTblUnt().getInsTblEnt().getITpeId())
								.getSOptNmeSpn() + "<br/>";
					}
				}
			}
			return vle;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public boolean isVsbPrsLbl() {
		return vsbPrsLbl;
	}

	public void setVsbPrsLbl(boolean vsbPrsLbl) {
		this.vsbPrsLbl = vsbPrsLbl;
	}

	public boolean isDsbPrsLbl() {
		return dsbPrsLbl;
	}

	public void setDsbPrsLbl(boolean dsbPrsLbl) {
		this.dsbPrsLbl = dsbPrsLbl;
	}

	public DtaTblPr getPrs() {
		return prs;
	}

	public void setPrs(DtaTblPr prs) {
		this.prs = prs;
	}

	public DtaTblPrsApn getPrsApn() {
		return prsApn;
	}

	public void setPrsApn(DtaTblPrsApn prsApn) {
		this.prsApn = prsApn;
	}

	public List<DtaTblPrsApn> getLstTblPrsApn() {
		return lstTblPrsApn;
	}

	public void setLstTblPrsApn(List<DtaTblPrsApn> lstTblPrsApn) {
		this.lstTblPrsApn = lstTblPrsApn;
	}

	public boolean isDsbStt() {
		return dsbStt;
	}

	public void setDsbStt(boolean dsbStt) {
		this.dsbStt = dsbStt;
	}

	public boolean isVsbStt() {
		return vsbStt;
	}

	public void setVsbStt(boolean vsbStt) {
		this.vsbStt = vsbStt;
	}

	public boolean isRqrStt() {
		return rqrStt;
	}

	public void setRqrStt(boolean rqrStt) {
		this.rqrStt = rqrStt;
	}

	public int getISttCde() {
		return ISttCde;
	}

	public void setISttCde(int iSttCde) {
		ISttCde = iSttCde;
	}

	public List<DtaTblPrsApn> getLstPrsApn() {
		return lstPrsApn;
	}

	public void setLstPrsApn(List<DtaTblPrsApn> lstPrsApn) {
		this.lstPrsApn = lstPrsApn;
	}

	public boolean isDsbEntTpe() {
		return dsbEntTpe;
	}

	public void setDsbEntTpe(boolean dsbEntTpe) {
		this.dsbEntTpe = dsbEntTpe;
	}

	public boolean isVsbEntTpe() {
		return vsbEntTpe;
	}

	public void setVsbEntTpe(boolean vsbEntTpe) {
		this.vsbEntTpe = vsbEntTpe;
	}

	public boolean isRqrEntTpe() {
		return rqrEntTpe;
	}

	public void setRqrEntTpe(boolean rqrEntTpe) {
		this.rqrEntTpe = rqrEntTpe;
	}

	public int getIEntTpeId() {
		return IEntTpeId;
	}

	public void setIEntTpeId(int iEntTpeId) {
		IEntTpeId = iEntTpeId;
	}

	public boolean isDsbEnt() {
		return dsbEnt;
	}

	public void setDsbEnt(boolean dsbEnt) {
		this.dsbEnt = dsbEnt;
	}

	public boolean isVsbEnt() {
		return vsbEnt;
	}

	public void setVsbEnt(boolean vsbEnt) {
		this.vsbEnt = vsbEnt;
	}

	public boolean isRqrEnt() {
		return rqrEnt;
	}

	public void setRqrEnt(boolean rqrEnt) {
		this.rqrEnt = rqrEnt;
	}

	public int getIEntId() {
		return IEntId;
	}

	public void setIEntId(int iEntId) {
		IEntId = iEntId;
	}

	public boolean isDsbApn() {
		return dsbApn;
	}

	public void setDsbApn(boolean dsbApn) {
		this.dsbApn = dsbApn;
	}

	public boolean isVsbApn() {
		return vsbApn;
	}

	public void setVsbApn(boolean vsbApn) {
		this.vsbApn = vsbApn;
	}

	public boolean isRqrApn() {
		return rqrApn;
	}

	public void setRqrApn(boolean rqrApn) {
		this.rqrApn = rqrApn;
	}

	public int getIApnId() {
		return IApnId;
	}

	public void setIApnId(int iApnId) {
		IApnId = iApnId;
	}

	public int getIUntCde() {
		return IUntCde;
	}

	public void setIUntCde(int iUntCde) {
		IUntCde = iUntCde;
	}

	public int getIUntId() {
		return IUntId;
	}

	public void setIUntId(int iUntId) {
		IUntId = iUntId;
	}

	public boolean isDsbUnt() {
		return dsbUnt;
	}

	public void setDsbUnt(boolean dsbUnt) {
		this.dsbUnt = dsbUnt;
	}

	public boolean isVsbUnt() {
		return vsbUnt;
	}

	public void setVsbUnt(boolean vsbUnt) {
		this.vsbUnt = vsbUnt;
	}

	public boolean isRqrUnt() {
		return rqrUnt;
	}

	public void setRqrUnt(boolean rqrUnt) {
		this.rqrUnt = rqrUnt;
	}

	public boolean isDsbUntSub() {
		return dsbUntSub;
	}

	public void setDsbUntSub(boolean dsbUntSub) {
		this.dsbUntSub = dsbUntSub;
	}

	public boolean isVsbUntSub() {
		return vsbUntSub;
	}

	public void setVsbUntSub(boolean vsbUntSub) {
		this.vsbUntSub = vsbUntSub;
	}

	public boolean isRqrUntSub() {
		return rqrUntSub;
	}

	public void setRqrUntSub(boolean rqrUntSub) {
		this.rqrUntSub = rqrUntSub;
	}

	public String getSUntBld() {
		return SUntBld;
	}

	public void setSUntBld(String sUntBld) {
		SUntBld = sUntBld;
	}

	public boolean isDsbUntBld() {
		return dsbUntBld;
	}

	public void setDsbUntBld(boolean dsbUntBld) {
		this.dsbUntBld = dsbUntBld;
	}

	public boolean isVsbUntBld() {
		return vsbUntBld;
	}

	public void setVsbUntBld(boolean vsbUntBld) {
		this.vsbUntBld = vsbUntBld;
	}

	public boolean isRqrUntBld() {
		return rqrUntBld;
	}

	public void setRqrUntBld(boolean rqrUntBld) {
		this.rqrUntBld = rqrUntBld;
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

	public int getIPrsId() {
		return IPrsId;
	}

	public void setIPrsId(int iPrsId) {
		IPrsId = iPrsId;
	}

}
