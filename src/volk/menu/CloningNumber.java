package volk.menu;

import java.sql.SQLException;

import volk.dao.DaoNumer;
import volk.dao.DaoStateNumer;
import volk.domain.Numer;
import volk.util.Functions;

public class CloningNumber extends AMenu {

	public CloningNumber(AMenu parentMenu) {
		super(parentMenu);
		name = "Cloning number";

	}

	@Override
	public void callMenu() {
		DaoStateNumer dao = new DaoStateNumer();
		table = new DaoNumer();
		try {
			System.out.println("Select numer for cloning ");
			for (Object numer : table.select()) {
				Numer numerNew = (Numer) numer;
				System.out.print(numerNew);
			}
			System.out.println("Enter id");
			int numerId = Functions.getInteger();
			System.out.println("Enter count cloning");
			Numer num = (Numer) table.getObject(numerId);
			int count = Functions.getInteger();
			for (int i = 0; i < count; i++) {
				table.insert(num);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}