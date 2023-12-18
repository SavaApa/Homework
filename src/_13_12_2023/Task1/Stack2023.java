package _13_12_2023.Task1;

import java.util.ArrayList;

public interface Stack2023<T> {
    void put(T t); //put
    boolean isEmpty(); //
    T get(T t);
}

class StackImpl<T> implements Stack2023<T> {
    ArrayList<T> stack = new ArrayList<>();

    public StackImpl(ArrayList<T> stack) {
        this.stack = stack;
    }

    @Override
    public void put(T t) {
        stack.add(t);
    }

    @Override
    public boolean isEmpty() {
        if (!(stack.isEmpty())) {
            return false;
        }
        return true;
    }

    @Override
    public T get(T t) {
        return stack.get(stack.size() - 1);
    }

}
