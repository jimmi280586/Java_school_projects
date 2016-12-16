
public class MusicAlbum
{
   private String title;
   private Song[] songs; // From the association
   
   public MusicAlbum(String title, Song[] songs)
   {
      this.title = title;
      this.songs = songs;
      // Alternatively: this.songs = songs.clone();
      // clone() is the array version of copy()
   }
   
   public String getTitle()
   {
      return title;
   }
   
   public int getNumberOfSongs()
   {
      return songs.length;
   }
   
   public Song getSong(int i)
   {
      return songs[i];
   }
   
   // This is a very common pattern:
   // 1. Create an accumulator variable with a neutral value (in this case: 0)
   // 2. Loop through the array (or ArrayList) adding the proper value from each element
   // 3. return the value of the accumulator variable.
   public int getTotalLength()
   {
      // 1:
      int totalLength = 0;
      // 2:
      for(int i = 0; i < this.songs.length; i++)
      {
         totalLength += songs[i].getLength();
      }
      // 3:
      return totalLength;
   }
}
