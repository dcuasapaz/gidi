package ec.gob.msp.pms.ctl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import ec.gob.msp.pms.cmm.Code;
import ec.gob.msp.pms.ent.IndTblLvl;
import ec.gob.msp.pms.srv.IndSrvLvl;

@ManagedBean
@ViewScoped

public class IndCtlLvl {

	protected Code cde;
	private IndTblLvl cmp;

	@EJB
	protected IndSrvLvl SIndLvl;

	public IndCtlLvl() {
		cde = new Code();
		cmp = new IndTblLvl();
	}

	@PostConstruct
	public void init() {

	}

	public List<IndTblLvl> lstLv1() {
		try {
			return SIndLvl.lstLv1(cde.IVleFth());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<IndTblLvl> lstLvl(IndTblLvl lvl) {
		try {
			return SIndLvl.lstLvl(lvl);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public IndTblLvl entLvl(int ILvlFth) {
		try {
			return SIndLvl.searchId(ILvlFth);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public IndTblLvl getCmp() {
		return cmp;
	}

	public void setCmp(IndTblLvl cmp) {
		this.cmp = cmp;
	}

}
