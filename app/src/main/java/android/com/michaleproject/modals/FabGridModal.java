package android.com.michaleproject.modals;

/**
 * Created by amitrai on 18/3/16.
 */
public class FabGridModal {

    String item_name = null;
    String item_image_resource = null;

    public FabGridModal(String item_name,
            String item_image_resource){
        this.item_image_resource = item_image_resource;
        this.item_name = item_name;
    }


    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_image_resource() {
        return item_image_resource;
    }

    public void setItem_image_resource(String item_image_resource) {
        this.item_image_resource = item_image_resource;
    }
}
