package com.matching.task;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<String>(){
            {
                add("A");
                add("B");
                add("C");
                add("D");
                add("E");
                add("F");
    /*            add("G");
                add("H");
                add("I");
                add("J");
                add("K");
                add("L");
                add("M");
                add("N");*/
            }
        };
        countMatch(strings);
    }

    static void  countMatch(List<String> users) {
        if (users.size() % 2 != 0)
        {
            users.add("Bye"); // If odd number of teams add a dummy
        }

        int numDays = (users.size()  - 1); // Days needed to complete tournament
        int halfSize = users.size()  / 2;

        List<String> teams = new ArrayList<>();

        teams.addAll(users); // Add teams to List and remove the first team
        teams.remove(0);

        int teamsSize = teams.size();

        for (int day = 0; day < numDays; day++)
        {
            System.out.println("Set   " + (day + 1));

            int teamIdx = day % teamsSize;

            System.out.println(teams.get(teamIdx) + " vs " +  users.get(0));

            for (int idx = 1; idx < halfSize; idx++)
            {
                int firstTeam = (day + idx) % teamsSize;
                int secondTeam = (day  + teamsSize - idx) % teamsSize;
                System.out.println( teams.get(firstTeam)  + " vs "+ teams.get(secondTeam));
            }
        }
    }
}
