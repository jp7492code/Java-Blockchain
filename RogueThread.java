public class RogueThread implements Runnable {

    @Override
    public void run() {

        Util oUtil = new Util();
        MerkleManager merkleManager = new MerkleManager();

        while(true){

        	oUtil.sleepRandomTime("Rogue Thread"); // let user know sleep status of thread
            String sNewWord = merkleManager.grabWord();

            // validate user input
            if(sNewWord != null){
            	oUtil.print("[Rogue] grabbed word: STRIKE!");
                MerkleManager.strikes++ ; // strike incrementer to end game
            }

        }
    }
}
