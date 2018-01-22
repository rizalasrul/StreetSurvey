package dishub.streetsurvey;

/**
 * Created by 4741G on 08/10/2017.
 */

public class Items {
    private String namaBtn;
    private String item_new;
    private String title;

    public Items(String s) {

    }

    public Items(String namaBtn, String title) {
        this.namaBtn = namaBtn;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getnamaBtn() {
        return namaBtn;
    }

    public void setnamaBtn(String namaBtn) {
        this.namaBtn = namaBtn;
    }

    public String getItem_new() {
        return item_new;
    }

    public void setItem_new(String item_new) {
        this.item_new = item_new;
    }
}
