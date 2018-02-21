import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class BSTTest {

    /* input:
    5
    3
    1 3 2
    3
    2 1 3
    6
    3 2 1 5 4 6
    4
    1 3 4 2
    5
    3 4 5 1 2
    */

    ArrayList<ArrayList<Integer>> bstArrSet = new ArrayList<>();
    ArrayList<ArrayList<Integer>> notBstArrSet = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        Integer[] testArray1 = {1, 3, 2};
        Integer[] testArray2 = {2, 1, 3};
        Integer[] testArray3 = {3, 2, 1, 4, 5, 6};
        Integer[] testArray4 = {1, 3, 4, 2};
        Integer[] testArray5 = {3, 4, 5, 1, 2};

        // https://stackoverflow.com/questions/17520964/how-to-create-arraylist-arraylistinteger-from-array-int-in-java

        bstArrSet.add(new ArrayList<Integer>(Arrays.asList(testArray1)));
        bstArrSet.add(new ArrayList<Integer>(Arrays.asList(testArray2)));
        bstArrSet.add(new ArrayList<Integer>(Arrays.asList(testArray3)));

        notBstArrSet.add(new ArrayList<Integer>(Arrays.asList(testArray4)));
        notBstArrSet.add(new ArrayList<Integer>(Arrays.asList(testArray5)));

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isBST() {
        int itr = 0;
        for (ArrayList<Integer> arr : bstArrSet){
            BST testBST = new BST(arr);
            Assert.assertTrue("Failed on iteration " + itr, testBST.isBST());
            itr++;
        }
    }

    @Test
    public void isNotBST() {
        int itr = 0;
        for (ArrayList<Integer> arr : notBstArrSet){
            BST testBST = new BST(arr);
            Assert.assertFalse("Failed on iteration " + itr, testBST.isBST());
            itr++;
        }
    }

}