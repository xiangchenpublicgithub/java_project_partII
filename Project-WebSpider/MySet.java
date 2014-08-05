import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class MySet<T> {

	/* YOU WRITE THIS CLASS */
	private HashSet<T> ms = new HashSet<T>();
	
	public int size(){
		return ms.size();
	}

	public void clear() {
		ms.clear();
	}

	public boolean remove(T o) {
		return ms.remove(o);			
	}
	
	public boolean add(T o) {
		return ms.add(o);
	}
	
	public boolean contains(T o) {
		return ms.contains(o);
	}
	
}