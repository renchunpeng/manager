package com.hsnn.medstgmini.util.strategy;

import java.util.Date;
import java.util.Map;

/**
 * 中心审核企业信息时间判断
 */
public class ColumnUpdateStrategy implements Strategy {
    @Override
    public boolean operate(Map<String, Object> map) {
        Date shEndtime = (Date) map.get("shEndtime");
        Date shStarttime = (Date) map.get("shStarttime");
        Date nowtime = new Date();
        int ceAuditStatus = Integer.parseInt(map.get("ceAuditStatus").toString());
        if (shStarttime.getTime() < nowtime.getTime() && nowtime.getTime() < shEndtime.getTime() && ceAuditStatus == 1) {
            return false;//符合要求
        } else {
            return true;//不符合要求
        }
    }
}
