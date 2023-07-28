public class Student {
    //instance variables
    private int studentID;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private String faculty;

    //constructors
    public Student(int studentID, String firstName, String lastName, String email, String major, String faculty){
        this.studentID = studentID;
        this.firstName= firstName;
        this.lastName= lastName;
        this.email= email;
        this.major= major;
        this.faculty= faculty;
    }
    //getter methods
    public int getStudentID(){return studentID;}
    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}
    public String getEmail(){return email;}
    public String getMajor(){return major;}
    public String getFaculty(){return faculty;}

    //setter methods
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    //toString method
    @Override
    public String toString() {
        return (studentID + " " + firstName + " " + lastName + " "+ email + " " + faculty+ " " + major);
    }
}
