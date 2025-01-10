package com.gym.models;

import jakarta.persistence.*;
import java.time.*;

@Entity
public class ClienteFrecuente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClienteFrecuente;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    private LocalDate fechaUltimoIngreso;
    private Integer cantidadIngresos;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    // Getters and setters

    public Long getIdClienteFrecuente() {
        return idClienteFrecuente;
    }

    public void setIdClienteFrecuente(Long idClienteFrecuente) {
        this.idClienteFrecuente = idClienteFrecuente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFechaUltimoIngreso() {
        return fechaUltimoIngreso;
    }

    public void setFechaUltimoIngreso(LocalDate fechaUltimoIngreso) {
        this.fechaUltimoIngreso = fechaUltimoIngreso;
    }

    public Integer getCantidadIngresos() {
        return cantidadIngresos;
    }

    public void setCantidadIngresos(Integer cantidadIngresos) {
        this.cantidadIngresos = cantidadIngresos;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}