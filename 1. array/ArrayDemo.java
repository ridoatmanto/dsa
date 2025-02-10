class ArrayDemo {
    public static void main(String[] args) {
        int intArray[];
        intArray = new int[8];

        System.out.println("Init Array: ");
        display(intArray);

        for (int i = intArray.length - 1; i >= 0; i--) {
            intArray[i] = i + 7;
            System.out.println("Add " + i + " to Array.");
        }

        System.out.println("After adding data.");
        display(intArray);

        System.out.println("change value directly");
        int index = 5;
        intArray[index] = 22;
        System.out.println("Data at index " + index + " updated to " + intArray[index]);
        display(intArray);

        int value = 10;
        index = findIndexByValue(value, intArray);
        if (index >= 0) {
            System.out.println("Value " + value + " has index " + index);
        }
    }

    public static void display(int[] arrayParam) {
        String result = "Array : [";
        for (int i = 0; i < arrayParam.length; i++) {
            result += " " + arrayParam[i];
            if (i != arrayParam.length - 1) {
                result += ",";
            }
        }
        result += " ];";

        System.out.print(result + "\n");
    }

    public static int findIndexByValue(int value, int[] arrayParam) {
        int result = -1;
        for (int i = 0; i < arrayParam.length; i++) {
            if (value == arrayParam[i]) {
                return i;
            }
        }

        return result;
    }
}