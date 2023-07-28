public class Employee {
    //instance variables
    private int employeeID;
    private String firstName;
    private String lastName;
    private String email;
    private String department;

    //constructors
    public Employee(int employeeID, String firstName, String lastName, String email, String department){
        this.employeeID = employeeID;
        this.firstName= firstName;
        this.lastName= lastName;
        this.email= email;
        this.department= department;
    }
    //getter methods
    public int getEmployeeID(){return employeeID;}
    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}
    public String getEmail(){return email;}
    public String getDepartment(){return department;}

    //setter methods
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
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

    public void setDepartment(String department) {
        this.department = department;
    }


    //toString method
    @Override
    public String toString() {
        return (employeeID + " " + firstName + " " + lastName + " "+ email + " " + department);
    }
}

