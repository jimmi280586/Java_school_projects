package cd.view;

import java.util.Observer;

import cd.controller.CdController;

public interface CdView extends Observer
{
   void start(CdController controller);
   void show(String value);
   String get(String what);
}
