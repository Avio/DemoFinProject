package net.example.demofinproject.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "Audit")
public class AuditEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "ip_address")
    private String ip_address;

    @Column(name = "endpoint")
    private String endpoint;

    @Column(name = "parameters")
    private String parameters;

    @CreationTimestamp
    @Column(name = "created_Timestamp")
    private Timestamp created_Timestamp;

    public int getId() {
        return id;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public Timestamp getCreatedTimestamp() {
        return created_Timestamp;
    }
}
