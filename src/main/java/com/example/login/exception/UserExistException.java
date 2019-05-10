package com.example.login.exception;

/**
 * 自定义异常
 * @author HUIZHENG
 * @date 2019/5/9
 * @time 11:37
 * Created by IntelliJ IDEA.
 */
public class UserExistException extends Exception {
    public UserExistException() {
        super();
    }

    public UserExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserExistException(String message) {
        super(message);
    }

    public UserExistException(Throwable cause) {
        super(cause);
    }
}
