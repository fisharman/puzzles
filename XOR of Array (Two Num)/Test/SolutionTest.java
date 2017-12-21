import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {


    @Test
    public void testFindMaxXOR(){
        int[] ar = {10, 11, 12, 13, 14, 15};
        assertEquals(Solution.findMaxXOR(ar), 7);

    }

}
