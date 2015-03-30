package volk.menu;

public class MenuService extends AMenu {

	public MenuService(AMenu parentMenu) {
		super(parentMenu);
		name="Menu Services";
	}

	@Override
	public void callMenu() {
		getName();
	}

}
