package lambdas;

/**
 * Created by zhaocw on 2017-1-6.
 *
 * @author zhaocw
 */
public class AppleColorFilter implements IAppleFilter {
    private final String theColor;

    public AppleColorFilter(String theColor) {
        this.theColor = theColor;
    }
    @Override
    public boolean filter(Apple apple) {
        if(apple!=null&&apple.getColor().equals(theColor)) {
            return true;
        }
        return false;
    }
}
