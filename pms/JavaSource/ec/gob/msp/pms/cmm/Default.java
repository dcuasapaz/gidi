package ec.gob.msp.pms.cmm;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Default {
	public Default() {

	}

	/*******************************************************/
	public String flePthMain() {
		return "/root/Documentos/EpiSIG/PMS/";
	}

	public String flePrf() {
		return "MSP_PMS_";
	}

	public String fleCpb() {
		return "CartaIntencion_";
	}

	/*******************************************************/
	public String SVleStr() {
		return "";
	}

	public String SVleNull() {
		return "<p class=\"null\">Null</p>";
	}

	public int IVleInt() {
		return -99;
	}

	public boolean BVleT() {
		return true;
	}

	public String SKey() {
		return "MncSld";
	}

	/*******************************************************/
	/** RETORNA LA HORA ACTUAL **/

	public static final String S_CURRENT_TIME() {
		DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
		Calendar clnTme = GregorianCalendar.getInstance();
		Date fch = new Date();
		fch.setTime(clnTme.getTimeInMillis());
		return hourFormat.format(fch);
	}

	public String SCurrentTime() {
		DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
		Calendar clnTme = GregorianCalendar.getInstance();
		Date fch = new Date();
		fch.setTime(clnTme.getTimeInMillis());
		return hourFormat.format(fch);
	}

	/** RETORNA LA FECHA ACTUAL **/
	public Date DCurrentDate() {
		return new Date();
	}

	public String sCurrentDateFile() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date fch = new Date();
		return dateFormat.format(fch);
	}

	/*******************************************************/
	public static final String P_HOME_MAIN = "/pms/prf/home.jsf";
	public static final String P_HOME_LOGIN = "/pms/login.jsf";
	public static final String P_HOME_ERROR = "/pms/error/error.jsf";

	public int yrDfl() {
		return Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()));
	}

	public int mntDlf() {
		return Integer.parseInt(new SimpleDateFormat("MM").format(new Date()));
	}

	public int dayDfl() {
		return Integer.parseInt(new SimpleDateFormat("dd").format(new Date()));
	}
}
