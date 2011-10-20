package net.erqo.web.action;

import java.util.ArrayList;
import java.util.List;

import net.erqo.framework.utils.StringUtils;
import net.erqo.framework.web.BaseAction;
import net.erqo.model.Erqo_book_type;
import net.erqo.sessionfacade.ErqoBookTypeFacade;

/**
 * 
 * 标题：ERQO.NET
 * 
 * 作者：Tony 2010-12-31
 * 
 * 描述：
 * 
 * 说明:
 */
public class ErqoBookTypeAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7634810724406091144L;
	
	private ErqoBookTypeFacade erqoBookTypeFacade;

	public ErqoBookTypeFacade getErqoBookTypeFacade() {
		return erqoBookTypeFacade;
	}

	public void setErqoBookTypeFacade(ErqoBookTypeFacade erqoBookTypeFacade) {
		this.erqoBookTypeFacade = erqoBookTypeFacade;
	}
	
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void getBookTypeTree(){
		
		List<Erqo_book_type> list = new ArrayList<Erqo_book_type>();
		if(id==-1){
			Erqo_book_type btype = new Erqo_book_type();
			btype.setId(0);
			btype.setName("图书分类");
			btype.setChildNum(1);
			btype.setLayer(0);
			btype.setParent_id(0);
			list.add(btype);
		}else{
			list = erqoBookTypeFacade.getErqoBookTypeByParentIdList(id);
		}
		StringBuffer btree = new StringBuffer();
		btree.append("<?xml version=\"1.0\" encoding=\'UTF-8\'?>\n");
		btree.append("<tree id=\"" + id + "\">\n");
//		btree.append("<tree id=\"" + "s" + "\">\n");
		
		for(Erqo_book_type t : list){
			if (t.getChildNum()>0){
				btree.append("<item text=\"" + t.getName() + "\" id=\""
						+ t.getId() + "\" child=\"1\">\n");
				btree.append("<userdata name=\"code\">" + t.getCode()
						+ "</userdata>");
				btree.append("</item>\n");
			} else {
				btree.append("<item text=\"" + t.getName() + "\" id=\""
						+ t.getId() + "\" child=\"0\">\n");
				btree.append("<userdata name=\"code\">" + t.getCode()
						+ "</userdata>\n");
				btree.append("</item>\n");
			}
		}
		
		btree.append("</tree>");
		
		StringUtils.renderXml(response, btree.toString());
	}

}
