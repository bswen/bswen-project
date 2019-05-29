package defaultmethod;

/**
 * Created by zhaocaiwen on 2017/2/17.
 */
public class Bike extends Transportor implements IRingable {
    @Override
    public void ride() {

    }

    public static void main(String[] args) {
        IRidable b = new Bike();
        System.out.println(b.canTakePerson());
    }

    @Override
    public void ring() {

    }
}
