package com.fujisan.common;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * ��־���������Ų�����
 * Ŀǰͬһ�̹߳���һ������
 * @author siyaomin
 *
 */
public class LogSequence {
	public static final String seq(){
        SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd-HHmmssSSSS");//�ȼ���now.toLocaleString()
        return format.format(new Date());
	}
}
