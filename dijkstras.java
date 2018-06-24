import java.io.*;
import java.util.*;

class dijkstras
{
	public static void main(String args[])
	{
		int i,j,k;
		Scanner sc = new Scanner(System.in);
		int dis[],vis[],pre[];
		System.out.print("Enter number of vertices:");
		int n=sc.nextInt();
		dis=new int[n+1];
		vis=new int[n+1];
		pre=new int[n+1];
		int a[][]=new int[n+1][n+1];
		
		System.out.print("Enter weight(n*n)  ");
		for(i=0;i<n;i++)
			for(j=0;j<n;j++)
			{
				a[i][j]=sc.nextInt();
			}
			
			System.out.print("Enter starting node ");
			int s=sc.nextInt();
			dis[s]=0;
			for(i=0;i<n;i++)
				if(i!=s)
					{	dis[i]=Integer.MAX_VALUE;
						vis[i]=0;
					}
			
			int prev=s;
			 pre[s]=s;
			for(i=1;i<n;i++)
			{	
				
				vis[prev]=1;
				for(j=0;j<n;j++)
			    	if((a[prev][j]!=0)&&(prev!=j)&&(dis[j]>(dis[prev]+a[prev][j])))
					{
						dis[j]=dis[prev]+a[prev][j];
						pre[j]=prev;
					}
				 // s=prev;
				  int min=Integer.MAX_VALUE;
				  for(k=0;k<n;k++)
				  {
						if((vis[k]==0)&&(min>=dis[k]))
						{
							min=dis[k];
							prev=k;
							//pre[prev]=s;
						}
				  }
			}
			System.out.println("node distance from starting node previous node");
			for(i=0;i<n;i++)
			{
				System.out.println(i+"\t"+dis[i]+"\t\t\t   "+pre[i]);
			}
	}
	
}