package Data_Table;

import java.awt.*;

public class Title_bar extends Cell {
    private int x;
    private int y;
    private Color button_color;

    /**
     * constuctor
     * @param x
     * @param y
     * @param width
     * @param height
     * @param stroke
     * @param cell_color
     * @param stroke_color
     * @param text
     * @param button_color
     */
    public Title_bar(int x, int y, int width, int height, int stroke, Color cell_color, Color stroke_color, String text, Color button_color) {
        super(x, y, width, height, stroke, cell_color, stroke_color, text);
        this.x = x;
        this.y = y;
        this.button_color = button_color;
    }

    /**
     * this functio has all the config for title bar
     * @param g
     */
    public void paint(Graphics g) {
        Constants constants = new Constants();
        g.setColor(cell_color);
        g.drawRect(this.x, this.y, this.width, this.height);
        g.fillRect(topleft.x + Stroke, topleft.y + Stroke, this.width, this.height);
        g.setColor(button_color);
        g.drawRect(this.width - (this.width / 12), this.height / 3, width / 50, width / 50);
        g.setColor(button_color);
        g.fillRect(this.width - (this.width / 12), this.height / 3, width / 50, width / 50);
        FontMetrics metrics = g.getFontMetrics();
        this.fontsize = this.height;
        Font font = new Font("Arial", fontstyle, fontsize);
        g.setFont(font);
        int textHeight = metrics.getAscent() - metrics.getDescent();
        g.drawString(text, 5, (this.height / 2) + 4 * Stroke);
    }
}
