package com.finance.util;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Constant {
    // border
    public static final Border BlackLineBorder = new LineBorder(Color.BLACK, 2);

    // color
    public static final Color BACKGROUND_COLOR = new Color(230, 230, 230);
    public static final Color DISABLED_COLOR = new Color(205, 205, 205);

    // font
    public static final Font TEXTFIELD_FONT = new Font("맑은 고딕", Font.BOLD, 14);
    public static final Font BUTTON_FONT = new Font("Helvetica", Font.BOLD, 13);
    public static final Font LIST_FONT = new Font("Helvetica", Font.BOLD, 12);
    public static final Font DESC_FONT = new Font("Helvetica", Font.PLAIN, 12);
    public static final Font QUERY_FONT = new Font("Consolas", Font.BOLD, 12);
}
