package graphsearch.searching;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.io.IOException;
import org.json.JSONObject;
import java.io.PrintWriter;

import org.apache.lucene.queryParser.ParseException;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.server.Request;

public class GraphSearchServlet extends AbstractHandler {

	@Override
	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		response.setContentType("application/json");
	    response.setStatus(HttpServletResponse.SC_OK);
	    String query = request.getParameter("query");
	    
	    String[] queryArr = query.split(Pattern.quote(" "));
	    System.out.println(queryArr[1]);
	    
	    List<String> list = Arrays.asList(queryArr);
	    //System.out.println(list);
	    int indexOfWith = findIndex(queryArr, "with");
	    int indexOfAs = findIndex(queryArr, "as");
	    int indexOfCharacter = findIndex(queryArr, "character");
	    int indexOfYear = findIndex(queryArr, "year");
	    Map<String, Float> mapActor = new HashMap<String, Float>();
	    Map<String, Float> mapYear = new HashMap<String, Float>();
	    Map<String, Float> mapChar = new HashMap<String, Float>();
	    GraphSearchSearching s = new GraphSearchSearching();
	    
	    //System.out.println(indexOfWith + " / " + indexOfAs + " / " +  indexOfCharacter);
	    
	    List<String> actors = new ArrayList<String>();
	    if( indexOfWith != -1 )
	    {
	    	String temp1 = list.get(++indexOfWith);
	    	while(indexOfWith < list.size()-1 && temp1.compareTo("in") != 0 && temp1.compareTo("as") != 0 && temp1.compareTo("character") != 0) 
	    	{
	    		System.out.println("while");
	    		String temp2 = temp1, name = "";
	    		while( temp2.compareTo("and") != 0 && temp2.compareTo("in") != 0 && temp2.compareTo("as") != 0 && temp2.compareTo("character") != 0 )
		    	{
	    			System.out.println("inner while");
		    		name += temp2 + " ";
		    		if( indexOfWith < list.size()-1)
		    			temp2 = list.get(++indexOfWith);
		    		else
		    			break;
		    	}
	    		actors.add(name);

	    		if(temp2.compareTo("in") == 0 || temp2.compareTo("as") == 0 || temp2.compareTo("character") == 0)
	    			break;
	    		if( indexOfWith < list.size()-1)
	    			temp1 = list.get(++indexOfWith);
	    	}
	    	
	    	System.out.println("working");
	    	
	    	
	    	
	    	for( int j = 0; j < actors.size(); j++)
	    	{
	    		System.out.println(actors.get(j));
	    		String q = actors.get(j);
	    		Map<String, Float> temp = new HashMap<String, Float>();
				try {
					temp = s.search(q, "name");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(temp);
	    		if( j == 0)
	    			mapActor = temp;
	    		else
	    			mapActor.keySet().retainAll(temp.keySet());
	    	}
	    	System.out.println("map" + mapActor);
	}
	    
	    
	    if( indexOfYear != -1)
	    {
	    	String q1 = list.get(++indexOfYear);
	    	try {
				mapYear = s.search(q1, "year");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    }
	    
	    if( indexOfCharacter != -1)
	    {
	    	String q2 = list.get(++indexOfCharacter);
	    	try {
				mapChar = s.search(q2, "character");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    if( indexOfAs != -1)
	    {
	    	String q3 = list.get(++indexOfAs);
	    	try {
				mapChar = s.search(q3,  "year");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    if( mapChar.size() != 0 )
	    {
	    	System.out.println("mapchar");
	    	mapActor.keySet().retainAll(mapChar.keySet());
	    }
	    
	    if( mapYear.size() != 0)
	    {
	    	System.out.println("mapyear");
	    	mapActor.keySet().retainAll(mapYear.keySet());
	    }
	    
	    Map<String, Float> result = new HashMap<String, Float>();
	    System.out.println(mapActor);
	    result.putAll(mapActor);
	    
	    System.out.println(result);
	    
	    JSONObject t = new JSONObject(result);
	    String str = t.toString();
	    PrintWriter out = response.getWriter();
	    out.print(str);
	    out.flush();
	}
	
	public int findIndex(String[] str, String q)
	{
		int i;
		for(i = 0; i < str.length; i++)
		{
			if( q.equals(str[i]))
				return i;
		}
		return -1;
	}
}

class ValueComparator implements Comparator<String> 
{
	Map<String, Float> base;
	
    public ValueComparator(Map<String, Float> base) 
    {
        this.base = base;
    }

       
    public int compare(String a, String b) 
    {
        if (base.get(a) >= base.get(b)) 
        {
            return -1;
        }
        else
        {
            return 1;
        }
    }
}
