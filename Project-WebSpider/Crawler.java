import java.net.*;
import java.util.concurrent.locks.Lock;
import java.io.*;

public class Crawler {
	
    public static void main(String[] args) {
		
	MyQueue<URL> linkQueue = new MyQueue<URL>();
	MyQueue<URL> picQueue = new MyQueue<URL>();
	MySet<URL> beenThere = new MySet<URL>();
	MySet<URL> doneThat = new MySet<URL>();
		
	final int MAX_NUM_EXTRACTORS = 5;  // Change this to whatever you want
		
	ExtractorThread[] extractors = new ExtractorThread[MAX_NUM_EXTRACTORS];
		
	new SlideShowGUI(picQueue);
	new CrawlerGUI(linkQueue, picQueue, beenThere, doneThat, extractors);
		
	URL url = null;
		
	while(true) {
	    // YOU FILL THIS IN!!!  SEE THE PROJECT SPEC.
		for (int ithread = 0; ithread < MAX_NUM_EXTRACTORS; ithread ++) {
			if (extractors[ithread] == null || !extractors[ithread].isAlive()) {
				//System.out.println("need action " + ithread);
				
				//synchronized(extractors) { 
				boolean testURL = true;
				while (testURL) {
					url = linkQueue.dequeue();
					URLConnection conn;
					try {
						conn = url.openConnection();
						String contentType = conn.getContentType();
		 			    if (contentType.contains("text/html"))
		 			    	testURL = false;
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				//}
				
				extractors[ithread] = new ExtractorThread(url, linkQueue, picQueue, beenThere, doneThat);
				extractors[ithread].run();			
			}
			
			if (extractors[ithread].isAlive())
				continue;

		}
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    }
}
