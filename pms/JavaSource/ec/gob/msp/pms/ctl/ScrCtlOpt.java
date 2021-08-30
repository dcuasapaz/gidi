package ec.gob.msp.pms.ctl;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.gob.msp.pms.srv.ScrSrvOpt;
import ec.gob.msp.pms.ent.ScrTblOpt;

@ViewScoped
@ManagedBean
public class ScrCtlOpt {

	/*******************************************************/
	@EJB
	protected ScrSrvOpt SScrOpt;

	/*******************************************************/
	public ScrCtlOpt() {

	}

	/*******************************************************/
	public ScrTblOpt rtrEnt(int IOptId) {
		try {
			return SScrOpt.searchId(IOptId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/*******************************************************/
	public List<ScrTblOpt> lstEnt(int IOptCde, boolean BOptStt) {
		try {
			return SScrOpt.rtrLstEnt(IOptCde, BOptStt);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/*******************************************************/
}
