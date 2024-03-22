import java.util.ArrayList;

public class Snail {

    /**
     *
     * TODO 5
     *
     * Input: an n x n 2d array.
     * Output: a 1d array of length n^2 that contains the order of elements visited in a snail traversal of the 2d array.
     *
     * Example:
     *
     * Input:
     *
     * {
     *     {1,2,3},
     *     {4,5,6},
     *     {7,8,9}
     * }
     *
     * Output:
     *
     * {1,2,3,6,9,8,7,4,5}
     *
     * @param array2d
     * @return a 1d array containing the order of elements visited in a snail traversal of the 2d array.
     *         returns an empty array if array2d is not square.
     */
    public static int[] flattenSnail(int[][] array2d) {
        if (array2d == null){
            return new int[0];
        }
        for (int[] thing : array2d){
            if (thing.length != array2d.length){
                return new int[0];
            }
        }
        int[] array = new int[array2d.length * array2d.length];
        int direction = 0;
        boolean running = true;
        int n = 0;
        int x = 0;
        int y = 0;
        int edge = 0;
        int height = array2d.length;
        while (running){
            if (direction == 0){
                array[n] = array2d[y][x];
                x++;
                n++;
            }
            if (direction == 1){
                array[n] = array2d[y][x];
                y++;
                n++;
            }
            if (direction ==2){
                array[n] = array2d[y][x];
                if (x > 0){
                    x--;
                }
                n++;
            }
            if (direction == 3){
                array[n] = array2d[y][x];
                y--;
                n++;
            }
            if (direction == 4){
                direction = 0;
                edge++;
                continue;
            }
            if (x == height-1-edge && y == edge){
                direction++;
            }
            if (x == height-1-edge && y == height-1-edge){
                direction++;
            }
            if (x == edge && y == height-1-edge){
                direction++;
            }
            if (x == edge && y == edge){
                direction++;
                y++;
                x++;
            }
            if (n == array.length){
                running = false;
            }
        }
        return array;
    }

    /**
     *
     * TODO 6
     *
     * Input: a 1d array of length n, where n is a perfect square.
     * Output: a 2d array of width == height == sqrt(n) that represents a snail.
     *
     * Example:
     *
     * Input:
     *
     * {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
     *
     * Output:
     *
     * {
     *     {1,2,3,4,5},
     *     {16,17,18,19,6},
     *     {15,24,25,20,7},
     *     {14,23,22,21,8},
     *     {13,12,11,10,9},
     * }
     *
     *
     * @param array1d
     * @return a 2d array of width == height == sqrt(n), where n is the length of the inputted array, that represents a snail.
     *         returns an empty 2d array if the length of array1d is not a perfect square.
     */
    public static int[][] makeSnail(int[] array1d) {
        if (array1d == null){
            return new int[0][0];
        }
        if (!isPerfectSquare(array1d)){
            return new int[0][0];
        }
        int height = (int) Math.sqrt(array1d.length);
        int[][] snail = new int[height][height];
        int direction = 0;
        boolean running = true;
        int n = 0;
        int x = 0;
        int y = 0;
        int edge = 0;
        while (running){
            if (direction == 0){
                snail[y][x] = array1d[n];
                x++;
                n++;
            }
            if (direction == 1){
                snail[y][x] = array1d[n];
                y++;
                n++;
            }
            if (direction == 2){
                snail[y][x] = array1d[n];
                if (x > 0){
                    x--;
                }
                n++;
            }
            if (direction == 3){
                snail[y][x] = array1d[n];
                y--;
                n++;
            }
            if (direction == 4){
                direction = 0;
                edge++;
                continue;
            }
            if (x == height-1-edge && y == edge){
                direction++;
            }
            if (x == height-1-edge && y == height-1-edge){
                direction++;
            }
            if (x == edge && y == height-1-edge){
                direction++;
            }
            if (x == edge && y == edge){
                direction++;
                y++;
                x++;
            }
            if (n == array1d.length){
                running = false;
            }
        }
        return snail;
    }

    /**
     *
     * TODO 1
     *
     * Private helper method that prints the contents of a 1d array.
     * Used mainly for debugging purposes.
     *
     * @param array1d
     */
    private static void print1dArray(int[] array1d) {
        for (int thing : array1d){
            System.out.println(thing);
        }
    }

    /**
     *
     * TODO 2
     *
     * Private helper method that prints the contents of a 2d array.
     * Used mainly for debugging purposes.
     *
     * @param array2d
     */
    private static void print2dArray(int[][] array2d) {
        for (int[] array : array2d){
            for (int num : array){
                System.out.println(num);
            }
        }
    }

    /**
     *
     * TODO 3
     *
     * Private helper method that checks to see if a 1d array is of a length that is a perfect square.
     *
     * @param array1d
     * @return
     */
    private static boolean isPerfectSquare(int[] array1d) {
        int length = array1d.length;
        return Math.sqrt(length) == Math.floor(Math.sqrt(length));
    }


    /**
     *
     * TODO 4
     *
     * Private helper method that checks to see if a 2d array is a square.
     *
     * @param array2d
     * @return
     */
    private static boolean isPerfectSquare(int[][] array2d) {
        return (array2d.length == array2d[0].length);
    }


}
