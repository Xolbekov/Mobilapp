package com.example.mobilaloqaapp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Simkarta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String kompaniya;
    public String tarifReja;
    public String telRaqam;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    Mijoz mijoz;

    public Simkarta(String kompaniya, String tarifReja, String telRaqam, Mijoz mijoz) {
      this.kompaniya=kompaniya;
      this.tarifReja=tarifReja;
      this.telRaqam=telRaqam;
      this.mijoz=mijoz;
    }
}
