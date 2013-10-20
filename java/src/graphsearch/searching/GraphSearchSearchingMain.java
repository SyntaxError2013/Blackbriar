package graphsearch.searching;

import java.io.IOException;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.*;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GraphSearchSearchingMain {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		GraphSearchSearching s = new GraphSearchSearching();
		Server server = new org.eclipse.jetty.server.Server(1236);
	    server.setHandler(new GraphSearchServlet());
	    server.start();
	    server.join();
	}

}
