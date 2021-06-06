package andromo.gujuratjob.RestCall;

import andromo.gujuratjob.model.NsView;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Server {
    @GET("/job/gj.json")
    Call<NsView> getEightBook();
}

