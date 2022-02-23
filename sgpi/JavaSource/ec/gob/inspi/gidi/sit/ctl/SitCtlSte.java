package ec.gob.inspi.gidi.sit.ctl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.gob.inspi.gidi.sit.cmm.Message;
import ec.gob.inspi.gidi.sit.ent.SitTblSte;
import ec.gob.inspi.gidi.sit.srv.SitSrvSte;

@ManagedBean
@ViewScoped
public class SitCtlSte {

	@EJB
	protected SitSrvSte SSte;
	private static Logger LOG;

	public SitCtlSte() {
		LOG = Logger.getLogger(this.getClass().getName());
	}

	public List<SitTblSte> lstSte(int IPrjId) {
		try {
			return SSte.lstSte(IPrjId, true);
		} catch (Exception e) {
			LOG.log(Level.WARNING, Message.S_LOG_NME_CTL + e.getMessage());
			return null;
		}
	}
}
