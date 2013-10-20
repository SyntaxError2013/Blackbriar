package graphsearch.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import graphsearch.indexing.GraphSearchIndexing;
import graphsearch.utils.*;

public class GraphSearchIndexingMain 
{
	/**
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException 
	{
		DBQuery db = new DBQuery();
		GraphSearchIndexing index = new GraphSearchIndexing();
		List<Map<String, String>> listOfMovies = db.getFromSQL();
		
		for(int i = 25000; i < listOfMovies.size(); i++)
		{
			System.out.println(i);
			Map<String, String> currentMovie = listOfMovies.get(i);
			GraphSearchDocument currentMovieDoc = new GraphSearchDocument(currentMovie);
			index.indexDocument(currentMovieDoc);
		}
	}
}
