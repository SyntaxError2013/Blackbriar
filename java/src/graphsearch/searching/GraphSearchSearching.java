package graphsearch.searching;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.lucene.analysis.WhitespaceAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class GraphSearchSearching 
{
	private String indexLocation = "/home/neeraj/Desktop/Index";
	private Directory indexDirectory = FSDirectory.open(new File(indexLocation));
	private IndexSearcher indexSearcher = new IndexSearcher(indexDirectory);
	
	// constructor
	public GraphSearchSearching() throws IOException {}
	
	/* function to return results of a search query in the form of a map
	 * it takes field as input and query string as input.
	 */
	public Map<String, Float> search(String queryStr, String field) throws ParseException, IOException
	{
		queryStr = queryStr.toLowerCase();
		field = field.toLowerCase();
		Map<String, Float> map = new HashMap<String, Float>();
		QueryParser parser = new QueryParser(Version.LUCENE_30, field, new WhitespaceAnalyzer());
		Query query = parser.parse(queryStr);
		TopDocs hits = indexSearcher.search(query, 20);
		
		for(int i = 0; i < hits.scoreDocs.length; i++)
		{
			ScoreDoc scoreDoc = hits.scoreDocs[i];
			Document doc = indexSearcher.doc(scoreDoc.doc);
			map.put(doc.get("movie"), scoreDoc.score);
			
		}
		indexSearcher.close();
		return map;
	}
}
