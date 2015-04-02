package volk.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Expression;

import volk.domain.Service;

public class DaoService extends Generic<Service> implements Serializable {

	public DaoService() {
		super();

	}

	@Override
	public List<Service> getSelectQuery() {
		return session.createCriteria(Service.class).list();
	}

	@Override
	protected void insertObject(Service service) {

		session.save(service);

	}

	@Override
	public void updateObject(Service service) {

		session.update(service);

	}

	@Override
	public void deleteObject(Service service) {

		session.delete(service);

	}

	@Override
	public Service getObjectPk(int key) {
		List<Service> service = session.createCriteria(Service.class)
				.add(Expression.eq("id", key)).list();
		return service.get(0);
	}

}
