package src.system.gui.result;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Add extends JFrame{
	
	private static final long serialVersionUID = -7912629317388049604L;

	public Add(){}

	public static void cat(JPanel display){
		
		display.removeAll();
		
		JPanel hold = new JPanel();
		hold.setBounds(1, 1, 534, 40);
		hold.setBackground(new Color(189, 136, 138));
		display.add(hold);
		
		JLabel category = new JLabel("Category");
		category.setBounds(225, 1, 309, 40);
		category.setFont(new Font("Arial", Font.PLAIN , 18));
		category.setForeground(Color.WHITE);
		hold.add(category);
		
		display.repaint();
	}
	
	public static void form(JPanel display1, JPanel display2){
		display1.removeAll();
		display2.removeAll();
		
		JPanel hold = new JPanel();
		hold.setBounds(1, 1, 534, 120);
		hold.setBackground(new Color(189, 136, 138));
		display1.add(hold);
		
		JLabel name = new JLabel("Name");
		name.setBounds(240, 1, 294, 40);
		name.setFont(new Font("Arial", Font.PLAIN , 18));
		name.setForeground(Color.WHITE);
		hold.add(name);		
		//---------------------------------------------------
		JPanel hold1 = new JPanel();
		hold1.setBounds(1, 159, 534, 120);
		hold1.setBackground(new Color(189, 136, 138));
		display1.add(hold1);
		
		JLabel history = new JLabel("History");
		history.setBounds(235, 1, 299, 40);
		history.setFont(new Font("Arial", Font.PLAIN , 18));
		history.setForeground(Color.WHITE);
		hold1.add(history);	
		//---------------------------------------------------
		JPanel hold2 = new JPanel();
		hold2.setBounds(1, 317, 534, 120);
		hold2.setBackground(new Color(189, 136, 138));
		display1.add(hold2);
		
		JLabel taste = new JLabel("Taste");
		taste.setBounds(240, 1, 294, 40);
		taste.setFont(new Font("Arial", Font.PLAIN , 18));
		taste.setForeground(Color.WHITE);
		hold2.add(taste);	
		//---------------------------------------------------
		JPanel hold3 = new JPanel();
		hold3.setBounds(1, 475, 534, 120);
		hold3.setBackground(new Color(189, 136, 138));
		display1.add(hold3);
		
		JLabel cookingTime = new JLabel("Cooking time");
		cookingTime.setBounds(220, 1, 314, 40);
		cookingTime.setFont(new Font("Arial", Font.PLAIN , 18));
		cookingTime.setForeground(Color.WHITE);
		hold3.add(cookingTime);
		//-------------------------------------------------
		display1.repaint();
		//-------------------------------------------------
		//-------------------------------------------------
		JPanel hold4 = new JPanel();
		hold4.setBounds(1, 1, 266, 120);
		hold4.setBackground(new Color(189, 136, 138));
		display2.add(hold4);
		
		JLabel growingStart = new JLabel("Growing start");
		growingStart.setBounds(75, 1, 219, 40);
		growingStart.setFont(new Font("Arial", Font.PLAIN , 18));
		growingStart.setForeground(Color.WHITE);
		hold4.add(growingStart);	
		//----------
		JPanel hold5 = new JPanel();
		hold5.setBounds(269, 1, 264, 120);
		hold5.setBackground(new Color(189, 136, 138));
		display2.add(hold5);
		
		JLabel growingEnd = new JLabel("Growing end");
		growingEnd.setBounds(80, 1, 214, 40);
		growingEnd.setFont(new Font("Arial", Font.PLAIN , 18));
		growingEnd.setForeground(Color.WHITE);
		hold5.add(growingEnd);
		//----------------------------------------------------
		JPanel hold6 = new JPanel();
		hold6.setBounds(1, 159, 534, 120);
		hold6.setBackground(new Color(189, 136, 138));
		display2.add(hold6);
		
		JLabel secondName = new JLabel("Second name");
		secondName.setBounds(208, 1, 341, 40);
		secondName.setFont(new Font("Arial", Font.PLAIN , 18));
		secondName.setForeground(Color.WHITE);
		hold6.add(secondName);	
		//----------------------------------------------------
		JPanel hold7 = new JPanel();
		hold7.setBounds(1, 317, 534, 120);
		hold7.setBackground(new Color(189, 136, 138));
		display2.add(hold7);
		
		JLabel origins = new JLabel("Origins");
		origins.setBounds(240, 1, 304, 40);
		origins.setFont(new Font("Arial", Font.PLAIN , 18));
		origins.setForeground(Color.WHITE);
		hold7.add(origins);	
		//----------------------------------------------------
		JPanel hold8 = new JPanel();
		hold8.setBounds(1, 475, 534, 120);
		hold8.setBackground(new Color(189, 136, 138));
		display2.add(hold8);
		
		JLabel subID = new JLabel("Country code");
		subID.setBounds(220, 1, 314, 40);
		subID.setFont(new Font("Arial", Font.PLAIN , 18));
		subID.setForeground(Color.WHITE);
		hold8.add(subID);
		//----------------------------------------------------
		display2.repaint();
	}

	public static void addDisp(JPanel display, String value) {
		JTextArea text = new JTextArea();
		text.setEditable(false);
		text.setText(value);// actual text
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		text.setBounds(1, 1, 534, 1000);
		text.setFont(new Font("Arial", Font.PLAIN, 13));
		display.add(text);
		display.repaint();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(1, 1, 534, 550);
		scrollPane.add(text);
		scrollPane.setViewportView(text);
		display.add(scrollPane);	
	}
}
