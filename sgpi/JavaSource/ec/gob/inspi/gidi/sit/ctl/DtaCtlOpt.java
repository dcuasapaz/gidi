package ec.gob.inspi.gidi.sit.ctl;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import ec.gob.inspi.gidi.sit.ent.DtaTblOpt;
import ec.gob.inspi.gidi.sit.srv.DtaSrvOpt;

@ManagedBean
public class DtaCtlOpt {

	@EJB
	protected DtaSrvOpt sDtaOpt;

	public DtaCtlOpt() {

	}

	public DtaTblOpt rtrOpt(int IOptId) {
		try {
			return sDtaOpt.searchId(IOptId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<DtaTblOpt> loadLstOpt(int IOptId) {
		try {
			return sDtaOpt.lstOpt(IOptId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
