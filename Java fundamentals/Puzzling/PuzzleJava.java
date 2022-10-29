import java.util.Random;
import java.util.ArrayList;

public class PuzzleJava {
    
    public ArrayList<Integer> getTenRolls(){
        ArrayList<Integer> myarray = new ArrayList<Integer>();
        Random myRandom = new Random();
        for(int i=0; i<10;i++) {
            myarray.add(myRandom.nextInt(20));
        }return myarray;
    }

    public String getRandomLetter() {
        String [] letters = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"}; //curley prackets for the array, and it is fixed so we just fill it
        Random myAlph = new Random();
        String myAlphabet = letters[myAlph.nextInt(26)];
        return myAlphabet;
    }

    public String generatePassword(){
        String password = new String();
        for(int i=0; i<8;i++){
            password += getRandomLetter();
        }return password;
    }

    public ArrayList<String> getNewPasswordSet(int length){
        ArrayList<String> setPassword = new ArrayList<String>();
        for(int i=0; i<length ; i++){
            setPassword.add(generatePassword());
        } return setPassword;

    }
}