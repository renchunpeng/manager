package com.hsnn.medstgmini.task;

import com.hsnn.medstgmini.yimiao.model.YimiaoOrderdetail;
import com.hsnn.medstgmini.yimiao.service.YimiaoOrderdetailManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;


@Component
@PropertySource("classpath:system.properties")
public class AutoRecipientOrder {
    private static final Logger log = Logger.getLogger(AutoRecipientOrder.class);

    @Autowired
    private YimiaoOrderdetailManager yimiaoOrderdetailManager;

    @Scheduled(cron="${system.checkDate}")
    public void task(){
        try{
            Calendar now = Calendar.getInstance();
            int day = now.get(Calendar.DAY_OF_MONTH);
            if(day == 1){
                //修改未提交，已提交，待处理，审核未通过，供货的订单明细与订单的状态为已取消
                yimiaoOrderdetailManager.updateCancelStatus();
                //修改收货中的订单明细数据与订单为已完成
                yimiaoOrderdetailManager.updateOrderStatus();
            }
        }catch (Exception e){
            log.error("Fail to AutoRecipientOrder !",e);
        }
    }
}
