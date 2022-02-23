package ec.gob.inspi.gidi.sit.srv;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.inspi.gidi.sit.cmm.Message;
import ec.gob.inspi.gidi.sit.cmm.SrvDb;
import ec.gob.inspi.gidi.sit.ent.SitTblOpt;

@Stateless
public class SitSrvOPt extends SrvDb<SitTblOpt> {
	private static Logger LOG;

	public SitSrvOPt() {
		super(SitTblOpt.class, SitSrvOPt.class);
		LOG = Logger.getLogger(this.getClass().getName());
	}

	public List<SitTblOpt> lstOpt(int IFhtId, boolean BOptStt) {
		try {
			String sql = "SELECT opt FROM SitTblOpt opt WHERE opt.iOptFth = :param1 AND opt.bOptStt = :param2 ORDER BY 1";
			Query q = em.createQuery(sql);
			q.setParameter("param1", IFhtId);
			q.setParameter("param2", BOptStt);
			return q.getResultList();
		} catch (Exception e) {
			LOG.log(Level.SEVERE, Message.S_LOG_NME_SRV + e.getMessage());
			return null;
		}

	}
}
