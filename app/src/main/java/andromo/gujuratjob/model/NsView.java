package andromo.gujuratjob.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NsView {
    @SerializedName("ns")
    @Expose

    private List<NsModel> spllist;


    public List<NsModel> getEightBook(){
        return spllist;
    }

    public void setAlbums(List<NsModel> spllist){
        this.spllist = spllist;
    }
}

