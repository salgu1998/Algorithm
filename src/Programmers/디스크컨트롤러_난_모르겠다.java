package Programmers;

import java.util.*;

public class 디스크컨트롤러_난_모르겠다 {
    public static void main(String[] args) throws Exception {
        System.out.println(solution(new int[][]{{0, 3}, {1, 9}, {2, 6}}));
    }

    private static int solution(int[][] jobs) {

        Arrays.sort(jobs, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o1[0] <= o2[0]){
                    return -1;
                }
                return 1;
            }
        });

        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o1[1] < o2[1]){
                    return -1;
                }
                return 1;
            }
        });

        int time = 0;
        int index = 0;
        float answer = 0;

        while(true){
            while(index < jobs.length && jobs[index][0] <= time){
                queue.offer(jobs[index]);
                index ++;
            }
            if(queue.size() == 0){
                time = jobs[index][0];
                continue;
            }
            int[] job = queue.poll();
            time += job[1];
            answer += time - job[0];
            if(index == jobs.length && queue.size() == 0){
                break;
            }
        }

        answer /= jobs.length;
        return (int)answer;
    }
}
