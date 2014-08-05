import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MyQueue<T> {

	/* YOU WRITE THIS CLASS */
	private List<T> mq = new LinkedList<T>();
	//private Queue<T> mq;
		
	public int size(){
		return mq.size();
	}

	public void clear() {
		mq.clear();
	}

	public synchronized void enqueue(T o) {
		if(mq.size() == 0)
		    notifyAll();

		mq.add(o);
	}

	public synchronized T dequeue() {
		while (mq.size() == 0) {
	        try {
				wait();
			} catch (InterruptedException e) {
			}
	    }
		
		return mq.remove(0);			
	}
	
}
