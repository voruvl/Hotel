package volk.menu;

import java.sql.SQLException;

import volk.dao.DaoNumer;
import volk.dao.DaoStateNumer;
import volk.domain.Numer;

public class ViewNumers extends AMenu {

	public ViewNumers(AMenu parentMenu) {
		super(parentMenu);
		name = "View all numers";
		
		
	}

	@Override
	public void callMenu() {
		DaoStateNumer dao=new DaoStateNumer();
		table = new DaoNumer();
		try {
			
			for(Object numer:table.select()){
				Numer numerNew =(Numer)numer;
				System.out.print(numerNew+" state ");
				System.out.println(dao.getObject(numerNew.getState()).getNameState());
				
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
