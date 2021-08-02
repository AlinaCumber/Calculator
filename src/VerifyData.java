public class VerifyData {
    
    public static int tryParseInt (String value, int defaultV){

        try{
            return Integer.parseInt(value);
        } catch(NumberFormatException e){

            return defaultV;
        }
    }
}
