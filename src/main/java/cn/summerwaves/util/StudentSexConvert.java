package cn.summerwaves.util;

import com.github.crab2died.converter.ReadConvertible;

public class StudentSexConvert implements ReadConvertible {
    @Override
    public Object execRead(String s) {
        if ("男".equals(s)) {
            return 1;
        } else if ("女".equals(s)) {
            return 2;
        } else {
            return 0;
        }

    }
}
