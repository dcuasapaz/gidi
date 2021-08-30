package ec.gob.msp.pms.ctl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.gob.msp.pms.cmm.Method;
import ec.gob.msp.pms.ent.DteTblDay;
import ec.gob.msp.pms.ent.DteTblMnt;
import ec.gob.msp.pms.ent.DteTblYr;
import ec.gob.msp.pms.srv.DteSrvDay;
import ec.gob.msp.pms.srv.DteSrvMnt;
import ec.gob.msp.pms.srv.DteSrvYr;


@ManagedBean
@ViewScoped
public class DteCtlAdm {
	
	protected Method mth;
	
	public DteCtlAdm() {
		mth = new Method();
	}
	
	@EJB
	protected DteSrvYr sYr;

	@EJB
	protected DteSrvDay sDay;

	@EJB
	protected DteSrvMnt sMnt;

	private List<Integer> lstDay;

	private void newDay() {
		lstDay = new ArrayList<Integer>();
	}

	public List<DteTblYr> loadYr(int IMdlId) {
		try {
			return sYr.lstYr(IMdlId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<DteTblMnt> loadMnt() {
		try {
			return sMnt.srcAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void chsMnt(int IYrId, int IMntId) {
		try {
			this.newDay();
			System.out.println("Año:" + IYrId);
			System.out.println("Mes:" + IMntId);
			lstDay = mth.lstDay(IYrId, IMntId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Integer> loadDay(int IYrId, int IMntId) {
		try {
			this.newDay();
			System.out.println("Año:" + IYrId);
			System.out.println("Mes:" + IMntId);
			lstDay = mth.lstDay(IYrId, IMntId);
			return lstDay;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public DteTblDay rtrDay(int IDayVle) {
		try {
			return sDay.searchId(IDayVle);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public DteTblMnt rtrMnt(int IMntVle) {
		try {
			return sMnt.searchId(IMntVle);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Integer> getLstDay() {
		return lstDay;
	}

	public void setLstDay(List<Integer> lstDay) {
		this.lstDay = lstDay;
	}

}
