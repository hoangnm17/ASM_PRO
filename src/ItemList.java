
import java.util.*;

public class ItemList extends ArrayList<Item> {

    private static final Random rand = new Random();

    // Danh sách dữ liệu để sinh ngẫu nhiên cho TeaPot
    private static final String[] TEA_POT_NAMES = {
        "Tây Thi", "Thạch Biều", "Hán Ngoã", "Trúc Đoạn", "Cân Văn", "Đề Lương", "Cung Đăng",
        "Liên Tử", "Tứ Phương", "Tần Quyền", "Đức Chung"
    };
    private static final String[] TEA_POT_CATEGORIES = {"Đất", "Sứ", "Thủy tinh", "Pha lê", "Sắt", "Bạc"};
    private static final String[] TEA_POT_MATERIALS = {
        "Đất tử sa TỬ NÊ", "Đất tử sa CHU NÊ", "Đất tử sa ĐOÀN NÊ", "Đất tử sa ĐẠI HỒNG BÀO",
        "Đất tử sa HẮC LONG NÊ", "Đất tử sa LỤC NÊ", "Đất tử sa THIÊN THANH NÊ",
        "Sứ BÁT TRÀNG", "Sứ NHẬT", "Sứ CẢNH ĐỨC TRẤN", "Pha lê TÀU", "Pha lê TIỆP", "Pha lê PHÁP"
    };
    private static final String[] TEA_TYPES = {"trà ô long", "trà phổ nhĩ", "trà xanh", "trà đen", "trà trắng"};

    // Danh sách dữ liệu để sinh ngẫu nhiên cho Rod
    private static final String[] ROD_NAMES = {"Shimano", "Daiwa", "Abu Garcia", "Okuma", "Penn", "Quantum"};
    private static final String[] ROD_CATEGORIES = {"Cần câu Spinning", "Cần câu Baitcasting", "Cần câu Telescopic", "Cần câu Fly"};
    private static final String[] ROD_MATERIALS = {"Carbon Fiber", "Graphite", "Fiberglass", "Composite"};
    private static final String[] FISH_TYPES = {"cá rô", "cá chép", "cá lóc", "cá trê", "cá tầm"};

    // Danh sách chung
    private static final String[] IMAGE_URLS = {
        "https://www.facebook.com/photo.php?fbid=122126511584609325",
        "https://www.facebook.com/photo.php?fbid=122126308736609325",
        "https://www.facebook.com/photo.php?fbid=122123544086609325",
        "https://www.facebook.com/photo.php?fbid=122123028086609325",
        "https://www.facebook.com/photo.php?fbid=122122592168609325",
        "https://www.facebook.com/photo.php?fbid=122122193306609325",
        "https://www.facebook.com/photo/?fbid=122105930588609325",
        "https://www.facebook.com/photo/?fbid=122105930492609325",
        "https://www.facebook.com/photo/?fbid=122105926946609325"
    };
    private static final String[] AWARD_TEMPLATES = {
        "Giải Nhất cấp tỉnh Nghi Hưng năm %d",
        "Giải Nhì cuộc thi ấm trà đẹp quốc gia Trung Hoa năm %d",
        "Giải vô địch cuộc thi ấm trà đẹp quốc tế tổ chức tại Hà Lan năm %d",
        "Giải thưởng thiết kế sáng tạo tại Nhật Bản năm %d",
        "Giải xuất sắc triển lãm trà đạo Trung Quốc năm %d",
        "Giải thưởng thiết kế cần câu quốc tế năm %d"
    };

    // Hàm khởi tạo: Sinh ngẫu nhiên m sản phẩm (TeaPot hoặc Rod)
    public ItemList(int m) {
        for (int i = 0; i < m; i++) {
            // Chọn ngẫu nhiên giữa TeaPot và Rod (50/50)
            if (rand.nextBoolean()) {
                // Sinh ngẫu nhiên TeaPot
                String name = TEA_POT_NAMES[rand.nextInt(TEA_POT_NAMES.length)];
                String category = TEA_POT_CATEGORIES[rand.nextInt(TEA_POT_CATEGORIES.length)];
                String material = TEA_POT_MATERIALS[rand.nextInt(TEA_POT_MATERIALS.length)];
                double volume = 100 + rand.nextDouble() * 200; // 100ml - 300ml
                double inPrice = 1_000_000 + rand.nextDouble() * 9_000_000; // 1 triệu - 10 triệu VNĐ
                double price = 10_000_000 + rand.nextDouble() * 9_990_000_000L; // 10 triệu - 10 tỷ VNĐ

                // Sinh ngẫu nhiên danh sách tác giả (1-8 tác giả)
                List<String> authorIds = new ArrayList<>();
                int numAuthors = 1 + rand.nextInt(8); // 1-8 tác giả
                for (int j = 0; j < numAuthors; j++) {
                    authorIds.add("Nghệ nhân " + (char) ('A' + j));
                }

                // Sinh ngẫu nhiên giải thưởng (0-3 giải)
                List<String> awards = new ArrayList<>();
                int numAwards = rand.nextInt(4); // 0-3 giải thưởng
                for (int j = 0; j < numAwards; j++) {
                    String awardTemplate = AWARD_TEMPLATES[rand.nextInt(5)]; // Chỉ dùng 5 mẫu đầu cho TeaPot
                    int year = 2015 + rand.nextInt(10); // 2015-2024
                    awards.add(String.format(awardTemplate, year));
                }

                // Sinh ngẫu nhiên hình ảnh (1-3 ảnh)
                List<String> images = new ArrayList<>();
                int numImages = 1 + rand.nextInt(3); // 1-3 ảnh
                for (int j = 0; j < numImages; j++) {
                    images.add(IMAGE_URLS[rand.nextInt(IMAGE_URLS.length)]);
                }

                // Sinh ngẫu nhiên mô tả
                String teaType = TEA_TYPES[rand.nextInt(TEA_TYPES.length)];
                String color = getColorForMaterial(material);
                String desc = String.format(
                        "Ấm trà %s chế tác từ %s, màu %s độc đáo. Hình dáng tinh tế, dung tích %.0fml, "
                        + "phù hợp pha %s. Vòi nước chảy êm, nắp đậy kín, giữ nhiệt tốt, tôn lên hương vị trà đậm đà.",
                        name, material, color, volume, teaType
                );

                // Tạo và thêm TeaPot
                TeaPot teaPot = new TeaPot(
                        "TP" + (i + 1), // ID
                        "Ấm " + name, // Name
                        category, // Category
                        material, // Material
                        inPrice, // InPrice
                        price, // Price
                        volume, // Volume
                        authorIds, // AuthorIds
                        2015 + rand.nextInt(10), // YearOfRelease
                        awards, // Awards
                        images, // Images
                        desc // Description
                );
                this.add(teaPot);
            } else {
                // Sinh ngẫu nhiên Rod
                String name = ROD_NAMES[rand.nextInt(ROD_NAMES.length)];
                String category = ROD_CATEGORIES[rand.nextInt(ROD_CATEGORIES.length)];
                String material = ROD_MATERIALS[rand.nextInt(ROD_MATERIALS.length)];
                double length = 1.5 + rand.nextDouble() * 2.0; // 1.5m - 3.5m
                double inPrice = 500_000 + rand.nextDouble() * 4_500_000; // 500k - 5 triệu VNĐ
                double price = 1_000_000 + rand.nextDouble() * 49_000_000; // 1 triệu - 50 triệu VNĐ

                // Sinh ngẫu nhiên danh sách tác giả (1-5 tác giả)
                List<String> authorIds = new ArrayList<>();
                int numAuthors = 1 + rand.nextInt(5); // 1-5 tác giả
                for (int j = 0; j < numAuthors; j++) {
                    authorIds.add("Nhà sản xuất " + (char) ('A' + j));
                }

                // Sinh ngẫu nhiên giải thưởng (0-2 giải)
                List<String> awards = new ArrayList<>();
                int numAwards = rand.nextInt(3); // 0-2 giải thưởng
                for (int j = 0; j < numAwards; j++) {
                    String awardTemplate = AWARD_TEMPLATES[5]; // Sử dụng mẫu cuối cho Rod
                    int year = 2015 + rand.nextInt(10); // 2015-2024
                    awards.add(String.format(awardTemplate, year));
                }

                // Sinh ngẫu nhiên hình ảnh (1-3 ảnh)
                List<String> images = new ArrayList<>();
                int numImages = 1 + rand.nextInt(3); // 1-3 ảnh
                for (int j = 0; j < numImages; j++) {
                    images.add(IMAGE_URLS[rand.nextInt(IMAGE_URLS.length)]);
                }

                // Sinh ngẫu nhiên mô tả
                String fishType = FISH_TYPES[rand.nextInt(FISH_TYPES.length)];
                String desc = String.format(
                        "Cần câu %s làm từ %s, nhẹ và bền bỉ. Chiều dài %.1fm, phù hợp câu %s. "
                        + "Thiết kế tinh tế, chịu lực tốt, mang lại trải nghiệm câu cá tuyệt vời.",
                        name, material, length, fishType
                );

                // Tạo và thêm Rod
                Rod rod = new Rod(
                        "RD" + (i + 1), // ID
                        name, // Name
                        category, // Category
                        material, // Material
                        inPrice, // InPrice
                        price, // Price
                        length, // Length
                        authorIds, // AuthorIds
                        2015 + rand.nextInt(10), // YearOfRelease
                        awards, // Awards
                        images, // Images
                        desc // Description
                );
                this.add(rod);
            }
        }
    }

    // Hàm hỗ trợ lấy màu sắc hoặc đặc điểm dựa trên vật liệu cho TeaPot
    private String getColorForMaterial(String material) {
        if (material.contains("TỬ NÊ")) {
            return "nâu tím sang trọng";
        }
        if (material.contains("CHU NÊ") || material.contains("ĐẠI HỒNG BÀO")) {
            return "đỏ gạch ấm áp";
        }
        if (material.contains("ĐOÀN NÊ")) {
            return "xám lục hiếm gặp";
        }
        if (material.contains("HẮC LONG NÊ")) {
            return "đen huyền bí";
        }
        if (material.contains("LỤC NÊ")) {
            return "xanh lục dịu mắt";
        }
        if (material.contains("THIÊN THANH NÊ")) {
            return "xanh thiên thanh mát mẻ";
        }
        if (material.contains("Sứ")) {
            return "trắng tinh khôi";
        }
        if (material.contains("Pha lê")) {
            return "trong suốt lấp lánh";
        }
        return "màu sắc độc đáo";
    }

    // Hàm bổ sung sản phẩm (TeaPot hoặc Rod)
    public void addItem(Item item) {
        this.add(item);
        System.out.println("Item added successfully: " + item.getName());
    }

    // Sắp xếp theo giá giảm dần
    public void sortItemsByPrice() {
        this.sort((item1, item2) -> Double.compare(item2.getPrice(), item1.getPrice()));
        System.out.println("Items sorted by price (descending).");
    }

    // Sắp xếp theo tên tăng dần (A-Z)
    public void sortItemsByName() {
        this.sort((item1, item2) -> item1.getName().compareTo(item2.getName()));
        System.out.println("Items sorted by name (ascending).");
    }

    // Tìm kiếm sản phẩm theo tên nghệ nhân/nhà máy sản xuất
    public List<Item> searchByAuthor(String author) {
        List<Item> result = new ArrayList<>();
        for (Item item : this) {
            if (item.getAuthorIds().contains(author)) {
                result.add(item);
            }
        }
        return result;
    }

    // Cập nhật thông tin sản phẩm theo ID
    public boolean updateItemById(String id) {
        for (Item item : this) {
            if (item.getId().equalsIgnoreCase(id)) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter new Name: ");
                item.setName(scanner.nextLine());
                System.out.print("Enter new Material: ");
                item.setMaterial(scanner.nextLine());
                System.out.print("Enter new In Price: ");
                item.setInPrice(Double.parseDouble(scanner.nextLine()));
                System.out.print("Enter new Price: ");
                item.setPrice(Double.parseDouble(scanner.nextLine()));
                List<String> newAuthorIds = new ArrayList<>();
                System.out.println("Enter number of new Authors: ");
                int numAuthors = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < numAuthors; i++) {
                    System.out.println("Enter new AuthorId " + (i + 1) + ": ");
                    newAuthorIds.add(scanner.nextLine());
                }
                item.setAuthorIds(newAuthorIds);
                System.out.print("Enter new Year of Release: ");
                item.setYearOfRelease(Integer.parseInt(scanner.nextLine()));
                System.out.print("Enter new Description: ");
                item.setDesc(scanner.nextLine());

                if (item instanceof TeaPot) {
                    System.out.print("Enter new Volume: ");
                    ((TeaPot) item).setVolume(Double.parseDouble(scanner.nextLine()));
                } else if (item instanceof Rod) {
                    System.out.print("Enter new Length: ");
                    ((Rod) item).setLength(Double.parseDouble(scanner.nextLine()));
                }
                System.out.println("Item updated successfully.");
                return true;
            }
        }
        System.out.println("Item with ID " + id + " not found.");
        return false;
    }

}
