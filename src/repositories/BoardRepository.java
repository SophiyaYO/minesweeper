package repositories;

import model.Cell;

public interface BoardRepository {
    int getRolls();
    Cell[][] getBoard();

}
