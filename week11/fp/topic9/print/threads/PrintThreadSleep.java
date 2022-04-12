package fp.topic9.print.threads;

//refactored by Caspar
public class PrintThreadSleep extends AbstractPrintThread
{
   private int sleepAtNum;

   public PrintThreadSleep(int val, int sleepAtNum)
   {
      super(val);
      this.sleepAtNum = sleepAtNum;
   }

   @Override
   protected void doSomething(int i)
   {
      final long SLEEP_MS = 200;

      try
      {
         if (i == sleepAtNum)
            Thread.sleep(SLEEP_MS);
      }
      catch (InterruptedException ex)
      {
      }
   }
}