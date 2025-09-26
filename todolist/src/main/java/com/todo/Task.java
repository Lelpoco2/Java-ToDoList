package com.todo;

import java.time.LocalDateTime;

public class Task {
    
    private String title;
    private String description;
    private boolean completed;
    private LocalDateTime createdAt;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
        this.createdAt = LocalDateTime.now();
    }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public boolean isCompleted() {
            return completed;
        }

        public void setCompleted(boolean completed) {
            this.completed = completed;
        }

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
        }

        public String getStatus() {
            return completed ? "Completed" : "Pending";
        }

        @Override
        public String toString() {
            java.time.format.DateTimeFormatter fmt = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return String.format("Title: %s\nDescription: %s\nStatus: %s\nCreated at: %s",
                    title, description, getStatus(), createdAt.format(fmt));
        }
    }



