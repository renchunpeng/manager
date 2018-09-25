package com.hsnn.medstgmini.util;


import com.hsnn.medstgmini.enums.BinaryConvert;

/**
 * Created by Chenglong
 *
 * @date 2017-5-15 9:41
 */
public class BinaryConvertUtil {


    /**
     * 传入本流程已经有几个角色个数
     * 返回新增角色的标识位
     * <p>
     * 联合审核第一个审核角色标识为：00000000000000000000000000000001
     * 第二个审核角色表示为：00000000000000000000000000000010
     * ...
     * 第三十二个         ：10000000000000000000000000000000
     *
     * @param count 流程上已经有几个角色个数
     * @return
     */
    public static String BinaryConvert(int count) {
        if (count == 0) {
            return "00000000000000000000000000000001";
        }
        if (count > 32 || count < 0) {
            return "角色标志位转换错误";
        } else {
            StringBuffer baseStr = new StringBuffer("00000000000000000000000000000000");
            int index = 31 - count;
            baseStr.replace(index, index + 1, "1");
            return baseStr.toString();
        }
    }

    /**
     * 通过角色标志和审核状态更新结果标志字符串上相应的值
     * 角色标志：00000000000000000000000000000001
     * 结果标志：00000000000000000000000000000000
     * 审核状态：2
     * 返回结果：00000000000000000000000000000002
     * <p>
     * 角色标志：00000000000000000000000000000010
     * 结果标志：00000000000000000000000000000000
     * 审核状态：1
     * 返回结果：00000000000000000000000000000010
     *
     * @param baseStr 结果标志
     * @param roleStr 角色标志
     * @param status  审核状态
     * @return
     */
    public static String ChangeBidStatus(String baseStr, String roleStr, String status) {
        if (baseStr.length() != 32 || roleStr.length() != 32) {
            return "审核状态修改错误";
        } else {
            int index = roleStr.indexOf("1");
            StringBuffer stringBuffer = new StringBuffer(baseStr);
            String str = stringBuffer.replace(index, index + 1, status).toString();
            return str;
        }
    }

    /**
     * 资审 判断审核状态
     *
     * @param count   审核流程有几个角色
     * @param baseStr 结果标志
     * @return 0->没有审核完   1->审核通过  2->审核没有通过     -1->参数错误
     */
    public static int CheckBidStatus(int count, String baseStr) {
        if (baseStr.length() != 32 || count > 32 || count < 0) {
            return BinaryConvert.ERROR.getKey();
        } else {
            String subBaseStr = baseStr.substring(32 - count);
            if (subBaseStr.indexOf("0") > -1) {
                return BinaryConvert.AUDIT_NOT_FINISHED.getKey();
            } else if (subBaseStr.indexOf("2") > -1) {
                return BinaryConvert.AUDIT_NOT_THROUGH.getKey();
            } else {
                return BinaryConvert.AUDIT_PASS.getKey();
            }
        }
    }

    public static int PendedBidStatus(String baseStr, String roleStr) {
        if (baseStr.length() != 32 || roleStr.length() != 32) {
            return -1;
        } else {
            int index = roleStr.indexOf("1");
            String baseChar = baseStr.substring(index, index + 1);
            if (baseChar.equals("0")) {
                return 0;
            } else if (baseChar.equals("1")) {
                return 1;
            } else {
                return 2;
            }
        }
    }
}
