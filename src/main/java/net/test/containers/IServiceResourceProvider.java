package net.test.containers;

public interface IServiceResourceProvider {
    <T> T getService(String typeKey,Class<T> serviceClass);

    <T> T getService(Class<T> serviceClass);
}
