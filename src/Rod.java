
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rod extends Item {

    private double length;

    public Rod() {
    }

    public Rod(String id, String name, String category, String material, double inPrice, double price, double length, List<String> AuthorIds, int yearOfRelease, List<String> awards, List<String> images, String desc) {
        super(id, name, category, material, inPrice, price, AuthorIds, yearOfRelease, awards, images, desc);
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
   
    @Override
    public String toString() {
        return this.getClass().getName() + "[ID: " + getId() + ", Name: " + getName() + ", Category: " + getCategory()
                + ", Material: " + getMaterial() + ", InPrice: " + getInPrice() + ", Price: " + getPrice()
                + ", Length: " + length + ", AuthorIds: " + getAuthorIds() + ", YearOfRelease: " + getYearOfRelease()
                + ", Awards: " + getAwards() + ", Images: " + getImages() + ", Description: " + getDesc() + "]";
    }

    @Override
    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ID: ");
        id = scanner.nextLine();
        System.out.print("Enter Name: ");
        name = scanner.nextLine();
        System.out.print("Enter Category: ");
        category = scanner.nextLine();
        System.out.print("Enter Material: ");
        material = scanner.nextLine();
        System.out.print("Enter In Price: ");
        inPrice = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter Price: ");
        price = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter Length: ");
        length = Double.parseDouble(scanner.nextLine());
        AuthorIds = new ArrayList<>();
        System.out.print("Enter number of Author: ");
        int numAuthors = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numAuthors; i++) {
            System.out.print("Enter AuthorId: " + (i + 1) + ": ");
            AuthorIds.add(scanner.nextLine());
        }
        System.out.print("Enter Year of Release: ");
        yearOfRelease = Integer.parseInt(scanner.nextLine());
        awards = new ArrayList<>();
        System.out.print("Enter number of awards: ");
        int numAwards = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numAwards; i++) {
            System.out.print("Enter award " + (i + 1) + ": ");
            awards.add(scanner.nextLine());
        }
        images = new ArrayList<>();
        System.out.print("Enter number of images: ");
        int numImages = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numImages; i++) {
            System.out.print("Enter image URL " + (i + 1) + ": ");
            images.add(scanner.nextLine());
        }
        System.out.print("Enter Description: ");
        desc = scanner.nextLine();
    }

    @Override
    public void output() {
        System.out.println(this);
    }

}
