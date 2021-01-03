package leedcode.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {

    private final PriorityQueue<Integer> minPq = new PriorityQueue<>((a, b) -> b - a);
    private final PriorityQueue<Integer> maxPq = new PriorityQueue<>(Comparator.comparingInt(a -> a));

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
    }

    public void addNum(int num) {
        if (num >= 0) {
            maxPq.add(num);
            if (maxPq.size() > minPq.size()) {
                minPq.add(maxPq.remove());
            }
        } else {
            minPq.add(num);
            if (minPq.size() > maxPq.size()) {
                maxPq.add(minPq.remove());
            }
        }
    }

    public double findMedian() {
        if (minPq.size() > maxPq.size()) {
            return minPq.peek();
        } else if (maxPq.size() > minPq.size()) {
            return maxPq.peek();
        }
        return (maxPq.peek() + minPq.peek()) / 2.0;
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
//        mf = new MedianFinder();
//        Arrays.asList(1,2).forEach(mf::addNum);
//        System.out.println("Median = " + mf.findMedian());
//        Arrays.asList(3).forEach(mf::addNum);
//        System.out.println("Median = " + mf.findMedian());

//        mf = new MedianFinder();
//        Arrays.asList(-1, -2, -3).forEach(mf::addNum);
//        System.out.println("Median = " + mf.findMedian());
//        Arrays.asList(-4, -5).forEach(mf::addNum);
//        System.out.println("Median = " + mf.findMedian());

        mf = new MedianFinder();
        Arrays.asList(0, 1, 2).forEach(mf::addNum);
        System.out.println("Median = " + mf.findMedian());
        Arrays.asList(4, 5).forEach(mf::addNum);
        System.out.println("Median = " + mf.findMedian());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */