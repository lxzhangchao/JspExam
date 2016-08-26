package com.jikexueyuan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jikexueyuan.dao.FilmDao;
import com.jikexueyuan.entity.Film;

public class FilmDaoImpl implements FilmDao {

	public void save(Connection conn, Film film) throws SQLException {

	}

	public void update(Connection conn, Long id, Film film) throws SQLException {

	}

	public void insert(Connection conn, Film film) throws SQLException {
		PreparedStatement ps = conn
				.prepareStatement("insert into  film (film_id,title,description,name) values(?,?,?,'chinese') ");
		ps.setInt(1, film.getFilm_id());
		ps.setString(2, film.getTitle());
		ps.setString(3, film.getDescription());
		ps.execute();
	}

	public void delete(Connection conn, String film_id) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("delete from film where film_id = ?");
		ps.setString(1, film_id);
		ps.execute();
	}

	public ResultSet get(Connection conn, Film film) throws SQLException {
		return null;
	}

	public ResultSet get(Connection conn) throws SQLException {
		PreparedStatement ps = conn
				.prepareStatement("select f.*,l.name from film f,language l where f.language_id =l.language_id ");
		return ps.executeQuery();
	}
}
