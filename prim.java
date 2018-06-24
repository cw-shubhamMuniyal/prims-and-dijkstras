import java.util.*;

public class prim
{	static ArrayList<Node> arr[];
    static int key[],previous[],vis[];
    //static TreeSet<Integer> set;

	static int n,mini;
    public static void main(String[] args)
    {	Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number of vertices:");
		 n = sc.nextInt();
	 
		vis=new int[n+1];
        arr = new ArrayList[n+1];
        key=new int[n+1];  previous=new int[n+1];

        for(int i=0;i<n;i++)
        {   key[i] = Integer.MAX_VALUE;
	        Node n1=new Node();
			n1.name=i;
			n1.weight=0;
			vis[i]=0;
            arr[i]=new ArrayList<Node>();
			arr[i].add(n1);
        }

	 //to give inputs manually use this part of code
		pf("Enter the number of edges:- "+":");
        int e =  sc.nextInt();
		for(int i=0;i<e;i++)
		{	pfn("enter the end points of an edge:- ");
			int a =  sc.nextInt();
			int b =  sc.nextInt();
			
			pf("Enter weight associated with this edge:- ");
			int wt = sc.nextInt();
			
			addEdge(a,b,wt);
		}
           
       /*Not disturbing the user use this part of code
	     addEdge(0,1,5);
		 addEdge(1,0,1);
			addEdge(0,2,6);
			addEdge(1,2,2);
			addEdge(1,3,3);
			addEdge(2,4,6);
			addEdge(3,4,2);*/
		
	

		
		int start =  0;
		pfn("Node\tkey");
        calcShortestPath(0);	
       /* for(int i=0;i<n;i++)
        {
           
			System.out.println(key[i]);
        }*/

    }

    static void addEdge(int A,int B,int wt)
    { 	Node n1 = new Node();
        n1.name = B;       n1.weight=wt;
        arr[A].add(n1);
    }


    static void calcShortestPath(int i)
    {     
		key[i]=0;
		vis[i]=1;
		int min=Integer.MAX_VALUE;
        for(int l=1;l<n;l++)
		{
			min=Integer.MAX_VALUE;
			for(int j=1;j<arr[i].size();j++ )
			{
				if(arr[i].get(j).weight<key[arr[i].get(j).name])
				{
					//min=arr[i].get(j).weight;
					key[arr[i].get(j).name]=arr[i].get(j).weight;
					previous[arr[i].get(j).name]=i;
				}
				//key[j]=arr[i].get(j).weight;
				
			}
			
			for(int k=0;k<n;k++)
				{
					if((key[k]<min)&&(vis[k]==0))
					{
						min=key[k];
					    mini=k;
						
					}
				}
				System.out.println(previous[mini]+">"+mini+"\t"+key[mini]+"\t");
			vis[mini]=1;
			i=mini;
		}

    }



    //*******************
    static void pf(String s)
    {	System.out.print(s);
    }
    static void pfn(String s)
    {	System.out.println(s);
    }
    static void pfn()
    {	System.out.println();
    }
}



class Node
{	public int name;
    public int weight=0;
}