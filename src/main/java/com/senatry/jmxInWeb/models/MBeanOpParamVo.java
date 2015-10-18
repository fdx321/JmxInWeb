package com.senatry.jmxInWeb.models;

import javax.management.MBeanParameterInfo;

import com.senatry.jmxInWeb.utils.OpenTypeUtil;

/**
 * <pre>
 * 对MBeanParameterInfo的包装
 * </pre>
 * 
 * @author 梁韦江
 * 2015年10月15日
 */
public class MBeanOpParamVo {
	private final MBeanParameterInfo info;
	private final boolean inputable;

	public MBeanOpParamVo(MBeanParameterInfo info) {
		super();
		this.info = info;

		this.inputable = OpenTypeUtil.isOpenType(info.getType());
	}

	public MBeanParameterInfo getInfo() {
		return info;
	}

	public boolean isInputable() {
		return inputable;
	}

	public String getDefaultValue() {
		return OpenTypeUtil.getDefaultValue(this.info.getType());
	}
}