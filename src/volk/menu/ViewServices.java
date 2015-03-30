package volk.menu;

import java.sql.SQLException;

import volk.dao.DaoService;
import volk.domain.Service;

public class ViewServices extends AMenu {

	public ViewServices(AMenu parentMenu) {
		super(parentMenu);
		name = "View all \"SERVICES\"";
		
	}

	@Override
	public void callMenu() {
		table = new DaoService();
		try {
			for(Object service:table.select()){
				System.out.println((Service)service);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
