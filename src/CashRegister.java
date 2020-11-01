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
    public static int[] findSmallestChange(double [] usDenominations, double userChange) {
        int [] denominationQuantity = new int[usDenominations.length];
        Arrays.fill(denominationQuantity, 0);
        for(int i=usDenominations.length-1; i > -1; i--) {
            if(usDenominations[i] <= userChange) {
                denominationQuantity[i] = (int) Math.floor(userChange/usDenominations[i]);
                userChange=((100*userChange)-(usDenominations[i]*denominationQuantity[i]*100))/100;
            }
        }
        return denominationQuantity;
    }

    /**
     * Main used to retrieve valid decimal value from user using stdin.
     * Runs function to find the smallest change combination.
     * Prints the formatted version of the denominations and their associated values if greater than 0.
     * @param args
     */
    public static void main(String[] args) {
        double [] usDenominations = {.01, .05, .10, .25, 1, 5, 10, 20};

        System.out.print("Change amount is: ");
        Scanner scanUserInput = new Scanner(System.in);
        double userChange = scanUserInput.nextDouble();

        int[] denominationQuantity = findSmallestChange(usDenominations, userChange);
        DecimalFormat formatWholeNum = new DecimalFormat("##");
        DecimalFormat formatFloatNum = new DecimalFormat(".##");
        for(int i=usDenominations.length-1; i > -1; i--) {
            if(denominationQuantity[i] != 0) {
                if(usDenominations[i]%1 == 0) {
                    System.out.println(formatWholeNum.format(usDenominations[i]) + ": " + denominationQuantity[i]);
                }
                else {
                    System.out.println(formatFloatNum.format(usDenominations[i]) + ": " + denominationQuantity[i]);
                }
            }
        }
    }
}
