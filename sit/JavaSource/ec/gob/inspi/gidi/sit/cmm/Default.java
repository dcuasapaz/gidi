package ec.gob.inspi.gidi.sit.cmm;

import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.faces.bean.ManagedBean;


@ManagedBean
public class Default {

	public Default() {
		// TODO Auto-generated constructor stub
	}
	public int IDflVle() {
		return -99;
	}
	public String acr() {
		return "sit";
	}

	/** TASK **/
	public int tskRslCtd() {
		return 0;
	}

	/** PAGINAS SISTEMA **/
	public String urlErrorSss() {
		return "/" + this.acr() + "/error/error.jsf";
	}

	public String urlLgn() {
		return "/" + this.acr() + "/login.jsf";
	}

	/** RETORNA LA HORA ACTUAL **/
	public String currentTime() {
		DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
		Calendar clnTme = GregorianCalendar.getInstance();
		Date fch = new Date();
		fch.setTime(clnTme.getTimeInMillis());
		return hourFormat.format(fch);
	}

	/** RETORNA LA FECHA ACTUAL **/
	public Date dCurrentDate() {
		return new Date();
	}

	public int yrDfl() {
		return Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()));
	}

	public int mntDlf() {
		return Integer.parseInt(new SimpleDateFormat("MM").format(new Date()));
	}

	public int dayDfl() {
		return Integer.parseInt(new SimpleDateFormat("dd").format(new Date()));
	}

	public String sCurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date fch = new Date();
		return dateFormat.format(fch);
	}

	public String sCurrentDateFile() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date fch = new Date();
		return dateFormat.format(fch);
	}

	/** RETORNA VALOR DEFECTO CAMPO STRING **/
	public String cmpStr() {
		return "";
	}
	
	public String cmpTime() {
		return "00";
	}
	

	public String noneLstNme() {
		return "";
	}

	public String none() {
		return "---------------";
	}

	/** RETORNA VALOR DEFECTO CAMPO INTEGER **/
	public int cmpInt() {
		return -99;
	}

	/** RETORNA PREDETERMINADA **/
	public String defaultTime() {
		return "00:00:00";
	}
}
