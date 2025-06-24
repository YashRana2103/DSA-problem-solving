//https://leetcode.com/problems/insert-delete-getrandom-o1/description/?envType=study-plan-v2&envId=top-interview-150

package leetcode_150;

import java.util.*;

public class _12_Medium_150_insert_delete_getRandom {

    HashMap<Integer, Integer> map;
    List<Integer> list;;
    Random random;

    public _12_Medium_150_insert_delete_getRandom(){
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }

        int index = map.get(val);
        int lastEleInList = list.getLast();

        list.set(index, lastEleInList);
        map.put(lastEleInList, index);

        list.removeLast();
        map.remove(val);

        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

    /**
     * Your RandomizedSet object will be instantiated and called as such:
     * RandomizedSet obj = new RandomizedSet();
     * boolean param_1 = obj.insert(val);
     * boolean param_2 = obj.remove(val);
     * int param_3 = obj.getRandom();
     */
    public static void main(String[] args) {
        _12_Medium_150_insert_delete_getRandom set = new _12_Medium_150_insert_delete_getRandom();
        System.out.println(set.insert(1));         // true
        System.out.println(set.remove(2));         // false (2 not present)
        System.out.println(set.insert(2));         // true
        System.out.println(set.getRandom());       // 1 or 2 (random)
        System.out.println(set.remove(1));         // true
        System.out.println(set.insert(2));         // false (already present)
        System.out.println(set.getRandom());       // 2 (only one left)
        System.out.println(set.insert(10));        // true
        System.out.println(set.insert(10));        // false
        System.out.println(set.remove(10));        // true
        System.out.println(set.remove(10));        // false
        System.out.println(set.insert(5));         // true
        System.out.println(set.insert(6));         // true
        System.out.println(set.insert(7));         // true
        // Call getRandom() multiple times, should return 5, 6, or 7 with equal chance
        System.out.println(set.getRandom());       // 5, 6, or 7 (random)

    }
}
