package dsa.atlassian.votingsystem.service.impl;

import dsa.atlassian.votingsystem.exceptions.InvalidInputException;
import dsa.atlassian.votingsystem.service.VotingService;

import java.util.*;

public class VotingServiceImpl implements VotingService {

    private int numOfTeams;

    private Map<Character, Map<Integer, Integer>> teamRankCountMap;

    public VotingServiceImpl(int numOfTeams) {
        this.numOfTeams = numOfTeams;
        this.teamRankCountMap = new HashMap<>();
    }

    @Override
    public void addVote(String teamsVoteSequence) {
        if (teamsVoteSequence.length() != numOfTeams) {
            throw new InvalidInputException("Rank should be given for all teams");
        }
        for (int i = 0; i < numOfTeams; i++) {
            Map<Integer, Integer> rankCountMap = teamRankCountMap.putIfAbsent(teamsVoteSequence.charAt(i), new HashMap<>());
            rankCountMap.compute(i+1, (k, v) -> {
                v = (v == null) ? 1 : v+1;
                return v;
            });
        }
    }

    @Override
    public int addVote(Character team, int rank) {
        Map<Integer, Integer> rankCountMap = teamRankCountMap.putIfAbsent(team, new HashMap<>());
        int totalVotes = rankCountMap.compute(rank, (k, v) -> {
            v = (v == null) ? 1 : v+1;
            return v;
        });

        return totalVotes;
    }

    @Override
    public List<Character> getTopK(int k) {
        List<Character> resultList = new ArrayList<>(k);
        PriorityQueue<Character> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            for (int i = 0; i < numOfTeams; i++) {
                int count1 = teamRankCountMap.get(o1).getOrDefault(i+1, 0);
                int count2 = teamRankCountMap.get(o2).getOrDefault(i+1, 0);
                int diff = Integer.compare(count2, count1);
                if (diff != 0) {
                    return diff;
                }
            }
            return Character.compare(o1, o2);
        });
        priorityQueue.addAll(teamRankCountMap.keySet());

        for (int i = 0; i < k && !priorityQueue.isEmpty(); i++) {
            resultList.add(priorityQueue.poll());
        }
        return resultList;
    }

    @Override
    public void printMap() {

    }
}
