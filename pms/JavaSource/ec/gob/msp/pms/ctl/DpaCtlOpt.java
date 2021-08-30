package ec.gob.msp.pms.ctl;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.gob.msp.pms.srv.DpaSrvOpt;
import ec.gob.msp.pms.ent.DpaTblOpt;

@ViewScoped
@ManagedBean
public class DpaCtlOpt {

	/*******************************************************/
	@EJB
	protected DpaSrvOpt SDpaOpt;

	/*******************************************************/
	public DpaCtlOpt() {

	}

	/*******************************************************/
	public DpaTblOpt rtrEnt(int IOptId) {
		try {
			return SDpaOpt.searchId(IOptId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/*******************************************************/
	public DpaTblOpt rtrEntPrv(int IPrvCde) {
		try {
			return SDpaOpt.rtrEntPrv(IPrvCde);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/*******************************************************/
	public List<DpaTblOpt> rtrLstEnt(int IOptId) {
		try {
			return SDpaOpt.rtrLstEnt(IOptId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/*******************************************************/
		
}
