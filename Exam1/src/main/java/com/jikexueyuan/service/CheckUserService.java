package com.jikexueyuan.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jikexueyuan.dao.FilmDao;
import com.jikexueyuan.dao.LanguageDao;
import com.jikexueyuan.dao.UserDao;
import com.jikexueyuan.dao.impl.FilmDaoImpl;
import com.jikexueyuan.dao.impl.LanguageDaoImpl;
import com.jikexueyuan.dao.impl.UserDaoImpl;
import com.jikexueyuan.entity.Film;
import com.jikexueyuan.entity.User;
import com.jikexueyuan.util.ConnectionFactory;


public class CheckUserService {
	private UserDao  userDao=new UserDaoImpl(); //连接UserDaoImpl
	private FilmDao filmDao = new FilmDaoImpl();
	private LanguageDao languageDao = new LanguageDaoImpl();
	public boolean check(User user){
		Connection conn=null;
		try {
			conn=ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			ResultSet resultSet = userDao.get(conn, user);
			while(resultSet.next()){
				return true; //检查name是否在数据库中
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}finally{
			try {
				conn.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return false;
	}
	public List<Film> readResult() {

		List<Film> list = new ArrayList<Film>();

		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection();

			conn.setAutoCommit(false);

			rs = filmDao.get(conn);

			while (rs.next()) {
				int film_id = rs.getInt("film_id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				String name = rs.getString("name");
				Film film = new Film(film_id, title, description, name);
				list.add(film);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}

	public List<String> readLanguageId() {

		List<String> list = new ArrayList<String>();

		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection();

			conn.setAutoCommit(false);

			rs = languageDao.get(conn);

			while (rs.next()) {
				String language = rs.getString("name");
				list.add(language);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}
}
