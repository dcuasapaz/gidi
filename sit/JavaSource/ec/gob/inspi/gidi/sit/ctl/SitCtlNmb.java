package ec.gob.inspi.gidi.sit.ctl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.gob.inspi.gidi.sit.ent.SitTblNmb;
import ec.gob.inspi.gidi.sit.ent.SitTblSte;
import ec.gob.inspi.gidi.sit.srv.SitSrvNmb;

@ManagedBean
@ViewScoped
public class SitCtlNmb {
	@EJB
	protected SitSrvNmb SOvi;

	public SitCtlNmb() {

	}

	public List<SitTblNmb> lstNmb(SitTblSte ste) {
		try {
			List<SitTblNmb> auxLstNmb = new ArrayList<SitTblNmb>();
			auxLstNmb = SOvi.lstNmb(ste);
			Collections.sort(auxLstNmb, new Comparator<SitTblNmb>() {
				public int compare(SitTblNmb o1, SitTblNmb o2) {
					return o1.getINmbId().compareTo(o2.getINmbId());
				}
			});
			return auxLstNmb;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
