package com.exsun.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.exsun.bean.Command;
import com.exsun.bean.Message;
import com.exsun.db.DbAccess;

/**
 * 与指令类对应的操作
 * @author jinshouji
 *
 */
public class CommandDao {
	/**
	 * 通过Mybatis得到查询的结果
	 * @param command
	 * @param description
	 * @return
	 */
	public List<Command> queryCommand(String name, String description)
	{
		DbAccess dbAccess=new DbAccess();
		SqlSession sqlSession=null;
		List<Command> commandList = new ArrayList<Command>();
		try {
			//设置SqlSession
			sqlSession= dbAccess.getSqlSession();
			
			//设置Sql的查询条件
			Command condition=new Command();
			condition.setName(name);
			condition.setDescription(description);
			
			commandList=sqlSession.selectList("Command.queryCommandList",condition);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(sqlSession!=null) sqlSession.close();
		}
		
		return commandList;
	}

}
