package com.restaurantandcafeapplication.controllerbusinesslogic;

import com.restaurantandcafeapplication.service.EmployessGETMENANINGService;
import com.restaurantandcafeapplication.service.EmployessService;
import com.restaurantandcafeapplication.systemoperations.GeneralSystemOperation;
import com.restaurantandcafeapplication.transfer.TransferClass;

public class ControllerEmploye implements CommandBaseTransferObject {

	@Override
	public void execute(TransferClass transferClass) {
	
		GeneralSystemOperation generalSystemOperation = null;
		
		switch(transferClass.getOperation()) {
		
		case POST : 
			generalSystemOperation = new EmployessService();
			break;
			
		case GET_EMPLOYEES:
			generalSystemOperation = new EmployessService();
			break;
		
		case GET_MENAGING_EMPLOYEES:
			generalSystemOperation = new EmployessGETMENANINGService();
			break;
			
		case UPDATE:
			generalSystemOperation = new EmployessService();
			break;
		
		case DELETE:
			generalSystemOperation = new EmployessService();
			break;
			
			
		default :
			break;
		}
		generalSystemOperation.executeSystemOperation(transferClass);
	}
	
	

}
