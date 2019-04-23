import java.util.Scanner;

public class isHappyNum {
    public static int sum(int num){
        int sum = 0;
        int temp = 0;
        while(num != 0){
            temp = num;
            temp %= 10;
            num /= 10;
            sum += temp*temp;
        }
        return sum;
    }
    public static boolean isHappyNum(int num){
        if(num < 0){
            return false;
        }
        if(sum(num) == 1){
            return true;
        }
        else if(sum(num) == 4){
            return false;
        }else{
            num = sum(num);
        }return isHappyNum(num);
    }
    public static void main(String[] args) {
        int num;
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();
        System.out.println(isHappyNum(num));
    }
}
// public static int fun(int n){
//     int[] array = new int[n];
//     for(int i = 0;i < array.length;i++){
//         array[i] = 1;
//     }
//     int count = 0;
//     int num = n;
//     while(num > 1){
//         for(int i = 0; i < n; i++){
//             if(array[i] == 1){
//                 count++;
//                 if(count == 3){
//                     array[i] = 0;
//                     num--;
//                     count = 0;
//                 }
//             }
//         }
//         for(int i = 0;i < n;i++){
//             if(array[i] == 1){
//                 return i;
//             }
//         }
//         return -1;
//     }
// }