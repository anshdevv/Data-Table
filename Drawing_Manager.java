package Data_Table;
import Data_Table.Drawing_canvas;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;

public class Drawing_Manager {

    public static void main(String[] args) {
        Drawing_canvas canvas = new Drawing_canvas();
        JFrame frame = new JFrame();
        frame.add(canvas);
        Constants constants=new Constants();
        frame.setSize(constants.WIDTH,constants.HEIGHT);
        //f.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);

    }
}
