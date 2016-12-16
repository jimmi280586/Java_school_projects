/*
 * 09.02.2015 Original version
 */


package server;


import javax.swing.*;


public class AddressServerFrame
	extends JFrame
	implements AddressServerView
{
	private AddressServerController controller;
	
	
	JTextArea area = new JTextArea( 20, 50 );
	
	
	public AddressServerFrame( AddressServerController controller )
	{
		super( "Address Server" );
		
		this.controller = controller;
		
		area.setEditable( false );
		add( new JScrollPane( area ) );

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
}