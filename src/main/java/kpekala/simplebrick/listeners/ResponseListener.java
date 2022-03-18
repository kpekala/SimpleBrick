package kpekala.simplebrick.listeners;

public interface ResponseListener<T> {
    void onResponse(T t);
    void onError(String error);
}
