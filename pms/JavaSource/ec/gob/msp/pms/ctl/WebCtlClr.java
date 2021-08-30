package ec.gob.msp.pms.ctl;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;


import ec.gob.msp.pms.ent.WebTblClr;
import ec.gob.msp.pms.srv.WebSrvClr;

@ManagedBean
public class WebCtlClr {

	

	public WebCtlClr() {
		
	}

	@EJB
	protected WebSrvClr SClr;

	public WebTblClr rtrClr(int IClrId) {
		try {
			return SClr.searchId(IClrId);
		} catch (Exception e) {
				e.printStackTrace();
			return null;
		}
	}

	public WebTblClr rtrClrSmf(int IClsId) {
		try {
			if (IClsId == 1 || IClsId == 2 || IClsId == 3) {
				IClsId = IClsId + 10;
			} else if (IClsId == 0) {
				IClsId = -99;
			}
			return SClr.searchId(IClsId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
