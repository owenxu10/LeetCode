package old;

class Solution {
    public double myPow(double x, int n) {
        double sum = 1;

        if(n < 0){
            sum = myPow(1/x,-n-1) * (1/x);
        }

        if(n == 0){
            sum = 1;
        }

        if(n > 0){
            double half = myPow(x,n/2);
            sum = (n%2==0) ? half*half : half*half*x;
        }

        return sum;
    }
}
