package com.company.view;

import java.util.Scanner;

public class Console {

    private int from;
    private int to;
    private int numThreads;

    public Console() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the beginning of the search range -> ");
        from = scanner.nextInt();
        System.out.print("Enter the end of the search range -> ");
        to = scanner.nextInt();
        System.out.print("Enter the number of Threads -> ");
        numThreads = scanner.nextInt();
        scanner.close();
    }


    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public int getNumThreads() {
        return numThreads;
    }
}
