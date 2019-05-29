package defaultmethod;

/**
 * Created by zhaocaiwen on 2017/2/17.
 */
public interface IRidable {
    void ride();

    default boolean canTakePerson() {
        System.out.println("IRidable here");
        return false;
    }
}
