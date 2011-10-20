package net.erqo.dao.jdbc;

import java.util.ArrayList;
import java.util.List;

import net.erqo.dao.ErqoBookTypeDAO;
import net.erqo.framework.dao.jdbc.AbstractBaseJDBCDAO;
import net.erqo.framework.utils.CodeGenerator;
import net.erqo.framework.utils.StringUtils;
import net.erqo.model.Erqo_book_type;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

/**
 * 
 * 标题：ERQO.NET
 * 
 * 作者：Tony 2010-12-30
 * 
 * 描述：
 * 
 * 说明:
 */
public class ErqoBookTypeJDBCDAO extends
		AbstractBaseJDBCDAO<Erqo_book_type, Integer> implements ErqoBookTypeDAO {

	private static final String SQL_ADD_ERQO_BOOK_TYPE = "insert into erqo_book_type (name,state,parent_id,code,layer,seq) values (:name,:state,:parent_id,:code,:layer,:seq)";

	private static final String SQL_GET_ERQO_BOOK_TYPE_BY_PARENTID_LIST = "SELECT t.ID, t.NAME, t.STATE, t.PARENT_ID, t.CODE, t.LAYER, t.LEVEL, t.SEQ, (select count(1) from erqo_book_type t1 where t1.parent_id = t.id) as childNum FROM erqo_book_type t where t.parent_id = ? and t.state=1 order by t.seq";
	
	public Erqo_book_type addErqoBookType(Erqo_book_type btype) {
		// 设置生成的CODE
		String code = getMaxCode(btype.getParent_id());
		btype.setCode(code);
		btype.setSeq(Integer.parseInt(code.substring(code.length()-4)));
		getJdbcTemplate().update(SQL_ADD_ERQO_BOOK_TYPE,
				new BeanPropertySqlParameterSource(btype));
		btype.setId(getCurrentId());
		return null;
	}

	@SuppressWarnings("unchecked")
	public Erqo_book_type updateErqoBookType(Erqo_book_type btype) {
		StringBuffer sql = new StringBuffer();
		List list = new ArrayList();
		sql.append("update erqo_book_type set ");
		if (!StringUtils.checkNull(btype.getName())) {
			sql.append(" name = ?, ");
			list.add(btype.getName());
		}
		if (btype.getParent_id() != null) {
			sql.append(" parent_id = ? , ");
			list.add(btype.getParent_id());
		}
		if (!StringUtils.checkNull(btype.getCode())) {
			sql.append(" code = ? , ");
			list.add(btype.getCode());
		}
		if (btype.getLayer() != null) {
			sql.append(" layer = ? , ");
			list.add(btype.getLayer());
		}
		if (btype.getSeq() != null) {
			sql.append(" seq = ? , ");
			list.add(btype.getSeq());
		}
		if (btype.getState() != null) {
			sql.append(" state = ? ");
			list.add(btype.getState());
		}
		sql.append(" where id = ? ");
		list.add(btype.getId());
		getJdbcTemplate().update(sql.toString(), list.toArray());
		return btype;
	}

	public void updateErqoBookTypeStateById(Erqo_book_type btype) {

	}

	private String getMaxCode(int parentId) {
		String sql = "select max(code) as code from erqo_book_type where parent_id = ?";
		// 父节点CODE
		String parentCode = "0";
		parentCode = getErqoBookTypeById(parentId).getCode();
		// 平级最大CODE
		String maxCode = getJdbcTemplate().queryForObject(
				sql,
				ParameterizedBeanPropertyRowMapper
						.newInstance(Erqo_book_type.class), parentId).getCode();

		return CodeGenerator.genratorCode(parentCode, maxCode);
	}

	public Erqo_book_type getErqoBookTypeById(Integer id) {
		String sql = "select * from erqo_book_type where id = ?";
		return getJdbcTemplate().queryForObject(
				sql,
				ParameterizedBeanPropertyRowMapper
						.newInstance(Erqo_book_type.class), id);
	}

	public List<Erqo_book_type> getErqoBookTypeRootList() {
		return getJdbcTemplate().query(
				SQL_GET_ERQO_BOOK_TYPE_BY_PARENTID_LIST,
				ParameterizedBeanPropertyRowMapper
						.newInstance(Erqo_book_type.class),0);
	}

	public List<Erqo_book_type> getErqoBookTypeByParentIdList(Integer parentId) {
		return getJdbcTemplate().query(
				SQL_GET_ERQO_BOOK_TYPE_BY_PARENTID_LIST,
				ParameterizedBeanPropertyRowMapper
						.newInstance(Erqo_book_type.class),parentId);
	}

}
