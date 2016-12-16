/*
 * 10.02.2015 Original version
 */


package peer;


import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class PeerFrame
	extends JFrame
	implements PeerView, ActionListener
{
	private PeerController controller;
	
	
	JTextArea area = new JTextArea( 20, 50 );
	JTextField toTxt = new JTextField( 5 );
	JTextField msgTxt = new JTextField( 50 );
	JButton sendBtn = new JButton( "Send" );
	
	
	public PeerFrame( PeerController controller )
	{
		super( "Peer" );
		
		this.controller = controller;
		
		Box b = Box.createVerticalBox();
		
		area.setEditable( false );
		b.add( new JScrollPane( area ) );
		
		JPanel p = new JPanel( new FlowLayout( FlowLayout.LEFT ) );
		
		p.add( toTxt );
		p.add( msgTxt );
		p.add( sendBtn );
		
		sendBtn.addActionListener( this );
		
		b.add( p );
		add( b );

		pack();
		setLocationRelativeTo( null );
		setVisible( true );
		
		setDefaultCloseOperation( EXIT_ON_CLOSE );
	}
	
	
	public void println( String text )
	{
		area.append( text + "\n" );
		area.setCaretPosition( area.getText().length() );
	}
	
	
	public String inputAlias()
	{
		return JOptionPane.showInputDialog( "Alias" );
	}
	
	
	public void displayAlias( String alias )
	{
		setTitle( "Peer [alias=" + alias + "]" );
	}
	
	
	public void error( String text )
	{
		JOptionPane.showMessageDialog( null, text, "error", JOptionPane.ERROR_MESSAGE );
	}
	
	
	public void actionPerformed( ActionEvent ae )
	{
		if( ae.getSource() == sendBtn )
			controller.send( toTxt.getText(), msgTxt.getText() );
	}
}