package exercise;

public class PetName extends NameMixin {
	String firstname;
	String lastname;
	String middlename;
	
	public PetName(String fistname,String lastname, String middlename){
		this.firstname=fistname;
		this.lastname=lastname;
		this.middlename=middlename;
		
	}
	public  String getFirstName(){
		return firstname;
	}
	public  String getLastName(){
		return lastname;
	}
	public  String getMiddleName(){
		return middlename;
	}
	public void setFirstName(String newName){
		this.firstname=newName;
	}
	public void setLastName(String newName){
		this.lastname=newName;
	}
	public void setMiddleName(String newName){
		this.middlename=newName;
	}

}
