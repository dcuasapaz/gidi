package ec.gob.inspi.gidi.sit.ctl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.gob.inspi.gidi.sit.cmm.Code;
import ec.gob.inspi.gidi.sit.cmm.Message;
import ec.gob.inspi.gidi.sit.ent.DpaTblCnr;
import ec.gob.inspi.gidi.sit.ent.InsTblEnt;
import ec.gob.inspi.gidi.sit.ent.InsTblOpt;
import ec.gob.inspi.gidi.sit.srv.DpaSrvCnr;
import ec.gob.inspi.gidi.sit.srv.InsSrvEnt;
import ec.gob.inspi.gidi.sit.srv.InsSrvOpt;

@ManagedBean
@ViewScoped
public class InsCtlEnt {

	protected Code cde;
	protected Message msg;
	protected Code dfl;

	public InsCtlEnt() {
		cde = new Code();
		msg = new Message();
		ent = new InsTblEnt();
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

	////////////////////////// ENTIDAD //////////////////////////

	private boolean dsbEnt;
	private boolean vsbEnt;
	private boolean rqrEnt;

	private void actEnt(boolean dsb, boolean vsb, boolean rqr) {
		dsbEnt = dsb;
		vsbEnt = vsb;
		rqrEnt = rqr;
	}

	private boolean dsbEntCde;
	private boolean vsbEntCde;
	private boolean rqrEntCde;

	private void actEntCde(boolean dsb, boolean vsb, boolean rqr) {
		dsbEntCde = dsb;
		vsbEntCde = vsb;
		rqrEntCde = rqr;
	}

	private boolean dsbEntAcr;
	private boolean vsbEntAcr;
	private boolean rqrEntAcr;

	private void actEntAcr(boolean dsb, boolean vsb, boolean rqr) {
		dsbEntAcr = dsb;
		vsbEntAcr = vsb;
		rqrEntAcr = rqr;
	}

	private int IEntId;
	private List<InsTblEnt> lstTblEnt;
	private List<InsTblEnt> lstEnt;
	private InsTblEnt ent;
	@EJB
	protected InsSrvEnt sEnt;

	public InsTblEnt rtrEnt(int IEntCde) {
		try {
			return sEnt.searchId(IEntCde);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private void newLstTblEnt() {
		IEntId = 0;
		lstTblEnt = new ArrayList<InsTblEnt>();
	}

	private void loadLstTblEnt() {
		try {
			this.newLstTblEnt();
			lstTblEnt = sEnt.srcAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loadEnt(int IEntTpeId) {
		try {
			lstEnt = new ArrayList<InsTblEnt>();
			lstEnt = sEnt.lstEnt(IEntTpeId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<InsTblEnt> loadEntCmb(int IEntTpeId) {
		try {
			return sEnt.lstEnt(IEntTpeId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<InsTblEnt> loadLstEnt(int IEntTpeId) {
		try {
			return sEnt.lstEnt(IEntTpeId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	////////////////////////// OPTION //////////////////////////
	@EJB
	protected InsSrvOpt sInsOpt;
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

	////////////////////////// NIVEL //////////////////////////
	private int ILvlId;
	private List<InsTblOpt> lstLvl;

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

	////////////////////////// PAIS //////////////////////////
	private int ICnrId;

	private List<DpaTblCnr> lstCnr;
	@EJB
	protected DpaSrvCnr sCnr;

	private void newLstCnr() {
		ICnrId = 0;
		lstCnr = new ArrayList<DpaTblCnr>();
	}

	private void loadLstCnr() {
		try {
			this.newLstCnr();
			lstCnr = sCnr.srcAll();
			ICnrId = cde.dpaCnrEcd();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PostConstruct
	public void init() {
		this.actPgr(true, false);
		this.loadLstTblEnt();
		this.actTblBtnDlt(false, true);
		this.actTblBtnEdt(false, true);
		this.actEnt(true, true, false);
		this.actEntCde(true, true, false);
		this.actEntAcr(true, true, false);
		this.actBtnHme(false, true);
		this.actBtnAdd(false, true);
		this.actBtnSve(true, true);
		this.actBtnUpd(true, false);
		this.actBtnRtr(false, true);
	}

	public void add() {
		try {
			this.actPgr(false, true);
			this.actEnt(false, true, true);
			this.actEntCde(false, true, false);
			this.actEntAcr(false, true, false);
			this.actBtnAdd(true, true);
			this.actBtnSve(false, true);
			this.actBtnHme(true, true);
			this.loadLstEntTpe();
			this.loadLstLvl();
			this.loadLstCnr();
			ent = new InsTblEnt();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sve() {
		try {
			if (sEnt.save(ent, ILvlId, IEntTpeId, ICnrId)) {
				this.msg.msgInf(msg.msgSaveInf());
			} else {
				this.msg.msgErr(msg.msgSaveErr());
			}
			this.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void upd() {
		try {
			if (sEnt.update(ent, ILvlId, IEntTpeId, ICnrId)) {
				this.msg.msgInf(msg.msgUpdInf());
			} else {
				this.msg.msgErr(msg.msgUpdErr());
			}
			this.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void edt() {
		try {
			this.actPgr(false, true);
			this.actEnt(false, true, true);
			this.actEntCde(false, true, false);
			this.actEntAcr(false, true, false);
			this.actBtnAdd(true, true);
			this.actBtnSve(true, true);
			this.actBtnHme(true, true);
			this.actBtnUpd(false, true);
			this.loadLstEntTpe();
			IEntTpeId = ent.getITpeId();
			this.loadLstLvl();
			ILvlId = ent.getILvlId();
			this.loadLstCnr();
			ICnrId = ent.getICnrId();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dlt() {
		try {
			sEnt.delete(ent);
			this.msg.msgInf(msg.msgDltInf());
		} catch (Exception e) {
			this.msg.msgInf(msg.msgErrDlt());
			e.printStackTrace();
		}
		this.init();
	}

	public List<InsTblEnt> getLstEnt() {
		return lstEnt;
	}

	public void setLstEnt(List<InsTblEnt> lstEnt) {
		this.lstEnt = lstEnt;
	}

	public boolean isDsbEntCde() {
		return dsbEntCde;
	}

	public void setDsbEntCde(boolean dsbEntCde) {
		this.dsbEntCde = dsbEntCde;
	}

	public boolean isVsbEntCde() {
		return vsbEntCde;
	}

	public void setVsbEntCde(boolean vsbEntCde) {
		this.vsbEntCde = vsbEntCde;
	}

	public boolean isRqrEntCde() {
		return rqrEntCde;
	}

	public void setRqrEntCde(boolean rqrEntCde) {
		this.rqrEntCde = rqrEntCde;
	}

	public boolean isDsbEntAcr() {
		return dsbEntAcr;
	}

	public void setDsbEntAcr(boolean dsbEntAcr) {
		this.dsbEntAcr = dsbEntAcr;
	}

	public boolean isVsbEntAcr() {
		return vsbEntAcr;
	}

	public void setVsbEntAcr(boolean vsbEntAcr) {
		this.vsbEntAcr = vsbEntAcr;
	}

	public boolean isRqrEntAcr() {
		return rqrEntAcr;
	}

	public void setRqrEntAcr(boolean rqrEntAcr) {
		this.rqrEntAcr = rqrEntAcr;
	}

	public int getICnrId() {
		return ICnrId;
	}

	public void setICnrId(int iCnrId) {
		ICnrId = iCnrId;
	}

	public List<DpaTblCnr> getLstCnr() {
		return lstCnr;
	}

	public void setLstCnr(List<DpaTblCnr> lstCnr) {
		this.lstCnr = lstCnr;
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

	public int getIEntId() {
		return IEntId;
	}

	public void setIEntId(int iEntId) {
		IEntId = iEntId;
	}

	public List<InsTblEnt> getLstTblEnt() {
		return lstTblEnt;
	}

	public void setLstTblEnt(List<InsTblEnt> lstTblEnt) {
		this.lstTblEnt = lstTblEnt;
	}

	public InsTblEnt getEnt() {
		return ent;
	}

	public void setEnt(InsTblEnt ent) {
		this.ent = ent;
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

}
