package com.company.model;

import java.util.Arrays;

public class PrimesList {

    private int[] primes;

    public PrimesList() {
        primes = new int[0];
    }

    public synchronized void addPrimes(int[] primesForAdd) {
        int[] newArray = new int[primes.length + primesForAdd.length];
        if (primes.length == 0) {
            primes = new int[primesForAdd.length];
            for (int i = 0; i < primes.length; i++) {
                primes[i] = primesForAdd[i];
            }
        } else {
            for (int i = 0; i < primes.length; i++) {
                newArray[i] = primes[i];
            }
            for (int i = 0; i < primesForAdd.length; i++) {
                newArray[primes.length + i] = primesForAdd[i];
            }
            primes = new int[newArray.length];
            for (int i = 0; i < newArray.length; i++) {
                primes[i] = newArray[i];
            }
        }
    }

    public int[] getPrimes() {
        return primes;
    }

    public void setPrimes(int[] primes) {
        this.primes = primes;
    }

    @Override
    public String toString() {
        return "PrimesList{" +
                "primes=" + Arrays.toString(primes) +
                '}';
    }
}
