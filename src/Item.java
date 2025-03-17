
import java.util.*;

public abstract class Item {

    protected String id;
    protected String name;
    protected String category;
    protected String material;
    protected double inPrice;
    protected double price;
    protected List<String> AuthorIds;
    protected int yearOfRelease;
    protected List<String> awards;
    protected List<String> images;
    protected String desc;

    public Item() {
    }

    public Item(String id, String name, String category, String material, double inPrice, double price, List<String> AuthorIds, int yearOfRelease, List<String> awards, List<String> images, String desc) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.material = material;
        this.inPrice = inPrice;
        this.price = price;
        this.AuthorIds = AuthorIds;
        this.yearOfRelease = yearOfRelease;
        this.awards = awards;
        this.images = images;
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getInPrice() {
        return inPrice;
    }

    public void setInPrice(double inPrice) {
        this.inPrice = inPrice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<String> getAuthorIds() {
        return AuthorIds;
    }

    public void setAuthorIds(List<String> AuthorIds) {
        this.AuthorIds = AuthorIds;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public List<String> getAwards() {
        return awards;
    }

    public void setAwards(List<String> awards) {
        this.awards = awards;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Category: " + category + ", Material: " + material
                + ", InPrice: " + inPrice + ", Price: " + price + ", AuthorIds: " + AuthorIds
                + ", Year: " + yearOfRelease + ", Awards: " + awards + ", Images: " + images + ", Desc: " + desc;
    }

    public abstract void input();

    public abstract void output();

}
