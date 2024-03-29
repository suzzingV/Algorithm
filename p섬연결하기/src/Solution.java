import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] root = new int[n];
        Arrays.sort(costs, new Comparator<int[]> () { //cost 적은 순으로 정렬
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        for(int i = 0; i < root.length; i++) { //처음에 자신의 뿌리는 자신이다
            root[i] = i;
        }

        int count = 0;
        for(int i = 0; count < n - 1 || i < costs.length; i++) { //n - 1까지 중복 없이 연결 가능
            if(root[costs[i][0]] != root[costs[i][1]]) { //뿌리가 다르면 연결
                connectIsland(root, costs[i][0], costs[i][1]);
                answer += costs[i][2];
                count ++;
            }
        }
        return answer;
    }
    
    public void connectIsland(int[] root, int root1, int root2) {
        int change = Math.max(root[root1], root[root2]); //뿌리가 더 큰 요소의 뿌리
        int fix = Math.min(root[root1], root[root2]);
        for(int i = 0; i < root.length; i++) {
            if(root[i] == change) { //뿌리가 더 큰 요소의 뿌리를 작은 요소의 뿌리로 바꿔야함
                root[i] = fix;
            }
        }
    }
}