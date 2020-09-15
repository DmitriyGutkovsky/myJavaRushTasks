package com.javarush.task.task32.task3209.actions;

import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;
import java.awt.font.TextAttribute;

//отвечает за стиль текста "Зачеркнутый"
public class StrikeThroughAction extends StyledEditorKit.StyledTextAction {
    /**
     * Creates a new StyledTextAction from a string action name.
     *
     * @param nm the name of the action
     */
    public StrikeThroughAction(String nm) {
        super(nm);
    }

    public StrikeThroughAction() {
        super(TextAttribute.STRIKETHROUGH.toString());

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
