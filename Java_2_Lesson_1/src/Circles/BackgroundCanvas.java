package Circles;

import java.awt.*;
public class BackgroundCanvas {
    int r = (int)(Math.random() * 255);
    int gr = (int)(Math.random() * 255);
    int b = (int)(Math.random() * 255);
    int count = 0;
    Color color = new Color(r, gr, b);

    void updateColor(GameCanvas canvas) {
        if ( count == 0) {
            if (r < 255) {
                r++;
            } else {
                if (gr < 255) {
                    gr++;
                } else {
                    if (b < 255) {
                        b++;
                    } else {
                        count = 1;
                    }
                }
            }
        }

        if (count == 1) {
            if (r > 0) {
                r--;
            } else {
                if (gr > 0) {
                    gr--;
                } else {
                    if (b > 0) {
                        b--;
                    } else {
                        count = 0;
                    }
                }
            }
        }

        color = new Color (r, gr, b);
        canvas.setBackground(color);
    }


}
