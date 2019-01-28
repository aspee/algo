import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class MergeSort
{
int i, j, k, key, n1, n2, no;
String f;
int a[];
boolean u = true;
public MergeSort() throws IOException
{
InputStreamReader o = new InputStreamReader(System.in);
BufferedReader br = new BufferedReader(o);
ArrayList<Integer> list = new ArrayList<Integer>();
System.out.println("Enter the elements to sort:");
while (u) {
f = br.readLine();
if (f.equalsIgnoreCase(""))
{
System.out.println("Stop::");
break;
}
else
{
no = Integer.parseInt(f);
list.add(no);
}
}
System.out.println("arry=" + list.size());
int p = 1;
int q = list.size() / 2;
int r1 = list.size();
int n = r1 - p + 1;
n1 = q - p + 1;
n2 = r1 - q;
int l[] = new int[n1 + 1];
int r[] = new int[n2 + 1];
l[n1]=1000000;
r[n2] = 1000000;
System.out.println("Left Array");
System.out.println("Length=" + l.length);
for (i = 0; i < n1; i++)
{
l[i] = list.get(p + i - 1);
}
for (i = 0; i < n1; i++)
{
System.out.print(l[i] + ",");
}
l = sort(l, n1);
System.out.println("\n");
System.out.println("right array");
System.out.println("Length=" + r.length);
for (j = 0; j < n2; j++)
{
r[j] = list.get(q + j);
}
for (j = 0; j < n2; j++)
{
System.out.print(r[j] + ",");
}
System.out.println("\n");
r = sort(r, n2);
i = 0;
j = 0;
for (k = p - 1; k < r1; k++)
{
if (l[i] <= r[j])
{
list.set(k, l[i]);
i = i + 1;
}
else
{
list.set(k, r[j]);
j = j + 1;
}
}
System.out.println("Sorted Elements are: \n");
for (i = 0; i < list.size(); i++)
{
System.out.print(list.get(i) + ",");
}
}
public int[] sort(int t[], int s)
{
for (j = 1; j < t.length; j++)
{
key = t[j];
i = j - 1;
while (i >= 0 && t[i] > key)
{
t[i + 1] = t[i];
i = i - 1;
}
t[i + 1] = key;
}
return t;
}
public static void main(String[] args) throws IOException
{
long startime = System.currentTimeMillis();
MergeSort mg = new MergeSort();
long endtime = System.currentTimeMillis();
System.out.println("\n Insertion sort timing:" + (endtime-startime) + " millisec");
}
}