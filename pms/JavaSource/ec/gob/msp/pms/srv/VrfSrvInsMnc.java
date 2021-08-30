package ec.gob.msp.pms.srv;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.msp.pms.cmm.SrvDb;
import ec.gob.msp.pms.ent.PmsTblMnc;
import ec.gob.msp.pms.ent.VrfTblInsMnc;

@Stateless
public class VrfSrvInsMnc extends SrvDb<VrfTblInsMnc> {

	public VrfSrvInsMnc() {
		super(VrfTblInsMnc.class, VrfSrvInsMnc.class);

	}

	public List<VrfTblInsMnc> lstInsMnc(PmsTblMnc mnc) {
		try {
			String sql = "SELECT insMnc FROM VrfTblInsMnc insMnc WHERE insMnc.pmsTblMnc=:prm";
			Query q = em.createQuery(sql);
			q.setParameter("prm", mnc);
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
