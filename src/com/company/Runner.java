package com.company;

import com.company.model.PrimesList;
import com.company.service.FinderThreadService;
import com.company.view.Console;

public class Runner {

    private int startIndex;
    private int endIndex;
    private int numThreads;
    private PrimesList primesList;
    private Thread[] numberOfThreads;

    public Runner(PrimesList primesList) {
        Console console = new Console();
        this.startIndex = console.getFrom();
        this.endIndex = console.getTo();
        this.numThreads = console.getNumThreads();
        this.primesList = primesList;
        separateThreads();
    }

    public Runner(int start, int end, int numThreads, PrimesList primesList) {
        this.startIndex = start;
        this.endIndex = end;
        this.numThreads = numThreads;
        this.primesList = primesList;
        separateThreads();
    }

    private void separateThreads() {
        int part = (endIndex - startIndex) / numThreads;
        numberOfThreads = new Thread[numThreads];
        int from = startIndex;
        int end = startIndex;
        for (int i = 0; i < numThreads; i++) {
            if (numThreads < 2) {
                end += part;
            } else {
                if (i == 0) {
                    end += part;
                } else if (i != numThreads - 1) {
                    from += part;
                    end += part;
                } else {
                    from += part;
                    end = endIndex;
                }
            }
            numberOfThreads[i] = new Thread(new FinderThreadService(from + 1, end, primesList));
        }
    }

    public void startAllThreads() {
        for (Thread thread : numberOfThreads) {
            thread.start();
        }
    }

    public void waitingForThread() throws InterruptedException {
        for (Thread thread : numberOfThreads) {
            thread.join();
        }
    }
}
