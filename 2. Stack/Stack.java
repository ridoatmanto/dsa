class Stack {

    private int arraySize;
    private int[] intArray;
    private int topPositionIndex;

    public Stack(int sizeParam) {
        this.arraySize = sizeParam;
        this.intArray = new int[sizeParam];
        this.topPositionIndex = -1;
    }

    public void push(int data) {
        if (!isFull()) {
            intArray[++topPositionIndex] = data;
        } else {
            System.out.println("Stack is full. Cannot add data.");
        }
    }

    public int pop() {
        return intArray[topPositionIndex--];
    }

    public int peek() {
        return intArray[topPositionIndex];
    }

    public boolean isFull() {
        return (topPositionIndex == arraySize - 1);
    }

    public boolean isEmpty() {
        return (topPositionIndex == -1);
    }
}