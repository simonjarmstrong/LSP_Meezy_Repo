import java.util.HashMap;
import java.util.Map;

public class VotingMachine {
    // Renamed from "candidateVotes" to "electionTally"
    private Map<String, Integer> electionTally;

    // Constructor
    public VotingMachine() {
        // Initialize the HashMap
        this.electionTally = new HashMap<>();
    }

    /**
     * Adds a new contender (was "candidate" before).
     * If the contender already exists, does nothing.
     */
    public void addContender(String contenderName) {
        if (!electionTally.containsKey(contenderName)) {
            electionTally.put(contenderName, 0);
        }
    }

    /**
     * Casts a vote (now called "castBallot") for a given contender.
     * Returns true if the vote was successful, false if the contender doesn't exist.
     */
    public boolean castBallot(String contenderName) {
        if (electionTally.containsKey(contenderName)) {
            electionTally.put(contenderName, electionTally.get(contenderName) + 1);
            return true;
        }
        return false;
    }

    /**
     * Determines the contender with the most votes (was "getWinner" before).
     * If there are no contenders, returns a message indicating that.
     */
    public String determineLeader() {
        if (electionTally.isEmpty()) {
            return "No contenders available!";
        }

        String leader = null;
        int highestCount = -1;

        // Find the contender with the highest vote total
        for (Map.Entry<String, Integer> entry : electionTally.entrySet()) {
            if (entry.getValue() > highestCount) {
                highestCount = entry.getValue();
                leader = entry.getKey();
            }
        }

        return leader + " WINS with " + highestCount + " votes!!";
    }
}
