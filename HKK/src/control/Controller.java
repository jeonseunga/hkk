package control;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import handler.CommandHandler;
import handler.DefaultHandler;

public class Controller extends HttpServlet {
	
	private Map<String, CommandHandler> handlerMap 
	   = new HashMap<String, CommandHandler>();
	
	
	public void init(ServletConfig config)
			throws ServletException{
	String configFile = config.getInitParameter("configFile");
	String filename = config.getServletContext().getRealPath("/")+ configFile;
	Properties prop = new Properties();
	FileInputStream fis = null;
	
	try {
		fis = new FileInputStream(filename);
		prop.load(fis);
		
		Iterator<Object> keys =  prop.keySet().iterator();
		while(keys.hasNext()){
			//키를 하나 꺼내줌
			String command = (String) keys.next();
		    String handlerName = prop.getProperty(command);
		    Class<?> handlerClass = Class.forName(handlerName);
		    CommandHandler handlerInstance = (CommandHandler)handlerClass.newInstance();
		    
		    handlerMap.put(command, handlerInstance);
		    
		}
		
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	} catch (IOException e) {
		
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	} catch (InstantiationException e) {
		
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		
		e.printStackTrace();
	}
	
	
	
	}
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		
		String command = request.getRequestURI();
		if(command.indexOf(request.getContextPath()) == 0){
			command = command.substring(request.getContextPath().length()); //~.do 부분
		}
		CommandHandler handler = handlerMap.get(command);
		if(handler == null){
			handler = new DefaultHandler();
		}
		String viewpage = null;
		
		try {
			viewpage = handler.process(request, response);
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewpage);
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doProcess(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doProcess(req, resp);
	}
}
