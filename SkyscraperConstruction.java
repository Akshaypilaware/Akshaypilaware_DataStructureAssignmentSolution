import java.util.Scanner;
import java.util.Stack;

public class SkyscraperConstruction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total no of floors in the building");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the floor size given on day :");
        for (int i = 0; i < n; i++) {
            int day = i + 1;
            System.out.println("enter the floor size given on day : " + day);
            arr[i] = sc.nextInt();
        }
        sc.close();

        Stack<Integer> stack = new Stack<>();
        System.out.println("The order of construction is as follows");
        for (int i = 0; i < n; i++) {
            int day = i + 1;
            while (!stack.isEmpty() && stack.peek() < arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty() || arr[i] == n) {
                stack.push(arr[i]);
                System.out.print("Day: " + day + "\n");
                for (int j = stack.size() - 1; j >= 0; j--) {
                    System.out.print(stack.get(j) + " ");
                }
                System.out.println();
            } else {
                System.out.println("Day: " + day + "\n");
            }
        }
    }
}
