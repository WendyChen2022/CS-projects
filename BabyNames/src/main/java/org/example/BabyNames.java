package org.example;


//The “names.txt” file contains data about popular baby names over the last 80 years in the United States. Every 10 years, the data gives the 1000 most popular boy names and girl names for children born in the US.

import org.example.DrawingPanel;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class BabyNames {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name? ");
        String inputName = scanner.nextLine().toLowerCase();
        Scanner input = new Scanner(new File("names.txt"));
        String fileName = "";
        int max = Integer.MIN_VALUE;
        int[] nums = new int[9];
        while(input.hasNextLine()){
            String line = input.nextLine();
            Scanner lineScan = new Scanner(line);
            String nameIn = lineScan.next();
            String name = nameIn.toLowerCase();
            if(inputName.equals(name)){
                fileName = name.substring(0,1).toUpperCase()+name.substring(1) + ".txt";
                PrintStream out = new PrintStream(new File(fileName));
                int year=1920;

                out.print(nameIn);
                int k = 0;
                while(lineScan.hasNextInt()){
                    out.println(", ");
                    int num = lineScan.nextInt();
                    nums[k]=num;
                    k++;
                    max = Math.max(max,num);
                    System.out.println(year+": "+num);
                    out.print(year+": "+num);
                    year +=10;
                }
                System.out.println();
                break;
            }
        }
        if(fileName.equals("")){
            System.out.println("name not found.");
        }else {
            DrawingPanel panel = new DrawingPanel(900, 600);
            panel.setBackground(Color.WHITE);
            Graphics g = panel.getGraphics();
            addGraph(g, max, nums);
        }


    }

    private static void addGraph(Graphics g,int max,int[]nums) {
        double rate = 500.0/max;

        for(int i= 0; i<9;i++){
            g.setColor(Color.lightGray);
            int height = (int) Math.round(nums[i]*rate);
            g.fillRect(i*100, 600-height, 100, height);
        }
    }
}