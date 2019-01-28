import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
public class LCS
{
int i,j,m,n,a;
public static int [][] c = new int[30][30];
public static char [] x = new char[15];
public static char [] y = new char[15];
public static char [][]b = new char [30][30];
public static void main(String[] args)
{
try
{
LCS objLCS= new LCS();
BufferedReader br= new BufferedReader(new
InputStreamReader(System.in));
String seq1,seq2;
System.out.println("Enter First Sequence: ");
seq1= br.readLine();
System.out.println("Enter Second Sequence: ");
seq2= br.readLine();
System.out.println("Seq1: "+ seq1);
System.out.println("Seq2: "+ seq2);
objLCS.setSeq(seq1,seq2);
objLCS.lcsLength();
}
catch (IOException ex)
{
Logger.getLogger(LCS.class.getName()).log(Level.SEVERE, null,
ex);
}
}
public void getLCS(int i,int j)
{
if(i==0 || j==0)
return;
if(b[i][j]=='c')
{
getLCS(i-1,j-1);
System.out.println(x[i-1]);
}
else if(b[i][j]=='u')
getLCS(i-1,j);
else
getLCS(i,j-1);
}
void lcsLength()
{
m=x.length;
n=y.length;
for(i=0;i<=m;i++)
c[i][0]=0;
for(i=0;i<=n;i++)
c[0][i]=0;
for(i=1;i<=m;i++)
{
for(j=1;j<=n;j++)
{
if(x[i-1]==y[j-1])
{
c[i][j]=c[i-1][j-1]+1;
b[i][j]='c';
}
else if(c[i-1][j]>=c[i][j-1])
{
c[i][j]=c[i-1][j];
b[i][j]='u';
}
else
{
c[i][j]=c[i][j-1];
b[i][j]='l';
}
}
getLCS(m,n);
}
}
private void setSeq(String seq1, String seq2)
{
x=seq1.toCharArray();
y=seq2.toCharArray();
}
}