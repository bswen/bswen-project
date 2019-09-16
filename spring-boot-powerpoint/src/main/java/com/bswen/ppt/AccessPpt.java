package com.bswen.ppt;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created on 2019/7/10.
 */
@Component
public class AccessPpt implements CommandLineRunner {
    @Override
    public void run(String... strings) throws Exception {
        //Load the powerpoint document

        Presentation ppt = new Presentation();
        ppt.loadFromFile("addproperty.pptx");

        //读取文档属性
        System.out.println("标题： " + ppt.getDocumentProperty().getTitle());
        System.out.println("主题： " + ppt.getDocumentProperty().getSubject());
        System.out.println("作者： " + ppt.getDocumentProperty().getAuthor());
        System.out.println("单位： " + ppt.getDocumentProperty().getCompany());
        System.out.println("主管： " + ppt.getDocumentProperty().getManager());
        System.out.println("类别： " + ppt.getDocumentProperty().getCategory());
        System.out.println("关键字：" + ppt.getDocumentProperty().getKeywords());
        System.out.println("备注： " + ppt.getDocumentProperty().getComments());
        System.out.println("内容状态："+ ppt.getDocumentProperty().getContentStatus());
    }
}
