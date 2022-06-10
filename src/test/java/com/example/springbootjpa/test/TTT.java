package com.example.springbootjpa.test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;

public class TTT {
    public static void main(String[] args) throws IOException {
        String sourcePic = "C:\\Users\\dell\\Desktop\\aa.png";
        Image image = ImageIO.read(new File(sourcePic));
        final BufferedImage picEdge = getPicEdge((BufferedImage) image);

        ImagePanel panel = new ImagePanel(new
                ImageIcon(picEdge).getImage());
        JFrame frame = new JFrame("test");
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static BufferedImage getPicEdge(BufferedImage originalPic) {
        int imageWidth = originalPic.getWidth();
        int imageHeight = originalPic.getHeight();

        BufferedImage newPic = new BufferedImage(imageWidth, imageHeight,
                BufferedImage.TYPE_3BYTE_BGR);

//        float[] elements = { 0.0f, -1.0f, 0.0f, -1.0f, 4.0f, -1.0f, 0.0f,
//                -1.0f, 0.0f };
        float[] elements = { -5.0f, 5.0f, -5.0f, 5.0f, 5.0f, 5.0f, -5.0f,
                5.0f, -5.0f };

        Kernel kernel = new Kernel(3, 3, elements);
        ConvolveOp cop = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
        cop.filter(originalPic, newPic);
        return newPic;
    }
}
