public class TestStack {
    public static void main(String[] args) {
        // Создаем новый экземпляр стека на очередях
        StackOnQueue stack = new StackOnQueue();

        System.out.println("=== Тестирование стека на двух очередях ===");

        // Проверяем, пуст ли стек
        System.out.println("1. Стек пуст? " + stack.empty());

        // Добавляем два значения
        System.out.println("\n2. Добавляем 10 и 20 в стек");
        stack.push(10);
        stack.push(20);

        // Выводим все элементы стека
        System.out.println("3. Все элементы стека: " + stack.toString());

        // Выводим объект на вершине стека (без удаления)
        System.out.println("4. Вершина стека (top()): " + stack.top());

        // Выводим и удаляем вершину стека
        System.out.println("5. Удаляем вершину стека (pop()): " + stack.pop());

        // Выводим все элементы после удаления
        System.out.println("6. Все элементы после удаления: " + stack.toString());

        // Проверяем, пуст ли стек
        System.out.println("7. Стек пуст? " + stack.empty());

        // Добавляем еще элементы для демонстрации
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