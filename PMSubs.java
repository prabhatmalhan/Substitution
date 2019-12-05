import java.util.*;
import java.io.*;
import java.text.*;
class PMSubs
{
    public static void main(String args[])throws IOException
    {
        Date d1=new Date();
        try
        {
            Date d2=new SimpleDateFormat("dd/mm/yyyy").parse("365/00/2055");
            if(d1.before(d2))
                new Substitution().substitute();
                else
                System.out.println("Contact PRABHAT for renewal of the license");
        }
        catch(Exception e){}
    }
}