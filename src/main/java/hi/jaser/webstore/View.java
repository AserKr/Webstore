package hi.jaser.webstore;


public enum View {
    VIDSKIPTAVINUR("vidskiptavinur-view.fxml"),
    PONTUN("pontun-view.fxml"),
    PHONES("phones-view.fxml"),
    TABLETS("tablets-view.fxml"),
    LAPTOPS("laptops-view.fxml"),
    ACCESSORIES("accessories-view.fxml"),
    HOMEDELIVERY("homedelivery-view.fxml"),

    JOB("job-view.fxml"),

    CART("greidsla-view.fxml"),

    DELIVERYMETHOD("deliverymethod-view.fxml");

    private final String fileName;
    View(String fileName) {
        this.fileName = fileName;
    }
    public String getFileName() {
        return fileName;
    }
}
