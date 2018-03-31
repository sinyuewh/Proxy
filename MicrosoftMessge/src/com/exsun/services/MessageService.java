package com.exsun.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.exsun.bean.Command;
import com.exsun.bean.CommandContent;
import com.exsun.bean.Message;
import com.exsun.dao.CommandDao;
import com.exsun.dao.MessageDao;
import com.exsun.util.Iconst;

/**
 * Message表的业务逻辑
 * 
 * @author jinshouji
 *
 */
public class MessageService {
	/**
	 * 根据条件查询列表
	 * 
	 * @param command
	 * @param description
	 * @return
	 */
	public List<Message> queryMessage(String command, String description) {
		return (new MessageDao()).queryMessage(command, description);
	}
	
	/**
	 * 得到命令查询列表
	 * @param name
	 * @param description
	 * @return
	 */
	public List<Command> queryCommand(String name,String description)
	{
		return (new CommandDao()).queryCommand(name, description);
	}

	/**
	 * 删除单条数据
	 * 
	 * @param id
	 */
	public void deleteOne(String id) {
		int id1 = Integer.parseInt(id);
		(new MessageDao()).deleteOne(id1);
	}

	/**
	 * 删除多条数据
	 * 
	 * @param ids
	 * 
	  */
	public void deleteBatch(String[] ids) {
		if (ids != null && ids.length > 0) {
			List<Integer> list1 = new ArrayList<Integer>();
			for (String m : ids) {
				list1.add(Integer.parseInt(m));
			}
			(new MessageDao()).deleteBatch(list1);
		}
	}
	
	/**
	 * 根据指令查询自动回复的内容
	 * @param command
	 * @return
	 */
	public String queryByCommand(String command)
	{
		List<Command> list1=this.queryCommand(command,null);
		if(list1.size()>0)
		{
			List<CommandContent> c1=list1.get(0).getContentlist();
			return c1.get(new Random().nextInt(c1.size())).getContent();
		}
		return Iconst.NO_MATCHING_CONTENT;
	}
}
