package com.codecool.dungeoncrawl.logic;

public enum CellType {
    EMPTY("empty", false),
    FLOOR("floor", true),
    WALL("wall", false),
    SKULL("skull", true),
    SCORPIO("scorpio", true),
    TEQUILA("tequila", true),
    RED_HOUSE1("redHouse1", false),
    RED_HOUSE2("redHouse2", false),
    RED_HOUSE3("redHouse3", false),
    RED_HOUSE4("redHouse4", false),
    CHURCH_TOP("churchTop1", false),
    CHURCH_TOP2("churchTop2", false),
    CHURCH_HOUSE("churchHouse", false),
    TOMB_STONE("tombStone", false),
    SKULL1("skull1", false),
    SKULL2("skull2", false),
    DOOR("door", false),
    CLOSED_DOOR("closedDoor", false),
    TOWN_ROAD("town_road", true),
    HOUSE_ROOF_LEFT("house_roof_left", false),
    HOUSE_ROOF_STRAIGHT("house_roof_straight", false),
    HOUSE_ROOF_RIGHT("house_roof_right", false),
    HOUSE_WINDOW_1("house_window_1", false),
    HOUSE_WINDOW_2("house_window_2", false),
    HOUSE_WALL("house_wall", false),
    HOUSE_BASE_LEFT("house_base_left", false),
    HOUSE_BASE_CENTER("house_base_center", false),
    HOUSE_BASE_RIGHT("house_base_right", false),
    HOUSE_DOOR("house_door", false),
    S("S", false),
    A("A", false),
    L("L", false),
    O("O", false),
    N("N", false),
    G("G", false),
    U("U", false),
    SALOON_DOOR("saloon_door", false),
    HORSE("horse", false),
    SKY("sky", false),
    CHURCHTOP2("churchTopMap2", false),
    SALOONFLOOR("saloonFloor", true),
    BARLEFTTOP("barLeftTop", false),
    BARLEFTDOWN("barLeftDown", false),
    BARCENTERTOP("barCenterTop", false),
    BARCENTERDOWN("barCenterDown", false),
    BARRIGHTTOP("barRightTop", false),
    BARRIGHTDOWN("barRightDown", false),
    BARLEG("barLeg", false),
    DRINK1("drink1", false),
    DRINK2("drink2", false),
    DRINK3("drink3", false),
    BARMAN("barMan", false),
    SALOONWALL("saloonWall", false),
    TEQUILA2("tequila2", true),
    TEQUILA3("tequila3", true);




    private final String tileName;
    private final boolean canStepOn;

    CellType(String tileName, boolean canStepOn) {
        this.tileName = tileName;
        this.canStepOn = canStepOn;
    }

    public boolean getCanStepOn() {
        return canStepOn;
    }

    public String getTileName() {
        return tileName;
    }
}
