package com.wander.notesapp.notesapplication.model;


import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * The Note Entity class
 *
 * @author Muthukumar PL
 * @version 1.0
 */
@Entity()
@Table(name = "note", schema = "notesappdb")
@EntityListeners(AuditingEntityListener.class)
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "content")
    private String content;

    @Column(name = "create_date")
    @CreatedDate
    private LocalDateTime createDate;
    
    @Column(name = "last_update_date")
    @LastModifiedDate
    private LocalDateTime lastUpdateDate;

    @Column(name = "status")
    private String status;

    @Column(name = "user_id")
    private int userId;


    public Note() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String taskName) {
        this.title = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime taskDate) {
        this.lastUpdateDate = taskDate;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note task = (Note) o;
        return id == task.id &&
                userId == task.userId &&
                Objects.equals(title, task.title) &&
                Objects.equals(description, task.description) &&
                Objects.equals(content, task.content) &&
                Objects.equals(lastUpdateDate, task.lastUpdateDate) &&
                Objects.equals(createDate, task.createDate) &&
                Objects.equals(status, task.status);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, description, content, lastUpdateDate, createDate, status, userId);
    }
}
