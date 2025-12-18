import java.util.LinkedList;
import java.util.Queue;

public class StackOnQueue {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public StackOnQueue() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    // Помещает элемент на вершину стека
    public void push(int x) {
        // Всегда добавляем в непустую очередь (или в queue1, если обе пусты)
        if (!queue1.isEmpty()) {
            queue1.add(x);
        } else {
            queue2.add(x);
        }
    }

    // Удаляет элемент с вершины стека и возвращает его
    public int pop() {
        if (empty()) {
            throw new RuntimeException("Stack is empty");
        }

        Queue<Integer> nonEmptyQueue = queue1.isEmpty() ? queue2 : queue1;
        Queue<Integer> emptyQueue = queue1.isEmpty() ? queue1 : queue2;

        // Перекладываем все элементы кроме последнего в пустую очередь
        while (nonEmptyQueue.size() > 1) {
            emptyQueue.add(nonEmptyQueue.poll());
        }

        // Последний элемент - вершина стека
        return nonEmptyQueue.poll();
    }

    // Возвращает элемент на вершине стека без удаления
    public int top() {
        if (empty()) {
            throw new RuntimeException("Stack is empty");
        }

        Queue<Integer> nonEmptyQueue = queue1.isEmpty() ? queue2 : queue1;
        Queue<Integer> emptyQueue = queue1.isEmpty() ? queue1 : queue2;

        // Перекладываем все элементы кроме последнего
        while (nonEmptyQueue.size() > 1) {
            emptyQueue.add(nonEmptyQueue.poll());
        }

        // Получаем последний элемент
        int topElement = nonEmptyQueue.peek();
        // Перекладываем его тоже в другую очередь
        emptyQueue.add(nonEmptyQueue.poll());

        return topElement;
    }

    // Проверяет, пуст ли стек
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    // Возвращает строковое представление всех элементов стека
    @Override
    public String toString() {
        if (empty()) {
            return "Stack is empty";
        }

        // Создаем копии очередей, чтобы не изменять оригиналы
        Queue<Integer> temp1 = new LinkedList<>(queue1);
        Queue<Integer> temp2 = new LinkedList<>(queue2);

        StringBuilder result = new StringBuilder("[");

        // Определяем, какая очередь не пуста
        Queue<Integer> current = temp1.isEmpty() ? temp2 : temp1;
        Queue<Integer> helper = temp1.isEmpty() ? temp1 : temp2;

        // Временный стек для правильного порядка вывода
        java.util.Stack<Integer> tempStack = new java.util.Stack<>();

        // Перекладываем в стек для получения правильного порядка
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
            // Меняем очереди местами
            Queue<Integer> temp = current;
            current = helper;
            helper = temp;
        }

        // Формируем строку из стека
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