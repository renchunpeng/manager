package com.hsnn.medstgmini.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.hsnn.medstgmini.base.sys.enums.HospTypeEnum;
import com.hsnn.medstgmini.common.model.UserType;
import com.hsnn.medstgmini.common.service.CommonService;


/**
 * @param <>
 * @category 用户帐号生成器
 */
public class AccountUtil {

	private static CommonService commonService;

	private AccountUtil() {
	}

	/**
	 * @param <string>
	 * @category 生成主帐号
	 * @param userType
	 * @return
	 */
	public static synchronized <string> String getSequence(int userType, String areaId,String companyType,String heaBurType) {
		if (commonService == null) {
			WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
			commonService = wac.getBean(CommonService.class);
		}
		//Integer areaId2 = Integer.parseInt(areaId);
		//Integer companyType2 = Integer.parseInt(companyType);
		String sequence = commonService.getSequence(userType);
		return getPrefix(userType,areaId,companyType,heaBurType) + sequence;
	}

	
	
	

	/**
	 * @param <string>
	 * @category 帐号前缀
	 * @param userType
	 * @return
	 */
	private static <string> String getPrefix(int userType,String areaId,String companyType,String heaBurType) {
		String username = "";
		if (userType == 1) {//投标企业
			username = "yms";
		}else if (userType == 2) {//配送企业
    		username = "ymp";
		} else if (userType == 4) {//疾控中心
			username = "jkzx";
		} else if (userType == 6) {//监管
			username = "ymjg";
		}
		return username;
	}

	
	/**
	 * @param <string>
	 * @category 生成登陆帐号
	 * @param type
	 * @param number
	 * @return
	 */
	public static <string> String generate(UserType type, Long number,String areaId, String fatherId, String drugPurchaseProperty2,String companyType,String heaBurType) {
		String username = "P";
		if (type == UserType.cgzx) {
			username = "Z" + number;
		} else if (type == UserType.scqy) {
			//username = "SC" + number;
			if( companyType == "1" ){
        		username = "SC" + number;
        	} else if( companyType == "2" ){
        		username = "JY" + number;
        	} else if( companyType == "3" ){
        		username = "SCJY" + number;
        	} else if( companyType == "4" ){
        		username = "SJ" + number;
        	} else if( companyType == "5" ){
        		username = "SZ" + number;
        	} else if( companyType == "6" ){
        		username = "SJZ" + number;
        	}
		} else if (type == UserType.jkzx) {
			//username = "Y" + number;
			fatherId = fatherId.substring(2, 6);//截取市地区ID的后4位
			areaId = areaId.substring(2, 6);//截取市地区ID的后4位
			if(drugPurchaseProperty2.equals(HospTypeEnum.Type1Grade1.getKey()) || drugPurchaseProperty2.equals(HospTypeEnum.Type1Grade2.getKey())){
				if (fatherId.equals("0000")){//省级直属医院，不选择市区
		            username = "H" + "S" + "C" + number;//陕西省直属医院
		        }else if( fatherId.equals("0100") ){
	        		username = "H" + "A" + "C" + number;//西安市
	        	}else if( fatherId.equals("0200") ){
	            	username = "H" + "B" + "C" + number;//铜川市
	            }else if( fatherId.equals("0300") ){
	            	username = "H" + "C" + "C" + number;//宝鸡市
	            }else if( fatherId.equals("0400") ){
	            	username = "H" + "D" + "C" + number;//咸阳市
	            }else if( fatherId.equals("0500") ){
	            	username = "H" + "E" + "C" + number;//渭南市
	            }else if( fatherId.equals("0600") ){
	            	username = "H" + "J" + "C" + number;//延安市
	            }else if( fatherId.equals("0700") ){
	            	username = "H" + "F" + "C" + number;//汉中市
	            }else if( fatherId.equals("0800") ){
	            	username = "H" + "K" + "C" + number;//榆林市
	            }else if( fatherId.equals("0900") ){
	            	username = "H" + "G" + "C" + number;//安康市
	            }else if( fatherId.equals("1000") ){
	            	username = "H" + "H" + "C" + number;//商洛市
	            }else if( areaId.equals("0403") ){
	            	username = "H" + "L" + "C" + number;//韩城市
	            }else if( areaId.equals("0581") ){
	            	username = "H" + "V" + "C" + number;//杨凌示范区
	            }
			}/*else if (drugPurchaseProperty2.equals(HospTypeEnum.Type1Grade3.getKey())) {
				if( fatherId.equals("0100") ){
		            username = "H" + "A" + number;;//西安市
				} else if( fatherId.equals("0200") ){
		            username = "H" + "B" + number;//铜川市
				} else if( fatherId.equals("0300") ){
		            username = "H" + "C" + number;//宝鸡市
				} else if( fatherId.equals("0400") ){
		            username = "H" + "D" + number;//咸阳市
				} else if( fatherId.equals("0500") ){
		            username = "H" + "E" + number;//渭南市
				} else if( fatherId.equals("0600") ){
		            username = "H" + "J" + number;//延安市
				} else if( fatherId.equals("0700") ){
		            username = "H" + "F" + number;//汉中市
				} else if( fatherId.equals("0800") ){
		            username = "H" + "K" + number;//榆林市
				} else if( fatherId.equals("0900") ){
		            username = "H" + "G" + number;//安康市
				} else if( fatherId.equals("1000") ){
		            username = "H" + "H" + number;//商洛市
				} else if( areaId.equals("0403") ){
		            username = "H" + "V" + number;//杨凌示范区
				} else if( areaId.equals("0581") ){
		            username = "H" + "E" + number;//韩城市
				}
			}*/
		}/* else if (type == UserType.jcyy) {
			//username = "J" + number;
			if( areaId == "0100" ){
	            username = "H" + "A" + number;//西安市
			} else if( areaId == "0200" ){
	            username = "H" + "B" + number;//铜川市
			} else if( areaId == "0300" ){
	            username = "H" + "C" + number;//宝鸡市
			} else if( areaId == "0400" ){
	            username = "H" + "D" + number;//咸阳市
			} else if( areaId == "0500" ){
	            username = "H" + "E" + number;//渭南市
			} else if( areaId == "0600" ){
	            username = "H" + "J" + number;//延安市
			} else if( areaId == "0700" ){
	            username = "H" + "F" + number;//汉中市
			} else if( areaId == "0800" ){
	            username = "H" + "K" + number;//榆林市
			} else if( areaId == "0900" ){
	            username = "H" + "G" + number;//安康市
			} else if( areaId == "1000" ){
	            username = "H" + "H" + number;//商洛市
			} else if( areaId == "0403" ){
	            username = "H" + "V" + number;//杨凌示范区
			} else if( areaId == "0581" ){
	            username = "H" + "E" + number;//韩城市
			}
		}*/
		return username;
	}

	public static String[] number = { "1" };
	
	/**
	 * @category 随机生成密码
	 * @param len
	 * @return
	 */
	public static String getPassword(int len) {
		StringBuffer password = new StringBuffer();
		for (int i = 0; i < len; i++) {
			int index=0;
			String temp="";
			 index = (int) Math.floor(Math.random() * number.length);
			 temp = number[index];
			password.append(temp);
		}
	    char[] passwordes  = password.toString().toCharArray();
	    password.setLength(0);
	    List<Character> list = new ArrayList<Character>();    
	    for(int i = 0;i < passwordes.length;i++){    
            list.add(passwordes[i]);    
        }  
        Collections.shuffle(list);//密码乱序  
        for(char c: list){
        	password.append(c);
        }
		return password.toString();
	}
	
	
	/**
	 * @category 生成基础库编码
	 * @date 2015年11月11日13:57:51
	 * @param
	 * @return
	 */
	public static synchronized String getStdSequence(String prefix, int stdType, int subFixLen) {
		if (commonService == null) {
			WebApplicationContext wac = ContextLoader
					.getCurrentWebApplicationContext();
			commonService = wac.getBean(CommonService.class);
		}
		String sequence = commonService.getSequence(stdType);
		String strSequece = StringUtils.leftPad("" + sequence, subFixLen, '0');
		return  prefix + strSequece;
	}
	
}
