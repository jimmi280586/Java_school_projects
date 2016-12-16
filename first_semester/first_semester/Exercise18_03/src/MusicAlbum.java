
public class MusicAlbum
{
   // Declare class variables
   private String title;
   private Song[] songs;
   
   // Constructor
   public MusicAlbum(String title, Song[] songs)
   {
      this.title = title;
      this.songs = songs;
   }
   
   // Getter
   public String getTitle()
   {
      return this.title;
   }
   
   // Returns the length of the songs array
   public int getNumberOfSongs()
   {
      return this.songs.length;
   }
   
   // Return the song object at the designated index
   public Song getSong(int i)
   {
      return this.songs[i];
   }
   
   // Return the total length of all the songs in the album
   public int getTotalLength()
   {
      // Declare and initialize a variable to hold accumulated length
      int totalLength = 0;
      
      // Loop through the array
      for (int i = 0; i < this.songs.length; i++)
      {
         // Add the length of the song at the current index to the total length
         totalLength += this.songs[i].getLength().toSeconds();
      }
      
      // Return the total length
      // NOT FINISHED: just returns seconds, not very useful :\
      return totalLength;

   }
      
}
