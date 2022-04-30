public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {3, 1, 0, -10, 5, 6, 8, -15};


        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSorted = false;
                }
            }
            if(isSorted) break;
        }

        for(int a : arr) {
            System.out.println(a);
        }
    }
}
