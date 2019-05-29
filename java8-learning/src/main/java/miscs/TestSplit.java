package miscs;

/**
 * Created by zhaocaiwen on 2017/6/2.
 */
public class TestSplit {
    public static void main(String[] args) {
        String s= "2wsxqwer#001 xx12122xxxxasdfaxxxx1212xx2wsxqwer";
        System.out.println(s.indexOf("#001")!=-1);
        String[] parts = s.split("2wsxqwer");
        for(String p:parts) {
            System.out.println("part:"+p);
        }
    }
}
