public class EX_02_override {
    private String title;
    private String author;

    public EX_02_override(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Overriding the method to include all members
    @Override
    public String toString() {
        // Concatenating both string members and adding descriptive labels
        return "EX_02_overrideObjectString [Title=" + title + ", Author=" + author + "]";
    }

    public static void main(String[] args) {
        // In the main method:
        EX_02_override myEX_02_override = new EX_02_override("The Martian", "Andy Weir");
        System.out.println(myEX_02_override); // Calls the custom EX_02_override.toString()

}

}
