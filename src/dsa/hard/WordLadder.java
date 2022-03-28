package dsa.hard;

import java.util.*;

public class WordLadder {

    private static int minCount = Integer.MAX_VALUE;

    public static void main(String[] args) {
        WordLadder obj = new WordLadder();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
//        String beginWord = "hit";
//        String endWord = "cog";
//        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log"));
        int result = obj.ladderLength(beginWord, endWord, wordList);
        System.out.println("Minimum number of sequences = " + result);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new LinkedHashSet<>();
        Set<String> dicSet = new HashSet<>(wordList);
        visited.add(beginWord);
        ladderLength(new StringBuilder(beginWord), endWord, dicSet, visited, 1);
        return minCount == Integer.MAX_VALUE ? 0 : minCount;
    }

    private void ladderLength(StringBuilder beginWord, String endWord, Set<String> dicSet, Set<String> visited, int count) {

        if (beginWord.toString().equals(endWord)) {
            minCount = Math.min(minCount, count);
            System.out.println("Sequence : " + Arrays.toString(visited.toArray()));
            return;
        }

        for (int j = 0; j < beginWord.length(); j++) {
            for (int i = 0; i < 26; i++) { //26 alphabets
                StringBuilder temp = new StringBuilder(beginWord);
                temp.setCharAt(j, (char)('a'+i));
                if (dicSet.contains(temp.toString()) && !visited.contains(temp.toString())) {
                    visited.add(temp.toString());
                    if (visited.size() < minCount) {
                        ladderLength(temp, endWord, dicSet, visited, count + 1);
                    }
                    visited.remove(temp.toString());
                }
            }
        }
    }
}
