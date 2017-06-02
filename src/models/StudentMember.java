package models;
/**This class will is a template for a student member 
*the details that will be stored include: 
*-Student ID 
*-College name 
*/

public abstract class StudentMember extends Member {
private  int studentId;
private String collegeName;


public StudentMember(String email, String collegname, String address, String gender, double height, double startingWeight,
        String chosenPackage) {
super (email, collegname, address, gender, startingWeight, startingWeight, chosenPackage);
this.studentId = studentId;
this.collegeName = collegeName;

}




@Override
public Object chosenPackage(String packageChoice){

    setChosenPackage(packageChoice);
	return packageChoice;
}
/** 
 * Returns the id for the student.
 * @return the  id
 */
public int getStudentId(){
   return studentId;
}  

public String getGender() {
	return getGender();
}




public String getEmail() {
	return getEmail();
}




public String getMemberProgress() {
	
	return getMemberProgress();
}

public String getCollgeName(){
	return collegeName;}
public String getAddress() {
	
	return getAddress();
}
public void setStudentId(int studentId){
	if ((studentId>100000)&&(studentId<=999999)){
		this.studentId=studentId;
	}
}
	public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }
	@Override
    public String toString() {
        return  "NAME..........." + getCollgeName() + "\n" +
                "EMAIL.........." + getEmail() + "\n" +
                "STUDENT ID....." + getStudentId() + "\n" +
               "COLLEGE........" + getCollgeName() + "\n" +
                "GENDER........." + getGender() + "\n" +
                "HEIGHT........." + getHeight() + "\n" +
                "START WEIGHT..." + getWeight();
    }




	
	}



