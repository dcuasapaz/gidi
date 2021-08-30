package ec.gob.msp.pms.cmm;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.bean.ManagedBean;

import ec.gob.msp.pms.ent.DpaTblCnt;
import ec.gob.msp.pms.ent.PmsTblOpt;

@ManagedBean
public class Method {
	protected Code cde;
	protected Html html;

	public Method() {
		cde = new Code();
		html = new Html();
	}

	/** Convierte texto a formato estandar **/
	public String mtdStrNmb(String valor) {
		valor = valor.toLowerCase();
		char[] caracteres = valor.toCharArray();
		caracteres[0] = Character.toUpperCase(caracteres[0]);
		for (int i = 0; i < valor.length() - 2; i++) {
			if (caracteres[i] == ' ' || caracteres[i] == '.' || caracteres[i] == ',')
				caracteres[i + 1] = Character.toUpperCase(caracteres[i + 1]);
		}
		return new String(caracteres);
	}

	public String getPassword(Default dfl, String nmeAux, String key) {
		String pswd = "";
		for (int i = 0; i < 4; i++) {
			pswd += (key.charAt((int) (Math.random() * key.length())));
		}
		return dfl.sCurrentDateFile().substring(0, 4) + "-" + nmeAux + "-" + dfl.sCurrentDateFile().substring(4, 6)
				+ "-" + pswd.toUpperCase() + "-" + dfl.sCurrentDateFile().substring(6, 8);
	}

	public String SCdeMth(int IDteMth) {
		if (IDteMth <= 9) {
			return "0" + IDteMth;
		} else {
			return "" + IDteMth;
		}
	}

	public String SCdeDay(int IDteDay) {
		if (IDteDay <= 9) {
			return "0" + IDteDay;
		} else {
			return "" + IDteDay;
		}
	}

	public String SCdeCnt(int ICntCde) {
		if (ICntCde <= 999) {
			return "0" + ICntCde;
		} else {
			return "" + ICntCde;
		}
	}

	/** VALIDAR SI UN AÑO ES BISIESTO **/
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

	public String PrintCntDtl(DpaTblCnt cnt, PmsTblOpt opt) {
		try {
			String cde = "<b>" + html.ICntCde + ": <b/>" + cnt.getICntCde() + "<br/>";
			String nme = "<b>" + html.SCntNme + ": <b/>" + cnt.getSCntNme() + "<br/>";
			String fle = "<b>" + html.SCntCmp + ": <b/>" + cnt.getSCntDcm() + "<br/>";
			String stt = "<b>" + html.SPrsRolStt + ": <b/>" + opt.getSOptNme() + "<br/>";
			String obs = "<b>" + html.SGnrObs + ": <b/>" + cnt.getSCntObs() + "<br/>";
			String dte = "<b>" + html.DCntDte + ": <b/>" + cnt.getICntDteStrPrcYr() + "-"
					+ this.SCdeMth(cnt.getICntDteStrPrcMth()) + "-" + this.SCdeDay(cnt.getICntDteStrPrcDay());
			return cde + nme + fle + stt + obs + dte;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String SLblInd(int ILstSize) {
		String vle = "<div class='pms-lbl-ind-sze'>" + ILstSize + "</div> <div class='pms-lbl-ind'>"
				+ "Indicadores: </div>";
		return vle;
	}

	public String SYN(boolean vlr) {
		if (vlr != false) {
			return "Sí";
		} else {
			return "No";
		}
	}

	public int clr(boolean vlr) {
		if (vlr != false) {
			return cde.org();
		} else {
			return cde.IVleFth();
		}
	}

}
