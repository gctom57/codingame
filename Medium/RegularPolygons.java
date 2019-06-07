import java.util.*;

class Solution {

    static int[] fermals = {1,
            3,
            5,
            15,
            17,
            51,
            85,
            255,
            257,
            771,
            1285,
            3855,
            4369,
            13107,
            21845,
            65535,
            65537,
            196611,
            327685,
            983055,
            1114129,
            3342387,
            5570645,
            16711935,
            16843009,
            50529027,
            84215045,
            252645135,
            286331153,
            858993459,
            1431655765};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();

        int nbSolution = 0;

        int powerOfTwo = 1;
        while(powerOfTwo <= b && powerOfTwo > 0) {
            for (int j : fermals) {
                if (powerOfTwo * j < 0) {
                    break;
                }
                if (powerOfTwo * j >= a && powerOfTwo * j <= b) {
                    nbSolution++;
                }
            }
            powerOfTwo *= 2;
        }

        System.out.println(nbSolution);
    }
}
