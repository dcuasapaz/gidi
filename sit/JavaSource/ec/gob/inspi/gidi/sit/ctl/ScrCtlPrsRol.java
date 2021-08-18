package ec.gob.inspi.gidi.sit.ctl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.gob.inspi.gidi.sit.ent.ScrTblPrsRol;
import ec.gob.inspi.gidi.sit.srv.ScrSrvOpt;
import ec.gob.inspi.gidi.sit.srv.ScrSrvPrsRol;

@ManagedBean
@ViewScoped
public class ScrCtlPrsRol {

	protected ScrCtlSss sss;

	protected ScrTblPrsRol prl;
	@EJB
	protected ScrSrvPrsRol SPrl;
	@EJB
	protected ScrSrvOpt SScrOpt;

	public ScrCtlPrsRol() {
		sss = new ScrCtlSss();
		prl = new ScrTblPrsRol();
	}

	public ScrTblPrsRol loadPrl() {
		try {
			return sss.getPrl();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ScrTblPrsRol rtrEnt(int IPrsRolID) {
		try {
			return SPrl.searchId(IPrsRolID);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<ScrTblPrsRol> loadPrlIns(int IRolCde) {
		try {
			List<ScrTblPrsRol> lstAux = new ArrayList<ScrTblPrsRol>();
			lstAux = SPrl.lstPrsRol(IRolCde);
			Collections.sort(lstAux, new Comparator<ScrTblPrsRol>() {
				public int compare(ScrTblPrsRol o1, ScrTblPrsRol o2) {
					return o1.getDtaTblPr().getSPrsLstNme().compareTo(o2.getDtaTblPr().getSPrsLstNme());
				}
			});
			return lstAux;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<ScrTblPrsRol> lstPrsPrf(int IPrfId) {
		try {
			List<ScrTblPrsRol> lstPrsPrfAux = new ArrayList<ScrTblPrsRol>();
			lstPrsPrfAux = SPrl.lstPrsRol(IPrfId);
			Collections.sort(lstPrsPrfAux, new Comparator<ScrTblPrsRol>() {
				public int compare(ScrTblPrsRol o1, ScrTblPrsRol o2) {
					return o1.getDtaTblPr().getSPrsLstNme().compareTo(o2.getDtaTblPr().getSPrsLstNme());
				}
			});
			return lstPrsPrfAux;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<ScrTblPrsRol> lstPrsPrfFld(int IPrjId) {
		try {
			List<ScrTblPrsRol> lstPrsPrfAux = new ArrayList<ScrTblPrsRol>();
			lstPrsPrfAux = SPrl.lstPrsRolFld(IPrjId);
			Collections.sort(lstPrsPrfAux, new Comparator<ScrTblPrsRol>() {
				public int compare(ScrTblPrsRol o1, ScrTblPrsRol o2) {
					return o1.getDtaTblPr().getSPrsLstNme().compareTo(o2.getDtaTblPr().getSPrsLstNme());
				}
			});
			return lstPrsPrfAux;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<ScrTblPrsRol> lstPrsPrfTch(int IPrjId) {
		try {
			List<ScrTblPrsRol> lstPrsPrfAux = new ArrayList<ScrTblPrsRol>();
			lstPrsPrfAux = SPrl.lstPrsRolTch(IPrjId);
			Collections.sort(lstPrsPrfAux, new Comparator<ScrTblPrsRol>() {
				public int compare(ScrTblPrsRol o1, ScrTblPrsRol o2) {
					return o1.getDtaTblPr().getSPrsLstNme().compareTo(o2.getDtaTblPr().getSPrsLstNme());
				}
			});
			return lstPrsPrfAux;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
