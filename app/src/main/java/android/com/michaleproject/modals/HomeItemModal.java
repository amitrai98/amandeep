package android.com.michaleproject.modals;

/**
 * Created by amitrai on 22/3/16.
 */
public class HomeItemModal {
    private String itemName, itemDetail, itemurl, img_largeurl;

    public HomeItemModal(String itemName,
                         String itemDetail, String itemurl, String img_largeurl){
        this.itemName = itemName;
        this.itemDetail = itemDetail;
        this.itemurl = itemurl;
        this.img_largeurl = img_largeurl;

    }


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDetail() {
        return itemDetail;
    }

    public void setItemDetail(String itemDetail) {
        this.itemDetail = itemDetail;
    }

    public String getItemurl() {
        return itemurl;
    }

    public void setItemurl(String itemurl) {
        this.itemurl = itemurl;
    }

    public String getImg_largeurl() {
        return img_largeurl;
    }

    public void setImg_largeurl(String img_largeurl) {
        this.img_largeurl = img_largeurl;
    }
}
