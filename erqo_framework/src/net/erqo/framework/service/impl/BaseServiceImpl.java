package net.erqo.framework.service.impl;

import net.erqo.framework.service.BaseService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class BaseServiceImpl implements
		BaseService {

	protected final Log logger = LogFactory.getLog(getClass());

}