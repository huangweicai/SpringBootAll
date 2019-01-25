package com.springboot.basic_configuration.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

@Entity
@Table(name = "holiday_scheme")
@EntityListeners(AuditingEntityListener.class)
public class HolidayEntity extends AbstractPersistable<Long> {
    @Column(name = "date")
    public String date;
    @Column(name = "hour")
    public String hour;
    @Column(name = "holiday")
    public String holiday;
    @Column(name = "holiday_explain")
    public String holiday_explain;
    @Column(name = "type")
    public String type;//SUB假期，ADD调休

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getHoliday() {
        return holiday;
    }

    public void setHoliday(String holiday) {
        this.holiday = holiday;
    }

    public String getHoliday_explain() {
        return holiday_explain;
    }

    public void setHoliday_explain(String holiday_explain) {
        this.holiday_explain = holiday_explain;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "HolidayEntity{" +
                "date='" + date + '\'' +
                ", hour='" + hour + '\'' +
                ", holiday='" + holiday + '\'' +
                ", holiday_explain='" + holiday_explain + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
