package com.blog.common.service;

/**
 * Created by liuhb on 2017/1/11.
 */
public interface Function<T,E> {
    public T callback(E e);
}
