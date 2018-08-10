package _374_Guess_Number_Higher_or_Lower;

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        if(guess(n)==0) return n;
        long min=1,max=n;
        while(true){
            long mid=(min+max)/2;
            //System.out.println(mid);
            int tmp=guess((int)mid);
            if(tmp==0) return (int)mid;
            if(tmp==1) min=mid;
            else max=mid;
        }
    }
}
