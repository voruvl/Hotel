package volk.menu;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import volk.dao.Generic;

public abstract class AMenu {
	protected List<AMenu> listMenu = new ArrayList<AMenu>();
	protected Connection connect;
	protected AMenu menuParent;
	protected String name;
	protected Generic table;

	public AMenu(AMenu parentMenu) {
		menuParent = parentMenu;
		
		if (parentMenu != null)
			parentMenu.listMenu.add(this);
	}

	public abstract void callMenu();

	public AMenu getItemMenu(int item) {
		return listMenu.get(item);
	}

	public List<AMenu> getListMenu() {
		return listMenu;
	}

	public AMenu getParent() {
		return menuParent;
	}

	public int getSize() {
		return listMenu.size();
	}

	public String getName() {
		return name;

	}
}
