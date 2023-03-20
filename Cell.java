package Data_Table;

import java.awt.*;

public class Cell {
    Point topleft;
    protected int width;
    protected int height;
    protected int Stroke;
    protected Color cell_color;
    protected Color stroke_color;
    protected String text;
    protected Font font;
    protected int fontsize;
    protected int fontstyle;
    public Color text_color;


    /**
     * constructor
     * @param x
     * @param y
     * @param width
     * @param height
     * @param stroke
     * @param cell_color
     * @param stroke_color
     * @param text
     */
    public Cell(int x,int y,int width, int height, int stroke, Color cell_color, Color stroke_color, String text) {
        topleft=new Point(x,y);
        this.width = width;
        this.height = height;
        Stroke = stroke;
        this.cell_color = cell_color;
        this.stroke_color = stroke_color;
        this.text = text;
    }

    /**
     * paint function
     * it has the config for individual cells and their fonts
     * @param g
     */
    public void paint(Graphics g) {
      
        g.setColor(stroke_color);
        g.fillRect(topleft.x, topleft.y, width, height);
        g.setColor(cell_color);
        g.fillRect(topleft.x + Stroke, topleft.y + Stroke, width - Stroke * 2, height - Stroke * 2);
        g.setColor(text_color);

        int font_size;
            this.fontsize = this.width / 5;
            font_size=this.fontsize;

        Font font = new Font("Arial", fontstyle, font_size);
        g.setFont(font);
        FontMetrics metrics = g.getFontMetrics();
        int textWidth = metrics.stringWidth(this.text);
        int textHeight = metrics.getAscent() - metrics.getDescent();

        g.setColor(Color.black);
        g.drawString(text, (this.topleft.x + (width / 2) - textWidth / 2), ((this.topleft.y + height / 2) + textHeight / 4));

    }
}
