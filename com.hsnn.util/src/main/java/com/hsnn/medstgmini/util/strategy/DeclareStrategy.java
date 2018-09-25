package com.hsnn.medstgmini.util.strategy;

import java.util.Date;
import java.util.Map;

/**
 * 企业申报信息时间校验
 */
public class DeclareStrategy implements Strategy {
    @Override
    public boolean operate(Map<String, Object> map) {
        Date starttime = (Date) map.get("starttime");
        Date endtime = (Date) map.get("endtime");
        Date nowtime = new Date();
        int ceAuditStatus = Integer.parseInt(map.get("ceAuditStatus").toString());
        if (starttime.getTime() <= nowtime.getTime() && nowtime.getTime() <= endtime.getTime() && ceAuditStatus < 1) {
            return false;//符合要求
        } else {
            return true;//不符合要求
        }
    }
}
