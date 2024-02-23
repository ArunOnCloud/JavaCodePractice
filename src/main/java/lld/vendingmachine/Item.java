package lld.vendingmachine;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of ={"id"})
public class Item {

    private String id;
    private String type;
    private String name;

}
