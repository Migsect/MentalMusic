package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Window extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JButton btnToggle;

	public Window(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(new Dimension(400, 500));
		setResizable(false);
		getContentPane().setLayout(null);
		
		addButtons();
		
		setVisible(true);
	}
	
	private void addButtons(){
		btnToggle = new JButton();
		
		btnToggle.setText("Start");
		btnToggle.setBounds(100,100,200,100);
		
		btnToggle.addActionListener(new ButtonListener());
		
		getContentPane().add(btnToggle);
	}
	
	class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(btnToggle.getText() == "Start"){
				btnToggle.setText("Stop");
				//do things to start
			}else{
				btnToggle.setText("Start");
				//do stopping things
			}
		}
	}
}
