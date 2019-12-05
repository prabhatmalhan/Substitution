import java.io.*;
class Node
{
    String data=null;
    Node link=null;
    Node()
    {
        ;
    }

    Node(String d)
    {
        data=d;
    }

    protected Node makeL(Node Start)throws IOException
    {
        BufferedReader br=new BufferedReader(new FileReader("E:/PMSubs/TimeTable.txt"));
        br.readLine();
        br.readLine();
        String d=br.readLine();
        char a=d.charAt(0);
        while(a!=' ')
        {
            d=d.trim();
            if(a=='\t');
            else
            {
                Node Fresh=new Node(d);
                Fresh.link=Start;
                Start=Fresh;
            }
            d=br.readLine();
            if(d!=null)
                a=d.charAt(0);
            else
                break;
        }
        br.close();
        return Start;
    }

    protected int countNT(Node start)
    {
        int c=0;
        while(start!=null)
        {
            ++c;
            start=start.link;
        }
        return c;
    }
}