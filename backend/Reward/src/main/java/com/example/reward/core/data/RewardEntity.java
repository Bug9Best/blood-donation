package com.example.reward.core.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Data
@Table(name = "Reward")
public class RewardEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -6683927298050738119L;
    @Id
    @Column(unique = true)
    private String _id;
    private String image;
    private String name;
    private int point;
}
