package ec.gob.inspi.gidi.sit.ctl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import ec.gob.inspi.gidi.sit.cmm.Method;
import ec.gob.inspi.gidi.sit.ent.DteTblDay;
import ec.gob.inspi.gidi.sit.ent.DteTblMnt;
import ec.gob.inspi.gidi.sit.ent.DteTblYr;
import ec.gob.inspi.gidi.sit.srv.DteSrvDay;
import ec.gob.inspi.gidi.sit.srv.DteSrvMnt;
import ec.gob.inspi.gidi.sit.srv.DteSrvYr;

@ManagedBean
public class DteCtlDte {

	protected Method mth;

	public DteCtlDte() {
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
			System.out.println("A�o:" + IYrId);
			System.out.println("Mes:" + IMntId);
			lstDay = mth.lstDay(IYrId, IMntId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Integer> loadDay(int IYrId, int IMntId) {
		try {
			this.newDay();
			System.out.println("A�o:" + IYrId);
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
