package uniapp.utils;

import java.awt.Color;
import java.awt.Component;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

public class CustomColors extends DefaultListCellRenderer {

    // Store the indexes as a Set for fast lookup
    private final Set<Integer> highlightedIndexes;

    public CustomColors(List<Integer> indexesToHighlight) {
        highlightedIndexes = new HashSet<>();
        for (int index : indexesToHighlight) {
            highlightedIndexes.add(index);
        }
    }

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        // If the current index is in the highlightedIndexes set, change color
        if (highlightedIndexes.contains(index)) {
            // Change text color RGB
            component.setBackground(new Color(255, 100, 100));
        }
        return component;
    }
}
