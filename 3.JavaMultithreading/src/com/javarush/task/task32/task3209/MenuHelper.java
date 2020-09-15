package com.javarush.task.task32.task3209;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MenuHelper {


    public static JMenuItem addMenuItem(JMenu parent, String text, ActionListener actionListener) {
        JMenuItem menuItem = new JMenuItem(text);
        menuItem.addActionListener(actionListener);
        parent.add(menuItem);
        return menuItem;
    }

    public static JMenuItem addMenuItem(JMenu parent, Action action) {
        JMenuItem item = new JMenuItem(action);
        parent.add(item);
        return item;
    }

    public static JMenuItem addMenuItem(JMenu parent, String text, Action action) {
        JMenuItem item = addMenuItem(parent, action);
        item.setText(text);
        parent.add(item);
        return item;
    }

    //инициализация меню помощи
    public static void initHelpMenu(View view, JMenuBar menuBar) {

    }

    //инициализация меню выбора шрифта
    public static void initFontMenu(View view, JMenuBar menuBar) {

    }

    //инициализация меню выбора цвета
    public static void initColorMenu(View view, JMenuBar menuBar) {

    }

    //инициализация меню выравнивания
    public static void initAlignMenu(View view, JMenuBar menuBar) {

    }

    //инициализация меню выбора стиля текста
    public static void initStyleMenu(View view, JMenuBar menuBar) {

    }

    //инициализация меню редактирования текста
    public static void initEditMenu(View view, JMenuBar menuBar) {

    }

    //инициализация меню Файл
    public static void initFileMenu(View view, JMenuBar menuBar) {

    }
}
