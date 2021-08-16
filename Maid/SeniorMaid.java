public class SeniorMaid extends Maid {
    private int people = 0;

    SeniorMaid(String name, double zp, int people) {
        super(name, zp);
        this.people = people;
    }

    @Override
    public String name() {
        return name;
    }


    @Override
    String getZp() {
        return Double.toString(zp+(people*1000)) + "руб.";
    }


}
