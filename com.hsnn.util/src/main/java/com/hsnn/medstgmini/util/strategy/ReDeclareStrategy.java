package com.hsnn.medstgmini.util.strategy;

import java.util.Date;
import java.util.Map;

/**
 * 企业、药品再次申报的判断
 */
public class ReDeclareStrategy implements Strategy {
    @Override
    public boolean operate(Map<String, Object> map) {
        Date shEndtime = (Date) map.get("shEndtime");
        Date nowtime = new Date();
        int ceAuditStatus = Integer.parseInt(map.get("ceAuditStatus").toString());
        if (nowtime.getTime() < shEndtime.getTime() && ceAuditStatus == 3) {
            return false;//符合要求
        } else {
            return true;//不符合要求
        }
    }
}
