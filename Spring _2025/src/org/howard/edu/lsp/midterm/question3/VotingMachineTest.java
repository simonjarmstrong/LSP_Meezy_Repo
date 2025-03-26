package org.howard.edu.lsp.midterm.question3;

public class VotingMachineTest {
    public static void main(String[] args) {
        // Create a VotingMachine instance
        VotingMachine votingSystem = new VotingMachine();

        // Add candidates
        votingSystem.addCandidate("Alice");
        votingSystem.addCandidate("Bob");
        votingSystem.addCandidate("Charlie");

        // Cast votes
        votingSystem.castVote("Alice");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Charlie");
        votingSystem.castVote("Charlie");
        votingSystem.castVote("Charlie");

        // Attempt to vote for a non-existent candidate
        boolean wasSuccessful = votingSystem.castVote("Eve");
        System.out.println("Vote for Eve successful? " + wasSuccessful);

        // Display the winner
        System.out.println("Winner: " + votingSystem.getWinner());
        // Expected: "Charlie WINS with 3 votes!!"
    }
}
