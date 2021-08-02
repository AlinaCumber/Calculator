public class MathCalc {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static int Calc(int a, int b, String op){
        int result = 0;
        switch(op){
            case "+":
               result = a + b;
               break;
            case "-":
                result = a - b;
                break;
            case "/":
                if(b == 0){
                    System.out.println(ANSI_RED + "На ноль делить нельзя" + ANSI_RESET);
                    break;
                }
                result = a / b;
                break;
            case "*":
                result = a * b;
                break;
            default:
                System.out.println("Ошибка вычисления");

        }
        return result;
    }
}
