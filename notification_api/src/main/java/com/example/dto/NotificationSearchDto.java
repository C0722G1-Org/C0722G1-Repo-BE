package com.example.dto;

public class NotificationSearchDto {
    private String startDate;
    private String tittle;
    private String content;

    public NotificationSearchDto() {
    }

    public NotificationSearchDto(String startDate, String tittle, String content) {
        this.startDate = startDate;
        this.tittle = tittle;
        this.content = content;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
