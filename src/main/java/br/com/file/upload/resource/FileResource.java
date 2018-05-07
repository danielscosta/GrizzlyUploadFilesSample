package br.com.file.upload.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
	
	@POST
	@Path("upload")
	public Response upload(File files[]) {

		FileFacade.upload(files);

		return Response.ok().build();
	}

}
