import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArabicToRomanTest {

    private int[] set1Input;
    private String[] set1Output;

    @Before
    public void setUp() throws Exception {
        set1Input = new int[]{5, 9, 12, 16, 29, 44, 45, 68, 83, 97, 99, 500, 501, 649, 798, 891, 1000};
        set1Output = new String[]{"V", "IX", "XII", "XVI", "XXIX", "XLIV", "XLV", "LXVIII", "LXXXIII", "XCVII", "XCIX",
                                    "D", "DI", "DCXLIX", "DCCXCVIII", "DCCCXCI", "M"};
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getRoman() {
        Assert.assertArrayEquals(ArabicToRoman.getRoman(set1Input), set1Output);
    }
}