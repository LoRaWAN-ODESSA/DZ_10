package com.company;

import com.company.model.PrimesList;

public class Main {
    public static void main(String[] args) {
        PrimesList data = new PrimesList();
        Runner runner = new Runner(data);
        runner.startAllThreads();
        try {
            runner.waitingForThread();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        int[] result = data.getPrimes();
        System.out.println(result.toString());
    }
}