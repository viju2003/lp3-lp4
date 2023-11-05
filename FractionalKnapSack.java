import java.lang.*;
import java.util.*;
class KnapsackItem
{
	public int index;
	public int weight;
	public int value;
	public double ratio;
	KnapsackItem(int index,int weight,int value)
	{
		this.index=index;
		this.weight=weight;
		this.value=value;
		ratio = value*1.0 / weight;
	}
	@Override
	public String toString()
	{
		return "Item Index="+index+", Value="+value+" ,Weight="+weight+", Ratio="+ratio;
	}	
}
public class FractionalKnapSack
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of items :");
		int num=sc.nextInt();
		ArrayList<KnapsackItem> items = new ArrayList<>();
		for(int i=0;i<num;i++)
		{
			System.out.println("Enter the weight of item "+(i+1));
			int weight=sc.nextInt();
			System.out.println("Enter the value of item "+(i+1));
			int value=sc.nextInt();
			items.add(new KnapsackItem((i+1),weight,value));
		}
		System.out.println("Enter the capacity of Knapsack:");
		int capacity=sc.nextInt();
		Comparator<KnapsackItem> comparator = new Comparator<KnapsackItem>()
		{
			@Override
			public int compare(KnapsackItem o1,KnapsackItem o2)
			{
				if(o1.ratio < o2.ratio)
				{
					return 1;
				}
				else
				{
					return -1;		
				}

			}
		};
		Collections.sort(items,comparator);
		int usedCapacity=0;
		int totalValue=0;
		for(KnapsackItem item : items)
		{
			if(usedCapacity + item.weight <= capacity)
			{
				usedCapacity+=item.weight;
				totalValue+=item.value;
				System.out.println("Taken "+item);	
			}
			else
			{	
				int remainingCapacity = capacity-usedCapacity;
				double value= item.ratio * remainingCapacity;
				System.out.println("Taken Item Index="+item.index+", Value="+value+" ,Weight="+remainingCapacity+", Ratio="+item.ratio);
				usedCapacity += remainingCapacity;
				totalValue += value;
			}
			if(usedCapacity == capacity)
			{
				break;
			}
		}
		System.out.println("total value obtained "+totalValue);
	}
}