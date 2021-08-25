package ec.gob.inspi.gidi.sit.ctl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import ec.gob.inspi.gidi.sit.ent.DpaTblCnr;
import ec.gob.inspi.gidi.sit.itf.DpaIftCnr;
import ec.gob.inspi.gidi.sit.srv.DpaSrvCnr;

@ManagedBean
public class DpaCtlCnr implements DpaIftCnr {

	@EJB
	protected DpaSrvCnr sCnr;

	public DpaCtlCnr() {

	}

	@Override
	public DpaTblCnr rtrCnr(int ICnrId) {
		try {
			return sCnr.searchId(ICnrId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<DpaTblCnr> loadLstCnr() {
		try {
			List<DpaTblCnr> lstCnr = new ArrayList<DpaTblCnr>();
			lstCnr = sCnr.srcAll();
			Collections.sort(lstCnr, new Comparator<DpaTblCnr>() {
				public int compare(DpaTblCnr o1, DpaTblCnr o2) {
					return o1.getSCnrNmeSpn().compareTo(o2.getSCnrNmeSpn());
				}
			});
			return lstCnr;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
