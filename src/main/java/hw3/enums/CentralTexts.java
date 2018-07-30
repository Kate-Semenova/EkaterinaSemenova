package hw3.enums;

/**
 * Created by Ekaterina on 28.07.2018.
 */
public enum CentralTexts {
    FIRST("EPAM FRAMEWORK WISHES…"),
    SECOND("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, " +
            "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. " +
            "UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS " +
            "NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN " +
            "REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR."
    ),
    THIRD("JDI GITHUB");

    public final String text;

    CentralTexts(String text) {
        this.text = text;
    }
}
