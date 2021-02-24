public class MonitorThread implements Runnable {

    @Override
    public void run() {
    	Util oUtil = new Util();
        while(true){
            if(MerkleManager.merkleRoot != null){
                if(MerkleManager.merkleRoot.equals(MerkleManager.userEnteredExpectedMerkleRoot)){
                	System.out.println("You Win: " +MerkleManager.merkleRoot);
                    System.exit(0);
                }
                else {
                	System.out.println("The roots don't match: You lose!\n");
                	System.out.println("Actual Root: " +MerkleManager.merkleRoot ); // DEBUG: test print to see what the actual merkle root value is
                	System.out.println("Your guessed root: " +MerkleManager.userEnteredExpectedMerkleRoot); //DEBUG: test print for users guess of merkle root
                    System.exit(0); // exit program
                }
            }
            else if(MerkleManager.strikes == 3){
            	System.out.println("3 Strikes: you lost!");
                System.exit(0); 
            }

            oUtil.sleep(1); 
            //sleep the utils object to allow for updates
        }
    }
}


