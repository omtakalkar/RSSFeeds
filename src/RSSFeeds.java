import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class RSSFeeds
{
  public static void main(String [] args)
  {
    System.out.println(readRSS("https://news.google.co.in/news?cf=all&hl=en&pz=1&ned=in&output=rss"));
  }

  public static String readRSS( String urlAddress)
  {
  try
 {
    URL rssURL = new URL(urlAddress);
       
    BufferedReader in = new BufferedReader (new InputStreamReader(rssURL.openStream()));
    
    String line;
	String  sourceCode = "";
	while ((line = in.readLine()) != null) {
	    int titleEndIndex = 0;
	    int titleStartIndex = 0;
	    while (titleStartIndex >= 0)
	    {
	        titleStartIndex = line.indexOf("<title>", titleEndIndex);
	        if (titleStartIndex >= 0)
	        {
	            titleEndIndex = line.indexOf("</title>", titleStartIndex);
	            sourceCode += line.substring(titleStartIndex + "<title>".length(), titleEndIndex) + "\n";
	        }
	    }
	}
 in.close(); 
return sourceCode;
}
catch(IOException ioe)
{
  System.out.println("error");
}
return urlAddress;
}
}  