package ec.gob.msp.pms.ctl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.gob.msp.pms.cmm.Message;
import ec.gob.msp.pms.ent.DpaTblCnt;
import ec.gob.msp.pms.ent.IndTblLvl;
import ec.gob.msp.pms.ent.IndTblMain;
import ec.gob.msp.pms.ent.PmsTblMnc;
import ec.gob.msp.pms.ent.ScrTblPrsRol;
import ec.gob.msp.pms.srv.DpaSrvCnt;
import ec.gob.msp.pms.srv.IndSrvLvl;
import ec.gob.msp.pms.srv.PmsSrvMnc;

@ManagedBean
@ViewScoped
public class PmsCtlSmf {

	protected ScrCtlSss sss;
	protected Message msg;

	private List<PmsTblMnc> lstMnc;
	@EJB
	protected PmsSrvMnc sMnc;

	@EJB
	protected DpaSrvCnt sCnt;

	private void newMnc() {
		lstMnc = new ArrayList<PmsTblMnc>();
	}

	private void loadMnc(DpaTblCnt cnt) {
		try {
			this.newMnc();
			lstMnc = sMnc.lstMncCnt(cnt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PmsCtlSmf() {
		sss = new ScrCtlSss();
		msg = new Message();
	}

	protected ScrTblPrsRol loadPrl() {
		try {
			return sss.getPrl();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@PostConstruct
	public void init() {

		try {
			this.loadMnc(this.loadPrl().getDpaTblCnt());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String smfVld(IndTblMain lv3, PmsTblMnc mnc) {
		try {
			if (lv3.getBMainQnt() == true) {
				if (mnc.getRCrtNmb() == -999) {
					return "No aplica";
				} else if (mnc.getRCrtNmb() == -99) {
					return "Sin dato";
				} else {
					return String.valueOf(mnc.getRCrtNmb());
				}
			} else if (mnc.getRCrtNmb() == 1) {
				return lv3.getSMainV3();
			} else if (mnc.getRCrtNmb() == 2) {
				return lv3.getSMainV2();
			} else if (mnc.getRCrtNmb() == 3) {
				return lv3.getSMainV1();
			} else if (mnc.getRCrtNmb() == -999) {
				return "No aplica";
			} else {
				return "Sin dato";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public double smfCls(IndTblMain lv3, PmsTblMnc mnc) {
		double rnk = 0;
		double v0;
		double v1;
		double v2;
		double v3;
		if (lv3.getBMainQnt() == true) {
			v0 = Double.valueOf(lv3.getSMainV0());
			v1 = Double.valueOf(lv3.getSMainV1());
			v2 = Double.valueOf(lv3.getSMainV2());
			v3 = Double.valueOf(lv3.getSMainV3());
			if (v0 < v3) {
				if ((mnc.getRCrtNmb() >= v0) && (mnc.getRCrtNmb() < v1)) {
					rnk = 3;
				} else if ((mnc.getRCrtNmb() >= v1) && (mnc.getRCrtNmb() <= v2)) {
					rnk = 2;
				} else if ((mnc.getRCrtNmb() > v2) && (mnc.getRCrtNmb() <= v3)) {
					rnk = 1;
				} else if (mnc.getRCrtNmb() == -999) {
					rnk = -999;
				} else {
					this.msg.msgWrn("Valor fuera del rango permisible.");
					rnk = -99;
				}
			} else if (v0 > v3) {
				if ((mnc.getRCrtNmb() <= v0) && (mnc.getRCrtNmb() > v1)) {
					rnk = 3;
				} else if ((mnc.getRCrtNmb() <= v1) && (mnc.getRCrtNmb() >= v2)) {
					rnk = 2;
				} else if ((mnc.getRCrtNmb() < v2) && (mnc.getRCrtNmb() >= v3)) {
					rnk = 1;
				} else if (mnc.getRCrtNmb() == -999)
					rnk = -999;
			} else
				rnk = -99;
		} else {
			if ((mnc.getRCrtNmb() < 1 && mnc.getRCrtNmb() != -999) || mnc.getRCrtNmb() > 3) {
				this.msg.msgWrn("Valor fuera del rango permisible.");
				rnk = -99;
			} else {
				rnk = mnc.getRCrtNmb();
			}
		}
		return rnk;
	}

	@EJB
	protected IndSrvLvl SLvl;

	public String smfCdeLv3(IndTblMain lv3) throws Exception {

		IndTblLvl mainLvl = new IndTblLvl();
		mainLvl = SLvl.searchId(lv3.getIndTblLvl().getILvlCde());
		String SLv1Cde = String.valueOf(mainLvl.getILvlFth());

		String SLv2Cde = String.valueOf(String.valueOf(lv3.getIndTblLvl().getILvlCde()).substring(
				String.valueOf(lv3.getIndTblLvl().getILvlCde()).length() - 2,
				String.valueOf(lv3.getIndTblLvl().getILvlCde()).length()));
		String SLv3Cde = String.valueOf(String.valueOf(lv3.getIndTblLvl().getILvlCde()).substring(
				String.valueOf(lv3.getIndTblLvl().getILvlCde()).length() - 2,
				String.valueOf(lv3.getIndTblLvl().getILvlCde()).length()));
		return SLv1Cde + "-" + SLv2Cde + "-" + SLv3Cde;
	}

	public List<PmsTblMnc> getLstMnc() {
		return lstMnc;
	}

	public void setLstMnc(List<PmsTblMnc> lstMnc) {
		this.lstMnc = lstMnc;
	}

}
