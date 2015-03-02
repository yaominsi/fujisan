package com.fujisan.notify;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.fujisan.common.NotifyTypeEnum;
/**
 * ��Ҫ������Ϣ��ע��
 * @author siyaomin
 *
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface NeedNotify {
	NotifyTypeEnum value();
}
