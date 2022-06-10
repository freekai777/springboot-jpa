package com.example.springbootjpa.test;


import org.springframework.data.repository.query.Param;

public class Test {

    static class Parent{
        public static int A = 1;
        static {
//            A = 2;
        }
    }

    /**
     * create by:
     * description:
     * create time: 2020/12/31
     *
     * @aram: a
     */
    static class Sub extends Parent{
        public static int B = A;
    }

    /**
     * @Author marvin
     * @Date 2020/12/31 10:56
     * @description
     * @Param args
     * @Return void
     */
    public static void main(String[] args) {
        System.out.println(Sub.B);
    }
}
