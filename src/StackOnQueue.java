import java.util.LinkedList;
import java.util.Queue;

public class StackOnQueue {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public StackOnQueue() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        if (!queue1.isEmpty()) {
            queue1.add(x);
        } else {
            queue2.add(x);
        }
    }

    public int pop() {
        if (empty()) {
            throw new RuntimeException("Stack is empty");
        }

        Queue<Integer> nonEmptyQueue = queue1.isEmpty() ? queue2 : queue1;
        Queue<Integer> emptyQueue = queue1.isEmpty() ? queue1 : queue2;

        while (nonEmptyQueue.size() > 1) {
            emptyQueue.add(nonEmptyQueue.poll());
        }

        return nonEmptyQueue.poll();
    }

    public int top() {
        if (empty()) {
            throw new RuntimeException("Stack is empty");
        }

        Queue<Integer> nonEmptyQueue = queue1.isEmpty() ? queue2 : queue1;
        Queue<Integer> emptyQueue = queue1.isEmpty() ? queue1 : queue2;

        while (nonEmptyQueue.size() > 1) {
            emptyQueue.add(nonEmptyQueue.poll());
        }

        int topElement = nonEmptyQueue.peek();
        emptyQueue.add(nonEmptyQueue.poll());

        return topElement;
    }

    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    @Override
    public String toString() {
        if (empty()) {
            return "Stack is empty";
        }

        Queue<Integer> temp1 = new LinkedList<>(queue1);
        Queue<Integer> temp2 = new LinkedList<>(queue2);

        StringBuilder result = new StringBuilder("[");

        Queue<Integer> current = temp1.isEmpty() ? temp2 : temp1;
        Queue<Integer> helper = temp1.isEmpty() ? temp1 : temp2;

        java.util.Stack<Integer> tempStack = new java.util.Stack<>();

        while (!current.isEmpty()) {
            helper.add(current.poll());
        }

        current = helper;
        helper = (current == temp1) ? temp2 : temp1;

        while (!current.isEmpty()) {
            tempStack.push(current.poll());
            while (current.size() > 1) {
                helper.add(current.poll());
            }
            if (!current.isEmpty()) {
                tempStack.push(current.poll());
            }
            Queue<Integer> temp = current;
            current = helper;
            helper = temp;
        }

        while (!tempStack.isEmpty()) {
            result.append(tempStack.pop());
            if (!tempStack.isEmpty()) {
                result.append(", ");
            }
        }

        result.append("] (top -> bottom)");
        return result.toString();
    }
}