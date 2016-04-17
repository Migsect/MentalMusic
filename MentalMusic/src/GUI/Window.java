package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import mentalMusic.MuseOscServer;
import mentalMusic.MuseReader;



public class Window extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JButton btnToggle;
	
	MuseOscServer server = new MuseOscServer();
	
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
				MuseReader mr = new MuseReader();
				//while (true) {
					//Muse-A168
					
				//mr.readAddress("/muse/eeg/quantization");
				
				server.connectToMuse("/muse/eeg/quantization");
				btnToggle.setText("Stop");
				//do things to start
			}else{
				server.disconnectMuse("/muse/eeg/quantization");
				btnToggle.setText("Start");
				//do stopping things
			}
		}
	}
}
