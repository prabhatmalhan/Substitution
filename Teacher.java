import java.io.*;
import java.util.*;
class Teacher
{
    String name;
    int ns=0,nf=0;
    boolean subs=false;
    String TT[]=new String[7];
    private void initialize(Teacher a[])
    {
        for(int i=0;i<a.length;++i)
            a[i]=new Teacher();
    }

    protected Teacher[] fill(int n)throws IOException
    {
        Node start=null;
        start=new Node().makeL(null);
        Teacher t[]=new Teacher[start.countNT(start)];
        initialize(t);
        int i=0;
        while(start!=null)
        {
            int ind=start.data.indexOf("\t");
            t[i].name=start.data.substring(0,ind);
            StringTokenizer st=new StringTokenizer(start.data.substring(ind+1));
            ind=st.countTokens();
            for(int j=0,k=0;j<ind;++j)
            {
                if(j==(n+1)*7)
                    break;
                else if(j>=n*7)
                    t[i].TT[k++]=st.nextToken();
            }
            ++i;
            start=start.link;
        }
        count(t);
        return t;
    }

    private void count(Teacher T[])
    {
        for(int i=0;i<T.length;++i)
            for(int j=0;j<7;++j)
                if(T[i].TT[j].charAt(0)=='-')
                    ++T[i].nf;
    }
}