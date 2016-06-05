package org.nick.services;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.nick.dao.MediaItemDAO;
import org.nick.entities.MediaItem;

@RequestScoped
@Path("/mediaitem")
@Produces({ MediaType.APPLICATION_JSON  })
@Consumes({ "application/xml", "application/json" })
public class MediaItemService {
	MediaItemDAO miDAO = new MediaItemDAO();

	@GET
	public List<MediaItem> listAll() { 
		return miDAO.getAllMediaItems();
	}
}
