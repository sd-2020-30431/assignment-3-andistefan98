package presentation;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entities.GroceryList;
import entities.Item;
import entities.User;
import requests.ListRequests;


public class NewListFrame {
	
	private JFrame frmGroceryList;
	
	
  
	private JTextField nameTxt;
	
	static List<Item> intermList;
	static User user;
	static GroceryList listt;
	
	//ListController control ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewListFrame window = new NewListFrame(user, listt,intermList);
					window.frmGroceryList.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NewListFrame(User user , GroceryList items, List<Item> intermList2 ) {
		this.user =user;

		this.listt = items; 
		
		this.intermList = intermList2;
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGroceryList = new JFrame();
		frmGroceryList.setTitle("Grocery List");
		frmGroceryList.setBounds(100, 100, 645, 446);
		frmGroceryList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGroceryList.getContentPane().setLayout(null);
		frmGroceryList.setLocationRelativeTo(null);
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 627, 399);
		frmGroceryList.getContentPane().add(panel);
		panel.setLayout(null);
		JList itemsScrollBar = new JList();
		if(intermList!=null) {
		if(intermList.size()>0) {
		itemsScrollBar = new JList( intermList.toArray());
		itemsScrollBar.setBounds(82, 42, 220, 271);
		}
		}
		else {
			itemsScrollBar = new JList();
			itemsScrollBar.setBounds(72, 32, 220, 271);
		}
		panel.add(itemsScrollBar);
	
		JButton btnAddItem = new JButton("Add Item");
		btnAddItem.setBackground(Color.ORANGE);
		btnAddItem.setFont(new Font("Sylfaen", Font.PLAIN, 24));
		btnAddItem.setBounds(384, 139, 185, 66);
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				NewItemFrame frmm = new NewItemFrame(user,listt,intermList);
				frmm.setVisible(true);
				frmGroceryList.dispose();
			
				//ListController.addNewItem(frmGroceryList,user,service, listServ, items ,itemServ,intermList);
			}
		});
		panel.add(btnAddItem);
		
		JButton btnSaveList = new JButton("Save list");
		btnSaveList.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		btnSaveList.setBounds(235, 341, 127, 45);
		btnSaveList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
			//System.out.println(nameTxt.getText());
			
			//items.setListName(nameTxt.getText());
			//ListController.saveList(frmGroceryList,user,service, listServ,items, itemServ);
				System.out.println("Saving list\n");
			try {
				System.out.println("In try\n");
				String strr = ListRequests.addList(user.getId(), listt.getListName());
				for(Item itm: intermList) {
					System.out.println(itm.getName());
					//if(isNumeric(Integer.parseInt(strr)))
					itm.setList(Integer.parseInt(strr));
					ListRequests.addItem(itm.getName(), itm.getQuantity(),itm.getCalorieValue() , String.valueOf(itm.getPurchaseDate()), String.valueOf(itm.getExpirationDate()), itm.getList(), "02/02/2025");
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			MainFrame newMainFrame =  new MainFrame(user);
			newMainFrame.setVisible(true);
			frmGroceryList.dispose();
			}
			
		});
		panel.add(btnSaveList);
		

		
	}

	public void setVisible(boolean b) {
		frmGroceryList.setVisible(b);
		
	}

}
