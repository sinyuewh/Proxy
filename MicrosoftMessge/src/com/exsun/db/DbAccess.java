package com.exsun.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 访问数据库的基础类
 * @author jinshouji
 *
 */
public class DbAccess {
	
	/**
	 * 得到数据库的会话
	 * @return
	 * @throws IOException
	 */
	public SqlSession getSqlSession() throws IOException
	{
		//通过配置文件获取数据库的连接信息
		Reader config=Resources.getResourceAsReader("com/exsun/config/Configuration.xml");
		
		//通过配置信息构建一个SqlSessionFactory
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(config);
		
		//通过sqlSessionFactory去打开一个数据库会话
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		//返回数据库会话
		return sqlSession;
	}
}
