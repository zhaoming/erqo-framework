package net.erqo.framework.dao.jdbc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;


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
public abstract class AbstractBaseJDBCDAO<T, PK extends Serializable> extends
	SimpleJdbcDaoSupport implements BaseDAO<T, PK> {
	
	/**
	 * 泛型通过删除相关数据,返回删除的数据条数
	 * 
	 * @param id
	 * @return int
	 */
	
	
	protected int delete(String sql, Object... params)
			throws DataAccessException {
		return getSimpleJdbcTemplate().update(sql, params);
	}

	/**
	 * 泛型批量更新，通过List<Object[]>这种形式传递参数
	 * 
	 * @param ids
	 * @return
	 */
	protected int[] updateBatch(String sql, List<Object[]> params) {
		List<Object[]> batch = new ArrayList<Object[]>();
		int size = params.size();
		for (int i = 0; i < size; i++) {
			batch.add(params.get(i));
		}
		return getSimpleJdbcTemplate().batchUpdate(sql, batch);
	}

	protected Long getNextId(String seqName) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT " + seqName + "_SEQ.NEXTVAL FROM DUAL");
		return getJdbcTemplate().queryForLong(sql.toString());
	}

	protected List<T> getList(String sql, List<Object> list,
			ParameterizedRowMapper<T> rowMapper) {
		return (List<T>) getJdbcTemplate()
				.query(sql, list.toArray(), rowMapper);
	}
	
	/**
	 * 
	 * FunName:saveList
	 * Description: batchUpdate 操作List
	 * @param sql 添加的insert语句，参数用(:id,:name)形式
	 * @param list 存放对象的List 用于以SqlParameterSource进行转换
	 * @return
	 * @return: int[]
	 * @Create Time: 2010-1-12 下午06:05:19
	 */
	protected int[] saveList(String sql,List<T> list){
		SqlParameterSource[] batchArgs = new SqlParameterSource[list.size()];
		for (int i = 0; i < list.size() ; i++) {
			batchArgs[i] = new BeanPropertySqlParameterSource(list.get(i));
		}
		return getSimpleJdbcTemplate().batchUpdate(sql, batchArgs);
	}
	
	protected int getCurrentId() {
		String sql = "select last_insert_id()";
		return getJdbcTemplate().queryForInt(sql);
	}
	
}
