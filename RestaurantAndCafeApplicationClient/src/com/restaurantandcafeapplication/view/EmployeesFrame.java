package com.restaurantandcafeapplication.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.restaurantandcafeapplication.domainclass.ConstantsControllerBusinessLogic;
import com.restaurantandcafeapplication.domainclass.ConstantsUserInterfaceController;
import com.restaurantandcafeapplication.domainclass.Employees;
import com.restaurantandcafeapplication.transfer.TransferClass;
import com.restaurantandcafeapplication.userinterfacecontroller.UserInterfaceController;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Window.Type;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EmployeesFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfName;
	private JPasswordField pfPassword;
	private JPasswordField pfTypeAginPassword;
	private DefaultTableModel dtm = new DefaultTableModel();
	private JTextField tfSelectedName;
	private JTextField tfSelectedPassword;
	private JTable tableEMP;
	private List<Employees>listEMP = null;
	private int id;
	

	
	

	/**
	 * Create the frame.
	 */
	public EmployeesFrame() {
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 631);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfName = new JTextField();
		tfName.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfName.setBounds(206, 23, 303, 33);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(10, 33, 58, 13);
		contentPane.add(lblName);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(10, 76, 96, 13);
		contentPane.add(lblPassword);
		
		JLabel lblConfrimPassword = new JLabel("TYPE AGIN PASSWORD");
		lblConfrimPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConfrimPassword.setBounds(10, 119, 186, 13);
		contentPane.add(lblConfrimPassword);
		
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = tfName.getText();
				String password = String.copyValueOf(pfPassword.getPassword());
				String aginPassword = String.copyValueOf(pfTypeAginPassword.getPassword());
				
				if(password.equals(aginPassword) && !name.isEmpty()) {
					Employees employees = new Employees();
					employees.setNameAndSurname(name);
					employees.setPassword(password);
					//employees.setWorkRole(2);
					
				
		try {
			TransferClass  transferClass = UserInterfaceController.getUserInterfaceController().execute(
			TransferClass.createOperation(employees,ConstantsControllerBusinessLogic.POST, ConstantsUserInterfaceController.EMPLOYEES));
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
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRegister.setBounds(388, 152, 123, 33);
		contentPane.add(btnRegister);
		
		pfPassword = new JPasswordField();
		pfPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		pfPassword.setBounds(206, 66, 303, 33);
		contentPane.add(pfPassword);
		
		pfTypeAginPassword = new JPasswordField();
		pfTypeAginPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		pfTypeAginPassword.setBounds(206, 109, 303, 33);
		contentPane.add(pfTypeAginPassword);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedName = tfSelectedName.getText();
				String selectedPassword = tfSelectedPassword.getText();
				
				if(!selectedPassword.isEmpty() && !selectedName.isEmpty()) {
					int idUpdate = id;
					Employees updateEmployees = new Employees();
					updateEmployees.setNameAndSurname(selectedName);
					updateEmployees.setPassword(selectedPassword);
					updateEmployees.setIdEmployees(idUpdate);
try {
	TransferClass transferClass = UserInterfaceController.getUserInterfaceController()
	.execute(TransferClass.createOperation(updateEmployees, ConstantsControllerBusinessLogic.UPDATE, ConstantsUserInterfaceController.EMPLOYEES));
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
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(10, 456, 128, 47);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int idDelete = id;
				
				Employees deleteEmployess = new Employees();
				deleteEmployess.setIdEmployees(idDelete);
				

	try {
		TransferClass transferClass = UserInterfaceController.getUserInterfaceController().
		execute(TransferClass.createOperation(deleteEmployess, ConstantsControllerBusinessLogic.DELETE, ConstantsUserInterfaceController.EMPLOYEES));
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
		btnDelete.setBounds(10, 513, 128, 47);
		contentPane.add(btnDelete);
		
		JButton btnBACK = new JButton("BACK");
		btnBACK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminForm af = new AdminForm();
				af.setVisible(true);
				dispose();
			}
		});
		btnBACK.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBACK.setBounds(414, 513, 128, 47);
		contentPane.add(btnBACK);
		
		JLabel lblSelectedName = new JLabel("SELECTED NAME");
		lblSelectedName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSelectedName.setBounds(10, 359, 122, 26);
		contentPane.add(lblSelectedName);
		
		JLabel lblSelectedPassword = new JLabel("SELECTED PASSWORD");
		lblSelectedPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSelectedPassword.setBounds(6, 402, 170, 30);
		contentPane.add(lblSelectedPassword);
		
		tfSelectedName = new JTextField();
		tfSelectedName.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfSelectedName.setBounds(186, 356, 303, 33);
		contentPane.add(tfSelectedName);
		tfSelectedName.setColumns(10);
		
		tfSelectedPassword = new JTextField();
		tfSelectedPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfSelectedPassword.setBounds(186, 403, 303, 33);
		contentPane.add(tfSelectedPassword);
		tfSelectedPassword.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 187, 536, 162);
		contentPane.add(scrollPane);
		
		tableEMP = new JTable(dtm);
		tableEMP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			int row = tableEMP.getSelectedRow();
			id = Integer.parseInt(tableEMP.getModel().getValueAt(row, 0).toString());
			String selectedName = String.valueOf(tableEMP.getModel().getValueAt(row, 1).toString());
			String selectedPassword = String.valueOf(tableEMP.getModel().getValueAt(row, 2).toString());	
			
			tfSelectedName.setText(selectedName);
			tfSelectedPassword.setText(selectedPassword);
			
			}
		});
		tableEMP.setFont(new Font("Tahoma", Font.BOLD, 12));
		scrollPane.setViewportView(tableEMP);
		
		JButton btnRefresh = new JButton("REFRESH");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				putEmpInTable();
				tfName.setText("");
				pfPassword.setText("");
				pfTypeAginPassword.setText("");
				tfSelectedName.setText("");
				tfSelectedPassword.setText("");
				
			}
		});
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRefresh.setBounds(15, 152, 123, 31);
		contentPane.add(btnRefresh);
		
		JLabel lblImage = new JLabel(new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\RestaurantAndCafeApplicationClient\\src\\com\\restaurantandcafeapplication\\imgform\\registerImg.jpg"));
		lblImage.setBounds(0, 0, 552, 603);
		contentPane.add(lblImage);
		
	
		
		Object [] column = {"ID","NAME AND SURNAME","PASSWORD","ROLE"};
		dtm.addColumn(column[0]);
		dtm.addColumn(column[1]);
		dtm.addColumn(column[2]);
		dtm.addColumn(column[3]);
		
		
		

	
	
	}

private void putEmpInTable() {
		// TODO Auto-generated method stub
try {
listEMP = (List<Employees>) UserInterfaceController.getUserInterfaceController()
 .execute(TransferClass.createOperation(null, ConstantsControllerBusinessLogic.GET_MENAGING_EMPLOYEES, ConstantsUserInterfaceController.EMPLOYEES)).getResponse();
	
dtm.setRowCount(0);

for(Employees empTable : listEMP) {
	
Object [] row = {empTable.getIdEmployees(),empTable.getNameAndSurname(),empTable.getPassword(),empTable.getWorkRole()};
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
