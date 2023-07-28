public class EmployeeList {
    //creation of the list
    private List<Employee> employees;
    //creation of a new list
    public EmployeeList(){
        employees = new List<Employee>();
    }
    //methods similar to the ones in the ExpenseList lab 4
    public boolean isEmpty() {return employees.isEmpty();}
    public Employee first(){return employees.first();}
    public Employee next()
    {
        return employees.next();
    }
    //adds a "value" e to the employee list
    public void addEmployee(Employee e)
    {
        employees.add(e);
    }
    public void enumerate() { employees.enumerate(); }

    // will delete a employee's record based on their ID
    public void deleteEmployee(int ID){
        Employee e = employees.first();
        int i;
        while(e!=null){
            i= e.getEmployeeID();
            if(i==ID){
                employees.remove(e);
            }
            e= employees.next();
        }
    }
    // searches for the employee and returns based on the ID
    public Employee searchID (int ID){
        Employee e= employees.first();
        int id;
        while(e!=null){
            id= e.getEmployeeID();
            if(id==ID){
                return e;
            }
            e= employees.next();
        }
        return e;
    }
}


