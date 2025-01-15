public class DEQ<T> extends Queue<T> {
	public DEQ(int maxSize) {
		super(maxSize);
	}

	public DEQ(T[] items) {
		super(items);
	}

	public T popEnd() {
		if (isEmpty())
			return null;
		setSize(size() - 1);
		return items()[(startIndex() + size()) % maxSize()];
	}

	public int pushStart(T item) throws ArrayIndexOutOfBoundsException {
		if (isFull())
			throw new ArrayIndexOutOfBoundsException("Queue is full");
		setStartIndex((startIndex() - 1 + maxSize()) % maxSize());
		items()[startIndex()] = item;
		return setSize(size() + 1);
	}
}