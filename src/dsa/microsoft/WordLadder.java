package dsa.microsoft;

import java.util.*;

/**
 * To convert start word to target word using dictinary of words
 * in minimum number of steps
 * Change only 1 character at a time
 */
public class WordLadder {

    public static void main(String[] args) {
        String start = "TOON", target = "PLEA";
        List<String> dicList = new ArrayList<>(Arrays.asList("POON", "PLEE", "SAME", "POIE", "PLEA", "PLIE", "POIN"));
        Set<String> dictionary = new HashSet<>(dicList);
        System.out.println("Min Steps = " + new WordLadder().minNumberOfSteps(start, target, dictionary));
    }

    /**
     * Use BFS
     * Each level will have all possible words after a single transformation
     * Return level number when target found
     * @param src
     * @param dictionary
     * @return
     */
    private int minNumberOfSteps(String src, String target, Set<String> dictionary) {
        if (src.equals(target)) {
            return 0;
        }

        if (!dictionary.contains(target)) {
            return -1;
        }

        int length = src.length();
        Queue<String> queue = new LinkedList<>();
        queue.add(src);

        int level = 0;
        while (!queue.isEmpty()) {
            int numOfWordsInLevel = queue.size();
            ++level;
            for (int i = 0; i < numOfWordsInLevel; i++) {
                char[] currentWordArr = queue.remove().toCharArray();
                for (int currIndex = 0; currIndex < length; currIndex++) { //replace each index with new character and check
                    char origChar = currentWordArr[currIndex];
                    for (char ch = 'A'; ch <= 'Z'; ch++) {
                        currentWordArr[currIndex] = ch;
                        String modifiedStr = String.valueOf(currentWordArr);
                        if (!dictionary.contains(modifiedStr)) {
                            continue;
                        }
                        if (target.equals(modifiedStr)) { //if target reached
                            return level+1;
                        }
                        dictionary.remove(modifiedStr); //remove from dictionary if present
                        queue.add(modifiedStr); //push the transformation to queue
                    }
                    currentWordArr[currIndex] = origChar;
                }
            }
        }
        return -1;
    }
}
