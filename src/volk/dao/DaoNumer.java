package volk.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Expression;

import volk.domain.Numer;

public class DaoNumer extends Generic<Numer> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4627813057924508486L;

	public DaoNumer() {
		super();

	}

	@Override
	public List<Numer> getSelectQuery() {
		return session.createCriteria(Numer.class).list();
	}

	@Override
	protected void insertObject(Numer numer) {

		session.save(numer);

	}

	@Override
	public void updateObject(Numer numer) {

		session.update(numer);

	}

	@Override
	public void deleteObject(Numer numer) {

		session.delete(numer);

	}

	@Override
	public Numer getObjectPk(int key) {
		List<Numer> numer = session.createCriteria(Numer.class)
				.add(Expression.eq("id", key)).list();
		return numer.get(0);
	}

}
