package volk.dao;

import java.sql.SQLException;
import java.util.List;

public interface IDaoGeneric<T> {

	public List<T> select() throws SQLException;

	public List<T> selectPk(int key) throws SQLException;
	
	public T getObject(int key) throws SQLException;

	public void insert(T t) throws SQLException;

	public void update(T t) throws SQLException;

	public void delete(T t) throws SQLException;

}
