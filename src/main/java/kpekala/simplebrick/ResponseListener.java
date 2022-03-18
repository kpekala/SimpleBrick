package kpekala.simplebrick;

public interface ResponseListener<T> {
    void onResponse(T t);
    void onError(String error);
}
