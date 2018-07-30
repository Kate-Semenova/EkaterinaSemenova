package hw3.enums;

/**
 * Created by Ekaterina on 28.07.2018.
 */
public enum BenefitTexts {
    FIRST("To include good practices\nand ideas from successful\nEPAM project"),

    SECOND("To be flexible and\ncustomizable"),

    THIRD("To be multiplatform"),

    FOURTH("Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

    public final String text;

    BenefitTexts(String text) {
        this.text = text;
    }
}
