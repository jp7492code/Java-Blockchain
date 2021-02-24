public class RogueThread implements Runnable {

    @Override
    public void run() {

        Util oUtil = new Util();
        
        while(true) {
        	
        	oUtil.sleepRandomTime("Rogue Thread"); 
        	// ********************************************
        	// *** let user know sleep status of thread ***
            String sNewWord = MerkleManager.grabWord();
            // *** validate user input ***
            if(sNewWord != null){
            	System.out.println("[Rogue] grabbed word: STRIKE!");
                MerkleManager.strikes++ ; 
                // strike incrementer to end game
            }

        }
    }
}
