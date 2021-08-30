package ec.gob.msp.pms.ctl;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.gob.msp.pms.ent.PmsTblMnc;
import ec.gob.msp.pms.ent.VrfTblInsMnc;
import ec.gob.msp.pms.srv.VrfSrvInsMnc;

@ManagedBean
@ViewScoped
public class VrfCtlInsMnc {
	
	public VrfCtlInsMnc() {

	}

	@EJB
	protected VrfSrvInsMnc SInsMnc;

	public List<VrfTblInsMnc> lstInsMnc(PmsTblMnc mnc) {
		try {
			return SInsMnc.lstInsMnc(mnc);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
