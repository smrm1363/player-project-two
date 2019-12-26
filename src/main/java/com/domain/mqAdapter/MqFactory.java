package com.domain.mqAdapter;

/**
 * This a factory for instantiating an  message queue.
 * I used Factory and Singleton patterns
 */
public class MqFactory {
    private static MqFactory mqFactory;
    public static MqFactory getInstance()
    {
        if(mqFactory==null)
            mqFactory=new MqFactory();
        return mqFactory;
    }
    private MqFactory() {
    }
    public MqAdapter getMq()
    {
        MqAdapter mqAdaprer;
        /**
         * This part could be configurable and check some IF for instantiating a MqAdapter.
         *
         */
        mqAdaprer=new InternalMq();
        return mqAdaprer;
    }
}
