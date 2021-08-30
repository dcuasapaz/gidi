package ec.gob.msp.pms.ctl;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import ec.gob.msp.pms.cmm.Code;
import ec.gob.msp.pms.cmm.Default;
import ec.gob.msp.pms.cmm.Message;
import ec.gob.msp.pms.ent.DtaTblPr;
import ec.gob.msp.pms.ent.ScrTblPrsRol;
import ec.gob.msp.pms.itf.ScrIftLgn;
import ec.gob.msp.pms.srv.ScrSrvPrsRol;
import ec.gob.msp.pms.srv.ScrSrvSss;
import ec.gob.msp.pms.srv.WebSrvMnu;

@ManagedBean
@ViewScoped
public class ScrCtlLgn implements ScrIftLgn {
	/*******************************************************/
	protected Code cde;
	protected Message msg;
	protected Default dfl;
	protected static Logger LOG;
	/*******************************************************/
	private HttpSession session;
	@EJB
	protected ScrSrvSss SSss;
	/*******************************************************/
	@EJB
	protected ScrSrvPrsRol SPrsRol;
	private ScrTblPrsRol prsRol;
	/*******************************************************/
	@EJB
	protected WebSrvMnu SMnu;
	/*******************************************************/
	private DtaTblPr prs;

	/*******************************************************/
	public ScrCtlLgn() {
		cde = new Code();
		msg = new Message();
		dfl = new Default();
		prs = new DtaTblPr();
		prsRol = new ScrTblPrsRol();
		session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		LOG = Logger.getLogger(this.getClass().getName());
	}

	/*******************************************************/
	private boolean rqrAtrPrsUsr;
	private boolean dsbAtrPrsUsr;
	private boolean vsbAtrPrsUsr;

	@Override
	public void actAtrPrsUsr(boolean dsb, boolean vsb, boolean rqr) {
		rqrAtrPrsUsr = rqr;
		dsbAtrPrsUsr = dsb;
		vsbAtrPrsUsr = vsb;
	}

	/*******************************************************/
	private boolean rqrAtrPrsPsw;
	private boolean dsbAtrPrsPsw;
	private boolean vsbAtrPrsPsw;

	@Override
	public void actAtrPrsPsw(boolean dsb, boolean vsb, boolean rqr) {
		rqrAtrPrsPsw = rqr;
		dsbAtrPrsPsw = dsb;
		vsbAtrPrsPsw = vsb;
	}

	/*******************************************************/
	private boolean dsbBtnLgn;
	private boolean vsbBtnLgn;

	@Override
	public void actBtnLgn(boolean dsb, boolean vsb) {
		dsbBtnLgn = dsb;
		vsbBtnLgn = vsb;
	}

	/*******************************************************/
	@Override
	@PostConstruct
	public void init() {
		this.actAtrPrsUsr(false, true, true);
		this.actAtrPrsPsw(false, true, true);
		this.actBtnLgn(false, true);
	}

	/*******************************************************/
	@Override
	public void login() {
		try {
			boolean BPrsUsr = false;
			boolean BPrsPsw = false;
			prsRol = new ScrTblPrsRol();
			Iterator<ScrTblPrsRol> itrPrsRol = SPrsRol.lstPrsRol(cde.IScrSttAct()).iterator();
			while (itrPrsRol.hasNext()) {
				ScrTblPrsRol auxPrsRol = new ScrTblPrsRol();
				auxPrsRol = itrPrsRol.next();
				if (auxPrsRol.getDtaTblPr().getSPrsEml().compareTo(prs.getSPrsUsr()) == 0
						|| auxPrsRol.getDtaTblPr().getSPrsUsr().compareTo(prs.getSPrsUsr()) == 0) {
					BPrsUsr = true;
					if (auxPrsRol.getDtaTblPr().getSPrsPsw().compareTo(prs.getSPrsPsw()) == 0) {
						prsRol = auxPrsRol;
						BPrsPsw = true;
						break;
					} else {
						this.msg.msgWrn("La contraseña ingresada es incorrecta");
					}
				} else {
					this.msg.msgWrn("El email/usuario ingresado es incorrecto");
				}
			}
			if (BPrsUsr != false && BPrsPsw != false) {
				if (SPrsRol.upd(prsRol, cde.IScrSttAct())) {
					session.setAttribute("prsRol", prsRol);
					session.setAttribute("sss", SSss.sve(prsRol, Message.T_SCR_STR_SSS));
					FacesContext contex = FacesContext.getCurrentInstance();
					contex.getExternalContext().redirect(Default.P_HOME_MAIN);
				} else {
					FacesContext contex = FacesContext.getCurrentInstance();
					contex.getExternalContext().redirect(Default.P_HOME_ERROR);

				}
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE, e.getMessage());
		}
	}

	/*******************************************************/

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public DtaTblPr getPrs() {
		return prs;
	}

	public void setPrs(DtaTblPr prs) {
		this.prs = prs;
	}

	public boolean isRqrAtrPrsUsr() {
		return rqrAtrPrsUsr;
	}

	public void setRqrAtrPrsUsr(boolean rqrAtrPrsUsr) {
		this.rqrAtrPrsUsr = rqrAtrPrsUsr;
	}

	public boolean isDsbAtrPrsUsr() {
		return dsbAtrPrsUsr;
	}

	public void setDsbAtrPrsUsr(boolean dsbAtrPrsUsr) {
		this.dsbAtrPrsUsr = dsbAtrPrsUsr;
	}

	public boolean isVsbAtrPrsUsr() {
		return vsbAtrPrsUsr;
	}

	public void setVsbAtrPrsUsr(boolean vsbAtrPrsUsr) {
		this.vsbAtrPrsUsr = vsbAtrPrsUsr;
	}

	public boolean isRqrAtrPrsPsw() {
		return rqrAtrPrsPsw;
	}

	public void setRqrAtrPrsPsw(boolean rqrAtrPrsPsw) {
		this.rqrAtrPrsPsw = rqrAtrPrsPsw;
	}

	public boolean isDsbAtrPrsPsw() {
		return dsbAtrPrsPsw;
	}

	public void setDsbAtrPrsPsw(boolean dsbAtrPrsPsw) {
		this.dsbAtrPrsPsw = dsbAtrPrsPsw;
	}

	public boolean isVsbAtrPrsPsw() {
		return vsbAtrPrsPsw;
	}

	public void setVsbAtrPrsPsw(boolean vsbAtrPrsPsw) {
		this.vsbAtrPrsPsw = vsbAtrPrsPsw;
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

}
