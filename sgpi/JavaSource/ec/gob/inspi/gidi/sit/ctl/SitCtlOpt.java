package ec.gob.inspi.gidi.sit.ctl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.gob.inspi.gidi.sit.cmm.Message;
import ec.gob.inspi.gidi.sit.ent.SitTblOpt;
import ec.gob.inspi.gidi.sit.srv.SitSrvOPt;

@ManagedBean
@ViewScoped
public class SitCtlOpt {
	@EJB
	protected SitSrvOPt SOpt;

	private static Logger LOG;

	public SitCtlOpt() {
		LOG = Logger.getLogger(this.getClass().getName());
	}

	public List<SitTblOpt> lstOpt(int IFthId) {
		try {
			List<SitTblOpt> auxOpt = new ArrayList<SitTblOpt>();
			auxOpt = SOpt.lstOpt(IFthId, true);
			return auxOpt;
		} catch (Exception e) {
			LOG.log(Level.SEVERE, Message.S_LOG_NME_CTL + e.getMessage());
			return null;
		}
	}

	public List<SitTblOpt> lstOptCtg(int IFthId) {
		try {
			List<SitTblOpt> auxOpt = new ArrayList<SitTblOpt>();
			auxOpt = SOpt.lstOpt(IFthId, true);
			Collections.sort(auxOpt, new Comparator<SitTblOpt>() {
				public int compare(SitTblOpt o1, SitTblOpt o2) {
					return o1.getiOptCtg().compareTo(o2.getiOptCtg());
				}
			});
			return auxOpt;
		} catch (Exception e) {
			LOG.log(Level.SEVERE, Message.S_LOG_NME_CTL + e.getMessage());
			return null;
		}
	}

	public List<SitTblOpt> lstOptNme(int IFthId) {
		try {
			List<SitTblOpt> auxOpt = new ArrayList<SitTblOpt>();
			auxOpt = SOpt.lstOpt(IFthId, true);
			Collections.sort(auxOpt, new Comparator<SitTblOpt>() {
				public int compare(SitTblOpt o1, SitTblOpt o2) {
					return o1.getSOptNme().compareTo(o2.getSOptNme());
				}
			});
			return auxOpt;
		} catch (Exception e) {
			LOG.log(Level.SEVERE, Message.S_LOG_NME_CTL + e.getMessage());
			return null;
		}
	}

	public List<SitTblOpt> lstEpiNme(int IFthId) {
		try {
			List<SitTblOpt> auxOpt = new ArrayList<SitTblOpt>();
			auxOpt = SOpt.lstOpt(IFthId, true);
			Collections.sort(auxOpt, new Comparator<SitTblOpt>() {
				public int compare(SitTblOpt o1, SitTblOpt o2) {
					return o1.getSOptNme().compareTo(o2.getSOptNme());
				}
			});
			return auxOpt;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public SitTblOpt ent(int IOptId) throws Exception {
		try {
			return SOpt.searchId(IOptId);
		} catch (Exception e) {
			e.printStackTrace();
			return SOpt.searchId(-99);
		}
	}
}
