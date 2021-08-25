package ec.gob.inspi.gidi.sit.ctl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.gob.inspi.gidi.sit.cmm.Code;
import ec.gob.inspi.gidi.sit.cmm.Message;
import ec.gob.inspi.gidi.sit.ent.InsTblApn;
import ec.gob.inspi.gidi.sit.ent.InsTblEnt;
import ec.gob.inspi.gidi.sit.ent.InsTblOpt;
import ec.gob.inspi.gidi.sit.ent.InsTblUnt;
import ec.gob.inspi.gidi.sit.srv.InsSrvApn;
import ec.gob.inspi.gidi.sit.srv.InsSrvEnt;
import ec.gob.inspi.gidi.sit.srv.InsSrvOpt;
import ec.gob.inspi.gidi.sit.srv.InsSrvUnt;

@ManagedBean
@ViewScoped
public class InsCtlApn {

	protected Code cde;
	protected Message msg;

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
		} else {
			this.actUntSub(true, true, false);
		}
		this.actApn(false, true, true);
		this.actEntTpe(false, true, true);
		this.actEnt(false, true, true);
		this.actUnt(false, true, true);

		this.newLstEntTpe();
		this.newLstEnt();
		this.newLstUnt();
		this.newLstUntSub();
		this.loadLstEntTpe();
	}

////////////////////////// TIPO ENTIDAD //////////////////////////

	private boolean dsbEntTpe;
	private boolean vsbEntTpe;
	private boolean rqrEntTpe;

	private void actEntTpe(boolean dsb, boolean vsb, boolean rqr) {
		dsbEntTpe = dsb;
		vsbEntTpe = vsb;
		rqrEntTpe = rqr;
	}

	private int IEntTpeId;
	private List<InsTblOpt> lstEntTpe;
	@EJB
	protected InsSrvOpt sInsOpt;

	private void newLstEntTpe() {
		IEntTpeId = 0;
		lstEntTpe = new ArrayList<InsTblOpt>();
	}

	private void loadLstEntTpe() {
		try {
			this.newLstEntTpe();
			lstEntTpe = sInsOpt.lstOpt(cde.insEntTpe());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void chsEntTpe() {
		try {
			this.newLstEnt();
			this.newLstUnt();
			this.newLstUntSub();
			this.loadLstEnt(IEntTpeId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	////////////////////////// ENTIDAD //////////////////////////

	private boolean dsbEnt;
	private boolean vsbEnt;
	private boolean rqrEnt;

	private void actEnt(boolean dsb, boolean vsb, boolean rqr) {
		dsbEnt = dsb;
		vsbEnt = vsb;
		rqrEnt = rqr;
	}

	private int IEntId;
	private List<InsTblEnt> lstEnt;
	private InsTblEnt ent;
	@EJB
	protected InsSrvEnt sEnt;

	private void newLstEnt() {
		IEntId = 0;
		lstEnt = new ArrayList<InsTblEnt>();
	}

	private void loadLstEnt(int IEntTpeId) {
		try {
			this.newLstEnt();
			lstEnt = sEnt.lstEnt(IEntTpeId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void chsEnt() {
		try {
			ent = new InsTblEnt();
			ent = sEnt.searchId(IEntId);
			this.loadLstUnt(ent);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

////////////////////////// UNIDAD //////////////////////////
	private boolean dsbUnt;
	private boolean vsbUnt;
	private boolean rqrUnt;

	private void actUnt(boolean dsb, boolean vsb, boolean rqr) {
		dsbUnt = dsb;
		vsbUnt = vsb;
		rqrUnt = rqr;
	}

	private List<InsTblUnt> lstUnt;
	private int IUntCde;
	private InsTblUnt unt;
	@EJB
	protected InsSrvUnt sUnt;

	private void newLstUnt() {
		lstUnt = new ArrayList<InsTblUnt>();
		IUntCde = 0;
	}

	private void loadLstUnt(InsTblEnt ent) {
		try {
			this.newLstUnt();
			lstUnt = sUnt.lstUnt(ent);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void chsUnt() {
		try {
			unt = new InsTblUnt();
			unt = sUnt.searchId(IUntCde);
			if (Integer.parseInt(SUntBld) != -99) {// Cuando no es una UNIDAD
				this.loadLstUntSub(IUntCde);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

////////////////////////// SUB-UNIDAD //////////////////////////
	private boolean dsbUntSub;
	private boolean vsbUntSub;
	private boolean rqrUntSub;

	private void actUntSub(boolean dsb, boolean vsb, boolean rqr) {
		dsbUntSub = dsb;
		vsbUntSub = vsb;
		rqrUntSub = rqr;
	}

	private List<InsTblUnt> lstUntSub;
	private int IUntId;
	private InsTblUnt untSub;

	private void newLstUntSub() {
		lstUntSub = new ArrayList<InsTblUnt>();
		IUntId = 0;
	}

	private void loadLstUntSub(int IUntCde) {
		try {
			this.newLstUntSub();
			lstUntSub = sUnt.lstUntSub(IUntCde);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void chsUntSub() {
		try {
			untSub = new InsTblUnt();
			untSub = sUnt.searchId(IUntId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

////////////////////////// CARGO //////////////////////////

	private boolean dsbApn;
	private boolean vsbApn;
	private boolean rqrApn;

	private void actApn(boolean dsb, boolean vsb, boolean rqr) {
		dsbApn = dsb;
		vsbApn = vsb;
		rqrApn = rqr;
	}

	private List<InsTblApn> lstTblApn;
	private List<InsTblApn> lstApn;
	private InsTblApn apn;
	@EJB
	protected InsSrvApn sApn;

	private void newLstTblApn() {
		lstTblApn = new ArrayList<>();
	}

	private void loadLstTblApn() {
		try {
			this.newLstTblApn();
			lstTblApn = sApn.srcAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loadApnUnt(int IUntMain) {
		try {
			lstApn = new ArrayList<>();
			lstApn = sApn.lstApn(sUnt.searchId(IUntMain));
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public List<InsTblApn> loadApnUntCmb(String SUntBld, int IUntCde, int IUntId) {
		try {
			if (Integer.parseInt(SUntBld) == -99) {
				return sApn.lstApn(sUnt.searchId(IUntCde));
			}else {
				return sApn.lstApn(sUnt.searchId(IUntId));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void loadApnUntSub(int IUntSubId) {
		try {
			lstApn = new ArrayList<>();
			lstApn = sApn.lstApn(sUnt.searchId(IUntSubId));
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public InsCtlApn() {
		cde = new Code();
		msg = new Message();
		apn = new InsTblApn();
	}

	public InsTblApn rtrEnt(int IEntCde) {
		try {
			return sApn.searchId(IEntCde);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@PostConstruct
	public void init() {
		this.actPgr(true, false);
		this.loadLstTblApn();
		this.actTblBtnDlt(false, true);
		this.actTblBtnEdt(false, true);
		this.actEntTpe(true, true, false);
		this.actEnt(true, true, false);
		this.actUnt(true, true, false);
		this.actUntSub(true, true, false);
		this.actApn(true, true, false);
		this.actUntBld(true, true, false);
		this.actBtnHme(false, true);
		this.actBtnAdd(false, true);
		this.actBtnSve(true, true);
		this.actBtnUpd(true, false);
		this.actBtnRtr(false, true);
	}

	public void add() {
		try {
			this.SUntBld = "";
			this.newLstEntTpe();
			this.newLstEnt();
			this.newLstUnt();
			this.newLstUntSub();
			apn = new InsTblApn();
			this.actPgr(false, true);
			this.actUntBld(false, true, true);
			this.actBtnHme(true, true);
			this.actBtnAdd(true, true);
			this.actBtnSve(false, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sve() {
		try {
			boolean vlr = false;
			if (Integer.parseInt(SUntBld) == -99) {// Cuando es una UNIDAD
				sApn.save(apn, sUnt.searchId(IUntCde));
				vlr = true;
			} else {
				sApn.save(apn, sUnt.searchId(IUntId));
				vlr = true;
			}
			if (vlr != false) {
				this.msg.msgInf(msg.msgSaveInf());
			} else {
				this.msg.msgErr(msg.msgSaveErr());
			}
			this.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void edt() {
		ent = new InsTblEnt();
		unt = new InsTblUnt();
		untSub = new InsTblUnt();
		SUntBld = "";
		this.actPgr(false, true);
		this.actBtnHme(true, true);
		this.actBtnAdd(true, true);
		this.actBtnSve(true, false);
		this.actBtnUpd(false, true);
		this.actApn(false, true, true);
		this.actEnt(false, true, true);
		this.actUnt(false, true, true);
		this.actEntTpe(false, true, true);
		try {
			if (apn.getInsTblUnt().getIUntCde() == -99) { // Cuando es una UNIDAD
				SUntBld = String.valueOf(apn.getInsTblUnt().getIUntCde());
				this.actUntSub(true, true, false);
			} else {
				SUntBld = "0";
				this.actUntSub(false, true, true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			// TIPO ENTIDAD //
			this.loadLstEntTpe();
			IEntTpeId = apn.getInsTblUnt().getInsTblEnt().getITpeId();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			// ENTIDAD //
			this.loadLstEnt(IEntTpeId);
			IEntId = apn.getInsTblUnt().getInsTblEnt().getIEntCde();
			ent = apn.getInsTblUnt().getInsTblEnt();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// UNIDAD | SUB-UNIDAD //

		this.loadLstUnt(ent);
		if (apn.getInsTblUnt().getIUntCde() != -99) { // Cuando es una SUB-UNIDAD
			try {
				IUntCde = sUnt.searchId(apn.getInsTblUnt().getIUntCde()).getIUntId();
				this.loadLstUntSub(IUntCde);
				IUntId = apn.getInsTblUnt().getIUntId();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				// UNIDAD //
				IUntCde = apn.getInsTblUnt().getIUntId();
				unt = apn.getInsTblUnt();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void upd() {
		try {
			try {
				boolean vlr = false;
				if (Integer.parseInt(SUntBld) == -99) {// Cuando es una UNIDAD
					sApn.update(apn, sUnt.searchId(IUntCde));
					vlr = true;
				} else {
					sApn.update(apn, sUnt.searchId(IUntId));
					vlr = true;
				}
				if (vlr != false) {
					this.msg.msgInf(msg.msgUpdInf());
				} else {
					this.msg.msgErr(msg.msgUpdErr());
				}
				this.init();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dlt() {
		try {
			sApn.delete(apn);
			this.msg.msgInf(msg.msgDltInf());
		} catch (Exception e) {
			e.printStackTrace();
			this.msg.msgErr(this.msg.msgErrDlt());
		}
		this.init();
	}

	public List<InsTblApn> getLstApn() {
		return lstApn;
	}

	public void setLstApn(List<InsTblApn> lstApn) {
		this.lstApn = lstApn;
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

	public List<InsTblOpt> getLstEntTpe() {
		return lstEntTpe;
	}

	public void setLstEntTpe(List<InsTblOpt> lstEntTpe) {
		this.lstEntTpe = lstEntTpe;
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

	public List<InsTblEnt> getLstEnt() {
		return lstEnt;
	}

	public void setLstEnt(List<InsTblEnt> lstEnt) {
		this.lstEnt = lstEnt;
	}

	public InsTblEnt getEnt() {
		return ent;
	}

	public void setEnt(InsTblEnt ent) {
		this.ent = ent;
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

	public List<InsTblUnt> getLstUnt() {
		return lstUnt;
	}

	public void setLstUnt(List<InsTblUnt> lstUnt) {
		this.lstUnt = lstUnt;
	}

	public int getIUntCde() {
		return IUntCde;
	}

	public void setIUntCde(int iUntCde) {
		IUntCde = iUntCde;
	}

	public InsTblUnt getUnt() {
		return unt;
	}

	public void setUnt(InsTblUnt unt) {
		this.unt = unt;
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

	public List<InsTblUnt> getLstUntSub() {
		return lstUntSub;
	}

	public void setLstUntSub(List<InsTblUnt> lstUntSub) {
		this.lstUntSub = lstUntSub;
	}

	public int getIUntId() {
		return IUntId;
	}

	public void setIUntId(int iUntId) {
		IUntId = iUntId;
	}

	public InsTblUnt getUntSub() {
		return untSub;
	}

	public void setUntSub(InsTblUnt untSub) {
		this.untSub = untSub;
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

	public List<InsTblApn> getLstTblApn() {
		return lstTblApn;
	}

	public void setLstTblApn(List<InsTblApn> lstTblApn) {
		this.lstTblApn = lstTblApn;
	}

	public InsTblApn getApn() {
		return apn;
	}

	public void setApn(InsTblApn apn) {
		this.apn = apn;
	}

}
