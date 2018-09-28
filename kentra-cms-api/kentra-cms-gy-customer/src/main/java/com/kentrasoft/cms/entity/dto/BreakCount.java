package com.kentrasoft.cms.entity.dto;

import java.io.Serializable;

/**
 * 描述：违规信息统计
 *
 * @author zmk
 * @date 2018-8-7
 */
public class BreakCount implements Serializable {
    private String mon;
    private Integer totalCount;
    private Integer review;
    private Double reviewPercent;
    private Integer breaked;
    private Double breakedPercent;
    private Integer nobreak;
    private Double nobreakPercent;

    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getReview() {
        return review;
    }

    public void setReview(Integer review) {
        this.review = review;
    }

    public Double getReviewPercent() {
        return reviewPercent;
    }

    public void setReviewPercent(Double reviewPercent) {
        this.reviewPercent = reviewPercent;
    }

    public Integer getBreaked() {
        return breaked;
    }

    public void setBreaked(Integer breaked) {
        this.breaked = breaked;
    }

    public Double getBreakedPercent() {
        return breakedPercent;
    }

    public void setBreakedPercent(Double breakedPercent) {
        this.breakedPercent = breakedPercent;
    }

    public Integer getNobreak() {
        return nobreak;
    }

    public void setNobreak(Integer nobreak) {
        this.nobreak = nobreak;
    }

    public Double getNobreakPercent() {
        return nobreakPercent;
    }

    public void setNobreakPercent(Double nobreakPercent) {
        this.nobreakPercent = nobreakPercent;
    }
}
