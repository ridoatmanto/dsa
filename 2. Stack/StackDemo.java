class StackDemo {
    public static void main(String[] args) {
        Stack stack = new Stack(10);
        stack.push(3);
        stack.push(7);
        stack.push(12);
        stack.push(8);
        stack.push(6);
        stack.push(2);

        System.out.println("Element at top of the stack: " + stack.peek());
        System.out.println("Elements: " + stack.toString());

        while (!stack.isEmpty()) {
            int data = stack.pop();
            System.out.println("Pop element: " + data);
        }
        System.out.println("Elements is full : " + stack.isFull());
        System.out.println("Elements is empty : " + stack.isEmpty());
    }
}