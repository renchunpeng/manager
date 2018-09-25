package com.hsnn.medstgmini.util;

import org.apache.commons.lang.StringUtils;

public class GBTUtil {
	
	public static String getChecksum(String str, int modVal, int radis) throws Exception {
		
		if (StringUtils.isEmpty(str)) {
			throw new Exception("Empty input string");
		}
		
		char[] charArr = str.toCharArray();
		int[] intArr = new int[charArr.length];
				
		for (int i = 0; i < charArr.length; ++i) {
			
			int j = 0;
            for (j = 0; j < gbtKeys.length; ++j) {
            	if (("" + charArr[i]).equals(gbtKeys[j])) {
            		intArr[i] = gbtValues[j];
            		break;
            	} 
            }
            
            if (j == gbtKeys.length) {
            	intArr[i] = suppValue;
            }
		}
		
		// begin for debug only
		/*
		int [] tmpArr = new int[charArr.length];
		for (int i = 0; i < intArr.length; ++i) {
			tmpArr[i] = (int)Math.pow(radis, intArr.length - i) % modVal;
			System.out.println("tmp = " + tmpArr[i] + ", intArr = " + intArr[i]);
		}
		*/
		// end for debug only
		
		int resu = 0;
		for (int i = 0; i < intArr.length; ++i) {
			resu += (Math.pow(radis, intArr.length - i) % modVal)* intArr[i];
		}
		
		int returnVal = 0;
		for (int i = 0; i < modVal; ++i) {
			if ((resu + i) % modVal == 1) {
				returnVal = i;
				break;
			}
		}
		

		if (returnVal == 36) {
			return "*";
		} else {
			return gbtKeys[returnVal];
		}
	}
		
	public static int suppValue = 36;
	
	public static String[] gbtKeys= new String[] {
		"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", 
		"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
		"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
		"U", "V", "W", "X", "Y", "Z"
	};
	
	public static int[] gbtValues = new int[] {
		0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 
		10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 
		20, 21, 22, 23, 24, 25, 26, 27, 28, 29,
		30, 31, 32, 33, 34, 35
	};
	

	public static void main(String[] arr) throws Exception {
		
		System.out.println("0794 -> " + GBTUtil.getChecksum("0794", 11, 2));
		System.out.println("0794 -> " + GBTUtil.getChecksum("0794", 37, 2));
	}
}