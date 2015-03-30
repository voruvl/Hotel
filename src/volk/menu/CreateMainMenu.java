package volk.menu;

import java.util.ArrayList;

import volk.util.Functions;


public class CreateMainMenu {

	public CreateMainMenu() {
		AMenu root = new MainMenu(null);
		AMenu menuNumer = new MenuNumer(root);
		AMenu menuGuest = new MenuGuest(root);
		AMenu menuService = new MenuService(root);
		new ExitProgramm(root);
		new ViewNumers(menuNumer);
		new ViewGuests(menuGuest);
		new ViewServices(menuService);
		new ViewCountNumber(menuNumer);
		new ViewNotEmptyNumbers(menuNumer);
		new NewNumer(menuNumer);
		new UpdateStateNumer(menuNumer);
		new CloningNumber(menuNumer);
		new NewGuest(menuGuest);
		new NewService(menuService);
		new DeleteService(menuService);
		new DeleteGuest(menuGuest);
		new ServicesInGuest(menuGuest);
		new ServiceAddGuest(menuGuest);
		AMenu menu = root;
		while (true) {
			System.out.println();
			System.out.println(menu.name);
			int numMenu = 1;
			if (menu.getSize() == 0) {
				menu.callMenu();
				menu = menu.getParent();
			}
			for (AMenu menuItem : (ArrayList<AMenu>) menu.getListMenu()) {

				System.out.println(numMenu++ + ". " + menuItem.name);
			}

			if ((menu.getParent() != null) && (menu.getSize() != 0))
				System.out.println(numMenu + ". " + "<-EXIT "
						+ menu.name.toUpperCase());

			int select = Functions.getInteger();

			if (select == (menu.getListMenu().size() + 1)) {
				menu = menu.getParent();

			} else {
				menu = menu.getItemMenu(select - 1);
			}
		}
	}
}
