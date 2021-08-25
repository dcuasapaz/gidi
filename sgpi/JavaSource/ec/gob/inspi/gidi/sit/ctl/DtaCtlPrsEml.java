package ec.gob.inspi.gidi.sit.ctl;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.gob.inspi.gidi.sit.ent.DtaTblPr;
import ec.gob.inspi.gidi.sit.ent.DtaTblPrsEml;
import ec.gob.inspi.gidi.sit.srv.DtaSrvPrsEml;

@ManagedBean
@ViewScoped
public class DtaCtlPrsEml {

	public DtaCtlPrsEml() {

	}

	@EJB
	protected DtaSrvPrsEml SPrsEml;

	public String email(DtaTblPr prs) {
		try {
			String vle = "";
			if (SPrsEml.lstPrsEml(prs) != null) {
				for (DtaTblPrsEml aux : SPrsEml.lstPrsEml(prs)) {
					if (SPrsEml.lstPrsEml(prs).size() == 1) {
						vle = aux.getSEmlDsc();
					} else {
						vle = vle + aux.getSEmlDsc() + "<br/>";
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
