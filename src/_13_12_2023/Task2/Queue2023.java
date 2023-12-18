package _13_12_2023.Task2;

import java.util.ArrayList;

public interface Queue2023<E> {
    boolean add(E e);

    void remove();

    E element(E e);
}

class QueueImpl<E> implements Queue2023<E> {
    ArrayList<E> queue = new ArrayList<>();

    @Override
    public boolean add(E e) {
        if (queue.contains(e)) {
            System.out.println("Element is already in Queue");
            return false;
        } else {
            queue.add(e);
        }
        System.out.println("Element is added");
        return true;
    }

    @Override
    public void remove() {
        if (queue.isEmpty()) {
            System.out.println("NoSuchElementException");
        }
        queue.get(0);
        queue.remove(0);

    }

    @Override
    public E element(E e) {
        if (queue.isEmpty()) {
            System.out.println("NoSuchElementException");
        }
        return queue.get(0);
    }
}
