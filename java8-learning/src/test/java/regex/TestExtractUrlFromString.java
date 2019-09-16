package regex;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created on 2019/9/16.
 */
public class TestExtractUrlFromString {
    @Test
    public void test1() {
        String data = "#Let's start doing this job…… http://v.douyin.com/eUWYth/ copy this url, let's enjoy！";
        assertEquals("http://v.douyin.com/eUWYth", InfoExtractor.extractUrl(data));
    }
}
