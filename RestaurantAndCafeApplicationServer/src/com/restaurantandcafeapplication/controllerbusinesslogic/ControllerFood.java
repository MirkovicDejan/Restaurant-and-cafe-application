package com.restaurantandcafeapplication.controllerbusinesslogic;

import com.restaurantandcafeapplication.service.FoodGETService;
import com.restaurantandcafeapplication.service.FoodService;
import com.restaurantandcafeapplication.systemoperations.GeneralSystemOperation;
import com.restaurantandcafeapplication.transfer.TransferClass;

public class ControllerFood implements CommandBaseTransferObject {

	@Override
	public void execute(TransferClass transferClass) {
		// TODO Auto-generated method stub
		GeneralSystemOperation generalSystemOperation = null;
		
		switch(transferClass.getOperation()) {
		
		case POST:
			generalSystemOperation = new FoodService();
		break;
		
		case GET_FOOD:
			generalSystemOperation = new FoodGETService();
			break;
			
		case DELETE :
			generalSystemOperation = new FoodService();
		    break;
	  
		case UPDATE:
			generalSystemOperation = new FoodService();
			break;
		    
		default : 
			break;
		
		}
		 generalSystemOperation.executeSystemOperation(transferClass);
	}

}
