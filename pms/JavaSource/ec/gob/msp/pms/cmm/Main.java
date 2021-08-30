package ec.gob.msp.pms.cmm;

import ec.gob.msp.pms.ent.DpaTblCnt;
import ec.gob.msp.pms.ent.DtaTblPr;

public class Main {

	public static String getPassword(Default dfl, String nmeAux, String key) {
		String pswd = "";
		for (int i = 0; i < 4; i++) {
			pswd += (key.charAt((int) (Math.random() * key.length())));
		}
		return dfl.sCurrentDateFile().substring(0, 4) + "-" + nmeAux + "-" + dfl.sCurrentDateFile().substring(4, 6)
				+ "-" + pswd.toUpperCase() + "-" + dfl.sCurrentDateFile().substring(6, 8);

	}

	public static String cntDtl(Html html, DpaTblCnt cnt) {
		try {
			Method mth = new Method();
			String cde = "<b>" + html.ICntCde + ": <b/>" + cnt.getICntCde() + "<br/>";
			String nme = "<b>" + html.SCntNme + ": <b/>" + cnt.getSCntNme() + "<br/>";
			String fle = "<b>" + html.SCntCmp + ": <b/>" + cnt.getSCntDcm() + "<br/>";
			String stt = "<b>" + html.SPrsRolStt + ": <b/>" + cnt.getISttCde() + "<br/>";
			String obs = "<b>" + html.SGnrObs + ": <b/>" + cnt.getSCntObs() + "<br/>";
			String dte = "<b>" + html.DCntDte + ": <b/>" + cnt.getICntDteStrPrcYr() + "-"
					+ mth.SCdeMth(cnt.getICntDteStrPrcMth()) + "-" + mth.SCdeDay(cnt.getICntDteStrPrcDay());
			return cde + nme + fle + stt + obs + dte;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {

		System.out.println(getPassword(new Default(), "PMS", "dcuasapaz"));

		int a = 602;
		if (a <= 999) {
			System.out.println("0" + a);
		} else {
			System.out.println(a);
		}
		DpaTblCnt cnt = new DpaTblCnt();
		cnt.setICntCde(1701);
		cnt.setSCntNme("Quito");
		cnt.setSCntDcm("C:/PMS/2202/MSP_PMS_Comprobante_1701_20170101.docx");
		cnt.setSCntObs("Imprimir");
		cnt.setICntDteStrPrcYr(2017);
		cnt.setICntDteStrPrcMth(1);
		cnt.setICntDteStrPrcDay(1);
		System.out.println(cntDtl(new Html(), cnt));

		String prl = "test1, test2, test3, ";
		System.out.println(prl.substring(0, prl.length()-2)+".");
		
		Email eml = new Email();
		DtaTblPr prs = new DtaTblPr();
		prs.setSPrsNme("hola");
		prs.setSPrsLstNme("hola");
		prs.setSPrsUsr("hola");
		prs.setSPrsEml("diego.cuasapaz.heredia@gmail.com");
		eml.sndEmlPrf(prs, "test", "test");
	}

}
