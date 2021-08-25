package ec.gob.inspi.gidi.sit.ctl;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.gob.inspi.gidi.sit.ent.DtaTblPr;
import ec.gob.inspi.gidi.sit.ent.DtaTblPrsPhn;
import ec.gob.inspi.gidi.sit.srv.DtaSrvPrsPhn;

@ManagedBean
@ViewScoped
public class DtaCtlPrsPhn {

	public DtaCtlPrsPhn() {

	}

	@EJB
	protected DtaSrvPrsPhn SPrsPhn;

	public String phone(DtaTblPr prs) {
		try {
			String vle = "";
			if (SPrsPhn.lstPrsPhn(prs) != null) {
				for (DtaTblPrsPhn aux : SPrsPhn.lstPrsPhn(prs)) {
					if (SPrsPhn.lstPrsPhn(prs).size() == 1) {
						vle = aux.getSPhnDsc();
					} else {
						vle = vle + aux.getSPhnDsc() + "<br/>";
					}
				}
			}
			return vle;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

}
