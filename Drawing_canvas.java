package Data_Table;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Drawing_canvas extends Canvas {
    public void paint(Graphics g) {

        Table1 table1=new Table1(Color.blue,Color.red,3,Color.cyan,Color.black,"title bar");
        table1.paint(g);





    }
}





