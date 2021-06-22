package com.restaurantandcafeapplication.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.restaurantandcafeapplication.domainclass.ConstantsControllerBusinessLogic;
import com.restaurantandcafeapplication.domainclass.ConstantsUserInterfaceController;
import com.restaurantandcafeapplication.domainclass.Employees;
import com.restaurantandcafeapplication.proxylogin.Proxy;
import com.restaurantandcafeapplication.proxylogin.ProxyLogin;
import com.restaurantandcafeapplication.transfer.TransferClass;
import com.restaurantandcafeapplication.userinterfacecontroller.UserInterfaceController;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JTextField tfName;
	private JPasswordField pfPassword;
	private JLabel lblImg;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the frame.
	 */
	public LoginForm() {
		setType(Type.POPUP);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 492, 637);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(60, 119, 65, 16);
		contentPane.add(lblName);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(60, 183, 105, 16);
		contentPane.add(lblPassword);
		
		tfName = new JTextField();
		tfName.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfName.setBounds(174, 115, 205, 23);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblTitle = new JLabel("Restaurant and Cafe application");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Stencil", Font.ITALIC, 16));
		lblTitle.setBounds(105, 10, 304, 42);
		contentPane.add(lblTitle);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = tfName.getText();
				String password = String.copyValueOf(pfPassword.getPassword());
				Employees empLogin = new Employees();
				empLogin.setNameAndSurname(name);
				empLogin.setPassword(password);
				
	try {
TransferClass transferClass = UserInterfaceController.getUserInterfaceController()
.execute(TransferClass.createOperation(empLogin,ConstantsControllerBusinessLogic.GET_EMPLOYEES, ConstantsUserInterfaceController.EMPLOYEES)) ;
					
					Employees employeeLogin = (Employees) transferClass.getResponse();
					Proxy proxy = new ProxyLogin();
					proxy.login(employeeLogin);
					
				
					
					
				
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(241, 255, 85, 32);
		contentPane.add(btnNewButton);
		
	
		pfPassword = new JPasswordField();
		pfPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		pfPassword.setBounds(175, 180, 204, 23);
		contentPane.add(pfPassword);
		
		lblImg = new JLabel(new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\RestaurantAndCafeApplicationClient\\src\\com\\restaurantandcafeapplication\\imgform\\rastaurantPhotoLoginForm.jpg"));
		lblImg.setBounds(0, 0, 488, 609);
		contentPane.add(lblImg);
		
		
	}
}
