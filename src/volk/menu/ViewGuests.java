package volk.menu;

import java.sql.SQLException;

import volk.dao.DaoGuest;
import volk.domain.Guest;

public class ViewGuests extends AMenu {

	public ViewGuests(AMenu parentMenu) {
		super(parentMenu);
		name = "View all guests";
		
	}

	@Override
	public void callMenu() {
		table = new DaoGuest();
		try {
			for(Object guest:table.select()){
				System.out.println((Guest)guest);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
