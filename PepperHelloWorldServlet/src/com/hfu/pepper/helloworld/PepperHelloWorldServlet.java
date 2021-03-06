package com.hfu.pepper.helloworld;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aldebaran.qi.Application;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Servlet implementation class PepperHelloWorldServlet
 */
@WebServlet("/PepperHelloWorldServlet")
public class PepperHelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PepperTest pepper;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PepperHelloWorldServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        PrintWriter out = response.getWriter();
        out.print("<html><body><h1 align='center'>" + new Date().toString() + "</h1>"
        		+ "<form action=\"/PepperHelloWorldServlet/PepperHelloWorldServlet\" method=\"post\">\n" + 
        		"  <button name=\"forwardBtn\" type=\"submit\">Pepper say: Hello World!</button>\n" + 
        		"</form>"
        		+ "</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
        String ip_address = "192.168.0.41";
        int port = 9559;
		
	    String robotUrl = "tcp://" + ip_address + ":" + port;
	    String[] args = new String[0];
	    
	    Application application = new Application(args, robotUrl);
	    application.start();
	    
	    pepper = new PepperTest(ip_address, port, application);
	    
	    application.run();
	    
		pepper.say("Hello World!");
		
	    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/PepperHelloWorldServlet");
	    dispatcher.forward(request, response);
	}

}
