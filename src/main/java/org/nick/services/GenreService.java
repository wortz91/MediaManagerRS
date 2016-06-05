package org.nick.services;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.nick.dao.GenreDAO;
import org.nick.entities.Genre;

@Path("/genre")
@Produces({ MediaType.APPLICATION_JSON  })
@Consumes({ "application/xml", "application/json" })
public class GenreService {
	GenreDAO gDAO = new GenreDAO();

	@GET
	public List<Genre> listAll() { 
		return gDAO.getAllGenres();
	}
}
