package leedcode.map;

import code.challenge.AlgorithmUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class MyHashMap {

    private final int MAX_VALUE = 1000000;
    private final int CONTAINERS = 100 * 10;

    List<int[]>[] holder = new ArrayList[MAX_VALUE / CONTAINERS];


    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        System.out.println(map.get(5)); ;
        map.remove(5);
//        map.put(1, 2);
//        map.put(2, 3);
//        AlgorithmUtils.printInvokeReturn(map::get, 1);
//        map.remove(1);
//        AlgorithmUtils.printInvokeReturn(map::get, 2);
//        AlgorithmUtils.printInvokeReturn(map::get, 5);
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        if (holder[key / CONTAINERS] == null) {
            holder[key / CONTAINERS] = new ArrayList<>();
        }
        Optional<int[]> pair = holder[key / CONTAINERS].stream().filter(p -> p[0] == key).findFirst();
        if (pair.isEmpty())
            holder[key / CONTAINERS].add(new int[]{key, value});
        else
            pair.get()[1] = value;
    }

    private Optional<int[]> getPair(int key) {
        if (holder[key / CONTAINERS] != null) {
            return holder[key / CONTAINERS].stream().filter(pair -> pair[0] == key).findFirst();
        }
        return Optional.empty();
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        return getPair(key).orElseGet(() -> new int[]{-1, -1})[1];
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        if (holder[key / CONTAINERS] != null) {
            holder[key / CONTAINERS].removeIf(kv -> kv[0] == key);
        }
    }
}
