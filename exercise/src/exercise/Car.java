package exercise;

public class Car implements Comparable<Car>{
    private String tag;
    private int mileage;
	public Car(String tag,int mileage){
		this.tag=tag;
		this.mileage=mileage;
	}
	public String toString(){
		return this.tag+"-"+this.mileage;
	}
	public boolean equals(Object o){
		if(o==null) return false;
		if(this.getClass()!=o.getClass()) return false;
		Car temp=(Car)o;
        return this.tag.compareTo(temp.tag)==0;
	}
	public int compareTo(Car a){
		return this.tag.compareTo(a.tag);
	}
	public int get_mileage(){
		return this.mileage;
	}
}
