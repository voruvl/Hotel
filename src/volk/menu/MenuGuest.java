package volk.menu;

public class MenuGuest extends AMenu{

	public MenuGuest(AMenu parentMenu) {
		super(parentMenu);
		name="Menu Guests";
	}

	@Override
	public void callMenu() {
		getName();
	}

}
