import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.StaticHttpHandler;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import br.com.file.upload.resource.FileResource;

public class Main {

	public static void main(String[] args) {
	    
	    final ResourceConfig rc = new ResourceConfig();
	    rc.register(FileResource.class);
	    
	    HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create("http://0.0.0.0:8881/api"), rc);
	    server.getServerConfiguration().addHttpHandler(new StaticHttpHandler("src/main/webapp"), "/");
	 }
}
