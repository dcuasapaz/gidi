package ec.gob.inspi.gidi.sit.ctl;

import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import ec.gob.inspi.gidi.sit.cmm.Code;
import ec.gob.inspi.gidi.sit.cmm.Default;
import ec.gob.inspi.gidi.sit.cmm.Message;
import ec.gob.inspi.gidi.sit.ent.ScrTblPrsRol;
import ec.gob.inspi.gidi.sit.ent.ScrTblSss;
import ec.gob.inspi.gidi.sit.itf.ScrItfSss;
import ec.gob.inspi.gidi.sit.srv.ScrSrvPrsRol;
import ec.gob.inspi.gidi.sit.srv.ScrSrvSss;

@ManagedBean
@ViewScoped
@RequestScoped
public class ScrCtlSss implements ScrItfSss {

	protected Message msg;
	protected Code cde;
	protected Default dfl;

	private final HttpServletRequest httpServletRequest;
	private final FacesContext faceContext;

	public ScrCtlSss() {
		msg = new Message();
		cde = new Code();
		dfl = new Default();
		prl = new ScrTblPrsRol();
		sss = new ScrTblSss();

		faceContext = FacesContext.getCurrentInstance();
		httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();

		if (httpServletRequest.getSession().getAttribute("prl") != null
				&& httpServletRequest.getSession().getAttribute("sss") != null) {
			prl = (ScrTblPrsRol) httpServletRequest.getSession().getAttribute("prl");
			sss = (ScrTblSss) httpServletRequest.getSession().getAttribute("sss");
		} else {
			try {
				FacesContext contex = FacesContext.getCurrentInstance();
				contex.getExternalContext().redirect(dfl.urlErrorSss());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void clsSss() {
		try {
			if (sPrl.update(prl, cde.sctSttNoSss()) && sSss.update(sss, msg.txtEndSss(dfl.currentTime()))) {
				httpServletRequest.getSession().removeAttribute("sss");
				httpServletRequest.getSession().removeAttribute("prl");
				FacesContext contex = FacesContext.getCurrentInstance();
				try {
					contex.getExternalContext().redirect(dfl.urlLgn());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				FacesContext contex = FacesContext.getCurrentInstance();
				contex.getExternalContext().redirect(dfl.urlErrorSss());
			} catch (IOException ex) {
				e.printStackTrace();
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

}
