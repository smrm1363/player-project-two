package com.domain.player;

import com.domain.mqAdapter.MqAdapter;
import com.domain.mqAdapter.MqFactory;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * This class is the logic of the program. This is a singleton
 */
public class PlayerService {
    private static PlayerService playerService;
    public static PlayerService getInstance()
    {
        if(playerService== null)
            playerService= new PlayerService();
        return playerService;
    }

    private PlayerService() {
    }

    /**
     * This method is responsible for passing the queues to the players
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public void runMessagePassing() throws ExecutionException, InterruptedException {
        MqAdapter<String> toBeSendQueue = MqFactory.getInstance().getMq();
        MqAdapter<String> toBeReceivedQueue = MqFactory.getInstance().getMq();
        Player initiator=new Player(toBeSendQueue,toBeReceivedQueue);
        Player secondPlayer=new Player(toBeReceivedQueue,toBeSendQueue);
        /**
         * I used CompletableFuture for checking the queue, because async call,
         */
        initiator.send("Hello");
        CompletableFuture initiatorFuture =CompletableFuture.runAsync(initiator::receive);
        CompletableFuture secondPlayerFuture =CompletableFuture.runAsync(secondPlayer::receive);
        CompletableFuture.allOf(initiatorFuture,secondPlayerFuture).get();
    }
}
