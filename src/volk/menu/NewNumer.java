package volk.menu;

import java.sql.SQLException;

import volk.dao.DaoNumer;
import volk.domain.Numer;
import volk.util.Functions;

public class NewNumer extends AMenu {
	
	public NewNumer(AMenu parentMenu) {
		super(parentMenu);
		name = "Add new \"NUMER\"";
		
	}

	@Override
	public void callMenu() {
		table = new DaoNumer();
		try {
			Numer numer = new Numer();
			System.out.println("Enter count stars");
			numer.setStars(Functions.getInteger());
			System.out.println("Enter price new numer");
			numer.setPrice(Functions.getInteger());
			System.out.println("Enter count capacity new numer");
			numer.setCapacity(Functions.getInteger());
			numer.setState(1);
			table.insert(numer);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
