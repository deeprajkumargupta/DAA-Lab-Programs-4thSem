import java.util.Scanner;
import java.util.Random;

public class PGM2 {
    static int count = 0;

    static int partition(int a[], int l, int r)
    // Partitions a subarray by Hoare’s algorithm, using the first element as a
    // pivot
    // Input: Subarray of array A[0..n − 1], defined by its left and right indices l
    // and r (l<r)
    // Output: Partition of A[l..r], with the split position returned as this
    // function’s value
    {
        int pivot = a[l], temp, i = l, j = r + 1;
        do {
            // Traverse i from left to right, segregating element of left group
            do {
                i++;
                count++;
            } while (i < r && a[i] <= pivot);
            // Traverse j from right to left, segregating element of right group
            do {
                j--;
                count++;
            } while (j > l && a[j] >= pivot);
            // Swap a[i] and a[j]
            {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        } while (i < j);

        // Undo the last swap
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;

        // Swap a[l] and a[j]
        temp = a[l];
        a[l] = a[j];
        a[j] = temp;

        return j;
    }

    static void quicksort(int a[], int l, int r)
    // Sorts a subarray by quicksort
    // Input: Subarray of array A[0..n − 1], defined by its left and right indices l
    // and r
    // Output: Subarray A[l..r] sorted in nondecreasing order
    {
        int s;
        if (l < r) {
            // partition to place pivot element in between left and right group
            s = partition(a, l, r);
            quicksort(a, l, s - 1);
            quicksort(a, s + 1, r);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = r.nextInt(10000);
            System.out.println(arr[i] + " ");
        }
        quicksort(arr, 0, n - 1);
        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println("Number of comparisons: " + count);
        System.out.println("Best Case: "+ n*(Math.log10(n)/Math.log10(2)));
        System.out.println("Worst Case: "+ n*(Math.log10(n)/Math.log10(2)));
    }
}