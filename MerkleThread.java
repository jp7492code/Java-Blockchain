import java.util.ArrayList;

public class MerkleThread implements Runnable{

    public static volatile ArrayList<String> grabbedWords;
    private int iMerkleTreeInputs = 4; //how many words to wait for before tree gets created

    @Override
    public void run() {
        Util oUtil = new Util();
        MerkleManager merkleManager = new MerkleManager();
        grabbedWords = new ArrayList<>();
        while(true){

        	oUtil.sleepRandomTime("Merkle Thread"); // let user know sleep status of thread
            String sNewWord = merkleManager.grabWord();

            // validate user input
            if(sNewWord != null){
            	oUtil.print("[Merkle] grabbed word");
                grabbedWords.add(sNewWord); // add grabbed word to list
                if(grabbedWords.size() == iMerkleTreeInputs){
                    // set the sMerkleRoot to the generated merkle root value by getMerkleNode
                    MerkleManager.merkleRoot = oUtil.getMerkleRoot(grabbedWords);
                }
            }
        }
    }
}