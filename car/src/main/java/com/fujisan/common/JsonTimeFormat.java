package com.fujisan.common;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * ʱ��ת������
 * @author siyaomin
 *
 */
@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT")
public @interface JsonTimeFormat {

}
