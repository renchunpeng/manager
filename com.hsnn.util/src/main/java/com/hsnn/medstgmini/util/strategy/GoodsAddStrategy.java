package com.hsnn.medstgmini.util.strategy;

import java.util.Date;
import java.util.Map;

/**
 * 药品资质申报时间判断
 * 企业只能在申报时间内进行申报
 * 如果是补交申报企业，那么必须在截止时间之间进行申报
 */
public class GoodsAddStrategy implements Strategy {
    @Override
    public boolean operate(Map<String, Object> map) {
        Date starttime = (Date) map.get("starttime");
        Date endtime = (Date) map.get("endtime");
        Date deadlinetime = (Date) map.get("deadlinetime");
        Date nowtime = new Date();

        if (null == deadlinetime) {
            int ceAuditStatus = Integer.parseInt(map.get("ceAuditStatus").toString());
            if (starttime.getTime() <= nowtime.getTime() && nowtime.getTime() <= endtime.getTime() && ceAuditStatus == 0) {
                return false;//符合要求
            } else {
                return true;//不符合要求
            }
        } else {
            if (deadlinetime.getTime() > nowtime.getTime()) {//判断是否在补交截止时间之前
                return false;
            } else {
                return true;
            }
        }

    }
}
