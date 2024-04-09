package coffee_bin;

public abstract class Coffee {
    private String name;
    private int amount;
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setQuantity(int amount){
        this.amount = amount;
    }
    public int getQuantity(){
        return amount;
    }

}
