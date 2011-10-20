package net.erqo.framework.exception;

/**
 * 
 * 标题：ERQO.NET
 * 
 * 作者：tony 2010-8-27
 * 
 * 描述：
 * 
 * 说明:
 */
public class BusinessException extends RuntimeException

{
	private static final long serialVersionUID = 0xc1a865c45ffdc5f9L;

	public BusinessException(String frdMessage) {
		super(createFriendlyErrMsg(frdMessage));
	}

	public BusinessException(Throwable throwable) {
		super(throwable);

	}

	public BusinessException(Throwable throwable, String frdMessage) {
		super(throwable);
	}

	private static String createFriendlyErrMsg(String msgBody) {

		String prefixStr = "抱歉，";

		String suffixStr = " 请稍后再试或与管理员联系！";
		StringBuffer friendlyErrMsg = new StringBuffer("");
		friendlyErrMsg.append(prefixStr);
		friendlyErrMsg.append(msgBody);
		friendlyErrMsg.append(suffixStr);
		return friendlyErrMsg.toString();

	}

}
