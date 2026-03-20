class Stack {
        private int top;
        private int maxSize;
        private int[] arr;

        Stack(int maxSize) {
                top = -1;
                this.maxSize = maxSize;
                arr = new int[maxSize];
        }

        public boolean isEmpty() {
                return top == -1;
        }

        public boolean push(int data) {
                if (top == maxSize - 1)
                        return false;
                arr[++top] = data;
                return true;
        }

        public int pop() {
                if (isEmpty())
                        return Integer.MIN_VALUE;
                return arr[top--];
        }

        public void display() {
                for (int i = top; i >= 0; i--)
                        System.out.println(arr[i]);
        }

        public int getMaxSize() {
                return maxSize;
        }
}

class Tester {
        public static Stack removeOdd(Stack stack) {

                Stack tempStack = new Stack(stack.getMaxSize());
                Stack resultStack = new Stack(stack.getMaxSize());

                // Remove odd numbers
                while (!stack.isEmpty()) {
                        int value = stack.pop();
                        if (value % 2 == 0) {
                                tempStack.push(value);
                        }
                }

                // Restore correct order
                while (!tempStack.isEmpty()) {
                        resultStack.push(tempStack.pop());
                }

                return resultStack;
        }

        public static void main(String[] args) {
                Stack stack = new Stack(10);
                stack.push(45);
                stack.push(22);
                stack.push(13);
                stack.push(8);
                stack.push(17);
                stack.push(6);

                System.out.println("Before:");
                stack.display();

                stack = Tester.removeOdd(stack);

                System.out.println("After:");
                stack.display();
        }
}
