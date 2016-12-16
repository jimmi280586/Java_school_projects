package cd.domain.model;

public class Cd 
{
   private String title;
   private String artist;
   private CdTrack[] track;

   public Cd(String title, String artist, CdTrack[] track)
   {
      this.title = title;
      this.artist = artist;
      this.track = track;
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
      int length = 0;
      for (int i = 0; i < track.length; i++)
      {
         length += track[i].getLength().getTimeInSeconds();
      }
      return new Time(length);
   }

   public CdTrack getTrack(int index)
   {
      return track[index];
   }

   public int getnumberOfTracks()
   {
      return track.length;
   }

   public String toString()
   {
      String CDText = "CD: \"" + title + "\", " + artist + ", " + getLength()
            + "\n";
      int length = CDText.length();
      String allTracksText = "";
      for (int i = 0; i < track.length; i++)
      {
         String trackText = "\ntrack #" + (i + 1) + ": " + track[i];
         if (length < trackText.length())
            length = trackText.length();
         allTracksText += trackText;
      }
      for (int i = 0; i < length; i++)
      {
         CDText += "-";
      }
      CDText += allTracksText;
      return CDText;
   }

 }
