package Recursion;

public class Fabonacci {
    public static void FabIterator(int range) {
        int first = 0, second = 1, temp = 0;
        for (int i = 0; i < range; i++) {
            System.out.print(first + " ");
            temp = first;
            first = second;
            second = temp + first;
        }
    }

    public static void main(String[] args) {
//        FabIterator(8);
        System.out.println(FabRecursion(9));
        ;
    }

    private static int FabRecursion(int range) {
        if (range < 2)
            return range;
        else
            return FabRecursion(range - 1) + FabRecursion(range - 2);
    }
}
