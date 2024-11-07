import java.util.Scanner;
 public class FibonacciStepCount {
 // Recursive Fibonacci with step count
 static int recursiveSteps = 0;
 public static int fibonacciRecursive(int n) {
 recursiveSteps++;
 if (n <= 1) {
 return n;
 }
 return fibonacciRecursive(n- 1) + fibonacciRecursive(n- 2);
 }
 // Iterative Fibonacci with step count
 public static int fibonacciIterative(int n) {
 int steps = 0;
 if (n <= 1) {
 steps++;
 return n;
 }
 int fib = 1, prevFib = 0;
 for (int i = 2; i <= n; i++) {
 steps++;
 int newFib = fib + prevFib;
 prevFib = fib;
 fib = newFib;
 }
 System.out.println("Iterative steps: " + steps);
 return fib;
 }
 public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
 // Get user input for the Fibonacci number to calculate
 System.out.print("Enter a number to calculate Fibonacci: ");
 int n = scanner.nextInt();
 // Recursive Fibonacci
 recursiveSteps = 0; // Reset the step counter
int fibRec = fibonacciRecursive(n);
 System.out.println("Recursive Fibonacci of " + n + " is: " + fibRec);
 System.out.println("Recursive steps: " + recursiveSteps);
 // Iterative Fibonacci
 int fibIter = fibonacciIterative(n);
 System.out.println("Iterative Fibonacci of " + n + " is: " + fibIter);
 scanner.close();
 }
 }