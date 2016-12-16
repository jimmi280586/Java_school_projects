
public class ClassSong 
{
private String artist;
private String title;
private int length;

public ClassSong(String artist, String title, int length) {
	this.artist = artist;
	this.title = title;
	this.length = length;
}

public void setartist(String art)
{
	artist = art;
}
public void settitle(String tit)
{
	title = tit;
}
public void setlength(int len)
{
	length = len;
}

public String getartist()
{
	return artist;
}
public String gettitle()
{
	return title;
}
public Integer getlength()
{
	return length;
}
public void displaySong()
{
	System.out.println(this.toString());
}
public String toString()
{
	return artist + "," + title + "," + length;
}
}

