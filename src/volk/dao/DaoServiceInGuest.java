package volk.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Expression;

import volk.domain.Guest;
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
	public Object getObjectPk(int key) {
		Guest guest = new Guest();
		guest.setId(key);
		List<ServiceInGuest> serviceInGuest = session
				.createCriteria(ServiceInGuest.class)
				.add(Expression.eq("idGuest", guest)).list();
		System.out.println(serviceInGuest);
		return serviceInGuest;
	}

}
