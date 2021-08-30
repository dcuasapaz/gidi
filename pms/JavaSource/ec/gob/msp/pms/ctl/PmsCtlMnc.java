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
import ec.gob.msp.pms.cmm.Ctg;
import ec.gob.msp.pms.cmm.Default;
import ec.gob.msp.pms.cmm.Message;
import ec.gob.msp.pms.cmm.Method;
import ec.gob.msp.pms.ent.DteTblMnt;
import ec.gob.msp.pms.ent.DteTblYr;
import ec.gob.msp.pms.ent.IndTblLvl;
import ec.gob.msp.pms.ent.IndTblMain;
import ec.gob.msp.pms.ent.PmsTblMnc;
import ec.gob.msp.pms.ent.ScrTblPrsRol;
import ec.gob.msp.pms.ent.VrfTblIn;
import ec.gob.msp.pms.ent.VrfTblInsMnc;
import ec.gob.msp.pms.srv.DteSrvDay;
import ec.gob.msp.pms.srv.DteSrvMnt;
import ec.gob.msp.pms.srv.DteSrvYr;
import ec.gob.msp.pms.srv.IndSrvLvl;
import ec.gob.msp.pms.srv.IndSrvMain;
import ec.gob.msp.pms.srv.PmsSrvMnc;
import ec.gob.msp.pms.srv.VrfSrvIns;
import ec.gob.msp.pms.srv.VrfSrvInsMnc;
import ec.gob.msp.pms.srv.WebSrvClr;

@ManagedBean
@ViewScoped
public class PmsCtlMnc {

	protected Code cde;
	protected ScrCtlSss sss;
	private PmsTblMnc mnc;
	protected Message msg;
	protected Default dfl;

	public PmsCtlMnc() {
		cde = new Code();
		lv1 = new IndTblLvl();
		lv2 = new IndTblLvl();
		sss = new ScrCtlSss();
		prl = new ScrTblPrsRol();
		mnc = new PmsTblMnc();
		mth = new Method();
		clr = new WebCtlClr();
		msg = new Message();
		dfl = new Default();
		ins = new VrfTblIn();
		insMnc = new VrfTblInsMnc();
	}

	private ScrTblPrsRol prl;

	public void loadPrl() {
		try {
			prl = sss.getPrl();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*******************************************************/
	// FORM
	private boolean vsbTbl;
	private boolean vsbDta;

	private void actVsbBdy(boolean tbl, boolean dta) {
		this.vsbTbl = tbl;
		this.vsbDta = dta;
	}

	/*******************************************************/

	private void actInit() {
		this.actVsbBdy(true, false);

		this.actIndCls(true, true, false);
		this.actIndEsp(true, true, false);

		this.actEsp(true, true, false);
		this.actMain(true, true, false);
		this.actLv1(true, true, false);
		this.actLv2(true, true, false);
		this.loadTxtClr();
		this.actMainLbl(false);
		this.actMainVle(true, false, false);
		this.actMainOpt(true, false, false);
		this.actYr(true, true, false);
		this.actMth(true, true, false);
		this.actDay(true, true, false);
		this.actDte(true, true, false);
		this.actVldYr(true, true, false);
		this.actVldMth(true, true, false);
		this.actVldDay(true, true, false);
		this.actVldDwn(true, true);
		this.actIns(true, true, false);
		this.actInsMnc(true, true, false);
		this.actBtnAdd(true, true);
		this.actBtnNew(true, true);
		this.actBtnVld(true, true);
		this.actBtnSve(true, true);
		this.actBtnNvo(false, true);
	}

	@PostConstruct
	public void init() {
		this.loadPrl();
		this.actInit();
		this.loadMnc();
	}

	/*******************************************************/
	public void actAdd() {
		this.actVsbBdy(false, true);
		this.actIndCls(false, true, false);
		this.actIndEsp(false, true, false);
		this.actEsp(false, true, true);
		this.vlrIndCls = false;
		this.vlrIndEsp = true;
		this.IEspCde = cde.IPmsEspCdeNoInp();
		this.chsEsp();
		this.actBtnSve(false, true);
		this.actBtnNvo(true, true);
	}

	public void add() {
		this.actAdd();
		mnc = new PmsTblMnc();
		ins = new VrfTblIn();
		insMnc = new VrfTblInsMnc();
		main = new IndTblMain();
		vlrMnc = -99;
		IYrVle = 0;
		IMthVle = 0;
		IDayVle = 0;
		IYrVldVle = 0;
		IMthVldVle = 0;
		IDayVldVle = 0;
		txtClrBle = "";
		txtClrOrg = "";
		txtClrPnk = "";
		txtClrSlv = "";
		txtClrVlt = "";
		IInsId = 0;
		lstIns = new ArrayList<>();
		lstInsMnc = new ArrayList<>();

	}

	/*******************************************************/
	public void actSve() {

	}

	public void sve() {
		try {
			SMnc.insert(mnc);
			if (lstInsMnc.size() > 0) {
				Iterator<VrfTblInsMnc> itAux = lstInsMnc.iterator();
				while (itAux.hasNext()) {
					VrfTblInsMnc auxInsMnc = new VrfTblInsMnc();
					auxInsMnc = itAux.next();
					SInsMnc.insert(auxInsMnc);
				}
			}
			this.msg.msgInf("Infomación almacenada correctamente");
			this.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*******************************************************/
	// Form: Indicadores
	private boolean vlrIndCls;
	private boolean vlrIndEsp;
	private boolean dsbIndCls;
	private boolean vsbIndCls;
	private boolean rqrIndCls;
	private boolean dsbIndEsp;
	private boolean vsbIndEsp;
	private boolean rqrIndEsp;

	private void actIndCls(boolean dsb, boolean vsb, boolean rqr) {
		this.dsbIndCls = dsb;
		this.vsbIndCls = vsb;
		this.rqrIndCls = rqr;

	}

	private void actIndEsp(boolean dsb, boolean vsb, boolean rqr) {
		this.dsbIndEsp = dsb;
		this.vsbIndEsp = vsb;
		this.rqrIndEsp = rqr;

	}

	public void chsIndCls() {
		try {
			if (vlrIndCls == true) {
				this.actLv1(false, true, true);
				this.actEsp(true, true, false);
				vlrIndEsp = false;
			} else {
				vlrIndCls = false;
				this.actLv1(true, true, false);
				this.actLv2(true, true, false);
				this.actEsp(false, true, true);
				vlrIndEsp = true;
				ILv1Cde = 0;
				ILv2Cde = 0;
			}
			this.actMain(true, true, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void chsIndEsp() {
		try {
			if (vlrIndEsp == true) {
				this.actLv1(true, true, false);
				this.actLv2(true, true, false);
				this.actEsp(false, true, true);
				vlrIndEsp = true;
				vlrIndCls = false;
			} else {
				vlrIndCls = true;
				this.actLv1(false, true, true);
				this.actEsp(true, true, false);
				vlrIndEsp = false;
				ILv1Cde = 0;
				ILv2Cde = 0;
			}
			this.actMain(true, true, false);
			this.IEspCde = cde.IPmsEspCdeNoInp();
			this.chsEsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*******************************************************/
	private boolean dsbLv1;
	private boolean vsbLv1;
	private boolean rqrLv1;
	private boolean dsbLv2;
	private boolean vsbLv2;
	private boolean rqrLv2;

	private void actLv1(boolean dsb, boolean vsb, boolean rqr) {
		this.dsbLv1 = dsb;
		this.vsbLv1 = vsb;
		this.rqrLv1 = rqr;

	}

	private void actLv2(boolean dsb, boolean vsb, boolean rqr) {
		this.dsbLv2 = dsb;
		this.vsbLv2 = vsb;
		this.rqrLv2 = rqr;
	}

	@EJB
	protected IndSrvLvl SIndLvl;
	private IndTblLvl lv1;
	private int ILv1Cde;
	private IndTblLvl lv2;
	private int ILv2Cde;

	public void chsLv1() {
		try {
			lv1 = new IndTblLvl();
			lv1 = SIndLvl.searchId(ILv1Cde);
			this.actLv2(false, true, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void chsLv2() {
		try {
			lv2 = new IndTblLvl();
			lv2 = SIndLvl.searchId(ILv2Cde);
			this.loadMain(lv2);
			this.actMain(false, true, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*******************************************************/
	private int IEspCde;
	private boolean dsbEsp;
	private boolean vsbEsp;
	private boolean rqrEsp;

	private void actEsp(boolean dsb, boolean vsb, boolean rqr) {
		this.dsbEsp = dsb;
		this.vsbEsp = vsb;
		this.rqrEsp = rqr;
	}

	public void chsEsp() {
		try {
			this.actMain(false, true, true);
			this.newMain();
			if (IEspCde == 21) {
				lstMain = SIndMain.lstMain21();
			} else if (IEspCde == 22) {
				lstMain = SIndMain.lstMain22(prl.getDpaTblCnt());
			} else if (IEspCde == 23) {
				lstMain = SIndMain.lstMain23();
			} else if (IEspCde == 24) {
				lstMain = SIndMain.lstMain24();
			} else if (IEspCde == 25) {
				lstMain = SIndMain.lstMain25();
			} else if (IEspCde == 26) {
				lstMain = SIndMain.lstMain26();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*******************************************************/
	private int IMainCde;
	private List<IndTblMain> lstMain;
	private IndTblMain main;
	@EJB
	protected IndSrvMain SIndMain;

	private boolean dsbMain;
	private boolean vsbMain;
	private boolean rqrMain;

	private void actMain(boolean dsb, boolean vsb, boolean rqr) {
		this.dsbMain = dsb;
		this.vsbMain = vsb;
		this.rqrMain = rqr;
	}

	private void newMain() {
		IMainCde = 0;
		lstMain = new ArrayList<IndTblMain>();
	}

	private void loadMain(IndTblLvl lvl) {
		try {
			this.newMain();
			lstMain = SIndMain.lstMain(lv2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@EJB
	protected WebSrvClr SClr;

	private String txtClrOrg;
	private String txtClrBle;
	private String txtClrPnk;
	private String txtClrVlt;
	private String txtClrSlv;

	private void loadTxtClr() {
		try {
			txtClrOrg = "color: " + SClr.searchId(cde.IVleFth()).getSClrHex() + ";";
			txtClrBle = "color: " + SClr.searchId(cde.IVleFth()).getSClrHex() + ";";
			txtClrPnk = "color: " + SClr.searchId(cde.IVleFth()).getSClrHex() + ";";
			txtClrVlt = "color: " + SClr.searchId(cde.IVleFth()).getSClrHex() + ";";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@EJB
	protected IndSrvLvl SLvl;

	private boolean vsbMainPnlVle;
	private boolean vsbMainPnlOpt;

	private boolean dsbMainVle;
	private boolean rqrMainVle;
	private boolean vsbMainVle;

	private boolean vsbClr;

	private void actMainVle(boolean dsb, boolean vsb, boolean rqr) {
		this.dsbMainVle = dsb;
		this.rqrMainVle = rqr;
		this.vsbMainVle = vsb;
	}

	private boolean dsbMainOpt;
	private boolean rqrMainOpt;
	private boolean vsbMainOpt;

	private void actMainOpt(boolean dsb, boolean vsb, boolean rqr) {
		this.dsbMainOpt = dsb;
		this.rqrMainOpt = rqr;
		this.vsbMainOpt = vsb;
	}

	private String lblMainVle;

	private boolean vsbMainLbl;

	private void actMainLbl(boolean vsb) {
		this.vsbMainLbl = vsb;
	}

	private boolean vsbClrVlr;

	private List<Ctg> lstCtg;
	private int id;

	private void newLstCtg() {
		lstCtg = new ArrayList<Ctg>();
		id = 0;
	}

	private double vlrMnc;

	public void chsMain() {
		try {

			lv1 = new IndTblLvl();
			lv2 = new IndTblLvl();

			main = new IndTblMain();
			main = SIndMain.searchId(IMainCde);

			lv2 = main.getIndTblLvl();
			lv1 = SLvl.searchId(main.getIndTblLvl().getILvlFth());

			ILv1Cde = lv1.getILvlCde();
			ILv2Cde = lv2.getILvlCde();

			vlrMnc = -99;
			vsbClrVlr = true;
			if (main.getBMainObl() == true) {
				txtClrOrg = "color: " + SClr.searchId(cde.org()).getSClrHex() + ";";
			} else {
				txtClrOrg = "color: " + SClr.searchId(cde.IVleFth()).getSClrHex() + ";";
			}

			if (main.getBMainDsn() == true) {
				txtClrBle = "color: " + SClr.searchId(cde.blue()).getSClrHex() + ";";
			} else {
				txtClrBle = "color: " + SClr.searchId(cde.IVleFth()).getSClrHex() + ";";
			}

			if (main.getBMainMtr() == true) {
				txtClrPnk = "color: " + SClr.searchId(cde.pink()).getSClrHex() + ";";
			} else {
				txtClrPnk = "color: " + SClr.searchId(cde.IVleFth()).getSClrHex() + ";";
			}

			if (main.getBMainVln() == true) {
				txtClrVlt = "color: " + SClr.searchId(cde.vlt()).getSClrHex() + ";";
			} else {
				txtClrVlt = "color: " + SClr.searchId(cde.IVleFth()).getSClrHex() + ";";
			}

			String c0, c1, c2, c3;
			mnc = new PmsTblMnc();

			this.actMainLbl(true);
			if (main.getBMainQnt() == true) {
				this.actMainVle(false, true, true);
				this.actMainOpt(true, false, false);
				lblMainVle = "Valor";
			} else {
				this.actMainVle(true, false, false);
				this.actMainOpt(false, true, true);
				lblMainVle = "Categoría";
				c0 = main.getSMainV0();
				c1 = main.getSMainV1();
				c2 = main.getSMainV2();
				c3 = main.getSMainV3();
				if (c0 != "" && c1 != "" && c2 != "" && c3 != "") {
					this.newLstCtg();
					lstCtg.add(new Ctg(1, c3));
					lstCtg.add(new Ctg(2, c2));
					lstCtg.add(new Ctg(3, c1));
					lstCtg.add(new Ctg(0, c0));
				} else {
					this.newLstCtg();
					lstCtg.add(new Ctg(0, "Desconocido"));
					lstCtg.add(new Ctg(3, "No"));
					lstCtg.add(new Ctg(2, "En proceso"));
					lstCtg.add(new Ctg(1, "Si"));
				}
			}

			this.actDte(false, true, false);
			this.actYr(false, true, true);
			this.actMth(false, true, false);
			this.actDay(false, true, false);
			this.loadYr();
			this.actBtnVld(false, true);
			this.actBtnSve(false, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void vldVlrOpt() {
		try {
			if (id == 3) {
				vlrMnc = 3;
			} else if (id == 2) {
				vlrMnc = 2;
			} else if (id == 1) {
				vlrMnc = 1;
			} else {
				vlrMnc = -99;
			}
			System.out.println("Valor Caul: " + vlrMnc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected PmsCtlSmf smf;

	public void vldVlrInd() {
		try {
			smf = new PmsCtlSmf();
			vlrMnc = smf.smfCls(main, mnc);
			System.out.println("Valor Cuan: " + vlrMnc);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*******************************************************/
	private boolean dsbDte;
	private boolean rqrDte;
	private boolean vsbDte;
	private boolean vleDte;

	private void actDte(boolean dsb, boolean vsb, boolean rqr) {
		this.dsbDte = dsb;
		this.rqrDte = rqr;
		this.vsbDte = vsb;
	}

	public void chsDteVle() {
		if (vleDte == true) {
			this.actYr(false, true, true);
			this.actMth(false, true, false);
			this.actDay(false, true, false);
			this.loadYr();
			vleDte = true;
		} else {
			this.actYr(true, true, false);
			this.actMth(true, true, false);
			this.actDay(true, true, false);
			vleDte = false;
			this.IYrVle = 0;
			this.IMthVle = 0;
			this.IDayVle = 0;
		}
	}

	private boolean dsbYr;
	private boolean rqrYr;
	private boolean vsbYr;

	private void actYr(boolean dsb, boolean vsb, boolean rqr) {
		this.dsbYr = dsb;
		this.rqrYr = rqr;
		this.vsbYr = vsb;
	}

	private boolean dsbMth;
	private boolean rqrMth;
	private boolean vsbMth;

	private void actMth(boolean dsb, boolean vsb, boolean rqr) {
		this.dsbMth = dsb;
		this.rqrMth = rqr;
		this.vsbMth = vsb;
	}

	private boolean dsbDay;
	private boolean rqrDay;
	private boolean vsbDay;

	private void actDay(boolean dsb, boolean vsb, boolean rqr) {
		this.dsbDay = dsb;
		this.rqrDay = rqr;
		this.vsbDay = vsb;
	}

	private int IYrVle;
	private int IMthVle;
	private int IDayVle;
	protected Method mth;

	private List<DteTblYr> lstYr;
	private List<DteTblMnt> lstMth;
	private List<Integer> lstDay;

	@EJB
	protected DteSrvYr SYr;
	@EJB
	protected DteSrvMnt SMth;
	@EJB
	protected DteSrvDay SDay;

	private void loadYr() {
		try {
			lstYr = new ArrayList<DteTblYr>();
			lstYr = SYr.srcAll();
			Collections.sort(lstYr, new Comparator<DteTblYr>() {
				public int compare(DteTblYr o1, DteTblYr o2) {
					return o1.getIYrVle().compareTo(o2.getIYrVle());
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void loadMth() {
		try {
			lstMth = new ArrayList<DteTblMnt>();
			lstMth = SMth.srcAll();
			Collections.sort(lstMth, new Comparator<DteTblMnt>() {
				public int compare(DteTblMnt o1, DteTblMnt o2) {
					return o1.getIMntCde().compareTo(o2.getIMntCde());
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void loadDay() {
		try {
			lstDay = new ArrayList<Integer>();
			lstDay = mth.lstDay(IYrVle, IMthVle);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void chsYr() {
		this.loadMth();
	}

	public void chsMth() {
		this.loadDay();
	}

	/*******************************************************/

	private List<DteTblYr> lstVldYr;
	private List<DteTblMnt> lstVldMth;
	private List<Integer> lstVldDay;

	private void loadVldYr() {
		try {
			lstVldYr = new ArrayList<DteTblYr>();
			lstVldYr = SYr.srcAll();
			Collections.sort(lstVldYr, new Comparator<DteTblYr>() {
				public int compare(DteTblYr o1, DteTblYr o2) {
					return o1.getIYrVle().compareTo(o2.getIYrVle());
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void loadVldMth() {
		try {
			lstVldMth = new ArrayList<DteTblMnt>();
			lstVldMth = SMth.srcAll();
			Collections.sort(lstVldMth, new Comparator<DteTblMnt>() {
				public int compare(DteTblMnt o1, DteTblMnt o2) {
					return o1.getIMntCde().compareTo(o2.getIMntCde());
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void loadVldDay() {
		try {
			lstVldDay = new ArrayList<Integer>();
			lstVldDay = mth.lstDay(IYrVldVle, IMthVldVle);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void chsVldYr() {
		this.loadVldMth();
	}

	public void chsVldMth() {
		this.loadVldDay();
	}

	private boolean dsbVldYr;
	private boolean rqrVldYr;
	private boolean vsbVldYr;

	private void actVldYr(boolean dsb, boolean vsb, boolean rqr) {
		this.dsbVldYr = dsb;
		this.rqrVldYr = rqr;
		this.vsbVldYr = vsb;
	}

	private boolean dsbVldMth;
	private boolean rqrVldMth;
	private boolean vsbVldMth;

	private void actVldMth(boolean dsb, boolean vsb, boolean rqr) {
		this.dsbVldMth = dsb;
		this.rqrVldMth = rqr;
		this.vsbVldMth = vsb;
	}

	private boolean dsbVldDay;
	private boolean rqrVldDay;
	private boolean vsbVldDay;

	private void actVldDay(boolean dsb, boolean vsb, boolean rqr) {
		this.dsbVldDay = dsb;
		this.rqrVldDay = rqr;
		this.vsbVldDay = vsb;
	}

	private int IYrVldVle;
	private int IMthVldVle;
	private int IDayVldVle;

	private boolean dsbVldDwn;
	private boolean rqrVldDwn;
	private boolean vsbVldDwn;

	private void actVldDwn(boolean dsb, boolean vsb) {
		this.dsbVldDwn = dsb;
		this.vsbVldDwn = vsb;
	}

	private boolean dsbBtnVld;
	private boolean vsbBtnVld;

	private void actBtnVld(boolean dsb, boolean vsb) {
		this.dsbBtnVld = dsb;
		this.vsbBtnVld = vsb;
	}

	protected WebCtlClr clr;
	private String mainPth;

	public void validate() {
		try {
			System.out.println("Valor: " + vlrMnc);
			System.out.println("Ruta: " + main.getSMainFle());
			mainPth = main.getSMainFle();
			if ((vlrMnc + 10) == 11) {
				this.actVldYr(false, true, false);
				this.actVldMth(false, true, false);
				this.actVldDay(false, true, false);
				this.actVldDwn(false, true);
				this.loadVldYr();
				this.msg.msgInf("Seleccione los medios de verificación");
				try {
					this.loadVldYr();
					this.loadVldMth();
				} catch (Exception e) {
					e.printStackTrace();
				}
				this.loadIns();
				this.actIns(false, true, true);
				this.actInsMnc(false, true, true);
				this.actBtnAdd(false, true);
				this.actBtnNew(true, true);
				insMnc = new VrfTblInsMnc();
				lstInsMnc = new ArrayList<VrfTblInsMnc>();

			} else {
				this.actVldYr(true, true, false);
				this.actVldMth(true, true, false);
				this.actVldDay(true, true, false);
				this.actVldDwn(true, true);
				this.msg.msgWrn("Medio de verificación se activa solo si el valor del indicador esta en verde");
			}

			mnc.setDpaTblCnt(prl.getDpaTblCnt());
			mnc.setIndTblMain(main);
			mnc.setICrtYr(IYrVle);
			mnc.setICrtMth(IMthVle);
			mnc.setICrtDay(IDayVle);
			mnc.setICrtDteTpe(dfl.IVleInt());
			mnc.setSCrtSrc(dfl.SVleStr());
			mnc.setSCrtPrf(dfl.SVleStr());
			mnc.setScrTblPrsRol(prl);
			mnc.setSMncTmeRgs(dfl.SCurrentTime());
			mnc.setDMncDteRgs(dfl.DCurrentDate());
			mnc.setICrtYrSrc(dfl.IVleInt());
			mnc.setICrtMthSrc(dfl.IVleInt());
			mnc.setICrtDaySrc(dfl.IVleInt());
			mnc.setISttId(dfl.IVleInt());
			mnc.setSMncFle(dfl.SVleStr());
			if (main.getBMainQnt() == false) {
				mnc.setRCrtNmb(vlrMnc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*******************************************************/

	private boolean dsbIns;
	private boolean rqrIns;
	private boolean vsbIns;

	private void actIns(boolean dsb, boolean vsb, boolean rqr) {
		this.dsbIns = dsb;
		this.rqrIns = rqr;
		this.vsbIns = vsb;
	}

	private boolean dsbInsMnc;
	private boolean rqrInsMnc;
	private boolean vsbInsMnc;

	private void actInsMnc(boolean dsb, boolean vsb, boolean rqr) {
		this.dsbInsMnc = dsb;
		this.rqrInsMnc = rqr;
		this.vsbInsMnc = vsb;
	}

	private boolean dsbBtnAdd;
	private boolean vsbBtnAdd;

	private void actBtnAdd(boolean dsb, boolean vsb) {
		this.dsbBtnAdd = dsb;
		this.vsbBtnAdd = vsb;
	}

	private boolean dsbBtnNew;
	private boolean vsbBtnNew;

	private void actBtnNew(boolean dsb, boolean vsb) {
		this.dsbBtnNew = dsb;
		this.vsbBtnNew = vsb;
	}

	private List<VrfTblIn> lstIns;
	private int IInsId;
	private List<VrfTblInsMnc> lstInsMnc;
	private VrfTblIn ins;
	private VrfTblInsMnc insMnc;

	@EJB
	protected VrfSrvIns SIns;
	@EJB
	protected VrfSrvInsMnc SInsMnc;

	private void loadIns() {
		try {
			lstIns = new ArrayList<VrfTblIn>();
			IInsId = 0;
			lstIns = SIns.srcAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void chsIns() {
		try {
			ins = new VrfTblIn();
			ins = SIns.searchId(IInsId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addInsMnc() {
		try {
			insMnc.setVrfTblIn(ins);
			insMnc.setPmsTblMnc(mnc);
			insMnc.setIInsMncYr(IYrVldVle);
			insMnc.setIInsMncMth(IMthVldVle);
			insMnc.setIInsMncDay(IDayVldVle);
			lstInsMnc.add(insMnc);
			this.msg.msgInf("Agregado correctamente");
			this.actBtnAdd(true, true);
			this.actBtnNew(false, true);
			this.actIns(true, true, false);
			this.actInsMnc(true, true, false);
			this.actVldYr(true, true, false);
			this.actVldMth(true, true, false);
			this.actVldDay(true, true, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newInsMnc() {
		try {
			insMnc = new VrfTblInsMnc();
			ins = new VrfTblIn();
			IInsId = 0;
			this.loadIns();

			IYrVldVle = 0;
			IMthVldVle = 0;
			IDayVldVle = 0;
			this.loadVldYr();
			this.loadVldMth();
			this.actBtnAdd(false, true);
			this.actBtnNew(true, true);
			this.actVldYr(false, true, false);
			this.actVldMth(false, true, false);
			this.actVldDay(false, true, false);
			this.actIns(false, true, true);
			this.actInsMnc(false, true, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*******************************************************/

	private List<PmsTblMnc> lstMnc;
	@EJB
	protected PmsSrvMnc SMnc;

	private void newLstMnc() {
		lstMnc = new ArrayList<PmsTblMnc>();
	}

	private void loadMnc() {
		try {
			this.newLstMnc();
			lstMnc = SMnc.lstMncCnt(prl.getDpaTblCnt());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*******************************************************/

	private boolean dsbBtnNvo;
	private boolean vsbBtnNvo;

	private void actBtnNvo(boolean dsb, boolean vsb) {
		this.dsbBtnNvo = dsb;
		this.vsbBtnNvo = vsb;
	}

	private boolean dsbBtnSve;
	private boolean vsbBtnSve;

	private void actBtnSve(boolean dsb, boolean vsb) {
		this.dsbBtnSve = dsb;
		this.vsbBtnSve = vsb;
	}

	/*******************************************************/
	public boolean isVlrIndCls() {
		return vlrIndCls;
	}

	public void setVlrIndCls(boolean vlrIndCls) {
		this.vlrIndCls = vlrIndCls;
	}

	public boolean isDsbIndCls() {
		return dsbIndCls;
	}

	public void setDsbIndCls(boolean dsbIndCls) {
		this.dsbIndCls = dsbIndCls;
	}

	public boolean isVsbIndCls() {
		return vsbIndCls;
	}

	public void setVsbIndCls(boolean vsbIndCls) {
		this.vsbIndCls = vsbIndCls;
	}

	public boolean isRqrIndCls() {
		return rqrIndCls;
	}

	public void setRqrIndCls(boolean rqrIndCls) {
		this.rqrIndCls = rqrIndCls;
	}

	public boolean isDsbLv1() {
		return dsbLv1;
	}

	public void setDsbLv1(boolean dsbLv1) {
		this.dsbLv1 = dsbLv1;
	}

	public boolean isVsbLv1() {
		return vsbLv1;
	}

	public void setVsbLv1(boolean vsbLv1) {
		this.vsbLv1 = vsbLv1;
	}

	public boolean isRqrLv1() {
		return rqrLv1;
	}

	public void setRqrLv1(boolean rqrLv1) {
		this.rqrLv1 = rqrLv1;
	}

	public boolean isDsbLv2() {
		return dsbLv2;
	}

	public void setDsbLv2(boolean dsbLv2) {
		this.dsbLv2 = dsbLv2;
	}

	public boolean isVsbLv2() {
		return vsbLv2;
	}

	public void setVsbLv2(boolean vsbLv2) {
		this.vsbLv2 = vsbLv2;
	}

	public boolean isRqrLv2() {
		return rqrLv2;
	}

	public void setRqrLv2(boolean rqrLv2) {
		this.rqrLv2 = rqrLv2;
	}

	public IndTblLvl getLv1() {
		return lv1;
	}

	public void setLv1(IndTblLvl lv1) {
		this.lv1 = lv1;
	}

	public IndTblLvl getLv2() {
		return lv2;
	}

	public void setLv2(IndTblLvl lv2) {
		this.lv2 = lv2;
	}

	public int getILv1Cde() {
		return ILv1Cde;
	}

	public void setILv1Cde(int iLv1Cde) {
		ILv1Cde = iLv1Cde;
	}

	public int getILv2Cde() {
		return ILv2Cde;
	}

	public void setILv2Cde(int iLv2Cde) {
		ILv2Cde = iLv2Cde;
	}

	public boolean isVlrIndEsp() {
		return vlrIndEsp;
	}

	public void setVlrIndEsp(boolean vlrIndEsp) {
		this.vlrIndEsp = vlrIndEsp;
	}

	public boolean isDsbIndEsp() {
		return dsbIndEsp;
	}

	public void setDsbIndEsp(boolean dsbIndEsp) {
		this.dsbIndEsp = dsbIndEsp;
	}

	public boolean isVsbIndEsp() {
		return vsbIndEsp;
	}

	public void setVsbIndEsp(boolean vsbIndEsp) {
		this.vsbIndEsp = vsbIndEsp;
	}

	public boolean isRqrIndEsp() {
		return rqrIndEsp;
	}

	public void setRqrIndEsp(boolean rqrIndEsp) {
		this.rqrIndEsp = rqrIndEsp;
	}

	public int getIEspCde() {
		return IEspCde;
	}

	public void setIEspCde(int iEspCde) {
		IEspCde = iEspCde;
	}

	public boolean isDsbEsp() {
		return dsbEsp;
	}

	public void setDsbEsp(boolean dsbEsp) {
		this.dsbEsp = dsbEsp;
	}

	public boolean isVsbEsp() {
		return vsbEsp;
	}

	public void setVsbEsp(boolean vsbEsp) {
		this.vsbEsp = vsbEsp;
	}

	public boolean isRqrEsp() {
		return rqrEsp;
	}

	public void setRqrEsp(boolean rqrEsp) {
		this.rqrEsp = rqrEsp;
	}

	public int getIMainCde() {
		return IMainCde;
	}

	public void setIMainCde(int iMainCde) {
		IMainCde = iMainCde;
	}

	public boolean isDsbMain() {
		return dsbMain;
	}

	public void setDsbMain(boolean dsbMain) {
		this.dsbMain = dsbMain;
	}

	public boolean isVsbMain() {
		return vsbMain;
	}

	public void setVsbMain(boolean vsbMain) {
		this.vsbMain = vsbMain;
	}

	public boolean isRqrMain() {
		return rqrMain;
	}

	public void setRqrMain(boolean rqrMain) {
		this.rqrMain = rqrMain;
	}

	public List<IndTblMain> getLstMain() {
		return lstMain;
	}

	public void setLstMain(List<IndTblMain> lstMain) {
		this.lstMain = lstMain;
	}

	public IndTblMain getMain() {
		return main;
	}

	public void setMain(IndTblMain main) {
		this.main = main;
	}

	public String getTxtClrOrg() {
		return txtClrOrg;
	}

	public void setTxtClrOrg(String txtClrOrg) {
		this.txtClrOrg = txtClrOrg;
	}

	public String getTxtClrBle() {
		return txtClrBle;
	}

	public void setTxtClrBle(String txtClrBle) {
		this.txtClrBle = txtClrBle;
	}

	public String getTxtClrPnk() {
		return txtClrPnk;
	}

	public void setTxtClrPnk(String txtClrPnk) {
		this.txtClrPnk = txtClrPnk;
	}

	public String getTxtClrVlt() {
		return txtClrVlt;
	}

	public void setTxtClrVlt(String txtClrVlt) {
		this.txtClrVlt = txtClrVlt;
	}

	public String getTxtClrSlv() {
		return txtClrSlv;
	}

	public void setTxtClrSlv(String txtClrSlv) {
		this.txtClrSlv = txtClrSlv;
	}

	public PmsTblMnc getMnc() {
		return mnc;
	}

	public void setMnc(PmsTblMnc mnc) {
		this.mnc = mnc;
	}

	public boolean isVsbMainPnlVle() {
		return vsbMainPnlVle;
	}

	public void setVsbMainPnlVle(boolean vsbMainPnlVle) {
		this.vsbMainPnlVle = vsbMainPnlVle;
	}

	public boolean isVsbMainPnlOpt() {
		return vsbMainPnlOpt;
	}

	public void setVsbMainPnlOpt(boolean vsbMainPnlOpt) {
		this.vsbMainPnlOpt = vsbMainPnlOpt;
	}

	public boolean isDsbMainVle() {
		return dsbMainVle;
	}

	public void setDsbMainVle(boolean dsbMainVle) {
		this.dsbMainVle = dsbMainVle;
	}

	public boolean isRqrMainVle() {
		return rqrMainVle;
	}

	public void setRqrMainVle(boolean rqrMainVle) {
		this.rqrMainVle = rqrMainVle;
	}

	public boolean isVsbMainVle() {
		return vsbMainVle;
	}

	public void setVsbMainVle(boolean vsbMainVle) {
		this.vsbMainVle = vsbMainVle;
	}

	public boolean isVsbClr() {
		return vsbClr;
	}

	public void setVsbClr(boolean vsbClr) {
		this.vsbClr = vsbClr;
	}

	public boolean isDsbMainOpt() {
		return dsbMainOpt;
	}

	public void setDsbMainOpt(boolean dsbMainOpt) {
		this.dsbMainOpt = dsbMainOpt;
	}

	public boolean isRqrMainOpt() {
		return rqrMainOpt;
	}

	public void setRqrMainOpt(boolean rqrMainOpt) {
		this.rqrMainOpt = rqrMainOpt;
	}

	public boolean isVsbMainOpt() {
		return vsbMainOpt;
	}

	public void setVsbMainOpt(boolean vsbMainOpt) {
		this.vsbMainOpt = vsbMainOpt;
	}

	public boolean isVsbClrVlr() {
		return vsbClrVlr;
	}

	public void setVsbClrVlr(boolean vsbClrVlr) {
		this.vsbClrVlr = vsbClrVlr;
	}

	public String getLblMainVle() {
		return lblMainVle;
	}

	public void setLblMainVle(String lblMainVle) {
		this.lblMainVle = lblMainVle;
	}

	public boolean isVsbMainLbl() {
		return vsbMainLbl;
	}

	public void setVsbMainLbl(boolean vsbMainLbl) {
		this.vsbMainLbl = vsbMainLbl;
	}

	public List<Ctg> getLstCtg() {
		return lstCtg;
	}

	public void setLstCtg(List<Ctg> lstCtg) {
		this.lstCtg = lstCtg;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getVlrMnc() {
		return vlrMnc;
	}

	public void setVlrMnc(double vlrMnc) {
		this.vlrMnc = vlrMnc;
	}

	public boolean isDsbYr() {
		return dsbYr;
	}

	public void setDsbYr(boolean dsbYr) {
		this.dsbYr = dsbYr;
	}

	public boolean isRqrYr() {
		return rqrYr;
	}

	public void setRqrYr(boolean rqrYr) {
		this.rqrYr = rqrYr;
	}

	public boolean isVsbYr() {
		return vsbYr;
	}

	public void setVsbYr(boolean vsbYr) {
		this.vsbYr = vsbYr;
	}

	public boolean isDsbMth() {
		return dsbMth;
	}

	public void setDsbMth(boolean dsbMth) {
		this.dsbMth = dsbMth;
	}

	public boolean isRqrMth() {
		return rqrMth;
	}

	public void setRqrMth(boolean rqrMth) {
		this.rqrMth = rqrMth;
	}

	public boolean isVsbMth() {
		return vsbMth;
	}

	public void setVsbMth(boolean vsbMth) {
		this.vsbMth = vsbMth;
	}

	public boolean isDsbDay() {
		return dsbDay;
	}

	public void setDsbDay(boolean dsbDay) {
		this.dsbDay = dsbDay;
	}

	public boolean isRqrDay() {
		return rqrDay;
	}

	public void setRqrDay(boolean rqrDay) {
		this.rqrDay = rqrDay;
	}

	public boolean isVsbDay() {
		return vsbDay;
	}

	public void setVsbDay(boolean vsbDay) {
		this.vsbDay = vsbDay;
	}

	public int getIYrVle() {
		return IYrVle;
	}

	public void setIYrVle(int iYrVle) {
		IYrVle = iYrVle;
	}

	public int getIMthVle() {
		return IMthVle;
	}

	public void setIMthVle(int iMthVle) {
		IMthVle = iMthVle;
	}

	public int getIDayVle() {
		return IDayVle;
	}

	public void setIDayVle(int iDayVle) {
		IDayVle = iDayVle;
	}

	public List<DteTblYr> getLstYr() {
		return lstYr;
	}

	public void setLstYr(List<DteTblYr> lstYr) {
		this.lstYr = lstYr;
	}

	public List<DteTblMnt> getLstMth() {
		return lstMth;
	}

	public void setLstMth(List<DteTblMnt> lstMth) {
		this.lstMth = lstMth;
	}

	public List<Integer> getLstDay() {
		return lstDay;
	}

	public void setLstDay(List<Integer> lstDay) {
		this.lstDay = lstDay;
	}

	public boolean isDsbDte() {
		return dsbDte;
	}

	public void setDsbDte(boolean dsbDte) {
		this.dsbDte = dsbDte;
	}

	public boolean isRqrDte() {
		return rqrDte;
	}

	public void setRqrDte(boolean rqrDte) {
		this.rqrDte = rqrDte;
	}

	public boolean isVsbDte() {
		return vsbDte;
	}

	public void setVsbDte(boolean vsbDte) {
		this.vsbDte = vsbDte;
	}

	public boolean isVleDte() {
		return vleDte;
	}

	public void setVleDte(boolean vleDte) {
		this.vleDte = vleDte;
	}

	public boolean isDsbVldYr() {
		return dsbVldYr;
	}

	public void setDsbVldYr(boolean dsbVldYr) {
		this.dsbVldYr = dsbVldYr;
	}

	public boolean isRqrVldYr() {
		return rqrVldYr;
	}

	public void setRqrVldYr(boolean rqrVldYr) {
		this.rqrVldYr = rqrVldYr;
	}

	public boolean isVsbVldYr() {
		return vsbVldYr;
	}

	public void setVsbVldYr(boolean vsbVldYr) {
		this.vsbVldYr = vsbVldYr;
	}

	public boolean isDsbVldMth() {
		return dsbVldMth;
	}

	public void setDsbVldMth(boolean dsbVldMth) {
		this.dsbVldMth = dsbVldMth;
	}

	public boolean isRqrVldMth() {
		return rqrVldMth;
	}

	public void setRqrVldMth(boolean rqrVldMth) {
		this.rqrVldMth = rqrVldMth;
	}

	public boolean isVsbVldMth() {
		return vsbVldMth;
	}

	public void setVsbVldMth(boolean vsbVldMth) {
		this.vsbVldMth = vsbVldMth;
	}

	public boolean isDsbVldDay() {
		return dsbVldDay;
	}

	public void setDsbVldDay(boolean dsbVldDay) {
		this.dsbVldDay = dsbVldDay;
	}

	public boolean isRqrVldDay() {
		return rqrVldDay;
	}

	public void setRqrVldDay(boolean rqrVldDay) {
		this.rqrVldDay = rqrVldDay;
	}

	public boolean isVsbVldDay() {
		return vsbVldDay;
	}

	public void setVsbVldDay(boolean vsbVldDay) {
		this.vsbVldDay = vsbVldDay;
	}

	public int getIYrVldVle() {
		return IYrVldVle;
	}

	public void setIYrVldVle(int iYrVldVle) {
		IYrVldVle = iYrVldVle;
	}

	public int getIMthVldVle() {
		return IMthVldVle;
	}

	public void setIMthVldVle(int iMthVldVle) {
		IMthVldVle = iMthVldVle;
	}

	public int getIDayVldVle() {
		return IDayVldVle;
	}

	public void setIDayVldVle(int iDayVldVle) {
		IDayVldVle = iDayVldVle;
	}

	public boolean isDsbVldDwn() {
		return dsbVldDwn;
	}

	public void setDsbVldDwn(boolean dsbVldDwn) {
		this.dsbVldDwn = dsbVldDwn;
	}

	public boolean isRqrVldDwn() {
		return rqrVldDwn;
	}

	public void setRqrVldDwn(boolean rqrVldDwn) {
		this.rqrVldDwn = rqrVldDwn;
	}

	public boolean isVsbVldDwn() {
		return vsbVldDwn;
	}

	public void setVsbVldDwn(boolean vsbVldDwn) {
		this.vsbVldDwn = vsbVldDwn;
	}

	public List<DteTblYr> getLstVldYr() {
		return lstVldYr;
	}

	public void setLstVldYr(List<DteTblYr> lstVldYr) {
		this.lstVldYr = lstVldYr;
	}

	public List<DteTblMnt> getLstVldMth() {
		return lstVldMth;
	}

	public void setLstVldMth(List<DteTblMnt> lstVldMth) {
		this.lstVldMth = lstVldMth;
	}

	public List<Integer> getLstVldDay() {
		return lstVldDay;
	}

	public void setLstVldDay(List<Integer> lstVldDay) {
		this.lstVldDay = lstVldDay;
	}

	public String getMainPth() {
		return mainPth;
	}

	public boolean isDsbIns() {
		return dsbIns;
	}

	public void setDsbIns(boolean dsbIns) {
		this.dsbIns = dsbIns;
	}

	public boolean isRqrIns() {
		return rqrIns;
	}

	public void setRqrIns(boolean rqrIns) {
		this.rqrIns = rqrIns;
	}

	public boolean isVsbIns() {
		return vsbIns;
	}

	public void setVsbIns(boolean vsbIns) {
		this.vsbIns = vsbIns;
	}

	public boolean isDsbInsMnc() {
		return dsbInsMnc;
	}

	public void setDsbInsMnc(boolean dsbInsMnc) {
		this.dsbInsMnc = dsbInsMnc;
	}

	public boolean isRqrInsMnc() {
		return rqrInsMnc;
	}

	public void setRqrInsMnc(boolean rqrInsMnc) {
		this.rqrInsMnc = rqrInsMnc;
	}

	public boolean isVsbInsMnc() {
		return vsbInsMnc;
	}

	public void setVsbInsMnc(boolean vsbInsMnc) {
		this.vsbInsMnc = vsbInsMnc;
	}

	public List<VrfTblIn> getLstIns() {
		return lstIns;
	}

	public void setLstIns(List<VrfTblIn> lstIns) {
		this.lstIns = lstIns;
	}

	public int getIInsId() {
		return IInsId;
	}

	public void setIInsId(int iInsId) {
		IInsId = iInsId;
	}

	public List<VrfTblInsMnc> getLstInsMnc() {
		return lstInsMnc;
	}

	public void setLstInsMnc(List<VrfTblInsMnc> lstInsMnc) {
		this.lstInsMnc = lstInsMnc;
	}

	public VrfTblIn getIns() {
		return ins;
	}

	public void setIns(VrfTblIn ins) {
		this.ins = ins;
	}

	public VrfTblInsMnc getInsMnc() {
		return insMnc;
	}

	public void setInsMnc(VrfTblInsMnc insMnc) {
		this.insMnc = insMnc;
	}

	public void setMainPth(String mainPth) {
		this.mainPth = mainPth;
	}

	public boolean isDsbBtnAdd() {
		return dsbBtnAdd;
	}

	public void setDsbBtnAdd(boolean dsbBtnAdd) {
		this.dsbBtnAdd = dsbBtnAdd;
	}

	public boolean isVsbBtnAdd() {
		return vsbBtnAdd;
	}

	public void setVsbBtnAdd(boolean vsbBtnAdd) {
		this.vsbBtnAdd = vsbBtnAdd;
	}

	public boolean isDsbBtnNew() {
		return dsbBtnNew;
	}

	public void setDsbBtnNew(boolean dsbBtnNew) {
		this.dsbBtnNew = dsbBtnNew;
	}

	public boolean isVsbBtnNew() {
		return vsbBtnNew;
	}

	public void setVsbBtnNew(boolean vsbBtnNew) {
		this.vsbBtnNew = vsbBtnNew;
	}

	public boolean isDsbBtnVld() {
		return dsbBtnVld;
	}

	public void setDsbBtnVld(boolean dsbBtnVld) {
		this.dsbBtnVld = dsbBtnVld;
	}

	public boolean isVsbBtnVld() {
		return vsbBtnVld;
	}

	public void setVsbBtnVld(boolean vsbBtnVld) {
		this.vsbBtnVld = vsbBtnVld;
	}

	public List<PmsTblMnc> getLstMnc() {
		return lstMnc;
	}

	public void setLstMnc(List<PmsTblMnc> lstMnc) {
		this.lstMnc = lstMnc;
	}

	public boolean isDsbBtnSve() {
		return dsbBtnSve;
	}

	public void setDsbBtnSve(boolean dsbBtnSve) {
		this.dsbBtnSve = dsbBtnSve;
	}

	public boolean isVsbBtnSve() {
		return vsbBtnSve;
	}

	public void setVsbBtnSve(boolean vsbBtnSve) {
		this.vsbBtnSve = vsbBtnSve;
	}

	public boolean isDsbBtnNvo() {
		return dsbBtnNvo;
	}

	public void setDsbBtnNvo(boolean dsbBtnNvo) {
		this.dsbBtnNvo = dsbBtnNvo;
	}

	public boolean isVsbBtnNvo() {
		return vsbBtnNvo;
	}

	public void setVsbBtnNvo(boolean vsbBtnNvo) {
		this.vsbBtnNvo = vsbBtnNvo;
	}

	public boolean isVsbTbl() {
		return vsbTbl;
	}

	public void setVsbTbl(boolean vsbTbl) {
		this.vsbTbl = vsbTbl;
	}

	public boolean isVsbDta() {
		return vsbDta;
	}

	public void setVsbDta(boolean vsbDta) {
		this.vsbDta = vsbDta;
	}

}
