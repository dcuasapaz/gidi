package ec.gob.msp.pms.ctl;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import ec.gob.msp.pms.cmm.Code;
import ec.gob.msp.pms.cmm.Default;
import ec.gob.msp.pms.cmm.Message;
import ec.gob.msp.pms.ent.ScrTblPrsRol;
import ec.gob.msp.pms.ent.ScrTblSss;
import ec.gob.msp.pms.itf.ScrItfSss;
import ec.gob.msp.pms.srv.ScrSrvPrsRol;
import ec.gob.msp.pms.srv.ScrSrvSss;

@ManagedBean
@ViewScoped
@RequestScoped
public class ScrCtlSss implements ScrItfSss {

	private final HttpServletRequest httpServletRequest;
	private final FacesContext faceContext;
	protected Code cde;

	protected static Logger LOG;

	public ScrCtlSss() {
		prl = new ScrTblPrsRol();
		sss = new ScrTblSss();
		cde = new Code();
		LOG = Logger.getLogger(this.getClass().getName());
		faceContext = FacesContext.getCurrentInstance();
		httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();
		if (httpServletRequest.getSession().getAttribute("prsRol") != null
				&& httpServletRequest.getSession().getAttribute("sss") != null) {
			prl = (ScrTblPrsRol) httpServletRequest.getSession().getAttribute("prsRol");
			sss = (ScrTblSss) httpServletRequest.getSession().getAttribute("sss");
		} else {
			try {
				FacesContext contex = FacesContext.getCurrentInstance();
				contex.getExternalContext().redirect(Default.P_HOME_ERROR);
			} catch (IOException e) {
				LOG.log(Level.WARNING, e.getMessage());
			}
		}
	}

	@Override
	public void clsSss() {
		try {
			if (sPrl.upd(prl, cde.sctSttNoSss()) && sSss.upd(sss, Message.T_SCR_END_SSS)) {
				httpServletRequest.getSession().removeAttribute("sss");
				httpServletRequest.getSession().removeAttribute("prsRol");
				FacesContext contex = FacesContext.getCurrentInstance();
				try {
					contex.getExternalContext().redirect(Default.P_HOME_LOGIN);
				} catch (IOException e) {
					LOG.log(Level.WARNING, e.getMessage());
				}
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE, e.getMessage());
			try {
				FacesContext contex = FacesContext.getCurrentInstance();
				contex.getExternalContext().redirect(Default.P_HOME_ERROR);
			} catch (IOException ex) {
				LOG.log(Level.SEVERE, ex.getMessage());
			}
		}
	}

	/****************** PRL *********************/
	private ScrTblPrsRol prl;
	@EJB
	protected ScrSrvPrsRol sPrl;
	/****************** SSS *********************/
	protected ScrTblSss sss;
	@EJB
	protected ScrSrvSss sSss;

	/********************************************
	 * GET AND SET
	 ********************************************/
	public ScrTblPrsRol getPrl() {
		return prl;
	}

	public void setPrl(ScrTblPrsRol prl) {
		this.prl = prl;
	}

	public ScrTblSss getSss() {
		return sss;
	}

	public void setSss(ScrTblSss sss) {
		this.sss = sss;
	}

}
