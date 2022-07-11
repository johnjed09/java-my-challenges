package ChallengesClasses;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MyMultithreading extends Thread {

    private int gwapoKaauID;

    public MyMultithreading(int gwapoKaauID) {
        this.gwapoKaauID = gwapoKaauID;
    }

    @Override
    public void run() {
        if (this.gwapoKaauID == 1) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("Gwapo kaau from " + this.gwapoKaauID);

        }

    }

}
