package ec.gob.inspi.gidi.sit.ctl;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import ec.gob.inspi.gidi.sit.cmm.Code;
import ec.gob.inspi.gidi.sit.cmm.DteTblMth;
import ec.gob.inspi.gidi.sit.ent.SitTblOpt;
import ec.gob.inspi.gidi.sit.srv.SitSrvOPt;



@ManagedBean
public class DteCtlGnr {

	protected Code cde;
	@EJB
	protected SitSrvOPt SOpt;
	private List<Integer> lstYr;
	private List<DteTblMth> lstMth;

	public DteCtlGnr() {
		cde = new Code();
	}

	@PostConstruct
	public void init() {
		this.loadYr();
		this.loadMth();
	}

	private void loadYr() {
		try {
			lstYr = new ArrayList<Integer>();
			List<SitTblOpt> lstYrAux = SOpt.lstOpt(9999);
			Iterator<SitTblOpt> auxYr = lstYrAux.iterator();
			while (auxYr.hasNext()) {
				SitTblOpt auxOpt = new SitTblOpt();
				auxOpt = auxYr.next();
				lstYr.add(Integer.parseInt(auxOpt.getSOptNme()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void loadMth() {
		try {
			lstMth = new ArrayList<DteTblMth>();
			lstMth.add(new DteTblMth(1, "January", "01"));
			lstMth.add(new DteTblMth(2, "February", "02"));
			lstMth.add(new DteTblMth(3, "March", "03"));
			lstMth.add(new DteTblMth(4, "April", "04"));
			lstMth.add(new DteTblMth(5, "May", "05"));
			lstMth.add(new DteTblMth(6, "June", "06"));
			lstMth.add(new DteTblMth(7, "July", "07"));
			lstMth.add(new DteTblMth(8, "August", "08"));
			lstMth.add(new DteTblMth(9, "September", "09"));
			lstMth.add(new DteTblMth(10, "October", "10"));
			lstMth.add(new DteTblMth(11, "November", "11"));
			lstMth.add(new DteTblMth(12, "December", "12"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String SMthCde(int IMthCde) {
		try {
			String SMthAux = "";
			if (IMthCde >= 1 && IMthCde <= 9) {
				SMthAux = "0" + IMthCde;
			} else {
				SMthAux = IMthCde + "";
			}
			return SMthAux;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public String SDayCde(int IDayCde) {
		String dayAux = "";
		if (IDayCde >= 1 && IDayCde <= 9) {
			dayAux = "0" + IDayCde;
		} else {
			dayAux = IDayCde + "";
		}
		return dayAux;
	}

	/** VALIDAR SI UN A�O ES BISIESTO **/
	public boolean vrfYrBss(int anio) {
		GregorianCalendar calendar = new GregorianCalendar();
		return calendar.isLeapYear(anio);
	}

	private List<Integer> vleDays(int vle) {
		List<Integer> aux = new ArrayList<Integer>();
		for (int i = 1; i <= vle; i++) {
			aux.add(i);
		}
		return aux;
	}

	public List<Integer> lstDay(int IYrId, int IMntId) {
		List<Integer> aux = new ArrayList<Integer>();
		try {
			switch (IMntId) {
			case 2:
				if (this.vrfYrBss(IYrId)) {
					aux = this.vleDays(cde.dteDayBss());
				} else {
					aux = this.vleDays(cde.dteDayBssNo());
				}
				break;
			case 4:
				aux = this.vleDays(cde.dteDayNrmNo());
				break;

			case 6:
				aux = this.vleDays(cde.dteDayNrmNo());
				break;

			case 9:
				aux = this.vleDays(cde.dteDayNrmNo());
				break;

			case 11:
				aux = this.vleDays(cde.dteDayNrmNo());
				break;

			case 1:
				aux = this.vleDays(cde.dteDayNrm());
				break;

			case 3:
				aux = this.vleDays(cde.dteDayNrm());
				break;

			case 5:
				aux = this.vleDays(cde.dteDayNrm());
				break;

			case 7:
				aux = this.vleDays(cde.dteDayNrm());
				break;

			case 8:
				aux = this.vleDays(cde.dteDayNrm());
				break;

			case 10:
				aux = this.vleDays(cde.dteDayNrm());
				break;

			case 12:
				aux = this.vleDays(cde.dteDayNrm());
				break;
			}
			return aux;
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}

	public List<Integer> getLstYr() {
		return lstYr;
	}

	public void setLstYr(List<Integer> lstYr) {
		this.lstYr = lstYr;
	}

	public List<DteTblMth> getLstMth() {
		return lstMth;
	}

	public void setLstMth(List<DteTblMth> lstMth) {
		this.lstMth = lstMth;
	}
}
