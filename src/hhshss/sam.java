
package hhshss;

import java.util.Scanner;

public class sam {
	public static void main(String args[])
	{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the no. of elements");
		int n=sc.nextInt();
		int i[]=new int[n];
		System.out.println("enter the elements");
		int temp;
		for(int x=0;x<n;x++)
		{
			i[x]=sc.nextInt();
		}
		System.out.println("after sorting");
		for(int y=0;y<i.length;y++)
		{   
			for(int z=y+1;z<i.length;z++)
			{   
				if(i[y]<i[z])
				{
					temp=i[y];
					i[y]=i[z];
					i[z]=temp;
					
				}
				System.out.println(""+i[y]);
			}
			
			
			
			
			
			
		}
		
		
		
	}
}
