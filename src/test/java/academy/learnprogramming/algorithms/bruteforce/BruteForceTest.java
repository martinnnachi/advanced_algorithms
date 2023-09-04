package academy.learnprogramming.algorithms.bruteforce;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class BruteForceTest {

    BruteForce bruteForce = null;
    char[] array;

    @Before
    public void init() {
        bruteForce = new BruteForce();
        String s = "academy.learnprogramming";
        array = s.toCharArray();

    }

    @Test
    public void firstMatchTest() {
        Assert.assertEquals(0, bruteForce.firstMatch(array, new char[]{'a'}));
        Assert.assertEquals(16, bruteForce.firstMatch(array, new char[]{'g'}));
        Assert.assertEquals(22, bruteForce.firstMatch(array, new char[]{'n', 'g'}));
        Assert.assertEquals(6, bruteForce.firstMatch(array, new char[]{'y', '.', 'l', 'e'}));
        Assert.assertEquals(-1, bruteForce.firstMatch(array, new char[]{'z', 'z'}));
    }

    @Test
    public void forEveryMatchTest() {
        int[] expect = new int[array.length];
        resetExpectArray(expect);
        expect[0] = 0;
        expect[1] = 2;
        expect[2] = 10;
        expect[3] = 18;
        System.out.println("expect: " + Arrays.toString(expect));
        int[] found = bruteForce.everyMatch(array, new char[]{'a'});
        System.out.println("found: " + Arrays.toString(found));
        Assert.assertArrayEquals(expect, found);

        System.out.println("============");

        resetExpectArray(expect);
        expect[0] = 16;
        expect[1] = 23;
        System.out.println("expect: " + Arrays.toString(expect));
        found = bruteForce.everyMatch(array, new char[]{'g'});
        System.out.println("found: " + Arrays.toString(found));
        Assert.assertArrayEquals(expect, found);

        System.out.println("============");

        resetExpectArray(expect);
        expect[0] = 7;
        System.out.println("expect: " + Arrays.toString(expect));
        found = bruteForce.everyMatch(array, new char[]{'.'});
        System.out.println("found: " + Arrays.toString(found));
        Assert.assertArrayEquals(expect, found);

    }
    public void resetExpectArray(int[] expect) {
        Arrays.fill(expect, -1);
    }
}
