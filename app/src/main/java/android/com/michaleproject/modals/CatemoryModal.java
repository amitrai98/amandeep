package android.com.michaleproject.modals;

/**
 * Created by amitrai on 17/3/16.
 */
public class CatemoryModal {

    private String txt_name;
    private int img_source;

    public CatemoryModal(String txt_name, int img_source){
        this.txt_name = txt_name;
        this.img_source = img_source;
    }

    public String getTxt_name() {
        return txt_name;
    }

    public void setTxt_name(String txt_name) {
        this.txt_name = txt_name;
    }

    public int getImg_source() {
        return img_source;
    }

    public void setImg_source(int img_source) {
        this.img_source = img_source;
    }
}
