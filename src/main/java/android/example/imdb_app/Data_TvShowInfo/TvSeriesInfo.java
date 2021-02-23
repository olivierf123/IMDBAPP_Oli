package android.example.imdb_app.Data_TvShowInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TvSeriesInfo {

        @SerializedName("yearEnd")
        @Expose
        private String yearEnd;
        @SerializedName("creators")
        @Expose
        private String creators;
        @SerializedName("creatorList")
        @Expose
        private List<CreatorList> creatorList = null;
        @SerializedName("seasons")
        @Expose
        private List<String> seasons = null;

        public String getYearEnd() {
            return yearEnd;
        }

        public void setYearEnd(String yearEnd) {
            this.yearEnd = yearEnd;
        }

        public String getCreators() {
            return creators;
        }

        public void setCreators(String creators) {
            this.creators = creators;
        }

        public List<CreatorList> getCreatorList() {
            return creatorList;
        }

        public void setCreatorList(List<CreatorList> creatorList) {
            this.creatorList = creatorList;
        }

        public List<String> getSeasons() {
            return seasons;
        }

        public void setSeasons(List<String> seasons) {
            this.seasons = seasons;
        }

    }
