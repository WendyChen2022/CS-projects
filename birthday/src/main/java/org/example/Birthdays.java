package org.example;

//Modify the code so that the program prompts the user three questions and output six lines of messages as described

import java.util.Scanner;

public class Birthdays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get today's date
        System.out.print("Please enter today’s date (month day): ");
        int todayMonth = scanner.nextInt();
        int todayDay = scanner.nextInt();

        // Display today's date
        System.out.printf("\nToday is %d/%d/2024, day #%d of the year.\n\n", todayMonth, todayDay, absoluteDay(todayMonth, todayDay));

        // Get person #1's birthday
        System.out.print("Please enter person #1’s birthday (month day): ");
        int person1Month = scanner.nextInt();
        int person1Day = scanner.nextInt();

        // Display person #1's birthday information
        displayBirthdayInfo(person1Month, person1Day,todayMonth,todayDay);

        // Get person #2's birthday
        System.out.print("Please enter person #2’s birthday (month day): ");
        int person2Month = scanner.nextInt();
        int person2Day = scanner.nextInt();

        // Display person #2's birthday information
        displayBirthdayInfo(person2Month, person2Day,todayMonth,todayDay);

        // Compare birthdays and display the result
        compareBirthdays(person1Month, person1Day, person2Month, person2Day,todayMonth,todayDay);

        // Print fun fact about International Talk like a Pirate day
        System.out.println("\nDid ye know? 9/19 be International Talk like a Pirate day.");
        System.out.println("Arr, me mateys, arr!\n\n               ===============================================================");

    }

    // Method to compute absolute day of the year
    public static int absoluteDay(int month, int day) {
        int[] daysInMonth = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int absoluteDay = day;

        for (int i = 1; i < month; i++) {
            absoluteDay += daysInMonth[i];
        }

        return absoluteDay;
    }

    // Method to display birthday information
    public static void displayBirthdayInfo(int month, int day, int todayMonth, int todayDay) {
        int absDay = absoluteDay(month, day);
        int daysUntilNextBirthday = absDay - absoluteDay(todayMonth, todayDay);

        System.out.printf("%d/%d/2024 falls on day #%d of 366.\n", month, day, absDay);

        if (daysUntilNextBirthday > 0) {
            System.out.printf("Your next birthday is in %d day(s).\n\n", daysUntilNextBirthday);
        } else if (daysUntilNextBirthday == 0) {
            System.out.println("Happy Birthday! :)");
        } else {
            // Wrap around to the next year
            daysUntilNextBirthday += 366;
            System.out.printf("Your next birthday is in %d day(s).\n\n", daysUntilNextBirthday);
        }
    }

    // Method to compare birthdays and display the result
    public static void compareBirthdays(int month1, int day1, int month2, int day2, int todayMonth, int todayDay) {
        int absDay1 = absoluteDay(month1, day1);
        int absDay2 = absoluteDay(month2, day2);
        int daysUntilNextBirthday1 = absDay1 - absoluteDay(todayMonth, todayDay);
        int daysUntilNextBirthday2 = absDay2 - absoluteDay(todayMonth, todayDay);
        if(daysUntilNextBirthday1<0){
            daysUntilNextBirthday1 += 366;
        }
        if(daysUntilNextBirthday2<0){
            daysUntilNextBirthday2 += 366;
        }

        if (daysUntilNextBirthday1 < daysUntilNextBirthday2) {
            System.out.println("Person #1’s birthday is sooner.");
        } else if (daysUntilNextBirthday1 > daysUntilNextBirthday2) {
            System.out.println("Person #2’s birthday is sooner.");
        } else {
            System.out.println("Wow, you share the same birthday! ^_^");
        }
    }
}