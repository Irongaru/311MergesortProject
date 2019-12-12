package mergesortProject;

import java.util.Random;

public class Main {


public static int[] merge(int a[], int b[])
{
	int al = a.length;
	int bl = b.length;
	int cl = al+bl;
	int c[] = new int[cl];
	int ai=0;
	int bi=0;
	for (int i=0;i<cl;i++)
	{
		if (ai<al && bi<bl)
		{
			if(a[ai]<b[bi])
			{
				c[i]=a[ai];
				ai++;
			}
			else
			{
				c[i]=b[bi];
				bi++;
			}
		}
		else
		{
			if (!(ai<al))
			{
				c[i]=b[bi];
				bi++;
			}
			else
			{
				c[i]=a[ai];
				ai++;
			}
		}
	}
return c;	
}

public static int[] sort(int i[]) 
	{ 
		
		int L = i.length;
		if (!(L > 1))
		{
			return(i);
		}
		int l1=L/2;
		int l2=L/2;
		if(L%2==1)
		{
			l1=L/2;
			l2=l1+1;
		}
		int a[]= new int[l1];
		int b[]= new int[l2];
		for(int j=0;j<L;j++)
		{
			if(j<l1)
			{
				a[j]=i[j];
			}
			else
			{
				b[j-l1]=i[j];
			}
		}
		if(a.length>1)
		{
			a = sort(a);
		}
		if(b.length>1)
		{
			b = sort(b);
		}

		return merge(a,b);
	} 

public static void printer(int arr[]) 
	{ 
		for (int i =0; i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();

	} 

public static void main(String args[]) 
	{ 
		int N[] = {10,50,100,150,200,250,300,350,400,450,500,550,600,650,700,750,800,850,900,950,1000};
		Random r = new Random(97);
		for (int i=0;i<N.length;i++)
		{
		int intial[] = new int[N[i]];
		for (int j =0;j<N[i];j++)
		{
			intial[j]= r.nextInt();
		}
		long startTime = System.nanoTime();
		int finished[]= sort(intial); 
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("N: "+N[i]+"\tTime(nS): "+ duration);
		}
	} 
}
