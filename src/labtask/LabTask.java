
package labtask;

import java.util.ArrayList;
import java.util.Scanner;

public class LabTask {
    
    public static class Level 
    {
        Level (){}
        public int start;
        public int end;
        public int Q;
        public int Q_1;

    }
    
    
    public static void main(String[] args) 
    {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(2);
        input.add(3);
        input.add(4);
        input.add(10);
        input.add(20);
        input.add(30);
        input.add(100);
        Scanner sc  = new Scanner (System.in);
        System.out.println("Enter num of levels ");
        int numOfLevels = sc.nextInt();
        int step = 100/numOfLevels ;
        
        ArrayList<Level> table = new ArrayList<>();
        int start =0 ;
        int end ;
        
        for (int i=0 ; i<numOfLevels ; i++)
        {    
            if (i+1 == numOfLevels)
            {
                end = 100 ;
            }
            else 
            {
             end = start + step;   
            }
            Level cur = new Level();
            cur.Q = i ;
            cur.start = start ;
            cur.end = end ;
            cur.Q_1 = (start + end)/2 +1 ;
            table.add(cur);
            start = end+1 ;
            
            
        }
        
        System.out.println("---------- table ----------------");
        for (int i=0 ; i<table.size() ; i++)
        { 
            System.out.println(table.get(i).start + " " + table.get(i).end + " " + table.get(i).Q + " " + table.get(i).Q_1 );  
        }
        System.out.println("----------------------------");
        
        ArrayList<Integer> compress = new ArrayList<>();
        
        for (int i=0 ; i<input.size() ; i++)
        {
            int value = input.get(i);
            
            for (int j=0 ; j<table.size() ; j++)
            {
                if (value >= table.get(j).start && value <= table.get(j).end )
                {
                    compress.add(table.get(j).Q);
                }
            }
            
        }
        
        System.out.println("input = " + input);
        System.out.println("Compress = " +compress);
        
       ArrayList<Integer> decompress = new ArrayList<>();
        for (int i=0 ; i<compress.size() ; i++)
        {
            decompress.add( table.get(compress.get(i)).Q_1);
        }
        
        System.out.println( "Decompress = " +decompress); 
    }
    
}
