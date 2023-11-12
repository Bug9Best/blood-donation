package com.example.Bloodbank.core.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Data
@Table(name = "bloodbanks")
public class BloodbankEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 3734988974882169458L;
    @Id
    @Column(unique = true)
    private String _id;
    private String name;
    private String address;
    private String contact_phone;
    private String blood_group_a;
    private String blood_group_b;
    private String blood_group_o;
    private String blood_group_ab;
    private int blood_already_a;
    private int blood_already_b;
    private int blood_already_o;
    private int blood_already_ab;
    private int blood_required_a;
    private int blood_required_b;
    private int blood_required_o;
    private int blood_required_ab;
}
