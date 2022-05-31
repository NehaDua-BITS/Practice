package dsa.medium.array;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//Leetcode Link : https://leetcode.com/problems/rank-teams-by-votes/submissions/

public class RankTeamsByVotes {

    public static void main(String[] args) {
        RankTeamsByVotes obj = new RankTeamsByVotes();
        String[] votes = {"ABC","ACB","ABC","ACB","ACB"};
        String ranking = obj.rankTeams(votes);
        System.out.println("The ranking is : " + ranking);
    }

    public String rankTeams(String[] votes) {
        int numOfTeams = votes[0].length(); //same as number of ranks
        Map<Character, Map<Integer, Integer>> userRankCoutMap = new HashMap<>(numOfTeams);
        int numOfVoters = votes.length;

        //iterate over all votes from all users and count
        for (int i = 0; i < numOfVoters; i++) {
            char[] teamsArr = votes[i].toCharArray();
            for (int j = 0; j < numOfTeams; j++) {
                Map<Integer, Integer> rankCountMap = userRankCoutMap.getOrDefault(teamsArr[j], new HashMap<>());
                int count = rankCountMap.getOrDefault(j, 0);
                rankCountMap.put(j, count+1);
                userRankCoutMap.putIfAbsent(teamsArr[j], rankCountMap);
            }
        }

        //print map if needed
        printUserRankCountMap(userRankCoutMap);

        //implement priority queue for ranking
        PriorityQueue<Character> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            for (int rank = 0; rank < numOfTeams; rank++) {
                int count1 = userRankCoutMap.get(o1).getOrDefault(rank, 0); //get count of position
                int count2 = userRankCoutMap.get(o2).getOrDefault(rank, 0);
                int diff = Integer.compare(count2, count1); //to get descending order
                if (diff != 0) {
                    return diff;
                }
            }
            return Character.compare(o1, o2); //sort alphabetically if conflict not resolved
        });

        priorityQueue.addAll(userRankCoutMap.keySet());

        //iterate over queue and get ranking
        StringBuilder resultSb = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            resultSb.append(priorityQueue.poll());
        }

        return resultSb.toString();
    }

    private void printUserRankCountMap(Map<Character, Map<Integer, Integer>> userRankCoutMap) {
        for (Map.Entry<Character, Map<Integer, Integer>> entry : userRankCoutMap.entrySet()) {
            System.out.println("Team " + entry.getKey() + " : Ranks Count => ");
            for (Map.Entry<Integer, Integer> rankEntry : entry.getValue().entrySet()) {
                System.out.println(rankEntry.getKey() + " : " + rankEntry.getValue());
            }
        }
    }

}