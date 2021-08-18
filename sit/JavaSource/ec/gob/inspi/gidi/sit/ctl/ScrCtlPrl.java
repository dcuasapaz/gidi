package ec.gob.inspi.gidi.sit.ctl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.gob.inspi.gidi.sit.cmm.Code;
import ec.gob.inspi.gidi.sit.cmm.Log;
import ec.gob.inspi.gidi.sit.cmm.Message;
import ec.gob.inspi.gidi.sit.cmm.Method;
import ec.gob.inspi.gidi.sit.ent.DtaTblPr;
import ec.gob.inspi.gidi.sit.ent.ScrTblPrsRol;
import ec.gob.inspi.gidi.sit.itf.ScrItfPrl;
import ec.gob.inspi.gidi.sit.srv.DtaSrvPrs;
import ec.gob.inspi.gidi.sit.srv.ScrSrvPrsRol;

@ManagedBean
@ViewScoped
public class ScrCtlPrl implements ScrItfPrl {
	protected Message msg;
	protected Log log;
	protected Method mth;
	protected Code cde;

	public ScrCtlPrl() {
		prl = new ScrTblPrsRol();
		msg = new Message();
		prs = new DtaTblPr();
		log = new Log();
		mth = new Method();
		cde = new Code();
	}

	@Override
	@PostConstruct
	public void init() {
		this.cptInit();
		this.loadLstTblPrl();
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
		this.actPrl(true, true, false);
		this.actPrs(true, true, false);
		this.actPrf(true, true, false);
		this.actPrsLbl(true, false);
		this.actPrfLbl(true, false);
		this.actStt(true, false, false);
		this.actPrlStt(true, true, false);

		this.actPrsEml(true, true, false);
		this.actEml(true, true, false);
		this.vsbPnlBtnPrsEml = false;
		this.vlrEml = false;

		this.actPrsUsr(true, true, false);
		this.actUsr(true, true, false);
		this.vsbPnlBtnPrsUsr = false;
		this.vlrUsr = false;
		
		this.actPrsPrj(true, true, false);

		this.actPrsPsw(true, true, false);
		this.actPsw(true, true, false);
		this.vsbPnlBtnPrsPsw = false;
		this.vlrPsw = false;

		prs = new DtaTblPr();
		IPrfId = 0;
		IPrsId = 0;
		BPrlStt = false;

	}

	@Override
	public void loadLstTblPrl() {
		try {
			lstTblPrl = new ArrayList<>();
			lstTblPrl = sPrl.srcAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void add() {
		try {
			this.actPgr(false, true);
			this.actBtnAdd(true, true);
			this.actBtnSve(false, true);
			this.actBtnHme(true, true);
			this.actPrs(false, true, false);
			this.actPrf(false, true, false);
			this.actStt(true, false, false);
			this.actPrsPrj(false, true, true);
			IPrjId = 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void sve() {
		try {
			if (sPrl.save(prs, IPrfId, cde.sctSttRgs(), BPrlStt, IPrjId) != false) {
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
			// 1. Mostrar estado de usuario en sistema
			vsbStt = true;
			IPrjId = 0;
			// 2. Cargar informacion de usuario en un texto
			try {
				this.actPrs(true, false, false);
				this.actPrsLbl(false, true);
				prs = new DtaTblPr();
				prs = prl.getDtaTblPr();
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 3. Cargar informacion del perfil en un texto
			try {
				this.actPrf(true, false, false);
				this.actPrfLbl(false, true);
				IPrfId = prl.getIRolId();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 4. Cargar informacion de la persona con su perfil
			try {
				this.actPrlStt(false, true, true);
				BPrlStt = prl.getBPrsRolStt();
				this.actEml(false, true, true);
				this.actUsr(false, true, true);
				this.actPsw(false, true, true);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				this.actPrsPrj(false, true, true);
				IPrjId = prl.getIPrjId();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void upd() {
		try {
			if (sPrl.update(prl, BPrlStt,IPrjId) != false) {
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
			sPrl.delete(prl);
			this.msg.msgInf(msg.msgDltInf());
		} catch (Exception e) {
			e.printStackTrace();
			this.msg.msgErr(msg.msgDltErr());
		}
		this.init();

	}

	public ScrTblPrsRol rtrEnt(int IPrsRolId) {
		try {
			return sPrl.searchId(IPrsRolId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
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

	/****************** PRL *********************/

	private boolean dsbPrl;
	private boolean vsbPrl;
	private boolean rqrPrl;

	private void actPrl(boolean dsb, boolean vsb, boolean rqr) {
		dsbPrl = dsb;
		vsbPrl = vsb;
		rqrPrl = rqr;
	}

	private List<ScrTblPrsRol> lstTblPrl;
	private boolean BPrlStt;
	private ScrTblPrsRol prl;
	@EJB
	protected ScrSrvPrsRol sPrl;

	public void chsStt() {

		if (BPrlStt != false) {
			this.actEml(false, true, true);
			this.actUsr(false, true, true);
			this.actPsw(false, true, true);
		} else {
			this.actEml(true, true, false);
			this.actUsr(true, true, false);
			this.actPsw(true, true, false);
		}

	}

	/****************** PRS *********************/

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

	private boolean dsbPrsEml;
	private boolean vsbPrsEml;
	private boolean rqrPrsEml;

	private void actPrsEml(boolean dsb, boolean vsb, boolean rqr) {
		dsbPrsEml = dsb;
		vsbPrsEml = vsb;
		rqrPrsEml = rqr;
	}

	private boolean vsbPnlBtnPrsEml;
	private boolean vlrEml;
	private boolean dsbEml;
	private boolean vsbEml;
	private boolean rqrEml;

	private void actEml(boolean dsb, boolean vsb, boolean rqr) {
		dsbEml = dsb;
		vsbEml = vsb;
		rqrEml = rqr;
	}

	public void actEml() {
		try {
			if (vlrEml != false) {
				this.actPrsEml(false, true, true);
				this.vsbPnlBtnPrsEml = true;
			} else {
				this.actPrsEml(true, true, false);
				this.vsbPnlBtnPrsEml = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updPrsEml() {
		try {
			if (prs.getSPrsEml() != null || prs.getSPrsEml().compareToIgnoreCase("") == 0) {
				sPrs.update(prs);
				this.msg.msgInf(msg.msgUpdInf());
			} else {
				this.msg.msgErr(msg.msgUpdErr());
			}
			this.rstPrsEml();
		} catch (Exception e) {
			this.msg.msgErr(this.msg.errDtaPrsEml());
			e.printStackTrace();
		}
	}

	public void rstPrsEml() {
		try {
			// 1. Valor del check en false
			this.vlrEml = false;
			// 2. Desactivar el campo de Email
			this.actEml(false, true, false);
			// 3. Asignar la persona en sesion al campo
			prs = sPrs.searchId(IPrsId);
			// 4. Ocultar los botones
			this.vsbPnlBtnPrsEml = false;
			// 5. Desactivar el campo de Email
			this.actPrsEml(true, true, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private boolean dsbPrsUsr;
	private boolean vsbPrsUsr;
	private boolean rqrPrsUsr;

	private void actPrsUsr(boolean dsb, boolean vsb, boolean rqr) {
		dsbPrsUsr = dsb;
		vsbPrsUsr = vsb;
		rqrPrsUsr = rqr;
	}

	private boolean vsbPnlBtnPrsUsr;
	private boolean vlrUsr;
	private boolean dsbUsr;
	private boolean vsbUsr;
	private boolean rqrUsr;

	private void actUsr(boolean dsb, boolean vsb, boolean rqr) {
		dsbUsr = dsb;
		vsbUsr = vsb;
		rqrUsr = rqr;
	}

	public void actUsr() {
		try {
			if (vlrUsr != false) {
				this.actPrsUsr(false, true, true);
				this.vsbPnlBtnPrsUsr = true;
			} else {
				this.actPrsUsr(true, true, false);
				this.vsbPnlBtnPrsUsr = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updPrsUsr() {
		try {
			if (prs.getSPrsUsr() != null || prs.getSPrsUsr().compareToIgnoreCase("") == 0) {
				sPrs.update(prs);
				this.msg.msgInf(msg.msgUpdInf());
			} else {
				this.msg.msgErr(msg.msgUpdErr());
			}
			this.rstPrsUsr();
		} catch (Exception e) {
			this.msg.msgErr(this.msg.errDtaPrsUsr());
			e.printStackTrace();
		}
	}

	public void rstPrsUsr() {
		try {
			// 1. Valor del check en false
			this.vlrUsr = false;
			// 2. Desactivar el campo de Usr
			this.actUsr(false, true, false);
			// 3. Asignar la persona en sesion al campo
			prs = sPrs.searchId(IPrsId);
			// 4. Ocultar los botones
			this.vsbPnlBtnPrsUsr = false;
			// 5. Desactivar el campo de Email
			this.actPrsUsr(true, true, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private boolean dsbPrsPsw;
	private boolean vsbPrsPsw;
	private boolean rqrPrsPsw;

	private void actPrsPsw(boolean dsb, boolean vsb, boolean rqr) {
		dsbPrsPsw = dsb;
		vsbPrsPsw = vsb;
		rqrPrsPsw = rqr;
	}

	private boolean vsbPnlBtnPrsPsw;
	private boolean vlrPsw;
	private boolean dsbPsw;
	private boolean vsbPsw;
	private boolean rqrPsw;

	private void actPsw(boolean dsb, boolean vsb, boolean rqr) {
		dsbPsw = dsb;
		vsbPsw = vsb;
		rqrPsw = rqr;
	}

	public void actPsw() {
		try {
			if (vlrPsw != false) {
				this.actPrsPsw(false, true, true);
				this.vsbPnlBtnPrsPsw = true;
			} else {
				this.actPrsPsw(true, true, false);
				this.vsbPnlBtnPrsPsw = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updPrsPsw() {
		try {
			if (prs.getSPrsPsw() != null || prs.getSPrsPsw().compareToIgnoreCase("") == 0) {
				prs.setSPrsPsw(prs.getSPrsPsw());
				sPrs.update(prs);
				this.msg.msgInf(msg.msgUpdInf());
			} else {
				this.msg.msgErr(msg.msgUpdErr());
			}
			this.rstPrsPsw();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void rstPrsPsw() {
		try {
			// 1. Valor del check en false
			this.vlrPsw = false;
			// 2. Desactivar el campo de Usr
			this.actPsw(false, true, false);
			// 3. Asignar la persona en sesion al campo
			prs = sPrs.searchId(IPrsId);
			// 4. Ocultar los botones
			this.vsbPnlBtnPrsPsw = false;
			// 5. Desactivar el campo de Email
			this.actPrsPsw(true, true, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private int IPrsId;
	private DtaTblPr prs;
	@EJB
	protected DtaSrvPrs sPrs;

	public void chsPrs() {
		try {
			prs = new DtaTblPr();
			prs = sPrs.searchId(IPrsId);
			prs.setSPrsPsw(prs.getSPrsPsw());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/****************** PRF *********************/

	private boolean dsbPrf;
	private boolean vsbPrf;
	private boolean rqrPrf;

	private void actPrf(boolean dsb, boolean vsb, boolean rqr) {
		dsbPrf = dsb;
		vsbPrf = vsb;
		rqrPrf = rqr;
	}

	private boolean dsbPrfLbl;
	private boolean vsbPrfLbl;

	private void actPrfLbl(boolean dsb, boolean vsb) {
		dsbPrfLbl = dsb;
		vsbPrfLbl = vsb;
	}

	private int IPrfId;

	public void chsPrf() {
		if (IPrsId != 0 && IPrfId != 0) {
			this.actPrlStt(false, true, true);
		} else {
			this.msg.msgInf("Seleccione Profesional y Perfil");
		}
	}

	/****************** STT *********************/

	private boolean dsbStt;
	private boolean vsbStt;
	private boolean rqrStt;

	private void actStt(boolean dsb, boolean vsb, boolean rqr) {
		dsbStt = dsb;
		vsbStt = vsb;
		rqrStt = rqr;
	}

	private boolean dsbPrlStt;
	private boolean vsbPrlStt;
	private boolean rqrPrlStt;

	private void actPrlStt(boolean dsb, boolean vsb, boolean rqr) {
		dsbPrlStt = dsb;
		vsbPrlStt = vsb;
		rqrPrlStt = rqr;
	}

	/****************** STT *********************/
	private boolean dsbPrsPrj;
	private boolean vsbPrsPrj;
	private boolean rqrPrsPrj;
	private int IPrjId;

	private void actPrsPrj(boolean dsb, boolean vsb, boolean rqr) {
		dsbPrsPrj = dsb;
		vsbPrsPrj = vsb;
		rqrPrsPrj = rqr;
	}

	public boolean isDsbPrfLbl() {
		return dsbPrfLbl;
	}

	public void setDsbPrfLbl(boolean dsbPrfLbl) {
		this.dsbPrfLbl = dsbPrfLbl;
	}

	public boolean isVsbPrfLbl() {
		return vsbPrfLbl;
	}

	public void setVsbPrfLbl(boolean vsbPrfLbl) {
		this.vsbPrfLbl = vsbPrfLbl;
	}

	public boolean isVsbPnlBtnPrsUsr() {
		return vsbPnlBtnPrsUsr;
	}

	public void setVsbPnlBtnPrsUsr(boolean vsbPnlBtnPrsUsr) {
		this.vsbPnlBtnPrsUsr = vsbPnlBtnPrsUsr;
	}

	public boolean isVlrUsr() {
		return vlrUsr;
	}

	public void setVlrUsr(boolean vlrUsr) {
		this.vlrUsr = vlrUsr;
	}

	public boolean isDsbUsr() {
		return dsbUsr;
	}

	public void setDsbUsr(boolean dsbUsr) {
		this.dsbUsr = dsbUsr;
	}

	public boolean isVsbUsr() {
		return vsbUsr;
	}

	public void setVsbUsr(boolean vsbUsr) {
		this.vsbUsr = vsbUsr;
	}

	public boolean isRqrUsr() {
		return rqrUsr;
	}

	public void setRqrUsr(boolean rqrUsr) {
		this.rqrUsr = rqrUsr;
	}

	public boolean isVsbPnlBtnPrsPsw() {
		return vsbPnlBtnPrsPsw;
	}

	public void setVsbPnlBtnPrsPsw(boolean vsbPnlBtnPrsPsw) {
		this.vsbPnlBtnPrsPsw = vsbPnlBtnPrsPsw;
	}

	public boolean isVlrPsw() {
		return vlrPsw;
	}

	public void setVlrPsw(boolean vlrPsw) {
		this.vlrPsw = vlrPsw;
	}

	public boolean isDsbPsw() {
		return dsbPsw;
	}

	public void setDsbPsw(boolean dsbPsw) {
		this.dsbPsw = dsbPsw;
	}

	public boolean isVsbPsw() {
		return vsbPsw;
	}

	public void setVsbPsw(boolean vsbPsw) {
		this.vsbPsw = vsbPsw;
	}

	public boolean isRqrPsw() {
		return rqrPsw;
	}

	public void setRqrPsw(boolean rqrPsw) {
		this.rqrPsw = rqrPsw;
	}

	public boolean isVsbPnlBtnPrsEml() {
		return vsbPnlBtnPrsEml;
	}

	public void setVsbPnlBtnPrsEml(boolean vsbPnlBtnPrsEml) {
		this.vsbPnlBtnPrsEml = vsbPnlBtnPrsEml;
	}

	public boolean isDsbPrlStt() {
		return dsbPrlStt;
	}

	public void setDsbPrlStt(boolean dsbPrlStt) {
		this.dsbPrlStt = dsbPrlStt;
	}

	public boolean isVsbPrlStt() {
		return vsbPrlStt;
	}

	public void setVsbPrlStt(boolean vsbPrlStt) {
		this.vsbPrlStt = vsbPrlStt;
	}

	public boolean isRqrPrlStt() {
		return rqrPrlStt;
	}

	public void setRqrPrlStt(boolean rqrPrlStt) {
		this.rqrPrlStt = rqrPrlStt;
	}

	public boolean isDsbEml() {
		return dsbEml;
	}

	public void setDsbEml(boolean dsbEml) {
		this.dsbEml = dsbEml;
	}

	public boolean isVsbEml() {
		return vsbEml;
	}

	public void setVsbEml(boolean vsbEml) {
		this.vsbEml = vsbEml;
	}

	public boolean isRqrEml() {
		return rqrEml;
	}

	public void setRqrEml(boolean rqrEml) {
		this.rqrEml = rqrEml;
	}

	public boolean isVlrEml() {
		return vlrEml;
	}

	public void setVlrEml(boolean vlrEml) {
		this.vlrEml = vlrEml;
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

	public boolean isBPrlStt() {
		return BPrlStt;
	}

	public void setBPrlStt(boolean bPrlStt) {
		BPrlStt = bPrlStt;
	}

	public boolean isDsbPrsLbl() {
		return dsbPrsLbl;
	}

	public void setDsbPrsLbl(boolean dsbPrsLbl) {
		this.dsbPrsLbl = dsbPrsLbl;
	}

	public boolean isVsbPrsLbl() {
		return vsbPrsLbl;
	}

	public void setVsbPrsLbl(boolean vsbPrsLbl) {
		this.vsbPrsLbl = vsbPrsLbl;
	}

	public DtaTblPr getPrs() {
		return prs;
	}

	public void setPrs(DtaTblPr prs) {
		this.prs = prs;
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

	public boolean isDsbPrl() {
		return dsbPrl;
	}

	public void setDsbPrl(boolean dsbPrl) {
		this.dsbPrl = dsbPrl;
	}

	public boolean isVsbPrl() {
		return vsbPrl;
	}

	public void setVsbPrl(boolean vsbPrl) {
		this.vsbPrl = vsbPrl;
	}

	public boolean isRqrPrl() {
		return rqrPrl;
	}

	public void setRqrPrl(boolean rqrPrl) {
		this.rqrPrl = rqrPrl;
	}

	public List<ScrTblPrsRol> getLstTblPrl() {
		return lstTblPrl;
	}

	public void setLstTblPrl(List<ScrTblPrsRol> lstTblPrl) {
		this.lstTblPrl = lstTblPrl;
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

	public int getIPrsId() {
		return IPrsId;
	}

	public void setIPrsId(int iPrsId) {
		IPrsId = iPrsId;
	}

	public boolean isDsbPrf() {
		return dsbPrf;
	}

	public void setDsbPrf(boolean dsbPrf) {
		this.dsbPrf = dsbPrf;
	}

	public boolean isVsbPrf() {
		return vsbPrf;
	}

	public void setVsbPrf(boolean vsbPrf) {
		this.vsbPrf = vsbPrf;
	}

	public boolean isRqrPrf() {
		return rqrPrf;
	}

	public void setRqrPrf(boolean rqrPrf) {
		this.rqrPrf = rqrPrf;
	}

	public int getIPrfId() {
		return IPrfId;
	}

	public void setIPrfId(int iPrfId) {
		IPrfId = iPrfId;
	}

	public ScrTblPrsRol getPrl() {
		return prl;
	}

	public void setPrl(ScrTblPrsRol prl) {
		this.prl = prl;
	}

	public boolean isDsbPrsPrj() {
		return dsbPrsPrj;
	}

	public void setDsbPrsPrj(boolean dsbPrsPrj) {
		this.dsbPrsPrj = dsbPrsPrj;
	}

	public boolean isVsbPrsPrj() {
		return vsbPrsPrj;
	}

	public void setVsbPrsPrj(boolean vsbPrsPrj) {
		this.vsbPrsPrj = vsbPrsPrj;
	}

	public boolean isRqrPrsPrj() {
		return rqrPrsPrj;
	}

	public void setRqrPrsPrj(boolean rqrPrsPrj) {
		this.rqrPrsPrj = rqrPrsPrj;
	}

	public int getIPrjId() {
		return IPrjId;
	}

	public void setIPrjId(int iPrjId) {
		IPrjId = iPrjId;
	}

}
