/**
 * 1、
 * arr[][]={{34,21,44,66,18},{22,10,4,49,77},{25,2,78,55,48}}中的最小值，并输出。
 */
public class array {
    public static void main(String[] args) {
        int[][] arr = {{34, 21, 44, 66, 18}, {22, 10, 4, 49, 77}, {25, 2, 78, 55, 48}};
        int i = 0;
        int j = 0;
        int min = arr[0][0];
        while (i < 3) {//【 正确答案: j<5 或 j<=4】//题目错了
            while (j < 5) {
                if (arr[i][j] < min)
                    min = arr[i][j];
                j++;
            }
            j = 0;      //【 正确答案: j=0】
            i++;      //【 正确答案: i++ 或 i+=1 或 i=i+1】
        }
        System.out.println("The min:" + min);
    }
}
