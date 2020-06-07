package creational.patterns.prototype;

import java.math.BigDecimal;

public abstract class Player implements Cloneable {

    private Integer posY;

    private Integer posX;

    private Boolean terrorist;

    private BigDecimal money;

    public Integer getPosY() {
        return posY;
    }

    public void setPosY(Integer posY) {
        this.posY = posY;
    }

    public Integer getPosX() {
        return posX;
    }

    public void setPosX(Integer posX) {
        this.posX = posX;
    }

    public Boolean getTerrorist() {
        return terrorist;
    }

    public void setTerrorist(Boolean terrorist) {
        this.terrorist = terrorist;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public abstract void printName();

    public Player clone() {

        try {
            return (Player) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return null;
    }

}
