package intetface;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.*;




	public class SimpleWindow extends JFrame{
			
		private JPanel panel;
		private JLabel messageLabel;
		private JTextField kiloTextField;
		private JTextField kiloTextFieldA;
		private JTextField ReadOnly;
		private JButton calcButton;
		private JButton Red;
		private JRadioButton FButton;
		private JRadioButton FButton2;
		
		public SimpleWindow(){
			
			
		final int WINDOW_WIDTH = 350;
		final int WINDOW_HEIGHT = 250;
		
		buildPanel();
		add(panel);
		
		setTitle("A Simple Window");
		
		setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
		
		setLayout(new GridLayout(3,3));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pack();
		setVisible(true);
		
		}
		
		private void buildPanel(){
			
			messageLabel = new JLabel("Enter the value in kilometers");
			
			ReadOnly = new JTextField(10);
			ReadOnly.setEditable(false);
			ReadOnly.setText("NO EDITS HERE");
			
			kiloTextField = new JTextField(10);
			kiloTextFieldA = new JTextField(10);
			kiloTextFieldA.setEditable(false);
			
			calcButton = new JButton("Calculate");
			FButton = new JRadioButton("Choice one");
			FButton2 = new JRadioButton("Choice two");
			Red = new JButton("RED");
			
			ButtonGroup group = new ButtonGroup();
			group.add(FButton);
			group.add(FButton2);
			
			
			Red.addActionListener(new RedBut());
			
			FButton.addActionListener(new RedBut());
			FButton2.addActionListener(new Button2());
			
			calcButton.addActionListener(new CalcButtonListener());
			
			panel = new JPanel();
			panel.setBackground(Color.YELLOW);
			setLayout(new BorderLayout());
			panel.setBorder(BorderFactory.createTitledBorder("Calculate"));
			
			//panel.add(Red, BorderLayout.CENTER);
			
			panel.add(ReadOnly);
			panel.add(Red);
			panel.add(messageLabel);
			panel.add(kiloTextField);
			panel.add(kiloTextFieldA);
			
			panel.add(calcButton);
			panel.add(FButton);
			panel.add(FButton2);
			
		}
		
		
		private class Button2 implements ActionListener{
			public void actionPerformed(ActionEvent e){	
			if(FButton2.isSelected())
			{
				
			 panel.setBackground(Color.GREEN);
			}
				
			}	
		}
		
		
		private class RedBut implements ActionListener{
			public void actionPerformed(ActionEvent e){	
			panel.setBackground(Color.RED);
			
			messageLabel.setForeground(Color.BLUE);
				
			}
			
		}
		
		private class CalcButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				
				final double CONVERSION = 0.6214;
				String input;
				double miles;
				
				input = kiloTextField.getText();
				
				miles = Double.parseDouble(input) * CONVERSION;
				
				kiloTextFieldA.setText(Double.toString(miles));
				
				System.out.println(miles);
			}

			
			
		}
}
