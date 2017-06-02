package models;

/**
 * A concrete subclass of the Person class that holds the trainers specialty
 *
 * 
 */
public class Trainer extends Person{

    String specialty;

    /**
     * Constructor for Trainer class
     *
     * @param speciality a string defining the trainer's specialty
     */
    public Trainer(String email, String name, String address, String gender, String specialty) {

        super(email,name,address,gender, specialty) ;
        this.specialty = specialty;
       ;
    }

    /**
     * Returns the trainer's specialty
     * @return The trainer's specialty
     */
    public String getSpeciality() {
        return specialty;
    }
    public String getEmail() {
		return getEmail();
	}
    public String getName(){
    	return getName();
    }
    public String getGender(){
    	return getGender();
    }
    public String getAddress(){
    	return getAddress();
    }

	  

    /**
     * Updates the trainer's specialty
     * @param speciality Updates the trainer's specialty
     */
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    /**
     * Returns a human readable String interpretation of the trainer's details
     * @return A string version of the trainer object.
     */
  

	public void setEmail(String string) {
		return;
	}

	public void setName(String string) {
		return ;
		
	}

	public void setAddress(String string) {
		return ;
		
	}

	public void setGender(String string) {
		return ;
		
	}
	  public String toString() {
	    	        return "NAME..........." + getName() + "\n" +
	    	                "EMAIL.........." + getEmail() + "\n" +
	    	                "GENDER........." + getGender() + "\n" +
	    	                "SPECIALITY....." + getSpeciality();
	    	    }
}
	

	