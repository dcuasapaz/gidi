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

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import ec.gob.msp.pms.ent.WebTblMnu;
import ec.gob.msp.pms.ent.WebTblMnuSub;
import ec.gob.msp.pms.srv.WebSrvMnu;
import ec.gob.msp.pms.srv.WebSrvMnuSub;

@ManagedBean
@ViewScoped
public class WebCtlMnuSub {

	@EJB
	protected WebSrvMnuSub sMnuSub;

	@EJB
	protected WebSrvMnu sMnu;

	private MenuModel model;

	public WebCtlMnuSub() {
		model = new DefaultMenuModel();
	}

	private int IRolId;

	@PostConstruct
	public void init() {

	}

	public MenuModel mdlMnu(int IRolId) {
		model = new DefaultMenuModel();
		DefaultSubMenu mnuSub = new DefaultSubMenu();
		DefaultMenuItem item = new DefaultMenuItem();
		List<WebTblMnu> lstMnu = new ArrayList<WebTblMnu>();
		lstMnu = sMnu.lstMnuRol(IRolId);
		Collections.sort(lstMnu, new Comparator<WebTblMnu>() {
			@Override
			public int compare(WebTblMnu o1, WebTblMnu o2) {
				return o1.getSMnuNme().compareTo(o2.getSMnuNme());
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

	public MenuModel lstMnuSub(int IRolId) {
		model = new DefaultMenuModel();
		DefaultSubMenu mnuSub = new DefaultSubMenu();
		DefaultMenuItem item = new DefaultMenuItem();
		List<WebTblMnu> lstMnu = new ArrayList<WebTblMnu>();
		lstMnu = sMnu.lstMnuRol(IRolId);
		Collections.sort(lstMnu, new Comparator<WebTblMnu>() {
			@Override
			public int compare(WebTblMnu o1, WebTblMnu o2) {
				return o1.getSMnuNme().compareTo(o2.getSMnuNme());
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

	public MenuModel lstMnuSub1(int IRolId) {
		DefaultSubMenu mnuSub = new DefaultSubMenu();
		DefaultMenuItem item = new DefaultMenuItem();
		for (WebTblMnu aux : sMnu.lstMnuRol(IRolId)) {
			mnuSub = new DefaultSubMenu(aux.getSMnuNme());
			for (WebTblMnuSub itMnuSub : sMnuSub.lstMnuSubOpt(aux)) {
				item = new DefaultMenuItem(itMnuSub.getSMnuSubName());
				item.setUrl("http://www.primefaces.org");
				item.setIcon("ui-icon-home");
				mnuSub.addElement(item);
			}
			model.addElement(mnuSub);
		}
		return model;
	}

	public List<WebTblMnu> lstMnuRol(int IRolId) {
		return sMnu.lstMnuRol(IRolId);
	}

	public List<WebTblMnuSub> lstMnuOpt(WebTblMnu mnu) {
		return sMnuSub.lstMnuSubOpt(mnu);
	}

	public MenuModel getModel() {
		return model;
	}

	public void setModel(MenuModel model) {
		this.model = model;
	}

	public int getIRolId() {
		return IRolId;
	}

	public void setIRolId(int iRolId) {
		IRolId = iRolId;
	}
}
