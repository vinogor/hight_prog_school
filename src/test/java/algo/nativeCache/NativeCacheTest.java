package algo.nativeCache;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NativeCacheTest {

    private NativeCache<String> nc;

    @Before
    public void setUp() {
        nc = new NativeCache<>(5, String.class);
    }

    @Test
    public void put_01() {
        nc.put("aaaa", "valA");
        System.out.println(nc);

        nc.get("aaaa");
        System.out.println(nc);
    }

    @Test
    public void get_01() {

    }
}