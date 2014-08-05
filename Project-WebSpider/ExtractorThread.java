import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

public class ExtractorThread extends Thread {

    private URL url;
    private MyQueue<URL> linkQueue, picQueue;
    private MySet<URL> beenThere, doneThat;

    public ExtractorThread(URL url, MyQueue<URL> linkQueue, MyQueue<URL> picQueue, MySet<URL> beenThere, MySet<URL> doneThat) {
	this.url = url;
	this.linkQueue = linkQueue;
	this.picQueue = picQueue;
	this.beenThere = beenThere;
	this.doneThat = doneThat;
    }

    public String getCurrentURL() {
	return url.toString();
    }

    private static Pattern LINK_PATTERN = Pattern.compile("href *= *\"([^\"]*)\"", Pattern.CASE_INSENSITIVE);
    private static Pattern IMAGE_PATTERN = Pattern.compile("<( )*(img|IMG)( )+([^<>])*(src|SRC)( )*=( )*\"([^\"]+)\"[^>]*>");

    private static Set<URL> extractLinks(Pattern toMatch, String s, URL currentURL, int group) {
	Matcher m = toMatch.matcher(s);
	Set<URL> links = new HashSet<URL>();
	while ( m != null && s!= null && m.find()) {
	    String found = m.group(group);
	    try {
		links.add(new URL(currentURL, found));
	    } catch (MalformedURLException e) {
		// just ignore
	    }
	}
	return links;
    }

    private static Set<URL> getLinks(String s, URL currentURL) {
	return extractLinks(LINK_PATTERN, s, currentURL, 1);
    }

    private static Set<URL> getPicURLs(String s, URL currentURL) {
	return extractLinks(IMAGE_PATTERN, s, currentURL, 8);
    }

    public void run() {
	// 	YOU MUST WRITE THIS METHOD!  SEE THE PROJECT SPEC.
    	try {
            // get URL content
            URLConnection conn = url.openConnection();

            // open the stream and put it into BufferedReader
            BufferedReader br = new BufferedReader(
                               new InputStreamReader(conn.getInputStream()));

            String inputLine;
            while ((inputLine = br.readLine()) != null) {
            	collectLinks(inputLine);
            	collectPics(inputLine);
            }
            br.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void collectLinks(String inputLine) {
    	Set<URL> tempURLs = getLinks(inputLine, url);
    	for (URL a_url : tempURLs) {
    		if (a_url.getProtocol().equalsIgnoreCase("http") || 
    				a_url.getProtocol().equalsIgnoreCase("file")) {
    			if (!beenThere.contains(a_url)) {
    				linkQueue.enqueue(a_url);
    				beenThere.add(a_url);
    			}
    		}
    	}
    }
    
    private void collectPics(String inputLine) {
    	Set<URL> tempURLs = getPicURLs(inputLine, url);
    	for (URL a_url : tempURLs) {
			if (!doneThat.contains(a_url)) {
				picQueue.enqueue(a_url);
				doneThat.add(a_url);
			}
    	}
    	
    }

}
