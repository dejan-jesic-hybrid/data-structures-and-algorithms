## Sorting algorithms

1. **Bubble sort**
2. **Merge sort**
3. **Quicksort**


* **Bubble sort**

Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order.

![bubble-sort](../images/bubble-sort.gif)

```
public int[] sort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1])
                {
                    // swap temp and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        return arr;
    }
```

Runtime characteristics: O(n²)

* **Merge sort**

Merge Sort uses recursion to solve the problem of sorting more efficiently than algorithms previously presented, and in particular it uses a divide and conquer approach.

Using both of these concepts, we'll break the whole array down into two subarrays and then:

Sort the left half of the array (recursively)
Sort the right half of the array (recursively)
Merge the solutions

![merge-sort](../images/merge-sort.gif)

```
// Main function that sorts arr[l..r] using
    // merge()
    public void sort(int arr[], int l, int r)
    {
        System.out.println("splitting l r: " + l + " " + r);
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr , m+1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    private void merge(int arr[], int l, int m, int r)
    {
        System.out.println("merge l m r: " + l + " " + m + " " + r);

        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /* Copy data to temp arrays */
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }

        System.out.println("After merge");
        printArray(arr);
    }

    // Pros: Pretty efficient sorting algorithm - O(n log(n))

    // Cons: Takes up a bit more space (as you are copying and duplicating contents of array)

```

Runtime characteristics: O(n log n)

* **Quick sort**

Like Merge Sort, QuickSort is a Divide and Conquer algorithm. 

It picks one element of an array as the pivot and sorts all of the other elements around it, for example smaller elements to the left, and larger to the right.

![quick-sort](../images/quick-sort.gif)

```
public int[] sort(int[] array) {
        // Pick a pivot element randomly

        // Walk through the array making sure that all the elements
        // are smaller before the pivot, and that all elements after are bigger
        // and we do this in place! That's the killer feature. No extra array required.
        //
        // Then we repeat the process to the left and right portions over and over again
        // Then eventually our array becomes sorted.

        quickSort(array, 0, array.length - 1);

        return array;
    }

    private void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        // Step 1: Pick a pivot element - we will choose the center
        // Better would be to choose left + (right-left)/2 (as this would avoid overflow error for large arrays i.e. 2GB))
        int pivot = array[(left + right)/2];

        // Step 2: Partition the array around this pivot - return the index of the partition
        int index = partition(array, left, right, pivot);

        // Step 3: Sort on the left and the right side
        quickSort(array, left, index - 1);
        quickSort(array, index, right);
    }

    private int partition(int[] array, int left, int right, int pivot) {
        // Move the left and right pointers in towards each other
        while (left <= right) {

            // Move left until you find an element bigger than the pivot
            while(array[left] < pivot) {
                left++;
            }

            // Move right until you find an element smaller than the pivot
            while (array[right] > pivot) {
                right--;
            }

            // Then swap
            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }

        // When we get here, everything in this partition will be in the right order
        // Now we need to return next partition point - which for us will be left
        return left;
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
```

Runtime characteristics: O(n log n)


**JAVA implementations**

1. **Arrays.sort(int[] array)** - Arrays.sort uses dual-pivot Quicksort on primitives. It offers O(n log(n)) performance and is typically faster than traditional (one-pivot) Quicksort implementations. However it uses a stable, adaptive, iterative implementation of mergesort algorithm for Array of Objects.
2. **Arrays.sort(int[] a, int fromIndex, int toIndex)** - Sorting part of an array
3. **Arrays.parallelSort(int[] array)** - Behind the scenes of parallelSort(), it breaks the array into different sub-arrays (as per granularity in the algorithm of parallelSort). Each sub-array is sorted with Arrays.sort() in different threads so that sort can be executed in parallel fashion and are merged finally as a sorted array.
4. **Collections.sort(List<Integer> list)** - Collections.Sort, it uses a modified mergesort and offers guaranteed n log(n) performance.
