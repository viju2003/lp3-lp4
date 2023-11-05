import java.util.*;
import java.lang.*;
public class ZeroOneKnapSack
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the capacity of Knapsack :");
		int m = sc.nextInt();
		System.out.println("Enter the number of Items :");
		int num = sc.nextInt();
		int wt[] = new int[num+1];
		int p[] = new int[num+1];
		wt[0]=0;
		p[0]=0;
		for(int i=1;i<=num;i++)
		{
			System.out.println("Enter the weight of item "+i+" : ");
			wt[i]=sc.nextInt();
			System.out.println("Enter the profit of item "+i+" : ");
			p[i]=sc.nextInt();
		}
		int k[][] = new int[num+1][m+1];
		for(int i=0;i<=num;i++)
		{
			for(int w=0;w<=m;w++)
			{
				if(i==0 || w==0)
				{
					k[i][w]=0;
				}
				else if(wt[i]<=w)
				{
					k[i][w]= Math.max(p[i]+k[i-1][w-wt[i]],k[i-1][w]);
				}
				else
				{
					k[i][w] = k[i-1][w];
				}
			}
		}
		for(int i=0;i<=num;i++)
		{
			for(int j=0;j<=m;j++)
			{
				System.out.print(k[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("Maximum Profit :"+k[num][m]);
		int i=num;
		int j=m;
		while(i>0 && j>=0)
		{
			if(k[i][j] == k[i-1][j])
			{
				System.out.println("Item "+i+" not included in Knapsack");
				i--;
			}
			else
			{
				System.out.println("Item "+i+" included in Knapsack");
				j=j-wt[i];
				i--;
			}
		}	
	}
}