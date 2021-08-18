package ec.gob.inspi.gidi.sit.ctl;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.gob.inspi.gidi.sit.ent.DtaTblPr;
import ec.gob.inspi.gidi.sit.ent.DtaTblPrsLct;
import ec.gob.inspi.gidi.sit.srv.DtaSrvPrsLct;

@ManagedBean
@ViewScoped
public class DtaCtlPrsLct {

	public DtaCtlPrsLct() {

	}

	@EJB
	protected DtaSrvPrsLct SPrsLct;

	public String city(DtaTblPr prs) {
		try {
			String vle = "";
			if (SPrsLct.lstPrsUbc(prs) != null) {
				for (DtaTblPrsLct aux : SPrsLct.lstPrsUbc(prs)) {
					if (SPrsLct.lstPrsUbc(prs).size() == 1) {
						vle = aux.getSLctCty();
					} else {
						vle = vle + aux.getSLctCty() + "<br/>";
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
