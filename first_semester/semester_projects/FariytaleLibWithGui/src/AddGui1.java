


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



public class AddGui1 extends JPanel implements ActionListener
{

   private JButton Book;
   private JButton Cd;
   private JButton Dvd;
   private JButton Article;
   private JButton Customer;

   private JRadioButton student;
   private JRadioButton lecturer;

   private JLabel label1;
   private JLabel label2;
   private JLabel label3;
   private JLabel label4;
   private JLabel label5;

   private JTextField txtTitle;
   private JTextField txtIsbn;
   private JTextField txtAuthor;
  

   private JTextField titleCd;
   private JTextField ArtistCd;

   private JTextField titleDvd;
   private JTextField ArtistDvd;
   

   private JTextField titleArticle;
   private JTextField authorArticle;
  
   private JTextField magazineArticle;

   private JTextField txtName;
   private JTextField txtAddress;
   private JTextField txtEmail;
   private JTextField txtPhoneNumber;

   private JButton save;
 

   JPanel pbook;
   JPanel pcd;
   JPanel pDvd;
   JPanel pArticle;
   JPanel pCustomer;
   JPanel RButton;

   JPanel contentPane;

   JTextArea textArea;

   JPanel buttons;
   
 
   private String name;
   private String address;
   private String email;
   private String title;
   private String author;
   private String artist;
   private String magazine;
   private String isbn;
   private int phoneNumber;
   private int type;
   private MyDate date;


   @Override
   public void actionPerformed(ActionEvent e)
   {
      

   }



   public AddGui1() throws IOException
   {
      
     
      LibraryMaster library = new LibraryMaster();
      
      contentPane = new JPanel();
      contentPane.setLayout(new BorderLayout());

      contentPane.setSize(500, 360);
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
 
      setLayout(new BorderLayout());

    

      pbook = new JPanel();
      pcd = new JPanel();
      pDvd = new JPanel();
      pArticle = new JPanel();
      pCustomer = new JPanel();
      RButton = new JPanel();
      textArea = new JTextArea();
      textArea.setPreferredSize(new Dimension(130, 130));
      textArea.setLineWrap(true);
      textArea.setWrapStyleWord(true);
      JPanel buttons = new JPanel();

      

      RButton.setLayout(new GridLayout(5, 1, 20, 20));

      

      RButton.setBorder(BorderFactory.createTitledBorder("Chose What to Add"));

    
      Book = new JButton("Add Book");
      Cd = new JButton("Add CD");
      Dvd = new JButton("Add DVD");
      Article = new JButton("Add Article");
      Customer = new JButton("Add Customer");

     

      RButton.add(Book);
      RButton.add(Cd);
      RButton.add(Dvd);
      RButton.add(Article);
      RButton.add(Customer);

      

      pbook.setLayout(new FlowLayout());
      // Create border to the outJPanel
      pbook.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    

      label1 = new JLabel("Enter Title : ");
      txtTitle = new JTextField(18);
      label2 = new JLabel("Enter ISBN :");
      txtIsbn = new JTextField(18);
      label3 = new JLabel("Enter Author :");
      txtAuthor = new JTextField(18);
 
      pbook.add(label1);
      pbook.add(txtTitle);
      pbook.add(label2);
      pbook.add(txtAuthor);
      pbook.add(label3);
      pbook.add(txtIsbn);
    

      pbook.setBorder(BorderFactory.createTitledBorder("BOOK info"));

     

      label1 = new JLabel("Enter Title : ");
      titleCd = new JTextField(18);
      label2 = new JLabel("Enter Artist: ");
      ArtistCd = new JTextField(18);
 

      pcd.add(label1);
      pcd.add(titleCd);
      pcd.add(label2);
      pcd.add(ArtistCd);
     

      pcd.setBorder(BorderFactory.createTitledBorder("  CD Info "));

     

      label1 = new JLabel("Enter Title : ");
      titleDvd = new JTextField(18);
      label2 = new JLabel("Enter Artist: ");
      ArtistDvd = new JTextField(18);
   
      pDvd.add(label1);
      pDvd.add(titleDvd);
      pDvd.add(label2);
      pDvd.add(ArtistDvd);
    

      pDvd.setBorder(BorderFactory.createTitledBorder(" DVD Info "));

    

      label1 = new JLabel("Enter Title : ");
      titleArticle = new JTextField(18);
    
      label3 = new JLabel("Enter Author : ");
      authorArticle = new JTextField(18);
      label4 = new JLabel("Enter Magazine : ");
      magazineArticle = new JTextField(18);
     
      pArticle.add(label1);
      pArticle.add(titleArticle);
      pArticle.add(label3);
      pArticle.add(authorArticle);
      pArticle.add(label4);
      pArticle.add(magazineArticle);
 
      pArticle.setBorder(BorderFactory.createTitledBorder("ARTICLE info"));
      contentPane.add(pArticle);

    
      pCustomer = new JPanel();

      label1 = new JLabel("Enter Name : ");
      txtName = new JTextField(18);
      label2 = new JLabel("Enter Address: ");
      txtAddress = new JTextField(18);
      label3 = new JLabel("Enter Email : ");
      txtEmail = new JTextField(18);
      label4 = new JLabel("Enter PhoneNumber : ");
      txtPhoneNumber = new JTextField(18);

      pCustomer.add(label1);
      pCustomer.add(txtName);
      pCustomer.add(label2);
      pCustomer.add(txtAddress);
      pCustomer.add(label3);
      pCustomer.add(txtEmail);
      pCustomer.add(label4);
      pCustomer.add(txtPhoneNumber);

      student = new JRadioButton("Student ! ");
      lecturer = new JRadioButton("Lecturer !");

     
      ButtonGroup group2 = new ButtonGroup();

      group2.add(student);
      group2.add(lecturer);

      
      pCustomer.add(student);
      pCustomer.add(lecturer);

      pCustomer.setBorder(BorderFactory
            .createTitledBorder("    Customer Info    "));

      contentPane.add(pCustomer);

     

      textArea.setBorder(BorderFactory.createTitledBorder("   ADDED Info   "));
      textArea.setEditable(false);
      textArea.setText("");
    

      save = new JButton("Save");
      
      

      buttons.add(save);
     

      contentPane.add(RButton, BorderLayout.WEST);
      contentPane.add(pbook, BorderLayout.CENTER);
      contentPane.add(pcd, BorderLayout.CENTER);
      contentPane.add(pDvd, BorderLayout.CENTER);
      contentPane.add(pArticle, BorderLayout.CENTER);
      contentPane.add(pCustomer, BorderLayout.CENTER);
      contentPane.add(textArea, BorderLayout.EAST);
      contentPane.add(buttons, BorderLayout.SOUTH);

      setSize(500, 360);
    

      add(contentPane);
 

      Book.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
	         contentPane.add(RButton, BorderLayout.WEST);
	         contentPane.add(pbook, BorderLayout.CENTER);
	         contentPane.add(textArea, BorderLayout.EAST);
	         pbook.setVisible(true);
	         pcd.setVisible(false);
	         pDvd.setVisible(false);
	         pCustomer.setVisible(false);
	         pArticle.setVisible(false);

	         type = 1;
			
		}
	});
      
      Cd.addActionListener(new ActionListener() {
  		
		@Override
		public void actionPerformed(ActionEvent e)
		{
	         contentPane.add(RButton, BorderLayout.WEST);
	         contentPane.add(pcd, BorderLayout.CENTER);
	         contentPane.add(textArea, BorderLayout.EAST);
	         pbook.setVisible(false);
	         pcd.setVisible(true);
	         pDvd.setVisible(false);
	         pCustomer.setVisible(false);
	         pArticle.setVisible(false);

	         type = 2;
			
		}
	});
      
      Dvd.addActionListener(new ActionListener() {
  		
		@Override
		public void actionPerformed(ActionEvent e)
		{
	         contentPane.add(RButton, BorderLayout.WEST);
	         contentPane.add(pDvd, BorderLayout.CENTER);
	         contentPane.add(textArea, BorderLayout.EAST);
	         pbook.setVisible(false);
	         pcd.setVisible(false);
	         pDvd.setVisible(true);
	         pCustomer.setVisible(false);
	         pArticle.setVisible(false);

	         type = 3;
			
		}
	});
      
      Article.addActionListener(new ActionListener() {
  		
		@Override
		public void actionPerformed(ActionEvent e)
		{
	         contentPane.add(RButton, BorderLayout.WEST);
	         contentPane.add(pArticle, BorderLayout.CENTER);
	         contentPane.add(textArea, BorderLayout.EAST);
	         pbook.setVisible(false);
	         pcd.setVisible(false);
	         pDvd.setVisible(false);
	         pCustomer.setVisible(false);
	         pArticle.setVisible(true);

	         type = 4;
			
		}
	});
      
      Customer.addActionListener(new ActionListener() {
    		
  		@Override
  		public void actionPerformed(ActionEvent e)
  		{
  	         contentPane.add(RButton, BorderLayout.WEST);
  	         contentPane.add(pCustomer, BorderLayout.CENTER);
  	         contentPane.add(textArea, BorderLayout.EAST);
  	         pbook.setVisible(false);
  	         pcd.setVisible(false);
  	         pDvd.setVisible(false);
  	         pCustomer.setVisible(true);
  	         pArticle.setVisible(false);

  	         type = 5;
  			
  		}
  	});
      
      save.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			 if (type == 1)
	    	  {
	    		  title = txtTitle.getText();
	    		  author = txtAuthor.getText();
	    		  isbn = txtIsbn.getText();
	    		  
	    		  try {
	    			  
	    			 if(library.searchItem(title).getTitle().equals(title))
	    			  {
	    				  textArea.setText("item exists by title");
	    			  }
	    			  else{
					library.addItemToItemList(title, author, type, isbn);
					textArea.setText("item added");
	    			  }
				} catch (IOException e1)
	    		  {
					textArea.setText("could not add item");
					e1.printStackTrace();
				}
	    	  }	
			
			 if (type == 2)
	    	  {
	    		  title = titleCd.getText();
	    		  artist = ArtistCd.getText();
	    		  String empty = null;
	    		  
	    		  try {
	    			  
	    			  if(library.searchItem(title).getTitle().equals(title))
	    			  {
	    				  textArea.setText("item exists by title");
	    			  }
	    			  else{
					library.addItemToItemList(title, artist, type, empty);
					textArea.setText("item added");
	    			  }
				} catch (IOException e1)
	    		  {
					textArea.setText("could not add item");
					e1.printStackTrace();
				}
	    	  }
			 
			 if (type == 3)
	    	  {
	    		  title = titleDvd.getText();
	    		  artist = ArtistDvd.getText();
	    		  String empty = null;
	    		  
	    		  try {
	    			  
	    			  if(library.searchItem(title).getTitle().equals(title))
	    			  {
	    				  textArea.setText("item exists by title");
	    			  }
	    			  else{
					library.addItemToItemList(title, artist, type, empty);
					textArea.setText("item added");
	    			  }
				} catch (IOException e1)
	    		  {
					textArea.setText("could not add item");
					e1.printStackTrace();
				}
	    	  }
			 
			 if (type == 4)
	    	  {
	    		  title = titleArticle.getText();
	    		  author = authorArticle.getText();
	    		  magazine = magazineArticle.getText();
	    		  
	    		  try {
	    			  
	    			  if(library.searchItem(title).getTitle().equals(title))
	    			  {
	    				  textArea.setText("item exists by title");
	    			  }
	    			  else{
					library.addItemToItemList(title, author, type, magazine);
					textArea.setText("item added");
	    			  }
				} catch (IOException e1)
	    		  {
					textArea.setText("could not add item");
					e1.printStackTrace();
				}
	    	  }
			 
			 if (type == 5)
			 {
				  name = txtName.getText();
	    		  address = txtAddress.getText();
	    		  email = txtEmail.getText();
	    		  phoneNumber = Integer.parseInt(txtPhoneNumber.getText());
	    		  int type2;
	    		  
	    		  if(!(lecturer.isSelected() ==  true))
	    		  {
	    			  type2 = 2;
	    		  }
	    		  else
	    		  {
	    			  type2 = 1;
	    		  }
	    		  
	    		  
	    		  try {
	    			  
	    			  if(library.searchCustomer(name).getName().equals(name) 
	    					  || library.searchCustomer(email).getEmail().equals(email))
	    			  {
	    				  textArea.setText("item exists by name or email");
	    			  }
	    			  else{
					library.addCustomerToCustomerList(name, address, email, phoneNumber, type2);
					textArea.setText("item added");
	    			  }
				} catch (IOException e1)
	    		  {
					textArea.setText("could not add item");
					e1.printStackTrace();
				}
			 }
		}
	});
      
   }

  

   
   
  
   }


