package sample;

public class Validator {
    public static boolean checkInput(String input){
        try{
            int numb = Integer.parseInt(input);
            if (numb < 1){
                return false;
            }
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
}
