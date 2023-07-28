public class StudentList {
    //creation of the list
    private List<Student> student;
    //creation of a new list
    public StudentList(){
        student = new List<Student>();
    }
    //methods similar to the ones in the ExpenseList
    public boolean isEmpty() {return student.isEmpty();}
    public Student first(){return student.first();}
    public Student next()
    {
        return student.next();
    }
    //adds a "value" s to the student list
    public void addRecord(Student s)
    {
        student.add(s);
    }
    public void enumerate() { student.enumerate(); }
    // will delete a student's record based on their ID
    public void deleteRecord(int ID){
        Student s = student.first();
        int i;
        while(s!=null){
            i= s.getStudentID();
            if(i==ID){
                student.remove(s);
            }
            s= student.next();
        }
    }
    //THE NEXT 3 METHODS ARE REPEATED SPECIFIC TO THEIR OUTPUTS (VOID METHODS)
    //displays majors
    public void displayMajors(String major){
        Student s= student.first();
        String m;
        while(s!=null){
            m= s.getMajor();
            if(m.equals(major)){
                System.out.println(s);
            }
            s= student.next();
        }
    }
    //displays faculty
    public void displayFaculty(String faculty){
        Student s= student.first();
        String f;
        while(s!=null){
            f= s.getFaculty();
            if(f.equals(faculty)){
                System.out.println(s);
            }
            s= student.next();
        }

    }
    //displays last name
    public void displayName(String lName){
        Student s= student.first();
        String l;
        while(s!=null) {
            l = s.getLastName();
            if (l.equals(lName)) {
                System.out.println(s);
            }
            s = student.next();
        }
    }
    //this method displays the student record, based on the email
    public void displayEmail(String email){
        Student s= student.first();
        String e;
        while(s!=null) {
            e = s.getEmail();
            if (e.equals(email)) {
                System.out.println(s);
            }
            s = student.next();
        }
    }
    // searches for the student and returns based on the ID
    public Student searchID (int ID){
        Student s= student.first();
        int id;
        while(s!=null){
            id= s.getStudentID();
            if(id==ID){
                return s;
            }
            s= student.next();
        }
        return s;
    }
}
