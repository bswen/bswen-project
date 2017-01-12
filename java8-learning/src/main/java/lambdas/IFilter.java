package lambdas;

/**
 * Created by zhaocw on 2017-1-6.
 *
 * @author zhaocw
 * @param T the type.
 */
public interface IFilter<T> {
    boolean test(T t);
}
