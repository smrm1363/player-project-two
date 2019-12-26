package com.domain.mqAdapter;

/**
 * This is an interface as an adapter for message queue. We could use for internal MQ or a third party MQ broker such as ActiveMq
 * I used Adapter pattern
 * @param <T>
 */
public interface MqAdapter<T> {
    void put(T t) throws InterruptedException;
    T take() throws InterruptedException;
}
