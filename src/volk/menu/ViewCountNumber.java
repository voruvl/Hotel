package volk.menu;

import java.sql.SQLException;

import volk.dao.DaoNumer;

public class ViewCountNumber extends AMenu {

	public ViewCountNumber(AMenu parentMenu) {
		super(parentMenu);
		name = "View count numers";
		table = new DaoNumer();
	}

	@Override
	public void callMenu() {
		try {

			System.out.println("Count all numers in hotel "
					+ table.select().size());

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
