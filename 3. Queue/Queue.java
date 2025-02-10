class Queue {
    private final int MAX;
    private int[] intArray;
    private int front;
    private int rear;
    private int itemCount;

    public Queue(int sizeParam) {
        this.MAX = sizeParam;
        this.intArray = new int[sizeParam];
        this.front = 0;
        this.rear = -1;
        this.itemCount = 0;
    }

    public void insert(int data) {
        if (front > 0) {
            insertWithMovingIndex(data);
            return;
        }

        if (!isFull()) {
            if (this.rear == MAX - 1) {
                this.rear = -1;
            }

            this.intArray[++this.rear] = data;
            this.itemCount++;
        }
    }

    public int remove() {
        int data = intArray[front++];
        if (front == MAX) {
            front = 0;
        }
        itemCount--;
        return data;
    }

    public int peek() {
        return intArray[front];
    }

    public boolean isFull() {
        return itemCount == MAX;
    }

    public int size() {
        return itemCount;
    }

    public int[] getArray() {
        return this.intArray;
    }

    public void insertWithMovingIndex(int data) {
        for (int i = 1; i < intArray.length; i++) {
            this.intArray[i - 1] = this.intArray[i];
        }
        this.intArray[intArray.length - 1] = data;
    }
}