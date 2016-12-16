import java.util.Scanner;


public class ClassSongTest 
{

	public static void main(String[] args) 
	{
	//**from her
	//***from her	
	//**** from her
	//*****	from her
	//****** from her	
		String art;
		String tit;
		int len;
		
		
		Scanner keyboard = new Scanner(System.in);
				
		
			
		System.out.println("input artist name");
		art = keyboard.nextLine();
		System.out.println("input title");
		tit = keyboard.nextLine();
		System.out.println("input length");
		len = keyboard.nextInt();
		
		
		

		ClassSong song1 = new ClassSong(art, tit, len);
		//System.out.println(song1.toString());
		//** to her is assignment b
		ClassSong song2 = song1;
		//*** to her is assignment c
		ClassSong song3 = new ClassSong(art, tit, len);
		//**** to her is assignment d
		ClassSong song4 = null;
		//***** to her is assignment e
		
		System.out.println(song1 == song2);
		System.out.println(song1 == song3);
		System.out.println(song1 == null);
		System.out.println(song2 == song3);
		System.out.println(song2 == null);
		System.out.println(song3 == null);
		System.out.println(song4 == null);
		//****** to her is assignment f & g
	}

}
