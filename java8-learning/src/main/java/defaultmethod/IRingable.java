package defaultmethod;

/**
 * Created by zhaocaiwen on 2017/2/23.
 */
public interface IRingable extends IRidable{
    void ring();

    default boolean canTakePerson() {
        System.out.println("IRingable here");
        return false;
    }
}
