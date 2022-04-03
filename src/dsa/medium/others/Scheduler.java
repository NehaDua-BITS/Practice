package dsa.medium.others;

import java.util.ArrayList;
import java.util.Arrays;

public class Scheduler {

    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 0;
        Scheduler scheduler = new Scheduler();
        int result = scheduler.leastInterval(tasks, n);
        System.out.println("Least interval = " + result);
    }

    public int leastInterval(char[] tasks, int n) {
        ArrayList<String> schedule = new ArrayList<String>();
        int count = tasks.length;
        
        ArrayList<Task> freqList = calculateFrequency(tasks);        
        int currIndex = 0;
        int scheduleIndex = 0;
        
        while (count > 0) {
            int index = getNextTask(currIndex, scheduleIndex, freqList, n);
            if (index == -1) {
                schedule.add("idle");
            } else {
                schedule.add(freqList.get(index).name);
                currIndex = index+1;
                count--;
            };
            //System.out.println("schedule = " + Arrays.toString(schedule.toArray()));
            scheduleIndex++;
        }
        
        return schedule.size();
    }
    
    private int getNextTask(int startIndex, int scheduleIndex, ArrayList<Task> freqList, int n) {                   
        if (startIndex >= freqList.size()) {
                startIndex = 0;
        }
            
        int length = freqList.size();
        int i = startIndex;
        int count = 0;
        do {
            Task task = freqList.get(i);
            count++;
            if (task.count > 0 && 
                    (task.lastIndex == -1 || scheduleIndex - task.lastIndex > n)) {
                task.count--;
                task.lastIndex = scheduleIndex;
                //System.out.println("updated last index : " + task);
                return i;
            }

            if (i == length-1) {
                i = 0;
            } else {
                i++;
            }

        } while (count < freqList.size());
        
        return -1;  
    }
    
    private ArrayList<Task> calculateFrequency(char[] tasks) {
        
        ArrayList<Task> taskList = new ArrayList<Task>();
        
        int[] freq = new int[26];
        Arrays.fill(freq, 0);
        
        int length = tasks.length;
        for (int i = 0; i < length; i++) {
            freq[tasks[i]-'A']++;
        }
        
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                taskList.add(new Task(String.valueOf((char)('A'+i)), freq[i]));
            }
        }
        
        //System.out.println("Freq list = " + Arrays.toString(taskList.toArray()));
        return taskList;
    }
    
    class Task {
        String name;
        int count;
        int lastIndex;
        
        Task(String name, int count) {
            this.name = new String(name);
            this.count = count;
            this.lastIndex = -1;
        }
        
        public String toString() {
            return this.name + " " + this.count + " " + this.lastIndex;
        }
    }
}