import java.util.HashMap;

class HashTableComplete {
    static final int SIZE = 10;

    static class DataItem {
        int key;
        int data;

        DataItem(int keyParam, int dataParam) {
            this.key = keyParam;
            this.data = dataParam;
        }
    }

    static DataItem dummyItem = new DataItem(-1, -1);

    static DataItem[] hashArray = new DataItem[SIZE];

    static HashMap<Integer, DataItem> hashMap = new HashMap<>();

    static public int createHashCode(int keyParam) {
        int result = keyParam % SIZE;

        return result;
    }

    static DataItem search(int keyParam) {
        int hashIndex = createHashCode(keyParam);

        while (hashArray[hashIndex] != null) {
            if (hashArray[hashIndex].key == keyParam)
                return hashArray[hashIndex];

            hashIndex = ++hashIndex % SIZE;
        }

        return null;
    }

    static void insert(int keyParam, int dataParam) {
        DataItem newItem = new DataItem(keyParam, dataParam);
        newItem.key = keyParam;

        int hashIndex = createHashCode(keyParam);

        // moving new index value until get null index.
        while (hashArray[hashIndex] != null) {
            System.out.println("\nhashArray[hashIndex] " + hashArray[hashIndex].key);
            hashIndex++;
            System.out.println("hashIndex++ " + hashIndex);

            hashIndex %= SIZE;
            System.out.println("hashIndex %= SIZE " + hashIndex);

        }
        hashArray[hashIndex] = newItem;
    }

    static DataItem delete(DataItem dataParam) {
        int targetKey = dataParam.key;
        int hashIndex = createHashCode(targetKey);

        while (hashArray[hashIndex] != null) {
            if (hashArray[hashIndex].key == targetKey) {
                DataItem temp = hashArray[hashIndex];
                // hashArray[hashIndex] = dummyItem; // it will give signed object.
                hashArray[hashIndex] = null; // it will give pure empty object/skipped.
                return temp;
            }
            hashIndex = (++hashIndex) % SIZE;
        }

        return null;
    }

    static void display() {
        for (int i = 0; i < SIZE; i++) {
            if (hashArray[i] != null)
                System.out.print(" (" + hashArray[i].key + "," + hashArray[i].data + ") ");
        }
    }

    public static void main(String[] args) {
        insert(1, 20);
        insert(2, 70);
        insert(42, 80);
        insert(4, 25);
        insert(12, 44);
        insert(14, 32);
        insert(17, 11);
        insert(13, 78);
        insert(37, 97);

        System.out.println("Insertion Done");
        System.out.println("\nCOntents of Hash Table:");
        display();

        int searchKey = 37;
        System.out.println("\nThe element to be searched: " + searchKey);
        DataItem item = search(searchKey);

        if (item != null) {
            System.out.println("\nElement found: " + searchKey);
        } else {
            System.out.println("\nElement NOT found.");
        }

        DataItem item2 = search(17);
        delete(item);
        delete(item2);
        insert(17, 11);

        System.out.println("\nHash Table contents after deletion: ");

        display();
    }
}