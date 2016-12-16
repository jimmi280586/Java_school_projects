package cd.domain.model;



public class CdTrack
{
   private String title;
   private String artist;
   private Time length;

   public CdTrack(String title, String artist, Time length)
   {
      this.title = title;
      this.artist = artist;
      this.length = length;
   }

   public String getTitle()
   {
      return title;
   }

   public String getArtist()
   {
      return artist;
   }

   public Time getLength()
   {
      return length;
   }

   public String toString()
   {
      return "\"" + title + "\", " + artist + ", " + length;
   }

}
