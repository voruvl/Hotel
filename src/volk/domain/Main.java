package volk.domain;

import java.sql.SQLException;
import java.util.List;

import volk.config.LoadProperties;
import volk.dao.DaoService;
import volk.dao.DaoServiceInGuest;
import volk.dao.Generic;

public class Main {

	public static void main(String[] args) throws SQLException {

		LoadProperties property = new LoadProperties("config.conf");
		 Server sevr= new Server(property);
//		DaoServiceInGuest ds = new DaoServiceInGuest();
//
//	
//		List<ServiceInGuest> si=ds.getObjectsList(1);
//		for (ServiceInGuest serviceInGuest : si) {
//			System.out.println(serviceInGuest.getIdGuest()+" "+serviceInGuest.getIdService());
//		}
//
//		System.exit(0);
	}

}
