package volk.menu;

public class ExitProgramm extends AMenu {

	public ExitProgramm(AMenu parentMenu) {
		super(parentMenu);
		name = "Exit programm";
	}

	public void callMenu() {
		System.out.println("Close programm. Good bye.");
		System.exit(0);
	}
}
