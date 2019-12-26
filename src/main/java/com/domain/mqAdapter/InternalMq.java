package com.domain.mqAdapter;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * This is useful when we want to use an internal message queue. For single process but multi thread it works
 * @param <T>
 */
public class InternalMq<T> implements MqAdapter<T> {
    private final BlockingDeque<T> queue = new LinkedBlockingDeque<>();
    @Override
    public void put(T t) throws InterruptedException {
        queue.put(t);
    }

    @Override
    public T take() throws InterruptedException {
        return queue.take();
    }
}
