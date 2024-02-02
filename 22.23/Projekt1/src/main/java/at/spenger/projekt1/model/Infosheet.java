package at.spenger.projekt1.model;

public class Infosheet {
    private String curItem;
    private boolean stones;
    private boolean stickFire;
    private boolean stickSpeer;
    private boolean fish;
    private boolean speerComplete;
    private int firePlaceStatus;
    private int freeItem;
    private int stonePos;
    private int speerPos;
    private int stickFirePos;
    private int fishPos;




    public Infosheet(){
        curItem="";
        stones=false;
        stickFire=false;
        stickSpeer=false;
        fish=false;
        speerComplete=false;
        firePlaceStatus=0;
        freeItem=1;
    }

    public boolean isStones() {
        return stones;
    }

    public void tookStones() {
        stones=true;
    }

    public boolean isStickFire() {
        return stickFire;
    }

    public void tookStickFire() {
        stickFire=true;
    }

    public boolean isStickSpeer() {
        return stickSpeer;
    }

    public void tookStickSpeer() {
        stickSpeer=true;
    }


    public boolean isFish() {
        return fish;
    }

    public void tookFish() {
        fish=true;
    }

    public boolean isSpeerComplete() {
        return speerComplete;
    }

    public void speerCompletion() {
        speerComplete=true;
    }

    public int getFirePlaceStatus() {
        return firePlaceStatus;
    }

    public void firePlaceStatusInc() {
        firePlaceStatus++;
    }

    public int getStonePos() {
        return stonePos;
    }

    public void setStonePos(int stonePos) {
        this.stonePos = stonePos;
    }

    public int getSpeerPos() {
        return speerPos;
    }

    public void setSpeerPos(int speerPos) {
        this.speerPos = speerPos;
    }

    public int getStickFirePos() {
        return stickFirePos;
    }

    public void setStickFirePos(int stickFirePos) {
        this.stickFirePos = stickFirePos;
    }

    public int getFishPos() {
        return fishPos;
    }

    public void setFishPos(int fishPos) {
        this.fishPos = fishPos;
    }

    public int getFreeItem() {
        return freeItem;
    }

    public void freeItemUp() {
        freeItem++;
    }

    public String getCurItem() {
        return curItem;
    }
    public void setCurItem(String curItem) {
        this.curItem = curItem;
    }
}
