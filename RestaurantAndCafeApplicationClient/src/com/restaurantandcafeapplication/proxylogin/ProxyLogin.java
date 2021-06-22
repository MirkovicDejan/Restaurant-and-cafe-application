package com.restaurantandcafeapplication.proxylogin;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.restaurantandcafeapplication.domainclass.Employees;
import com.restaurantandcafeapplication.view.AdminForm;
import com.restaurantandcafeapplication.view.EmpLogin;




public class ProxyLogin extends JFrame implements Proxy {

	public void login(Employees employees) {
		
		if(employees.getWorkRole() == 1) {
			
			AdminForm af = new AdminForm();
		    af.setVisible(true);
		    
			
			
		}else if(employees.getWorkRole() == 2) {
			EmpLogin el = new EmpLogin(employees.getIdEmployees(),employees.getNameAndSurname());
		    el.setVisible(true);
		    
		    
			
		}else {
			JOptionPane.showMessageDialog(null, " TRY AGIN !!! ");
		}
		
		
	}

}
