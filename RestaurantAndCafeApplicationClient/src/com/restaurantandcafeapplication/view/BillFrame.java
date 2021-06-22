package com.restaurantandcafeapplication.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.restaurantandcafeapplication.domainclass.Bill;
import com.restaurantandcafeapplication.domainclass.ConstantsControllerBusinessLogic;
import com.restaurantandcafeapplication.domainclass.ConstantsUserInterfaceController;
import com.restaurantandcafeapplication.transfer.TransferClass;
import com.restaurantandcafeapplication.userinterfacecontroller.UserInterfaceController;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BillFrame extends JFrame {

	private JPanel contentPane;
	private JTable TableBills;
	private JTextField tFName;
	private JTextField tfEmployees;
	private JTextField tfPricee;
	private DefaultTableModel dtm = new DefaultTableModel();
	private List<Bill>list = null;
	private List<Bill>listBillDrinkTable = null;
	private List<Bill>search = null;
	private int id;
	private String name;
	private String SerialNumber;
	private String employyes;
	private double price;
	private JTextField tfSerialNumber;
	private JTextField tfID;
	private JTextField tfSearch;
	private JLabel lblSearch;
	private JButton btnSearch;
	private JButton btnREFERSH;
	

	
	public BillFrame() {
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 929, 676);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 91, 905, 148);
		contentPane.add(scrollPane);
		
		TableBills = new JTable(dtm);
		TableBills.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = TableBills.getSelectedRow();
				tfID.setText(TableBills.getModel().getValueAt(row, 0).toString());
				tFName.setText(TableBills.getModel().getValueAt(row, 1).toString()); 
			    tfEmployees.setText(TableBills.getModel().getValueAt(row, 2).toString()); 
				tfPricee.setText(TableBills.getModel().getValueAt(row, 3).toString()); 
				tfSerialNumber.setText(TableBills.getModel().getValueAt(row, 4).toString()); 
				
				id = Integer.valueOf(tfID.getText());
				
				
			
				
			}
		});
		TableBills.setFont(new Font("Tahoma", Font.BOLD, 12));
		scrollPane.setViewportView(TableBills);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setBackground(Color.BLACK);
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(10, 361, 86, 21);
		contentPane.add(lblName);
		
		JLabel lblEmployees = new JLabel("EMPLOYEES");
		lblEmployees.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmployees.setBounds(10, 429, 94, 26);
		contentPane.add(lblEmployees);
		
		JLabel lblPrice = new JLabel("PRICE");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrice.setBounds(10, 491, 86, 21);
		contentPane.add(lblPrice);
		
		tFName = new JTextField();
		tFName.setFont(new Font("Tahoma", Font.BOLD, 12));
		tFName.setBounds(139, 347, 435, 51);
		contentPane.add(tFName);
		tFName.setColumns(10);
		
		tfEmployees = new JTextField();
		tfEmployees.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfEmployees.setColumns(10);
		tfEmployees.setBounds(139, 418, 435, 51);
		contentPane.add(tfEmployees);
		
		tfPricee = new JTextField();
		tfPricee.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfPricee.setColumns(10);
		tfPricee.setBounds(139, 479, 108, 48);
		contentPane.add(tfPricee);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int deleteId = id;
				
				Bill deleteBill = new Bill();
				deleteBill.setId(deleteId);
				
try {
	TransferClass transferClass = UserInterfaceController.getUserInterfaceController()
	.execute(TransferClass.createOperation(deleteBill, ConstantsControllerBusinessLogic.DELETE, ConstantsUserInterfaceController.BILLS));
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
		btnDelete.setBounds(10, 598, 108, 40);
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
		btnBack.setBounds(817, 598, 108, 40);
		contentPane.add(btnBack);
		
	    btnREFERSH = new JButton("REFRESH");
		btnREFERSH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtm.setRowCount(0);
				billInTable();
				billDrinkInTable();
				tfID.setText("");
				tFName.setText("");
				tfEmployees.setText("");
				tfPricee.setText("");
				tfSerialNumber.setText("");
		//		tfSearch.setText("");
				
				
				
			}
		});
		btnREFERSH.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnREFERSH.setBounds(807, 254, 108, 29);
		contentPane.add(btnREFERSH);
		
		JLabel lblSerialNumber = new JLabel("SERIAL NUMBER");
		lblSerialNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSerialNumber.setBounds(10, 553, 137, 21);
		contentPane.add(lblSerialNumber);
		
		tfSerialNumber = new JTextField();
		tfSerialNumber.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfSerialNumber.setColumns(10);
		tfSerialNumber.setBounds(139, 541, 435, 48);
		contentPane.add(tfSerialNumber);
		
		JLabel lblIDEmployye = new JLabel("ID_BILLS");
		lblIDEmployye.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIDEmployye.setBounds(10, 296, 78, 21);
		contentPane.add(lblIDEmployye);
		
		tfID = new JTextField();
		tfID.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfID.setColumns(10);
		tfID.setBounds(139, 282, 108, 51);
		contentPane.add(tfID);
		
	    lblSearch = new JLabel("SEARCH :");
		lblSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSearch.setBounds(23, 36, 86, 21);
		contentPane.add(lblSearch);
		
		tfSearch = new JTextField();
		tfSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfSearch.setColumns(10);
		tfSearch.setBounds(139, 22, 435, 51);
		contentPane.add(tfSearch);
		
	    btnSearch = new JButton("SEARCH");
	    btnSearch.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	dtm.setRowCount(0);
	    	SearchSerialFood();
	    	SearchSerialDrink();
	    		
	    	}
	    });
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearch.setBounds(605, 29, 108, 38);
		contentPane.add(btnSearch);
		
		JLabel lblIMG = new JLabel(new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\RestaurantAndCafeApplicationClient\\src\\com\\restaurantandcafeapplication\\imgform\\billFrame.jpg"));
		lblIMG.setBounds(0, 0, 925, 648);
		contentPane.add(lblIMG);
		

		
		Object [] column = {"ID","NAME","EMPLOYEES","PRICE","SERIAL NUMBER","TOTAL"};
		dtm.addColumn(column[0]);
		dtm.addColumn(column[1]);
		dtm.addColumn(column[2]);
		dtm.addColumn(column[3]);
		dtm.addColumn(column[4]);
		dtm.addColumn(column[5]);
		
		
	 
	
		
	}


	
	


	private void SearchSerialFood() {
		// TODO Auto-generated method stub
		String search = tfSearch.getText();
		for(Bill b : list) {
			if(search.equals(b.getSerialNumber())) {
				Object [] row = {b.getId(),b.getFood(),b.getEmployyes(),b.getPrice(),b.getSerialNumber(),b.getTotal()};
				dtm.addRow(row);
			}
			
		}
		
	}






	private void SearchSerialDrink() {
		// TODO Auto-generated method stub
		String search = tfSearch.getText();
		for(Bill b : listBillDrinkTable) {
	    	if(search.equals(b.getSerialNumber())) {
	    		Object [] row = {b.getId(),b.getDrink(),b.getEmployyes(),b.getPrice(),b.getSerialNumber(),b.getTotal()};
	    		dtm.addRow(row);
	    }
			
		}
		
			}
		
		
		

	private void billDrinkInTable() {
		
try {
	listBillDrinkTable = (List<Bill>) UserInterfaceController.getUserInterfaceController()
	.execute(TransferClass.createOperation(null, ConstantsControllerBusinessLogic.BILL_DRINK_TABLE, ConstantsUserInterfaceController.BILLS)).getResponse();
	
	
	for(Bill b : listBillDrinkTable) {
		Object [] row = {b.getId(),b.getDrink(),b.getEmployyes(),b.getPrice(),b.getSerialNumber(),b.getTotal()};
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


	private void billInTable() {
	
		try {
			list = (List<Bill>) UserInterfaceController.getUserInterfaceController().execute(TransferClass.createOperation(null, ConstantsControllerBusinessLogic.GET_BILL,ConstantsUserInterfaceController.BILLS)).getResponse();
			for(Bill b : list) {
				Object [] row = {b.getId(),b.getFood(),b.getEmployyes(),b.getPrice(),b.getSerialNumber(),b.getTotal()};
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
