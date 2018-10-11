package br.com.file.upload.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.file.upload.facade.FileFacade;

import br.com.file.upload.model.File;

@Path("files")
public class FileResource {

	@GET
	@Produces({MediaType.TEXT_PLAIN})
	@Path("alive")
	public String alive() {

		return "I'm alive";
	}

    @GET
    @Path("readAll")
    @Produces({MediaType.APPLICATION_JSON})
    public Response readAll() {

        return Response.ok(FileFacade.readAll()).build();
    }
	
	@PUT
	@Path("upload")
	public Response upload(File files[]) {

		FileFacade.upload(files);

		return Response.ok().build();
	}

    @DELETE
    @Path("delete/{id}")
    public Response delete(@PathParam("id") int id) {

        FileFacade.delete(id);

        return Response.ok().build();
    }



}
