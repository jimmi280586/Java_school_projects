
public class Song
{
   // Declare class variables
   private String artist;
   private String title;
   private Duration length;
   
   // Constructor
   public Song(String artist, String title, Duration length)
   {
      this.artist = artist;
      this.title = title;
      this.length = length;
   }
   
   // Getters
   public String getArtist()
   {
      return this.artist;
   }
   
   public String getTitle()
   {
      return this.title;
   }

   public Duration getLength()
   {
      return this.length;
   }

   // Returns a string representation
   public String toString()
   {
      return String.format("Song(%s, %s, %d)", this.artist, this.title, this.length.toString());
   }
}
