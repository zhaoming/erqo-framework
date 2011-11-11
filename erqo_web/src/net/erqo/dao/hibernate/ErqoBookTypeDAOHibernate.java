package net.erqo.dao.hibernate;

import java.util.List;

import net.erqo.dao.ErqoBookTypeDAO;
import net.erqo.framework.dao.hibernate3.CommonDAOHibernate;
import net.erqo.framework.utils.CodeGenerator;
import net.erqo.model.Erqo_book_type;

import org.hibernate.Query;

public class ErqoBookTypeDAOHibernate extends
		CommonDAOHibernate<Erqo_book_type, Integer, ErqoBookTypeDAO> implements ErqoBookTypeDAO {

	private static final String HQL_GETERQOBOOKTYPELIST = "from Erqo_book_type as t where t.parent_id = ?";
	
	private static final String HQL_GET_MAX_CODE = "select max(t.code) from Erqo_book_type as t where t.parent_id = ?";
	
	public List<Erqo_book_type> getErqoBookTypeByParentIdList(int parentId) {
		return this.findHQL(HQL_GETERQOBOOKTYPELIST,parentId);
	}

	public Erqo_book_type addErqoBookType(Erqo_book_type t) {
		String parentCode = "0";
		
		if(t.getParent_id()!=0){
			parentCode = getObject(t.getParent_id()).getCode();
		}
		
		// 平级最大CODE
		Query query = this.getSession().createQuery(HQL_GET_MAX_CODE);
		query.setParameter(0, t.getParent_id());
		String maxCode = (String)query.uniqueResult();
		
		maxCode = CodeGenerator.genratorCode(parentCode, maxCode);
		t.setSeq(Integer.parseInt(maxCode.substring(maxCode.length()-4)));
		t.setCode(maxCode);
		
		save(t);
		
		return t;
	}

}
