package android.example.imdb_app.Data_TvShowInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GenreList {

        @SerializedName("key")
        @Expose
        private String key;
        @SerializedName("value")
        @Expose
        private String value;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
}
