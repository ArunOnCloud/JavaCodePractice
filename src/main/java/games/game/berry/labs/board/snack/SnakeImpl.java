package games.game.berry.labs.board.snack;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SnakeImpl implements Snake{
    private int start;
    private int end;
}
