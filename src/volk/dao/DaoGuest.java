package volk.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Expression;

import volk.domain.Guest;

public class DaoGuest extends Generic<Guest> implements Serializable {

	@Override
	public List<Guest> getSelectQuery() {
		return session.createCriteria(Guest.class).list();

	}

	@Override
	protected void insertObject(Guest guest) {
		
		session.save(guest);
		

	}

	@Override
	public void updateObject(Guest guest) {
		
		session.update(guest);
	
	}

	@Override
	public void deleteObject(Guest guest) {
	
		session.delete(guest);
		
	}

	@Override
	public Guest getObjectPk(int key) {
		List<Guest> guest=session.createCriteria(Guest.class)
				.add(Expression.eq("id", key)).list();
		return guest.get(0);
	}

	@Override
	public List<Guest> getObjectsList(int key) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
