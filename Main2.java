package mergesortProject;

import java.util.Random;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main2 {
	public static int fc=0;
	
	public static RandomAccessFile merge(RandomAccessFile a, RandomAccessFile b) throws IOException
	{
		a.seek(0);
		b.seek(0);
		fc++;
		RandomAccessFile c = new RandomAccessFile("data"+fc+".raf", "rw");
		c.setLength(0);
		int al = (int) a.length() / 4;
		int bl = (int) b.length() / 4;
		int cl = al+bl;
		int ai=0;
		int bi=0;
		int tA=0;
		int tB=0;
		for(int i=0;i<cl;i++)
		{
			if (ai<al && bi<bl)
			{	a.seek(ai*4);
				b.seek(bi*4);
				tA=a.readInt();
				tB=b.readInt();
				if(tA<tB)
				{
					c.writeInt(tA);
					ai++;
				}
				else
				{
					c.writeInt(tB);
					bi++;
				}
			}
			else
			{
				if (!(ai<al))
				{
					b.seek(bi*4);
					tB=b.readInt();
					c.writeInt(tB);
					bi++;
				}
				else
				{
					a.seek(ai*4);
					tA=a.readInt();
					c.writeInt(tA);
					ai++;
				}
			}
			
		}
		return c;
	}
	
	public static RandomAccessFile sort(RandomAccessFile intial) throws IOException
	{ 
		intial.seek(0);
		fc++;
		RandomAccessFile a = new RandomAccessFile("data"+fc+".raf", "rw");
		fc++;
		RandomAccessFile b = new RandomAccessFile("data"+fc+".raf", "rw");
		a.setLength(0);
		b.setLength(0);
		int length = (int) intial.length()/4;
		for(int i=0;i<length;i++)
		{
			if(i<length/2)
			{
				a.writeInt(intial.readInt());
			}
			else
			{
				b.writeInt(intial.readInt());
			}
		}
		if((int)a.length()/4>1)
		{
			a = sort(a);
		}
		if((int)b.length()/4>1)
		{
			b = sort(b);
		}
		return merge(a,b);
	} 

	public static void printer(RandomAccessFile a) throws IOException
	{
		a.seek(0);
		for (int i = 0;i<(int) a.length()/4;i++ )
		{
			System.out.print(a.readInt()+" "); 	
		}
		System.out.println(); 
	}
	
	public static void main(String[] args) throws IOException {
		Random r = new Random(97);
		int N[] = {10,50,100,150,200,250,300,350,400,450,500,550,600,650,700,750,800,850,900,950,1000};
for (int j =0;j<N.length;j++)
{
		RandomAccessFile intial = new RandomAccessFile("data.raf", "rw");
		intial.setLength(0);
		RandomAccessFile finished = new RandomAccessFile("final.raf", "rw");
		intial.setLength(0);
		
		for(int i = 0;i<N[j];i++)
		{
			intial.writeInt(r.nextInt());
		}
		long startTime = System.nanoTime();
		finished=sort(intial);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("N: "+N[j]+"\tTime(nS): "+ duration);
	}
	}
}
