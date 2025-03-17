
import java.util.Scanner;

public class YiXingShop {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ItemList itemList = new ItemList(10); // Khởi tạo với 5 sản phẩm ngẫu nhiên

        // Màn hình welcome
        System.out.println("Welcome to Yixing Shop!");
        while (true) {
            // Hiển thị menu
            System.out.println("\nMenu:");
            System.out.println("1. Add a new TeaPot");
            System.out.println("2. Add a new Rod");
            System.out.println("3. List all items in the shop");
            System.out.println("4. Sort items by price (descending)");
            System.out.println("5. Sort items by name (ascending)");
            System.out.println("6. Search items by author");
            System.out.println("7. Update item by ID");
            System.out.println("8. Load data from file");
            System.out.println("9. Save data to file");
            System.out.println("10. Exit");
            System.out.print("Enter your choice (1-10): ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1: // Thêm mới TeaPot
                    TeaPot teaPot = new TeaPot();
                    teaPot.input();
                    itemList.addItem(teaPot);
                    break;

                case 2: // Thêm mới Rod
                    Rod rod = new Rod();
                    rod.input();
                    itemList.addItem(rod);
                    break;

                case 3: // Liệt kê tất cả hàng hóa
                    System.out.println("All items in the shop:");
                    for (Item item : itemList) {
                        item.output();
                    }
                    break;

                case 4: // Sắp xếp theo giá giảm dần
                    itemList.sortItemsByPrice();
                    break;

                case 5: // Sắp xếp theo tên tăng dần
                    itemList.sortItemsByName();
                    break;

                case 6: // Tìm kiếm theo nghệ nhân/nhà máy
                    System.out.print("Enter author name to search: ");
                    String author = scanner.nextLine();
                    System.out.println("Search results for author '" + author + "':");
                    for (Item item : itemList.searchByAuthor(author)) {
                        item.output();
                    }
                    break;

                case 7: // Cập nhật sản phẩm theo ID
                    System.out.print("Enter item ID to update: ");
                    String id = scanner.nextLine();
                    itemList.updateItemById(id);
                    break;

                case 8: // Nạp dữ liệu từ file
//                    System.out.print("Enter file name to load data from: ");
//                    String loadFile = scanner.nextLine();
//                    itemList.loadDataFromFile(loadFile);
//                    break;
//
//                case 9: // Ghi dữ liệu ra file
//                    System.out.print("Enter file name to save data to: ");
//                    String saveFile = scanner.nextLine();
//                    itemList.saveDataToFile(saveFile);
//                    break;
//
//                case 10: // Thoát chương trình
//                    System.out.println("Goodbye!");
//                    scanner.close();
//                    return;

                default:
                    System.out.println("Invalid choice! Please choose between 1 and 10.");
            }
        }
    }
}
