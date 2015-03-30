package volk.menu;

import java.sql.SQLException;

import volk.dao.DaoService;
import volk.domain.Service;
import volk.util.Functions;

public class NewService extends AMenu {
	

	public NewService(AMenu parentMenu) {
		super(parentMenu);
		name = "Add new \"SERVICE\"";
		
	}

	@Override
	public void callMenu() {
		table = new DaoService();
		try {
			Service service = new Service();
			System.out.println("Enter name");
			service.setNameService(Functions.getString());
			System.out.println("Enter price");
			service.setPrice(Functions.getInteger());
			table.insert(service);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
