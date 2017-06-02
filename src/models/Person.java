package models;

/**
 * This class is the template for a single Person. This is a super class for Member and Trainer.
 *
 * The details stored for a member include:
 *     Name
 *     e-mail
 *     Address
 *     Gender
 *
 * 
 *
 * @author Bernadette Murphy
 */
abstract public class Person {
    private String name;
    private String email;
    private String address;
    private String gender;


    /**
     * Constructor for objects of class Person.
     *
     * @param name The Person's name should be no more than 30 characters. If the
     *             entered name exceeds 30 characters, the extra characters will be
     *             truncated and only the first 30 characters will be used.
     *
     * @param email The Person's e-mail should contain an '@' symbol. No other
     *              validation is required.
     *
     * @param address There is no validation on the member's address.
     *
     * @param gender The member's gender can be either "M" or "F". lower case entries
     *               will be changed to upper case. If not specified, this will default
     *               to "Unspecified".
     * @param specialty 
     */
    public Person(String name, String email, String address, String gender, String specialty) {
        if (name.length() <= 30)
        {
            this.name = name;
        }
        else
        {
            this.name = name.substring(0, 30);
        }
        {
            this.email = email.toLowerCase();
        }
        this.address = address;
        if ((gender.toUpperCase().equals("M")) || (gender.toUpperCase().equals("F"))) {
            this.gender = gender.toUpperCase();
        }
        else
        {
            this.gender = "Unspecified";
        }
    }

    //********************************************************************************
    //  SETTERS
    //********************************************************************************



    /**
     * This method updates the email field.
     * @param email The Person's e-mail must contain an '@' symbol.
     */
    public void setEmail(String email) {
        if (email.contains("@")){
        
            this.email = email;
        }
        else
        {
            this.email = "Invalid Email";
        }
    }

    /**
     * This method updates the name field.
     * @param name The person's name should be no longer than 30 characters. If
     *             the entered name exceeds 30 characters, the extra characters
     *             will be truncated and only the first 30 characters will be used.
     */
    public void setName(String name) {
        if (name.length() <= 30)
        {
            this.name = name;
        }
        else
        {
            this.name = name.substring(0, 30);
        }

    }

    /**
     * This method updates the address field.
     * @param address There is no validation on the member's address.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * This method updates the gender field.
     * @param gender The member's gender can be either "M" or "F". lower case entries
     *               will be changed to upper case. If not specified, this will default
     *               to "Unspecified".
     */
    public void setGender(String gender) {
        if ((gender.toUpperCase().equals("M")) || (gender.toUpperCase().equals("F"))) {
            this.gender = gender.toUpperCase();
        }
        else
        {
            this.gender = "Unspecified";
        }
    }

    //********************************************************************************
    //  GETTERS
    //********************************************************************************

    /**
     * Returns the e-mail of the Person.
     * @return the Person's e-mail
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns the name of the Person.
     * @return the Person's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the address of the Person.
     * @return the Person's address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Returns the gender of the Person.
     * @return the Person's gender.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Returns a human-readable String representation of the object state.
     *
     * @return a string version of the Person object. The String returned
     * is similar to this structure:
     *
     * 
     */
    /**
     * Updates the person's gender.
     * @param gender Updates the person's gender
     */
    public void setgender(String gender) {

        gender = gender.toUpperCase();
        if (gender.equals("MALE") || gender.equals("FEMALE")){
            this.gender = gender.substring(0,1);
        }
        else if (gender.length() == 1 && (gender.charAt(0) == 'M' || gender.charAt(0) == 'F')){
            this.gender = gender;
        }
    }
    //----
    //HelperMethods
    //-------
    @Override
    public String toString() {
    	return "Person{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", gender=" + gender +
                '}';
    }

	public Object chosenPackage(String packageChoice) {
		Object chosenPackage = null;
		return chosenPackage;
		
	}
}

