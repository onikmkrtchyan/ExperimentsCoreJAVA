import java.util.Arrays;
import java.util.Scanner;

public class ReverseString
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        char[] arr = text.toCharArray();
        int size = arr.length;
        int i = 0;
        char temp;
        while(i<size/2){
            temp = arr[i];
            arr[i] = arr[size-i-1];
            arr[size-i-1] = temp;
            i++;
        }
        System.out.println(Arrays.toString(arr));
    }
}
