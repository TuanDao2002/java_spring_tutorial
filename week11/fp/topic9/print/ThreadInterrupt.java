package fp.topic9.print;

public class ThreadInterrupt {
	   public static void main(String[] args) {
	      System.out.println("Thread main started");
	      final Task task = new Task();
	      final Thread thread = new Thread(task);
	      thread.start();
	      thread.interrupt(); // calling interrupt() method
	      System.out.println("Main Thread finished");
	   }
	}
	class Task implements Runnable {
	   @Override
	   public void run() {
	      for (int i = 0; i < 5; i++) {
	         System.out.println("[" + Thread.currentThread().getName() + "] Message " + i);
	         if(Thread.interrupted()) {
	            System.out.println("This thread was interruped by someone calling this Thread.interrupt()");
	            System.out.println("Cancelling task running in thread " + Thread.currentThread().getName());
	            System.out.println("After Thread.interrupted() call, JVM reset the interrupted value to: " + Thread.interrupted());
	            break;
	         }
	      }
	   }
	}