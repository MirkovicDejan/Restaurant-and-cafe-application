package com.restaurantandcafeapplication.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.restaurantandcafeapplication.domainclass.ConstantsControllerBusinessLogic;
import com.restaurantandcafeapplication.domainclass.ConstantsUserInterfaceController;
import com.restaurantandcafeapplication.domainclass.Food;
import com.restaurantandcafeapplication.transfer.TransferClass;
import com.restaurantandcafeapplication.userinterfacecontroller.UserInterfaceController;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FoodFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfPrice;
	private JTextField tfSelectedName;
	private JTextField tfSelectedPrice;
	private JTable TableFood;
	private DefaultTableModel dtm = new DefaultTableModel();
	private List<Food>listFood = null;
	private int row;
	private String remove;
    private String price;
    private int id;
	


	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public FoodFrame()  {
		setResizable(false);
		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfName = new JTextField();
		tfName.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfName.setBounds(91, 12, 292, 26);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(10, 10, 86, 29);
		contentPane.add(lblName);
		
		JLabel lblPrice = new JLabel("PRICE");
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrice.setBounds(10, 49, 86, 26);
		contentPane.add(lblPrice);
		
		tfPrice = new JTextField();
		tfPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfPrice.setBounds(91, 50, 292, 26);
		contentPane.add(tfPrice);
		tfPrice.setColumns(10);
		
		JButton btnNewButton = new JButton("INSERT FOOD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = tfName.getText();
				String price = tfPrice.getText();
				if(!price.isEmpty()&&!name.isEmpty()) {
				double price1 = Double.parseDouble(price);
				Food food = new Food();
		        food.setName(name);
				food.setPrice(price1);
				try {
					TransferClass transferClass = UserInterfaceController.getUserInterfaceController() 
      .execute(TransferClass.createOperation(food,ConstantsControllerBusinessLogic.POST,ConstantsUserInterfaceController.FOOD));
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
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(91, 85, 142, 36);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 141, 532, 164);
		contentPane.add(scrollPane);
		
		TableFood = new JTable(dtm);
		TableFood.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				row = TableFood.getSelectedRow();
				id = Integer.parseInt(TableFood.getModel().getValueAt(row, 0).toString());
				remove = TableFood.getModel().getValueAt(row, 1).toString();
				price = TableFood.getModel().getValueAt(row, 2).toString();
			    tfSelectedName.setText(remove);
			    tfSelectedPrice.setText(price);
			}
		});
		TableFood.setFont(new Font("Tahoma", Font.BOLD, 12));
		scrollPane.setViewportView(TableFood);
		
		JLabel lblSelectedFood = new JLabel("SELECTED FOOD :");
		lblSelectedFood.setForeground(Color.WHITE);
		lblSelectedFood.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSelectedFood.setBounds(10, 315, 147, 26);
		contentPane.add(lblSelectedFood);
		
		tfSelectedName = new JTextField();
		tfSelectedName.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfSelectedName.setBounds(10, 349, 292, 26);
		contentPane.add(tfSelectedName);
		tfSelectedName.setColumns(10);
		
		tfSelectedPrice = new JTextField();
		tfSelectedPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfSelectedPrice.setBounds(10, 393, 292, 26);
		contentPane.add(tfSelectedPrice);
		tfSelectedPrice.setColumns(10);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idUpdate = id;
				String name = tfSelectedName.getText();
				double price = Double.parseDouble(tfSelectedPrice.getText());
				Food updateFood = new Food();
				updateFood.setId(idUpdate);
		        updateFood.setName(name);
				updateFood.setPrice(price);
				
				try {
					TransferClass transferClass = UserInterfaceController.getUserInterfaceController().
							execute(TransferClass.createOperation(updateFood, ConstantsControllerBusinessLogic.UPDATE, ConstantsUserInterfaceController.FOOD));
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
		btnUpdate.setBounds(10, 429, 105, 33);
		contentPane.add(btnUpdate);
		
		JButton btnRemove = new JButton("DELETE");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int deleteId = id;
				//Double price = Double.valueOf(tfSelectedPrice.getText());
				Food deleteFood = new Food();
				deleteFood.setId(deleteId);
				//deleteFood.setPrice(price);
				
	try {
TransferClass transferClass = UserInterfaceController
.getUserInterfaceController().
execute(TransferClass.createOperation(deleteFood, ConstantsControllerBusinessLogic.DELETE, ConstantsUserInterfaceController.FOOD));
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnRemove.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRemove.setBounds(125, 429, 105, 35);
		contentPane.add(btnRemove);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminForm af = new AdminForm();
				af.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(449, 430, 93, 32);
		contentPane.add(btnBack);
		JButton btnRefresh = new JButton("REFRESH");
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				putFoodInTable();
				tfName.setText("");
				tfPrice.setText("");
				tfSelectedName.setText("");
				tfSelectedPrice.setText("");
			}
		});
		btnRefresh.setBounds(243, 86, 142, 35);
		contentPane.add(btnRefresh);
		
		
		
		
		Object [] column = {"ID","NAME","PRICE"};
		dtm.addColumn(column[0]);
		dtm.addColumn(column[1]);
		dtm.addColumn(column[2]);
		
		JLabel lblImg = new JLabel(new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\RestaurantAndCafeApplicationClient\\src\\com\\restaurantandcafeapplication\\imgform\\FoodFrame.jpg"));
		lblImg.setBounds(0, 0, 552, 486);
		contentPane.add(lblImg);
		
	
	
		
		
	}


	private void putFoodInTable() {
try {
listFood =
(List<Food>) UserInterfaceController.getUserInterfaceController()
.execute(TransferClass.createOperation(null, ConstantsControllerBusinessLogic.GET_FOOD, ConstantsUserInterfaceController.FOOD)).getResponse();
dtm.setRowCount(0);
for(Food f : listFood) {
	Object [] row = {f.getId(),f.getName(),f.getPrice()};
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
