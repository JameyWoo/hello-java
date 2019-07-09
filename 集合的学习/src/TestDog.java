class Animal{
    int a = 3;
    public void move(){
        System.out.println("动物可以移动");
    }
}

class Dog extends Animal{
    int b = 4;
    public void move(){
        System.out.println("狗可以跑和走");
    }
}

public class TestDog{
    public static void main(String args[]){
        Animal a = new Animal(); // Animal 对象
        Animal b = new Dog(); // Dog 对象. 用Dog重写了Animal

        a.move();// 执行 Animal 类的方法

        b.move();//执行 Dog 类的方法
        System.out.println(a.a);
//        System.out.println(b.b); // 因为b其实是一个Animal, 只是用Dog的方法重写了Animal?
    }
}