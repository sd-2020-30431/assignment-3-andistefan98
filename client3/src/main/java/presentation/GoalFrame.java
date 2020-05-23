package presentation;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entities.User;
import requests.UserRequests;


public class GoalFrame {
	
	private JFrame frmUpdateGoal;
	private JTextField caloriesGoalText;
	static User user ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GoalFrame window = new GoalFrame(user);
					window.frmUpdateGoal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GoalFrame(User user ) {
		
		this.user= user;
		initialize();	
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUpdateGoal = new JFrame();
		frmUpdateGoal.setTitle("Update Goal");
		frmUpdateGoal.setBounds(100, 100, 453, 320);
		frmUpdateGoal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUpdateGoal.getContentPane().setLayout(null);
		frmUpdateGoal.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 432, 273);
		frmUpdateGoal.getContentPane().add(panel);
		panel.setLayout(null);
		

		final JLabel lblErr = new JLabel("");
		lblErr.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		lblErr.setBounds(12, 37, 420, 85);
		panel.add(lblErr);
		
		JLabel lblEnterYourNew = new JLabel("Enter your new goal. How many calories are you going to eat?");
		lblEnterYourNew.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		lblEnterYourNew.setBounds(12, 37, 420, 85);
		panel.add(lblEnterYourNew);
		
		caloriesGoalText = new JTextField();
		caloriesGoalText.setBounds(114, 107, 169, 32);
		panel.add(caloriesGoalText);
		caloriesGoalText.setColumns(10);
		
		JButton btnUpdateGoal = new JButton("Update goal");
		btnUpdateGoal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdateGoal.setBounds(146, 163, 109, 38);
		btnUpdateGoal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 //   Optional<User> usr = service.getUserByUsername(user.get().getUsername())	;
			    
			    if(Integer.parseInt(caloriesGoalText.getText())>0) {
			    
			    try {
				//user.setCaloric_goal(Integer.parseInt(caloriesGoalText.getText()));	
				UserRequests.updateUser(user.getId(),Integer.parseInt(caloriesGoalText.getText()) );
			    }
			    catch(Exception ex) {
			    	lblErr.setText("Add a number bigger than 0 . ");
			      }
			    }
				//System.out.println(user.get().getCaloricGoal());
				
				//service.addUser(user.get());
				
				MainFrame frm = new MainFrame(user);
				frm.setVisible(true);
				frmUpdateGoal.dispose();
			}
		});
		panel.add(btnUpdateGoal);
		
		JButton backBtn = new JButton("Back");
		backBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		backBtn.setBounds(146, 222, 109, 38);
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame frm = new MainFrame(user);
				frm.setVisible(true);
				frmUpdateGoal.dispose();
			}
		});
		panel.add(backBtn);
		
				
	}

	public void setVisible(boolean b) {
		frmUpdateGoal.setVisible(b);
		
	}

}
