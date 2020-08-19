package cn.ebing.dog.api.thread.future;

public interface Data<T> {
	T get();
	boolean isDone();
	boolean cancel();
}
