package volk.menu;

import java.sql.SQLException;
import java.util.List;

import volk.dao.DaoGuest;
import volk.dao.DaoNumer;
import volk.dao.DaoStateNumer;
import volk.domain.Guest;
import volk.domain.Numer;

public class ViewNotEmptyNumbers extends AMenu {
	public ViewNotEmptyNumbers(AMenu parentMenu) {
		super(parentMenu);
		name = "View not empty numers";

	}

	@Override
	public void callMenu() {
		DaoStateNumer dao = new DaoStateNumer();
		DaoGuest guestDao = new DaoGuest();

		table = new DaoNumer();
		try {
			List<Numer> numers = table.select();
			List<Guest> guests = guestDao.select();

			for (int i = 0; i < numers.size(); i++) {
				for (int j = 0; j < guests.size(); j++) {
					if (guests.get(j).getNumer() == numers.get(i).getId()) {
						System.out.print(numers.get(i)
								+ " state "
								+ dao.getObject(numers.get(i).getState())
										.getNameState() + "\n");
						break;
					}
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
