package com.ibm.cloudoe.samples;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InstanceNumServlet
 */
@WebServlet(description = "Get the CF application instance number", urlPatterns = { "/InstanceNumServlet" })
public class InstanceNumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public InstanceNumServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * Return Cloud Foundry application instnace index number as JSON
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String instanceJson = "{\"instanceIndex\": " + System.getenv("CF_INSTANCE_INDEX") + " }";
		response.setContentType("application/json");
		
		response.getWriter().append(instanceJson);
	}

}
