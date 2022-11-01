package com.finance.pay.ui.custom;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class MilestoneRenderer extends DefaultTableCellRenderer {

    public Component colorSetComponent(JTable table, int row, int col, Color color) {
        Component c = this.getTableCellRendererComponent(table, null, false, false, row, col);
        c.setBackground(color);
        return c;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}
