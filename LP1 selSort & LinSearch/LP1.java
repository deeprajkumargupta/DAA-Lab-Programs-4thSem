import java.util.Scanner;
import java.util.Random;

class LP1 {
    public static int searchCount = 0;
    public static int sortCount = 0;

    public static int sequentialSearch(int a[], int key) {
        for (int i = 0; i < a.length; i++) {
            searchCount++;
            if (a[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void selectionSort(int a[]) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                sortCount++;
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            int temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        System.out.println("Enter value of n>=5000");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = r.nextInt(10000);
        }
        System.out.println("Enter the key element: ");
        int key = sc.nextInt();
        int index = sequentialSearch(arr, key);
        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found");
        }
        selectionSort(arr);
        System.out.println("First 5 sorted elements are: ");
        for (int i = 0; i < 5; i++)
            System.out.println(arr[i] + "\t");
        System.out.println("No of times the basic operation executed: ");
        System.out.println("Sequential Search: " + searchCount);
        System.out.println("Selection Sort: " + sortCount);
    }
}