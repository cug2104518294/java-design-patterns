package com.iluwatar.chain;

class Father {

    String name;
    int age;

    public void test() {
        System.out.println("我是父类的test()方法");
        System.out.println("父类姓名=" + name + " 父类年龄=" + age);
    }

    public void test(String name, int age) {
        System.out.println("我是父类的test(String name, int age)方法");
        System.out.println("父类姓名=" + name + " 父类年龄=" + age);
    }
}

public class Son extends Father {

    public void test() {
        //调用父类的时候  即便是没有传任何参数 但是父类的name和age也是杨过、12
        //调用的时候 传入的参数其实对应的都是此时对象的对应的参数
        super.test();
        //可以多次调用父类的方法
        super.test("kobe", 18);
        System.out.println("我是子类的test()方法");
        System.out.println("子类姓名=" + this.name + " 子类年龄=" + this.age);
    }

    public static void main(String[] args) {
        Son son = new Son();
        son.name = "杨过";
        son.age = 12;
        son.test();
    }
}

