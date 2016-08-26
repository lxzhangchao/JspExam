package com.jikexueyuan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jikexueyuan.dao.UserDao;
import com.jikexueyuan.entity.User;

public class UserDaoImpl implements UserDao {
	/*
	 * 保存用户信息
	 */
	public void save(Connection conn, User user) throws SQLException {
		
	}	
	/*
	 * 更新用户信息
	 */
	public void update(Connection conn, int id, User user) throws SQLException {

	}
	/*
	 * 删除用户信息
	 */
	public void delete(Connection conn, User user) throws SQLException {
	}

	public ResultSet get(Connection conn, User user) throws SQLException {
		PreparedStatement ps=conn.prepareStatement("select * from customer where first_name = ? ");
		ps.setString(1, user.getFirst_name());
		//ps.setString(2, user.getPassword());
		return ps.executeQuery();
	}
	public ResultSet get(Connection conn) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("select * from customer ");			
		return ps.executeQuery();
	}

}
