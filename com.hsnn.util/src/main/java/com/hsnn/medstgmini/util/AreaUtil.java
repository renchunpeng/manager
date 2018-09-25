package com.hsnn.medstgmini.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;


public class AreaUtil {
	/**
	 * 
	 * @category 获取地区下拉框ID
	 * @author 王炳
	 * @date 2015年6月11日 上午11:52:57
	 * @param provId
	 *            省
	 * @param cityId
	 *            市
	 * @param townId
	 *            县
	 * @return
	 */
	public static String getAreaStartCode(String provId, String cityId,
			String townId) {
		String areaId = provId;
		if (StringUtils.isNotBlank(townId)) {
			areaId = townId;
		} else if (StringUtils.isNotBlank(cityId)) {
			areaId = cityId.replaceAll("0*$", "");
		} else if (StringUtils.isNotBlank(provId)) {
			areaId = provId.replaceAll("0*$", "");
		} else {
			areaId = "";
		}

		return areaId;

	}

	/**
	 * @category 地区编码转义
	 * @date 2015年7月16日
	 * @param areaId
	 * @return
	 */
	public static String escapeAreaId(String areaId) {
		if (StringUtils.isNotBlank(areaId)) {
			if (areaId.length() == 6) {
				String sheng = areaId.substring(0, 2);
				String shi = areaId.substring(2, 4);
				String xian = areaId.substring(4, 6);
				if ("00".equals(xian)) {
					xian = "__";
				}
				if ("00".equals(shi)) {
					shi = "__";
				}
				return sheng + shi + xian;
			}
		}
		return areaId;
	}

	/**
	 * @category 根据地区获取药品
	 * @date 2015年11月16日
	 * @param areaId
	 * @return
	 */
	public static String getDrugByArea(String areaId, String columnName) {
		StringBuilder sb = new StringBuilder();
		if (StringUtils.isNotBlank(areaId) && areaId.length() == 6) {
			sb.append("( ");
			String sheng = areaId.substring(0, 2);
			String shi = areaId.substring(2, 4);
			String xian = areaId.substring(4, 6);
			if ("00".equals(xian)) {
				if ("00".equals(shi)) { // 省
					sb.append(columnName + " LIKE '" + sheng + "____'");
				} else { // 市
					sb.append(columnName + " = '" + sheng + "0000' OR ");
					sb.append(columnName + " LIKE '" + sheng + shi + "__'");
				}
			} else { // 县
				sb.append(columnName + " = '" + sheng + "0000' OR ");
				sb.append(columnName + " = '" + sheng + shi + "00' OR ");
				sb.append(columnName + " = '" + areaId + "'");
			}
			sb.append(" )");
		}
		return sb.toString();
	}
	
	/**
	 * @category 根据地区获取医院
	 * @date 2015年11月16日
	 * @param areaId
	 * @return
	 */
	public static String getHospByArea(String areaId, String columnName) {
		StringBuilder sb = new StringBuilder();
		if (StringUtils.isNotBlank(areaId) && areaId.length() == 6) {
			sb.append("( ");
			String sheng = areaId.substring(0, 2);
			String shi = areaId.substring(2, 4);
			String xian = areaId.substring(4, 6);
			if ("00".equals(xian)) {
				if ("00".equals(shi)) { // 省
					sb.append(columnName + " LIKE '" + sheng + "____'");
				} else { // 市
					sb.append(columnName + " LIKE '" + sheng + shi + "__'");
				}
			} else { // 县
				sb.append(columnName + " = '" + areaId + "'");
			}
			sb.append(" )");
		}
		return sb.toString();
	}

//	public static String getAreaPrefix(DicArea dicArea) {
//
//		if (dicArea == null) {
//			return null;
//		}
//		String areaId = dicArea.getAreaid();
//		if (StringUtils.isNotBlank(areaId) && areaId.length() == 6) {
//			String xian = areaId.substring(4, 6);
//			String shi = areaId.substring(2, 4);
//			String sheng = areaId.substring(0, 2);
//
//			if ("00".equals(xian)) {
//				if ("00".equals(shi)) {
//					return sheng;
//				} else {
//					return sheng + shi;
//				}
//			} else {
//				return sheng + shi + xian;
//			}
//		} else {
//			return null;
//		}
//	}

	public static String getAreaPrefix(String areaId) {

		if (StringUtils.isBlank(areaId)) {
			return null;
		}
		if (StringUtils.isNotBlank(areaId) && areaId.length() == 6) {
			String xian = areaId.substring(4, 6);
			String shi = areaId.substring(2, 4);
			String sheng = areaId.substring(0, 2);

			if ("00".equals(xian)) {
				if ("00".equals(shi)) {
					return sheng;
				} else {
					return sheng + shi;
				}
			} else {
				return sheng + shi + xian;
			}
		} else {
			return null;
		}
	}

	public static String[] getSuperArea(String areaId) {

		if (StringUtils.isBlank(areaId)) {
			return null;
		}

		if (areaId.endsWith("0000")) {
			return null;
		}

		String xian = areaId.substring(4, 6);
		String shi = areaId.substring(2, 4);
		String sheng = areaId.substring(0, 2);
		List<String> suArr = new ArrayList<String>();

		if ("00".equals(xian)) {
			suArr.add(sheng + "0000");
		} else {
			suArr.add(sheng + "0000");
			suArr.add(sheng + shi + "00");
		}

		return (String[]) suArr.toArray(new String[suArr.size()]);
	}
	
	
	/**
	 * @category 根据地区id获取市级地区id
	 * @author 韩守松
	 * @date   2015年12月19日
	 * @param  @param areaId
	 * @param  @return
	 */
	public static String getAreaSHIID(String areaId) {

		if (StringUtils.isBlank(areaId)) {
			return null;
		}
		if (StringUtils.isNotBlank(areaId) && areaId.length() == 6) {
			String xian = areaId.substring(4, 6);
			String shi = areaId.substring(2, 4);
			String sheng = areaId.substring(0, 2);

			if ("00".equals(xian)) {
				if ("00".equals(shi)) {
					return null;
				} else {
					return sheng + shi+"00";
				}
			} else {
				return sheng + shi + "00";
			}
		} else {
			return null;
		}
	}
	
	/**
	 * 根据AreaId 得到地区等级  1 ：省  2 ：市   3： 区
	 * @param areaId
	 * @return
	 */
	public static String getAreaLevel(String areaId) {
		if (StringUtils.isNotBlank(areaId)) {
			if (areaId.length() == 6) {
				String sheng = areaId.substring(2, 6);
				String shi = areaId.substring(4, 6);
				if("0000".equals(sheng)){
					return "1";
				}else if("00".equals(shi)) {
					return "2";
				}else{
					return "3";
				}
			}
		}
		return areaId;
	}
	
	public static void main(String[] args) {
		
		String areaId = "331000";
		
		System.out.println(getAreaLevel(areaId));
	}
	
	
}