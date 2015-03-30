package volk.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Expression;

import volk.domain.Service;
import volk.domain.ServiceInGuest;

public class DaoServiceInGuest extends Generic<ServiceInGuest> implements
		Serializable {

	public DaoServiceInGuest() {
		super();
	}

	@Override
	public List<ServiceInGuest> getSelectQuery() {
		return session.createCriteria(ServiceInGuest.class).list();
	}

	@Override
	protected void insertObject(ServiceInGuest serviceInGuest) {

		session.save(serviceInGuest);

	}

	@Override
	public void updateObject(ServiceInGuest serviceInGuest) {

		session.update(serviceInGuest);

	}

	@Override
	public void deleteObject(ServiceInGuest serviceInGuest) {

		session.delete(serviceInGuest);

	}

	@Override
	public ServiceInGuest getObjectPk(int key) {
		List<ServiceInGuest> serviceInGuest = session
				.createCriteria(ServiceInGuest.class)
				.add(Expression.eq("idGuest", key)).list();
		System.out.println(serviceInGuest);
		return serviceInGuest.get(0);
	}

	public List<ServiceInGuest> getObjectsList(int key) {
		List<ServiceInGuest> list = session
				.createCriteria(ServiceInGuest.class)
				.add(Expression.eq("idGuest", key)).list();
		return list;
	}
}
