package ec.gob.msp.pms.ctl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.gob.msp.pms.ent.DtaTblPr;
import ec.gob.msp.pms.srv.DtaSrvPrs;

@ManagedBean
@ViewScoped
public class DtaCtlPrs {

	public DtaCtlPrs() {

	}

	@PostConstruct
	public void init() {
		this.loadPrs();
	}

	/****************** PRS *********************/

	@EJB
	protected DtaSrvPrs sPrs;

	public List<DtaTblPr> loadPrs() {
		try {
			List<DtaTblPr> lstPrs = new ArrayList<DtaTblPr>();
			lstPrs = sPrs.srcAll();
			Collections.sort(lstPrs, new Comparator<DtaTblPr>() {
				public int compare(DtaTblPr o1, DtaTblPr o2) {
					return o2.getIPrsId().compareTo(o1.getIPrsId());
				}
			});
			return lstPrs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
