import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
public class PermuteBySort {
public static void main(String[] args)
{ try{
int[] a=new int[10];
BufferedReader br = new BufferedReader(new
InputStreamReader(System.in));
String input= "";
System.out.println("Write an array to be Permute:");
for(int i=0;i<9;i++)
{
input=br.readLine();
if(input.equalsIgnoreCase(""))
break;
a[i]=Integer.parseInt(input);
}
System.out.println("Unsorted: "+Arrays.toString(a));
a=pSort(a);
System.out.println("Sorted: "+Arrays.toString(a));
}
catch (IOException ex)
{
Logger.getLogger(PermuteBySort.class.getName()).log(Level.SEVERE, null, ex);
}
}
public static int[] pSort(int[] a)
{
List<int[]> list=new ArrayList<int[]>();
permute(a,a.length,list);
for(int[] x : list)
if(isSorted(x))
return x;
return a;
}
private static void permute(int[] a, int n, List<int[]> list)
{
if (n == 1)
{
int[] b=new int[a.length];
System.arraycopy(a, 0, b, 0, a.length);
list.add(b);
return;
}
for (int i = 0; i < n; i++)
{
swap(a, i, n-1);
permute(a, n-1, list);
swap(a, i, n-1);
}
}
private static boolean isSorted(int[] a)
{
for(int i=1;i<a.length;i++)
if(a[i-1]>a[i])
return false;
return true; }
private static void swap(int[] arr,int i, int j)
{
int temp=arr[i];
arr[i]=arr[j];
arr[j]=temp;
};
}