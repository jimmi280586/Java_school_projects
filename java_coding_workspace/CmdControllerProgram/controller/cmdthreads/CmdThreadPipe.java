package cmdthreads;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class CmdThreadPipe implements Runnable
{
	private final OutputStream outputStream_;
	private final InputStream inputStream_;
public CmdThreadPipe(InputStream inputstream, OutputStream outputStream)
{
      inputStream_ = inputstream;
      outputStream_ = outputStream;
  }

public void run()
  {
      try
      {
          final byte[] buffer = new byte[1024];
          for (int length = 0; (length = inputStream_.read(buffer)) != -1; )
          {
              outputStream_.write(buffer, 0, length);
          }
      }
      catch (Exception e)
      {
          e.printStackTrace();
      }
  }



public static void main(String[] args) throws InterruptedException, IOException 
{
	 
}
}