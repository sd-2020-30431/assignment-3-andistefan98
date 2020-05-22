package presentation;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import org.apache.commons.lang3.StringUtils;

import business.BurnDownRateCalculator;
import entities.GroceryList;
import entities.Item;
import entities.User;
import requests.ListRequests;



public class DonationFrame {
	


	private JFrame frmDonate;
	static User user ;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DonationFrame window = new DonationFrame(user);
					window.frmDonate.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public DonationFrame(User user ) throws IOException, ParseException {
		
		this.user=user;
		
		initialize();
	}


	private void initialize() throws IOException, ParseException {
		frmDonate = new JFrame();
		frmDonate.setTitle("Donate");
		frmDonate.setBounds(100, 100, 685, 562);
		frmDonate.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDonate.getContentPane().setLayout(null);
		frmDonate.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 667, 515);
		frmDonate.getContentPane().add(panel);
		panel.setLayout(null);
		
		JList list = new JList();
		list.setBounds(72, 297, 163, -226);
		panel.add(list);
		
		
		
		  Iterable<Item> usersLists = ListRequests.getAll(user.getId());
			
			
			final List<Item> itemsOfUser = new ArrayList<Item>();
			
		 for(Item itm : usersLists) {
			
			 itemsOfUser.add(itm);
			}
			JScrollPane scrollPane_1 = new JScrollPane();
		    scrollPane_1.setBounds(46, 198, 280, 243);

		
			

			final JList lsst = new JList(itemsOfUser.toArray());
			scrollPane_1.setViewportView(lsst);
			lsst.setVisibleRowCount(20);
			lsst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			panel.add(scrollPane_1);
		
		JButton btnDonate = new JButton("Donate");
		btnDonate.setBackground(Color.ORANGE);
		btnDonate.setBounds(392, 286, 153, 47);
		btnDonate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Item selectedItem= (Item) lsst.getSelectedValue();
	
				int reqId = 0 ;
							
				
				for(Item itm: itemsOfUser) {
		
					
					if( Math.round(itm.getCalorieValue()) - Math.round(selectedItem.getCalorieValue()) == 0) {
						if(selectedItem.getQuantity() - itm.getQuantity() == 0) {
							
							reqId = itm.getId();
					 }
				  }
				}
				
				
				System.out.println(selectedItem.getName() + "    id :   " + reqId);
				
				try {
					ListRequests.removeItem(reqId);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//itemServ.deleteItem(selectedItem.getId());
				switchFrames();
				
				
			}
		});
		panel.add(btnDonate);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(274, 463, 153, 39);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame frm = new MainFrame(user);
				frm.setVisible(true);
				frmDonate.dispose();
			}
		});
		panel.add(btnBack);
		
		JLabel lblItemsThatWill = new JLabel("Items that will soon expire:");
		lblItemsThatWill.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblItemsThatWill.setBounds(102, 84, 224, 39);
		panel.add(lblItemsThatWill);

		
		
		List<Item> expiresSoon = new ArrayList<Item>();
		for(Item itmm : itemsOfUser) {
			 //LocalDate expirationLocal = BurnDownRateCalculator.convertToLocalDateViaInstant(itmm.getExpirationDate());
			 Calendar calendar = Calendar.getInstance();
			 Date now = new Date();
			 String beet = itmm.getExpirationDate();

			 Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(beet);  

			 long diff = date1.getTime() - now.getTime();
			    long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		       
		       if(days <= 2 && days >=-1 ) {
		    	   expiresSoon.add(itmm);
		       }
		}
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(368, 49, 251, 119);
		
		JList dueToExpireList = new JList(expiresSoon.toArray());
		dueToExpireList.setBounds(368, 49, 251, 119);
		scrollPane_2.setViewportView(dueToExpireList);
		dueToExpireList.setVisibleRowCount(7);
		//dueToExpireList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		panel.add(scrollPane_2);
		
		JLabel lblNewLabel = new JLabel("(next 2 days)");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(159, 120, 95, 16);
		panel.add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel(BurnDownRateCalculator.getWasteMessage(user));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(34, 26, 220, 25);
		panel.add(lblNewLabel_1);
	}
 
	public void setVisible(boolean b) {
		frmDonate.setVisible(b);
		
	 }  
	
	public void switchFrames() {
		
		frmDonate.setVisible(false);
		MainFrame frmDonate2 = new MainFrame(user);
		frmDonate2.setVisible(true);
	}

}
