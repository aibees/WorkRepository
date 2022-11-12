package com.finance.pay.ui.common;

import javax.swing.*;
import java.awt.*;

public class CommonComponents {

    public JLabel createFooter(String text) {
        JLabel footer = new JLabel(text);
        footer.setHorizontalAlignment(SwingConstants.CENTER);
        footer.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
        footer.setOpaque(true);
        footer.setForeground(Color.WHITE);
        footer.setBackground(new Color(45, 180, 0));

        return footer;
    }
}
