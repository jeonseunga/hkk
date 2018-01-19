package receipe;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class FoodCodeDBBean {
	private static FoodCodeDBBean instance = new FoodCodeDBBean();
	public static FoodCodeDBBean getInstance()
	{
		return instance;
	}
	
	public Connection getConnection() throws NamingException, SQLException
	{
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/kh");
		return ds.getConnection();
	}
}
