package com.example.login.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

/**
 * @author HUIZHENG
 * @date 2019/5/10
 * @time 11:15
 * Created by IntelliJ IDEA.
 */
public class CharacterEncodingFilter implements Filter {

    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }
}
