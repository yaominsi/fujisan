package com.fujisan.common;

import java.util.Date;

import com.fujisan.api.service.asserts.Assert;

/**
 * ʱ�乤��
 * 
 * @author siyaomin
 *
 */
public class TimeUtil {
	/**
	 * ����ʱ���뵱ǰ��ʱ����Ƿ񳬹�ָ��������
	 * 
	 * @param date
	 * @param minutes
	 * @return
	 */
	public static boolean isInMins(Date date, int minutes) {
		Assert.notNull(date);
		//return (System.currentTimeMillis() - date.getTime()) < (minutes * 60 * 1000);
		return false;
	}

	/**
	 * �ƻ�
	 * @param from
	 * @param amount
	 * @param unit
	 * @return
	 */
	public static Date add(Date from, int amount, DurationUnitEnum unit) {
		Assert.notNull(from, "from is null when cal duration");
		long amountms = amount * 1000 * 60;// һ����ms
		if (DurationUnitEnum.h.equals(unit)) {
			amountms *= 60;
		} else if (DurationUnitEnum.d.equals(unit)) {
			amountms *= 60 * 24;
		} else if (DurationUnitEnum.w.equals(unit)) {
			amountms *= 60 * 24 * 7;
		}
		return new Date(new Date().getTime() + amountms);
	}
}
