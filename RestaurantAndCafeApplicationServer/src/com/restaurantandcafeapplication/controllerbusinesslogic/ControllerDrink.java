package com.restaurantandcafeapplication.controllerbusinesslogic;

import com.restaurantandcafeapplication.service.DrinkService;
import com.restaurantandcafeapplication.service.GetDrinkService;
import com.restaurantandcafeapplication.systemoperations.GeneralSystemOperation;
import com.restaurantandcafeapplication.transfer.TransferClass;

public class ControllerDrink implements CommandBaseTransferObject {

	@Override
	public void execute(TransferClass transferClass) {
		// TODO Auto-generated method stub
		GeneralSystemOperation generalSystemOperation = null;
		switch (transferClass.getOperation()) {
		
		case GET_DRINK :
			
        generalSystemOperation = new GetDrinkService();
          break;
        
		case POST:
		generalSystemOperation = new DrinkService();
		break;
		
		case UPDATE:
		generalSystemOperation = new DrinkService();
		break;
		
		case DELETE :
		generalSystemOperation = new DrinkService();
		break;
			
		
        
         default:
        	  break;
		
		}
		 generalSystemOperation.executeSystemOperation(transferClass);
	}

}
