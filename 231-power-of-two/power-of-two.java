class Solution {
    public boolean isPowerOfTwo(int n) {
      
        return n > 0 && (n & (n - 1)) == 0;  // Check if n is greater than 0 and has only one bit set
    
    }
}