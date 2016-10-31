package by.pvt.dumping.utils;

import by.pvt.dumping.constants.Parameters;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Component
public class MenuHelper {

    public MenuHelper() {}

    public List<Integer> createStringMenu(Map<String, Integer> paginationParams) {

        List<Integer> menuItems = new ArrayList<>();
        int maxMenuSize = 11;
        int selected = paginationParams.get(Parameters.SELECTED_PAGE);
        int quantity = paginationParams.get(Parameters.QUANTITY_PER_PAGE);
        int count = paginationParams.get(Parameters.TOTAL_PAGES_QUANTITY);

        int pages = count /quantity;
        int currentMenuSize;

        if (count%quantity == 0) {
            currentMenuSize = pages;
        } else {
            currentMenuSize = pages + 1;
        }

        if (currentMenuSize <= maxMenuSize) {
            for (int i = 1; i <= currentMenuSize; i++ ) {
                menuItems.add(i);
            }
        } else {
            if (selected <= 5) {
                for (int i = 1; i <= maxMenuSize-1; i++ ) {
                    menuItems.add(i);
                }
                menuItems.add(currentMenuSize);
            } else if (selected >= currentMenuSize - 4) {
                menuItems.add(1);
                for (int j = currentMenuSize - (maxMenuSize - 2) ; j <= currentMenuSize; j++ ) {
                    menuItems.add(j);
                }
            } else {
                menuItems.add(1);
                for (int i = selected - 4; i <= selected + 4; i++ ) {
                    menuItems.add(i);
                }
                menuItems.add(currentMenuSize);
            }
        }

        return menuItems;
    }

}
