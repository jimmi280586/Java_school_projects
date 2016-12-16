package teacher;

import java.util.ArrayList;

public class MusicCollectionArrayList
{
   // The count is no longer needed.
   private ArrayList<MusicAlbum> albums;
   
   // Never mind capacity - ArrayList is unlimited
   public MusicCollectionArrayList()
   {
      this.albums = new ArrayList<MusicAlbum>();
   }
   
   public int getCount()
   {
      return this.albums.size();
   }
   
   public MusicAlbum getAlbum(int i)
   {
      return this.albums.get(i);
   }
   
   // This is much easier that arrays.
   public void addAlbum(MusicAlbum album)
   {
      this.albums.add(album);
   }
   
   // This is the same solution as the findVehicle in CarFerry (exercise 19.01)
   public MusicAlbum findAlbum(String title)
   {
      // Note that the loops goes to this.count, not this.albums.length.
      // The album has a lot of nulls at the end, and we don't want to see those.
      for(int i = 0; i < this.albums.size(); i++)
      {
         MusicAlbum currentAlbum = this.albums.get(i);
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
