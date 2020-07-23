package com.javarush.task.task23.task2312;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    private List<SnakeSection> sections;
    private boolean isAlive;
    private SnakeDirection direction;

    public List<SnakeSection> getSections() {
        return sections;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public Snake(int x, int y) {
        SnakeSection snakeSectionHead = new SnakeSection(x, y);
        sections = new ArrayList<>();
        sections.add(snakeSectionHead);
        isAlive = true;
    }

    int getX(){
        return getSections().get(0).getX();
    }
    int getY(){
        return getSections().get(0).getY();
    }

    void move(){
        if (isAlive == false) return;

//        switch (getDirection()) {
        switch (direction) {
            case UP: move(0, -1);
            case RIGHT: move(1, 0);
            case DOWN: move(0, 1);
            case LEFT: move(-1, 0);
        }
    }

    void move(int dx, int dy){
        SnakeSection newSnakeSection = new SnakeSection(sections.get(0).getX() + dx, sections.get(0).getY() + dy);
        checkBody(newSnakeSection);
        checkBorders(newSnakeSection);

        if (isAlive) {
            sections.add(0, newSnakeSection);

            Mouse mouse = Room.game.getMouse();

            if (mouse.getX() == newSnakeSection.getX() && mouse.getY() == newSnakeSection.getY()) {
                Room.game.eatMouse();
            } else {
                sections.remove(sections.size() - 1);
            }
        }


    }

    void checkBorders(SnakeSection head){
        if(head.getX() < 0 || head.getX() >= Room.game.getWidth() ||
        head.getY() < 0 || head.getY() >= Room.game.getHeight()){
            isAlive = false;
        }
    }

    void checkBody(SnakeSection head){
        if(sections.contains(head)) {
            isAlive = false;
        }

    }

}
