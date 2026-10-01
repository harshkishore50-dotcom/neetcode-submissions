class Solution {

    public static List<List<Pair>> insertionSort(List<Pair> pairs) {
        List<List<Pair>> states = new ArrayList<>();

        // Edge case: empty list
        if (pairs == null || pairs.isEmpty()) return states;

        // Work on a copy to avoid mutating the original
        List<Pair> arr = new ArrayList<>(pairs);

        for (int i = 0; i < arr.size(); i++) {
            // Take the current element and shift left while key is smaller
            int j = i;
            while (j > 0 && arr.get(j).key < arr.get(j - 1).key) {
                // Swap adjacent elements
                Pair temp = arr.get(j);
                arr.set(j, arr.get(j - 1));
                arr.set(j - 1, temp);
                j--;
            }
            // Snapshot: deep copy current state after this insertion
            states.add(new ArrayList<>(arr));
        }

        return states;
    }

    // Removed the inner Pair class definition to use the one provided in the environment

    // ----------------------------------------------------------------
    // Main — test both examples
    // ----------------------------------------------------------------
    public static void main(String[] args) {
        // Example 1
        // Using a temporary list to work around the static/inner context for the external Pair class
        Main mainInstance = new Main();
        List<Pair> pairs1 = new ArrayList<>();
        pairs1.add(mainInstance.new Pair(5, "apple"));
        pairs1.add(mainInstance.new Pair(2, "banana"));
        pairs1.add(mainInstance.new Pair(9, "cherry"));

        System.out.println("Example 1:");
        for (List<Pair> state : insertionSort(pairs1)) {
            System.out.println(state);
        }

        // Example 2
        List<Pair> pairs2 = new ArrayList<>();
        pairs2.add(mainInstance.new Pair(3, "cat"));
        pairs2.add(mainInstance.new Pair(3, "bird"));
        pairs2.add(mainInstance.new Pair(2, "dog"));

        System.out.println("\nExample 2:");
        for (List<Pair> state : insertionSort(pairs2)) {
            System.out.println(state);
        }
    }
}