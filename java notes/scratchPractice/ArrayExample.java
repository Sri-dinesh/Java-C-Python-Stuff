public class ArrayExample {
    public static void main(String[] args) {

        int[] nums = { 10, 20, 30, 40, 50 };
        System.out.println("One dimensional array elements:");
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 }
        };

        System.out.println("Two dimensional array elements:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
