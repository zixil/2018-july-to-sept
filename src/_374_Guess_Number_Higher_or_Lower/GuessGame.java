package _374_Guess_Number_Higher_or_Lower;

public class GuessGame {
    int n=12;

    int guess(int num) {
        return Integer.compare(n, num);
    }
}
