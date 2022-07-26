package PulseTest.PulseTest;
import java.util.*;


public class App {

    public static void main(String[] args) {
        int sum;
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        String numberToString = String.valueOf(number);
        validateUserInput(numberToString );

        int ranNum =generateRanNum();

        long twl = Long.valueOf(String.valueOf(number) + String.valueOf(ranNum));

        String m = String.valueOf(twl);

        sum = getSum(m);

        long fnum = Long.valueOf(String.valueOf(twl) + String.valueOf(getCtrlNum(sum)));
    }

    public static void validateUserInput(String numberToString){
        if (numberToString.length() == 9) {
            String numberArray[] = numberToString.split("");
            int a = Integer.parseInt(numberArray[0]);
            if (a < 1) {
                System.out.println("Incorrect first digit");
            } else if (a == 9) {
                System.out.println("Non- residents");
            }

            String yearOfBirth=numberArray[1]+numberArray[2];

            if(Integer.parseInt(numberArray[3]) >1 ) ) {
                System.out.println("Please enter valid month");
            else if (Integer.parseInt(numberArray[3])==1 && Integer.parseInt(numberArray[4])>2){
                System.out.println("Please enter valid month");
            }
            else if (Integer.parseInt(numberArray[3])==0 && Integer.parseInt(numberArray[4])==0){
                System.out.println("Please enter valid month");
            }

            int month = Integer.valueOf(numberArray[3] + numberArray[4]);

            int f = Integer.parseInt(numberArray[5]);
            if (f > 3) {
                System.out.println("Please enter valid date");
            }

            int g = Integer.parseInt(numberArray[6]);
            if (f == 0 && g == 0) {
                System.out.println("Please enter valid date");
            } else if (f == 3 && g > 1) {
                System.out.println("Please enter valid date");
            } else if ((f == 3 && g > 0) && (month == 04 || month == 06 || month == 11)) {
                System.out.println("Please enter valid date");
            } else if (month == 02 && f == 2 && g > 9) {
                System.out.println("Please eneter valid date");
            }
            int fg = Integer.valueOf(String.valueOf(f) + String.valueOf(g));

            int h = Integer.parseInt(numberArray[7]);
            if (h > 5) {
                System.out.println("Please enter valid Code");
            }
                
            int j = Integer.parseInt(numberArray[8]);
            if (h == 5 && j > 2) {
                System.out.println("Please enter valid Code");
            }
                
            int hj = Integer.valueOf(String.valueOf(h) + String.valueOf(j));
        } else {
            System.out.println("Please enter 9 digit number");

        }
    }
    public static int getSum(String num) {
        int sum = 0;
        for (int i = 0; i < num.length() - 1; i++) {

            char p = num.charAt(i);
            int a1 = Character.getNumericValue(p);
            sum = sum + ((i + 1) * a1);
        }
        return sum;
    }

    public static int generateRanNum() {
        return (int) Math.floor(Math.random() * 900) + 100;
    }
    public static long getCtrlNum(int sum){
        long  ctrlNum,rem;

        rem = sum - (11 * (sum / 11));
        if (rem == 10) {
            ctrlNum = 1;
        }
        else {
            ctrlNum = rem;
         }

    return  ctrlNum;
    }
}
