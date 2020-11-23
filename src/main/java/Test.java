public class Test {
    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue();
        queue.push(10, "a", "as");
        queue.push(9, "a", "as");
        queue.push(12, "a", "as");
        queue.push(0, "a", "as");
        System.out.println(queue);
    }
}
