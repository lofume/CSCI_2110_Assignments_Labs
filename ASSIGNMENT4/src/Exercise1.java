import java.util.*;
import java.io.*;
public class Exercise1{
    public static void main(String[] args) throws FileNotFoundException{
        //value is fullname
        HashMap<String, String> user= new HashMap<String, String>();
        //value is password
        HashMap<String, String> passW= new HashMap<String, String>();
        System.out.print("Enter name info file: ");
        //read file Student.txt
        //get full name
        //get username and password
        //then add the above values to the HashMaps
        Scanner kb= new Scanner(System.in);
        String filename= kb.nextLine();
        File file= new File(filename);
        Scanner input= new Scanner(file);
        String line;
        String fN;
        String uN;
        String pW;
        while(input.hasNext()){
            line= input.nextLine();
            StringTokenizer tk= new StringTokenizer(line, "\t");
            fN= tk.nextToken();
            uN= tk.nextToken();
            pW= tk.nextToken();
            //puts username ->> fullname to user
            user.put(uN,fN);
            //puts username->> password to passW
            passW.put(uN,pW);
        }
        input.close();
        //user then needs to enter the login info and password
        //counts 3 tries and then displays fail message
        //if correct then success
        int tries=1;
        //checks if password is correct
        boolean correctPassW= false;
        while(tries<4 && !correctPassW){
            //get login info
            System.out.print("Login: ");
            uN=kb.nextLine();
            System.out.print("Password: ");
            pW= kb.nextLine();
            //if login info correct = success
            //if not correct then give total 3 tries and then support message
            if(pW.equals(passW.get(uN))){
                correctPassW= true;
                System.out.println("\nLogin successful");
                System.out.println("Welcome "+ user.get(uN));
            }
            //remainder attempt trials
            else{
                if(tries<3){
                    int tried= 3-tries;
                    System.out.println("\nEither the username or password is incorrect. You have "+ tried+ " more attemps.\n");
                }
                else
                    System.out.println("\nSorry. Incorrect login. Please contact the system administrator.");
                tries++;
            }
        }
        kb.close();
    }
}