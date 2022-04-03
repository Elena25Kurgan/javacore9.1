public class FactsCats {
    private String id;
    private String text;
    private String type;
    private String user;
    private int upvotes;

    public FactsCats(String id, String text, String type, String user, int upvotes) {
        this.id = id;
        this.text = text;
        this.type = type;
        this.user = user;
        this.upvotes = upvotes;
    }

    public FactsCats() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setUpvotes(int upvotes) {
        this.upvotes =upvotes;
    }

    public void setUpvotes(String upvotes) {
        if (!(upvotes == null)) {
            this.upvotes = Integer.getInteger(upvotes);
        } else {
            this.upvotes = 0;
        }
    }

    public int getUpvotes() {
        return upvotes;
    }

    public String getUpvotes1() {
        return Integer.toString(upvotes);
    }

    @Override
    public String toString() {
        return  "id: " + id + "\n" +
                "text: " + text + "\n" +
                "type: " + type + "\n" +
                "user: " + user + "\n" +
                "upvotes: " + upvotes + "\n";
    }
}
