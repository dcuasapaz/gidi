package ec.gob.msp.pms.ctl;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.gob.msp.pms.srv.PmsSrvOpt;
import ec.gob.msp.pms.ent.PmsTblOpt;

@ViewScoped
@ManagedBean
public class PmsCtlOpt {

	/*******************************************************/
	@EJB
	protected PmsSrvOpt SPmsOpt;

	/*******************************************************/
	public PmsCtlOpt() {

	}

	/*******************************************************/
	public PmsTblOpt rtrEnt(int IOptId) {
		try {
			return SPmsOpt.searchId(IOptId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<PmsTblOpt> rtrLstEnt(int IOptId) {
		try {
			return SPmsOpt.rtrLstEnt(IOptId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<PmsTblOpt> rtrLstEntObl(int IOptId) {
		try {
			return SPmsOpt.rtrLstEntObl(IOptId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/*******************************************************/
}
