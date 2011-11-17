package net.erqo.web.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import net.erqo.framework.web.BaseAction;
import net.erqo.web.vo.TestVO;
import net.sf.json.JSONObject;

public class TestAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5679279881629825299L;

	private TestVO tv;
	
	private InputStream im;
	
	public InputStream getIm() {
		return im;
	}

	public void setIm(InputStream im) {
		this.im = im;
	}

	public TestVO getTv() {
		return tv;
	}

	public void setTv(TestVO tv) {
		this.tv = tv;
	}

	public String test() {
		System.out.print(tv);
//		JSONObject jsonObject = new JSONObject();
//		jsonObject.put("success", "aaaa");
		
		;
		System.out.println(JSONObject.fromObject(tv).toString());
		try {
			setIm(new ByteArrayInputStream(JSONObject.fromObject(tv).toString().getBytes("utf-8")));
		} catch (UnsupportedEncodingException e) {
			System.out.println(e);
			e.printStackTrace();
		}   
		return SUCCESS;
	}
}
