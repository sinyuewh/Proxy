package com.exsun.services;

import java.util.List;

import com.exsun.bean.Message;
import com.exsun.dao.MessageDao;

/**
 * Message表的业务逻辑
 * @author jinshouji
 *
 */
public class MessageService {
	/**
	 * 根据条件查询列表
	 * @param command
	 * @param description
	 * @return
	 */
	public List<Message> queryMessage(String command, String description)
	{
		return (new MessageDao()).queryMessage(command, description);
	}
}
