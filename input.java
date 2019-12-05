import java.util.*;
import java.io.*;
class input
{
    int absentT[];
    Teacher det[];
    private boolean check(String s)throws IOException
    {
        String x[]={"MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY"};
        for(int i=0;i<x.length;++i)
        {
            if(s.equals(x[i]))
            {
                det=new Teacher().fill(i);
                return true;
            }
        }
        return false;
    }

    private boolean check2(String s,int k)
    {
        for(int i=0;i<det.length;++i)
        {
            if(s.equalsIgnoreCase(det[i].name))
            {
               absentT[k]=i;
                return true;
            }
        }
        return false;
    }
    
    protected input data()throws IOException
    {
        Scanner sc=new Scanner(System.in);
        input o1=new input();
        while(true)
        {
            System.out.print("Enter the day:");
            String d=sc.nextLine().toUpperCase();
            if(o1.check(d))
                break;
            else
                System.out.println("Day not found");
        }
        System.out.print("Enter the no. of teachers absent:");
        o1.absentT=new int[sc.nextInt()];
        sc.nextLine();
        for(int i=0;i<o1.absentT.length;++i)
        {
            while(true)
            {
                System.out.print("Enter the name"+(i+1)+":");
                String d=sc.nextLine();
                if(o1.check2(d,i))
                    break;
                else
                    System.out.println("TEACHER not found");
            }
        }
        return o1;
    }
}