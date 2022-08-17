package com.company;

import com.company.model.PrimesList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FinderPrimesServiceTest {

    @Test
    void whenSearchingPrimes_thenFindList() {
        int from = 1;
        int end = 20;
        int numThreads = 3;

        int[] expectations = {2, 3, 5, 7, 11, 13, 17, 19};

        PrimesList data = new PrimesList();
        Runner runner = new Runner(from, end, numThreads, data);
        runner.startAllThreads();

        try {
            runner.waitingForThread();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        int[] result = data.getPrimes();

        Assertions.assertArrayEquals(expectations, result);
    }

    @Test
    void whenSearchingPrimesCount_thenFindRightCountOfPrimes() {
        int from = 1;
        int end = 21;
        int numThreads = 3;

        int expectations = 8;

        PrimesList data = new PrimesList();
        Runner runner = new Runner(from, end, numThreads, data);
        runner.startAllThreads();

        try {
            runner.waitingForThread();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        int result = data.getPrimes().length;

        Assertions.assertEquals(expectations, result);
    }
}
