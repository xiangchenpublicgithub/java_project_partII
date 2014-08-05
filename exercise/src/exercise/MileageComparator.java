package exercise;

public class MileageComparator implements Comparator<Car> {

	public int compare(Car a, Car b){
		return a.get_mileage()-b.get_mileage();
		
	}
}
//   ArrayList <Comparable> names=new ArrayList<Comparable>();
//   ArrayList <Mammals> mal=new ArrayList<Mammals>();