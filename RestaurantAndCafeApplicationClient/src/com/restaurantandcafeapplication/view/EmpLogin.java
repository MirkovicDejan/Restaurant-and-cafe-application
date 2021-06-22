package com.restaurantandcafeapplication.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.restaurantandcafeapplication.domainclass.Bill;
import com.restaurantandcafeapplication.domainclass.BillThings;
import com.restaurantandcafeapplication.domainclass.ConstantsControllerBusinessLogic;
import com.restaurantandcafeapplication.domainclass.ConstantsUserInterfaceController;
import com.restaurantandcafeapplication.domainclass.Drink;
import com.restaurantandcafeapplication.domainclass.Employees;
import com.restaurantandcafeapplication.domainclass.Food;
import com.restaurantandcafeapplication.transfer.TransferClass;
import com.restaurantandcafeapplication.userinterfacecontroller.UserInterfaceController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.JRadioButton;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.naming.directory.SearchControls;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.TextArea;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmpLogin extends JFrame {
	

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel dtm = new DefaultTableModel();
	private DefaultTableModel billDtm = new DefaultTableModel();
	private JLabel idEmployyes;
	private Label lblNameAndSurnameEmployyes;
	private JLabel lblString;
	private JLabel lblNewLabel;
	private JRadioButton rdbFood;
	private JRadioButton rdbtnDrink;
	private List<Food> listFood = null;
	private List<Drink> listDrink = null;
	private List<BillThings>listForBill = new ArrayList<BillThings>();
	private JLabel lblNewLabel_1;
	private int idFoodDrink;
	private String nameFoodDrink;
	private double price;
    private JTable tableBill;
	BillThings bt = new BillThings();
	private JTextField tfTotal;
	private JButton btnDelete;
	private JTextField tfSerialNumber;
	private JButton btnINSERT;
	private JLabel lblIMG;
	private JTextField textField;
	private JTextField tfSearch;
	private JLabel lblSearch;
	private JButton btnSearch;
	
	
	
	



	


	/**
	 * Create the frame.
	 */
	public EmpLogin(int id , String name) {
		setResizable(false);
		
	    setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 892, 592);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 134, 868, 141);
		contentPane.add(scrollPane);
		
		table = new JTable(dtm);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				idFoodDrink = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
				nameFoodDrink = table.getModel().getValueAt(row, 1).toString();
				price = Double.parseDouble(table.getModel().getValueAt(row, 2).toString());
				
				bt.setIdFoodDrink(idFoodDrink);
				bt.setNameFoodDrink(nameFoodDrink);
				bt.setPrice(price);
				
				listForBill.add(bt);
				
			
			
				}
				
		});
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		scrollPane.setViewportView(table);
		
		rdbFood = new JRadioButton("FOOD");
		rdbFood.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdbFood.isSelected()) {
				rdbtnDrink.setVisible(false);
				putFoodInTable();
				lblSearch.setVisible(true);
		    	tfSearch.setVisible(true);
				btnINSERT.setVisible(true);
				btnDelete.setVisible(true);
			    btnSearch.setVisible(true);
				
				}else {
					rdbtnDrink.setVisible(true);
					dtm.setRowCount(0);
					lblSearch.setVisible(false);
			    	tfSearch.setVisible(false);
					btnINSERT.setVisible(false);
					btnDelete.setVisible(false);
					btnSearch.setVisible(false);
				}
			}
		});
		rdbFood.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbFood.setBounds(224, 60, 103, 21);
		contentPane.add(rdbFood);
		
	    rdbtnDrink = new JRadioButton("DRINK");
	    rdbtnDrink.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		if(rdbtnDrink.isSelected()) {
	    			rdbFood.setVisible(false);
	    			putDrinkInTheTable();
	    			lblSearch.setVisible(true);
	    	     	tfSearch.setVisible(true);
	    			btnINSERT.setVisible(true);
					btnDelete.setVisible(true);
					 btnSearch.setVisible(true);
	    		}else {
	    			rdbFood.setVisible(true);
	    			dtm.setRowCount(0);
	    			lblSearch.setVisible(false);
					tfSearch.setVisible(false);
					btnINSERT.setVisible(false);
					btnDelete.setVisible(false);
					 btnSearch.setVisible(false);
	    		}
	    		
	    		
	    	}
	    });
		rdbtnDrink.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnDrink.setBounds(549, 60, 103, 21);
		contentPane.add(rdbtnDrink);
		
		idEmployyes = new JLabel("");
		idEmployyes.setFont(new Font("Tahoma", Font.BOLD, 12));
		idEmployyes.setBounds(124, 10, 37, 28);
		idEmployyes.setText(String.valueOf(id));
		contentPane.add(idEmployyes);
	
		
		
	    lblNameAndSurnameEmployyes = new Label("");
		lblNameAndSurnameEmployyes.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNameAndSurnameEmployyes.setBounds(320, 10, 297, 28);
		lblNameAndSurnameEmployyes.setText(name);
		contentPane.add(lblNameAndSurnameEmployyes);
		
		lblString = new JLabel("ID EMPLOYYES");
		lblString.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblString.setBounds(10, 10, 104, 28);
		contentPane.add(lblString);
		
		lblNewLabel = new JLabel("NAME AND SURNAME :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(171, 10, 159, 28);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("BILL ITEMS :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(20, 292, 116, 21);
		contentPane.add(lblNewLabel_1);
		
		
		JLabel lblToalTXT = new JLabel("TOTAL :");
		lblToalTXT.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblToalTXT.setBounds(10, 470, 69, 21);
		contentPane.add(lblToalTXT);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(775, 583, 103, 40);
		contentPane.add(btnBack);
		
		 btnINSERT = new JButton("INSERT");
		btnINSERT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listBill();
				getSum();
				billThings();
				
			}
		});
		btnINSERT.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnINSERT.setBounds(116, 285, 145, 34);
		btnINSERT.setVisible(false);
		contentPane.add(btnINSERT);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 327, 868, 127);
		contentPane.add(scrollPane_1);
		
	    tableBill = new JTable(billDtm);
		tableBill.setFont(new Font("Tahoma", Font.BOLD, 12));
		scrollPane_1.setViewportView(tableBill);
		
		tfTotal = new JTextField();
		tfTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfTotal.setBounds(70, 467, 96, 31);
		contentPane.add(tfTotal);
		tfTotal.setColumns(10);
		
		btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 deleteItem();
				 subtractTheSum();  
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBounds(273, 285, 159, 34);
		btnDelete.setVisible(false);
		contentPane.add(btnDelete);
		
		JLabel lblSerialNumber = new JLabel("ENTER SERIAL NUMBER BILL :");
		lblSerialNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSerialNumber.setBounds(460, 282, 239, 40);
		contentPane.add(lblSerialNumber);
		
		tfSerialNumber = new JTextField();
		tfSerialNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfSerialNumber.setBounds(692, 283, 144, 40);
		contentPane.add(tfSerialNumber);
		tfSerialNumber.setColumns(10);
		
		JButton btnAllwaysShowDELETE = new JButton("DELETE");
		btnAllwaysShowDELETE.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//this btn delete only table
				deleteOnlyTable();	
				subtractTheSum();
				
				
			}
		});
		btnAllwaysShowDELETE.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAllwaysShowDELETE.setBounds(271, 285, 161, 34);
		contentPane.add(btnAllwaysShowDELETE);
		
	    lblSearch = new JLabel("SEARCH :");
	    lblSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
	    lblSearch.setBounds(224, 98, 69, 26);
	    lblSearch.setVisible(false);
		contentPane.add(lblSearch);
		
		tfSearch = new JTextField();
		tfSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfSearch.setBounds(331, 98, 321, 26);
		tfSearch.setVisible(false);
		contentPane.add(tfSearch);
		tfSearch.setColumns(10);
		
	    btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Search();
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearch.setBounds(662, 98, 96, 26);
		btnSearch.setVisible(false);
		contentPane.add(btnSearch);
		
		
		
		lblIMG = new JLabel(new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\RestaurantAndCafeApplicationClient\\src\\com\\restaurantandcafeapplication\\imgform\\empLog.jpg"));
		lblIMG.setBounds(0, 0, 888, 564);
		contentPane.add(lblIMG);
		
		
		
	
		
		
		
		Object [] column = {"ID","Name","Price"};
		dtm.addColumn(column[0]);
		dtm.addColumn(column[1]);
		dtm.addColumn(column[2]);
		
		Object [] column1 = {"ID","Name","Price"};
		billDtm.addColumn(column1[0]);
		billDtm.addColumn(column1[1]);
		billDtm.addColumn(column1[2]);
		
		
		
	
	
		
	
}


private void Search() {
		// TODO Auto-generated method stub
	Bill bill = new Bill();
	for(int i = 0; i<dtm.getRowCount();i++) {
	if(tfSearch.getText().equals(String.valueOf(dtm.getValueAt(i, 1)))) {
	    bill.setId(Integer.valueOf(dtm.getValueAt(i, 0).toString()));
	    bill.setName(String.valueOf( dtm.getValueAt(i, 1)));
	    bill.setPrice(Double.valueOf(dtm.getValueAt(i, 2).toString()));
	  
	}
		
	}
	 dtm.setRowCount(0);
	 Object [] row = {bill.getId(),bill.getName(),bill.getPrice()};
	 dtm.addRow(row);
}


private void deleteOnlyTable() {
		// TODO Auto-generated method stub
	if(tableBill.getSelectedRowCount() == 1) {
	billDtm.removeRow(tableBill.getSelectedRow());
    }else if(tableBill.getSelectedRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "EMPTY !!!");
		}else {
			JOptionPane.showMessageDialog(null, "Select before delete !");
		}
		
	}


private void subtractTheSum() {
		// TODO Auto-generated method stub
	double sum = 0;
	for(int i = 0; i<billDtm.getRowCount();i++) {
		sum = sum + Double.parseDouble(billDtm.getValueAt(i, 2).toString());
		tfTotal.setText(String.valueOf(sum));
		
		}
	if(billDtm.getRowCount() == 0) {
		tfTotal.setText("");
	}
	
	}


private void billThings() {
		// TODO Auto-generated method stub
	
	Bill bill = new Bill();
	if(!tfSerialNumber.getText().isEmpty()) {	
	if(rdbFood.isSelected()) {
		bill.setIdF(idFoodDrink);
		bill.setIdE(Integer.parseInt(idEmployyes.getText()));
	//	bill.setIdD(Integer.parseInt(null));
		bill.setPrice(price);
		bill.setSerialNumber(tfSerialNumber.getText());
		bill.setTotal(Double.parseDouble(tfTotal.getText()));
		
		 try {
				TransferClass transferClass = UserInterfaceController.getUserInterfaceController()
				.execute(TransferClass.createOperation(bill, ConstantsControllerBusinessLogic.POST_FOOD_BILL,ConstantsUserInterfaceController.BILLS));
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}else if(rdbtnDrink.isSelected()) {
		bill.setIdD(idFoodDrink);
		bill.setIdE(Integer.parseInt(idEmployyes.getText()));
	//	bill.setIdF(Integer.parseInt(null));
		bill.setPrice(price);
		bill.setSerialNumber(tfSerialNumber.getText());
		bill.setTotal(Double.parseDouble(tfTotal.getText()));
		
		
		 try {
				TransferClass transferClass = UserInterfaceController.getUserInterfaceController()
				.execute(TransferClass.createOperation(bill, ConstantsControllerBusinessLogic.POST_DRINK_BILL,ConstantsUserInterfaceController.BILLS));
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
 
		
}

}

	
	 
  


private void deleteItem() {
		// TODO Auto-generated method stub
	Bill deleteBill = new Bill();
	
	
	
	if(rdbFood.isSelected()) {
	
	if(tableBill.getSelectedRowCount() == 1) {
	//	int row = tableBill.getSelectedRow();
		deleteBill.setId( Integer.valueOf(billDtm.getValueAt(tableBill.getSelectedRow(), 0).toString()));
try {
	TransferClass transferClass = UserInterfaceController.getUserInterfaceController()
	.execute(TransferClass.createOperation(deleteBill,ConstantsControllerBusinessLogic.DELETE_FOOD_FROM_BILLS , ConstantsUserInterfaceController.BILLS));
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
billDtm.removeRow(tableBill.getSelectedRow());
	}else if(tableBill.getSelectedRowCount() == 0) {
		JOptionPane.showMessageDialog(null, "EMPTY !!!");
	}else {
		JOptionPane.showMessageDialog(null, "Select before delete !");
	}
	
	}if(rdbtnDrink.isSelected()) {
		if(tableBill.getSelectedRowCount() == 1) {
			//	int row = tableBill.getSelectedRow();
				deleteBill.setId( Integer.valueOf(billDtm.getValueAt(tableBill.getSelectedRow(), 0).toString()));
		try {
			TransferClass transferClass = UserInterfaceController.getUserInterfaceController()
			.execute(TransferClass.createOperation(deleteBill,ConstantsControllerBusinessLogic.DELETE_DRINK_FROM_BILLS , ConstantsUserInterfaceController.BILLS));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		billDtm.removeRow(tableBill.getSelectedRow());
			}else if(tableBill.getSelectedRowCount() == 0) {
				JOptionPane.showMessageDialog(null, "EMPTY !!!");
			}else {
				JOptionPane.showMessageDialog(null, "Select before delete !");
			}
		
	}
	}
	


private void getSum() {
		// TODO Auto-generated method stub
		double sum = 0;
		for(int i = 0; i<billDtm.getRowCount();i++) {
			sum = sum + Double.parseDouble(billDtm.getValueAt(i, 2).toString());
			tfTotal.setText(String.valueOf(sum));
		}
		
		
}

private void listBill() {
		// TODO Auto-generated method stub
		for(BillThings b : listForBill ) {
		    Object [] row = {b.getIdFoodDrink(),b.getNameFoodDrink(),b.getPrice()};
			billDtm.addRow(row);
			}
		    listForBill.clear();
		   
    }


private void putDrinkInTheTable() {
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











	private void putFoodInTable() {
		// TODO Auto-generated method stub
try {
	listFood = (List<Food>) UserInterfaceController.getUserInterfaceController()
	.execute(TransferClass.createOperation(null, ConstantsControllerBusinessLogic.GET_FOOD, ConstantsUserInterfaceController.FOOD)).getResponse();
	
	dtm.setRowCount(0);
	for(Food f : listFood) {
		Object row [] = {f.getId(),f.getName(),f.getPrice()};
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
	

