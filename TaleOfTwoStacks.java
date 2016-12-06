import java.util.*;

public class TaleOfTwoStacks {

    public static class MyQueue<T> {

        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue(T value) {
            stackNewestOnTop.push(value);
        }

        public T peek() {

            if(stackOldestOnTop.isEmpty()){
                transfer(stackNewestOnTop, stackOldestOnTop);
            }

            return stackOldestOnTop.peek();
        }

        public T dequeue() {

            if(stackOldestOnTop.isEmpty()){
                transfer(stackNewestOnTop, stackOldestOnTop);
            }

            return stackOldestOnTop.pop();
        }

        private void transfer(Stack<T> from, Stack<T> to){
            while(!from.isEmpty()){
                to.push(from.pop());
            }
        }

    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}

