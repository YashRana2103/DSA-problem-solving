//https://leetcode.com/problems/gas-station/?envType=study-plan-v2&envId=top-interview-150

package leetcode_150;

public class _14_Medium_150_gas_station {
    public static int myBruteForce(int[] gas, int[] cost){
        int n = gas.length;;
        int startPos = 0;
        while(startPos < n){
            int tank = 0;
            int currPos = startPos;
            int cnt = 0;
            while(cnt < n){
                tank = tank + gas[currPos];
                if(tank < cost[currPos]){
                    startPos++;
                    break;
                }
                tank = tank - cost[currPos];
                currPos = (currPos + 1) % n;
                cnt++;
                if(cnt == n) return startPos;
            }
        }
        return -1;

        // works but take too much time in worst case
        // TC: O(n^2)
        // SC: O(1)
    }

    public static int chatGPT_Greedy(int[] gas, int[] cost) {
        int totalTank = 0;
        int currTank = 0;
        int startStation = 0;

        for (int i = 0; i < gas.length; i++) {
            int fuelGain = gas[i] - cost[i];
            totalTank += fuelGain;
            currTank += fuelGain;

            if (currTank < 0) {
                startStation = i + 1;
                currTank = 0;
            }
        }

        return totalTank >= 0 ? startStation : -1;

        // TC: O(n)
        // SC: O(1)
    }


    public static void main(String[] args) {
        int[] gas = {5, 1, 2};
        int[] cost = {3, 4, 5};

//        int[] gas = {3, 4, 5};
//        int[] cost = {5, 1, 2};

//        int[] gas = {3, 4, 5, 1, 2};
//        int[] cost = {1, 2, 3, 4, 5};

//        int[] gas = {2, 3, 4};
//        int[] cost = {3, 4, 3};

//        int[] gas = {2, 4, 4};
//        int[] cost = {3, 4, 3};

//        int[] gas = {2, 3, 5};
//        int[] cost = {3, 4, 3};

        System.out.println(myBruteForce(gas, cost));
        System.out.println(chatGPT_Greedy(gas, cost));
    }
}
