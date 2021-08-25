package ec.gob.inspi.gidi.sit.ctl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import ec.gob.inspi.gidi.sit.ent.InfTblStm;
import ec.gob.inspi.gidi.sit.srv.InfSrvStm;

@ManagedBean
public class InfCtlStm {

	private InfTblStm stm;
	private InfTblStm stmAdmin;
	private List<InfTblStm> lstStm;

	@EJB
	protected InfSrvStm sstm;

	public InfCtlStm() {
		stm = new InfTblStm();
	}

	@PostConstruct
	public void init() {
		try {
			stm = sstm.searchId(1);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<InfTblStm> getLstStm() {
		return lstStm;
	}

	public void setLstStm(List<InfTblStm> lstStm) {
		this.lstStm = lstStm;
	}

	public InfTblStm getStm() {
		return stm;
	}

	public void setStm(InfTblStm stm) {
		this.stm = stm;
	}

	public InfTblStm getStmAdmin() {
		return stmAdmin;
	}

	public void setStmAdmin(InfTblStm stmAdmin) {
		this.stmAdmin = stmAdmin;
	}

}
