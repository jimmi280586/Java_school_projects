package cd.domain.mediator;
import cd.domain.model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import cd.domain.model.Cd;

public class CdTextFile implements CdPersistence
{
   private File file;

   public CdTextFile(String filename) throws IOException
   {
      file = new File(filename);
      if (file == null)
      {
         throw new FileNotFoundException(null);
      }
   }

   @Override
   public CdList load() throws FileNotFoundException
   {
      Scanner in = null;
      try
      {
         in = new Scanner(file);
         CdList cdList = new CdList();

         while (in.hasNext())
         {
            String[] lineToken = in.nextLine().split(";");
            String cdTitle = lineToken[0].trim();
            String cdArtist = lineToken[1].trim();
            int trackCount = Integer.parseInt(lineToken[2].trim());
            CdTrack[] tracks = new CdTrack[trackCount];
            for (int j = 0; j < trackCount; j++)
            {
               lineToken = in.nextLine().split(";");
               String trackTitle = lineToken[0].trim();
               String trackArtist = lineToken[1].trim();
               int day = Integer.parseInt(lineToken[2].trim());
               int month = Integer.parseInt(lineToken[3].trim());
               int year = Integer.parseInt(lineToken[4].trim());
               Time time = new Time(day, month, year);
               tracks[j] = new CdTrack(trackTitle, trackArtist, time);
            }
            Cd cd = new Cd(cdTitle, cdArtist, tracks);
            cdList.addCd(cd);
         }
         return cdList;
      }
      finally
      {
         in.close();
      }
   }

   @Override
   public void save(CdList cdList) throws FileNotFoundException
   {
      PrintWriter out = null;
      try
      {
         out = new PrintWriter(file);
         for (int i = 0; i < cdList.getNumberOfCds(); i++)
         {
            Cd cd = cdList.getCD(i);
            out.println(cd.getTitle() + "; " + cd.getArtist() + "; "
                  + cd.getnumberOfTracks());
            for (int j = 0; j < cd.getnumberOfTracks(); j++)
            {
               CdTrack track = cd.getTrack(j);
               Time length = track.getLength();
               out.println(track.getTitle() + "; " + track.getArtist() + "; "
                     + length.getHour() + "; " + length.getMinute() + "; "
                     + length.getSecond());
            }

         }
         out.flush();
      }
      finally
      {
         out.close();
      }

   }

   @Override
   public void save(Cd cd) throws IOException
   {
      PrintWriter out = null;
      try
      {
         FileWriter fileWriter = new FileWriter(file, true);
         out = new PrintWriter(fileWriter);
         out.println(cd.getTitle() + "; " + cd.getArtist() + "; "
               + cd.getnumberOfTracks());
         for (int j = 0; j < cd.getnumberOfTracks(); j++)
         {
            CdTrack track = cd.getTrack(j);
            Time length = track.getLength();
            out.println(track.getTitle() + "; " + track.getArtist() + "; "
                  + length.getHour() + "; " + length.getMinute() + "; "
                  + length.getSecond());
         }
         out.flush();
      }
      finally
      {
         out.close();
      }
   }

   @Override
   public void remove(Cd cd) throws IOException
   {
      // inefficient
      CdList list = load();

      for (int i = 0; i < list.getNumberOfCds(); i++)
      {
         if (list.getCD(i).getTitle().equals(cd.getTitle())
               && list.getCD(i).getArtist().equals(cd.getArtist()))
         {
            list.removeCdByIndex(i);
            break;
         }
      }     
      clear();
      save(list);
   }

   @Override
   public void clear() throws IOException
   {
      file.delete();
   }
}
