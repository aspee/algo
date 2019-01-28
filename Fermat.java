public class Fermat {
public static void checkFermat(int a, int b, int c, int n) {
if (((Math.pow(a, n) + Math.pow(b, n)) == Math.pow(c, n)) &&
(n != 2)) {
System.out.println("Holy smokes, Fermat was wrong!");
} else {
System.out.println("No, that doesn't work.");
}
}
public static void main(String[] args) {
checkFermat(5, 4, 8, 4);
}
}