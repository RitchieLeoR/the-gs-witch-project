package com.witch.calculator.svc.helper;

import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Component
public class PrimeNumberGenerator {

    public Integer primeNumbersCalculator(int n) {

        return Stream.iterate(0, a -> a + 1)
                .filter(x -> isPrime(x)).limit(n).collect(Collectors.toList())
                .stream().mapToInt(Integer::intValue).sum();
    }

    private boolean isPrime(int number) {
        return IntStream.rangeClosed(2, (int) (Math.sqrt(number)))
                .allMatch(n -> number % n != 0);
    }
}
