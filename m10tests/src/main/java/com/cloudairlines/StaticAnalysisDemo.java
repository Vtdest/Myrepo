package com.cloudairlines;

public class StaticAnalysisDemo {

    public static final int SOME_NUM = 1; // adheres now to constant naming convention

    public static void main(String[] args) {

        boolean isTrue = true;

        if(isTrue) {

        }

        StringBuilder str = new StringBuilder();
        String[] arrayOfStrings = {""};
        for (String arrayOfString : arrayOfStrings) {
            str.append(arrayOfString);
        }
    }
}
