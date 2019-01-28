import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class InsertionSort {
int c, i, j, key;
String b;
boolean temp = true;
public InsertionSort() throws IOException
{
InputStreamReader f = new InputStreamReader(System.in);
BufferedReader br = new BufferedReader(f);
int a[];
ArrayList<Integer> list = new ArrayList<Integer>();
System.out.println("Enter the elements to sort:");
while (temp)
{
b = br.readLine();
if (b.equalsIgnoreCase(""))
{
System.out.println("STOP");
break;
}
else
{
int c = Integer.parseInt(b);
list.add(c);
}
}
for (j = 1; j < list.size(); j++)
{
key = list.get(j);
i = j - 1;
while (i >= 0 && list.get(i) > key)
{
list.set(i + 1, list.get(i));
i = i - 1;
}
list.set(i + 1, key);
}
System.out.println("Your sorted Elements are:");
for (i = 0; i < list.size(); i++)
{
System.out.println(list.get(i));
}
}
public static void main(String[] args) throws IOException
{
long startime = System.currentTimeMillis();
InsertionSort is = new InsertionSort();
long endtime = System.currentTimeMillis();
System.out.println("Insertion sort timing:" + (endtime -
startime) + " Milliseconds");
}
}