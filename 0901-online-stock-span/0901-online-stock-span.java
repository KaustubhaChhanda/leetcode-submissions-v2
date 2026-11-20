class StockSpanner {
    int[] stock = new int[10000];
    int[] span = new int[10000];
    int stockTop = -1;
    int spanTop = -1;

    public StockSpanner() {

    }
    
    public int next(int price) {
        int curr = 1;

        while (stockTop != -1 && price >= stock[stockTop]) {
            stockTop--;
            curr += span[spanTop--];
        }

        stock[++stockTop] = price;
        span[++spanTop] = curr;

        return curr;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */