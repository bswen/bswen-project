package tij.generics;

import typeinfo.pets.Cat;
import typeinfo.pets.Mouse;
import typeinfo.pets.Pet;
import typeinfo.pets.Rodent;

import static net.mindview.util.Print.print;

/**
 * Created by zhaocaiwen on 2017/3/17.
 */
public class Holder<T> {
    private T a;
    public Holder(T a) {
        this.a = a;
    }

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public static void main(String[] args) {
        Holder<Automobile> holder = new Holder<>(new Automobile("honda"));
        System.out.println(holder.getA().getBrand());

        Holder<Pet> aCat = new Holder<>(new Cat("tomcat"));
        System.out.println(aCat.getA().getName());

        Holder<Rodent> rodent = new Holder<>(new Mouse("jack mouse"));
        print(rodent.getA().getName());
    }
}
