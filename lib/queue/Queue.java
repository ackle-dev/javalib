
import java.util.Arrays;

public class Queue<T> {

	private final T[] _items;
	private final int maxSize;
	private int _startIndex;
	private int size;

	@SuppressWarnings("unchecked")
	public Queue(int maxSize) {
		this.maxSize = maxSize;
		_items = (T[]) new Object[maxSize];
		_startIndex = 0;
		size = 0;
	}

	public Queue(T[] items) {
		_items = items;
		maxSize = items.length;
		_startIndex = 0;
		size = items.length;
	}

	public int getStartIndex() {
		return _startIndex;
	}

	public int setStartIndex(int startIndex) {
		return _startIndex = startIndex;
	}

	public int getSize() {
		return size;
	}

	public int setSize(int size) {
		return this.size = size;
	}

	public int maxSize() {
		return maxSize;
	}

	public boolean isFull() {
		return size == maxSize;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int pushEnd(T item) throws ArrayIndexOutOfBoundsException {
		if (isFull())
			throw new ArrayIndexOutOfBoundsException("Queue is full");
		_items[(_startIndex + size) % maxSize] = item;
		return ++size;
	}

	public T popStart() {
		if (isEmpty())
			return null;
		size--;
		return _items[_startIndex++ % maxSize];
	}

	// tests
	public static void main(String[] args) {
		Queue<Integer> q = new Queue<>(5);
		for (int i = 1; i <= 5; i++) {
			q.pushEnd(i);
			System.out.printf("%d %d\n", q._startIndex, q.size);
		}
		try {
			q.pushEnd(6);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		for (int i = 0; i < 5; i++)
			System.out.println(q.popStart());
		System.out.println(q.isEmpty());
		q.pushEnd(6);
		System.out.printf("%d %d\n", q._startIndex, q.size);
		System.out.println(Arrays.toString(q._items));
	}
}
