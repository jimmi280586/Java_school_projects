package cd.domain.mediator;

import java.io.IOException;
import java.util.Observable;

import cd.domain.model.Cd;
import cd.domain.model.CdList;

public class CdModelManager extends Observable implements CdModel {
  private final String TEXT_FILE_NAME = "src/cds.txt";
  private CdList cdList;
  private CdPersistence storage;

  public CdModelManager() {
    try {
      this.storage = new CdTextFile(this.TEXT_FILE_NAME);
    } catch (IOException e) {
      e.printStackTrace();
    }
    try {
      this.cdList = storage.load();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public CdList getAll() {
    return this.cdList;
  }

  @Override
  public void addCD(Cd cd) {
    this.cdList.addCd(cd);
    setChanged();
    notifyObservers(cd);
  }

  @Override
  public Cd removeCD(String title) {
    setChanged();
    notifyObservers(title);
    return this.cdList.removeFirstCdByTitle(title);
  }

  @Override
  public CdList getCD(String title) {
    return this.cdList.getCdsByTitle(title);
  }

  @Override
  public int getNumberOfCds() {
    return this.cdList.getNumberOfCds();
  }

}
