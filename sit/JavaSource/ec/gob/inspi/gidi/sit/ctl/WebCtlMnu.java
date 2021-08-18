package ec.gob.inspi.gidi.sit.ctl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import ec.gob.inspi.gidi.sit.cmm.Code;
import ec.gob.inspi.gidi.sit.cmm.Log;
import ec.gob.inspi.gidi.sit.cmm.Name;
import ec.gob.inspi.gidi.sit.cmm.Page;
import ec.gob.inspi.gidi.sit.ent.ScrTblPrsRol;
import ec.gob.inspi.gidi.sit.ent.WebTblMnu;
import ec.gob.inspi.gidi.sit.ent.WebTblMnuSub;
import ec.gob.inspi.gidi.sit.srv.WebSrvMnu;
import ec.gob.inspi.gidi.sit.srv.WebSrvMnuSub;

@ManagedBean
@ViewScoped
@RequestScoped
public class WebCtlMnu {

	protected Log log;
	protected Name nme;
	protected Page pge;
	protected Code cde;

	public WebCtlMnu() {
		log = new Log();
		nme = new Name();
		pge = new Page();
		cde = new Code();

		sss = new ScrCtlSss();
		prl = new ScrTblPrsRol();
	}

	@PostConstruct
	public void init() {
		// this.loadMnu(this.loadPrl().getIRolId());
		this.loadMnuSubTsk(cde.mnuTsk());
	}

	public WebTblMnu rtrEnt(int IMnuId) {
		try {
			return sMnu.searchId(IMnuId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ------------------------- MODULE: Scr -------------------------
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */
	/****************************************************************/
	/** 01: ScrCtlSss **/
	/****************************************************************/
	protected ScrCtlSss sss;

	/****************************************************************/
	/** 02: ScrTblPrsRol **/
	/****************************************************************/
	protected ScrTblPrsRol prl;

	/*
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ------------------------- MODULE: Web -------------------------
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */
	/****************************************************************/
	/** 01: WebTblMnu **/
	/****************************************************************/
	@EJB
	protected WebSrvMnu sMnu;

	public void home(int IRolId) {
		try {
			FacesContext contex = FacesContext.getCurrentInstance();
			contex.getExternalContext().redirect(sMnu.mnuRol(IRolId).getSMnuLnk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*****************************************************************/
	/** 02: WebTblMnuSub **/
	/****************************************************************/
	private List<WebTblMnuSub> lstMnuSubTsk;
	@EJB
	protected WebSrvMnuSub sMnuSub;

	private void newMnuSubTsk() {
		lstMnuSubTsk = new ArrayList<WebTblMnuSub>();
	}

	private void loadMnuSubTsk(int IMnuTskId) {
		try {
			this.newMnuSubTsk();
			lstMnuSubTsk = sMnuSub.lstMnuSub(IMnuTskId);
			Collections.sort(lstMnuSubTsk, new Comparator<WebTblMnuSub>() {
				public int compare(WebTblMnuSub o1, WebTblMnuSub o2) {
					return o1.getIMnuSubCtg().compareTo(o2.getIMnuSubCtg());
				}
			});
		} catch (Exception e) {
			this.log.impCtl(WebCtlMnu.class.getSimpleName(), nme.evnLoad(), nme.actAdd(),
					WebTblMnuSub.class.getSimpleName(), e.getMessage());
		}
	}

	public List<WebTblMnuSub> getLstMnuSubTsk() {
		return lstMnuSubTsk;
	}

	public void setLstMnuSubTsk(List<WebTblMnuSub> lstMnuSubTsk) {
		this.lstMnuSubTsk = lstMnuSubTsk;
	}

}
