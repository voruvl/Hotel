package volk.menu;


public class ServicesInGuest extends AMenu {

	public ServicesInGuest(AMenu parentMenu) {
		super(parentMenu);
		name = "View guest services";

	}

	@Override
	public void callMenu() {
//		table = new DaoServiceInGuest();
//		DaoGuest guestDao = new DaoGuest();
//		DaoService serviceDao = new DaoService();
//		Guest guestTemp;
//		try {
//
//			for (Guest guest : guestDao.select()) {
//				System.out.println(guest);
//			}
//			System.out.println("Entering id guest");
//			guestTemp = guestDao.getObject(Functions.getInteger());
//			System.out.println(guestTemp+"\n List services:");
//			
//
//			int summa = 0;
//
////			List<ServiceInGuest> servInGuest = table.selectPk(
////					guestTemp.getId(), "idguest");
//
//			for (ServiceInGuest serviceInGuest : servInGuest) {
//				Service service = (Service) serviceDao.getObject(serviceInGuest
//						.getIdService());
//				String nameService = service.getNameService();
//				while (nameService.length() < 10)
//					nameService += " ";
//				System.out.println("\t" + nameService + "\t "
//						+ service.getPrice() + " BLR");
//				summa += service.getPrice();
//			}
//			System.out.println("\t------------------------------------");
//			System.out.println("\tThe total price of services " + summa
//					+ " BLR");
//
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//		}
	}
}
