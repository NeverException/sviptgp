package com.qf.tgp.plamtv.model.live;

import android.os.Parcel;
import android.os.Parcelable;

import com.qf.tgp.plamtv.http.JsonParser;

import org.xutils.http.annotation.HttpResponse;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/9/20.
 */
@HttpResponse(parser= JsonParser.class)
public class LiveModel {

    private int total;
    private int pageCount;
    private int page;
    private int size;
    private String icon;


    private RecommendBean recommend;

    private List<DataBean> data;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public RecommendBean getRecommend() {
        return recommend;
    }

    public void setRecommend(RecommendBean recommend) {
        this.recommend = recommend;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class RecommendBean {
        private String name;
        private String icon;

        private List<DataBean> data;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            private int id;
            private String title;
            private String thumb;
            private String link;
            private String create_at;
            private int status;
            private String fk;
            private String subtitle;
            private String content;
            private String ext;
            private int slot_id;
            private int priority;
            private LinkObjectBean link_object;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getCreate_at() {
                return create_at;
            }

            public void setCreate_at(String create_at) {
                this.create_at = create_at;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getFk() {
                return fk;
            }

            public void setFk(String fk) {
                this.fk = fk;
            }

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getExt() {
                return ext;
            }

            public void setExt(String ext) {
                this.ext = ext;
            }

            public int getSlot_id() {
                return slot_id;
            }

            public void setSlot_id(int slot_id) {
                this.slot_id = slot_id;
            }

            public int getPriority() {
                return priority;
            }

            public void setPriority(int priority) {
                this.priority = priority;
            }

            public LinkObjectBean getLink_object() {
                return link_object;
            }

            public void setLink_object(LinkObjectBean link_object) {
                this.link_object = link_object;
            }

            public static class LinkObjectBean {
                private String nick;
                private String video;
                private int screen;
                private String grade;
                private String start_time;
                private String avatar;
                private String status;
                private String thumb;
                private String intro;
                private String level;
                private String recommend_image;
                private String like;
                private String uid;
                private String view;
                private String love_cover;
                private String category_name;
                private String announcement;
                private String create_at;
                private String play_at;
                private String video_quality;
                private String default_image;
                private String category_id;
                private String follow;
                private String beauty_cover;
                private String slug;
                private String title;
                private String category_slug;
                private String app_shuffling_image;
                private String weight;
                private boolean hidden;
                private String icontext;

                public String getNick() {
                    return nick;
                }

                public void setNick(String nick) {
                    this.nick = nick;
                }

                public String getVideo() {
                    return video;
                }

                public void setVideo(String video) {
                    this.video = video;
                }

                public int getScreen() {
                    return screen;
                }

                public void setScreen(int screen) {
                    this.screen = screen;
                }

                public String getGrade() {
                    return grade;
                }

                public void setGrade(String grade) {
                    this.grade = grade;
                }

                public String getStart_time() {
                    return start_time;
                }

                public void setStart_time(String start_time) {
                    this.start_time = start_time;
                }

                public String getAvatar() {
                    return avatar;
                }

                public void setAvatar(String avatar) {
                    this.avatar = avatar;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public String getThumb() {
                    return thumb;
                }

                public void setThumb(String thumb) {
                    this.thumb = thumb;
                }

                public String getIntro() {
                    return intro;
                }

                public void setIntro(String intro) {
                    this.intro = intro;
                }

                public String getLevel() {
                    return level;
                }

                public void setLevel(String level) {
                    this.level = level;
                }

                public String getRecommend_image() {
                    return recommend_image;
                }

                public void setRecommend_image(String recommend_image) {
                    this.recommend_image = recommend_image;
                }

                public String getLike() {
                    return like;
                }

                public void setLike(String like) {
                    this.like = like;
                }

                public String getUid() {
                    return uid;
                }

                public void setUid(String uid) {
                    this.uid = uid;
                }

                public String getView() {
                    return view;
                }

                public void setView(String view) {
                    this.view = view;
                }

                public String getLove_cover() {
                    return love_cover;
                }

                public void setLove_cover(String love_cover) {
                    this.love_cover = love_cover;
                }

                public String getCategory_name() {
                    return category_name;
                }

                public void setCategory_name(String category_name) {
                    this.category_name = category_name;
                }

                public String getAnnouncement() {
                    return announcement;
                }

                public void setAnnouncement(String announcement) {
                    this.announcement = announcement;
                }

                public String getCreate_at() {
                    return create_at;
                }

                public void setCreate_at(String create_at) {
                    this.create_at = create_at;
                }

                public String getPlay_at() {
                    return play_at;
                }

                public void setPlay_at(String play_at) {
                    this.play_at = play_at;
                }

                public String getVideo_quality() {
                    return video_quality;
                }

                public void setVideo_quality(String video_quality) {
                    this.video_quality = video_quality;
                }

                public String getDefault_image() {
                    return default_image;
                }

                public void setDefault_image(String default_image) {
                    this.default_image = default_image;
                }

                public String getCategory_id() {
                    return category_id;
                }

                public void setCategory_id(String category_id) {
                    this.category_id = category_id;
                }

                public String getFollow() {
                    return follow;
                }

                public void setFollow(String follow) {
                    this.follow = follow;
                }

                public String getBeauty_cover() {
                    return beauty_cover;
                }

                public void setBeauty_cover(String beauty_cover) {
                    this.beauty_cover = beauty_cover;
                }

                public String getSlug() {
                    return slug;
                }

                public void setSlug(String slug) {
                    this.slug = slug;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getCategory_slug() {
                    return category_slug;
                }

                public void setCategory_slug(String category_slug) {
                    this.category_slug = category_slug;
                }

                public String getApp_shuffling_image() {
                    return app_shuffling_image;
                }

                public void setApp_shuffling_image(String app_shuffling_image) {
                    this.app_shuffling_image = app_shuffling_image;
                }

                public String getWeight() {
                    return weight;
                }

                public void setWeight(String weight) {
                    this.weight = weight;
                }

                public boolean isHidden() {
                    return hidden;
                }

                public void setHidden(boolean hidden) {
                    this.hidden = hidden;
                }

                public String getIcontext() {
                    return icontext;
                }

                public void setIcontext(String icontext) {
                    this.icontext = icontext;
                }
            }
        }
    }

    public static class DataBean implements Parcelable{
        private String nick;
        private String video;
        private int screen;
        private String grade;
        private String start_time;
        private String avatar;
        private String status;
        private String thumb;
        private String intro;
        private String level;
        private String recommend_image;
        private String like;
        private String uid;
        private String view;
        private String love_cover;
        private String category_name;
        private String announcement;
        private String create_at;
        private String play_at;
        private String video_quality;
        private String default_image;
        private String category_id;
        private int follow;
        private String beauty_cover;
        private String slug;
        private String title;
        private String category_slug;
        private String app_shuffling_image;
        private String weight;
        private boolean hidden;
        private String icontext;

        protected DataBean(Parcel in) {
            nick = in.readString();
            video = in.readString();
            screen = in.readInt();
            grade = in.readString();
            start_time = in.readString();
            avatar = in.readString();
            status = in.readString();
            thumb = in.readString();
            intro = in.readString();
            level = in.readString();
            recommend_image = in.readString();
            like = in.readString();
            uid = in.readString();
            view = in.readString();
            love_cover = in.readString();
            category_name = in.readString();
            announcement = in.readString();
            create_at = in.readString();
            play_at = in.readString();
            video_quality = in.readString();
            default_image = in.readString();
            category_id = in.readString();
            follow = in.readInt();
            beauty_cover = in.readString();
            slug = in.readString();
            title = in.readString();
            category_slug = in.readString();
            app_shuffling_image = in.readString();
            weight = in.readString();
            hidden = in.readByte() != 0;
            icontext = in.readString();
        }

        public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel in) {
                return new DataBean(in);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };

        public String getNick() {
            return nick;
        }

        public void setNick(String nick) {
            this.nick = nick;
        }

        public String getVideo() {
            return video;
        }

        public void setVideo(String video) {
            this.video = video;
        }

        public int getScreen() {
            return screen;
        }

        public void setScreen(int screen) {
            this.screen = screen;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        public String getStart_time() {
            return start_time;
        }

        public void setStart_time(String start_time) {
            this.start_time = start_time;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getRecommend_image() {
            return recommend_image;
        }

        public void setRecommend_image(String recommend_image) {
            this.recommend_image = recommend_image;
        }

        public String getLike() {
            return like;
        }

        public void setLike(String like) {
            this.like = like;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getView() {
            return view;
        }

        public void setView(String view) {
            this.view = view;
        }

        public String getLove_cover() {
            return love_cover;
        }

        public void setLove_cover(String love_cover) {
            this.love_cover = love_cover;
        }

        public String getCategory_name() {
            return category_name;
        }

        public void setCategory_name(String category_name) {
            this.category_name = category_name;
        }

        public String getAnnouncement() {
            return announcement;
        }

        public void setAnnouncement(String announcement) {
            this.announcement = announcement;
        }

        public String getCreate_at() {
            return create_at;
        }

        public void setCreate_at(String create_at) {
            this.create_at = create_at;
        }

        public String getPlay_at() {
            return play_at;
        }

        public void setPlay_at(String play_at) {
            this.play_at = play_at;
        }

        public String getVideo_quality() {
            return video_quality;
        }

        public void setVideo_quality(String video_quality) {
            this.video_quality = video_quality;
        }

        public String getDefault_image() {
            return default_image;
        }

        public void setDefault_image(String default_image) {
            this.default_image = default_image;
        }

        public String getCategory_id() {
            return category_id;
        }

        public void setCategory_id(String category_id) {
            this.category_id = category_id;
        }

        public int getFollow() {
            return follow;
        }

        public void setFollow(int follow) {
            this.follow = follow;
        }

        public String getBeauty_cover() {
            return beauty_cover;
        }

        public void setBeauty_cover(String beauty_cover) {
            this.beauty_cover = beauty_cover;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCategory_slug() {
            return category_slug;
        }

        public void setCategory_slug(String category_slug) {
            this.category_slug = category_slug;
        }

        public String getApp_shuffling_image() {
            return app_shuffling_image;
        }

        public void setApp_shuffling_image(String app_shuffling_image) {
            this.app_shuffling_image = app_shuffling_image;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public boolean isHidden() {
            return hidden;
        }

        public void setHidden(boolean hidden) {
            this.hidden = hidden;
        }

        public String getIcontext() {
            return icontext;
        }

        public void setIcontext(String icontext) {
            this.icontext = icontext;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(nick);
            dest.writeString(video);
            dest.writeInt(screen);
            dest.writeString(grade);
            dest.writeString(start_time);
            dest.writeString(avatar);
            dest.writeString(status);
            dest.writeString(thumb);
            dest.writeString(intro);
            dest.writeString(level);
            dest.writeString(recommend_image);
            dest.writeString(like);
            dest.writeString(uid);
            dest.writeString(view);
            dest.writeString(love_cover);
            dest.writeString(category_name);
            dest.writeString(announcement);
            dest.writeString(create_at);
            dest.writeString(play_at);
            dest.writeString(video_quality);
            dest.writeString(default_image);
            dest.writeString(category_id);
            dest.writeInt(follow);
            dest.writeString(beauty_cover);
            dest.writeString(slug);
            dest.writeString(title);
            dest.writeString(category_slug);
            dest.writeString(app_shuffling_image);
            dest.writeString(weight);
            dest.writeByte((byte) (hidden ? 1 : 0));
            dest.writeString(icontext);
        }
    }
}

