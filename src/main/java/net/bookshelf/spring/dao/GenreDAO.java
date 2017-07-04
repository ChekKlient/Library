package net.bookshelf.spring.dao;

import net.bookshelf.spring.model.*;

import java.util.List;

/**
 * Defines DAO operations for the contact model.
 * @author www.codejava.net
 *
 */
public interface GenreDAO {
	
	void saveOrUpdate(Genre genre);
	
	void delete(int genreId);
	
	Genre get(int genreId);
	
	List<Genre> list();
}
