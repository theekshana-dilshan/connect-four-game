package lk.ijse.dep.service;

import javax.swing.border.Border;

public interface BoardUI{
    void update(int col, boolean isHuman);
    void notifyWinner(Winner winner);

}