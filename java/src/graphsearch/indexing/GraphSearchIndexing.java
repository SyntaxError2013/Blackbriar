package graphsearch.indexing;

import graphsearch.utils.GraphSearchDocument;
import java.io.File;
import java.io.IOException;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class GraphSearchIndexing 
{
	private String indexLocation = "/home/neeraj/Desktop/Index";
	File file = new File(indexLocation);
	private FSDirectory indexDirectory = FSDirectory.open(file, null);	
	private IndexWriter indexWriter = new IndexWriter(indexDirectory, new StandardAnalyzer(Version.LUCENE_30), false, IndexWriter.MaxFieldLength.UNLIMITED);
	
	public GraphSearchIndexing() throws IOException {}
	
	public void indexDocument(GraphSearchDocument doc) throws CorruptIndexException, IOException
	{
		indexWriter.addDocument(doc.getDocument());
		indexWriter.commit();
		//indexWriter.optimize();
	}
}
