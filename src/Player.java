public class Player {
    
    // public class enum arma{
    //     faca,espada,cajado
    // }

    // 
    
    private int vida;
    private int forca;
    private int stamina;
    private int armadura;

    public Player(int vida, int forca, int stamina, int armadura){
        this.vida = vida;
        this.forca = forca;
        this.stamina = stamina;
        this.armadura = armadura;
    }

    public int getForca() {
        return forca;
    }
    public int getVida() {
        return vida;
    }
    public int getStamina() {
        return stamina;
    }
    public int getArmadura() {
        return armadura;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }
    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }
}