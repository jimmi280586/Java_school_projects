package cd.view;
import cd.controller.Controller;

public interface CdView
{
   void start(Controller controller);
   void show(String value);
   String get(String what);
}
