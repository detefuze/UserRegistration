package com.ru.klimash.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_auth")
public class UserAuth {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO.SEQUENCE)
    @Column
    private int id;

    @Column
    private int customer_id;

    @Column
    private int password_hash;

    @Column
    private LocalDateTime authorized_at;

    protected UserAuth() {
    }

    public UserAuth(int customer_id, int password_hash, LocalDateTime authorized_at) {
        this.customer_id = customer_id;
        this.password_hash = password_hash;
        this.authorized_at = authorized_at;
    }

    public int getId() {
        return id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(int password_hash) {
        this.password_hash = password_hash;
    }

    public LocalDateTime getAuthorized_at() {
        return authorized_at;
    }

    public void setAuthorized_at(LocalDateTime authorized_at) {
        this.authorized_at = authorized_at;
    }
}
