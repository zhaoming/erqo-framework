package net.erqo.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 标题：ERQO.NET
 * 
 * 作者：Tony 2010-12-30
 * 
 * 描述：图书
 * 
 * 说明:
 */
public class Erqo_book extends AbstactBean<Erqo_book> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -627245576309347248L;
	
	private Integer id;
	
	private String book_name;
	
	private String book_author;
	
	private String book_press;
	
	private String boob_tag;
	
	private String book_introduction;
	
	private Integer book_types;
	
	private Integer book_kind;
	
	private String book_deckblatt_path;
	
	private Date book_creationdate;
	
	private Date book_publication;
	
	private Integer book_level;
	
	private Integer book_state;
	
	private String file_text_path;
	
	private String file_pdf_path;
	
	private String file_epub_path;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String bookName) {
		book_name = bookName;
	}

	public String getBook_author() {
		return book_author;
	}

	public void setBook_author(String bookAuthor) {
		book_author = bookAuthor;
	}

	public String getBook_press() {
		return book_press;
	}

	public void setBook_press(String bookPress) {
		book_press = bookPress;
	}

	public String getBoob_tag() {
		return boob_tag;
	}

	public void setBoob_tag(String boobTag) {
		boob_tag = boobTag;
	}

	public String getBook_introduction() {
		return book_introduction;
	}

	public void setBook_introduction(String bookIntroduction) {
		book_introduction = bookIntroduction;
	}

	public Integer getBook_types() {
		return book_types;
	}

	public void setBook_types(Integer bookTypes) {
		book_types = bookTypes;
	}

	public Integer getBook_kind() {
		return book_kind;
	}

	public void setBook_kind(Integer bookKind) {
		book_kind = bookKind;
	}

	public String getBook_deckblatt_path() {
		return book_deckblatt_path;
	}

	public void setBook_deckblatt_path(String bookDeckblattPath) {
		book_deckblatt_path = bookDeckblattPath;
	}

	public Date getBook_creationdate() {
		return book_creationdate;
	}

	public void setBook_creationdate(Date bookCreationdate) {
		book_creationdate = bookCreationdate;
	}

	public Date getBook_publication() {
		return book_publication;
	}

	public void setBook_publication(Date bookPublication) {
		book_publication = bookPublication;
	}

	public Integer getBook_level() {
		return book_level;
	}

	public void setBook_level(Integer bookLevel) {
		book_level = bookLevel;
	}

	public Integer getBook_state() {
		return book_state;
	}

	public void setBook_state(Integer bookState) {
		book_state = bookState;
	}

	public String getFile_text_path() {
		return file_text_path;
	}

	public void setFile_text_path(String fileTextPath) {
		file_text_path = fileTextPath;
	}

	public String getFile_pdf_path() {
		return file_pdf_path;
	}

	public void setFile_pdf_path(String filePdfPath) {
		file_pdf_path = filePdfPath;
	}

	public String getFile_epub_path() {
		return file_epub_path;
	}

	public void setFile_epub_path(String fileEpubPath) {
		file_epub_path = fileEpubPath;
	}
	
	

}
