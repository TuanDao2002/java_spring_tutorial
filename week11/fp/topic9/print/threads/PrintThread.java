package fp.topic9.print.threads;

//refactored by Caspar
public class PrintThread extends AbstractPrintThread
{
   public PrintThread(int val)
   {
      super(val);
   }

   // default is to do nothing extra
   @Override
   protected void doSomething(int i)
   {
   }
}