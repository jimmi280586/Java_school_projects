// This music collection is a collection of music albums using arrays.
// If you want to see the ArrayList version see MusicCollectionArrayList.
public class MusicCollection
{
   private int count;
   private MusicAlbum[] albums;
   
   public MusicCollection(int capacity)
   {
      // This is completely standard for a collection using arrays.
      // Note that this.albums is full of nothing (null).
      // We'll fill in albums later.
      this.count = 0;
      this.albums = new MusicAlbum[capacity];
   }
   
   public int getCount()
   {
      return this.count;
   }
   
   public MusicAlbum getAlbum(int i)
   {
      return this.albums[i];
   }
   
   // This is also standard. The trick is to realize that count
   // will always contain the first available index.
   // Try running this in your hand a few times, if it's not clear.
   public void addAlbum(MusicAlbum album)
   {
      this.albums[count] = album;
      this.count++;
   }
   
   // This is the same solution as the findVehicle in CarFerry (exercise 19.01)
   public MusicAlbum findAlbum(String title)
   {
      // Note that the loops goes to this.count, not this.albums.length.
      // The album has a lot of nulls at the end, and we don't want to see those.
      for(int i = 0; i < this.count; i++)
      {
         MusicAlbum currentAlbum = this.albums[i];
         if (title.equals(currentAlbum.getTitle()))
         {
            // This is the right album. Return it and leave the method immediately.
            return currentAlbum;
         }
         else
         {
            // Else nothing. We are not done searching, yet.
         }
      }
      // Now we are done searching, and apparently didn't find the album.
      // It is safe to return null.
      return null;
   }
}
