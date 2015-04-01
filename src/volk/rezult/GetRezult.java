package volk.rezult;

import java.sql.SQLException;
import java.util.List;

import volk.dao.DaoGuest;
import volk.dao.DaoNumer;
import volk.dao.DaoService;
import volk.dao.DaoServiceInGuest;
import volk.dao.DaoStateNumer;
import volk.dao.Generic;
import volk.domain.Guest;
import volk.domain.Numer;
import volk.domain.Service;
import volk.domain.ServiceInGuest;
import volk.domain.StateNumer;

public class GetRezult {
	public Generic getTypeDao(Object obj) {
		Generic object = null;

		if (obj instanceof Service)
			object = new DaoService();
		if (obj instanceof Guest)
			object = new DaoGuest();
		if (obj instanceof ServiceInGuest)
			object = new DaoServiceInGuest();
		if (obj instanceof Numer)
			object = new DaoNumer();
		if (obj instanceof StateNumer)
			object = new DaoStateNumer();
		return object;
	}

	public List<?> getSelect(Generic tableDao) throws SQLException {

		return tableDao.select();
	}

	public Object getSelectPk(Generic tableDao, int key) throws SQLException {

		return tableDao.getObject(key);
	}

	public List<?> getSelectPkField(Generic tableDao, int key)
			throws SQLException {

		return tableDao.selectPk(key);
	}

	public Object getObject(Object obj) throws SQLException {
		Object rezult = null;
		try {
			if (obj instanceof Service)
				rezult = getTypeDao(obj).getObject(((Service) obj).getId());
			if (obj instanceof Guest)
				rezult = getTypeDao(obj).getObject(((Guest) obj).getId());
			if (obj instanceof ServiceInGuest)
				rezult = getTypeDao(obj).getObject(
						((ServiceInGuest) obj).getIdGuest().getId());
			if (obj instanceof Numer)
				rezult = getTypeDao(obj).getObject(((Numer) obj).getId());
			if (obj instanceof StateNumer)
				rezult = getTypeDao(obj).getObject(((StateNumer) obj).getId());
		} catch (Exception e) {
			System.out.println("exception");
		}
		return rezult;
	}

	public void insert(Object objectEntity) throws SQLException {
		getTypeDao(objectEntity).insert(objectEntity);

	}

	public void update(Generic daoObject, Object objectEntity)
			throws SQLException {
		daoObject.update(objectEntity);

	}

	public void delete(Generic daoObject, Object objectEntity)
			throws SQLException {
		daoObject.delete(objectEntity);

	}

}
