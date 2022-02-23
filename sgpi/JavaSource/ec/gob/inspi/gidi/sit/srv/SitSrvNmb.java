package ec.gob.inspi.gidi.sit.srv;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;

import javax.persistence.Query;

import ec.gob.inspi.gidi.sit.cmm.Message;
import ec.gob.inspi.gidi.sit.cmm.SrvDb;
import ec.gob.inspi.gidi.sit.ent.SitTblNmb;
import ec.gob.inspi.gidi.sit.ent.SitTblSte;

@Stateless
public class SitSrvNmb extends SrvDb<SitTblNmb> {
	private static Logger LOG;

	public SitSrvNmb() {
		super(SitTblNmb.class, SitSrvNmb.class);
		LOG = Logger.getLogger(this.getClass().getName());
	}

	public List<SitTblNmb> lstNmb(SitTblSte ste, boolean BNmbStt) {
		try {
			String sql = "SELECT nmb FROM SitTblNmb nmb WHERE nmb.sitTblSte = :param1 AND nmb.bNmbStt = :param2";
			Query q = em.createQuery(sql);
			q.setParameter("param1", ste);
			q.setParameter("param2", BNmbStt);			
			return q.getResultList();
		} catch (Exception e) {
			LOG.log(Level.WARNING, Message.S_LOG_NME_SRV + e.getMessage());
			return null;
		}

	}

}
