package ec.gob.inspi.gidi.sit.ctl;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import ec.gob.inspi.gidi.sit.ent.InsTblOpt;
import ec.gob.inspi.gidi.sit.srv.InsSrvOpt;

@ManagedBean
public class InsCtlOpt {

	@EJB
	protected InsSrvOpt sInsOpt;

	public InsCtlOpt() {

	}

	public InsTblOpt rtrOpt(int IOptId) {
		try {
			return sInsOpt.searchId(IOptId);
		} catch (Exception e) {
			e.printStackTrace();

			return null;
		}
	}

	public List<InsTblOpt> loadLstOpt(int IOptId) {
		try {
			return sInsOpt.lstOpt(IOptId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
