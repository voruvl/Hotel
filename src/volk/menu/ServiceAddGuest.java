package volk.menu;

import java.sql.SQLException;

import volk.dao.DaoGuest;
import volk.dao.DaoService;
import volk.dao.DaoServiceInGuest;
import volk.domain.Guest;
import volk.domain.Service;
import volk.domain.ServiceInGuest;



public class ServiceAddGuest extends AMenu {

	public ServiceAddGuest(AMenu parentMenu) {
		super(parentMenu);
		name = "Add service for GUEST";
		
	}

	@Override
	public void callMenu() {
		table = new DaoServiceInGuest();
		DaoGuest guestDao = new DaoGuest();
		DaoService serviceDao=new DaoService();
		ServiceInGuest serviceInGuest=new ServiceInGuest();
		try {
			
			for(Object guest:guestDao.select()){
				System.out.println((Guest)guest);
			}
			System.out.println("Entering id guest for inserting service");
			
//			serviceInGuest.setIdGuest(Functions.getInteger());
			
			for(Object service:serviceDao.select()){
				System.out.println((Service)service);}
			
			System.out.println("Entering id guest for inserting service");
			
//			serviceInGuest.setIdService(Functions.getInteger());
			
			table.insert(serviceInGuest);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
