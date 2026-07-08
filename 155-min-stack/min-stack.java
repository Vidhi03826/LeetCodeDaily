class MinStack {

    Stack<Long> s;
    long minVal;

    public MinStack() {
        s = new Stack<>();
    }

    public void push(int value) {

        if (s.isEmpty()) {
            s.push((long) value);
            minVal = value;
        }

        else if (value < minVal) {

            s.push(2L * value - minVal);
            minVal = value;

        }

        else {

            s.push((long) value);

        }
    }

    public void pop() {

        if (s.peek() < minVal) {
            minVal = 2 * minVal - s.peek();
        }

        s.pop();
    }

    public int top() {

        if (s.peek() < minVal)
            return (int) minVal;

        return s.peek().intValue();
    }

    public int getMin() {
        return (int) minVal;
    }
}