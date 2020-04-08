package pl.edu.agh.dronka.shop.model.filters;

import pl.edu.agh.dronka.shop.model.Category;

public class FilterSpec {

    private Category category;
    private boolean isPolish;
    private boolean isSecondHand;
    private boolean isHardCover;
    private boolean isMobile;
    private boolean isUnderWarranty;
    private boolean isWithVideo;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isPolish() {
        return isPolish;
    }

    public void setPolish(boolean polish) {
        isPolish = polish;
    }

    public boolean isSecondHand() {
        return isSecondHand;
    }

    public void setSecondHand(boolean secondHand) {
        isSecondHand = secondHand;
    }

    public boolean isHardCover() {
        return isHardCover;
    }

    public void setHardCover(boolean hardCover) {
        isHardCover = hardCover;
    }

    public boolean isMobile() {
        return isMobile;
    }

    public void setMobile(boolean mobile) {
        isMobile = mobile;
    }

    public boolean isUnderWarranty() {
        return isUnderWarranty;
    }

    public void setUnderWarranty(boolean underWarranty) {
        isUnderWarranty = underWarranty;
    }

    public boolean isWithVideo() {
        return isWithVideo;
    }

    public void setWithVideo(boolean withVideo) {
        isWithVideo = withVideo;
    }
}
