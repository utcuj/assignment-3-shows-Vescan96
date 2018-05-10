package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import javax.swing.JOptionPane;
import client.Client;
import model.Admin;
import model.User;
import view.Login;
import view.UserFrame;
import view.AdminFrame;

public class LoginManagement {
		
	private List<Object> list = new ArrayList<Object>();
	
	public LoginManagement(Login frame) {
		frame.setVisible(true);
	
		frame.validateUsernameEvent(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent event) {
				if( Character.isDigit(event.getKeyChar()) || Character.isWhitespace(event.getKeyChar()) )
					frame.SetValidationText("Invalid username!");
								
				if( event.getKeyChar() == KeyEvent.VK_ENTER)
					frame.SetValidationText("");
			}

			@Override
			public void keyReleased(KeyEvent arg0) {				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {				
			}
			
		});
		
		frame.registerEvent(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean pass = true;
				
				if(frame.getChckbxUser().isSelected() && frame.getChckbxAdmin().isSelected()) {
					JOptionPane.showMessageDialog(null, "please choose just one option!", "Error", JOptionPane.ERROR_MESSAGE);
					pass = false;
				}
				
				if(frame.getChckbxAdmin().isSelected() && pass) 
					JOptionPane.showMessageDialog(null, "already exist and administrator", "Error", JOptionPane.ERROR_MESSAGE);
				
				if(frame.getChckbxUser().isSelected() && pass) {
					String name = frame.getUserText();
					String password = frame.getPassText();
						
					list.clear();
					list.add(0);
					list.add(new User(name, password, null));
										
					new Client().registerUser(list);
				}					
			}
			
		});
		
		frame.loginEvent(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				boolean pass = true;
				
				if(frame.getChckbxUser().isSelected() && frame.getChckbxAdmin().isSelected()) {
					JOptionPane.showMessageDialog(null, "please choose just one option!", "Error", JOptionPane.ERROR_MESSAGE);
					pass = false;
				}
				
				if(frame.getChckbxAdmin().isSelected() && pass) {
					String name = frame.getUserText();
					String password = frame.getPassText();
					
					list.clear();
					list.add(1);
					list.add(new Admin(name, password));
					
					if(new Client().loginAdmin(list)) 
						new AdminManagement(new AdminFrame());
					else
						JOptionPane.showMessageDialog(null, "wrong username or password, or user doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);					
				}
				
				if(frame.getChckbxUser().isSelected() && pass) {
					String name = frame.getUserText();
					String password = frame.getPassText();
						
					User user = new User(name, password, null);
					
					list.clear();
					list.add(2);
					list.add(user);							
					
					if(new Client().loginUser(list))
						new UserManagement(user, new UserFrame());
					else
						JOptionPane.showMessageDialog(null, "wrong username or password, or user doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		});
	}
}
