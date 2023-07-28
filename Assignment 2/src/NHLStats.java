import java.util.*;
public class NHLStats {
    private List<PlayerRecord> pList;
    //creation of the list
    public NHLStats() {
        pList = new List<PlayerRecord>();
    }
    //methods similar to ExpenseList class
    public void add(PlayerRecord p) {
        pList.add(p);
    }
    public boolean isEmpty(){
        return pList.isEmpty();
    }
    public PlayerRecord first(){
        return pList.first();
    }
    public PlayerRecord next(){
        return pList.next();
    }
    public void enumerate(){
        pList.enumerate();
    }
    //this method dictates the team(s) that has the most amount of points
    public String mostPoints() {
        ArrayList<String> members = new ArrayList<String>();
        int most = first().getPoints();
        for (int i = 1; i < pList.size(); i++) {
            int v = next().getPoints();
            if (v > most) {
                most = v;
            }
        }
        if (first().getPoints() == most) {
            members.add(first().getPlayerName() + " " + first().getTeamName());
        }
        for (int i = 1; i < pList.size(); i++) {
            PlayerRecord p= next();
            if(p.getPoints()==most){
                members.add(p.getPlayerName()+ " "+ p.getTeamName());
            }
        }
        //string r fixes the writing of the output
        String r= "";
        for(int i=0; i<members.size(); i++){
            r+=members.get(i);
        }
        return r;
    }
    //dictates the most aggressive player and their position and team, repeat of prev. method
    public String mostAgressive(){
        ArrayList<String> agressive = new ArrayList<String>();
        int most = first().getPenMinutes();
        for (int i = 1; i < pList.size(); i++) {
            int v = next().getPenMinutes();
            if (v > most) {
                most = v;
            }
        }
        if (first().getPoints() == most) {
            agressive.add(first().getPlayerName() + " " + first().getTeamName() + " "+ first().getPosition() +"\n");
        }
        for (int i = 1; i < pList.size(); i++) {
            PlayerRecord p= next();
            if(p.getPenMinutes()==most){
                agressive.add(p.getPlayerName()+ " "+ p.getTeamName()+ " "+ p.getPosition()+ "\n");
            }
        }
        //string r fixes the writing of the output
        String r= "";
        for(int i=0; i<agressive.size(); i++){
            r+=agressive.get(i);
        }
        return r;
    }
    //dictates the most valuable player - displays the player and the team
    public String mVP(){
        ArrayList<String> mostVP = new ArrayList<String>();

        int most = first().getGameWGoals();

        for (int i = 1; i < pList.size(); i++) {
            int v = next().getGameWGoals();
            if (v > most) {
                most = v;
            }
        }
        if (first().getGameWGoals() == most) {
            mostVP.add(first().getPlayerName() + " " + first().getTeamName() + "\n");
        }
        for (int i = 1; i < pList.size(); i++) {
            PlayerRecord p= next();
            if(p.getGameWGoals()==most){
                mostVP.add(p.getPlayerName()+ " "+ p.getTeamName()+ "\n");
            }
        }
        //string r fixes the writing of the output
        String r= "";
        for(int i=0; i<mostVP.size(); i++){
            r+=mostVP.get(i);
        }
        return r;
    }
    //displays the most promising player and their team
    public String mP(){
        ArrayList<String> mostP = new ArrayList<String>();
        int most = first().getShotsOnGoal();
        for (int i = 1; i < pList.size(); i++) {
            int v = next().getShotsOnGoal();
            if (v > most) {
                most = v;
            }
        }
        if (first().getShotsOnGoal() == most) {
            mostP.add(first().getPlayerName() + " " + first().getTeamName() + "\n");
        }
        //iterates through the shots on the goals and adds to the array
        for (int i = 1; i < pList.size(); i++) {
            PlayerRecord p= next();
            if(p.getShotsOnGoal()==most){
                mostP.add(p.getPlayerName()+ " "+ p.getTeamName()+ "\n");
            }
        }
        //string r fixes the writing of the output
        String r= "";
        for(int i=0; i<mostP.size(); i++){
            r+=mostP.get(i);
        }
        return r;
    }
    //this displays the team with the most amount of penalty minutes
    public String mostPenT(){
        ArrayList<String> teams = new ArrayList<String>();
        ArrayList<PlayerRecord> t= new ArrayList<PlayerRecord>();
        String mPT= first().getTeamName();
        teams.add(mPT);
        PlayerRecord pr = new PlayerRecord(first().getTeamName());
        t.add(pr);
        t.get(0).addToPen(first().getPenMinutes());
        for(int i=1; i<pList.size();i++){
            PlayerRecord r= next();
            //iterates through the penalty minutes and adds to the array
            if(!teams.contains(r.getTeamName())){
                pr= new PlayerRecord(r.getTeamName());
                teams.add(r.getTeamName());
                t.add(pr);
            }
            else{
                int p= teams.indexOf(r.getTeamName());
                t.get(p).addToPen(r.getPenMinutes());
            }
        }

        int most= t.get(0).getPenMinutes();
        for(int i=1; i<t.size();i++){
            if(t.get(i).getPenMinutes()>most){
                most= t.get(i).getPenMinutes();
            }
        }
        //string r fixes the writing of the output
        String r="";
        for(int i=0; i<t.size(); i++){
            if(t.get(i).getPenMinutes()==most){
                r= r +" "+ t.get(i).getTeamName() + " " + t.get(i).getPenMinutes()+ "\n";
            }
        }
        return r;
    }
    //displays the most game winning goals, repeat of prev. method
    public String mostGWG(){
        ArrayList<Integer> games = new ArrayList<Integer>();
        ArrayList<PlayerRecord> g= new ArrayList<PlayerRecord>();
        int mPT= first().getGameWGoals();
        games.add(mPT);
        PlayerRecord pr = new PlayerRecord(first().getGameWGoals());
        g.add(pr);
        g.get(0).gameWin(first().getGameWGoals());
        //iterates and adds to the array
        for(int i=1; i<pList.size();i++){
            PlayerRecord r= next();
            if(!games.contains(r.getGameWGoals())){
                pr= new PlayerRecord(r.getGameWGoals());
                games.add(r.getGameWGoals());
                g.add(pr);
            }
            else{
                int p= games.indexOf(r.getGameWGoals());
                g.get(p).addToPen(r.getGameWGoals());
            }
        }
        //iterates through the game goals
        int most= g.get(0).getGameWGoals();
        for(int i=1; i<g.size();i++){
            if(g.get(i).getGameWGoals()>most){
                most= g.get(i).getGameWGoals();
            }
        }
        //string r fixes the writing of the output
        String r="";
        for(int i=0; i<g.size(); i++){
            if(g.get(i).getGameWGoals()==most){
                r= g.get(i).getTeamName() + " " + g.get(i).getGameWGoals()+ "\n";
            }
        }
        return r;
    }
}