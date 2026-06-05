package DairyManagement;

public class CowBean {

    private int id;
    private String category;
    private String color;
    private String weight;
    private String batch;
    private String milkQuantity;
    private String pregnancyPeriod;
    private byte[] photo;

    public CowBean(int id, String category, String color, String weight,
                   String batch, String milkQuantity, String pregnancyPeriod, byte[] photo) {
        this.id = id;
        this.category = category;
        this.color = color;
        this.weight = weight;
        this.batch = batch;
        this.milkQuantity = milkQuantity;
        this.pregnancyPeriod = pregnancyPeriod;
        this.photo = photo;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getMilkQuantity() {
        return milkQuantity;
    }

    public void setMilkQuantity(String milkQuantity) {
        this.milkQuantity = milkQuantity;
    }

    public String getPregnancyPeriod() {
        return pregnancyPeriod;
    }

    public void setPregnancyPeriod(String pregnancyPeriod) {
        this.pregnancyPeriod = pregnancyPeriod;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
