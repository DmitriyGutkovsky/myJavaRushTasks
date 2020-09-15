package com.javarush.task.task32.task3209.actions;

import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;
import java.awt.font.TextAttribute;

//будет отвечать за стиль "Надстрочный знак"
public class SuperscriptAction extends StyledEditorKit.StyledTextAction {
    /**
     * Creates a new StyledTextAction from a string action name.
     *
     * @param nm the name of the action
     */
    public SuperscriptAction(String nm) {
        super(nm);
    }

    public SuperscriptAction() {
        super(TextAttribute.SUPERSCRIPT.toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
