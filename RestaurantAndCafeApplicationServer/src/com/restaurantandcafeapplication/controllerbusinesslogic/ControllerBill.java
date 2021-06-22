package com.restaurantandcafeapplication.controllerbusinesslogic;

import com.restaurantandcafeapplication.service.BillDrinkDeleteService;
import com.restaurantandcafeapplication.service.BillFoodDeleteService;
import com.restaurantandcafeapplication.service.BillFoodService;
import com.restaurantandcafeapplication.service.BillService;
import com.restaurantandcafeapplication.service.GetBillService;
import com.restaurantandcafeapplication.service.GetDrinkBillService;
import com.restaurantandcafeapplication.systemoperations.GeneralSystemOperation;
import com.restaurantandcafeapplication.transfer.TransferClass;

public class ControllerBill implements CommandBaseTransferObject {

	@Override
	public void execute(TransferClass transferClass) {
		// TODO Auto-generated method stub
		GeneralSystemOperation generalSystemOperation = null;
		
		switch(transferClass.getOperation()) {
		
		case GET_BILL : 
			
			generalSystemOperation = new GetBillService();
			break;
			
		case BILL_DRINK_TABLE :
			generalSystemOperation = new GetDrinkBillService();
			break;
		
		case DELETE :
			generalSystemOperation = new BillService();
			break;
			
		case POST_FOOD_BILL : 
			generalSystemOperation = new BillFoodService();
			break;
			
		case POST_DRINK_BILL : 
			generalSystemOperation = new BillService();
			break;
			
		case DELETE_FOOD_FROM_BILLS :
			generalSystemOperation = new BillFoodDeleteService();
			
			break;
		
		case DELETE_DRINK_FROM_BILLS :
			generalSystemOperation = new BillDrinkDeleteService();
			
			break;
			
	/*	case POST :
			generalSystemOperation = new BillService();
			break;*/
			
	
		
		default :
			break;
		
		}
		
		generalSystemOperation.executeSystemOperation(transferClass);
		
	}

}
