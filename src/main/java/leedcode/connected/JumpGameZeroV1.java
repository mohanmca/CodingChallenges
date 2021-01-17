package leedcode.connected;


/**
 * https://leetcode.com/problems/jump-game-iii/
 */
public class JumpGameZeroV1 {

    public static void main(String[] args) {
        System.out.println(new JumpGameZeroV1().canReach(new int[]{387,205,355,101,210,587,690,443,605,198,504,106,681,399,303,516,511,17,333,626,411,288,18,160,205,335,830,576,801,138,347,439,218,272,690,98,388,560,352,703,547,496,786,545,240,66,742,41,86,136,173,170,551,218,274,777,340,614,518,261,376,346,348,116,298,240,618,798,732,500,138,593,564,788,106,328,40,416,74,389,807,150,128,349,117,629,601,800,387,78,584,563,229,579,83,273,373,302,577,547,117,468,283,110,805,46,847,302,12,628,686,14,93,423,117,845,808,40,192,245,804,600,431,165,118,461,171,697,247,162,761,105,445,387,825,555,837,301,563,259,728,488,322,102,212,667,325,40,27,10,805,302,743,610,327,460,400,320,408,64,65,324,615,466,114,256,220,803,632,796,555,704,480,677,364,265,187,554,212,314,203,252,369,83,839,287,91,771,458,92,667,588,658,347,232,399,314,42,335,191,324,811,592,310,251,342,103,557,626,592,826,610,94,250,225,20,827,249,411,74,274,564,72,746,76,22,650,10,297,768,811,367,505,480,157,103,513,796,814,335,78,521,681,177,183,794,153,144,841,327,312,109,726,526,616,300,129,211,145,558,739,32,798,323,840,638,823,688,566,764,706,210,182,306,443,550,161,49,731,683,253,258,796,65,698,457,827,440,562,256,554,449,550,464,11,405,346,175,264,497,24,812,661,426,584,19,63,708,363,593,141,607,128,141,265,283,407,577,410,176,627,91,239,497,7,181,541,324,512,664,448,702,654,748,231,244,320,506,703,490,230,729,422,345,573,625,745,669,281,661,224,49,73,781,523,660,377,163,523,784,811,208,319,305,709,306,565,380,169,718,718,754,475,608,87,126,620,526,584,386,180,159,256,436,222,583,736,775,801,53,506,697,403,734,652,356,393,527,168,557,747,41,536,92,827,261,643,103,273,754,85,142,794,631,675,703,717,83,455,246,391,821,443,406,168,333,448,129,637,499,217,122,441,615,546,418,120,676,302,284,254,387,767,572,4,194,541,449,592,21,31,642,620,248,266,211,177,291,151,555,205,279,318,599,775,256,699,457,810,828,172,558,365,502,430,124,787,213,584,392,209,290,830,110,826,24,120,582,765,13,558,303,690,779,741,664,139,76,512,382,586,824,318,447,515,693,365,776,541,331,0,126,452,735,460,358,312,552,408,347,801,748,699,585,504,115,663,386,391,208,570,3,284,650,612,739,756,745,523,203,472,615,529,418,762,729,312,719,174,460,634,684,543,202,368,538,3,694,398,593,436,414,344,636,598,751,716,766,69,504,763,253,655,664,297,644,21,416,738,644,159,648,797,406,801,276,182,785,75,834,794,619,10,357,270,817,725,421,701,557,310,155,473,265,496,173,478,522,46,277,522,100,762,604,432,71,363,68,672,453,20,168,519,727,165,707,95,411,651,705,282,619,311,213,540,212,242,341,275,70,76,715,535,674,377,479,523,571,754,50,172,304,668,752,730,834,569,276,364,624,757,237,401,574,409,176,495,808,265,625,337,733,227,264,624,723,250,676,31,637,412,324,442,779,254,804,275,194,74,640,749,169,593,454,595,745,151,620,268,470,539,166,141,797,141,732,451,369,317,769,410,246,118,735,211,735,697,312,69,108,233,406,329,504,102,191,46,56,828,611,23,770,221,699,35,506,720,541,834,741,627,452,350,678,281,120,627,709,176,97,227,409,238,506,460,386,768,172,237,241,839,290,473,560,593,398,216,462,732,264,338,508,607,113,218,80,47,15,816,5,491,327,392,594,294,200,409,163,844,776,661,155,812,31,15,396,148,680,555,58,578,388,260,133,81,473,667,310,14,36,549,62,537,132,43,280,799,120,442,93,194,28,511,652,133,762,285,703,836,196,678,458,399,337,646,274,266,657,650,248,251,61,602,806,604,179,358,438}, 619));
//        System.out.println(new JumpGameZero().canReach(new int[]{1, 2, 3, 0, 5, 6, 4}, 6));
//        System.out.println(new JumpGameZero().canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 5));
//        System.out.println(new JumpGameZero().canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 0));
//        System.out.println(new JumpGameZero().canReach(new int[]{3, 0, 2, 1, 2}, 2));
//        System.out.println(new JumpGameZero().canReach(new int[]{0, 3, 0, 6, 3, 3, 4}, 6));
//        System.out.println(new JumpGameZero().canReach(new int[]{0, 1}, 1));
//        System.out.println(new JumpGameZero().canReach(new int[]{0, 0}, 0));
//        System.out.println(new JumpGameZero().canReach(new int[]{0}, 0));
    }

    public boolean canReach(int[] arr, int start) {
        QuickFindUF quf = new QuickFindUF(arr.length);
        for (int i = 0; i < arr.length; i++) {
            if (i - arr[i] >= 0 && i - arr[i] < arr.length) {
                quf.union(i, i - arr[i]);
            }
            if (i + arr[i] >= 0 && i + arr[i] < arr.length) {
                quf.union(i, i + arr[i]);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                if (quf.find(start) == quf.find(i)) {
                    return true;
                }
            }
        }
        return false;
    }
}

class QuickFindUF {
    private final int[] id;    // id[i] = component identifier of i
    private int count;   // number of components

    /**
     * Initializes an empty union-find data structure with
     * {@code n} elements {@code 0} through {@code n-1}.
     * Initially, each elements is in its own set.
     *
     * @param n the number of elements
     * @throws IllegalArgumentException if {@code n < 0}
     */
    public QuickFindUF(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++)
            id[i] = i;
    }

    /**
     * Returns the number of sets.
     *
     * @return the number of sets (between {@code 1} and {@code n})
     */
    public int count() {
        return count;
    }

    /**
     * Returns the canonical element of the set containing element {@code p}.
     *
     * @param p an element
     * @return the canonical element of the set containing {@code p}
     * @throws IllegalArgumentException unless {@code 0 <= p < n}
     */
    public int find(int p) {
        validate(p);
        return id[p];
    }

    // validate that p is a valid index
    private void validate(int p) {
        int n = id.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
        }
    }

    /**
     * Returns true if the two elements are in the same set.
     *
     * @param p one element
     * @param q the other element
     * @return {@code true} if {@code p} and {@code q} are in the same set;
     * {@code false} otherwise
     * @throws IllegalArgumentException unless
     *                                  both {@code 0 <= p < n} and {@code 0 <= q < n}
     * @deprecated Replace with two calls to {@link #find(int)}.
     */
    @Deprecated
    public boolean connected(int p, int q) {
        validate(p);
        validate(q);
        return id[p] == id[q];
    }

    /**
     * Merges the set containing element {@code p} with the
     * the set containing element {@code q}.
     *
     * @param p one element
     * @param q the other element
     * @throws IllegalArgumentException unless
     *                                  both {@code 0 <= p < n} and {@code 0 <= q < n}
     */
    public void union(int p, int q) {
        validate(p);
        validate(q);
        int pID = id[p];   // needed for correctness
        int qID = id[q];   // to reduce the number of array accesses

        // p and q are already in the same component
        if (pID == qID) return;

        for (int i = 0; i < id.length; i++)
            if (id[i] == pID) id[i] = qID;
        count--;
    }

}