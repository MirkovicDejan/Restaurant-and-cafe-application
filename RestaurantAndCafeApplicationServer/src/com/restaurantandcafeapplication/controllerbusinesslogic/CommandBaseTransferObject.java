package com.restaurantandcafeapplication.controllerbusinesslogic;

import com.restaurantandcafeapplication.transfer.TransferClass;

public interface CommandBaseTransferObject {

	void execute(TransferClass transferClass) ;
}
