package presentation;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import com.itextpdf.text.DocumentException;

import business.AbstractFactory;
import business.BurnDownRateCalculator;

import decorator.GreenReportDecorator;
import decorator.RedReportDecorator;
import decorator.ReportDecorator;
import entities.ColorType.colorTypes;
import entities.GroceryList;
import entities.Item;
import entities.PlainReport;
import entities.Report;
import entities.ReportType.reportTypes;
import entities.User;
import requests.ListRequests;



public class ReportsFrame {
	
	private JFrame frmReports;
	static User user; 

	static JTextPane textPane = new JTextPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportsFrame window = new ReportsFrame(user);
					window.frmReports.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param itemServ 
	 * @param listServ 
	 * @param service 
	 * @param user 
	 */
	public ReportsFrame(User user) {
		
		this.user= user;		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmReports = new JFrame();
		frmReports.setTitle("Reports");
		frmReports.setBounds(100, 100, 483, 415);
		frmReports.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmReports.getContentPane().setLayout(null);
		frmReports.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 465, 368);
		frmReports.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton WeeklyBtn = new JButton("Weekly");
		WeeklyBtn.setBounds(154, 40, 175, 57);
		WeeklyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				List<Item> usersLists = null;
				try {
					usersLists = ListRequests.getAll(user.getId());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
							
				List<Item> itemsOfUser = new ArrayList<Item>();
				
			 for(Item itm : usersLists) {
				 
				 itemsOfUser.add(itm);
				 
				}
			 
			 
		Report rep;
			//ReportFactory fct = new ReportFactory(reportTypes.Weekly , itemsOfUser); 
			 //AbstractFactory fct = ReportCreator.getFactory(reportTypes.Weekly, itemsOfUser);
			 colorTypes type = colorTypes.Green;
			try {
				type = BurnDownRateCalculator.getWasteColor(user);
			} catch (ParseException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			
			 			 
			 if(type == colorTypes.Red) {
				 
			  try {
				rep= new RedReportDecorator(new PlainReport(itemsOfUser),itemsOfUser) ;
			} catch (ParseException e1) {
				e1.printStackTrace();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (DocumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			 }
			 else {
				 
		      try {
		    	  System.out.println(itemsOfUser.toString());
				rep= new GreenReportDecorator(new PlainReport(itemsOfUser),itemsOfUser) ;
			} catch (ParseException e1) {
				e1.printStackTrace();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (DocumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			 }
				
		}
		});
		panel.add(WeeklyBtn);
		
	
		textPane.setBounds(64, 123, 317, 197);
		panel.add(textPane);
		
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(174, 333, 97, 25);
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame frm = new MainFrame(user);
				frm.setVisible(true);
				frmReports.dispose();
			}
		});
		panel.add(backBtn);
	}

	public void setVisible(boolean b) {
		frmReports.setVisible(b);
		
	}
	
	public static JTextPane forReportDisplay() {
		return textPane;
	}

}
