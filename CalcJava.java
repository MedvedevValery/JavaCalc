package src;

import java.util.Scanner;

 class RomanAndArabicCalc {
    public static String intToRoman(int n){
        String result = "";
        int t = n / 10;
        if (t == 1) result += "X";
        if (t == 2) result += "XX";
        if (t == 3) result += "XXX";
        if (t == 4) result += "XL";
        if (t == 5) result += "L";
        if (t == 6) result += "LX";
        if (t == 7) result += "LXX";
        if (t == 8) result += "LXXX";
        if (t == 9) result += "XC";
        if (t == 10) result += "C";
        int e = n % 10;
        if (e == 1) result += "I";
        if (e == 2) result += "II";
        if (e == 3) result += "III";
        if (e == 4) result += "IV";
        if (e == 5) result += "V";
        if (e == 6) result += "VI";
        if (e == 7) result += "VII";
        if (e == 8) result += "VIII";
        if (e == 9) result += "IX";


        return result;
    }
    public static int romanToInt(String z){
        int result = 0;
        for (int i = 0; i < z.length(); i++){
            if (z.charAt(i) == 'X') result += 10;
            if (z.charAt(i) == 'V') result += 5;
            if (z.charAt(i) == 'I'){
                if (i < z.length() - 1 && (z.charAt(i + 1) == 'V' || z.charAt(i + 1) == 'X')  ) result -= 1;
                else result += 1;
            }

        }

        return result;

    }
    public static boolean isRoman(String z){

        for (int i = 0; i < z.length(); i++){
            if(z.charAt(i) == 'V' || z.charAt(i) == 'X' || z.charAt(i) == 'I' );
            else
                return false;
        }
        return true;
    }
    public static int Calculator(int a, int b, String operator) throws Exception
    {
        if (operator.equals("+") ) return a + b;
        if (operator.equals("-")) return a - b;
        if (operator.equals("*")) return a * b;
        if (b == 0) throw new Exception("div by 0");
        if (operator.equals("/")) return a / b;
        throw new Exception("wrong operator");

    }
    public static boolean IsArabic(String z){
        try {
            int a = Integer.parseInt(z);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }

    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            String k = scan.nextLine();
            String result[] = k.split("\s+");
            if(result.length != 3) throw new Exception("wrong input format");
            if (isRoman(result[0]) && isRoman(result[2])) {
                int a = romanToInt(result[0]);
                int b = romanToInt(result[2]);
                if (a > 10 || b > 10) throw new Exception("greater than 10");
                int f = Calculator(a, b, result[1]);
                if (f <= 0) throw new Exception("Negative Roman");
                System.out.println(intToRoman(f));
            } else if (IsArabic(result[0]) && IsArabic(result[2])) {
                int a = Integer.parseInt(result[0]);
                int b = Integer.parseInt(result[2]);
                if (a > 10 || b > 10) throw new Exception("greater than 10");
                if (a <= 0 || b <= 0) throw new Exception("less than 1");
                System.out.println(Calculator(a, b, result[1]));
            } else throw new Exception("Wrong format of numbers");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}