package net.erqo.model;

import java.io.Serializable;


/**
 * 
 * 标题：ERQO.NET
 * 
 * 作者：Tony 2010-12-30
 * 
 * 描述：图书类别
 * 
 * 说明:
 */
public class Erqo_book_type implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4214273639962023869L;

	/**
	 * ID
	 */
	private Integer id;
	
	/**
	 * 图书类别名称
	 */
	private String name;

	/**
	 * 图书类别状态
	 * 1:正常
	 * 0:禁用
	 */
	private Integer state;

	/**
	 * 父类
	 */
	private Integer parent_id;
	

	
	/**
	 * 图书类别CODE
	 * 00010001
	 * 00010002
	 */
	private String code;

	/**
	 * 层级
	 */
	private Integer layer;

	/**
	 * 顺序
	 */
	private Integer seq;
	
	/**
	 * 级别
	 */
	private Integer level;
	
	/**
	 * 子节点个数
	 */
	private int childNum;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getLayer() {
		return layer;
	}

	public void setLayer(Integer layer) {
		this.layer = layer;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public int getChildNum() {
		return childNum;
	}

	public void setChildNum(int childNum) {
		this.childNum = childNum;
	}
	
	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Override
	public boolean equals(Object o) {
		return false;
	}

	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public String toString() {
		return null;
	}

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parentId) {
		parent_id = parentId;
	}

}
