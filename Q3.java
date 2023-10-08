import java.util.*;

public class Q3 {
    
    public static List<int[]> merger(List<int[]> I) 
    {
        List<int[]> MI = new ArrayList<>();

        if (I.isEmpty()) 
        {
            //Agar List empty ho to return kardo empty List 
            return MI;
        }

        int[] currentInterval = I.get(0);
        MI.add(currentInterval);

        for (int[] interval : I) 
        {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (currentEnd >= nextStart) 
            {
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } 
            else 
            {
                currentInterval = interval;
                MI.add(currentInterval);
            }
        }

        return MI;
    }

    public static void main(String[] args) {
        List<int[]> I = new ArrayList<>();
        I.add(new int[]{1, 3});
        I.add(new int[]{4, 6});
        I.add(new int[]{8, 10});
        I.add(new int[]{7, 18});

        List<int[]> MI = merger(I);

        System.out.println("M I:");
        for (int[] interval : MI) 
        {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }
}