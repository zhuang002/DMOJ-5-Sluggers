/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sluggers;

import java.util.Scanner;

/**
 *
 * @author zhuan
 */
public class Sluggers {

    static Scanner sc=new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] scores=new int[2][7];
        for (int i=0;i<7;i++) scores[1][i]=0;
        String season=sc.nextLine();
        System.out.println(season);
        for (int i=0;i<20;i++) {
            System.out.print("=");
        }
        System.out.println();
        for (int i=0;i<10;i++) {
            String team=sc.next();
            
            for (int j=0;j<7;j++) {
                scores[0][j]=sc.nextInt();
                scores[1][j]+=scores[0][j];
            }
            System.out.printf("%s: .%03d .%03d\n",team,fround(getBatAverage(scores[0])),
                    fround(getSlugingAverage(scores[0])));
        }
        for (int i=0;i<20;i++) {
            System.out.print("=");
        }
        System.out.println();
        System.out.printf("Big 10 av: .%03d .%03d", fround(getBatAverage(scores[1])),
                    fround(getSlugingAverage(scores[1])));
        
    }

    private static double getBatAverage(int[] score) {
        return (double)score[3]/(double)score[1];
    }

    private static double getSlugingAverage(int[] score) {
        return (double)(score[3]-score[4]-score[5]-score[6]+score[4]*2+score[5]*3+score[6]*4)/(double)score[1];
    }
    
    private static int fround(double d) {
        int i=(int)(d*10000);
        if (i%10>=5) {
            return i/10+1;
        }
        return i/10;
    }
    
}
