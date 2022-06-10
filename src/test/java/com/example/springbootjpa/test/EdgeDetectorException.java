package com.example.springbootjpa.test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;

public class EdgeDetectorException extends Exception {

    public EdgeDetectorException() {
        super();
    }

    public EdgeDetectorException(String message) {

        super(message);
    }


    public static void main(String[] args) throws IOException {
        EdgeDetector edgeDetector=new EdgeDetector();
        String sourcePic = "C:\\Users\\dell\\Desktop\\aa.png";
        Image image = ImageIO.read(new File(sourcePic));
        edgeDetector.setSourceImage(image);
        edgeDetector.setThreshold(160);
        edgeDetector.setWidGaussianKernel(10);
        try {
            edgeDetector.process();
        }
        catch(EdgeDetectorException e) {
            System.out.println(e.getMessage());
        }
        Image edgeImage=edgeDetector.getEdgeImage();
//        final Graphics graphics = edgeImage.getGraphics();
        ImagePanel panel = new ImagePanel(new
                ImageIcon(edgeImage).getImage());
        JFrame frame = new JFrame("纠正。。。");
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }


}
