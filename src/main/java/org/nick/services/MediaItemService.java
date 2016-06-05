package org.nick.services;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

import org.nick.dao.MediaItemDAO;
import org.nick.entities.MediaItem;

@RequestScoped
@Path("/mediaitem")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class MediaItemService {

	@POST
	public Response create(final MediaItem mediaitem) {
		//TODO: process the given mediaitem 
		//here we use MediaItem#getId(), assuming that it provides the identifier to retrieve the created MediaItem resource. 
		return Response
				.created(
						UriBuilder.fromResource(MediaItemService.class).path(String.valueOf(mediaitem.getId())).build())
				.build();
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final int id) {
		//TODO: retrieve the mediaitem 
		MediaItemDAO miDAO = new MediaItemDAO();
		MediaItem mediaItem = miDAO.getMediaItemById(id);
		if (mediaItem == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(mediaItem).build();
	}

	@GET
	public List<MediaItem> listAll(@QueryParam("start") final Integer startPosition,
			@QueryParam("max") final Integer maxResult) {
		//TODO: retrieve the mediaitems
		MediaItemDAO miDAO = new MediaItemDAO();

		return miDAO.getAllMediaItems();
	}

	@PUT
	@Path("/{id:[0-9][0-9]*}")
	public Response update(@PathParam("id") Long id, final MediaItem mediaitem) {
		//TODO: process the given mediaitem 
		return Response.noContent().build();
	}

	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") final Long id) {
		//TODO: process the mediaitem matching by the given id 
		return Response.noContent().build();
	}

}
