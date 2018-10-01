package NetApi.tesco;

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Convert {

    public static String[] splitByNumber(String s, int size) {
    if(s == null || size <= 0)
        return null;
    int chunks = s.length() / size + ((s.length() % size > 0) ? 1 : 0);
    String[] arr = new String[chunks];
    for(int i = 0, j = 0, l = s.length(); i < l; i += size, j++)
        arr[j] = s.substring(i, Math.min(l, i + size));
    return arr;
}
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner sc=new Scanner(System.in);
	    String s=sc.nextLine();
	    String x=s.substring(s.length()-36);
	    System.out.println(x);
	    String[] parts = x.split("-");
	    //System.out.println(parts[4]);
	    String make=null;
	    for(int i=0;i<4;i++){
	        String a=parts[i];
	        if(a.length()==4){
	            String b=a.substring(2);
	            String c=a.substring(0,2);
	             make+="-"+b+c;
	             if(i==3){
	                 make+="-";
	             }
	        }
	        else{
	            String[] d=splitByNumber(a,2);
	            String e="";
	            for(int j=d.length-1;j>=0;j--){
	                e+=d[j];
	            }
	            make=e;
	        }

	    }
	    make+=parts[4];
	    System.out.println(make);
		// your code goes here
	}
}
