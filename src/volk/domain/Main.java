package volk.domain;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import volk.config.LoadProperties;
import volk.util.HibernateUtil;

@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) throws SQLException {

		LoadProperties property = new LoadProperties("config.conf");
		HibernateUtil.getSessionFactory().openSession();
		new Server(property);
		 

	}

}
