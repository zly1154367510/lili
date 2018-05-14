package com.zly.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;
import sun.plugin2.message.Message;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class Content {
    private Long id;

    @NotNull()
    private Long categoryId;

    @NotEmpty(message = "标题不能为空")
    private String title;

    private String subTitle;

    private String titleDesc;
    @NotEmpty(message = "跳转链接不能为空")
    private String url;

    private String pic;

    private String pic2;

    private Date created;

    private Date updated;

    private String content;

    private MultipartFile images;

    private ContentCategory contentCategory;

    public ContentCategory getContentCategory() {
        return contentCategory;
    }

    public void setContentCategory(ContentCategory contentCategory) {
        this.contentCategory = contentCategory;
    }

    public MultipartFile getImages() {
        return images;
    }

    public void setImages(MultipartFile images) {
        this.images = images;
    }

    public Content(Long id, Long categoryId, String title, String subTitle, String titleDesc, String url, String pic, String pic2, Date created, Date updated, String content) {
        this.id = id;
        this.categoryId = categoryId;
        this.title = title;
        this.subTitle = subTitle;
        this.titleDesc = titleDesc;
        this.url = url;
        this.pic = pic;
        this.pic2 = pic2;
        this.created = created;
        this.updated = updated;
        this.content = content;
    }

    public Content() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle == null ? null : subTitle.trim();
    }

    public String getTitleDesc() {
        return titleDesc;
    }

    public void setTitleDesc(String titleDesc) {
        this.titleDesc = titleDesc == null ? null : titleDesc.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public String getPic2() {
        return pic2;
    }

    public void setPic2(String pic2) {
        this.pic2 = pic2 == null ? null : pic2.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}