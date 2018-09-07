package site.skylake.project_cs;

public class Item {
    private String mImageUrl;
    private String mname;
    private String mscore;
    private String mid;

    public Item(String ImageUrl, String name, String score, String id){
        mImageUrl = ImageUrl;
        mname = name;
        mscore = score;
        mid = id;

    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public String getMname() {
        return mname;
    }

    public String getmScore() {
        return mscore;
    }

    public String getMid() {
        return mid;
    }

}
