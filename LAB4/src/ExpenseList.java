public class ExpenseList
{
	//instance variable
	private List<Expense> expenses;
	
	//constructor
	public ExpenseList()
	{
		expenses = new List<Expense>();
	}
	//void method that adds to expenses
	public void add(Expense exp)
	{
		expenses.add(exp);
	}


	public boolean isEmpty()
	{
		return expenses.isEmpty();
	}
	public boolean contains(Expense exp)
	{
		return expenses.contains(exp);
	}
	public Expense first()
	{
		return expenses.first();
	}
	public Expense next()
	{
		return expenses.next();
	}
	public void enumerate()
	{
		expenses.enumerate();
	}

	//returns max expense
	public double maxExpense()
	{
		double max =0.0, amt;
		Expense exp = expenses.first();
		while (exp!=null)
		{
			amt = exp.getAmount();
			if (amt>max)
				max = amt;
			exp = expenses.next();
		}
		return max;
	}
	//returns min expense
	public double minExpense()
	{
		double min =Double.MAX_VALUE, amt;
		Expense exp = expenses.first();
		if (exp==null) return 0.0;
		else
		{
		
			while (exp!=null)
			{
				amt = exp.getAmount();
				if (amt<min)
					min = amt;
				exp = expenses.next();
			}
		}
		return min;
	}
	//returns the average of a sum of expenses
	public double avgExpense()
	{
        int x=0;
        double sum= 0.0;
        double amt;
        Expense exp = expenses.first();
        if(exp==null){
			return 0.0;
		}
        else{
        	while(exp != null){
        		amt= exp.getAmount();
        		sum= sum + amt;
        		x++;
        		exp = expenses.next();
			}
		}
        return (sum/x);
	}

	// returns the total amount of all expenses
	public double totalExpense() {
       double sum= 0.0;
       double amt;
       Expense exp= expenses.first();
       if(exp==null) {
		   return 0.0;
	   }
       else{
       	while(exp!=null){
       		amt = exp.getAmount();
       		sum = sum + amt;
       		exp= expenses.next();
		}
	   }
       return sum;
	}

	//returns the amount spent on a specific section in expenses i.e groceries, bills etc.
	public double amountSpentOn(String expItem)
	{
        Expense exp = expenses.first();
        double x=0;
        if(exp==null) {
			return 0.0;
		}
        else{
        	while(exp != null){
        		if(exp.getItem().equals(expItem)){
        			x= x+ exp.getAmount();
				}
        		exp = expenses.next();
			}
		}
		return x;
	}
	
	
}
