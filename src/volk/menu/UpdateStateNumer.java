package volk.menu;

import java.sql.SQLException;

import volk.dao.DaoNumer;
import volk.dao.DaoStateNumer;
import volk.domain.Numer;
import volk.domain.StateNumer;
import volk.util.Functions;

public class UpdateStateNumer extends AMenu {

	public UpdateStateNumer(AMenu parentMenu) {
		super(parentMenu);
		name = "Update state numer";

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
			System.out.println("Enter id numer");
			Numer numer = (Numer) table.getObject(Functions.getInteger());
			table = new DaoStateNumer();
			System.out.println("List states for numers");
			for (Object state : table.select()) {
				System.out.println((StateNumer) state);
			}
			System.out.println("Enter id state");
			numer.setState(Functions.getInteger());
			table = new DaoNumer();
			table.update(numer);
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
