package ec.gob.inspi.gidi.sit.ctl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.gob.inspi.gidi.sit.ent.WebTblMnu;
import ec.gob.inspi.gidi.sit.ent.WebTblMnuSub;
import ec.gob.inspi.gidi.sit.srv.WebSrvMnu;
import ec.gob.inspi.gidi.sit.srv.WebSrvMnuSub;

@ManagedBean
@ViewScoped
public class WebCtlPrf {

	protected ScrCtlPrsRol ctlPrl;

	private WebTblMnu mnu;
	@EJB
	protected WebSrvMnu sMnu;

	public WebCtlPrf() {
		mnu = new WebTblMnu();
		ctlPrl = new ScrCtlPrsRol();
	}

	@PostConstruct
	public void init() {
		try {
			mnu = sMnu.mnuRol(ctlPrl.loadPrl().getIRolId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.loadMnuSub();
	}

	private List<WebTblMnuSub> lstMnuSub;
	@EJB
	protected WebSrvMnuSub sMnuSub;

	private void newMnuSub() {
		lstMnuSub = new ArrayList<WebTblMnuSub>();
	}

	public void loadMnuSub() {
		try {
			this.newMnuSub();
			lstMnuSub = sMnuSub.lstMnuSub(mnu.getIMnuId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public WebTblMnu getMnu() {
		return mnu;
	}

	public void setMnu(WebTblMnu mnu) {
		this.mnu = mnu;
	}

	public List<WebTblMnuSub> getLstMnuSub() {
		return lstMnuSub;
	}

	public void setLstMnuSub(List<WebTblMnuSub> lstMnuSub) {
		this.lstMnuSub = lstMnuSub;
	}

}
