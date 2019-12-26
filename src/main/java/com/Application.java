package com;
import com.domain.player.PlayerService;
import java.util.concurrent.ExecutionException;

/**
 * The start of the program, all the program runs in a single process
 */
public class Application {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        PlayerService playerService = PlayerService.getInstance();
        playerService.runMessagePassing();
    }
}
