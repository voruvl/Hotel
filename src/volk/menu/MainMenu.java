package volk.menu;


public class MainMenu extends AMenu {

	public MainMenu(AMenu parentMenu) {
		super(parentMenu);
		name = "Main menu";
	}

	@Override
	public void callMenu() {
		getName();
	}

	

}
