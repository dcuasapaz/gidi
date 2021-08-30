package ec.gob.msp.pms.ctl;

import java.io.File;
import java.io.FileInputStream;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.apache.commons.io.FilenameUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;

import org.primefaces.model.UploadedFile;

import ec.gob.msp.pms.cmm.Code;
import ec.gob.msp.pms.cmm.Default;
import ec.gob.msp.pms.cmm.Message;
import ec.gob.msp.pms.cmm.Method;
import ec.gob.msp.pms.ent.DpaTblCnt;
import ec.gob.msp.pms.ent.DtaTblPr;
import ec.gob.msp.pms.ent.PmsTblOpt;
import ec.gob.msp.pms.ent.ScrTblPrsRol;
import ec.gob.msp.pms.itf.DbIftGnr;
import ec.gob.msp.pms.srv.DpaSrvCnt;
import ec.gob.msp.pms.srv.DpaSrvOpt;
import ec.gob.msp.pms.srv.HstSrvCntPrsRol;
import ec.gob.msp.pms.srv.PmsSrvOpt;
import ec.gob.msp.pms.srv.ScrSrvPrsRol;

@ManagedBean
@ViewScoped
public class DpaCtlCnt implements DbIftGnr {

	protected Code cde;
	protected Default dfl;
	protected Message msg;
	protected Method mth;

	public DpaCtlCnt() {
		cde = new Code();
		dfl = new Default();
		msg = new Message();
		mth = new Method();
		cnt = new DpaTblCnt();
		stt = new PmsTblOpt();
		sss = new ScrCtlSss();
	}

	private void cptInit() {

		this.actSpcFrm(true, false);
		this.actBtnAdd(false, true);
		this.actBtnSve(true, true);
		this.actBtnUpd(true, true);
		this.actBtnEdt(false, true);
		this.actBtnDlt(false, true);
		this.actBtnRfr(false, true);
		this.actBtnPdf(true, true);
		this.actBtnCsv(true, true);
		this.actCntBPrv(true, true, false);
		this.actCntFle(true, true, false);
		this.actCnt(true, true, false);
		this.actCntPrv(true, true, false);
		this.actCntDteYr(true, true, false);
		this.actCntDteMth(true, true, false);
		this.actCntDteDay(true, true, false);
		this.actCntObs(true, true, false);
		this.actCntStt(true, true, false);
		this.actCntBChgCmpTbl(true, true, false);
	}

	@PostConstruct
	public void init() {
		this.loadCnt();
		this.cptInit();
		this.loadPrl();
	}

	@Override
	public void cptAdd() {
		this.actSpcFrm(false, true);
		this.actBtnAdd(true, true);
		this.actBtnSve(false, true);
		this.actBtnUpd(true, true);
		this.actBtnEdt(true, true);
		this.actBtnDlt(true, true);
		this.actBtnRfr(false, true);
		this.actCntBPrv(false, true, false);
		this.actCnt(false, true, true);
	}

	@Override
	public void add() {
		this.cptAdd();
		this.IPrvCde = 0;
		this.ICntDteYr = 0;
		this.ICntDteMth = 0;
		this.ICntDteDay = 0;
		this.ISttCde = 0;
		stt = new PmsTblOpt();
		this.loadLstCnt();
		cnt = new DpaTblCnt();
		this.BPrvSlc = false;
	}

	@Override
	public void cptEdt() {
		this.actSpcFrm(false, true);
		this.actBtnAdd(true, true);
		this.actBtnSve(true, true);
		this.actBtnUpd(false, true);
		this.actBtnEdt(true, true);
		this.actBtnDlt(true, true);
		this.actBtnRfr(false, true);
		this.actCnt(true, true, false);
		this.actCntDteYr(false, true, true);
		this.actCntDteMth(false, true, true);
		this.actCntDteDay(false, true, true);
		this.actCntStt(false, true, true);
		this.actCntObs(false, true, false);
		this.actCntBChgCmpTbl(false, true, false);
	}

	@Override
	public void edt() {
		try {
			this.cptEdt();
			this.IPrvCde = cnt.getIPrvCde();
			this.loadLstCnt(IPrvCde, cnt.getISttCde());
			this.ICntCde = cnt.getICntCde();
			this.ICntDteYr = cnt.getICntDteStrPrcYr();
			this.ICntDteMth = cnt.getICntDteStrPrcMth();
			this.ICntDteDay = cnt.getICntDteStrPrcDay();
			this.ISttCde = cnt.getISttCde();
			stt = new PmsTblOpt();
			stt = SPmsOpt.searchId(cnt.getISttCde());
			this.BCntChgCmpTbl = false;
		} catch (Exception e) {

		}

	}

	@Override
	public void cptSve() {
		this.init();
	}

	@Override
	public void sve() {
		try {
			if (SDpaCnt.sve(cnt, SCntDcm, ISttCde, ICntDteYr, ICntDteMth, ICntDteDay)) {
				if (SHstCntPrsRol.sve(cnt, this.loadPrl(), cde.insert(),
						mth.PrintCntDtl(cnt, SPmsOpt.searchId(cnt.getISttCde())))) {
					this.msg.msgInf(this.msg.SMsgSveOk);
				} else {
					this.msg.msgErr(this.msg.SMsgSveErr);
				}
			} else {
				this.msg.msgErr(this.msg.SMsgSveErr);
			}
			this.cptSve();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void cptUpd() {
		this.init();
	}

	@Override
	public void upd() {
		try {
			if (SDpaCnt.upd(cnt, SCntDcm, ISttCde, ICntDteYr, ICntDteMth, ICntDteDay)) {
				if (SHstCntPrsRol.sve(cnt, this.loadPrl(), cde.update(),
						mth.PrintCntDtl(cnt, SPmsOpt.searchId(cnt.getISttCde())))) {
					this.msg.msgInf(this.msg.SMsgUpdOk);
				} else {
					this.msg.msgErr(this.msg.SMsgUpdErr);
				}
			} else {
				this.msg.msgErr(this.msg.SMsgSveErr);
			}
			this.cptUpd();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void cptDlt() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dlt() {
		// TODO Auto-generated method stub

	}

	/*******************************************************/
	protected ScrCtlSss sss;

	public ScrTblPrsRol loadPrl() {
		try {
			return sss.getPrl();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
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

	/*******************************************************/
	@EJB
	protected DpaSrvOpt SDpaOpt;

	private boolean BPrvSlc;
	private boolean dsbCntPrv;
	private boolean vsbCntPrv;
	private boolean rqrCntPrv;
	private int IPrvCde;

	private void actCntPrv(boolean dsb, boolean vsb, boolean rqr) {
		dsbCntPrv = dsb;
		vsbCntPrv = vsb;
		rqrCntPrv = rqr;
	}

	public void slcPrv() {
		try {
			if (BPrvSlc != false) {
				this.actCntPrv(false, true, true);
			} else {
				this.actCntPrv(true, true, false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void chsPrv() {
		try {
			this.loadLstCnt(IPrvCde, cde.IPmsCntSttIna());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*******************************************************/
	@EJB
	protected HstSrvCntPrsRol SHstCntPrsRol;
	@EJB
	protected DpaSrvCnt SDpaCnt;
	private List<DpaTblCnt> lstCnt;
	private List<DpaTblCnt> lstCntSlc;
	private DpaTblCnt cnt;
	protected String DCntDteAdh;
	protected String SCntDcm;

	private int ICntCde;
	private UploadedFile FCntDcm;
	private boolean dsbCntBPrv;
	private boolean vsbCntBPrv;
	private boolean rqrCntBPrv;
	private boolean dsbCnt;
	private boolean vsbCnt;
	private boolean rqrCnt;
	private boolean dsbCntFle;
	private boolean vsbCntFle;
	private boolean rqrCntFle;
	private boolean dsbCntDteYr;
	private boolean vsbCntDteYr;
	private boolean rqrCntDteYr;
	private boolean dsbCntDteMth;
	private boolean vsbCntDteMth;
	private boolean rqrCntDteMth;
	private boolean dsbCntDteDay;
	private boolean vsbCntDteDay;
	private boolean rqrCntDteDay;
	private boolean dsbCntObs;
	private boolean vsbCntObs;
	private boolean rqrCntObs;
	private int ICntDteYr;
	private int ICntDteMth;
	private int ICntDteDay;

	private boolean BCntChgCmpTbl;
	private boolean dsbCntBChgCmpTbl;
	private boolean vsbCntBChgCmpTbl;
	private boolean rqrCntBChgCmpTbl;

	private void actCntBChgCmpTbl(boolean dsb, boolean vsb, boolean rqr) {
		dsbCntBChgCmpTbl = dsb;
		vsbCntBChgCmpTbl = vsb;
		rqrCntBChgCmpTbl = rqr;
	}

	private void actCntBPrv(boolean dsb, boolean vsb, boolean rqr) {
		dsbCntBPrv = dsb;
		vsbCntBPrv = vsb;
		rqrCntBPrv = rqr;
	}

	private void actCntFle(boolean dsb, boolean vsb, boolean rqr) {
		dsbCntFle = dsb;
		vsbCntFle = vsb;
		rqrCntFle = rqr;
	}

	private void actCnt(boolean dsb, boolean vsb, boolean rqr) {
		dsbCnt = dsb;
		vsbCnt = vsb;
		rqrCnt = rqr;
	}

	private void actCntDteYr(boolean dsb, boolean vsb, boolean rqr) {
		dsbCntDteYr = dsb;
		vsbCntDteYr = vsb;
		rqrCntDteYr = rqr;
	}

	private void actCntDteMth(boolean dsb, boolean vsb, boolean rqr) {
		dsbCntDteMth = dsb;
		vsbCntDteMth = vsb;
		rqrCntDteMth = rqr;
	}

	private void actCntDteDay(boolean dsb, boolean vsb, boolean rqr) {
		dsbCntDteDay = dsb;
		vsbCntDteDay = vsb;
		rqrCntDteDay = rqr;
	}

	private void actCntObs(boolean dsb, boolean vsb, boolean rqr) {
		dsbCntObs = dsb;
		vsbCntObs = vsb;
		rqrCntObs = rqr;
	}

	private void newCnt() {
		lstCnt = new ArrayList<DpaTblCnt>();
	}

	private void newCntSlc() {
		ICntCde = 0;
		lstCntSlc = new ArrayList<DpaTblCnt>();
	}

	private void loadCnt() {
		try {
			this.newCnt();
			lstCnt = SDpaCnt.lstCnt(cde.IPmsCntSttAct());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loadLstCnt() {
		try {
			this.newCntSlc();
			lstCntSlc = SDpaCnt.lstCnt(cde.IPmsCntSttIna());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loadLstCnt(int IPrvCde) {
		try {
			this.newCntSlc();
			lstCntSlc = SDpaCnt.lstCntPrv(IPrvCde);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loadLstCnt(int IPrvCde, int ISttCde) {
		try {
			this.newCntSlc();
			lstCntSlc = SDpaCnt.lstCntPrv(IPrvCde, ISttCde);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void chsCnt() {
		try {
			cnt = SDpaCnt.searchId(ICntCde);
			IPrvCde = cnt.getIPrvCde();
			this.actCntDteYr(false, true, true);
			this.actCntDteMth(false, true, true);
			this.actCntDteDay(false, true, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void handleFileUpload(FileUploadEvent event) {
		try {
			if (BCntChgCmpTbl == false) {
				// Creando directorio del municipio
				File pth = new File(dfl.flePthMain() + this.mth.SCdeCnt(cnt.getICntCde()));
				if (!pth.exists()) {
					if (pth.mkdirs()) {
						System.out.println("PMS: Directorio creado");
					} else {
						System.out.println("PMS: Error al crear directorio");
					}
				}
				String pthMnc = dfl.flePthMain() + this.mth.SCdeCnt(cnt.getICntCde()) + "/";
				// Copia del archivo cargado
				FCntDcm = event.getFile();
				// Ruta donde se guardara el archivo
				String ext = FilenameUtils.getExtension(FCntDcm.getFileName());
				// Nombre del archivo
				String fleNme = dfl.flePrf() + dfl.fleCpb() + this.mth.SCdeCnt(cnt.getICntCde()) + "_" + DCntDteAdh;
				// Crear archivo vacio
				File fle = new File(pthMnc + fleNme + "." + ext);
				if (!fle.exists()) {
					fle.createNewFile();
				}
				// Ruta del archivo para guardar en tabla
				SCntDcm = pthMnc + fleNme + "." + ext;
				// Realizar una copia del archivo subido
				Path file = fle.toPath();
				try (InputStream input = FCntDcm.getInputstream()) {
					Files.copy(input, file, StandardCopyOption.REPLACE_EXISTING);
				}
				this.msg.msgInf("El archivo a sido cargado correctamente");
				this.actCntFle(true, true, false);
				this.actCntStt(false, true, true);
				this.actCntObs(false, true, false);
			} else {
				File pth = new File(dfl.flePthMain() + this.mth.SCdeCnt(cnt.getICntCde()));
				if (pth.exists()) {
					String pthMnc = dfl.flePthMain() + this.mth.SCdeCnt(cnt.getICntCde()) + "/";
					// Copia del archivo cargado
					FCntDcm = event.getFile();
					// Ruta donde se guardara el archivo
					String ext = FilenameUtils.getExtension(FCntDcm.getFileName());
					// Nombre del archivo
					String fleNme = dfl.flePrf() + dfl.fleCpb() + this.mth.SCdeCnt(cnt.getICntCde()) + "_" + DCntDteAdh;
					// Crear archivo vacio
					File fle = new File(pthMnc + fleNme + "." + ext);
					if (!fle.exists()) {
						fle.createNewFile();
					}
					// Ruta del archivo para guardar en tabla
					SCntDcm = pthMnc + fleNme + "." + ext;
					// Realizar una copia del archivo subido
					Path file = fle.toPath();
					try (InputStream input = FCntDcm.getInputstream()) {
						Files.copy(input, file, StandardCopyOption.REPLACE_EXISTING);
					}
					this.msg.msgInf("El archivo a sido cargado correctamente");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void chsYr() {
		ICntDteMth = 0;
		ICntDteDay = 0;
	}

	public void chsMth() {
		ICntDteDay = 0;
	}

	public void chsDay() {
		DCntDteAdh = ICntDteYr + this.mth.SCdeMth(ICntDteMth) + this.mth.SCdeDay(ICntDteDay);
		this.actCntStt(false, true, true);
	}

	private DefaultStreamedContent fle;

	public void download(String pth) {
		try {
			File file = new File(pth);
			InputStream input = new FileInputStream(file);
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			this.setFle(new DefaultStreamedContent(input, externalContext.getMimeType(file.getName()), file.getName()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void slcChgCmpTbl() {
		try {
			if (BCntChgCmpTbl != false) {
				this.actCntFle(false, true, true);
			} else {
				this.actCntFle(true, true, false);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*******************************************************/
	@EJB
	protected ScrSrvPrsRol SPrsRol;

	public String rtrCnt(DtaTblPr prs) {
		try {
			String vleCnt = "";
			List<ScrTblPrsRol> lstPrsRolAux = new ArrayList<ScrTblPrsRol>();
			lstPrsRolAux = SPrsRol.lstRol(prs);
			Iterator<ScrTblPrsRol> itPrsRol = lstPrsRolAux.iterator();
			while (itPrsRol.hasNext()) {
				ScrTblPrsRol prsRolAux = itPrsRol.next();
				DpaTblCnt cntAux = prsRolAux.getDpaTblCnt();
				vleCnt = vleCnt + "<div class=\" tbl-etq \">" + "<div class=\\\" tbl-etq-text \\\"> - "
						+ cntAux.getSCntNme() + "</div>" + "</div>";
			}
			return vleCnt;
		} catch (Exception e) {
			e.printStackTrace();
			return dfl.SVleNull();
		}
	}

	/*******************************************************/
	@EJB
	protected PmsSrvOpt SPmsOpt;
	private PmsTblOpt stt;
	private int ISttCde;
	private boolean dsbCntStt;
	private boolean vsbCntStt;
	private boolean rqrCntStt;

	private void actCntStt(boolean dsb, boolean vsb, boolean rqr) {
		dsbCntStt = dsb;
		vsbCntStt = vsb;
		rqrCntStt = rqr;
	}

	public void chsStt() {
		try {
			stt = new PmsTblOpt();
			stt = SPmsOpt.searchId(ISttCde);
			this.actCntFle(false, true, true);
			this.actCntObs(false, true, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*******************************************************/

	public List<DpaTblCnt> getLstCnt() {
		return lstCnt;
	}

	public void setLstCnt(List<DpaTblCnt> lstCnt) {
		this.lstCnt = lstCnt;
	}

	public DpaTblCnt getCnt() {
		return cnt;
	}

	public void setCnt(DpaTblCnt cnt) {
		this.cnt = cnt;
	}

	public boolean isBPrvSlc() {
		return BPrvSlc;
	}

	public void setBPrvSlc(boolean bPrvSlc) {
		BPrvSlc = bPrvSlc;
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

	public int getIPrvCde() {
		return IPrvCde;
	}

	public void setIPrvCde(int iPrvCde) {
		IPrvCde = iPrvCde;
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

	public int getICntCde() {
		return ICntCde;
	}

	public void setICntCde(int iCntCde) {
		ICntCde = iCntCde;
	}

	public UploadedFile getFCntDcm() {
		return FCntDcm;
	}

	public void setFCntDcm(UploadedFile fCntDcm) {
		FCntDcm = fCntDcm;
	}

	public boolean isDsbCntDteYr() {
		return dsbCntDteYr;
	}

	public void setDsbCntDteYr(boolean dsbCntDteYr) {
		this.dsbCntDteYr = dsbCntDteYr;
	}

	public boolean isVsbCntDteYr() {
		return vsbCntDteYr;
	}

	public void setVsbCntDteYr(boolean vsbCntDteYr) {
		this.vsbCntDteYr = vsbCntDteYr;
	}

	public boolean isRqrCntDteYr() {
		return rqrCntDteYr;
	}

	public void setRqrCntDteYr(boolean rqrCntDteYr) {
		this.rqrCntDteYr = rqrCntDteYr;
	}

	public boolean isDsbCntDteMth() {
		return dsbCntDteMth;
	}

	public void setDsbCntDteMth(boolean dsbCntDteMth) {
		this.dsbCntDteMth = dsbCntDteMth;
	}

	public boolean isVsbCntDteMth() {
		return vsbCntDteMth;
	}

	public void setVsbCntDteMth(boolean vsbCntDteMth) {
		this.vsbCntDteMth = vsbCntDteMth;
	}

	public boolean isRqrCntDteMth() {
		return rqrCntDteMth;
	}

	public void setRqrCntDteMth(boolean rqrCntDteMth) {
		this.rqrCntDteMth = rqrCntDteMth;
	}

	public boolean isDsbCntDteDay() {
		return dsbCntDteDay;
	}

	public void setDsbCntDteDay(boolean dsbCntDteDay) {
		this.dsbCntDteDay = dsbCntDteDay;
	}

	public boolean isVsbCntDteDay() {
		return vsbCntDteDay;
	}

	public void setVsbCntDteDay(boolean vsbCntDteDay) {
		this.vsbCntDteDay = vsbCntDteDay;
	}

	public boolean isRqrCntDteDay() {
		return rqrCntDteDay;
	}

	public void setRqrCntDteDay(boolean rqrCntDteDay) {
		this.rqrCntDteDay = rqrCntDteDay;
	}

	public int getICntDteYr() {
		return ICntDteYr;
	}

	public void setICntDteYr(int iCntDteYr) {
		ICntDteYr = iCntDteYr;
	}

	public int getICntDteMth() {
		return ICntDteMth;
	}

	public void setICntDteMth(int iCntDteMth) {
		ICntDteMth = iCntDteMth;
	}

	public int getICntDteDay() {
		return ICntDteDay;
	}

	public void setICntDteDay(int iCntDteDay) {
		ICntDteDay = iCntDteDay;
	}

	public PmsTblOpt getStt() {
		return stt;
	}

	public void setStt(PmsTblOpt stt) {
		this.stt = stt;
	}

	public int getISttCde() {
		return ISttCde;
	}

	public void setISttCde(int iSttCde) {
		ISttCde = iSttCde;
	}

	public boolean isDsbCntStt() {
		return dsbCntStt;
	}

	public void setDsbCntStt(boolean dsbCntStt) {
		this.dsbCntStt = dsbCntStt;
	}

	public boolean isVsbCntStt() {
		return vsbCntStt;
	}

	public void setVsbCntStt(boolean vsbCntStt) {
		this.vsbCntStt = vsbCntStt;
	}

	public boolean isRqrCntStt() {
		return rqrCntStt;
	}

	public void setRqrCntStt(boolean rqrCntStt) {
		this.rqrCntStt = rqrCntStt;
	}

	public boolean isDsbCntObs() {
		return dsbCntObs;
	}

	public void setDsbCntObs(boolean dsbCntObs) {
		this.dsbCntObs = dsbCntObs;
	}

	public boolean isVsbCntObs() {
		return vsbCntObs;
	}

	public void setVsbCntObs(boolean vsbCntObs) {
		this.vsbCntObs = vsbCntObs;
	}

	public boolean isRqrCntObs() {
		return rqrCntObs;
	}

	public void setRqrCntObs(boolean rqrCntObs) {
		this.rqrCntObs = rqrCntObs;
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

	public boolean isDsbCntBPrv() {
		return dsbCntBPrv;
	}

	public void setDsbCntBPrv(boolean dsbCntBPrv) {
		this.dsbCntBPrv = dsbCntBPrv;
	}

	public boolean isVsbCntBPrv() {
		return vsbCntBPrv;
	}

	public void setVsbCntBPrv(boolean vsbCntBPrv) {
		this.vsbCntBPrv = vsbCntBPrv;
	}

	public boolean ChgCmpTbl() {
		return rqrCntBPrv;
	}

	public void setRqrCntBPrv(boolean rqrCntBPrv) {
		this.rqrCntBPrv = rqrCntBPrv;
	}

	public boolean isDsbCntFle() {
		return dsbCntFle;
	}

	public void setDsbCntFle(boolean dsbCntFle) {
		this.dsbCntFle = dsbCntFle;
	}

	public boolean isVsbCntFle() {
		return vsbCntFle;
	}

	public void setVsbCntFle(boolean vsbCntFle) {
		this.vsbCntFle = vsbCntFle;
	}

	public boolean isRqrCntFle() {
		return rqrCntFle;
	}

	public void setRqrCntFle(boolean rqrCntFle) {
		this.rqrCntFle = rqrCntFle;
	}

	public List<DpaTblCnt> getLstCntSlc() {
		return lstCntSlc;
	}

	public void setLstCntSlc(List<DpaTblCnt> lstCntSlc) {
		this.lstCntSlc = lstCntSlc;
	}

	public DefaultStreamedContent getFle() {
		return fle;
	}

	public void setFle(DefaultStreamedContent fle) {
		this.fle = fle;
	}

	public boolean isBCntChgCmpTbl() {
		return BCntChgCmpTbl;
	}

	public void setBCntChgCmpTbl(boolean bCntChgCmpTbl) {
		BCntChgCmpTbl = bCntChgCmpTbl;
	}

	public boolean isDsbCntBChgCmpTbl() {
		return dsbCntBChgCmpTbl;
	}

	public void setDsbCntBChgCmpTbl(boolean dsbCntBChgCmpTbl) {
		this.dsbCntBChgCmpTbl = dsbCntBChgCmpTbl;
	}

	public boolean isRqrCntBChgCmpTbl() {
		return rqrCntBChgCmpTbl;
	}

	public void setRqrCntBChgCmpTbl(boolean rqrCntBChgCmpTbl) {
		this.rqrCntBChgCmpTbl = rqrCntBChgCmpTbl;
	}

	public boolean isRqrCntBPrv() {
		return rqrCntBPrv;
	}

	public boolean isVsbCntBChgCmpTbl() {
		return vsbCntBChgCmpTbl;
	}

	public void setVsbCntBChgCmpTbl(boolean vsbCntBChgCmpTbl) {
		this.vsbCntBChgCmpTbl = vsbCntBChgCmpTbl;
	}

}
