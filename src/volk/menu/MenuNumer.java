package volk.menu;

public class MenuNumer extends AMenu {

	public MenuNumer(AMenu parentMenu) {
		super(parentMenu);
		name = "Menu Numers";
	}

	@Override
	public void callMenu() {
		getName();

	}

}
