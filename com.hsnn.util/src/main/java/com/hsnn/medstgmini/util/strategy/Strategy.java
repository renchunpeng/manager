package com.hsnn.medstgmini.util.strategy;

import java.util.Map;

/**
 * 策略
 */
public interface Strategy {
    boolean operate(Map<String, Object> map);
}
