package algo.bloomFilter;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BloomFilterTest {

    private BloomFilter bf;

    @Before
    public void setUp() {
        bf = new BloomFilter(32);
    }

    @Test
    public void isValue() {
        bf.add("0123456789");
        bf.add("1234567890");
        bf.add("2345678901");
        bf.add("3456789012");
        bf.add("4567890123");
        bf.add("5678901234");
        bf.add("6789012345");
        bf.add("7890123456");
        bf.add("8901234567");
        bf.add("9012345678");

        assertThat(bf.isValue("0123456789"), is(true));
        assertThat(bf.isValue("1234567890"), is(true));
        assertThat(bf.isValue("2345678901"), is(true));
        assertThat(bf.isValue("3456789012"), is(true));
        assertThat(bf.isValue("4567890123"), is(true));
        assertThat(bf.isValue("5678901234"), is(true));
        assertThat(bf.isValue("6789012345"), is(true));
        assertThat(bf.isValue("7890123456"), is(true));
        assertThat(bf.isValue("8901234567"), is(true));
        assertThat(bf.isValue("9012345678"), is(true));

        assertThat(bf.isValue("01234567891"), is(false));
        assertThat(bf.isValue("012345678911"), is(false));
        assertThat(bf.isValue("0123456789111"), is(false));
        assertThat(bf.isValue("01234567891111"), is(false));
        assertThat(bf.isValue("012345678911111"), is(false));
    }
}