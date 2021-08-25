package ec.gob.inspi.gidi.sit.cmm;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.jboss.logging.Logger;

public abstract class SrvDb<T> {
	@PersistenceContext
	protected EntityManager em;

	protected static Logger LOG;
	private Class<T> tipoEntidad;
	private Class<?> tipoServicio;

	public SrvDb(Class<T> tipoEntidad, Class<?> tipoServicio) {
		this.tipoEntidad = tipoEntidad;
		this.tipoServicio = tipoServicio;
	}

	public void insert(T entidad) throws Exception {
		LOG.debug("Insert Entity>>" + entidad);
		em.persist(entidad);
	}

	public void update(T entidad) throws Exception {
		LOG.debug("Update Entity>>" + entidad);
		em.merge(entidad);
	}

	public void delete(T entidad) throws Exception {
		LOG.debug("Delete Entity>>" + entidad);
		em.remove(em.merge(entidad));
	}

	public T searchId(Integer id) throws Exception {
		LOG.debug("Search for Id>>" + id);
		return em.find(tipoEntidad, id);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> srcAll() {
		CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
		cq.select(cq.from(tipoEntidad));
		return em.createQuery(cq).getResultList();
	}

	@PostConstruct
	private void setLogger() {
		if (LOG == null) {
			LOG = Logger.getLogger(tipoServicio);
		}
	}

}
