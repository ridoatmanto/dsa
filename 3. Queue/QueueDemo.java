class QueueDemo {
    public static void main(String[] args) {
        Queue queue = new Queue(6);
        queue.insert(3);
        queue.insert(7);
        queue.insert(12);
        queue.insert(8);
        queue.insert(6);

        display(queue.getArray());
        System.out.println("Element at front of the stack: " + queue.peek());
        System.out.println("========\n");

        queue.insert(15);
        System.out.println("Insert Element: " + 15);

        if (queue.isFull()) {
            System.out.println("Queue is full");
        }
        display(queue.getArray());
        System.out.println("Element at front of the stack: " + queue.peek());
        System.out.println("========\n");

        int num = queue.remove();
        System.out.println("Remove Element: " + num);
        System.out.println("Element at front of the stack: " + queue.peek());
        System.out.println("========\n");

        queue.insert(16);
        System.out.println("Insert Element: " + 16);
        display(queue.getArray());

        queue.insert(17);
        System.out.println("Insert Element: " + 17);
        display(queue.getArray());

        queue.insert(18);
        System.out.println("Insert Element: " + 18);
        display(queue.getArray());
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

        System.out.println(result + "\n");
    }
}