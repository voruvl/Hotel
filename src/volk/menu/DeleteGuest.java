package volk.menu;

import java.sql.SQLException;

import volk.dao.DaoGuest;
import volk.domain.Guest;
import volk.util.Functions;


public class DeleteGuest extends AMenu {

	public DeleteGuest(AMenu parentMenu) {
		super(parentMenu);
		name = "Delete \"GUEST\"";
		
	}
	public void callMenu() {
		table = new DaoGuest();
		try {
			Guest guest = new Guest();
			System.out.println("Enter id deleting guest");
			guest.setId(Functions.getInteger());
			table.delete(guest);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
}
