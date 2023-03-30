class Hero{
    //Attribute
    private String name;
    private double hp;
    private double atk;
    private double def;
    private double luck;
    //Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setHp(double hp) {
        this.hp = hp;
    }
    public void setAtk(double atk) {
        this.atk = atk;
    }
    public void setDef(double def) {
        this.def = def;
    }
    public void setLuck() {
        this.luck = 0.8+(Math.random()*0.2);
    }

    //Constructors
    public Hero(){
        
    }

    public Hero(String name, double hp, double atk, double def){
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.luck = 0.8+(Math.random()*0.2);
    }
    //Getters
    public String getName(){
        return name;
    }
    public double getHp() {
        return hp;
    }
    public double getAtk() {
        return atk;
    }
    public double getDef() {
        return def;
    }
    public double getLuck() {
        return luck;
    }
    
}
