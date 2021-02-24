import java.util.ArrayList;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;

import javax.swing.JOptionPane;

public class Util {
	
	public String getMerkleRoot(ArrayList<String> firstItems) {
		
		// *** Hard coded number of items to 4 ***
		MerkleNode oNode1 = new MerkleNode();
		MerkleNode oNode2 = new MerkleNode();
		MerkleNode oNode3 = new MerkleNode();
		MerkleNode oNode4 = new MerkleNode();
		MerkleNode oNode5 = new MerkleNode();
		MerkleNode oNode6 = new MerkleNode();
		MerkleNode oNode7 = new MerkleNode();
		
		oNode1.sHash = generateHash(firstItems.get(0)); 
		oNode2.sHash = generateHash(firstItems.get(1));
		oNode3.sHash = generateHash(firstItems.get(2));
		oNode4.sHash = generateHash(firstItems.get(3));
		
		populateMerkleNode(oNode5, oNode1, oNode2);
		//combined oNode1 and oNode2 to make oNode5
		populateMerkleNode(oNode6, oNode3, oNode4);
		populateMerkleNode(oNode7, oNode5, oNode6);
		//N7 node comes from H(N5 + N6)
		
		return oNode7.sHash;
	}
	
	private void populateMerkleNode(MerkleNode oNode, MerkleNode oLeftNode, 
									MerkleNode oRightNode) {
		oNode.oLeft = oLeftNode;
		oNode.oRight = oRightNode;
		oNode.sHash = generateHash(oNode.oLeft.sHash + oNode.oRight.sHash);
		//sOrigninal: combine oNode left and oNode right to make a string
	}
	
	public synchronized String generateHash(String sOriginal){

		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] btEncodedhash = digest.digest(
			sOriginal.getBytes(StandardCharsets.UTF_8));

			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < btEncodedhash.length; i++) {
				sb.append(Integer.toString((btEncodedhash[i] & 0xff) + 0x100, 16).substring(1));
			}
			return sb.toString();
		}
		catch(Exception ex){

				System.out.println("Error generating hash: " + ex.getMessage());
			    return null;
		}
	}
	/*This will pass in the string which will be the questions you want to display to user*/
    public String promptUser(String sQuestion){
        String sAnswer = JOptionPane.showInputDialog(sQuestion);
        return sAnswer;
    }

	public void sleepRandomTime(String sThreadName){

		// Gets random number between 0 and 5 and then adds 3, meaning between 3 and 8 now.
	    int iSleepTime = new SecureRandom().nextInt(5) + 3;
	    
	    System.out.println(sThreadName + " sleeping for " + iSleepTime + " seconds.");
	    sleep(iSleepTime);
	    
	}
    
	public void sleep(int iSeconds) {
		try {
			Thread.sleep(iSeconds * 1000);
			//millis:
		}
		catch(Exception ex) {
			
		}
	}
	
}
