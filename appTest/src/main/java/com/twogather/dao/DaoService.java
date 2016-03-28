package com.twogather.dao;

import java.sql.SQLException;

import com.twogather.dto.Member;

public interface DaoService {
	public Member getMember(int num) throws SQLException;

}
