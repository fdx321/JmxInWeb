package com.ynitq.utils.jmxInWeb.mvc;

import java.io.IOException;
import java.util.Map;

import javax.management.JMException;

import com.alibaba.fastjson.JSON;
import com.ynitq.utils.jmxInWeb.exception.BaseLogicException;
import com.ynitq.utils.jmxInWeb.exception.MyJmException;
import com.ynitq.utils.jmxInWeb.http.MyHttpRequest;

import freemarker.template.TemplateException;

/**
 * <pre>
 * 所有返回的页面的请求的基类
 * </pre>
 * 
 * @author<a href="https://github.com/liangwj72">Alex (梁韦江)</a> 2015年10月14日
 */
public abstract class BaseAjaxAction extends BaseAction {

	@Override
	public void process(MyHttpRequest request) throws IOException, BaseLogicException {
		// new empty dataModel
		Map<String, Object> dataModel = this.newModel();

		// get json response
		BaseJsonResponse res;
		try {
			res = this.getJsonResponse(request, dataModel);
			if (res == null) {
				res = new BaseJsonResponse();
			}
		} catch (JMException ex) {
			throw new MyJmException(ex);
		}

		String body = JSON.toJSONString(res);
		request.sendResponse(body);
	}

	/**
	 * <pre>
	 * 填充数据并返回view name
	 * 要处理404或者302时，就返回null
	 * </pre>
	 * 
	 * @param dataModel
	 * @return
	 * @throws TemplateException
	 * @throws IOException
	 * @throws JMException
	 */
	protected abstract BaseJsonResponse getJsonResponse(MyHttpRequest request, Map<String, Object> dataModel)
			throws IOException, BaseLogicException, JMException;

}
