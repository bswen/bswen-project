package lambdas;

/**
 * Created by zhaocw on 2017-1-6.
 *
 * @author zhaocw
 */
public class AppleWeightFilter implements IAppleFilter {
    private final int weight;

    public AppleWeightFilter(int weight) {
        this.weight = weight;
    }
    @Override
    public boolean filter(Apple apple) {
        return apple!=null&&apple.getWeight()>weight;
    }
}
