package com.exsun.bean;

import java.util.List;

/**
 * 与消息表对应的实体类
 * @author jinshouji
 *
 */
public class Command {
	
	private Integer id;
	
	private String name;
	
	private String description;
	
	//对应的多条子表的数据
	private List<CommandContent> contentlist;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<CommandContent> getContentlist() {
		return contentlist;
	}

	public void setContentlist(List<CommandContent> contentlist) {
		this.contentlist = contentlist;
	}	
	
}
