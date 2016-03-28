package com.twogather.dao;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.twogather.dto.Member;


@Repository
//@SuppressWarnings("unchecked")
public class UserDao {
	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;
//	
//	public static Reader reader;
//	public static SqlMapClient sqlMapper;
//	
//	public UserDao() throws Exception{
//		reader=Resources.getResourceAsReader("sqlMapConfig.xml");
//		sqlMapper=SqlMapClientBuilder.buildSqlMapClient(reader);
//		reader.close();
//	}
//	
//	
//	public void setSqlMapClient(SqlMapClient sqlMapClient){
//		this.sqlMapClient=sqlMapClient;
//	}
//	
//	public void setsqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate){
//		this.sqlMapClientTemplate=sqlMapClientTemplate;
//		
//	}
	

	public Member getMember(int num) throws SQLException{
		Member member = new Member();
	
		member=(Member)sqlMapClientTemplate.queryForObject("findMemeberByNum",num);
	
		
		return member;
		
	}

}
