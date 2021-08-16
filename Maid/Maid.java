public class Maid {

    protected String name;
    double zp;

    Maid(String name, double zp){
        this.name= name;
        this.zp=zp;
    }

    public String name() {
        return name;
    }

    String getZp() {
        return Double.toString(zp)+"руб.";
    }


}
