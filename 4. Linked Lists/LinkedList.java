class LinkedList {
    private Link first;

    public LinkedList() {
        this.first = null;
    }

    public void insertFirst(int key, int data) {
        Link link = new Link(key, data);
        link.setNext(this.first);
        first = link;
    }

    public Link deleteFirst() {
        Link deletedLink = this.first;
        first = first.getNext();
        return deletedLink;
    }

    public void display() {
        Link current = first;
        System.out.print("\n[ ");
        while (current != null) {
            current.displayLink();
            current = current.getNext();
            System.out.print(" ");
        }
        System.out.print(" ]");
    }

    public Link findByKey(int key) {
        if (this.first == null) {
            return null;
        }

        Link current = this.first;

        while (current.getKey() != key) {
            if (current.getNext() == null) {
                return null;
            }
            current = current.getNext();
        }

        return current;
    }

    public Link delete(int key) {
        Link current = this.first;
        Link previous = null;

        if (this.first == null) {
            return null;
        }

        while (current.getKey() != key) {
            if (current.getNext() == null) {
                return null;
            }
            previous = current;
            current = current.getNext();
        }

        if (current == first) {
            first = first.getNext();
        } else {
            previous.setNext(current.getNext());
        }

        return current;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int getLength() {
        int length = 0;
        for (Link current = first; current != null; current = current.getNext()) {
            length++;
        }
        return length;
    }

    public void sort() {
        int tempKey, tempData;
        Link current, next;
        int size = getLength();
        int k = size; // reducing unneeded loop.
        for (int i = 0; i < size - 1; i++, k--) {
            current = first;
            next = first.getNext();

            for (int j = 1; j < k; j++) {
                if (current.getData() > next.getData()) {
                    tempData = current.getData();
                    current.setData(next.getData());
                    next.setData(tempData);

                    tempKey = current.getKey();
                    current.setKey(next.getKey());
                    next.setKey(tempKey);
                }
                current = current.getNext();
                next = next.getNext();
            }
        }
    }

    // Original one really depend on sorting first.
    // public LinkedList reverse() {
    // LinkedList reversedList = new LinkedList();
    // Link nextLink = null;
    // reversedList.insertFirst(first.getKey(), first.getData());

    // Link currLink = first;

    // while (currLink.getNext() != null) {
    // nextLink = currLink.getNext();
    // reversedList.insertFirst(nextLink.getKey(), nextLink.getData());
    // currLink = currLink.getNext();
    // }
    // return reversedList;
    // }

    public void reverse() {
        int tempKey, tempData;
        Link current, next;
        int size = getLength();
        int k = size; // reducing unneeded loop.
        for (int i = 0; i < size - 1; i++, k--) {
            current = first;
            next = first.getNext();

            for (int j = 1; j < k; j++) {
                if (current.getData() < next.getData()) {
                    tempData = current.getData();
                    current.setData(next.getData());
                    next.setData(tempData);

                    tempKey = current.getKey();
                    current.setKey(next.getKey());
                    next.setKey(tempKey);
                }
                current = current.getNext();
                next = next.getNext();
            }
        }
    }

    public void concatenate(LinkedList listParam) {
        if (first == null) {
            first = listParam.first;
        }
        if (listParam.first == null) {
            return;
        }
        Link temp = first;

        while (temp.getNext() != null) {
            temp = temp.getNext();
            System.out.println("temp " + temp.getKey());
        }

        temp.setNext(listParam.first); // because linkParam already chained before.
        // So, wen need first link, the rest will follow.
    }
}
