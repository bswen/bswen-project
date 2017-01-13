package lambdas;

/**
 * Created by xx on 2017-1-6.
 *
 * @author xx
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
