public class TestStack {
    public static void main(String[] args) {
        StackOnQueue stack = new StackOnQueue();

        System.out.println("=== Тестирование стека на двух очередях ===");

        System.out.println("1. Стек пуст? " + stack.empty());

        System.out.println("\n2. Добавляем 10 и 20 в стек");
        stack.push(10);
        stack.push(20);

        System.out.println("3. Все элементы стека: " + stack.toString());

        System.out.println("4. Вершина стека (top()): " + stack.top());

        System.out.println("5. Удаляем вершину стека (pop()): " + stack.pop());

        System.out.println("6. Все элементы после удаления: " + stack.toString());

        System.out.println("7. Стек пуст? " + stack.empty());

        System.out.println("\n8. Добавляем 30, 40, 50");
        stack.push(30);
        stack.push(40);
        stack.push(50);

        System.out.println("9. Все элементы стека: " + stack.toString());
        System.out.println("10. Вершина стека: " + stack.top());
        System.out.println("11. Удаляем вершину: " + stack.pop());
        System.out.println("12. Все элементы: " + stack.toString());
    }
}