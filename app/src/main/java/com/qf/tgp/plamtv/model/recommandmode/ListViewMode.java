package com.qf.tgp.plamtv.model.recommandmode;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nfkj on 2016/9/20.
 */
public class ListViewMode {
    @SerializedName("app-index")
    private List<bean> app_index;
    @SerializedName("app-classification")
    private List<bean> app_classification;
    @SerializedName("app-recommendation")
    private List<bean> app_recommendation;
    @SerializedName("app-lol")
    private List<bean> app_lol;
    @SerializedName("app-beauty")
    private List<bean> app_beauty;
    @SerializedName("app-heartstone")
    private List<bean> app_heartstone;
    @SerializedName("app-huwai")
    private List<bean> app_huwai;
    @SerializedName("app-overwatch")
    private List<bean> app_overwatch;
    @SerializedName("app-blizzard")
    private List<bean> app_blizzard;
    @SerializedName("app-sport")
    private List<bean> app_sport;
    @SerializedName("app-qqfeiche")
    private List<bean> app_qqfeiche;
    @SerializedName("app-mobilegame")
    private List<bean> app_mobilegame;
    @SerializedName("app-wangzhe")
    private List<bean> app_wangzhe;
    @SerializedName("app-dota2")
    private List<bean> app_dota2;
    @SerializedName("app-tvgame")
    private List<bean> app_tvgame;
    @SerializedName("app-webgame")
    private List<bean> app_webgame;
    @SerializedName("app-dnf")
    private List<bean> app_dnf;
    @SerializedName("app-minecraft")
    private List<bean> app_minecraft;

   public static class bean{
        @Override
        public String toString() {
            return "lob{" +
                    "link_object=" + link_object +
                    '}';
        }

        private link_object link_object;

        public ListViewMode.link_object getLink_object() {
            return link_object;
        }

        public void setLink_object(ListViewMode.link_object link_object) {
            this.link_object = link_object;
        }
    }

   public static class link_object{
       private String category_name;
        private String title;
        private String avatar;
        private String thumb;
        private String view;
        private String nick;

       public String getNick() {
           return nick;
       }

       public void setNick(String nick) {
           this.nick = nick;
       }

       public String getCategory_name() {
           return category_name;
       }

       public void setCategory_name(String category_name) {
           this.category_name = category_name;
       }

       public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public String getView() {
            return view;
        }

        public void setView(String view) {
            this.view = view;
        }
    }

    public List<bean> getApp_index() {
        return app_index;
    }

    public void setApp_index(List<bean> app_index) {
        this.app_index = app_index;
    }

    public List<bean> getApp_classification() {
        return app_classification;
    }

    public void setApp_classification(List<bean> app_classification) {
        this.app_classification = app_classification;
    }

    public List<bean> getApp_recommendation() {
        return app_recommendation;
    }

    public void setApp_recommendation(List<bean> app_recommendation) {
        this.app_recommendation = app_recommendation;
    }

    public List<bean> getApp_lol() {
        return app_lol;
    }

    public void setApp_lol(List<bean> app_lol) {
        this.app_lol = app_lol;
    }

    public List<bean> getApp_beauty() {
        return app_beauty;
    }

    public void setApp_beauty(List<bean> app_beauty) {
        this.app_beauty = app_beauty;
    }

    public List<bean> getApp_heartstone() {
        return app_heartstone;
    }

    public void setApp_heartstone(List<bean> app_heartstone) {
        this.app_heartstone = app_heartstone;
    }

    public List<bean> getApp_huwai() {
        return app_huwai;
    }

    public void setApp_huwai(List<bean> app_huwai) {
        this.app_huwai = app_huwai;
    }

    public List<bean> getApp_overwatch() {
        return app_overwatch;
    }

    public void setApp_overwatch(List<bean> app_overwatch) {
        this.app_overwatch = app_overwatch;
    }

    public List<bean> getApp_blizzard() {
        return app_blizzard;
    }

    public void setApp_blizzard(List<bean> app_blizzard) {
        this.app_blizzard = app_blizzard;
    }

    public List<bean> getApp_sport() {
        return app_sport;
    }

    public void setApp_sport(List<bean> app_sport) {
        this.app_sport = app_sport;
    }

    public List<bean> getApp_qqfeiche() {
        return app_qqfeiche;
    }

    public void setApp_qqfeiche(List<bean> app_qqfeiche) {
        this.app_qqfeiche = app_qqfeiche;
    }

    public List<bean> getApp_mobilegame() {
        return app_mobilegame;
    }

    public void setApp_mobilegame(List<bean> app_mobilegame) {
        this.app_mobilegame = app_mobilegame;
    }

    public List<bean> getApp_wangzhe() {
        return app_wangzhe;
    }

    public void setApp_wangzhe(List<bean> app_wangzhe) {
        this.app_wangzhe = app_wangzhe;
    }

    public List<bean> getApp_dota2() {
        return app_dota2;
    }

    public void setApp_dota2(List<bean> app_dota2) {
        this.app_dota2 = app_dota2;
    }

    public List<bean> getApp_tvgame() {
        return app_tvgame;
    }

    public void setApp_tvgame(List<bean> app_tvgame) {
        this.app_tvgame = app_tvgame;
    }

    public List<bean> getApp_webgame() {
        return app_webgame;
    }

    public void setApp_webgame(List<bean> app_webgame) {
        this.app_webgame = app_webgame;
    }

    public List<bean> getApp_dnf() {
        return app_dnf;
    }

    public void setApp_dnf(List<bean> app_dnf) {
        this.app_dnf = app_dnf;
    }

    public List<bean> getApp_minecraft() {
        return app_minecraft;
    }

    public void setApp_minecraft(List<bean> app_minecraft) {
        this.app_minecraft = app_minecraft;
    }

    @Override
    public String toString() {
        return "ListViewMode{" +
                "app_index=" + app_index +
                ", app_classification=" + app_classification +
                ", app_recommendation=" + app_recommendation +
                ", app_lol=" + app_lol +
                ", app_beauty=" + app_beauty +
                ", app_heartstone=" + app_heartstone +
                ", app_huwai=" + app_huwai +
                ", app_overwatch=" + app_overwatch +
                ", app_blizzard=" + app_blizzard +
                ", app_sport=" + app_sport +
                ", app_qqfeiche=" + app_qqfeiche +
                ", app_mobilegame=" + app_mobilegame +
                ", app_wangzhe=" + app_wangzhe +
                ", app_dota2=" + app_dota2 +
                ", app_tvgame=" + app_tvgame +
                ", app_webgame=" + app_webgame +
                ", app_dnf=" + app_dnf +
                ", app_minecraft=" + app_minecraft +
                '}';
    }
}
