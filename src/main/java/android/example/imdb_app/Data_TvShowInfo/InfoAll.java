package android.example.imdb_app.Data_TvShowInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class InfoAll {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("originalTitle")
        @Expose
        private String originalTitle;
        @SerializedName("fullTitle")
        @Expose
        private String fullTitle;
        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("year")
        @Expose
        private String year;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("releaseDate")
        @Expose
        private String releaseDate;
        @SerializedName("runtimeMins")
        @Expose
        private String runtimeMins;
        @SerializedName("runtimeStr")
        @Expose
        private String runtimeStr;
        @SerializedName("plot")
        @Expose
        private String plot;
        @SerializedName("plotLocal")
        @Expose
        private String plotLocal;
        @SerializedName("plotLocalIsRtl")
        @Expose
        private Boolean plotLocalIsRtl;
        @SerializedName("awards")
        @Expose
        private String awards;
        @SerializedName("directors")
        @Expose
        private String directors;
        @SerializedName("directorList")
        @Expose
        private List<Object> directorList = null;
        @SerializedName("writers")
        @Expose
        private String writers;
        @SerializedName("writerList")
        @Expose
        private List<Object> writerList = null;
        @SerializedName("stars")
        @Expose
        private String stars;
        @SerializedName("starList")
        @Expose
        private List<StarList> starList = null;
        @SerializedName("actorList")
        @Expose
        private List<ActorList> actorList = null;
        @SerializedName("fullCast")
        @Expose
        private Object fullCast;
        @SerializedName("genres")
        @Expose
        private String genres;
        @SerializedName("genreList")
        @Expose
        private List<GenreList> genreList = null;
        @SerializedName("companies")
        @Expose
        private String companies;
        @SerializedName("companyList")
        @Expose
        private List<CompanyList> companyList = null;
        @SerializedName("countries")
        @Expose
        private String countries;
        @SerializedName("countryList")
        @Expose
        private List<CountryList> countryList = null;
        @SerializedName("languages")
        @Expose
        private String languages;
        @SerializedName("languageList")
        @Expose
        private List<LanguageList> languageList = null;
        @SerializedName("contentRating")
        @Expose
        private String contentRating;
        @SerializedName("imDbRating")
        @Expose
        private String imDbRating;
        @SerializedName("imDbRatingVotes")
        @Expose
        private String imDbRatingVotes;
        @SerializedName("metacriticRating")
        @Expose
        private String metacriticRating;
        @SerializedName("ratings")
        @Expose
        private Object ratings;
        @SerializedName("wikipedia")
        @Expose
        private Object wikipedia;
        @SerializedName("posters")
        @Expose
        private Object posters;
        @SerializedName("images")
        @Expose
        private Object images;
        @SerializedName("trailer")
        @Expose
        private Object trailer;
        @SerializedName("boxOffice")
        @Expose
        private BoxOffice boxOffice;
        @SerializedName("tagline")
        @Expose
        private String tagline;
        @SerializedName("keywords")
        @Expose
        private String keywords;
        @SerializedName("keywordList")
        @Expose
        private List<String> keywordList = null;
        @SerializedName("similars")
        @Expose
        private List<Similar> similars = null;
        @SerializedName("tvSeriesInfo")
        @Expose
        private TvSeriesInfo tvSeriesInfo;
        @SerializedName("tvEpisodeInfo")
        @Expose
        private Object tvEpisodeInfo;
        @SerializedName("errorMessage")
        @Expose
        private String errorMessage;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getOriginalTitle() {
            return originalTitle;
        }

        public void setOriginalTitle(String originalTitle) {
            this.originalTitle = originalTitle;
        }

        public String getFullTitle() {
            return fullTitle;
        }

        public void setFullTitle(String fullTitle) {
            this.fullTitle = fullTitle;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }

        public String getRuntimeMins() {
            return runtimeMins;
        }

        public void setRuntimeMins(String runtimeMins) {
            this.runtimeMins = runtimeMins;
        }

        public String getRuntimeStr() {
            return runtimeStr;
        }

        public void setRuntimeStr(String runtimeStr) {
            this.runtimeStr = runtimeStr;
        }

        public String getPlot() {
            return plot;
        }

        public void setPlot(String plot) {
            this.plot = plot;
        }

        public String getPlotLocal() {
            return plotLocal;
        }

        public void setPlotLocal(String plotLocal) {
            this.plotLocal = plotLocal;
        }

        public Boolean getPlotLocalIsRtl() {
            return plotLocalIsRtl;
        }

        public void setPlotLocalIsRtl(Boolean plotLocalIsRtl) {
            this.plotLocalIsRtl = plotLocalIsRtl;
        }

        public String getAwards() {
            return awards;
        }

        public void setAwards(String awards) {
            this.awards = awards;
        }

        public String getDirectors() {
            return directors;
        }

        public void setDirectors(String directors) {
            this.directors = directors;
        }

        public List<Object> getDirectorList() {
            return directorList;
        }

        public void setDirectorList(List<Object> directorList) {
            this.directorList = directorList;
        }

        public String getWriters() {
            return writers;
        }

        public void setWriters(String writers) {
            this.writers = writers;
        }

        public List<Object> getWriterList() {
            return writerList;
        }

        public void setWriterList(List<Object> writerList) {
            this.writerList = writerList;
        }

        public String getStars() {
            return stars;
        }

        public void setStars(String stars) {
            this.stars = stars;
        }

        public List<StarList> getStarList() {
            return starList;
        }

        public void setStarList(List<StarList> starList) {
            this.starList = starList;
        }

        public List<ActorList> getActorList() {
            return actorList;
        }

        public void setActorList(List<ActorList> actorList) {
            this.actorList = actorList;
        }

        public Object getFullCast() {
            return fullCast;
        }

        public void setFullCast(Object fullCast) {
            this.fullCast = fullCast;
        }

        public String getGenres() {
            return genres;
        }

        public void setGenres(String genres) {
            this.genres = genres;
        }

        public List<GenreList> getGenreList() {
            return genreList;
        }

        public void setGenreList(List<GenreList> genreList) {
            this.genreList = genreList;
        }

        public String getCompanies() {
            return companies;
        }

        public void setCompanies(String companies) {
            this.companies = companies;
        }

        public List<CompanyList> getCompanyList() {
            return companyList;
        }

        public void setCompanyList(List<CompanyList> companyList) {
            this.companyList = companyList;
        }

        public String getCountries() {
            return countries;
        }

        public void setCountries(String countries) {
            this.countries = countries;
        }

        public List<CountryList> getCountryList() {
            return countryList;
        }

        public void setCountryList(List<CountryList> countryList) {
            this.countryList = countryList;
        }

        public String getLanguages() {
            return languages;
        }

        public void setLanguages(String languages) {
            this.languages = languages;
        }

        public List<LanguageList> getLanguageList() {
            return languageList;
        }

        public void setLanguageList(List<LanguageList> languageList) {
            this.languageList = languageList;
        }

        public String getContentRating() {
            return contentRating;
        }

        public void setContentRating(String contentRating) {
            this.contentRating = contentRating;
        }

        public String getImDbRating() {
            return imDbRating;
        }

        public void setImDbRating(String imDbRating) {
            this.imDbRating = imDbRating;
        }

        public String getImDbRatingVotes() {
            return imDbRatingVotes;
        }

        public void setImDbRatingVotes(String imDbRatingVotes) {
            this.imDbRatingVotes = imDbRatingVotes;
        }

        public String getMetacriticRating() {
            return metacriticRating;
        }

        public void setMetacriticRating(String metacriticRating) {
            this.metacriticRating = metacriticRating;
        }

        public Object getRatings() {
            return ratings;
        }

        public void setRatings(Object ratings) {
            this.ratings = ratings;
        }

        public Object getWikipedia() {
            return wikipedia;
        }

        public void setWikipedia(Object wikipedia) {
            this.wikipedia = wikipedia;
        }

        public Object getPosters() {
            return posters;
        }

        public void setPosters(Object posters) {
            this.posters = posters;
        }

        public Object getImages() {
            return images;
        }

        public void setImages(Object images) {
            this.images = images;
        }

        public Object getTrailer() {
            return trailer;
        }

        public void setTrailer(Object trailer) {
            this.trailer = trailer;
        }

        public BoxOffice getBoxOffice() {
            return boxOffice;
        }

        public void setBoxOffice(BoxOffice boxOffice) {
            this.boxOffice = boxOffice;
        }

        public String getTagline() {
            return tagline;
        }

        public void setTagline(String tagline) {
            this.tagline = tagline;
        }

        public String getKeywords() {
            return keywords;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        public List<String> getKeywordList() {
            return keywordList;
        }

        public void setKeywordList(List<String> keywordList) {
            this.keywordList = keywordList;
        }

        public List<Similar> getSimilars() {
            return similars;
        }

        public void setSimilars(List<Similar> similars) {
            this.similars = similars;
        }

        public TvSeriesInfo getTvSeriesInfo() {
            return tvSeriesInfo;
        }

        public void setTvSeriesInfo(TvSeriesInfo tvSeriesInfo) {
            this.tvSeriesInfo = tvSeriesInfo;
        }

        public Object getTvEpisodeInfo() {
            return tvEpisodeInfo;
        }

        public void setTvEpisodeInfo(Object tvEpisodeInfo) {
            this.tvEpisodeInfo = tvEpisodeInfo;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }


}
