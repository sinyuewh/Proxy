package com.exsun.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exsun.bean.Message;
import com.exsun.services.MessageService;

/**
 * 删除单条数据的Servlet
 * 
 * @author jinshouji
 *
 */
@SuppressWarnings("serial")
public class DeleteOneServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 接受页面的传值
		String id = req.getParameter("id");
				
		// 調用Service执行操作
		MessageService ms1 = new MessageService();
		ms1.deleteOne(id);
		
		// 返回到指定的页面
		req.getRequestDispatcher("/List.action").forward(req, resp);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
