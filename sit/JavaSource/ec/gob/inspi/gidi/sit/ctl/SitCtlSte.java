package ec.gob.inspi.gidi.sit.ctl;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.gob.inspi.gidi.sit.ent.SitTblSte;
import ec.gob.inspi.gidi.sit.srv.SitSrvSte;


@ManagedBean
@ViewScoped
public class SitCtlSte {

	@EJB
	protected SitSrvSte SSte;

	public SitCtlSte() {

	}

	public List<SitTblSte> lstSte(int IPrjId) {
		try {
			return SSte.lstSte(IPrjId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
