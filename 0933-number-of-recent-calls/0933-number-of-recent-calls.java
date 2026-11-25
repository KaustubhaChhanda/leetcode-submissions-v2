class RecentCounter {
    int[] q = new int[10000];
    int front = 0;
    int rear = -1;

    public RecentCounter() {
        
    }
    
    public int ping(int t) {
        q[++rear] = t;

        while (front <= rear && q[front] < t - 3000) {
            front++;
        }

        return rear - front + 1;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */