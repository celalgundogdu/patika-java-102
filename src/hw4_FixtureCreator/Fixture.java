package hw4_FixtureCreator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Fixture {

    private Scanner input = new Scanner(System.in);
    private List<String> teams;
    private List<List<String>> weeksForFirstSeason;

    public Fixture() {
        this.teams = new ArrayList<>();
        this.weeksForFirstSeason = new ArrayList<>();
    }

    public void create(){
        getTeamNames();
        int totalWeek = this.teams.size() - 1;
        int matchesPerWeek = this.teams.size() / 2;
        for (int i = 0; i < totalWeek; i++){
            List<String> matchesOfTheWeek = new ArrayList<>();
            for(int j = 0; j < matchesPerWeek; j++){
                int first = j;
                int second = this.teams.size() - 1 - j;
                matchesOfTheWeek.add(this.teams.get(first) + " vs " + this.teams.get(second));
            }
            Collections.shuffle(matchesOfTheWeek);
            this.weeksForFirstSeason.add(matchesOfTheWeek);
            List<String> tempTeams = new ArrayList<>();
            tempTeams.add(this.teams.get(0));
            tempTeams.add(this.teams.get(this.teams.size()-1));

            for (int j = 1; j < this.teams.size()-1; j++){
                tempTeams.add(this.teams.get(j));
            }

            this.teams = tempTeams;
        }

        Collections.shuffle(weeksForFirstSeason);
        printAllSeason();
    }

    public void getTeamNames(){
        System.out.println("Takım isiMlerini giriniz. Çıkmak için ise 0 giriniz!");
        do {
            System.out.print("Takım: ");
            String str = input.nextLine();
            if (str.equals("0")){
                break;
            }
            this.teams.add(str);
        }while(true);

        if (this.teams.size() % 2 == 1){
            this.teams.add("Bay");
        }
    }

    public void printAllSeason(){
        List<List<String>> weeksForSecondSeason = new ArrayList<>();
        int weekNumber = 1;
        System.out.println("\n*** First Season ***\n");
        for (List<String> week : this.weeksForFirstSeason){
            List<String> matches = new ArrayList<>();
            System.out.println(weekNumber + ". Week");
            for (String match : week){
                System.out.println("\t" + match);
                matches.add(match.split("\\s+")[2] + " vs " + match.split("\\s+")[0]);
            }
            weeksForSecondSeason.add(matches);
            weekNumber++;
            System.out.println();
        }

        System.out.println("\n*** Second Season ***\n");
        for (List<String> week : weeksForSecondSeason){
            System.out.println(weekNumber + ". Week");
            for (String match : week){
                System.out.println("\t" + match);
            }
            weekNumber++;
            System.out.println();
        }
    }
}
