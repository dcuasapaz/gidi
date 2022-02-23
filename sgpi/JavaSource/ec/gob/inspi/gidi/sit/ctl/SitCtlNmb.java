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
import ec.gob.inspi.gidi.sit.ent.SitTblNmb;
import ec.gob.inspi.gidi.sit.ent.SitTblSte;
import ec.gob.inspi.gidi.sit.srv.SitSrvNmb;

@ManagedBean
@ViewScoped
public class SitCtlNmb {
	@EJB
	protected SitSrvNmb SOvi;
	private static Logger LOG;

	public SitCtlNmb() {
		LOG = Logger.getLogger(this.getClass().getName());
	}

	public List<SitTblNmb> lstNmb(SitTblSte ste) {
		try {
			List<SitTblNmb> auxLstNmb = new ArrayList<SitTblNmb>();
			auxLstNmb = SOvi.lstNmb(ste, true);
			Collections.sort(auxLstNmb, new Comparator<SitTblNmb>() {
				public int compare(SitTblNmb o1, SitTblNmb o2) {
					return o1.getINmbId().compareTo(o2.getINmbId());
				}
			});
			return auxLstNmb;
		} catch (Exception e) {
			e.printStackTrace();LOG.log(Level.WARNING, Message.S_LOG_NME_CTL + e.getMessage());
			return null;
		}
	}

	public List<SitTblNmb> lstNmbSP(SitTblSte ste) {
		try {
			List<SitTblNmb> auxLstNmb = new ArrayList<SitTblNmb>();
			auxLstNmb = SOvi.lstNmb(ste, true);
			return auxLstNmb;
		} catch (Exception e) {
			LOG.log(Level.WARNING, Message.S_LOG_NME_CTL + e.getMessage());
			return null;
		}
	}
}
