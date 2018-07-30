package hw6.enums;

/**
 * Created by Ekaterina on 05.07.2018.
 */
// TODO Code convention ?
public enum Table {

    NUMBER(0), TYPE(1), USER(2), DESCIPTION(3);

    public int index;

    Table(int index) {
        this.index = index;
    }
}
