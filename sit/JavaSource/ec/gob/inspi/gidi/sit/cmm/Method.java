package ec.gob.inspi.gidi.sit.cmm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.bean.ManagedBean;

import ec.gob.inspi.gidi.sit.ent.DteTblDay;

@ManagedBean
public class Method {

	protected Colour clr;
	protected Message msg;
	protected Option opt;
	protected Log log;
	protected Name nme;
	protected Code cde;

	public Method() {
		clr = new Colour();
		msg = new Message();
		opt = new Option();
		log = new Log();
		nme = new Name();
		cde = new Code();
	}

	public String acr(String nme, String lst_nme) {
		String rtr = "";
		rtr = nme.substring(0, 1) + lst_nme.substring(0, 1);
		System.out.println("Acr:" + rtr);
		return rtr;
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
			this.log.impCtl(Method.class.getSimpleName(), nme.evnLoad(), nme.actAdd(), DteTblDay.class.getSimpleName(),
					e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public int vldDte(Date dteStr, Date dteEnd) {
		int vlrFch = 0;
		try {
			if (dteStr.before(dteEnd)) {
				vlrFch = -1;
			} else {
				if (dteEnd.before(dteStr)) {
					vlrFch = 1;
				} else {
					vlrFch = 0;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.log.impCtl(Method.class.getSimpleName(), nme.evnLoad(), nme.actAdd(), Date.class.getSimpleName(),
					e.getMessage());
			return 0;
		}
		return vlrFch;
	}

	public Date dte(int yr, int mnt, int day) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return formatter.parse(yr + "-" + mnt + "-" + day);
		} catch (ParseException e) {
			this.log.impCtl(Method.class.getSimpleName(), nme.evnLoad(), nme.actAdd(), Date.class.getSimpleName(),
					e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public String SConvert(Date dte) throws ParseException {
		try {
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
			return fmt.format(dte);
		} catch (Exception e) {
			return "NO DATO";
		}
	}

	/** METODO PARA VALIDAR LA CEDULA ECUATORIANA **/
	public boolean validarCedula(String cedula) {
		// verifica que tenga 10 d�gitos y que contenga solo valores num�ricos
		if (!((cedula.length() == 10) && cedula.matches("^[0-9]{10}$"))) {
			return false;
		}

		// verifica que los dos primeros d�gitos correspondan a un valor entre 1
		// y NUMERO_DE_PROVINCIAS
		int prov = Integer.parseInt(cedula.substring(0, 2));
		if (!((prov > 0) && (prov <= 25))) {
			return false;
		}

		// verifica que el �ltimo d�gito de la c�dula sea v�lido
		int[] d = new int[10];

		// Asignamos el string a un array
		for (int i = 0; i < d.length; i++) {
			d[i] = Integer.parseInt(cedula.charAt(i) + "");
		}

		int imp = 0;
		int par = 0;

		// sumamos los duplos de posici�n impar
		for (int i = 0; i < d.length; i += 2) {
			d[i] = ((d[i] * 2) > 9) ? ((d[i] * 2) - 9) : (d[i] * 2);
			imp += d[i];
		}

		// sumamos los digitos de posici�n par
		for (int i = 1; i < (d.length - 1); i += 2) {
			par += d[i];
		}

		// Sumamos los dos resultados
		int suma = imp + par;

		// Restamos de la decena superior
		int d10 = Integer.parseInt(String.valueOf(suma + 10).substring(0, 1) + "0") - suma;

		// Si es diez el d�cimo d�gito es cero
		d10 = (d10 == 10) ? 0 : d10;

		// si el d�cimo d�gito calculado es igual al digitado la c�dula es
		// correcta
		return d10 == d[9];
	}

	public String chgBoolean(boolean vlr) {
		try {
			if (vlr == true) {
				return "Yes";
			} else {
				return "No";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public int week(Date dteClc) {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setFirstDayOfWeek(Calendar.MONDAY);
			calendar.setMinimalDaysInFirstWeek(4);
			calendar.setTime(dteClc);
			int numberWeekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
			return numberWeekOfYear;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

}
