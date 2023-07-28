import java.awt.*;
import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;
import java.util.*;

public class NHLStatsDemo {
        public static void main(String[] args) throws IOException {

            //code similar to the ExpenseListDemo class
            Scanner keyboard = new Scanner(System.in);
            System.out.print("Enter the filename to read from: ");
            String filename = keyboard.nextLine();
            StringTokenizer tk;

            File file = new File(filename);

            Scanner inputFile = new Scanner(file);
            Scanner input = new Scanner(System.in);

            NHLStats nhl = new NHLStats();

            PlayerRecord pl;

            String playNam;
            String pos;
            String team;
            int gamesPla;
            int goalS;
            int a;
            int penMin;
            int sog;
            int gwg;
            String s;




            while (inputFile.hasNext()) {
                s= inputFile.nextLine();
                tk= new StringTokenizer(s, " \t");
                playNam = tk.nextToken();
                pos = tk.nextToken();
                team = tk.nextToken();
                gamesPla= Integer.parseInt(tk.nextToken());
                goalS= Integer.parseInt(tk.nextToken());
                a= Integer.parseInt(tk.nextToken());
                penMin= Integer.parseInt(tk.nextToken());
                sog= Integer.parseInt(tk.nextToken());
                gwg= Integer.parseInt(tk.nextToken());

                pl = new PlayerRecord(playNam, pos, team, gamesPla, goalS, a, penMin, sog, gwg);
                nhl.add(pl);
            }

            inputFile.close();

            System.out.println("NHL Results Summary");
            System.out.println();

            //players with the highest points
            System.out.println("Players with highest points and their teams:");
            System.out.println(nhl.mostPoints());
            System.out.println();

            //prints the most agressive players
            System.out.println("Most agressive players, their teams and their positions:");
            System.out.println(nhl.mostAgressive());
            System.out.println();

            //prints the most most valuable players
            System.out.println("Most valuable players and their teams:");
            System.out.println(nhl.mVP());
            System.out.println();

            //prints most promising players
            System.out.println("Most promising players and their teams:");
            System.out.println(nhl.mP());
            System.out.println();

            //prints most nuumber of penalty minutes
            System.out.println("Teams that had the most number of penalty minutes:");
            System.out.println(nhl.mostPenT() );
            System.out.println();

            //prints out the teams with the most number of game winning goals
            System.out.println("Teams that had the most number of game winning goals:");
            System.out.println(nhl.mostGWG() );
            System.out.println();


























        }
}
