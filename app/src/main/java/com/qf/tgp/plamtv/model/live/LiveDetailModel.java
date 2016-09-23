package com.qf.tgp.plamtv.model.live;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.qf.tgp.plamtv.http.JsonParser;

import org.xutils.http.annotation.HttpResponse;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/9/21.
 */
@HttpResponse(parser = JsonParser.class)
public class LiveDetailModel implements Serializable{


    /**
     * uid : 4991489
     * title : 明星主播大作战 重播
     * nick : 平台杯官方房间
     * avatar : http://image.quanmin.tv/avatar/1dde73c3cf0680ad5292430aef9ed604?imageView2/2/w/300/
     * slug :
     * intro :
     * category_id : 1
     * category_name : 英雄联盟
     * screen : 0
     * view : 53143
     * weight : 156080
     * follow : 152507
     * last_play_at : 2016-09-19 14:03:33
     * play_status : true
     * forbid_status : false
     * police_forbid : false
     * video_quality : 234
     * live : {"ws":{"name":"ws","v":1,"def_pc":"flv","def_mobile":"flv","hls":{"main_pc":4,"main_mobile":3,"3":{"name":"标清","src":"http://hls.quanmin.tv/live/4991489_L3/playlist.m3u8"},"4":{"name":"高清","src":"http://hls.quanmin.tv/live/4991489_L4/playlist.m3u8"},"5":{"name":"超清","src":"http://hls.quanmin.tv/live/4991489/playlist.m3u8"}},"flv":{"main_pc":4,"main_mobile":3,"3":{"name":"标清","src":"http://flv.quanmin.tv/live/4991489_L3.flv"},"4":{"name":"高清","src":"http://flv.quanmin.tv/live/4991489_L4.flv"},"5":{"name":"超清","src":"http://flv.quanmin.tv/live/4991489.flv"}}}}
     * room_lines : [{"name":"ws","v":1,"def_pc":"flv","def_mobile":"flv","hls":{"main_pc":4,"main_mobile":3,"3":{"name":"标清","src":"http://hls.quanmin.tv/live/4991489_L3/playlist.m3u8"},"4":{"name":"高清","src":"http://hls.quanmin.tv/live/4991489_L4/playlist.m3u8"},"5":{"name":"超清","src":"http://hls.quanmin.tv/live/4991489/playlist.m3u8"}},"flv":{"main_pc":4,"main_mobile":3,"3":{"name":"标清","src":"http://flv.quanmin.tv/live/4991489_L3.flv"},"4":{"name":"高清","src":"http://flv.quanmin.tv/live/4991489_L4.flv"},"5":{"name":"超清","src":"http://flv.quanmin.tv/live/4991489.flv"}}},{"name":"bd","v":1,"def_pc":"flv","def_mobile":"flv","hls":{"main_pc":4,"main_mobile":3,"3":{"name":"标清","src":"http://livebd.quanmin.tv/live/4991489-L3.m3u8"},"4":{"name":"高清","src":"http://livebd.quanmin.tv/live/4991489-L4.m3u8"},"5":{"name":"超清","src":"http://livebd.quanmin.tv/live/4991489.m3u8"}},"flv":{"main_pc":4,"main_mobile":3,"3":{"name":"标清","src":"http://livebd.quanmin.tv/live/4991489-L3.flv"},"4":{"name":"高清","src":"http://livebd.quanmin.tv/live/4991489-L4.flv"},"5":{"name":"超清","src":"http://livebd.quanmin.tv/live/4991489.flv"}}},{"name":"tx","v":1,"def_pc":"flv","def_mobile":"flv","hls":{"main_pc":4,"main_mobile":3,"3":{"name":"标清","src":"http://hls3.quanmin.tv/live/3766_4991489_550.m3u8"},"4":{"name":"高清","src":"http://hls3.quanmin.tv/live/3766_4991489_900.m3u8"},"5":{"name":"超清","src":"http://hls3.quanmin.tv/live/3766_4991489.m3u8"}},"flv":{"main_pc":4,"main_mobile":3,"3":{"name":"标清","src":"http://flv3.quanmin.tv/live/3766_4991489_550.flv"},"4":{"name":"高清","src":"http://flv3.quanmin.tv/live/3766_4991489_900.flv"},"5":{"name":"超清","src":"http://flv3.quanmin.tv/live/3766_4991489.flv"}}},{"name":"ali","v":1,"def_pc":"flv","def_mobile":"flv","hls":{"main_pc":4,"main_mobile":3,"3":{"name":"标清","src":"http://liveal.quanmin.tv/live/4991489_quanmin576.flv"},"4":{"name":"高清","src":"http://liveal.quanmin.tv/live/4991489_quanmin720.flv"},"5":{"name":"超清","src":"http://liveal.quanmin.tv/live/4991489.flv"}},"flv":{"main_pc":4,"main_mobile":3,"3":{"name":"标清","src":"http://liveal.quanmin.tv/live/4991489_quanmin576.flv"},"4":{"name":"高清","src":"http://liveal.quanmin.tv/live/4991489_quanmin720.flv"},"5":{"name":"超清","src":"http://liveal.quanmin.tv/live/4991489.flv"}}}]
     * announcement :
     * watermark : 1
     * is_star : true
     * special : {"script_path":"/static/v2/special/module/pt/pt_eaf437b.js","module_name":"special/pt"}
     * pic_top : http://image.quanmin.tv/f5a603e5bb8063c4b451828c4250a069jpg
     * pic_bottom : http://image.quanmin.tv/f5402657be31a108f3295782d4d76fdbjpg
     * star_title :
     * star_content :
     * star_video : []
     * play_at : 2016-09-20 13:43:58
     * thumb : http://snap.quanmin.tv/4991489-1474424680-929.jpg?imageView2/2/w/390/
     * video : http://thumb.quanmin.tv/4991489.mp4?t=1474424400
     * admins : []
     * rank_week : [{"send_uid":5228574,"score":43918,"send_nick":"灬涛霸霸丶","rank":"20","avatar":"http://image.quanmin.tv/avatar/974b94dc34952d33e9cad788df464ffe?imageView2/2/w/300/","icon":"/static/images/lv/20.png?v=2","icon_url":"http://www.quanmin.tv/static/images/lv/20.png?v=2","change":"up"},{"send_uid":2272662,"score":28000,"send_nick":"新闻99","rank":"17","avatar":"http://image.quanmin.tv/avatar/045fdc8ceea990ccf7f3280dd79ffbcf?imageView2/2/w/300/","icon":"/static/images/lv/17.png?v=2","icon_url":"http://www.quanmin.tv/static/images/lv/17.png?v=2","change":"up"},{"send_uid":170,"score":27262,"send_nick":"伟大的鹏君","rank":"21","avatar":"http://image.quanmin.tv/avatar/760aa30ea97f5fc5205835ae7c5cfc85jpg?imageView2/2/w/300/","icon":"/static/images/lv/21.png?v=2","icon_url":"http://www.quanmin.tv/static/images/lv/21.png?v=2","change":"up"},{"send_uid":1828633,"score":22282,"send_nick":"一只老猫的狮子梦","rank":"21","avatar":"http://image.quanmin.tv/avatar/1728925a15b626f1d46ba85132567fd7jpg?imageView2/2/w/300/","icon":"/static/images/lv/21.png?v=2","icon_url":"http://www.quanmin.tv/static/images/lv/21.png?v=2","change":"up"},{"send_uid":912532,"score":13538,"send_nick":"伟大的欢君","rank":"15","avatar":"/static/images/avatar.jpg","icon":"/static/images/lv/15.png?v=2","icon_url":"http://www.quanmin.tv/static/images/lv/15.png?v=2","change":"up"},{"send_uid":621117,"score":10690,"send_nick":"我叫不要脸","rank":"15","avatar":"http://image.quanmin.tv/avatar/d50e8811f026299821f852db9ef16d03gif?imageView2/2/w/300/","icon":"/static/images/lv/15.png?v=2","icon_url":"http://www.quanmin.tv/static/images/lv/15.png?v=2","change":"up"},{"send_uid":3030274,"score":6908,"send_nick":"水瓶超人","rank":"16","avatar":"http://image.quanmin.tv/avatar/cfce6540b683c4a029f7ace1b4cb3996?imageView2/2/w/300/","icon":"/static/images/lv/16.png?v=2","icon_url":"http://www.quanmin.tv/static/images/lv/16.png?v=2","change":"up"},{"send_uid":3454810,"score":3000,"send_nick":"主播小洛","rank":"11","avatar":"http://image.quanmin.tv/avatar/8c64ed4f3421581e5ac76e92ed11ead4jpg?imageView2/2/w/300/","icon":"/static/images/lv/11.png?v=2","icon_url":"http://www.quanmin.tv/static/images/lv/11.png?v=2","change":"up"},{"send_uid":4322383,"score":2644,"send_nick":"坏人的大叔","rank":"22","avatar":"/static/images/avatar.jpg","icon":"/static/images/lv/22.png?v=2","icon_url":"http://www.quanmin.tv/static/images/lv/22.png?v=2","change":"up"},{"send_uid":5897396,"score":2402,"send_nick":"南波儿的瞳","rank":"15","avatar":"/static/images/avatar.jpg","icon":"/static/images/lv/15.png?v=2","icon_url":"http://www.quanmin.tv/static/images/lv/15.png?v=2","change":"up"}]
     * rank_total : [{"send_uid":5228574,"score":43918,"send_nick":"灬涛霸霸丶","rank":"20","avatar":"http://image.quanmin.tv/avatar/974b94dc34952d33e9cad788df464ffe?imageView2/2/w/300/","icon":"/static/images/lv/20.png?v=2","icon_url":"http://www.quanmin.tv/static/images/lv/20.png?v=2"},{"send_uid":1828633,"score":32282,"send_nick":"一只老猫的狮子梦","rank":"21","avatar":"http://image.quanmin.tv/avatar/1728925a15b626f1d46ba85132567fd7jpg?imageView2/2/w/300/","icon":"/static/images/lv/21.png?v=2","icon_url":"http://www.quanmin.tv/static/images/lv/21.png?v=2"},{"send_uid":2272662,"score":28000,"send_nick":"新闻99","rank":"17","avatar":"http://image.quanmin.tv/avatar/045fdc8ceea990ccf7f3280dd79ffbcf?imageView2/2/w/300/","icon":"/static/images/lv/17.png?v=2","icon_url":"http://www.quanmin.tv/static/images/lv/17.png?v=2"},{"send_uid":170,"score":27262,"send_nick":"伟大的鹏君","rank":"21","avatar":"http://image.quanmin.tv/avatar/760aa30ea97f5fc5205835ae7c5cfc85jpg?imageView2/2/w/300/","icon":"/static/images/lv/21.png?v=2","icon_url":"http://www.quanmin.tv/static/images/lv/21.png?v=2"},{"send_uid":4322383,"score":17644,"send_nick":"坏人的大叔","rank":"22","avatar":"/static/images/avatar.jpg","icon":"/static/images/lv/22.png?v=2","icon_url":"http://www.quanmin.tv/static/images/lv/22.png?v=2"},{"send_uid":912532,"score":13538,"send_nick":"伟大的欢君","rank":"15","avatar":"/static/images/avatar.jpg","icon":"/static/images/lv/15.png?v=2","icon_url":"http://www.quanmin.tv/static/images/lv/15.png?v=2"},{"send_uid":621117,"score":10690,"send_nick":"我叫不要脸","rank":"15","avatar":"http://image.quanmin.tv/avatar/d50e8811f026299821f852db9ef16d03gif?imageView2/2/w/300/","icon":"/static/images/lv/15.png?v=2","icon_url":"http://www.quanmin.tv/static/images/lv/15.png?v=2"},{"send_uid":3030274,"score":6908,"send_nick":"水瓶超人","rank":"16","avatar":"http://image.quanmin.tv/avatar/cfce6540b683c4a029f7ace1b4cb3996?imageView2/2/w/300/","icon":"/static/images/lv/16.png?v=2","icon_url":"http://www.quanmin.tv/static/images/lv/16.png?v=2"},{"send_uid":1318065,"score":5000,"send_nick":"壹时代","rank":"26","avatar":"http://image.quanmin.tv/avatar/d9a7608326359e290a4700ccf42b4584jpg?imageView2/2/w/300/","icon":"/static/images/lv/26.png?v=2","icon_url":"http://www.quanmin.tv/static/images/lv/26.png?v=2"}]
     * rank_curr : [{"send_uid":5228574,"score":29092,"send_nick":"灬涛霸霸丶","avatar":"http://image.quanmin.tv/avatar/974b94dc34952d33e9cad788df464ffe?imageView2/2/w/300/","rank":"20","icon":"/static/images/lv/20.png?v=2"},{"send_uid":170,"score":27240,"send_nick":"伟大的鹏君","avatar":"http://image.quanmin.tv/avatar/760aa30ea97f5fc5205835ae7c5cfc85jpg?imageView2/2/w/300/","rank":"21","icon":"/static/images/lv/21.png?v=2"},{"send_uid":912532,"score":8552,"send_nick":"伟大的欢君","avatar":"/static/images/avatar.jpg","rank":"15","icon":"/static/images/lv/15.png?v=2"},{"send_uid":621117,"score":7034,"send_nick":"我叫不要脸","avatar":"http://image.quanmin.tv/avatar/d50e8811f026299821f852db9ef16d03gif?imageView2/2/w/300/","rank":"15","icon":"/static/images/lv/15.png?v=2"},{"send_uid":1828633,"score":6902,"send_nick":"一只老猫的狮子梦","avatar":"http://image.quanmin.tv/avatar/1728925a15b626f1d46ba85132567fd7jpg?imageView2/2/w/300/","rank":"21","icon":"/static/images/lv/21.png?v=2"},{"send_uid":3030274,"score":3242,"send_nick":"水瓶超人","avatar":"http://image.quanmin.tv/avatar/cfce6540b683c4a029f7ace1b4cb3996?imageView2/2/w/300/","rank":"16","icon":"/static/images/lv/16.png?v=2"},{"send_uid":5897396,"score":2080,"send_nick":"南波儿的瞳","avatar":"/static/images/avatar.jpg","rank":"15","icon":"/static/images/lv/15.png?v=2"},{"send_uid":2694370,"score":1080,"send_nick":"海洋超人","avatar":"http://image.quanmin.tv/avatar/b8c15c9d2e3063054cf56d1f00269059?imageView2/2/w/300/","rank":"10","icon":"/static/images/lv/10.png?v=2"},{"send_uid":481032,"score":438,"send_nick":"跟我学股票","avatar":"http://image.quanmin.tv/avatar/e5b0e9e56e21a8b8634c43a62e6ade44jpg?imageView2/2/w/300/","rank":"5","icon":"/static/images/lv/5.png?v=2"},{"send_uid":871680,"score":402,"send_nick":"全民丶小蜜","avatar":"http://image.quanmin.tv/avatar/798a59fb8e3a4680dd58123c061e6b7ejpg?imageView2/2/w/300/","rank":"15","icon":"/static/images/lv/15.png?v=2"}]
     * hot_word : []
     * notice : []
     * warn : false
     * hidden : false
     */

    private int uid;
    private String title;
    private String nick;
    private String avatar;
    private String slug;
    private String intro;
    private String category_id;
    private String category_name;
    private String screen;
    private int view;
    private int weight;
    private int follow;
    private String last_play_at;
    private boolean play_status;
    private boolean forbid_status;
    private boolean police_forbid;
    private String video_quality;
    /**
     * ws : {"name":"ws","v":1,"def_pc":"flv","def_mobile":"flv","hls":{"main_pc":4,"main_mobile":3,"3":{"name":"标清","src":"http://hls.quanmin.tv/live/4991489_L3/playlist.m3u8"},"4":{"name":"高清","src":"http://hls.quanmin.tv/live/4991489_L4/playlist.m3u8"},"5":{"name":"超清","src":"http://hls.quanmin.tv/live/4991489/playlist.m3u8"}},"flv":{"main_pc":4,"main_mobile":3,"3":{"name":"标清","src":"http://flv.quanmin.tv/live/4991489_L3.flv"},"4":{"name":"高清","src":"http://flv.quanmin.tv/live/4991489_L4.flv"},"5":{"name":"超清","src":"http://flv.quanmin.tv/live/4991489.flv"}}}
     */

    private LiveBean live;


    public class LiveBean {
        private WsBean ws;

        public WsBean getWs() {
            return ws;
        }

        public void setWs(WsBean ws) {
            this.ws = ws;
        }

        public class WsBean implements Serializable{
            private String name;
            private HlsBean hls;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public HlsBean getHls() {
                return hls;
            }

            public void setHls(HlsBean hls) {
                this.hls = hls;
            }

            public class HlsBean {
                @SerializedName("3")
                private Flv3 mFlv3;
                @SerializedName("4")
                private Flv4 mFlv4;
                @SerializedName("5")
                private Flv5 mFlv5;

                public Flv3 getFlv3() {
                    return mFlv3;
                }

                public void setFlv3(Flv3 flv3) {
                    mFlv3 = flv3;
                }

                public Flv4 getFlv4() {
                    return mFlv4;
                }

                public void setFlv4(Flv4 flv4) {
                    mFlv4 = flv4;
                }

                public Flv5 getFlv5() {
                    return mFlv5;
                }

                public void setFlv5(Flv5 flv5) {
                    mFlv5 = flv5;
                }

                public class Flv3 {
                    private String name;
                    private String src;

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getSrc() {
                        return src;
                    }

                    public void setSrc(String src) {
                        this.src = src;
                    }
                }


                public class Flv4 {
                    private String name;
                    private String src;
                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getSrc() {
                        return src;
                    }

                    public void setSrc(String src) {
                        this.src = src;
                    }
                }

                public class Flv5 {
                    private String name;
                    private String src;
                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getSrc() {
                        return src;
                    }

                    public void setSrc(String src) {
                        this.src = src;
                    }
                }
            }
        }
    }

    private List<RankWeek> rank_week;
    private List<RankWeek> rank_total;
    private List<RankWeek> rank_curr;

    public class RankWeek implements Parcelable {
        @Override
        public String toString() {
            return "RankWeek{" +
                    "send_uid='" + send_uid + '\'' +
                    ", send_nick='" + send_nick + '\'' +
                    ", rank='" + rank + '\'' +
                    ", icon_url='" + icon_url + '\'' +
                    ", change='" + change + '\'' +
                    '}';
        }

        private String send_uid;
        private String send_nick;
        private String rank;
        private String icon_url;
        private String change;
        private String icon;
        private String score;

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getSend_uid() {
            return send_uid;
        }

        public void setSend_uid(String send_uid) {
            this.send_uid = send_uid;
        }

        public String getSend_nick() {
            return send_nick;
        }

        public void setSend_nick(String send_nick) {
            this.send_nick = send_nick;
        }

        public String getRank() {
            return rank;
        }

        public void setRank(String rank) {
            this.rank = rank;
        }

        public String getIcon_url() {
            return icon_url;
        }

        public void setIcon_url(String icon_url) {
            this.icon_url = icon_url;
        }

        public String getChange() {
            return change;
        }

        public void setChange(String change) {
            this.change = change;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(send_nick);
            dest.writeString(icon_url);
            dest.writeString(change);
        }
    }


    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getFollow() {
        return follow;
    }

    public void setFollow(int follow) {
        this.follow = follow;
    }

    public String getLast_play_at() {
        return last_play_at;
    }

    public void setLast_play_at(String last_play_at) {
        this.last_play_at = last_play_at;
    }

    public boolean isPlay_status() {
        return play_status;
    }

    public void setPlay_status(boolean play_status) {
        this.play_status = play_status;
    }

    public boolean isForbid_status() {
        return forbid_status;
    }

    public void setForbid_status(boolean forbid_status) {
        this.forbid_status = forbid_status;
    }

    public boolean isPolice_forbid() {
        return police_forbid;
    }

    public void setPolice_forbid(boolean police_forbid) {
        this.police_forbid = police_forbid;
    }

    public String getVideo_quality() {
        return video_quality;
    }

    public void setVideo_quality(String video_quality) {
        this.video_quality = video_quality;
    }

    public LiveBean getLive() {
        return live;
    }

    public void setLive(LiveBean live) {
        this.live = live;
    }

    public List<RankWeek> getRank_week() {
        return rank_week;
    }

    public void setRank_week(List<RankWeek> rank_week) {
        this.rank_week = rank_week;
    }

    public List<RankWeek> getRank_total() {
        return rank_total;
    }

    public void setRank_total(List<RankWeek> rank_total) {
        this.rank_total = rank_total;
    }

    public List<RankWeek> getRank_curr() {
        return rank_curr;
    }

    public void setRank_curr(List<RankWeek> rank_curr) {
        this.rank_curr = rank_curr;
    }


    @Override
    public String toString() {
        return "LiveDetailModel{" +
                "uid=" + uid +
                ", title='" + title + '\'' +
                ", nick='" + nick + '\'' +
                ", avatar='" + avatar + '\'' +
                ", slug='" + slug + '\'' +
                ", intro='" + intro + '\'' +
                ", category_id='" + category_id + '\'' +
                ", category_name='" + category_name + '\'' +
                ", screen='" + screen + '\'' +
                ", view=" + view +
                ", weight=" + weight +
                ", follow=" + follow +
                ", last_play_at='" + last_play_at + '\'' +
                ", play_status=" + play_status +
                ", forbid_status=" + forbid_status +
                ", police_forbid=" + police_forbid +
                ", video_quality='" + video_quality + '\'' +
                ", live=" + live +
                ", rank_week=" + rank_week +
                ", rank_total=" + rank_total +
                ", rank_curr=" + rank_curr +
                '}';
    }
}
