public class MonitorThread implements Runnable {

    Util oUtil = new Util();
    @Override
    public void run() {


        while(true){
            if(MerkleManager.merkleRoot != null){
                //if there is a merkle root
                if(MerkleManager.merkleRoot.equals(MerkleManager.userEnteredExpectedMerkleRoot)){
                	oUtil.print("You Win: " +MerkleManager.merkleRoot);
                    System.exit(0);
                }
                else {
                	oUtil.print("The roots don't match: You lose!\n");

                    // *** DEBUG TESTS ***
                	oUtil.printList(MerkleThread.grabbedWords); // DEBUG: test print to see what's in my ArrayList
                	oUtil.print("Actual Root: " +MerkleManager.merkleRoot ); // DEBUG: test print to see what the actual merkle root value is
                	oUtil.print("Your guessed root: " +MerkleManager.userEnteredExpectedMerkleRoot); //DEBUG: test print for users guess of merkle root
                    System.exit(0); // exit program
                }
            }
            else if(MerkleManager.strikes == 3){
            	oUtil.print("3 Strikes: you lost!");
                System.exit(0); // exit program
            }

            oUtil.sleep(1); //sleep the utils object to allow for updates
        }
    }
}


