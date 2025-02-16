import java.util.HashMap;

class HashTable {
    static final int SIZE = 10;

    static class DataItem {
        int key;
    }

    static DataItem[] hashArray = new DataItem[SIZE];

    static HashMap<Integer, DataItem> hashMap = new HashMap<>();

    static public int createHasCode(int keyParam) {
        int result = keyParam % SIZE;
        System.out.println("Value " + keyParam + " " + SIZE);
        System.out.println("Result " + result);
        System.out.println("\n");

        return result;
    }

    static DataItem search(int keyParam) {
        int hashIndex = createHasCode(keyParam);

        while (hashMap.get(hashIndex) != null) {
            if (hashMap.get(hashIndex).key == keyParam)
                return hashMap.get(hashIndex);

            ++hashIndex;
            hashIndex %= SIZE;
        }
        return null;
    }

    static void insert(int keyParam) {
        DataItem newItem = new DataItem();
        newItem.key = keyParam;

        int hashIndex = createHasCode(keyParam);

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

    // private static int hashCode(int keyParam) {
    // // TODO Auto-generated method stub
    // throw new UnsupportedOperationException("Unimplemented method 'hashCode'");
    // }

    static void delete(int keyParam) {
        int hashIndex = createHasCode(keyParam);
        while (hashArray[hashIndex] != null) {
            if (hashArray[hashIndex].key == keyParam) {
                hashArray[hashIndex] = null;
                return;
            }
            hashIndex = (++hashIndex) % SIZE;
        }
        System.out.println("Item with key " + keyParam + "not found.");
    }

    public static void main(String[] args) {
        DataItem item2 = new DataItem();
        item2.key = 25;

        DataItem item3 = new DataItem();
        item3.key = 64;

        DataItem item4 = new DataItem();
        item4.key = 22;

        int hashIndex2 = createHasCode(item2.key);
        hashMap.put(hashIndex2, item2);

        int hashIndex3 = createHasCode(item3.key);
        hashMap.put(hashIndex3, item3);

        int hashIndex4 = createHasCode(item4.key);
        hashMap.put(hashIndex4, item4);

        int keyToSearch = 64;
        DataItem result = search(keyToSearch);
        System.out.println("Element to be searched: " + keyToSearch);
        if (result != null) {
            System.out.println("\nElement found");
        } else {
            System.out.println("\nElement NOT found");
        }

        System.out.println("\n\nINSERT");
        insert(42);
        insert(25);
        insert(64);
        insert(22);
        insert(43);

        delete(25);
        // delete(22);

        for (int i = 0; i < SIZE; i++) {
            if (hashArray[i] != null) {
                System.out.println("\nINSERT " + i + ": Key  " + hashArray[i].key);
            } else {
                System.out.println("\nINSERT " + i + ": Key  empty.");
            }
        }

    }
}