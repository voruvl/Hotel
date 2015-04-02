package volk.domain;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import volk.config.LoadProperties;
import volk.dao.DaoService;
import volk.dao.DaoServiceInGuest;
import volk.dao.Generic;
import volk.util.HibernateUtil;

public class Main {

	public static void main(String[] args) throws SQLException {

		LoadProperties property = new LoadProperties("config.conf");
		HibernateUtil.getSessionFactory().openSession();
		Server sevr= new Server(property);
		 

	}

}
