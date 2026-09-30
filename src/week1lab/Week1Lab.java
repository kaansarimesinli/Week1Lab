package week1lab;

import java.util.Scanner;

public class Week1Lab {
    
    public static Scanner kyb = new Scanner(System.in);

    public static void main(String[] args) {
        
        int[][] matches = new int[6][2];
        String[] teams = {"A", "B", "C", "D"};
        int[] wins = new int[4];
        int[] loses = new int[4];
        int[] draws = new int[4];
        int[] points = new int[4];
        int[] goalsFor = new int[4];
        int[] goalsAgainst = new int[4];
        int[] goalDifference = new int[4];
        int maxPoint = -100;
        int maxGoalDifference = -100;
        
        System.out.printf("%15s %n%n", "MATCHES");
        int matchCounter = 1;
        
        for(int i = 0; i < 4; i++) {
            for(int j = i + 1; j < 4; j++) {
                System.out.println("Match " + matchCounter + ": Team " + teams[i] + " - Team " + teams[j]);
                matchCounter++;
            }
        }
        
        System.out.println("");
        matchCounter = 1;
        
        for(int i = 0; i < 4; i++) {
            for(int j = i + 1; j < 4; j++) {
                System.out.printf("%10s %d%n%n", "MATCH", matchCounter);
                System.out.print("Team " + teams[i] + " goals:");
                matches[matchCounter - 1][0] = kyb.nextInt();
                goalsFor[i] += matches[matchCounter - 1][0];
                goalsAgainst[j] += matches[matchCounter - 1][0];
                System.out.print("Team " + teams[j] + " goals:");
                matches[matchCounter - 1][1] = kyb.nextInt();
                goalsFor[j] += matches[matchCounter - 1][1];
                goalsAgainst[i] += matches[matchCounter - 1][1];
                matchCounter++;
                System.out.println("");
            }
        }
        
        System.out.println("");
        matchCounter = 1;
        System.out.printf("%25s %n%n", "MATCH SCORES");
        
        for(int i = 0; i < 4; i++) {
            for(int j = i + 1; j < 4; j++) {
                System.out.println("Match " + matchCounter + ": Team " + teams[i] + " goals:" + matches[matchCounter - 1][0] + " - " + "Team " + teams[j] + " goals:" + matches[matchCounter - 1][1]);
                matchCounter++;
            }
        }
        
        System.out.println("");
        matchCounter = 1;
        
        for(int i = 0; i < 4; i++) {
            for(int j = i + 1; j < 4; j++) {
                if(matches[matchCounter - 1][0] > matches[matchCounter - 1][1]) {
                    wins[i]++;
                    loses[j]++;
                    points[i] += 3;
                }else if(matches[matchCounter - 1][0] < matches[matchCounter - 1][1]) {
                    wins[j]++;
                    loses[i]++;
                    points[j] += 3;
                }else {
                    draws[i]++;
                    draws[j]++;
                    points[i]++;
                    points[j]++;
                }
                matchCounter++;
            }
            goalDifference[i] = goalsFor[i] - goalsAgainst[i];
        }
        
        for(int i = 0; i < 4; i++) {
            if(points[i] > maxPoint) {
                maxPoint = points[i];
            }
        }
        
        for(int i = 0; i < 4; i++) {
            if(goalDifference[i] > maxGoalDifference) {
                maxGoalDifference = goalDifference[i];
            }
        }
        
        System.out.printf("%30s %n%n", "STATISTICS");
        System.out.printf("%s %10s %10s %10s %10s %15s%n", "TEAM", "WINS", "DRAWS", "LOSES", "POINTS", "GOAL DIFFERENCE");
        System.out.println("---------------------------------------------------------------------------------------"); 
        
        for(int i = 0; i < 4; i++) {
            System.out.printf("%s %10d %10d %10d %10d %15d%n", teams[i], wins[i], draws[i], loses[i], points[i], goalDifference[i]);
        }
        
        System.out.println("");
        
        for(int i = 0; i < 4; i++) {
            if(maxPoint == points[i] && maxGoalDifference == goalDifference[i]) {
                System.out.println("CHAMPION: " + teams[i]);
            }
        }
    }
    
}