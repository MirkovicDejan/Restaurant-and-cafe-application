package com.restaurantandcafeapplication.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class AdminForm extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public AdminForm() {
		setResizable(false);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnFood = new JButton("FOOD");
		btnFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FoodFrame ff = new FoodFrame();
					ff.setVisible(true);
					dispose();
			
				
				
			}
		});
		btnFood.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFood.setBounds(128, 54, 168, 51);
		contentPane.add(btnFood);
		
		JButton btnDrink = new JButton("DRINK");
		btnDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DrinkFrame df = new DrinkFrame();
				df.setVisible(true);
				dispose();
			}
		});
		btnDrink.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDrink.setBounds(128, 145, 168, 51);
		contentPane.add(btnDrink);
		
		JButton btnEmployess = new JButton("EMPLOYEES");
		btnEmployess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			EmployeesFrame ef = new EmployeesFrame();
			ef.setVisible(true);
			dispose();
			}
		});
		btnEmployess.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEmployess.setBounds(128, 222, 168, 51);
		contentPane.add(btnEmployess);
		
		JButton btnBills = new JButton("BILLS");
		btnBills.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BillFrame bf = new BillFrame();
				bf.setVisible(true);
				dispose();
				
			}
		});
		btnBills.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBills.setBounds(128, 313, 168, 51);
		contentPane.add(btnBills);
		
		JLabel imgBackgrond = new JLabel(new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\RestaurantAndCafeApplicationClient\\src\\com\\restaurantandcafeapplication\\imgform\\adminForm.jpg"));
		imgBackgrond.setBounds(0, 0, 446, 470);
		contentPane.add(imgBackgrond);
		
		
		
	}
}
