package com.company.service;

import com.company.model.PrimesList;

public class FinderThreadService implements Runnable {

    private int[] localPrimes;
    private int start;
    private int end;
    private PrimesList primesList;

    public FinderThreadService(int start, int end, PrimesList primesList) {
        localPrimes = new int[0];
        this.start = start;
        this.end = end;
        this.primesList = primesList;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                if (localPrimes.length == 0) {
                    localPrimes = new int[1];
                    localPrimes[0] = i;
                } else {
                    int[] newArray = new int[localPrimes.length + 1];
                    for (int j = 0; j < localPrimes.length; j++) {
                        newArray[j] = localPrimes[j];
                    }
                    newArray[localPrimes.length] = i;
                    localPrimes = new int[newArray.length];
                    for (int j = 0; j < localPrimes.length; j++) {
                        localPrimes[j] = newArray[j];
                    }
                }
            }
        }
        primesList.addPrimes(localPrimes);
    }

    private boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public PrimesList getPrimesList() {
        return primesList;
    }

    public void setPrimesList(PrimesList primesList) {
        this.primesList = primesList;
    }
}
