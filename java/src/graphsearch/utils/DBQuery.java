package graphsearch.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBQuery 
{
	private Connection connect = null;
	private Statement statement = null;
    private ResultSet resultSet = null;
	
    
	/* function to get all the data from the database. Function returns of list of maps.
	 * One map contains all information about a movie.
	 */	
	public List<Map<String, String>> getFromSQL() throws SQLException, ClassNotFoundException 
	{
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
	    Class.forName("com.mysql.jdbc.Driver");
	    connect = DriverManager.getConnection("jdbc:mysql://172.17.10.167/?"+ "user=neeraj&password=maverick");  // link to database pending
	    statement = connect.createStatement();
	    System.out.print(statement.toString());
	    resultSet = statement.executeQuery("select * from testdb.Actors");
	    System.out.println("\n" + resultSet.getFetchSize());
	    while( resultSet.next() ) 
	    {
	    	Map<String, String> tempMap = new HashMap<String, String>();
	    	tempMap.put("Name", resultSet.getString("Name").replaceAll(",", ""));
	    	tempMap.put("Movie", resultSet.getString("Movie"));
	    	tempMap.put("Year", resultSet.getString("Year"));
	    	tempMap.put("Role", resultSet.getString("Role"));
	    	list.add(tempMap);
	    }
	    return list;
	}
}
