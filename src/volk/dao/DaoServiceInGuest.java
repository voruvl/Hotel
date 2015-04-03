package volk.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Expression;

import volk.domain.Guest;
import volk.domain.ServiceInGuest;

public class DaoServiceInGuest extends Generic<ServiceInGuest> implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6050272051800151646L;

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

		String hql="delete from serviceInGuest where idguest="+serviceInGuest.getIdGuest().getId()+" and idservice= "+serviceInGuest.getIdService().getId();
		session.createSQLQuery(hql).executeUpdate();


	}

	@Override
	public Object getObjectPk(int key) {
		Guest guest = new Guest();
		guest.setId(key);
		List<ServiceInGuest> serviceInGuest = session
				.createCriteria(ServiceInGuest.class)
				.add(Expression.eq("idGuest", guest)).list();
		return serviceInGuest;
	}

}
