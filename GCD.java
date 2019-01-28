import java.io.*;
import java.util.*;
class GCD {
public static void main(String args[]) {
int a = 0, b = 0, d;
int sign_a = 1, sign_b = 1;
int[] ans = new int[3];
if (args.length < 2) {
System.out.println("\n Please input two arguments!\n");
System.exit(1);
} else if (args.length > 0) {
try {
a = Integer.parseInt(args[0]);
} catch (NumberFormatException e) {
System.err.println("\n Arguments must be integers!\n");
System.exit(1);
}
try {
b = Integer.parseInt(args[1]);
} catch (NumberFormatException e) {
System.err.println("\n Arguments must be integers!\n");
System.exit(1);
}
}
if ((a == 0) && (b == 0)) {
System.out.println("\n Oops, both arguments are zero! No GCD of zero!\n");
System.exit(1);
}
if (a < 0) {
sign_a = -1;
a = Math.abs(a);
}
if (b < 0) {
sign_b = -1;
b = Math.abs(b);
}
ans = ExtendedEuclid(a, b);
System.out.println("\n gcd(" + a * sign_a + "," + b *
sign_b + ") = " + ans[0]);
System.out.print(" " + ans[0] + " = (" + sign_a * ans[1] +
") (" + sign_a * a + ")");
System.out.println(" + (" + sign_b * ans[2] + ") (" + sign_b
* b + ")\n");
}
public static int[] ExtendedEuclid(int a, int b) {
int[] ans = new int[3];
int q;
if (b == 0) {
/* If b = 0, then we're done... */ ans[0] = a;
ans[1] = 1;
ans[2] = 0;
} else {
/* Otherwise, make a recursive function call */ q = a
/ b;
ans = ExtendedEuclid(b, a % b);
int temp = ans[1] - ans[2] * q;
ans[1] = ans[2];
ans[2] = temp;
}
return ans;
}}