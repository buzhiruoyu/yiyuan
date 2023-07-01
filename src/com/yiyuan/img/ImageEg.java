package com.yiyuan.img;

import javax.swing.*;
import java.awt.*;

public class ImageEg  extends JPanel {
    private Image image;
    private ImageIcon image1;
    public ImageEg() {
        super();
        //super类就是超类，即父类，super()方法是调用父类的构造方法，实际上super指代父类的实例，如果父类有方法 fun(),可用super.fun()来调用
        setOpaque(true);
        //可以设置透明或不透明，true值为不透明
        //image = Toolkit.getDefaultToolkit().getImage( "src/house.jpg"); ;
        //image2=new ImageIcon(PanelImageTest.class.getResource("/house.jpg"));
        image1 = new ImageIcon(ImageEg.class.getResource("01.png"));
        //注意图片路径，图片放在根目录下的bin文件夹里
        //  System.out.println("image1="+image1);
        image=image1.getImage();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);
        if (image!= null) {
            int height = image.getHeight(this);
            int width = image.getWidth(this);

            if (height != -1 && height > getHeight())
                height = getHeight();

            if (width != -1 && width > getWidth())
                width = getWidth();

            int x = (int) (((double) (getWidth() - width)) / 2.0);
            int y = (int) (((double) (getHeight() - height)) / 2.0);
            g.drawImage(image, x, y, width, height, this);
        }
    }
    public static void main(String[] args) {
        JFrame frame=new JFrame();
        frame.setSize(1000, 500);
        ImageEg pI=new ImageEg();
        frame.add(pI);
        frame.setVisible(true);
    }
}
