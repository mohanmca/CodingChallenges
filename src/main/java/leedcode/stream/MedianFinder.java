package leedcode.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {

    // One more items in smallerNumbers than biggerNumbers if there is odd number of items.
    private final PriorityQueue<Integer> smallerNumbers = new PriorityQueue<>((a, b) -> b - a);
    private final PriorityQueue<Integer> biggerNumbers = new PriorityQueue<>(Comparator.comparingInt(a -> a));

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf = new MedianFinder();
        Arrays.asList(1, 2).forEach(mf::addNum);
        System.out.println("Median = " + mf.findMedian());
        Arrays.asList(3).forEach(mf::addNum);
        System.out.println("Median = " + mf.findMedian());

        mf = new MedianFinder();
        Arrays.asList(-1, -2, -3).forEach(mf::addNum);
        System.out.println("Median = " + mf.findMedian());
        Arrays.asList(-4, -5).forEach(mf::addNum);
        System.out.println("Median = " + mf.findMedian());

        mf = new MedianFinder();
        Arrays.asList(0, 1, 2).forEach(mf::addNum);
        System.out.println("Median = " + mf.findMedian());
        Arrays.asList(4, 5).forEach(mf::addNum);
        System.out.println("Median = " + mf.findMedian());
    }

    public void addNum(int num) {
        if (size() == 0) {
            smallerNumbers.add(num);
        } else {
            if (!smallerNumbers.isEmpty() && num > smallerNumbers.peek()) {
                biggerNumbers.add(num);
            } else {
                smallerNumbers.add(num);
            }
        }
        if (biggerNumbers.size() > smallerNumbers.size()) {
            smallerNumbers.add(biggerNumbers.remove());
        } else if (biggerNumbers.size() < smallerNumbers.size() - 1) {
            biggerNumbers.add(smallerNumbers.remove());
        }
    }

    public int size() {
        return biggerNumbers.size() + smallerNumbers.size();
    }

    public double findMedian() {
        if (smallerNumbers.size() > biggerNumbers.size()) {
            return smallerNumbers.peek();
        }
        return (smallerNumbers.peek() + biggerNumbers.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */