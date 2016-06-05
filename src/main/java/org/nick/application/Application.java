package org.nick.application;

import java.util.List;

import org.nick.dao.GenreDAO;
import org.nick.entities.Genre;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenreDAO gDAO = new GenreDAO();
		
		List<Genre> items = gDAO.getAllGenres();
		
		for(Genre genre : items) {
			System.out.println(genre.getGenreDescription());
		}
	}

}
