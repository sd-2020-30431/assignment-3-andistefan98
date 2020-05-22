package presentation;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import business.ItemValidator;
import entities.GroceryList;
import entities.Item;
import entities.User;
import requests.ListRequests;

import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListModel;

public class SeeAllListsFrame {

	private JFrame frmGroceryLists;

	private JTextField textField;

	ItemValidator validator ;
	
	static User user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeeAllListsFrame window = new SeeAllListsFrame(user );
					window.frmGroceryLists.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param intermList 
	 * @param itemServ 
	 * @param listServ 
	 * @param service 
	 * @param user 
	 * @throws ParseException 
	 */
	public SeeAllListsFrame(User user) throws ParseException {
	
	this.user= user;
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ParseException 
	 */
	private void initialize() throws ParseException {
		frmGroceryLists = new JFrame();
		frmGroceryLists.setTitle("Grocery items");
		frmGroceryLists.setBounds(100, 100, 574, 477);
		frmGroceryLists.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGroceryLists.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 556, 430);
		frmGroceryLists.getContentPane().add(panel);
		//panel.setLayout(null);
				
		List<Item>lista = new ArrayList<Item>();
		
		try {
			lista =  ListRequests.getAll(user.getId());
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		

		final JList lsst = new JList( lista.toArray() );
	
		lsst.setBounds(100, 69, 320, 263);
		lsst.setVisibleRowCount(20);
		lsst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane_1 = new JScrollPane(lsst);
	    scrollPane_1.setBounds(100, 69, 280, 243);

		panel.add(scrollPane_1);
		

		
		JLabel lblAllItemsFor = new JLabel("All items for user : ");
		lblAllItemsFor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAllItemsFor.setBounds(111, 13, 141, 43);
		panel.add(lblAllItemsFor);
		
		JLabel lblUser = new JLabel("New label");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
	
		lblUser.setBounds(293, 13, 141, 43);
		
		
		
		
		
		panel.add(lblUser);
		
		JButton backBtn = new JButton("Back");
		backBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		backBtn.setBounds(210, 382, 121, 35);
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
						MainFrame lstName = new MainFrame(user);
						lstName.setVisible(true);
						frmGroceryLists.dispose();
					
			}
		});
		panel.add(backBtn);
		
		JLabel lblConsumedAnotherItem = new JLabel("Consumed another item?");
		lblConsumedAnotherItem.setBounds(392, 94, 152, 54);
		panel.add(lblConsumedAnotherItem);
		
		JLabel lblDateDay = new JLabel("Write date as dd/mm/yyyy");
		lblDateDay.setBounds(392, 166, 152, 16);
		panel.add(lblDateDay);
		
		textField = new JTextField();
		textField.setBounds(402, 195, 142, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		
		final JLabel lblInvalidDate = new JLabel("");
		lblInvalidDate.setBounds(434, 312, 87, 16);
		panel.add(lblInvalidDate);
	
		
		JButton consumedBtn = new JButton("Set as consumed");
		consumedBtn.setBounds(406, 248, 138, 35);
		consumedBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Item itm = (Item) lsst.getSelectedValue();
				Date date1= new Date();
			    try {
					 date1=new SimpleDateFormat("dd/MM/yyyy").parse(textField.getText());
				} catch (ParseException e1) {
					
				}
			    
			    
			    if(ItemValidator.checkConsumptionDate(date1)==true) {
			      itm.setConsumptionDate(textField.getText());
		          try {
					ListRequests.addItem(itm.getName(), itm.getQuantity(), itm.getCalorieValue(), String.valueOf(itm.getPurchaseDate()), String.valueOf(itm.getExpirationDate()), itm.getList(), String.valueOf(itm.getConsumptionDate()));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			      
			  
			    
			   }
			    else {
			    	lblInvalidDate.setText("Invalid date.");
			    	SeeAllListsFrame neww = null;
					try {
						neww = new SeeAllListsFrame(user);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			    	neww.setVisible(true);
			    	frmGroceryLists.dispose();
			    }	
					
			}
		});
		panel.add(consumedBtn);
		
		JLabel wasteLbl = new JLabel("");
		wasteLbl.setFont(new Font("Tahoma", Font.PLAIN, 17));
		wasteLbl.setBounds(126, 325, 361, 44);
	//	String mess = BurnDownRateCalculator.getWasteMessage(user,listServ, service,itemServ);
		//wasteLbl.setText(mess);
		panel.add(wasteLbl);
		

	}

	public void setVisible(boolean b) {
		frmGroceryLists.setVisible(b);
		
	}
}
