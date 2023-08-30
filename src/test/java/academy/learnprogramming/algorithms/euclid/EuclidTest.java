package academy.learnprogramming.algorithms.euclid;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EuclidTest {

    Euclid euclid = null;

    @Before
    public void init() {
        euclid = new Euclid();
    }

    @Test
    public void gcdTest() {
        Assert.assertEquals(2, euclid.gcd(10, 2));
        Assert.assertEquals(2, euclid.gcd(22, 6));
    }

    @Test
    public void gcd2Test() {
        Assert.assertEquals(2, euclid.gcd2(10, 2));
        Assert.assertEquals(2, euclid.gcd2(22, 6));
    }

    @Test
    public void gcdVsGcd2Test() {
        Assert.assertEquals(euclid.gcd(10, 2), euclid.gcd2(10, 2));
        Assert.assertEquals(euclid.gcd(22, 6), euclid.gcd2(22, 6));
        Assert.assertEquals(euclid.gcd(182, 74), euclid.gcd2(182, 74));
    }
}
