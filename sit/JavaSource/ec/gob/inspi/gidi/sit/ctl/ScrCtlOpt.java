package ec.gob.inspi.gidi.sit.ctl;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import ec.gob.inspi.gidi.sit.ent.ScrTblOpt;
import ec.gob.inspi.gidi.sit.srv.ScrSrvOpt;


@ManagedBean
public class ScrCtlOpt {

	@EJB
	protected ScrSrvOpt sScrOpt;

	public ScrCtlOpt() {

	}

	public ScrTblOpt rtrOpt(int IOptId) {
		try {
			return sScrOpt.searchId(IOptId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<ScrTblOpt> loadLstOpt(int IOptId) {
		try {
			return sScrOpt.lstOpt(IOptId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
