package com.restaurantandcafeapplication.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.restaurantandcafeapplication.domainclass.ConstantsControllerBusinessLogic;
import com.restaurantandcafeapplication.domainclass.ConstantsUserInterfaceController;
import com.restaurantandcafeapplication.domainclass.Drink;
import com.restaurantandcafeapplication.transfer.TransferClass;
import com.restaurantandcafeapplication.userinterfacecontroller.UserInterfaceController;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrinkFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfPrice;
	private JTable table;
	private JTextField tfSelectedDrink;
	private JTextField tfSelectedPrice;
    
	private DefaultTableModel dtm = new DefaultTableModel();
	List<Drink>listDrink = null;
	private int id;

	public DrinkFrame() {
		setResizable(false);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(10, 10, 64, 19);
		contentPane.add(lblName);
		
		JLabel lblPrice = new JLabel("PRICE");
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrice.setBounds(10, 72, 64, 16);
		contentPane.add(lblPrice);
		
		tfName = new JTextField();
		tfName.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfName.setBounds(94, 7, 271, 30);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		tfPrice = new JTextField();
		tfPrice.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfPrice.setBounds(94, 68, 271, 30);
		contentPane.add(tfPrice);
		tfPrice.setColumns(10);
		
		JButton btnInsertDrink = new JButton("INSERT DRINK");
		btnInsertDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = tfName.getText();
				String price = tfPrice.getText();
				if(!price.isEmpty() && !name.isEmpty()) {
			    double price2 = Double.parseDouble(price);
				Drink drink = new Drink();
				drink.setName(name);
				drink.setPrice(price2);
				
try {
	TransferClass transferClass = UserInterfaceController.getUserInterfaceController()
	.execute(TransferClass.createOperation(drink, ConstantsControllerBusinessLogic.POST, ConstantsUserInterfaceController.DRINK));
} catch (ClassNotFoundException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
} catch (IOException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
				
				}			
			}
		});
		btnInsertDrink.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnInsertDrink.setBounds(22, 120, 169, 39);
		contentPane.add(btnInsertDrink);
		
		JButton btnRefresh = new JButton("REFRESH");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				putDrinkInTable();
				tfName.setText("");
				tfPrice.setText("");
				tfSelectedDrink.setText("");
				tfSelectedPrice.setText("");
			}
		});
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRefresh.setBounds(383, 122, 169, 39);
		contentPane.add(btnRefresh);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 174, 552, 142);
		contentPane.add(scrollPane);
		
		table = new JTable(dtm);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				id = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
				String selectedName = table.getModel().getValueAt(row, 1).toString();
				String selectedPrice = table.getModel().getValueAt(row, 2).toString();
				tfSelectedDrink.setText(selectedName);
				tfSelectedPrice.setText(selectedPrice);
				
			}
		});
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		scrollPane.setViewportView(table);
		
		JLabel lblSelectedDrink = new JLabel("SELECTED DRINK :");
		lblSelectedDrink.setForeground(Color.WHITE);
		lblSelectedDrink.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSelectedDrink.setBounds(10, 336, 146, 30);
		contentPane.add(lblSelectedDrink);
		
		JLabel selectedPrice = new JLabel("SELECTED PRICE :");
		selectedPrice.setForeground(Color.WHITE);
		selectedPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		selectedPrice.setBounds(10, 380, 146, 30);
		contentPane.add(selectedPrice);
		
		tfSelectedDrink = new JTextField();
		tfSelectedDrink.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfSelectedDrink.setBounds(164, 339, 271, 30);
		contentPane.add(tfSelectedDrink);
		tfSelectedDrink.setColumns(10);
		
		tfSelectedPrice = new JTextField();
		tfSelectedPrice.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfSelectedPrice.setBounds(166, 383, 269, 30);
		contentPane.add(tfSelectedPrice);
		tfSelectedPrice.setColumns(10);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idUpdate = id;
				String name = tfSelectedDrink.getText();
				double price = Double.parseDouble(tfSelectedPrice.getText());
				
				Drink drink = new Drink();
				drink.setId(idUpdate);
				drink.setName(name);
				drink.setPrice(price);

try {
	TransferClass transferClass = UserInterfaceController.getUserInterfaceController()
	.execute(TransferClass.createOperation(drink, ConstantsControllerBusinessLogic.UPDATE, ConstantsUserInterfaceController.DRINK));
} catch (ClassNotFoundException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
} catch (IOException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(10, 442, 137, 39);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int deleteID = id;
				Drink deleteDrink = new Drink();
				deleteDrink.setId(deleteID);

try {
	TransferClass transferClass = UserInterfaceController.getUserInterfaceController()
	.execute(TransferClass.createOperation(deleteDrink, ConstantsControllerBusinessLogic.DELETE, ConstantsUserInterfaceController.DRINK));
} catch (ClassNotFoundException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
} catch (IOException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBounds(164, 442, 137, 39);
		contentPane.add(btnDelete);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminForm af = new AdminForm();
				af.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(415, 444, 137, 39);
		contentPane.add(btnBack);
		
		JLabel lblImg = new JLabel(new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\RestaurantAndCafeApplicationClient\\src\\com\\restaurantandcafeapplication\\imgform\\DrinkFrame.jpg"));
		lblImg.setBounds(0, 0, 573, 537);
		contentPane.add(lblImg);
		
		Object [] column = {"ID","NAME","PRICE"};
		dtm.addColumn(column[0]);
		dtm.addColumn(column[1]);
		dtm.addColumn(column[2]);
		
		
	}

	private void putDrinkInTable() {
		// TODO Auto-generated method stub
		try {
			listDrink = (List<Drink>) UserInterfaceController.getUserInterfaceController()
			.execute(TransferClass.createOperation(null, ConstantsControllerBusinessLogic.GET_DRINK, ConstantsUserInterfaceController.DRINK)).getResponse();
			dtm.setRowCount(0);
			for(Drink d : listDrink) {
				Object [] row = {d.getId(),d.getName(),d.getPrice()};
				dtm.addRow(row);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
