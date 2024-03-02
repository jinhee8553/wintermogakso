
import java.awt.*;
import java.awt.event.*;
import java.time.*;
import javax.swing.*;


public class AnonymousInnerClassTest
{
   public static void main(String[] args) throws InterruptedException
   {
      var clock = new TalkingClock();
      clock.start(1000, true);

      Thread.sleep(10000);

      System.exit(0);
   }
}

 
class TalkingClock
{
   private int interval;
   private boolean beep;

   public void start(int interval, boolean beep)
   {
      // // anonymous inner class
      // var listener = new ActionListener()
      //    {
      //       public void actionPerformed(ActionEvent event)
      //       {
      //          System.out.println("At the tone, the time is " 
      //             + Instant.ofEpochMilli(event.getWhen()));
      //          //  if (beep) Toolkit.getDefaultToolkit().beep();
      //          // printing BEEP instead of making a sound
      //          if (beep) System.out.println("---BEEP---"); 

      //       }
      //    };
      // var timer = new Timer(interval, listener);
      // timer.start();

      // local inner class
      // this.interval = interval;
      // this.beep = beep;

      // var listener = new TimePrinter();
      // var timer = new Timer(interval, listener);
      // timer.start();




      //lambda expression
      var timer = new Timer(interval, event ->
      {
         System.out.println("At the tone, the time is " 
           + Instant.ofEpochMilli(event.getWhen()));
          //  if (beep) Toolkit.getDefaultToolkit().beep();
          // printing BEEP instead of making a sound
         if (beep) System.out.println("---BEEP---");
      });
      timer.start();
   }

   public class TimePrinter implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         System.out.println("At the tone, the time is " 
            + Instant.ofEpochMilli(event.getWhen()));
         //   if (beep) Toolkit.getDefaultToolkit().beep();
         // printing BEEP instead of making a sound
         if (beep) System.out.println("---BEEP---"); 
      }
   }
}
