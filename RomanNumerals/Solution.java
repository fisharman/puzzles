import java.util.ArrayList;
import java.util.TreeMap;

class ArabicToRoman{
    private static TreeMap<Integer, String> romanMap = new TreeMap<>();

    static {
        romanMap.put(1000, "M");
        romanMap.put(900, "CM");
        romanMap.put(500, "D");
        romanMap.put(400, "CD");
        romanMap.put(100, "C");
        romanMap.put(90, "XC");
        romanMap.put(50, "L");
        romanMap.put(40, "XL");
        romanMap.put(10, "X");
        romanMap.put(9, "IX");
        romanMap.put(5, "V");
        romanMap.put(4, "IV");
        romanMap.put(1, "I");
    }


    public static String[] getRoman(int[] number){
        ArrayList<String> ans = new ArrayList<>();

        for (int aNumber : number) {
            ans.add(getRoman(aNumber));
        }

        return ans.toArray(new String[ans.size()]);
    }

    private static String getRoman(int number){
        int l =  romanMap.floorKey(number);
        if ( number == l ) {
            return romanMap.get(number);
        }
        return romanMap.get(l) + getRoman(number-l);
    }
}

public class Solution {
    public static void main(String[] args) {

    }
}
