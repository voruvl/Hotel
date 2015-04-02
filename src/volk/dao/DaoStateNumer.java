package volk.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Expression;

import volk.domain.StateNumer;

public class DaoStateNumer extends Generic<StateNumer> implements Serializable {

	public DaoStateNumer() {
		super();

	}

	@Override
	public List<StateNumer> getSelectQuery() {
		return session.createCriteria(StateNumer.class).list();
	}

	@Override
	protected void insertObject(StateNumer stateNumber) {
		session.save(stateNumber);
	}

	@Override
	public void updateObject(StateNumer stateNumber) {
		session.update(stateNumber);

	}

	@Override
	public void deleteObject(StateNumer stateNumer) {
		session.delete(stateNumer);

	}

	@Override
	public StateNumer getObjectPk(int key) {

		List<StateNumer> stateNumer = session.createCriteria(StateNumer.class)
				.add(Expression.eq("id", key)).list();
		return stateNumer.get(0);
	}

	

}
