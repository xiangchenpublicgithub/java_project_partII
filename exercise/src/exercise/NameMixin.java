package exercise;

public abstract class NameMixin implements Renameable {
	public  NameMixin(){}
	public abstract String getFirstName();
	public abstract String getLastName();
	public abstract String getMiddleName();
    public abstract void  setFirstName(String newName);
	public abstract void setLastName(String newName);
	public abstract void setMiddleName(String newName);
		
	}

