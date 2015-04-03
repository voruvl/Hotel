package volk.domain;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import volk.config.LoadProperties;
import volk.dao.DaoGuest;
import volk.dao.DaoNumer;
import volk.dao.DaoService;
import volk.dao.DaoServiceInGuest;
import volk.dao.DaoStateNumer;
import volk.dao.Generic;
import volk.menu.CreateMainMenu;
import volk.rezult.GetRezult;

public class Server {

	private CreateMainMenu creatorMenu;
	private ServerSocket server;
	private Socket socket;
	private ObjectOutputStream to;
	private ObjectInputStream from;
	private static final int EXIT = 0;
	private static final int SELECT = 1;
	private static final int INSERT = 2;
	private static final int UPDATE = 3;
	private static final int DELETE = 4;
	private static final int SELECTPK = 5;
	private Generic table;
	Logger log = Logger.getLogger(Server.class);

	public Server(LoadProperties property) {

		try {
			server = new ServerSocket(property.getSOCKET_PORT());
			while (true) {
				createSocket();
				Object obj = receiveObject();

				if (obj instanceof Integer) {
					if ((Integer) obj == EXIT) {
						socket.close();
					} else {
						int command = (Integer) obj;

						Object table = receiveObject();

						if (command == SELECT) {

							selectTable(table);
						}
						if (command == INSERT) {

							insertTable(table);
						}
						if (command == UPDATE) {

							updateTable(table);
						}
						if (command == DELETE) {

							deleteTable(table);
						}
						if (command == SELECTPK) {

							selectpkTable(table);
						}
						
					}
				}
			}
		} catch (IOException e1) {

			e1.printStackTrace();

		}
	}


	public Generic getTableDao(Object obj) {
		Generic tableDao = null;
		if (obj instanceof Service) {

			tableDao = new DaoService();

		}
		if (obj instanceof Guest) {

			tableDao = new DaoGuest();
		}
		if (obj instanceof ServiceInGuest) {

			tableDao = new DaoServiceInGuest();
		}
		if (obj instanceof Numer) {

			tableDao = new DaoNumer();
		}
		if (obj instanceof StateNumer) {

			tableDao = new DaoStateNumer();
		}
		return tableDao;
	}

	private void updateTable(Object obj) {
		try {
			table = getTableDao(obj);

			table.update(obj);
		} catch (SQLException e) {
			System.out.println("Sql Exception");
		}

	}

	private void selectpkTable(Object obj) {
		int key = 0;
		try {
			if (obj instanceof Service) {
				obj = (Service) obj;
				table = new DaoService();
				key = ((Service) obj).getId();
			}
			if (obj instanceof Guest) {
				obj = (Guest) obj;
				table = new DaoGuest();
				key = ((Guest) obj).getId();
			}
			if (obj instanceof ServiceInGuest) {
				obj = (ServiceInGuest) obj;
				table = new DaoServiceInGuest();
				key = ((ServiceInGuest) obj).getIdGuest().getId();
			}
			if (obj instanceof Numer) {
				obj = (Numer) obj;
				table = new DaoNumer();
				key = ((Numer) obj).getId();
			}
			if (obj instanceof StateNumer) {
				obj = (StateNumer) obj;
				table = new DaoStateNumer();
				key = ((StateNumer) obj).getId();
			}
			sendObject(new GetRezult().getSelectPk(
					new GetRezult().getTypeDao(obj), key));
		} catch (SQLException e) {
			System.out.println("Sql Exception");
		}
	}

	private void deleteTable(Object obj) {
		try {
			table = getTableDao(obj);

			table.delete(obj);
		} catch (SQLException e) {
			System.out.println("Sql Exception");
		}
	}

	private void createSocket() {
		try {
			socket = server.accept();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	private void insertTable(Object obj) {
		try {
			table = getTableDao(obj);

			table.insert(obj);
		} catch (SQLException e) {
			System.out.println("Sql Exception");
		}
	}

	private void selectTable(Object obj) {

		try {

			sendObject(new GetRezult().getSelect(new GetRezult()
					.getTypeDao(obj)));
		} catch (SQLException e1) {
			log.error("Entering failed value for object= " + obj);

		}
	}

	public Object receiveObject() {
		Object recieve = null;
		try {
			from = new ObjectInputStream(socket.getInputStream());
			recieve = from.readObject();

		} catch (IOException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return recieve;
	}

	public void sendObject(Object object) {
		try {
			to = new ObjectOutputStream(socket.getOutputStream());
			to.writeObject(object);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
