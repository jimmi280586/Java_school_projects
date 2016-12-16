package cd.view;

import cd.controller.CdController;

public interface CdView
{
   void start(CdController controller);
   void show(String value);
   String get(String what);
}
