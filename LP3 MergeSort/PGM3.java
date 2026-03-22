import java.util.Scanner;
import java.util.Random;

public class PGM3 {
    public static int count = 0;

    static void merge(int b[], int c[], int a[]) {
        // Merges two sorted arrays into one sorted array
        // Input: Arrays b and c, both sorted
        // Output: Sorted array a of the elements of b and c

        int i = 0, j = 0, k = 0;
        int p = b.length;
        int q = c.length;
        while ((i < p) && (j < q)) {
            count++;
            if (b[i] <= c[j])
                a[k++] = b[i++];
            else
                a[k++] = c[j++];
        }
        // Copy the remaining array elements from any one of sub-array
        while (i < p)
            a[k++] = b[i++];
        while (j < q)
            a[k++] = c[j++];
    }

    static void mergesort(int a[]) {
        // Sorts array a by recursive mergesort
        // Input: An array a of orderable elements
        // Output: Array a sorted in nondecreasing order

        int n = a.length;
        if (n > 1) {
            int p = (int) Math.floor(n / 2.0); //or n/2
            int q = (int) Math.ceil(n / 2.0); //or n-p
            int b[] = new int[p];
            int c[] = new int[q];
            System.arraycopy(a, 0, b, 0, p);
            System.arraycopy(a, p, c, 0, q);
            mergesort(b);
            mergesort(c);
            merge(b, c, a);
        }
    }

    public static void main(String[] args) {
        int n;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the no. of elements");
        n = s.nextInt();
        int a[] = new int[n];

        // use random class object to generate random values
        Random r = new Random();
        System.out.println("intput numbers");
        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(10000);
            System.out.print(a[i] + " ");
        }

        mergesort(a);
        System.out.println("\n\nSorted numbers are");
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println("\nNo. of basic operations are " + count);
        System.out.println("Best Case: "+ (int)(n*Math.log(n)/Math.log(2)));
        System.out.println("Worst Case: "+ (int)(n*Math.log(n)/Math.log(2)));
    }
}