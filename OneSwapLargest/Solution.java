// package whatever; // don't place package name!

class largestNum{

    public static void main (String arg[]){
        int input1 = 73264;
        char maxNum = 0;
        int maxPos = 0;
        char startNum = 0;
        int startPos = 0;
        
        boolean switchFlag = false;
        
        StringBuilder number = new StringBuilder();
        number.append(input1);
                
        for (int i = 0; i < number.length() && switchFlag == false; i++){
        	
            startNum = number.charAt(i);
            maxNum = startNum;
            startPos = i;
            
            for (int j = i; j < number.length(); j++){
                if (maxNum < number.charAt(j)){
                    maxNum = number.charAt(j);
                    maxPos = j;
                    switchFlag = true;
                }
            }            
        }
        
        number.deleteCharAt(maxPos);
        number.insert(maxPos, startNum);
        number.deleteCharAt(startPos);
        number.insert(startPos, maxNum);    
        
        System.out.println(number);   

    }

}