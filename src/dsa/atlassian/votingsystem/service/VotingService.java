package dsa.atlassian.votingsystem.service;

import java.util.List;

public interface VotingService {

    void addVote(String teamsVoteSequence);

    int addVote(Character team, int rank);

    List<Character> getTopK(int k);

    void printMap();
}
