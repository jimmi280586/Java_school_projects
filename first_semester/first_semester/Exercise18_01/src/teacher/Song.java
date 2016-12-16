package teacher;

public class Song
{
   private String artist;
   private String title;
   private int length;
   
   public Song(String artist, String title, int length)
   {
      this.artist = artist;
      this.title = title;
      this.length = length;
   }

   public String getArtist()
   {
      return artist;
   }

   public String getTitle()
   {
      return title;
   }

   public int getLength()
   {
      return length;
   }
   
   public String toString()
   {
      return String.format("Song(%s, %s, %d)", this.artist, this.title, this.length);
   }
   
   public static void main(String[] args)
   {
      Song[] songs = { new Song("Bla", "saldæf", 876), new Song("Queen", "Bohemian Rhapsody", 876) };
      Song[] songsClone = songs.clone();
      for(Song song: songsClone)
      {
         System.out.println(song);
      }
   }
}
