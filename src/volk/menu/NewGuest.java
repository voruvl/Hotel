package volk.menu;

import java.sql.SQLException;

import volk.dao.DaoGuest;
import volk.dao.DaoNumer;
import volk.dao.DaoStateNumer;
import volk.domain.Guest;
import volk.domain.Numer;
import volk.util.Functions;

public class NewGuest extends AMenu {
	
	public NewGuest(AMenu parentMenu) {
		super(parentMenu);
		name = "Add new \"GUEST\"";
		
	}

	@Override
	public void callMenu() {
		table = new DaoGuest();
		DaoNumer numerDao=new DaoNumer();
		DaoStateNumer stateDao=new DaoStateNumer();
		try {
			Guest guest = new Guest();
			System.out.println("Enter name new guest");
			guest.setName(Functions.getString());
			System.out.println("Enter date input for new guest");
			guest.setDateIn(Functions.getDate() );
			System.out.println("Enter date output for new guest");
			guest.setDateOut(Functions.getDate());
			System.out.println("Selected id numer for new guest");
			
			for(Object numer:numerDao.select()){
				Numer numerNew =(Numer)numer;
				System.out.print(numerNew);
			}
			
			guest.setNumer(Functions.getInteger());
			table.insert(guest);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
