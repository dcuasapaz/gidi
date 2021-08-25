package ec.gob.inspi.gidi.sit.ctl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.gob.inspi.gidi.sit.cmm.Code;
import ec.gob.inspi.gidi.sit.cmm.Message;
import ec.gob.inspi.gidi.sit.ent.InsTblEnt;
import ec.gob.inspi.gidi.sit.ent.InsTblOpt;
import ec.gob.inspi.gidi.sit.ent.InsTblUnt;
import ec.gob.inspi.gidi.sit.srv.InsSrvEnt;
import ec.gob.inspi.gidi.sit.srv.InsSrvOpt;
import ec.gob.inspi.gidi.sit.srv.InsSrvUnt;

@ManagedBean
@ViewScoped
public class InsCtlUnt {

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

	private String SBldUnt;

	private boolean dsbBldUnt;
	private boolean vsbBldUnt;
	private boolean rqrBldUnt;

	private void actBldUnt(boolean dsb, boolean vsb, boolean rqr) {
		dsbBldUnt = dsb;
		vsbBldUnt = vsb;
		rqrBldUnt = rqr;
	}

	public void chsUnt() {
		this.actUntSub(false, true, true);
		this.actUnt(false, true, true);
		if (Integer.parseInt(SBldUnt) != -99) {// Cuando no es una UNIDAD
			this.loadLstUntAtr(ent);
			this.actUntAtr(false, true, true);
		} else {
			this.newLstUntAtr();
			this.actUntAtr(true, true, false);
		}
		this.newLstEntTpe();
		this.newLstEnt();
		this.newLstUntAtr();
		this.loadLstLvl();
		this.loadLstEntTpe();
	}

	private boolean dsbUntSub;
	private boolean vsbUntSub;
	private boolean rqrUntSub;

	private void actUntSub(boolean dsb, boolean vsb, boolean rqr) {
		dsbUntSub = dsb;
		vsbUntSub = vsb;
		rqrUntSub = rqr;
	}

	private boolean dsbUnt;
	private boolean vsbUnt;
	private boolean rqrUnt;

	private void actUnt(boolean dsb, boolean vsb, boolean rqr) {
		dsbUnt = dsb;
		vsbUnt = vsb;
		rqrUnt = rqr;
	}

	////////////////////////// TIPO ENTIDAD //////////////////////////
	private int IEntTpeId;
	private List<InsTblOpt> lstEntTpe;

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
			this.newLstUntAtr();
			this.loadLstEnt(IEntTpeId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	////////////////////////// ENTIDAD //////////////////////////
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
			if (Integer.parseInt(SBldUnt) != -99) {// Cuando no es una UNIDAD
				this.loadLstUntAtr(ent); // Cargar las UNIDADES padre
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	////////////////////////// UNIDAD //////////////////////////
	// Atributo Unidad
	private boolean dsbUntAtr;
	private boolean vsbUntAtr;
	private boolean rqrUntAtr;

	private void actUntAtr(boolean dsb, boolean vsb, boolean rqr) {
		dsbUntAtr = dsb;
		vsbUntAtr = vsb;
		rqrUntAtr = rqr;
	}

	private List<InsTblUnt> lstTblUnt;
	private List<InsTblUnt> lstTblAtr;
	private List<InsTblUnt> lstUntMain;
	private List<InsTblUnt> lstUntSub;
	private int IUntCde;
	public InsTblUnt untTbl;
	@EJB
	protected InsSrvUnt sUnt;

	private void newLstUntAtr() {
		lstTblAtr = new ArrayList<InsTblUnt>();
		IUntCde = 0;
	}

	public List<InsTblUnt> loadUnt(int IEntId) {
		try {
			return sUnt.lstUntMain(sEnt.searchId(IEntId));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<InsTblUnt> loadUntSub(int IEntId) {
		try {
			return sUnt.lstUntSub(sEnt.searchId(IEntId));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private void loadLstUntAtr(InsTblEnt ent) {
		try {
			this.newLstUntAtr();
			lstTblAtr = sUnt.lstUnt(ent);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loadUntSub(int IUntMain, String SUntBld) {
		try {
			if (Integer.parseInt(SUntBld) != -99) {// Cuando es una SUB-UNIDAD
				lstUntSub = new ArrayList<InsTblUnt>();
				lstUntSub = sUnt.lstUntSub(IUntMain);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	public String loadUntTbl(InsTblUnt unt) {
		try {
			String rtr = "";
			if (unt.getIUntCde() == -99) {
				rtr = sUnt.searchId(unt.getIUntId()).getSUntNme() + " (" + sUnt.searchId(unt.getIUntId()).getSUntAcr()
						+ ")";
			} else {
				rtr = this.vldUntSub(unt).getSUntNme() + " (" + this.vldUntSub(unt).getSUntAcr()
						+ ") <br/> <div class='alg-ctr'><b> " + this.vldUnt(unt).getSUntNme() + " ("
						+ this.vldUnt(unt).getSUntAcr() + ") </b></div>";
			}
			return rtr;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void chsUntAtr() {

	}

	////////////////////////// NIVEL //////////////////////////
	private int ILvlId;
	private List<InsTblOpt> lstLvl;
	@EJB
	protected InsSrvOpt sInsOpt;

	private void newLstLvl() {
		ILvlId = 0;
		lstLvl = new ArrayList<InsTblOpt>();
	}

	private void loadLstLvl() {
		try {
			this.newLstLvl();
			lstLvl = sInsOpt.lstOpt(cde.insUntLvl());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void newTblUnt() {
		lstTblUnt = new ArrayList<InsTblUnt>();
	}

	private void loadTblUnt() {
		try {
			this.newTblUnt();
			lstTblUnt = sUnt.lstTblUnt();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public InsTblEnt vldEnt(InsTblUnt unt) {
		try {
			if (unt.getIUntCde() != -99) {
				return sEnt.searchId(sUnt.searchId(unt.getIUntCde()).getInsTblEnt().getIEntCde());
			} else {
				return unt.getInsTblEnt();
			}
		} catch (Exception e) {
			return null;
		}
	}

	public InsTblUnt vldUnt(InsTblUnt unt) {
		try {
			if (unt.getIUntCde() != -99) {
				return sUnt.searchId(unt.getIUntCde());
			} else {
				return unt;
			}
		} catch (Exception e) {
			return null;
		}
	}

	public InsTblUnt vldUntSub(InsTblUnt unt) {
		try {
			if (unt.getIUntCde() != -99) {
				return unt;
			} else {
				return sUnt.searchId(-99);
			}
		} catch (Exception e) {
			return null;
		}
	}
	

	public InsCtlUnt() {
		lstTblUnt = new ArrayList<InsTblUnt>();
		untTbl = new InsTblUnt();
		cde = new Code();
		msg = new Message();
		ent = new InsTblEnt();
	}

	public InsTblUnt rtrUnt(int IUntId) {
		try {
			return sUnt.searchId(IUntId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@PostConstruct
	public void init() {
		this.actPgr(true, false);
		this.loadTblUnt();
		this.actTblBtnDlt(false, true);
		this.actTblBtnEdt(false, true);
		this.actUntSub(true, true, false);
		this.actUnt(true, true, false);
		this.actUntAtr(true, true, false);
		this.actBldUnt(true, true, false);
		this.actBtnHme(false, true);
		this.actBtnAdd(false, true);
		this.actBtnSve(true, true);
		this.actBtnUpd(true, false);
		this.actBtnRtr(false, true);
	}

	public void add() {
		this.untTbl = new InsTblUnt();
		this.SBldUnt = "";
		this.newLstEntTpe();
		this.newLstEnt();
		this.newLstLvl();
		this.actPgr(false, true);
		this.actBldUnt(false, true, true);
		this.actBtnHme(true, true);
		this.actBtnAdd(true, true);
		this.actBtnSve(false, true);
	}

	public void sve() {
		try {
			boolean vlr = false;
			if (Integer.parseInt(SBldUnt) == -99) {// Cuando es una UNIDAD
				sUnt.save(ent, ILvlId, Integer.parseInt(SBldUnt), untTbl);
				vlr = true;
			} else {
				sUnt.save(ent, ILvlId, IUntCde, untTbl);
				vlr = true;
			}
			if (vlr != false) {
				this.msg.msgInf(msg.msgSaveInf());
				this.init();
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
		SBldUnt = "";
		this.actPgr(false, true);
		this.actBtnHme(true, true);
		this.actBtnAdd(true, true);
		this.actBtnSve(true, false);
		this.actBtnUpd(false, true);
		this.actUnt(false, true, true);
		this.actUntSub(false, true, true);

		try {
			if (untTbl.getIUntCde() == -99) { // Cuando es una UNIDAD
				SBldUnt = String.valueOf(untTbl.getIUntCde());
				this.actUntAtr(true, true, false);
			} else {
				SBldUnt = "0";
				this.actUntAtr(false, true, true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			// NIVEL //
			this.loadLstLvl();
			ILvlId = untTbl.getILvlId();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			// TIPO ENTIDAD //
			this.loadLstEntTpe();
			IEntTpeId = untTbl.getInsTblEnt().getITpeId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			// ENTIDAD //
			this.loadLstEnt(IEntTpeId);
			IEntId = untTbl.getInsTblEnt().getIEntCde();
			ent = untTbl.getInsTblEnt();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (untTbl.getIUntCde() != -99) { // Cuando es una SUB-UNIDAD
			try {
				InsTblUnt aux = new InsTblUnt();
				aux = sUnt.searchId(untTbl.getIUntCde());
				this.loadLstUntAtr(ent);
				IUntCde = aux.getIUntId();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void dlt() {
		try {
			if (untTbl.getIUntCde() != -99) { // Cuando es UNIDAD
				sUnt.delete(untTbl);
				this.loadTblUnt();
				this.msg.msgInf(msg.msgDltInf());
			} else {
				this.msg.msgInf("Es padre: verificar si tiene hijos ");
			}
			this.init();
		} catch (Exception e) {
			e.printStackTrace();
			this.msg.msgErr(this.msg.msgErrDlt());
		}
	}

	public void upd() {
		try {
			boolean vlr = false;
			if (untTbl.getIUntCde() == -99) { // Cuando es una UNIDAD
				vlr = sUnt.update(ent, ILvlId, Integer.parseInt(SBldUnt), untTbl);
			} else {
				vlr = sUnt.update(ent, ILvlId, IUntCde, untTbl);
			}
			if (vlr != false) {
				this.msg.msgInf(msg.msgUpdInf());
			} else {
				this.msg.msgErr(msg.msgUpdErr());
			}
			this.init();
		} catch (Exception e) {
			e.printStackTrace();
			this.msg.msgErr(this.msg.msgErrUpd());
		}
	}

	public List<InsTblUnt> getLstUntSub() {
		return lstUntSub;
	}

	public void setLstUntSub(List<InsTblUnt> lstUntSub) {
		this.lstUntSub = lstUntSub;
	}

	public List<InsTblUnt> getLstUntMain() {
		return lstUntMain;
	}

	public void setLstUntMain(List<InsTblUnt> lstUntMain) {
		this.lstUntMain = lstUntMain;
	}

	public String getSBldUnt() {
		return SBldUnt;
	}

	public void setSBldUnt(String sBldUnt) {
		SBldUnt = sBldUnt;
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

	public int getILvlId() {
		return ILvlId;
	}

	public void setILvlId(int iLvlId) {
		ILvlId = iLvlId;
	}

	public List<InsTblOpt> getLstLvl() {
		return lstLvl;
	}

	public void setLstLvl(List<InsTblOpt> lstLvl) {
		this.lstLvl = lstLvl;
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

	public InsTblUnt getUntTbl() {
		return untTbl;
	}

	public void setUntTbl(InsTblUnt untTbl) {
		this.untTbl = untTbl;
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

	public List<InsTblUnt> getLstTblUnt() {
		return lstTblUnt;
	}

	public void setLstTblUnt(List<InsTblUnt> lstTblUnt) {
		this.lstTblUnt = lstTblUnt;
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

	public InsTblEnt getEnt() {
		return ent;
	}

	public void setEnt(InsTblEnt ent) {
		this.ent = ent;
	}

	public boolean isDsbUntAtr() {
		return dsbUntAtr;
	}

	public void setDsbUntAtr(boolean dsbUntAtr) {
		this.dsbUntAtr = dsbUntAtr;
	}

	public boolean isVsbUntAtr() {
		return vsbUntAtr;
	}

	public void setVsbUntAtr(boolean vsbUntAtr) {
		this.vsbUntAtr = vsbUntAtr;
	}

	public boolean isRqrUntAtr() {
		return rqrUntAtr;
	}

	public void setRqrUntAtr(boolean rqrUntAtr) {
		this.rqrUntAtr = rqrUntAtr;
	}

	public List<InsTblUnt> getLstTblAtr() {
		return lstTblAtr;
	}

	public void setLstTblAtr(List<InsTblUnt> lstTblAtr) {
		this.lstTblAtr = lstTblAtr;
	}

	public int getIUntCde() {
		return IUntCde;
	}

	public void setIUntCde(int iUntCde) {
		IUntCde = iUntCde;
	}

	public boolean isDsbBldUnt() {
		return dsbBldUnt;
	}

	public void setDsbBldUnt(boolean dsbBldUnt) {
		this.dsbBldUnt = dsbBldUnt;
	}

	public boolean isVsbBldUnt() {
		return vsbBldUnt;
	}

	public void setVsbBldUnt(boolean vsbBldUnt) {
		this.vsbBldUnt = vsbBldUnt;
	}

	public boolean isRqrBldUnt() {
		return rqrBldUnt;
	}

	public void setRqrBldUnt(boolean rqrBldUnt) {
		this.rqrBldUnt = rqrBldUnt;
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

}
