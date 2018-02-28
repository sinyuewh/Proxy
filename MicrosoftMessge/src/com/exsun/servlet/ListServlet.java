package com.exsun.servlet;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;

import com.exsun.bean.Message;
import com.exsun.services.MessageService;


/**
 * 列表页面初始化控制
 * @author jinshouji
 *
 */
@SuppressWarnings("serial")
public class ListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//设置编码
		req.setCharacterEncoding("UTF-8");
		//接受页面的传值
		String command=req.getParameter("command");
		String description=req.getParameter("description");
		
		//设置页面的值
		req.setAttribute("command",command);
		req.setAttribute("description", description);
		
		//得到查询结果和设置页面的查询结果
		MessageService ms1=new MessageService();
		List<Message> messageList=ms1.queryMessage(command, description);
		req.setAttribute("messagelist", messageList);
		
		//返回到指定的页面
		req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}
