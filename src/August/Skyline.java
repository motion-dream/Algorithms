package August;

import java.util.*;

/**
 * @author jmm
 * @version 1.0
 * @date 2021/8/18 10:47
 * @email 2867405686@qq.com
 */
/*
    A rectangle can be determined by the two adjacent abscissa and the maximum height.
        We are asked to print the left end of the "top" of each rectangle, while skipping the edges that extend from the "top" of the previous rectangle.
        Therefore, we need to maintain a maximum height in real time, using priority queues (heaps).
        When we implement this, we can first record all the left and right end abscissa and height of buildings, and order them from smallest to largest according to the end abscissa.
        In the process of traversing from front to back (traversing each rectangle), we discuss the cases according to the points currently traversed:
        Left endpoint: Since it is a left endpoint, there must be an edge extending from the right, but it is not necessarily the edge that needs to be recorded, because in the same rectangle, we only need to record the top edge.At this time can be the height of the team;
        Right end point: This means that a previous line to the right has ended, and the height should be dequeued (meaning that the ending line is not considered).
        We then extract the current maximum height from the priority queue. In order to prevent the current line from overlapping with the line "on top" of the previous rectangle, we need to record the height of the previous record using a variable prev
 */
public class Skyline {
    static class Solution {
        public List<List<Integer>> getSkyline(int[][] buildings) {
            List<List<Integer>> ans = new ArrayList<>();
            List<int[]> ps = new ArrayList<>();
            for (int[] b : buildings) {
                int l = b[0], r = b[1], h = b[2];
                ps.add(new int[]{l, -h});
                ps.add(new int[]{r, h});
            }
            Collections.sort(ps, (a, b)->{
                if (a[0] != b[0]) return a[0] - b[0];
                return a[1] - b[1];
            });
            PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->b-a);
            int prev = 0;
            q.add(prev);
            for (int[] p : ps) {
                int point = p[0], height = p[1];
                if (height < 0) {
                    q.add(-height);
                } else {
                    q.remove(height);
                }
                int cur = q.peek();
                if (cur != prev) {
                    List<Integer> list = new ArrayList<>();
                    list.add(point);
                    list.add(cur);
                    ans.add(list);
                    prev = cur;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[][] buildings={{5,6,8},{7,11,9},{2,13,4}};
        List<List<Integer>> pq= new Solution().getSkyline(buildings);
        System.out.println(pq);
    }
}
