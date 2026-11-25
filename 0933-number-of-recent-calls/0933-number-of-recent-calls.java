class RecentCounter {
    int[] q = new int[10000];
    int rear = -1;

    public RecentCounter() {
        
    }
    
    public int ping(int t) {
        q[++rear] = t;

        int temp = rear;
        int count = 0;

        while (temp >= 0 && q[temp] >= t - 3000) {
            count++;
            temp--;
        }

        return count;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */