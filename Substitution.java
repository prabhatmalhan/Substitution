import java.io.*;
class Substitution
{
    private void reset(input x)
    {
        for(int i=0;i<x.det.length;++i)
            x.det[i].subs=false;
    }

    boolean check(int a,input s)
    {
        for(int i=0;i<s.absentT.length;++i)
            if(a==s.absentT[i])
                return false;
        return true;
    }

    void substitute()throws IOException
    {
        input o1=new input().data();
        PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("E:/PMSubs/Substitution.logger")));
        for(int i=0;i<7;++i)
        {
            for(int j=0;j<o1.absentT.length;++j)
            {
                boolean flag=true;
                if(o1.det[o1.absentT[j]].TT[i].charAt(0)=='-')
                    continue;
                else
                {
                    for(int k=0;k<o1.det.length;++k)
                    {
                        if(!check(k,o1))
                            continue;
                        else
                        {
                            if(!(o1.det[k].TT[i].charAt(0)=='-'))
                                continue;
                            else
                            {
                                if((o1.det[k].ns==0 || o1.det[k].nf>1) && o1.det[k].subs==false)
                                {
                                    pw.println(i+1+"\t"+o1.det[o1.absentT[j]].TT[i]+"\t"+o1.det[k].name);
                                    ++o1.det[k].ns;
                                    --o1.det[k].nf;
                                    flag=false;
                                    o1.det[k].subs=true;
                                    ++k;
                                    break;
                                }
                            }
                        }
                    }
                }
                if(flag)
                {
                    for(int k=0;k<o1.det.length;++k)
                    {
                        if(!check(k,o1))
                            continue;
                        else
                        {
                            if(!(o1.det[k].TT[i].charAt(0)=='-'))
                                continue;
                            else
                            {
                                if((o1.det[k].ns==0 || o1.det[k].nf>1) && o1.det[k].subs==false)
                                {
                                    pw.println(i+1+"\t"+o1.det[o1.absentT[j]].TT[i]+"\t"+o1.det[k].name);
                                    ++o1.det[k].ns;
                                    --o1.det[k].nf;
                                    flag=false;
                                    o1.det[k].subs=true;
                                    ++k;
                                    break;
                                }
                            }
                        }
                    }
                }

            }
            reset(o1);
        }
        pw.close();
    }
}