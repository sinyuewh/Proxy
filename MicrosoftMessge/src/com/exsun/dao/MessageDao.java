package com.exsun.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exsun.bean.Message;

/**
 * 和Message表相关的操作
 * 
 * @author jinshouji
 *
 */
public class MessageDao {
	/**
	 * 根据查询条件查询列表
	 * 
	 * @param command
	 * @param description
	 * @throws ClassNotFoundException
	 */
	public List<Message> queryMessage(String command, String description) {
		List<Message> messageList = new ArrayList<Message>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbgirl", "root", "123456");

			// 构建Sql语句
			StringBuilder sb1 = new StringBuilder();
			sb1.append("select ID,COMMAND,DESCRIPTION,CONTENT from message where 1=1 ");

			List<String> paramList = new ArrayList<String>();
			if (command != null && !"".equals(command.trim())) {
				sb1.append(" and COMMAND=?");
				paramList.add(command);
			}
			if (description != null && !"".equals(description.trim())) {
				sb1.append(" and DESCRIPTION like '%' ? '%'");
				paramList.add(description);
			}

			PreparedStatement statement = conn.prepareStatement(sb1.toString());
			for (int i = 0; i < paramList.size(); i++) {
				statement.setString(i + 1, paramList.get(i));
			}

			ResultSet rs = statement.executeQuery();		
			while (rs.next()) {
				Message m1 = new Message();
				messageList.add(m1);
				m1.setId(rs.getInt("ID"));
				m1.setCommand(rs.getString("COMMAND"));
				m1.setContent(rs.getString("CONTENT"));
				m1.setDescription(rs.getString("DESCRIPTION"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return messageList;
	}
}
