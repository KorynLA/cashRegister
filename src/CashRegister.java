import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Class that receives input via stdin and outputs list of the smallest amount of coins
 * and bills as a formatted list
 */
public class CashRegister {
    /**
     * Takes the user input and finds the smallest amount of corresponding denominations
     * @param usDenominations
     * @param userChange
     * @return
     */
    public static int[] findSmallestChange(float [] usDenominations, float userChange) {
        int [] smallestChange = new int[usDenominations.length];
        Arrays.fill(smallestChange, 0);
        for(int i=usDenominations.length-1; i > -1; i--) {
            if(usDenominations[i] <= userChange) {
                smallestChange[i] = (int) Math.floor(userChange/usDenominations[i]);
                userChange=userChange-(usDenominations[i]*smallestChange[i]);
            }
        }
        return smallestChange;
    }

    /**
     * Main used to retrieve valid decimal value from user using stdin.
     * Runs function to find the smallest change combination.
     * Prints the formatted version of the denominations and their associated values if greater than 0.
     * @param args
     */
    public static void main(String[] args) {
        float [] usDenominations = {.01f, .05f, .10f, .25f, 1f, 5f, 10f, 20f};

        System.out.print("Change amount is: ");
        Scanner scanUserInput = new Scanner(System.in);
        float userChange = scanUserInput.nextFloat();

        int[] smallestChange = findSmallestChange(usDenominations, userChange);
        DecimalFormat formatWholeNum = new DecimalFormat("##");
        DecimalFormat formatFloatNum = new DecimalFormat(".##");
        for(int i=usDenominations.length-1; i > -1; i--) {
            if(smallestChange[i] != 0) {
                if(usDenominations[i]%1 == 0) {
                    System.out.println(formatWholeNum.format(usDenominations[i]) + ": " + smallestChange[i]);
                }
                else {
                    System.out.println(formatFloatNum.format(usDenominations[i]) + ": " + smallestChange[i]);
                }
            }
        }
    }
}
