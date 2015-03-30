package volk.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.StaleStateException;

import volk.util.HibernateUtil;

public abstract class Generic<T> implements IDaoGeneric<T> {

	protected Connection connect;

	public abstract List<T> getSelectQuery();

	public abstract List<T> getObjectsList(int key);

	public abstract T getObjectPk(int key);

	protected abstract void insertObject(T t);

	public abstract void updateObject(T t);

	public abstract void deleteObject(T t);

	private Logger log = Logger.getLogger(Generic.class);

	protected Session session;

	public Generic() {
		session = HibernateUtil.getSessionFactory().openSession();
	}

	@Override
	public List<T> select() throws SQLException {
		List<T> list = new ArrayList<T>();
		list = getSelectQuery();
		return list;

	}

	@Override
	public T getObject(int key) throws SQLException {

		return getObjectPk(key);
	}

	@Override
	public List<T> selectPk(int key) throws SQLException {

		return getObjectsList(key);
	}

	@Override
	public void insert(T t) throws SQLException {
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
	}

	@Override
	public void update(T t) throws SQLException {
		session.beginTransaction();
		updateObject(t);
		session.getTransaction().commit();
	}

	@Override
	public void delete(T t) throws SQLException {
		session.beginTransaction();
		try{
		deleteObject(t);
		session.getTransaction().commit();
		}catch(StaleStateException e ){
			log.error("Not entering identifier");
		}
		
	}

}
