package ec.gob.inspi.gidi.sit.ctl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import ec.gob.inspi.gidi.sit.cmm.Code;
import ec.gob.inspi.gidi.sit.cmm.Default;
import ec.gob.inspi.gidi.sit.cmm.Log;
import ec.gob.inspi.gidi.sit.cmm.Message;
import ec.gob.inspi.gidi.sit.ent.DtaTblPr;
import ec.gob.inspi.gidi.sit.ent.ScrTblPrsRol;
import ec.gob.inspi.gidi.sit.ent.WebTblMnu;
import ec.gob.inspi.gidi.sit.itf.ScrItfLgn;
import ec.gob.inspi.gidi.sit.srv.DtaSrvPrs;
import ec.gob.inspi.gidi.sit.srv.ScrSrvPrsRol;
import ec.gob.inspi.gidi.sit.srv.ScrSrvSss;
import ec.gob.inspi.gidi.sit.srv.WebSrvMnu;

@ManagedBean
@ViewScoped
public class ScrCtlLgn implements ScrItfLgn {

	protected Code cde;
	protected Log log;
	protected Message msg;
	protected Default dfl;

	private HttpSession session;

	public ScrCtlLgn() {
		log = new Log();
		msg = new Message();
		cde = new Code();
		dfl = new Default();
		session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		prs = new DtaTblPr();
		lstRol = new ArrayList<ScrTblPrsRol>();
		lstPrsRol = new ArrayList<ScrTblPrsRol>();
		prl = new ScrTblPrsRol();
		prlSlc = new ScrTblPrsRol();
	}

	@Override
	@PostConstruct
	public void init() {
		this.actCmpPrsEml(false, true, true);
		this.actCmpPrsPss(false, true, true);
		this.vsbBtnLgn(false, true);
		this.vsbBtnNxt(true, false);
		this.actCmpRol(true, false, false);
	}

	@Override
	public void login() {
		lstRol = new ArrayList<ScrTblPrsRol>();
		prlSlc = new ScrTblPrsRol();
		boolean bemail = false;
		boolean bclave = false;

		try {
			lstPrsRol = sprl.lstPrsRol(cde.scrRolMng(), cde.scrRolTchGlp());
			for (ScrTblPrsRol auxPrl : lstPrsRol) {

				try {
					if (auxPrl.getDtaTblPr().getSPrsEml().trim().compareToIgnoreCase(prs.getSPrsEml()) == 0
							|| auxPrl.getDtaTblPr().getSPrsUsr().trim().compareToIgnoreCase(prs.getSPrsEml()) == 0) {
						bemail = true;
						try {
							if (auxPrl.getDtaTblPr().getSPrsPsw().equals(prs.getSPrsPsw())) {
								prl = auxPrl;
								bclave = true;
								break;
							}
						} catch (Exception e) {
							e.printStackTrace();
							this.log.impMsg("Password", e.getLocalizedMessage());
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					this.log.impMsg("Busqueda por usuario/email", e.getLocalizedMessage());
				}

			}
			if (!bemail) {
				this.msg.msgWrn(msg.msgWrnEml);
			} else if (bemail == true && bclave == false) {
				this.msg.msgWrn(msg.msgWrnPsw);
			} else if (bemail && bclave) {
				this.actCmpPrsEml(true, true, false);
				this.actCmpPrsPss(true, false, false);
				this.vsbBtnLgn(true, false);
				this.vsbBtnNxt(false, true);
				this.actCmpRol(false, true, true);
				try {
					lstRol = sprl.lstRol(prl.getDtaTblPr());
					Collections.sort(lstRol, new Comparator<ScrTblPrsRol>() {
						public int compare(ScrTblPrsRol o1, ScrTblPrsRol o2) {
							return o1.getIRolId().compareTo(o2.getIRolId());
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void vld() {
		try {
			try {
				prlSlc = sprl.searchId(IRolId);
				prlSlc.setISttId(cde.sctSttSss());
				sprl.update(prlSlc);
				session.setAttribute("prl", prlSlc);
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				session.setAttribute("sss", sSss.save(prlSlc, msg.txtStrSss(dfl.currentTime())));
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				WebTblMnu mnu = new WebTblMnu();
				mnu = sMnu.mnuRol(prlSlc.getIRolId());
				FacesContext contex = FacesContext.getCurrentInstance();
				contex.getExternalContext().redirect(mnu.getSMnuLnk());
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/****************** BOTONES FORMULARIO *********************/
	private boolean dsbBtnLgn;
	private boolean vsbBtnLgn;

	private void vsbBtnLgn(boolean dsb, boolean vsb) {
		dsbBtnLgn = dsb;
		vsbBtnLgn = vsb;
	}

	private boolean dsbBtnNxt;
	private boolean vsbBtnNxt;

	private void vsbBtnNxt(boolean dsb, boolean vsb) {
		dsbBtnNxt = dsb;
		vsbBtnNxt = vsb;
	}

	/****************** MNU *********************/
	@EJB
	protected WebSrvMnu sMnu;

	/****************** PRS *********************/
	private boolean rqrCmpPrsEml;
	private boolean dsbCmpPrsEml;
	private boolean vsbCmpPrsEml;

	private void actCmpPrsEml(boolean dsb, boolean vsb, boolean rqr) {
		rqrCmpPrsEml = rqr;
		dsbCmpPrsEml = dsb;
		vsbCmpPrsEml = vsb;
	}

	private boolean rqrCmpPrsPss;
	private boolean dsbCmpPrsPss;
	private boolean vsbCmpPrsPss;

	private void actCmpPrsPss(boolean dsb, boolean vsb, boolean rqr) {
		rqrCmpPrsPss = rqr;
		dsbCmpPrsPss = dsb;
		vsbCmpPrsPss = vsb;
	}

	private DtaTblPr prs;
	@EJB
	protected DtaSrvPrs sprs;

	/****************** ROL *********************/
	private boolean rqrCmpRol;
	private boolean dsbCmpRol;
	private boolean vsbCmpRol;

	private void actCmpRol(boolean dsb, boolean vsb, boolean rqr) {
		rqrCmpRol = rqr;
		dsbCmpRol = dsb;
		vsbCmpRol = vsb;
	}

	private int IRolId;
	private List<ScrTblPrsRol> lstRol;
	private List<ScrTblPrsRol> lstPrsRol;
	private ScrTblPrsRol prl;
	private ScrTblPrsRol prlSlc;
	@EJB
	protected ScrSrvPrsRol sprl;

	/****************** SSS *********************/
	@EJB
	protected ScrSrvSss sSss;

	/********************************************
	 * GET AND SET
	 ********************************************/

	public boolean isRqrCmpRol() {
		return rqrCmpRol;
	}

	public void setRqrCmpRol(boolean rqrCmpRol) {
		this.rqrCmpRol = rqrCmpRol;
	}

	public boolean isDsbCmpRol() {
		return dsbCmpRol;
	}

	public void setDsbCmpRol(boolean dsbCmpRol) {
		this.dsbCmpRol = dsbCmpRol;
	}

	public boolean isVsbCmpRol() {
		return vsbCmpRol;
	}

	public void setVsbCmpRol(boolean vsbCmpRol) {
		this.vsbCmpRol = vsbCmpRol;
	}

	public ScrTblPrsRol getPrlSlc() {
		return prlSlc;
	}

	public void setPrlSlc(ScrTblPrsRol prlSlc) {
		this.prlSlc = prlSlc;
	}

	public List<ScrTblPrsRol> getLstRol() {
		return lstRol;
	}

	public void setLstRol(List<ScrTblPrsRol> lstRol) {
		this.lstRol = lstRol;
	}

	public int getIRolId() {
		return IRolId;
	}

	public void setIRolId(int iRolId) {
		IRolId = iRolId;
	}

	public DtaTblPr getPrs() {
		return prs;
	}

	public void setPrs(DtaTblPr prs) {
		this.prs = prs;
	}

	public boolean isDsbBtnLgn() {
		return dsbBtnLgn;
	}

	public void setDsbBtnLgn(boolean dsbBtnLgn) {
		this.dsbBtnLgn = dsbBtnLgn;
	}

	public boolean isVsbBtnLgn() {
		return vsbBtnLgn;
	}

	public void setVsbBtnLgn(boolean vsbBtnLgn) {
		this.vsbBtnLgn = vsbBtnLgn;
	}

	public boolean isRqrCmpPrsEml() {
		return rqrCmpPrsEml;
	}

	public void setRqrCmpPrsEml(boolean rqrCmpPrsEml) {
		this.rqrCmpPrsEml = rqrCmpPrsEml;
	}

	public boolean isDsbCmpPrsEml() {
		return dsbCmpPrsEml;
	}

	public void setDsbCmpPrsEml(boolean dsbCmpPrsEml) {
		this.dsbCmpPrsEml = dsbCmpPrsEml;
	}

	public boolean isVsbCmpPrsEml() {
		return vsbCmpPrsEml;
	}

	public void setVsbCmpPrsEml(boolean vsbCmpPrsEml) {
		this.vsbCmpPrsEml = vsbCmpPrsEml;
	}

	public boolean isRqrCmpPrsPss() {
		return rqrCmpPrsPss;
	}

	public void setRqrCmpPrsPss(boolean rqrCmpPrsPss) {
		this.rqrCmpPrsPss = rqrCmpPrsPss;
	}

	public boolean isDsbCmpPrsPss() {
		return dsbCmpPrsPss;
	}

	public void setDsbCmpPrsPss(boolean dsbCmpPrsPss) {
		this.dsbCmpPrsPss = dsbCmpPrsPss;
	}

	public boolean isVsbCmpPrsPss() {
		return vsbCmpPrsPss;
	}

	public void setVsbCmpPrsPss(boolean vsbCmpPrsPss) {
		this.vsbCmpPrsPss = vsbCmpPrsPss;
	}

	public boolean isDsbBtnNxt() {
		return dsbBtnNxt;
	}

	public void setDsbBtnNxt(boolean dsbBtnNxt) {
		this.dsbBtnNxt = dsbBtnNxt;
	}

	public boolean isVsbBtnNxt() {
		return vsbBtnNxt;
	}

	public void setVsbBtnNxt(boolean vsbBtnNxt) {
		this.vsbBtnNxt = vsbBtnNxt;
	}

}
