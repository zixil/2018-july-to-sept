package _622_Design_Circular_Queue;

public class MyCircularQueue {

    int[] que;
    int front = 0, rear = 0;
    int size;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        size = k + 1;
        que = new int[size];
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        int nextRear = (rear + 1) % size;
        if (front != nextRear) {
            que[rear = nextRear] = value;
            return true;
        } else return false;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (front == rear) return false;
        int nextFront = (front + 1) % size;
        front = nextFront;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        return que[front];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        return que[rear];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return (rear + 1) % size == front;
    }
}
