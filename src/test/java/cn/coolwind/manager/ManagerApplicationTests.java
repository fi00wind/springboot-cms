package cn.coolwind.manager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManagerApplicationTests {

    @Test
    public void contextLoads() {
        Document doc = null;
        try {
            doc = Jsoup.parse(new File("C:/Users/admin/Desktop/icon.html"),"utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements classes = doc.getElementsByClass("anticons-list");
        Elements element = classes.get(4).getElementsByClass("ant-badge");
        List<String> icons = new ArrayList<>();
        for (int i = 0; i < element.size(); i++) {
           String s = element.get(i).html();
            String[] s1 = s.split(" ");
            icons.add(s1[0]);
        }
        System.out.printf("[");
        for (String icon : icons) {
            System.out.printf("'"+icon+"',");
        }
        System.out.printf("]");
    }

}
