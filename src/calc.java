import java.util.Arrays;
import java.util.Scanner;
class Main {
    public static String arabicToRoman(String str) {
        String[] romanNums = new String[] {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] arabicNums = new int[] {100, 90, 50, 40, 10, 9, 5, 4, 1};
        double num = Double.parseDouble(str);
        String result = "";
        int k = 0;
        while (num > 0) {
            if (num < arabicNums[k])
                k++;
            else {
                num -= arabicNums[k];
                result += romanNums[k];
            }
        }
        return result;
    }
    public static String calc(String str) {
        String[] arabicNums = new String[] {"1","2","3","4","5","6","7","8","9","10"};
        String[] romanNums = new String[] {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
        String aStr = ""; String bStr = "";
        int k = 0;
        while (str.charAt(k) != ' ') {
            aStr += str.charAt(k++);
        }
        char sign = str.charAt(k + 1);
        if (!(sign == '+' || sign == '-' || sign == '*' || sign == '/'))
            throw new IllegalArgumentException();
        k += 3;
        while (k != str.length()) {
            bStr += str.charAt(k++);
        }
        double a = 0; double b = 0;
        int k1 = 0; int k2 = 0;
        if (Arrays.asList(arabicNums).contains(aStr)) {
            if (Arrays.asList(romanNums).contains(bStr))
                throw new IllegalArgumentException();
            else if (Arrays.asList(arabicNums).contains(bStr)) {
                a = Integer.parseInt(aStr);
                b = Integer.parseInt(bStr);
            }
            else
                throw new IllegalArgumentException();
        }
        else if (Arrays.asList(romanNums).contains(aStr)) {
            if (Arrays.asList(arabicNums).contains(bStr))
                throw new IllegalArgumentException();
            else if (Arrays.asList(romanNums).contains(bStr)) {
                while (!(aStr.equals(romanNums[k1])))
                    k1++;
                a = Integer.parseInt(arabicNums[k1]);
                while (!(bStr.equals(romanNums[k2])))
                    k2++;
                b = Integer.parseInt(arabicNums[k2]);
            }
            else
                throw new IllegalArgumentException();
        }
        else
            throw new IllegalArgumentException();
        String strResult = ""; double doubleResult = 0;
        switch (sign) {
            case '+':
                doubleResult += a + b;
                break;
            case '-':
                doubleResult += a - b;
                break;
            case '*':
                doubleResult += a * b;
                break;
            case '/':
                doubleResult += a / b;
                break;
            default:
                break;
        }
        strResult += doubleResult;
        if (Arrays.asList(romanNums).contains(aStr)) {
            if (doubleResult <= 0 || a % b != 0)
                throw new IllegalArgumentException();
            strResult = arabicToRoman(strResult);
        }
        return strResult;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print(calc(scanner.nextLine()));
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException();
        }
    }
}