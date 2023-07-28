public class Pair implements Comparable<Pair> {
    //declare all required fields
    private char value;
    private double prob;

    //constructor
    public Pair(char value,double prob){
        this.value= value;
        this.prob=prob;
    }
    //getter and setters
    public char getValue(){
        return value;
    }
    public double getProb(){
        return prob;
    }
    public void setValue(char v){
        this.value=v;
    }
    public void setProb(double p){
        this.prob=p;
    }
    //toString method
    public String toString(){
        return value+ " "+ Double.toString(prob);
    }
    //compare method overrides method of comparable interface
    @Override
    public int compareTo(Pair p){
        return Double.compare(this.getProb(), p.getProb());
    }
}
