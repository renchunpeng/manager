package com.hsnn.medstgmini.task;

import com.hsnn.medstgmini.yimiao.service.YimiaoOrderdetailManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@PropertySource("classpath:system.properties")
public class CheckException {

    private static final Logger log = Logger.getLogger(CheckException.class);

    @Autowired
    private YimiaoOrderdetailManager yimiaoOrderdetailManager;

    /**
     * 定时检查业务流程是否产生异常数据（每月1日0点执行）
     */
    @Scheduled(cron="${system.exception}")
    public void task(){
        try {
            Map<String, String> map = new HashMap<String, String>();
            map.put("out_flag","");
            yimiaoOrderdetailManager.checkException(map);
            String result = map.get("out_flag");
            if(!"1".equals(result)){
                log.info("检查业务存储过程执行失败，返回值为"+result);
            }
        } catch (Exception e) {
            log.error("Fail to system.exception",e);
        }
    }
}
