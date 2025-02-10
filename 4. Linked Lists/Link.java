class Link {
    private int key;
    private int data;
    private Link next;

    public Link(int key, int data) {
        this.key = key;
        this.data = data;
    }

    public void setNext(Link data) {
        this.next = data;
    }

    public void setKey(int newKey) {
        this.key = newKey;
    }

    public void setData(int newdata) {
        this.data = newdata;
    }

    public Link getNext() {
        return this.next;
    }

    public int getKey() {
        return this.key;
    }

    public int getData() {
        return this.data;
    }

    public void displayLink() {
        System.out.print("{" + key + "," + data + "}");
    }
}