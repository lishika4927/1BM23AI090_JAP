/ i. Interface for Stack Operations
interface Stack {
    void push(int element);
    int pop();
    boolean isEmpty();
    int size();
}

// ii. Fixed-Length Stack Implementation
class FixedLengthStack implements Stack {
    private int[] stackArray;
    private int top;
    private int capacity;

    public FixedLengthStack(int capacity) {
        this.capacity = capacity;
        this.stackArray = new int[capacity];
        this.top = -1;
    }

    @Override
    public void push(int element) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow: Cannot push element, stack is full.");
            return;
        }
        stackArray[++top] = element;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow: Cannot pop element, stack is empty.");
            return -1;
        }
        return stackArray[top--];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public int size() {
        return top + 1;
    }
}

// iii. Dynamic-Length Stack Implementation
class DynamicLengthStack implements Stack {
    private int[] stackArray;
    private int top;
    private int capacity;

    public DynamicLengthStack() {
        this.capacity = 10; // Initial capacity
        this.stackArray = new int[capacity];
        this.top = -1;
    }

    @Override
    public void push(int element) {
        if (top == capacity - 1) { // If the stack is full, double the capacity
            capacity *= 2;
            int[] newStackArray = new int[capacity];
            System.arraycopy(stackArray, 0, newStackArray, 0, stackArray.length);
            stackArray = newStackArray;
        }
        stackArray[++top] = element;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow: Cannot pop element, stack is empty.");
            return -1;
        }
        return stackArray[top--];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public int size() {
        return top + 1;
    }
}

// iv. Class Demonstrating Runtime Binding and Stack Operations
class StackOperations {
    public static void main(String[] args) {
        // Using FixedLengthStack through Interface reference
        Stack fixedStack = new FixedLengthStack(5);
        System.out.println("Fixed Length Stack Operations:");
        performStackOperations(fixedStack);

        // Using DynamicLengthStack through Interface reference
        Stack dynamicStack = new DynamicLengthStack();
        System.out.println("\nDynamic Length Stack Operations:");
        performStackOperations(dynamicStack);
    }

    public static void performStackOperations(Stack stack) {
        System.out.println("Stack Size: " + stack.size());
        stack.push(10);
        System.out.println("Stack Size: " + stack.size());
        stack.push(20);
        System.out.println("Stack Size: " + stack.size());
        stack.push(30);
        System.out.println("Stack Size: " + stack.size());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Stack Size: " + stack.size());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Stack Size: " + stack.size());
        System.out.println("Is Empty: " + stack.isEmpty());
        System.out.println("Stack Size: " + stack.size());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Stack Size: " + stack.size());
        System.out.println("Is Empty: " + stack.isEmpty());
    }
}
