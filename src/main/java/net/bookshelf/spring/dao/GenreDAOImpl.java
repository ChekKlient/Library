package net.bookshelf.spring.dao;

import net.bookshelf.spring.model.*;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * An implementation of the GenreDAO interface.
 * @author www.codejava.net
 *
 */
public class GenreDAOImpl implements GenreDAO {

	private JdbcTemplate jdbcTemplate;
	
	public GenreDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Genre genre) {
		if (genre.getId() > 0) {
			// update
			String sql = "UPDATE genre SET name=? "
						+ " WHERE genreId=?";
			jdbcTemplate.update(sql, genre.getTitle(), genre.getId());
		} else {
			// insert
			String sql = "INSERT INTO genre (title)"
						+ " VALUES (?)";
			jdbcTemplate.update(sql, genre.getTitle());
		}
		
	}

	@Override
	public void delete(int genreId) {
		String sql = "DELETE FROM genre WHERE genreId=?";
		jdbcTemplate.update(sql, genreId);
	}

	@Override
	public List<Genre> list() {
		String sql = "SELECT * FROM genre";
		List<Genre> listGenre = jdbcTemplate.query(sql, new RowMapper<Genre>() {

			@Override
			public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
				Genre aGenre = new Genre();
	
				aGenre.setId(rs.getInt("genreId"));
				return aGenre;
			}
			
		});
		
		return listGenre;
	}

	@Override
	public Genre get(int genreId) {
		String sql = "SELECT * FROM genre WHERE genreId=" + genreId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Genre>() {

			@Override
			public Genre extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Genre genre = new Genre();
					genre.setId(rs.getInt("genreId"));
					return genre;
				}
				
				return null;
			}
			
		});
	}

}
