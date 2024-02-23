package lld.games.chess.board;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Place {
    private int row;
    private int col;
    private Color color;
}
