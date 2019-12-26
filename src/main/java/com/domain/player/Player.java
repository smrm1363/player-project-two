package com.domain.player;
import com.domain.mqAdapter.MqAdapter;

/*
this is a Player class
 */
public class Player {
    private final int maxMessage = 10;
    private final MqAdapter<String> toBeSendQueue;
    private final MqAdapter<String> toBeReceivedQueue;
    private int counter = 0;

    public Player(MqAdapter<String> toBeSendQueue, MqAdapter<String> toBeReceivedQueue) {
        this.toBeSendQueue = toBeSendQueue;
        this.toBeReceivedQueue = toBeReceivedQueue;
    }
/*
This method is for sending message
 */
    public void send(String message) {
           try {
               toBeSendQueue.put(message);
               /**
                * I just used the println() for showing the result in the console. In real situation I should use Log
                */
               System.out.println(message);
               counter++;
           } catch (Exception e) {
               e.printStackTrace();
           }
   }

    /**
     * This method is for receiving message from the other player
     */
   public void receive()
   {
           while (counter<=maxMessage)
           {
               try {
                   String message = toBeReceivedQueue.take()+counter;
                   send(message);
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
   }
}
