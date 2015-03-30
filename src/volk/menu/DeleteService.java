package volk.menu;

import java.sql.SQLException;

import volk.dao.DaoGuest;
import volk.domain.Service;
import volk.util.Functions;

public class DeleteService extends AMenu {

	public DeleteService(AMenu parentMenu) {
		super(parentMenu);
		name = "Delete \"SERVICE\"";
		
	}

	@Override
	public void callMenu() {
		table = new DaoGuest();
		try {
			Service service = new Service();
			System.out.println("Enter id deleting service");
			service.setId(Functions.getInteger());
			table.delete(service);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
