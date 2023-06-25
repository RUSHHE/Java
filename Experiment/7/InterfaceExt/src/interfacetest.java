public class interfacetest {

    public static void main(String[] args) {
        FootballExtends ft = new FootballExtends();
        HockeyExtends he = new HockeyExtends();

        Sports s = ft;
        s.setHomeTeam(args[0]);
        s.setVisitingTeam(args[1]);

        ((Football) ft).homeTeamScored(Integer.parseInt(args[2]));

        s = he;
        s.setHomeTeam(args[0]);
        s.setVisitingTeam(args[1]);

        ((Hockey) he).endOfPeriod(Integer.parseInt(args[2]));

    }
}
//  interface  Sports
interface Sports {
    void setHomeTeam(String homeTeam);

    void setVisitingTeam(String visitingTeam);
}

//interface  Football  extends  Sports
interface Football extends Sports {
    void homeTeamScored(int score);
}

//interface  Hockey  extends  Sports
interface Hockey extends Sports {
    void endOfPeriod(int i);
}

class FootballExtends implements Football {
    String homeTeam;
    String visitingTeam;
    int score;
    @Override
    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
        System.out.println("Football homeTeam is " + this.homeTeam);
    }

    @Override
    public void setVisitingTeam(String visitingTeam) {
        this.visitingTeam = visitingTeam;
        System.out.println("Football visitingTeam is " + this.visitingTeam);
    }

    @Override
    public void homeTeamScored(int score) {
        this.score = score;
        System.out.println("Football homeTeam scored " + this.score);
    }
}

class HockeyExtends implements Hockey {
    String homeTeam;
    String visitingTeam;
    int period;
    @Override
    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
        System.out.println("Hockey homeTeam is " + this.homeTeam);
    }

    @Override
    public void setVisitingTeam(String visitingTeam) {
        this.visitingTeam = visitingTeam;
        System.out.println("Hockey visitingTeam is " + this.visitingTeam);
    }

    @Override
    public void endOfPeriod(int period) {
        this.period = period;
        System.out.println("Hockey endOfPeriod is " + this.period);
    }
}
