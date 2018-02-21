import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ReadIntArray{
    private Scanner in;
    private ArrayList<Integer> arr;

    public ReadIntArray(Scanner in){
        this.in = in;
        arr = new ArrayList<>();
    }

    public ArrayList<Integer> getArray(){
        arr.clear();
        int n = in.nextInt();
        for (int i = 0; i < n; i++){
            arr.add(in.nextInt());
        }
        return arr;
    }
}

class BST{
    private ArrayList<Integer> arr;

    public BST(ArrayList<Integer> arr){
        this.arr = arr;
    }

    // scan for greater
    public boolean isBST(){
        // return isBST_recursive(arr);
        return isBST_stack(arr);
    }

    private boolean isBST_stack(List<Integer> arr){
        /*
        1) Create an empty stack.
        2) Initialize root as INT_MIN.
        3) Do following for every element pre[i]
            a) If pre[i] is smaller than current root, return false.
            b) Keep removing elements from stack while pre[i] is greater
               then stack top. Make the last removed item as new root (to
               be compared next).
               At this point, pre[i] is greater than the removed root
               (That is why if we see a smaller element in step a), we
               return false)
            c) push pre[i] to stack (All elements in stack are in decreasing
               order)
        */
        // since it's preorder, the right branch must all be smaller than root. left branch must all be bigger than branch
        // inspired by next greater element https://www.geeksforgeeks.org/next-greater-element/

        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        int root = Integer.MIN_VALUE;
        for (Integer element : arr){
            // If we find a node who is on right side
            // and smaller than root, return false
            if (element < root)
                return false;


            // If pre[i] is in right subtree of stack top,
            // Keep removing items smaller than pre[i]
            // and make the last removed item as new
            // root.
            while (!stack.isEmpty() && stack.peekFirst() < element){
                root = stack.removeFirst();
            }

            // At this point either stack is empty or
            // pre[i] is smaller than root, push pre[i]
            stack.addFirst(element);
        }
        return true;
    }

    private boolean isBST_recursive(List<Integer> arr){
         /*
           Find the first greater value on right side of current node.
           Let the index of this node be j. Return true if following
           conditions hold. Else return false
                   (i)  All values after the above found greater value are
           greater than current node.
                   (ii) Recursive calls for the subarrays pre[i+1..j-1] and
           pre[j..n-1] also return true.
         */

        if (arr.size() < 2)
            return true;

        List<Integer> right = new ArrayList<>();
        List<Integer> left = new ArrayList<>();

        int root = arr.get(0);
        int idx = 1;

        while (idx < arr.size() && arr.get(idx) < root){
            right.add(arr.get(idx++));
        }

        while (idx < arr.size()){
            if (arr.get(idx) < root)
                return false;
            left.add(arr.get(idx++));
        }

        return isBST_recursive(right) && isBST_recursive(left);
    }

}



public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ReadIntArray readIntArray = new ReadIntArray(in);

        int q = in.nextInt();
        for (int i = 0; i < q; i++){
            BST bst = new BST(readIntArray.getArray());
            System.out.println(bst.isBST());
        }
    }
}