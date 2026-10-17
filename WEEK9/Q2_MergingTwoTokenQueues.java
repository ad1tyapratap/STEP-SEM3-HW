import java.util.*;

public class Q2_MergingTwoTokenQueues {
    public static void main(String[] args) {
        int[] a = {3, 8, 15, 20};
        int[] b = {5, 8, 12};

        int i = 0, j = 0;
        ArrayList<Integer> result = new ArrayList<>();

        while (i < a.length && j < b.length) {
            if (a[i] <= b[j])
                result.add(a[i++]);
            else
                result.add(b[j++]);
        }

        while (i < a.length)
            result.add(a[i++]);

        while (j < b.length)
            result.add(b[j++]);

        System.out.println(result);
    }
}