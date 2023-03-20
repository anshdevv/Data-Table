package Data_Table;

import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

import Data_Table.Title_bar;

public class Table1 {
    public Color cell_color1;
    public Color button_color;
    public int stroke;
    public Color first_rowcolor;
    public Color stroke_color;
    String title;

    private int max_Stringlength;

    public Table1(Color cell_color1, Color button_color, int stroke, Color first_rowcolor, Color stroke_color,String title) {
        this.cell_color1 = cell_color1;
        this.button_color = button_color;
        this.stroke = stroke;
        this.first_rowcolor = first_rowcolor;
        this.stroke_color = stroke_color;
        this.title=title;
    }

    public void paint(Graphics g) {
        Cell cell;
        Color cell_color;


        Constants constants = new Constants();

        File file = new File("./src/Data_Table/data table.txt");

        // the ide checks if file in null through buffer the default is printed with 4 rows and 4 coloumns.
        try {
            Scanner sc = new Scanner(file);

            Title_bar titleBar = new Title_bar(0, 0, constants.WIDTH, constants.HEIGHT / 25, 2, Color.black, Color.black,title , Color.red);
            titleBar.paint(g);
            int y = titleBar.height;
            int cell_height;
            BufferedReader br = new BufferedReader(new FileReader(file));
            if (br.readLine() == null) {

                for (int i = 0; i < 4; i++) {
                    if(i==0){
                        cell_color=first_rowcolor;
                    }else{
                        cell_color=cell_color1;
                    }
                    int x = 0;
                    for (int j = 0; j < 4; j++) {
                        cell_height = ((constants.HEIGHT) - ((constants.HEIGHT / 25) + (13 * 3)));
                        int cell_width = ((constants.WIDTH) - (5 * 3)) / 4;
                        cell = new Cell(x, y, cell_width, cell_height / 4, stroke, cell_color, stroke_color, "DEFAULT");
                        cell.paint(g);
                        x += cell_width;
                        System.out.println(cell_height / 4);
                    }
                    y += (((constants.HEIGHT) - ((constants.HEIGHT / 25) + (13 * 3)))) / 4;
                }
            }
// the file has data it reads the number of col first and then it reads the number of rows.
            // it then reads the data and stores it in a 2d array
            //the 2d array is printed
            //cell is called in the for loop.
            //table will call cell again and again

            else {
                int col = sc.nextInt();
                int rows = sc.nextInt();
                FontMetrics metrics = g.getFontMetrics();
                String[][] data = new String[rows][col];
                for (int i = 0; i < rows; i++) {
                    if (i == 0) {
                        cell_color = first_rowcolor;
                    } else {
                        cell_color = cell_color1;
                    }
                    int x = 0;
                    for (int j = 0; j < col; j++) {
                        String input;
                        int stringlength = 0;
                        input = sc.next();
                        data[i][j] = input;
                        stringlength = input.length();
                        if (stringlength > this.max_Stringlength) {
                            this.max_Stringlength = stringlength;

                        }
                        int k = metrics.stringWidth(input);
                        int u = metrics.getAscent() - metrics.getDescent();
                        if(k>titleBar.width / col){

                        }
                        int m = rows;
                        int p = col;
                        if (m != 2) {
                            m = m + 1;
                        } else {
                            m = rows;
                        }
                        cell_height = ((constants.HEIGHT) - (constants.HEIGHT / 25 + 4) - (6 * rows)) / rows;
                        cell = new Cell(x, y, titleBar.width / col, cell_height, stroke, cell_color, stroke_color, input);
                        cell.paint(g);
                        int Stroke = cell.Stroke;
                        x += constants.WIDTH / col;
                    }
                    y = y + ((constants.HEIGHT) - (constants.HEIGHT / 25 + 4) - (6 * rows)) / rows;
                }
                System.out.println(Arrays.deepToString(data));
            }
            //cathces the exceptions.

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
