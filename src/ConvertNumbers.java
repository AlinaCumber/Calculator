public class ConvertNumbers {

    public static int RomanToArab(String a){
        return switch (a) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> -11;
        };
    }

    public static String ArabToRoman(int number) throws Exception {
        if (number < 0 || number > 100) {
            throw new Exception("Число должно быть от 0 до 100");

        }

        int[] values = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] valuesRomanos = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        String result = "";
        for(int i = 0; i < 9; i++){
            while(number >= values[i]){
                number -= values[i];
                result =  result + valuesRomanos[i];
            }
        }
        return result;

    }


}
