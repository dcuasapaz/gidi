package ec.gob.msp.pms.ctl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import ec.gob.msp.pms.ent.DtaTblPr;
import ec.gob.msp.pms.ent.ScrTblPrsRol;
import ec.gob.msp.pms.ent.WebTblMnu;
import ec.gob.msp.pms.ent.WebTblMnuSub;
import ec.gob.msp.pms.srv.ScrSrvOpt;
import ec.gob.msp.pms.srv.ScrSrvPrsRol;
import ec.gob.msp.pms.srv.WebSrvMnu;
import ec.gob.msp.pms.srv.WebSrvMnuSub;

@ManagedBean
@ViewScoped
public class TplPms {

	//private HttpSession session;
	protected ScrCtlSss sss;

	public TplPms() {
		model = new DefaultMenuModel();
		//session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		sss = new ScrCtlSss();
		prsRol = new ScrTblPrsRol();
	}

	/*******************************************************/
	private int IRolPgeCde;
	/*******************************************************/
	@EJB
	protected ScrSrvPrsRol SPrsRol;
	private ScrTblPrsRol prsRol;

	public List<ScrTblPrsRol> loadRol(DtaTblPr prs) {
		try {
			return SPrsRol.lstRol(prs);
		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
	}

	public void chsRol() {
		try {
			if (IRolPgeCde == 0) {
				model = new DefaultMenuModel();
				vsbPnlMnu = false;
			} else {
				vsbPnlMnu = true;
				prsRol = new ScrTblPrsRol();
				prsRol = SPrsRol.searchId(IRolPgeCde);
			//	session.setAttribute("prsRol", prsRol);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*******************************************************/
	@PostConstruct
	public void init() {
		try {
			if (sss.getPrl() == null) {
				model = new DefaultMenuModel();
				vsbPnlMnu = false;
			} else {
				vsbPnlMnu = true;
				prsRol = new ScrTblPrsRol();
				IRolPgeCde = sss.getPrl().getIPrsRolId();
				prsRol = SPrsRol.searchId(IRolPgeCde);
				// session.setAttribute("prsRol", prsRol);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*******************************************************/

	private boolean vsbPnlMnu;
	@EJB
	protected WebSrvMnuSub sMnuSub;
	@EJB
	protected WebSrvMnu sMnu;

	private MenuModel model;

	public MenuModel lstMnuSub(ScrTblPrsRol prsRol) {
		model = new DefaultMenuModel();
		DefaultSubMenu mnuSub = new DefaultSubMenu();
		DefaultMenuItem item = new DefaultMenuItem();
		List<WebTblMnu> lstMnu = new ArrayList<WebTblMnu>();
		lstMnu = sMnu.lstMnuRol(prsRol.getIRolId());
		Collections.sort(lstMnu, new Comparator<WebTblMnu>() {
			@Override
			public int compare(WebTblMnu o1, WebTblMnu o2) {
				return o1.getIMnuCtg().compareTo(o2.getIMnuCtg());
			}
		});
		Iterator<WebTblMnu> mnu = lstMnu.iterator();
		while (mnu.hasNext()) {
			WebTblMnu aux = mnu.next();
			mnuSub = new DefaultSubMenu(aux.getSMnuNme());
			for (WebTblMnuSub itMnuSub : sMnuSub.lstMnuSubOpt(aux)) {
				item = new DefaultMenuItem(itMnuSub.getSMnuSubName());
				item.setUrl(itMnuSub.getSMnuSubLnk());
				item.setIcon(itMnuSub.getSMnuSubIcn());
				mnuSub.addElement(item);
			}
			model.addElement(mnuSub);
		}

		return model;
	}

	/*******************************************************/
	@EJB
	protected ScrSrvOpt SScrOpt;

	public String rtrPrsRol(ScrTblPrsRol prsRol) {
		String vle = "";
		try {
			vle = "| <b>Municipio/Institución: </b> " + prsRol.getDpaTblCnt().getSCntNme() + " | <b>Email: </b>"
					+ prsRol.getDtaTblPr().getSPrsEml() + " | <b>Usuario: </b>" + prsRol.getDtaTblPr().getSPrsUsr()
					+ " | <b>Fecha: </b>" + new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			return vle;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/*******************************************************/

	public int getIRolPgeCde() {
		return IRolPgeCde;
	}

	public void setIRolPgeCde(int iRolPgeCde) {
		IRolPgeCde = iRolPgeCde;
	}

	public boolean isVsbPnlMnu() {
		return vsbPnlMnu;
	}

	public void setVsbPnlMnu(boolean vsbPnlMnu) {
		this.vsbPnlMnu = vsbPnlMnu;
	}

	public ScrTblPrsRol getPrsRol() {
		return prsRol;
	}

	public void setPrsRol(ScrTblPrsRol prsRol) {
		this.prsRol = prsRol;
	}

}
