package com.example.springbootjpa.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BaseMultiResolutionImage;
import java.awt.image.MultiResolutionImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(JUnit4.class)
public class JunitTest {

    /**
     * 构建前缀树
     */
    @Test
    public void testBuildTrie(){
        final List<String> list = Arrays.asList("are", "arm", "army", "amy", "bird", "bed", "beg", "bad");
        TNode tNode = new TNode(true);

    }

    /**
     * 测试 jdk9的新特性
     * 图片分辨率
     */
    @Test
    public void testJdk9ImageDiff() throws IOException {
        List<String> imgUrls = List.of("http://www.runoob.com/wp-content/themes/runoob/assets/img/runoob-logo@2x.png",
                "http://www.runoob.com/wp-content/themes/runoob/assets/img/runoob-logo.png",
                "http://www.runoob.com/wp-content/themes/runoob/assets/images/qrcode.png");

        List<Image> images = new ArrayList<Image>();

//        for (String url : imgUrls) {
//            final File file = new File(url);
//            images.add(ImageIO.read(file));
//        }
        images.add(ImageIO.read(new FileInputStream("C:\\Users\\dell\\Desktop\\abc.png")));

//        for (int i = 0; i < ImageIO.getReaderFormatNames().length; i++) {
//            System.out.println(ImageIO.getReaderFormatNames()[i]);
//        }


        // 读取所有图片
        MultiResolutionImage multiResolutionImage =
                new BaseMultiResolutionImage(images.toArray(new Image[0]));

        // 获取图片的所有分辨率
        List<Image> variants = multiResolutionImage.getResolutionVariants();

        System.out.println("Total number of images: " + variants.size());

        for (Image img : variants) {
            System.out.println(img);
        }

        // 根据不同尺寸获取对应的图像分辨率
        Image variant1 = multiResolutionImage.getResolutionVariant(156, 45);
        System.out.printf("\nImage for destination[%d,%d]: [%d,%d]",
                156, 45, variant1.getWidth(null), variant1.getHeight(null));

        Image variant2 = multiResolutionImage.getResolutionVariant(311, 89);
        System.out.printf("\nImage for destination[%d,%d]: [%d,%d]", 311, 89,
                variant2.getWidth(null), variant2.getHeight(null));

//        Image variant3 = multiResolutionImage.getResolutionVariant(622, 178);
//        System.out.printf("\nImage for destination[%d,%d]: [%d,%d]", 622, 178,
//                variant3.getWidth(null), variant3.getHeight(null));
//
//        Image variant4 = multiResolutionImage.getResolutionVariant(300, 300);
//        System.out.printf("\nImage for destination[%d,%d]: [%d,%d]", 300, 300,
//                variant4.getWidth(null), variant4.getHeight(null));
    }
}
