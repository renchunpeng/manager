package com.hsnn.medstgmini.util.strategy;

import java.util.Map;


/**
 *
 * 使用策略模式对资审模块的关键操作进行校验
 *
 */
public class Context {
    private Strategy strategy;

    /**
     * Instantiates a new Context.
     *
     * @param strategy the strategy
     */
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Sets strategy.策略
     *
     * @param strategy the strategy
     */
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Operate boolean.操作
     *
     * @param map the map
     * @return the boolean
     */
    public boolean operate(Map<String, Object> map) {
        return this.strategy.operate(map);
    }
}
