package graphsearch.indexing;

import graphsearch.searching.GraphSearchSearching;
import graphsearch.utils.DBQuery;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.lucene.queryParser.ParseException;

public class GraphSearchTest 
{

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ParseException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IOException, ParseException, ClassNotFoundException, SQLException 
	{
		// TODO Auto-generated method stub
		/*List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		GraphSearchIndexing index = new GraphSearchIndexing();		
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("movie", "Fight Club");
		map1.put("actors", "Brad Pitt");
		map1.put("description", "Fight Club is a 1999 American drama film based on the 1996 novel of the same name by Chuck Palahniuk. The film was directed by David Fincher and stars Edward Norton, Brad Pitt, and Helena Bonham Carter.");
		list.add(map1);
		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("movie", "The Shawshank Redemption");
		map2.put("actors", "Morgan Freeman");
		map2.put("description", "The Shawshank Redemption is a 1994 American drama film written and directed by Frank Darabont and starring Tim Robbins and Morgan Freeman.");
		list.add(map2);
		for(int i = 0; i < list.size(); i++)
		{
			Map<String, String> currentMovie = list.get(i);
			GraphSearchDocument currentMovieDoc = new GraphSearchDocument(currentMovie);
			index.indexDocument(currentMovieDoc);
		}
		GraphSearchSearching search = new GraphSearchSearching();
		System.out.println(search.search("greg abbey", "name").toString());
		/*DBQuery db = new DBQuery();
		List<Map<String, String>> list = db.getFromSQL();
		System.out.println("\n" + list.size());
		/*for(int i = 0; i < 10; i++)
		{
			System.out.println("\n" + list.get(i));
		}*/
		/*String query = "movies%20with%20richard%20stallman%20and%20neeraj%20gangwar%20in%201993";
	    String[] queryArr = query.split("%20");
	    List<String> list = Arrays.asList(queryArr);
	    int indexOfWith = list.indexOf("with");
	    int indexOfAs = list.indexOf("as");
	    int indexOfCharacter = list.indexOf("character");
	    int indexOfYear = list.indexOf("in");
	    
	    List<String> actors = new ArrayList<String>();
	    if( indexOfWith != -1 )
	    {
	    	String temp1 = list.get(++indexOfWith);
	    	while(indexOfWith < list.size() && temp1.compareTo("in") != 0 && temp1.compareTo("as") != 0 && temp1.compareTo("character") != 0) 
	    	{
	    		String temp2 = temp1, name = "";
	    		while( temp2.compareTo("and") != 0 && temp2.compareTo("in") != 0 && temp2.compareTo("as") != 0 && temp2.compareTo("character") != 0 )
		    	{
		    		name += temp2 + " ";
		    		temp2 = list.get(++indexOfWith);
		    	}
	    		actors.add(name);
	    		System.out.println(name);
	    		if(temp2.compareTo("in") == 0 || temp2.compareTo("as") == 0 || temp2.compareTo("character") == 0)
	    			break;
	    		
	    		temp1 = list.get(++indexOfWith);
	    	}
	    	
	    	
	    }*/
		/*Map<String, String> map1 = new HashMap<String, String>();
		map1.put("1", "1");
		map1.put("2", "2");
		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("1", "1");
		map1.keySet().retainAll(map2.keySet());
		System.out.println(map1);*/
		
	}
}
