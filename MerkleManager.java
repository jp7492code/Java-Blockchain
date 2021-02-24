public class MerkleManager {

    // *** Variable initial and declarations ***
    public static volatile String usersEnteredWord; 
    // *** Volatile: prevents different threads from keeping cache of this ***
    public static String userEnteredExpectedMerkleRoot;
    public static String merkleRoot = null;
    public static int strikes = 0;

    public void manage() {
        // *** Create an instance of the Util class ***
        Util oUtil = new Util();

        // *** Created 3 instances of the three kinds of threads ***
        Thread oMerkleThread = new Thread(new MerkleThread());
        Thread oRogueThread = new Thread(new RogueThread());
        Thread oMonitorThread = new Thread(new MonitorThread());

        userEnteredExpectedMerkleRoot = oUtil.promptUser("Enter the expected merkle root (use https://www.xorbin.com/tools/sha256-hash-calculator): ");

        // *** Start three threads ***
        oMerkleThread.start();
        oRogueThread.start();
        oMonitorThread.start();

        while(true){
        	usersEnteredWord = oUtil.promptUser("Enter value: ");
        }

    }
    public static synchronized String grabWord() {
        String temp = usersEnteredWord;
        usersEnteredWord = null;
        return temp;
    }

}