//This method contains the beginning for all other classes, which will extend to the Slow and Fast Pieces and Flexibles
//it contains all attributes
public class Piece{
    //instance variables
    private String name;
    private String color;
    private String type;
    private int xPos;
    private int yPos;
//constructors
    public Piece(String name, String color, String type, int xPos, int yPos){
        this.name= name;
        this.color= color;
        this.type= type;
        this.xPos= xPos;
        this.yPos= yPos;
    }
    //get methods
    public String getName(){return name;}
    public String getColor(){return color;}
    public String getType(){return type;}
    public int getXPos(){return xPos;}
    public int getYPos(){return yPos;}
    //set methods
    public void setName(String name){
        this.name= name;
    }
    public void setColor(String color){
        this.color= color;
    }
    public void setType(String type){
        this.type = type;
    }
    public void setXPos (int xPos){ this.xPos= xPos; }
    public void setYPos (int yPos){
        this.yPos= yPos;
    }
    // to string method
    public String toString(){
        return ("   "+ name + "" + color + "" + type + "");
    }






}