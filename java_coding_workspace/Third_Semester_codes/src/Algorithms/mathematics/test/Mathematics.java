package mathematics.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.junit.Test;

import mathematics.Distance;
import mathematics.Division;
import mathematics.Knapsack;
import mathematics.Multiplication;
import mathematics.Primes;

@SuppressWarnings("static-method")
public class Mathematics {

    private static final int MIN = 1;
    private static final int MAX = 1000;

    private static final Random RANDOM = new Random();
    private static int nextRandomInt(int min, int max) {
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        return RANDOM.nextInt((max - min) + 1) + min;
    }

    @Test
    public void multiplication() {
        int a = nextRandomInt(MIN, MAX);
        int b = nextRandomInt(MIN, MAX);
        long result = Multiplication.multiplyUsingLoop(a, b);
        long check = Multiplication.multiplication(a, b);
        assertTrue("Multiplication using a loop. a=" + a + " b=" + b + " result=" + result + " check=" + check, (result == check));

        result = Multiplication.multiplyUsingRecursion(a, b);
        check = Multiplication.multiplication(a, b);
        assertTrue("Multiplication using recursion. a=" + a + " b=" + b + " result=" + result + " check=" + check, (result == check));

        result = Multiplication.multiplyUsingShift(a, b);
        check = Multiplication.multiplication(a, b);
        assertTrue("Multiplication using shifts. a=" + a + " b=" + b + " result=" + result + " check=" + check, (result == check));

        result = Multiplication.multiplyUsingLogs(a, b);
        check = Multiplication.multiplication(a, b);
        assertTrue("Multiplication using logs. a=" + a + " b=" + b + " result=" + result + " check=" + check, (result == check));
    }

    @Test
    public void division() {
        int a = nextRandomInt(MIN, MAX);
        int b = nextRandomInt(a, MAX);
        long result = Division.divisionUsingLoop(a, b);
        long check = Division.division(a, b);
        assertTrue("Division using a loop. a=" + a + " b=" + b + " result=" + result + " check=" + check, (result == check));

        result = Division.divisionUsingRecursion(a, b);
        check = Division.division(a, b);
        assertTrue("Division using recursion. a=" + a + " b=" + b + " result=" + result + " check=" + check, (result == check));

        result = Division.divisionUsingShift(a, b);
        check = Division.division(a, b);
        assertTrue("Division using shifts. a=" + a + " b=" + b + " result=" + result + " check=" + check, (result == check));

        result = Division.divisionUsingLogs(a, b);
        check = Division.division(a, b);
        assertTrue("Division using logs. a=" + a + " b=" + b + " result=" + result + " check=" + check, (result == check));

        result = Division.divisionUsingMultiplication(a, b);
        check = Division.division(a, b);
        assertTrue("Division using multiplication. a=" + a + " b=" + b + " result=" + result + " check=" + check, (result == check));
    }

    @Test
    public void knapsack() {
        int[] values = { 7, 4, 8, 6, 2, 5 };
        int[] weights = { 2, 3, 5, 4, 2, 3 };
        int capacity = 9;
        int[] result = Knapsack.zeroOneKnapsack(values, weights, capacity);
        int[] check = new int[]{5,3,0};
        for (int i=0; i<result.length; i++) {
            int r = result[i];
            int c = check[i];
            assertTrue("Knapsack problem. expected="+c+" got="+r, r==c);
        }
    }

    @Test
    public void chebyshevDistance() {
        long[] point1 = new long[]{1,2};
        long[] point2 = new long[]{7,8};
        long result = Distance.chebyshevDistance(point1, point2);
        long expected = 6;
        assertTrue("Chebyshev Distance error. expected="+expected+" got="+result, (result==expected));
    }

    @Test
    public void squaredDistance() {
        int x1 = 1;
        int y1 = 2;
        int x2 = 7;
        int y2 = 8;
        double result = Distance.squaredDistance(x1, y1, x2, y2);
        double expected = 72.0;
        assertTrue("squaredDistance error. expected="+expected+" got="+result, (result==expected));
    }

    @Test
    public void euclideanDistance() {
        int x1 = 1;
        int y1 = 2;
        int x2 = 7;
        int y2 = 8;
        double result = Distance.euclideanDistance(x1, y1, x2, y2);
        double expected = 8.48528137423857;
        assertTrue("squaredDistance error. expected="+expected+" got="+result, (result==expected));
    }

    @Test
    public void getPrimeFactorization() {
        int number = 234;
        Map<Long,Long> factorization = Primes.getPrimeFactorization(number);
        Map<Long,Long> check = new HashMap<Long,Long>();
        {
            check.put(2l, 1L);
            check.put(3l, 2L);
            check.put(13L, 1L);
        }
        for (Long k : factorization.keySet()) {
            Long f = factorization.get(k);
            Long c = check.get(k);
            assertTrue("PrimeFactorization error. expected="+c+" got="+f, (c==f));
        }
    }

    @Test
    public void isPrime() {
        int number = 1234;
        boolean isPrime = Primes.isPrime(number);
        assertFalse("isPrime error. isPrime="+isPrime, isPrime);

        number = 7919;
        isPrime = Primes.isPrime(number);
        assertTrue("isPrime error. isPrime="+isPrime, isPrime);
    }

    @Test
    public void sieveOfEratosthenes() {
        int number = 4177;
        boolean isPrime = Primes.sieveOfEratosthenes(number);
        assertTrue("Sieve Of Eratosthenes error.", isPrime);

        number = 4178;
        isPrime = Primes.sieveOfEratosthenes(number);
        assertFalse("Sieve Of Eratosthenes error.", isPrime);

        number = 7919;
        isPrime = Primes.sieveOfEratosthenes(number);
        assertTrue("Sieve Of Eratosthenes error.", isPrime);

        number = 556;
        isPrime = Primes.sieveOfEratosthenes(number);
        assertFalse("Sieve Of Eratosthenes error.", isPrime);

        number = 6091;
        isPrime = Primes.sieveOfEratosthenes(number);
        assertTrue("Sieve Of Eratosthenes error.", isPrime);

        number = 6090;
        isPrime = Primes.sieveOfEratosthenes(number);
        assertFalse("Sieve Of Eratosthenes error.", isPrime);

        number = 6089;
        isPrime = Primes.sieveOfEratosthenes(number);
        assertTrue("Sieve Of Eratosthenes error.", isPrime);
    }
}
