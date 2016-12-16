package cd.domain.mediator;

import java.io.IOException;
import cd.domain.model.*;

public interface CdPersistence
{
   public CdList load() throws IOException;
   public void save(CdList cdList) throws IOException;
   public void save(Cd cd) throws IOException;
   public void remove(Cd cd) throws IOException;
   public void clear() throws IOException;
}
