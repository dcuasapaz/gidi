package ec.gob.msp.pms.ctl;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.gob.msp.pms.srv.DtaSrvOpt;
import ec.gob.msp.pms.ent.DtaTblOpt;

@ViewScoped
@ManagedBean
public class DtaCtlOpt {

	/*******************************************************/
	@EJB
	protected DtaSrvOpt SDtaOpt;

	/*******************************************************/
	public DtaCtlOpt() {

	}

	/*******************************************************/
	public DtaTblOpt rtrEnt(int IOptId) {
		try {
			return SDtaOpt.searchId(IOptId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/*******************************************************/
	public List<DtaTblOpt> lstEnt(int IOptCde, boolean BOptStt) {
		try {
			return SDtaOpt.rtrLstEnt(IOptCde, BOptStt);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/*******************************************************/
}
