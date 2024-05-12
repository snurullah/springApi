package com.adresetiket.AdresEtiket.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="tblIdentity")
public class Identity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="IdentityId", updatable = false, nullable = false)
    private long IdentityId;
    private String Name;
    private String LastName;
}