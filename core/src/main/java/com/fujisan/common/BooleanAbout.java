package com.fujisan.common;
/**
 * booleanֵ
 * @author siyaomin
 *
 */
public class BooleanAbout {
	public static final String y="y";
	public static final String n="n";
	/**
	 * y����true,��������false
	 * @param value
	 * @return
	 */
	public static final boolean isTrue(String value){
		return y.equals(value)?true:false;
	}
}
