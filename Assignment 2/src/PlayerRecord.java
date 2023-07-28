public class PlayerRecord {
    //instance variables
    private String playerName;
    private String position;
    private String teamName;
    private int gamesPlayed;
    private int goalsScored;
    private int assists;
    private int penMinutes;
    private int shotsOnGoal;
    private int gameWGoals;
    private int penMin;
    private int tGW;
    //constructors
    public PlayerRecord(String playerName, String position, String teamName, int gamesPlayed, int goalsScored,
                        int assists, int penMinutes, int shotsOnGoal, int gameWGoals){
        this.playerName= playerName;
        this.position=position;
        this.teamName= teamName;
        this.gamesPlayed=gamesPlayed;
        this.goalsScored=goalsScored;
        this.assists=assists;
        this.penMinutes= penMinutes;
        this.shotsOnGoal= shotsOnGoal;
        this.gameWGoals= gameWGoals;
        penMin= 0;
        tGW=0;
    }
    //getters
    public String getPlayerName() {
        return playerName;
    }
    public String getPosition() {
        return position;
    }
    public String getTeamName() {
        return teamName;
    }
    public int getGamesPlayed() {
        return gamesPlayed;
    }
    public int getGoalsScored() {
        return goalsScored;
    }
    public int getAssists() {
        return assists;
    }
    public int getPenMinutes() {
        return penMinutes;
    }
    public int getShotsOnGoal() {
        return shotsOnGoal;
    }
    public int getGameWGoals() {
        return gameWGoals;
    }
    //setters
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }
    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }
    public void setAssists(int assists) {
        this.assists = assists;
    }
    public void setPenMinutes(int penMinutes) {
        this.penMinutes += penMinutes;
    }
    public void setShotsOnGoal(int shotsOnGoal) {
        this.shotsOnGoal = shotsOnGoal;
    }
    public void setGameWGoals(int gameWGoals) {
        this.gameWGoals += gameWGoals;
    }
    //extra methods that create a method for the team name, count for the number of penalties,
    //toString method, calculates the about of points for each team, count for the game winning goals
    public PlayerRecord(String teamName) {
        this.teamName= teamName;
    }
    public void addToPen(int n){
        penMin+=n;
    }
    public void gameWin(int n){
        tGW+=n;
    }
    public PlayerRecord(int gameWGoals) {
        this.gameWGoals= gameWGoals;
    }
    public int getPoints(){
        return goalsScored + assists;
    }
    public String toString(){
        return (playerName + " " + position + " "+ teamName + " "+ gamesPlayed + " "+ goalsScored + " "+ assists+
                " "+ penMinutes + " "+ shotsOnGoal+ " "+ gameWGoals);
    }
}