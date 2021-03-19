class StringSaS {

    private static String[] data = { "KM", "FU", "VR", "NG", "CF", "XD", "MO" };
    
    public static void main(String[] args) {
        sort();
        find("Xd");
    }

    private static int find(String searchValue) {
        int middleIdx = 0;
        int lowIdx = 0;
        int highIdx = data.length - 1;
        int i = 0;

        while(lowIdx <= highIdx) {
            middleIdx = (lowIdx + highIdx) / 2;
            System.out.println("Runde: " + i++ +  " green: " + middleIdx + " aktuelle Element: " + data[middleIdx] + " zu suchender Wert: " + searchValue);
            if (data[middleIdx].equals(searchValue)) {
                System.out.println("  found at: " + middleIdx);
                return middleIdx;
            } else if (data[middleIdx].compareTo(searchValue) < 1) {
                lowIdx = middleIdx + 1;
                System.out.println("  lowMarker to the right");
            } else {
                highIdx = middleIdx - 1;
                System.out.println("  highMarker to the left");
            }
        }
        System.out.println("Not found");
        return -1;
    }

    private static void sort() {
        for(int round = data.length - 1; round > 0; round--) {
            for(int currentIdx = 0; currentIdx < round; currentIdx++) {
                if (data[currentIdx].compareTo(data[currentIdx+1]) > 0) {
                    String tmp = data[currentIdx];
                    data[currentIdx] = data[currentIdx+1];
                    data[currentIdx+1] = tmp;
                }
            }
        }
        prettyPrint(data);


    }

    public static void prettyPrint(String[] data) {
        System.out.println();

        for (String i : data) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println();

    }
}