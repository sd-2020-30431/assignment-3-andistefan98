package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import entities.Item;
//import entities.Observer;
import entities.User;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Optional;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MainFrame implements java.util.Observer{

	private JFrame frmMainMenu;
	static User user;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame(user);
					window.frmMainMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param srv 
	 * @param user 
	 * @param lsrv 
	 * @param itemServ 
	 */
	public MainFrame(User user) {
		 this.user = user;
		initialize();
       
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMainMenu = new JFrame();
		frmMainMenu.setTitle("Main Menu");
		frmMainMenu.setBounds(100, 100, 597, 561);
		frmMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainMenu.getContentPane().setLayout(null);
		frmMainMenu.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 579, 514);
		frmMainMenu.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewList = new JButton("New grocery list");
		btnNewList.setFont(new Font("Sylfaen", Font.PLAIN, 24));
		btnNewList.setBackground(Color.WHITE);
		btnNewList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				List<Item> intermList = new ArrayList<Item>();
				
				ListNameFrame lstName = new ListNameFrame(user,intermList);
				lstName.setVisible(true);
				frmMainMenu.dispose();
			
			}
		});
		btnNewList.setBounds(137, 13, 310, 67);
		panel.add(btnNewList);
		
		JButton btnSeeReports = new JButton("Show reports");
		btnSeeReports.setBackground(Color.WHITE);
		btnSeeReports.setForeground(Color.BLACK);
		btnSeeReports.setFont(new Font("Sylfaen", Font.PLAIN, 24));
		btnSeeReports.setBounds(137, 103, 310, 67);
		btnSeeReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReportsFrame frm = new ReportsFrame(user);
				frm.setVisible(true);
				frmMainMenu.dispose();
			}
		});
		panel.add(btnSeeReports);
		
		
		JButton btnGoal = new JButton("Update caloric goal");
		btnGoal.setFont(new Font("Sylfaen", Font.PLAIN, 24));
		btnGoal.setBackground(Color.WHITE);
		btnGoal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoalFrame frm = new GoalFrame(user);
				frm.setVisible(true);
				frmMainMenu.dispose();
			}
		});
		btnGoal.setBounds(137, 288, 310, 67);
		panel.add(btnGoal);
		
		JButton showAllBtn = new JButton("See all lists");
		showAllBtn.setFont(new Font("Sylfaen", Font.PLAIN, 24));
		showAllBtn.setBackground(Color.WHITE);
		showAllBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
										
					    
					   SeeAllListsFrame lstName = null;
					try {
						lstName = new SeeAllListsFrame(user);
					} catch (ParseException e1) {
		
						e1.printStackTrace();
					}
					
						
						lstName.setVisible(true);
						frmMainMenu.dispose();
					
			}
		});
		showAllBtn.setBounds(137, 196, 310, 67);
		panel.add(showAllBtn);
		
		JButton btnDonate = new JButton("Donate to local charities");
		btnDonate.setFont(new Font("Sylfaen", Font.PLAIN, 24));
		btnDonate.setBounds(137, 383, 310, 67);
		btnDonate.setBackground(Color.WHITE);
		btnDonate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DonationFrame frm=null;
				try {
					frm = new DonationFrame(user);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frm.setVisible(true);
				frmMainMenu.dispose();
			}
		});
		panel.add(btnDonate);
		
		
		JLabel lblUser = new JLabel("Hello " + user.getUsername()) ; //" ! Current goal: " +getCaloric_goal());
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUser.setBounds(198, 471, 196, 35);
		panel.add(lblUser);
		
		
	}
	
	
	public static void popOutWindow() {
		
	
        
	final JFrame parent = new JFrame();
    JButton button = new JButton();
  
    button.setText("Notification");
    parent.add(button);
    
   parent.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  
   parent.setSize(400,300);
   parent.setLocationRelativeTo(null);
   parent.setVisible(true);
       

    button.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            String name = JOptionPane.showInputDialog(parent,
                    "You have items that will expire in the next few days. Go to the Donate section !", null);
        }
    });
	 }


	public void setVisible(boolean b) {
		frmMainMenu.setVisible(b);
		
	}

	

	public void update(Observable o, Object arg) {
		popOutWindow();
	}

	

}
