import java.util.Arrays;
import java.util.Scanner;

public class Calc {
    private int[] numAr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private String[] numRom = {"I", "II", "III", "IV", "V", "VI", "VII", "VII", "VIII", "IX", "X"};
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public int[] GetNumAr(){
        return numAr;
    }

    public String[] GetNumRom(){
        return numRom;
    }


    public void ArabAndRomanCalc() throws Exception {
        Scanner scanner = new Scanner(System.in);


        while (true) {

            System.out.println("Введите арабские или римские цифры: ");
            System.out.println("Для выхода наберите exit");
            String line = scanner.nextLine();
            if(line.equals("exit")){
                System.out.println("До свидания");
                break;
            }
            String[] splitLine = line.split(" ");
            if (splitLine.length != 3) {
                                System.out.println("\033[H\033[2J");
                System.out.flush();
                throw new IllegalArgumentException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");

            }
            String a = splitLine[0];
            String b = splitLine[2];
            String op = splitLine[1];

            if(Arrays.asList(numRom).contains(a) && Arrays.asList(numRom).contains(b)){
                int number = ConvertNumbers.RomanToArab(a);
                int number2 = ConvertNumbers.RomanToArab(b);
                int result = MathCalc.Calc(number,number2, op);
                if(result < 0){

                        throw new Exception("т.к. в римской системе нет отрицательных чисел");

                }
                if(result > 10){
                    System.out.println(ConvertNumbers.ArabToRoman(result));
                    System.out.println("\033[H\033[2J");
                    System.out.flush();

                }
                else if (result == 0 ){

                    System.out.println("N");
                    System.out.println("\033[H\033[2J");
                    System.out.flush();

                }
                else{
                    String resulta = numRom[result - 1];
                    System.out.println(resulta);
                    System.out.println("\033[H\033[2J");
                    System.out.flush();
                }

            }
            else{
                int number = VerifyData.tryParseInt(a, -11);
                int number2 = VerifyData.tryParseInt(b, -11);

                if (number == -11 || number2 == -11 || number > 10 || number2 > 10){
                    throw new Exception("т.к. используются одновременно разные системы счисления");
                }


                for (int i = 0; i < numAr.length; i++) {
                    for (int j = 0; j < numAr.length; j++) {
                        if (number == numAr[i] && number2 == numAr[j]) {
                            int result = MathCalc.Calc(number, number2, op );
                            System.out.println(result);
                            System.out.println("\033[H\033[2J");
                            System.out.flush();
                            break;
                        }
                    }
                }
            }
        }

    }


}
